package br.unicap.eticket.control.auxiliares;

import br.unicap.eticket.control.interfaces.BaseControl;
import br.unicap.eticket.control.interfaces.BuscasEntreterimento;
import br.unicap.eticket.dao.EntreterimentoDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class EntretenimentoControl implements BaseControl<Entretenimento>, BuscasEntreterimento {

    private EntreterimentoDAO dao = new EntreterimentoDAO();

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

    /**
     * Cadastrar um Entretenimento com Capa
     *
     * @param ent
     * @param urlCapa
     * @throws DadosInvalidosException
     */
    public void cadastrar(Entretenimento ent, String urlCapa) throws DadosInvalidosException {
        File file = new File(urlCapa);
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ent.setCapa(bFile);
        this.cadastrar(ent);
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
     * @return List
     */
    public List<Entretenimento> todosFilmes() {
        EntreterimentoDAO ed = new EntreterimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("todosFilmes");
        return entreterimentos;
    }
    
    /**
     * Retorna a lista com todas os pecas cadastradas
     * @return List
     */
    public List<Entretenimento> todasPecas() {
        EntreterimentoDAO ed = new EntreterimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("todasPecas");
        return entreterimentos;
    }

    /**
     * Retorna todos os entreterimentos com sessão ativa
     * @return List
     */
    @Override
    public List<Entretenimento> entreterimentosEmCartaz() {
        EntreterimentoDAO ed = new EntreterimentoDAO();
        List<Entretenimento> entreterimentos = ed.consultar("entreterimentosEmCartaz");
        return entreterimentos;
    }

    /**
     * Retorna todos entreterimentos com sessão ativa por Local
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
