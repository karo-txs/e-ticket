package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Evento;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import br.unicap.eticket.model.entretenimentos.Palestra;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locaisAuxiliares.TiposDeSala;
import br.unicap.eticket.model.usuarios.Cliente;
import java.util.Calendar;
import java.util.List;

public class FachadaLocais {

    private static FachadaLocais instance;

    EventoController evtC;
    EntretenimentoController entC;
    LocalController localC;
    ReservaController resvC;
    SalaController salaC;
    SessaoController sessaoC;

    private FachadaLocais() {
        this.sessaoC = new SessaoController();
        this.salaC = new SalaController();
        this.resvC = new ReservaController();
        this.localC = new LocalController();
        this.entC = new EntretenimentoController();
        this.evtC = new EventoController();
    }

    public static synchronized FachadaLocais getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new FachadaLocais();
            return instance;
        }
    }

    //---------------------------- CADASTROS ----------------------------//
    public void cadastrar(LocalGenerico local) throws DadosRepetidosException, DadosInvalidosException, CadastroInexistenteException {
        localC.cadastrar(local);
    }

    public void cadastrarSalaUnica(LocalGenerico local, Sala sala) throws CadastroInexistenteException {
        localC.cadastrarSalaUnica(local, sala);
    }

    public void cadastrar(Entretenimento ent) throws DadosInvalidosException {
        entC.cadastrar(ent);
    }

    public void cadastrar(Palestra palestra, Auditorio auditorio, String urlCapa) throws DadosInvalidosException {
        entC.cadastrar(palestra, auditorio, urlCapa);
    }

    public void cadastrarComCapa(Entretenimento ent, String urlCapa) throws DadosInvalidosException {
        entC.cadastrarComCapa(ent, urlCapa);
    }

    public void cadastrar(Evento evento) throws DadosRepetidosException, CadastroInexistenteException {
        evtC.cadastrar(evento);
    }

    public void cadastrar(Reserva reserva) throws DadosRepetidosException {
        resvC.cadastrar(reserva);
    }

    public void cadastrar(Sala sala) throws DadosRepetidosException, CadastroInexistenteException {
        salaC.cadastrar(sala);
    }

    public void cadastrar(LocalGenerico local, TiposDeSala tipo, String nome, int linhas, int colunas, double valorIngresso)
            throws DadosInvalidosException, DadosRepetidosException, CadastroInexistenteException {
        salaC.cadastrar(local, tipo, nome, linhas, colunas, valorIngresso);
    }

    public void cadastrar(Sessao sessao) throws DadosRepetidosException, CadastroInexistenteException {
        sessaoC.cadastrar(sessao);
    }

    public void cadastrar(LocalGenerico local, Sala sala, String nome, Calendar dataInicial, Entretenimento entreterimento) throws DadosRepetidosException, CadastroInexistenteException {
        sessaoC.cadastrar(local, sala, nome, dataInicial, entreterimento);
    }

