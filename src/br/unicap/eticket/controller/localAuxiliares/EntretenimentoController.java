package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.interfaces.BuscasEntreterimento;
import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.controller.locais.LocalController;
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
import java.util.function.Function;
import br.unicap.eticket.controller.interfaces.FunctionSimple;

public class EntretenimentoController implements BaseControl<Entretenimento>, BuscasEntreterimento {

    private EntretenimentoDAO dao;

    public EntretenimentoController() {
        this.dao = new EntretenimentoDAO();
    }

    /**
     * Cadastro de um Entretenimento com Verificação
     *
     * @param ent
     * @throws br.unicap.eticket.excecoes.DadosInvalidosException
     */
    @Override
    public void cadastrar(Entretenimento ent) throws DadosInvalidosException {

        if (!ValidaDados.validaNumero(ent.getDuracao() + "")) {
            throw new DadosInvalidosException("Nome do Local");
        }

        if (dao.buscarEntreterimento(ent.getNome()) == null) {
            dao.incluirAtomico(ent);
        }
    }

    /**
     * Cadastra uma palestra e a vincula a seu respectivo auditorio
     *
     * @param palestra
     * @param auditorio
     * @param urlCapa
     * @throws DadosInvalidosException
     */
    public void cadastrar(Palestra palestra, Auditorio auditorio, String urlCapa) throws DadosInvalidosException {
        LocalController localC = new LocalController();
        Auditorio buscaA = auditorio.getId() == null ? (Auditorio) localC.buscar(auditorio) : auditorio;
        palestra.setAuditorio(buscaA);

        if (urlCapa != null) {
            this.cadastrarComCapa(palestra, urlCapa);
        } else {
            this.cadastrar(palestra);
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
        ent.setCapa(Conversor.converterImagemEmByte(urlCapa));
        this.cadastrar(ent);
    }

    /**
     * Modifica a capa de um entretenimento
     *
     * @param ent
     * @param urlCapa
     * @throws CadastroInexistenteException
     */
    public void modificarCapa(Entretenimento ent, String urlCapa) throws CadastroInexistenteException {
        ent.inserirCapaESalvar(urlCapa);
    }

    /**
     * Buscar um entreterimento
     *
     * @param entreterimento
     * @return Entretenimento
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
     * Retorna a lista de nomes de entretenimentos por tipo de local
     *
     * @param local
     * @return
     */
    public String[] todosEntretenimentosDoLocal(LocalGenerico local) {
        EntretenimentoDAO ed = new EntretenimentoDAO();
        String[] entsVector;
        List<Entretenimento> ents;

        if (local instanceof Cinema) {
            FunctionSimple<List<Entretenimento>> function = () -> {
                return ed.consultar("todosFilmes");
            };
            ents = function.apply();
        } else if (local instanceof Teatro) {
            FunctionSimple<List<Entretenimento>> function = () -> {
                return ed.consultar("todasPecas");
            };
            ents = function.apply();
        } else {
            Function<LocalGenerico, List<Entretenimento>> function = (LocalGenerico l) -> {
                return ed.consultar("todasPalestras", "local", l);
            };
            ents = function.apply(local);
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

        List<Entretenimento> ents = dao.consultar("entreterimentoPorLocal", "local", busca, "ativa", true);
        return ents;
    }

    @Override
    public List<Entretenimento> entreterimentosNotaMaiorQue(double nota) {
        List<Entretenimento> ents = dao.consultar("filmesNotaMaiorQue", "nota", nota);
        return ents;
    }

    @Override
    public void atualizar(Entretenimento obj) throws CadastroInexistenteException {
    }

    /**
     * Remoção de um entretenimento
     *
     * @param ent
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Entretenimento ent) throws CadastroInexistenteException {
        if (dao.buscarEntreterimento(ent.getNome()) != null) {
            dao.removerAtomico(ent);
        }
    }
}
