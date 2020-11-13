package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.interfaces.BuscasEntreterimento;
import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.dao.EntretenimentoDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.entretenimentos.Palestra;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.Teatro;
import java.util.List;

public class EntretenimentoController implements BaseControl<Entretenimento>, BuscasEntreterimento {
    
    private EntretenimentoDAO dao;

     public EntretenimentoController(){
        this.dao = new EntretenimentoDAO();
    }
     
    /**
     * Cadastro de um Entretenimento com Varificação
     *
     * @param ent
     * @throws br.unicap.eticket.excecoes.DadosInvalidosException
     */
    @Override
    public void cadastrar(Entretenimento ent) throws DadosInvalidosException {
        //falta validações
        if (dao.buscarEntreterimento(ent.getNome()) == null) {
            dao.incluirAtomico(ent);
        }
    }
    
    public void cadastrar(Palestra ent, Auditorio a, String urlCapa) throws DadosInvalidosException {
        //falta validações
        ent.setAuditorio(a);
        if (urlCapa != null) {
            this.cadastrarComCapa(ent, urlCapa);
        } else {
            this.cadastrar(ent);
        }
    }

    /**
     * Cadastrar um Entretenimento com Capa
     *
     * @param ent
     * @param urlCapa
     * @throws DadosInvalidosException
     */
    public void cadastrarComCapa(Entretenimento ent, String urlCapa) throws DadosInvalidosException {
        if (urlCapa != null) {
            ent.setCapa(Conversor.converterImagemEmByte(urlCapa));
        }
        this.cadastrar(ent);
    }
    
    public void setImagem(Entretenimento ent, String urlCapa) throws CadastroInexistenteException{
        ent.inserirCapaESalvar(urlCapa);
    }

    /**
     * Buscar um entreterimento
     *
     * @param entreterimento
     * @return
     * @throws br.unicap.eticket.excecoes.CadastroInexistenteException
     */
    @Override
    public Entretenimento buscar(Entretenimento entreterimento) throws CadastroInexistenteException {
        Entretenimento busca = dao.buscarEntreterimento(entreterimento.getNome());
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Entreterimento");
        }
    }

    /**
     * Busca um entretenimento por nome
     *
     * @param nome
     * @return
     * @throws CadastroInexistenteException
     */
    public Entretenimento buscar(String nome) throws CadastroInexistenteException {
        Entretenimento busca = dao.buscarEntreterimento(nome);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Entreterimento");
        }
    }

    /**
     * Retorna a lista com todos os filmes cadastrados
     *
     * @return List
     */
    private List<Entretenimento> todosFilmes() {
        EntretenimentoDAO ed = new EntretenimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("todosFilmes");
        return entreterimentos;
    }

    /**
     * Retorna a lista com todas os pecas cadastradas
     *
     * @return List
     */
    private List<Entretenimento> todasPecas() {
        EntretenimentoDAO ed = new EntretenimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("todasPecas");
        return entreterimentos;
    }

    /**
     * Retorna a lista com todas os palestras cadastradas
     *
     * @return
     */
    private List<Entretenimento> todasPalestras(LocalGenerico local) {
        EntretenimentoDAO ed = new EntretenimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("todasPalestras","local",local);
        return entreterimentos;
    }

    /**
     * retorna a lista de nomes de entretenimentos por tipo de local
     *
     * @param local
     * @return
     */
    public String[] todosEntretenimentosDoLocal(LocalGenerico local) {
        String[] entsVector;
        List<Entretenimento> ents;
        
        if (local instanceof Cinema) {
            ents = this.todosFilmes();
        } else if (local instanceof Teatro) {
            ents = this.todasPecas();
        } else {
            ents = this.todasPalestras(local);
        }
        
        int tam = ents.size();
        entsVector = new String[tam];
        for (int i = 0; i < tam; i++) {
            entsVector[i] = ents.get(i).getNome();
        }
        return entsVector;
    }

    /**
     * Retorna todos os entreterimentos com sessão ativa
     *
     * @return List
     */
    @Override
    public List<Entretenimento> entreterimentosEmCartaz() {
        EntretenimentoDAO ed = new EntretenimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("entreterimentosEmCartaz");
        return entreterimentos;
    }

    /**
     * Retorna todos entreterimentos com sessão ativa por Local
     *
     * @param local
     * @return List
     */
    @Override
    public List<Entretenimento> entreterimentosEmCartaz(LocalGenerico local) {
        LocalDAO localD = new LocalDAO();
        LocalGenerico busca = local.getId() == null ? localD.buscarLocal(local) : local;
        
        List<Entretenimento> ents = dao.consultar("entreterimentoPorLocal", "local", busca);
        return ents;
    }
    
    @Override
    public List<Entretenimento> entreterimentosNotaMaiorQue(double nota) {
        List<Entretenimento> ents = dao.consultar("filmesNotaMaiorQue", "nota", nota);
        return ents;
    }

    //ATUALIZAÇÃO
    @Override
    public void atualizar(Entretenimento obj) throws CadastroInexistenteException {
    }

    //REMOÇÃO
    @Override
    public void remover(Entretenimento obj) throws CadastroInexistenteException {
    }
}