//---------------------------- BUSCAS ----------------------------//
    public LocalGenerico buscarLocal(LocalGenerico local) throws CadastroInexistenteException {
        return localC.buscar(local);
    }

    public LocalGenerico buscarLocalPorId(Long id) throws CadastroInexistenteException {
        return localC.buscarPorId(id);
    }

    public List<LocalGenerico> todosLocais(Class c) {
        return localC.todosLocais(c);
    }

    public Entretenimento buscar(Entretenimento entreterimento) throws CadastroInexistenteException {
        return entC.buscar(entreterimento);
    }

    public Entretenimento buscarEnt(String nome) throws CadastroInexistenteException {
        return entC.buscar(nome);
    }

    public String[] todosEntretenimentosDoLocal(LocalGenerico local) {
        return entC.todosEntretenimentosDoLocal(local);
    }

    public List<Entretenimento> entreterimentosEmCartaz(LocalGenerico local) {
        return entC.entreterimentosEmCartaz(local);
    }

    public Evento buscar(Evento evento) throws CadastroInexistenteException {
        return evtC.buscar(evento);
    }

    public Reserva buscar(Reserva reserva) throws CadastroInexistenteException {
        return resvC.buscar(reserva);
    }

    public Reserva buscaPorId(Long id) {
        return resvC.buscaPorId(id);
    }

    public Sala buscar(Sala sala) throws CadastroInexistenteException {
        return salaC.buscar(sala);
    }

    public Sala buscarSala(String nome) throws CadastroInexistenteException {
        return salaC.buscar(nome);
    }

    public String[] salasDoLocal(LocalGenerico local, boolean dadosCompletos) {
        return salaC.salasDoLocal(local, dadosCompletos);
    }

    public Sessao buscar(Sessao sessao) throws CadastroInexistenteException {
        return sessaoC.buscar(sessao);
    }

    public Sessao buscarSessao(String nome) throws CadastroInexistenteException {
        return sessaoC.buscar(nome);
    }

    public List<Sessao> buscarSessao(LocalGenerico local) throws CadastroInexistenteException {
        return sessaoC.buscar(local);
    }

    public Sessao buscarSessaoPorId(Long id) {
        return sessaoC.buscarPorId(id);
    }

    public List<Sessao> sessoesPorEntELocal(Entretenimento ent, LocalGenerico local) throws CadastroInexistenteException {
        return sessaoC.sessoesPorEntELocal(ent, local);
    }

    public List<Sessao> sessoesPorEntEData(Entretenimento ent, LocalGenerico local, Calendar dataInicial) throws CadastroInexistenteException {
        return sessaoC.sessoesPorEntEData(ent, local, dataInicial);
    }

    public List<Sessao> sessoesPassadas(Calendar data) {
        return sessaoC.sessoesPassadas(data);
    }

    public List<Sessao> sessoesDaSala(Sala sala) throws CadastroInexistenteException {
        return sessaoC.sessoesDaSala(sala);
    }

    //---------------------------- ATUALIZAÇÃO ----------------------------//
    public void atualizar(LocalGenerico novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        localC.atualizar(novo);
    }

    public void atualizarChave(LocalGenerico local, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        localC.atualizarChave(local, chave);
    }

    public void modificarCapa(Entretenimento ent, String urlCapa) throws CadastroInexistenteException {
        entC.modificarCapa(ent, urlCapa);
    }

    public void atualizar(Evento novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        evtC.atualizar(novo);
    }

    public void atualizar(Reserva reserva) throws CadastroInexistenteException {
        resvC.atualizar(reserva);
    }

    public void atualizar(Sala nova) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        salaC.atualizar(nova);
    }

    public void atualizarChave(Sala sala, Object chave) throws CadastroInexistenteException {
        salaC.atualizarChave(sala, chave);
    }

    public void atualizar(Sessao nova) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        sessaoC.atualizar(nova);
    }

    public void atualizarChave(Sessao sessao, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        sessaoC.atualizarChave(sessao, chave);
    }

    //---------------------------- REMOÇÕES ----------------------------//
    public void remover(LocalGenerico local) throws CadastroInexistenteException {
        localC.remover(local);
    }

    public void removerSalas(LocalGenerico local) throws CadastroInexistenteException {
        localC.removerSalas(local);
    }

    public void remover(Entretenimento ent) throws CadastroInexistenteException {
        entC.remover(ent);
    }

    public void remover(Evento evento) throws CadastroInexistenteException {
        evtC.remover(evento);
    }

    public void remover(Reserva reserva) throws CadastroInexistenteException {
        resvC.remover(reserva);
    }

    public void remover(Sala sala) throws CadastroInexistenteException {
        salaC.remover(sala);
    }

    public void desativarSala(Sala sala) throws CadastroInexistenteException {
        salaC.desativar(sala);
    }

    public void remover(Sessao sessao) throws CadastroInexistenteException {
        sessaoC.remover(sessao);
    }

    public void desativarSessao(Sessao sessao) throws CadastroInexistenteException {
        sessaoC.desativar(sessao);
    }

    //---------------------------- OUTROS ----------------------------//
    public void inserirBanner(LocalGenerico local, String caminho) {
        localC.inserirBanner(local, caminho);
    }

    public void inserirCapa(LocalGenerico local, String caminho) {
        localC.inserirCapa(local, caminho);
    }

    public double[] mostrarIngresso(Cliente cliente, Reserva reserva) {
        return resvC.mostrarIngresso(cliente, reserva);
    }
}
