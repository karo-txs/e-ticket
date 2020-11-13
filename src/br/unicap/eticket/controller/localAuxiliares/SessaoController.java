package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.interfaces.Formatador;
import br.unicap.eticket.controller.locais.LocalController;
import br.unicap.eticket.dao.EntretenimentoDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Entretenimento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessaoController implements BaseControl<Sessao>, Formatador<Sessao> {

    private SessaoDAO dao;

    public SessaoController() {
        this.dao = new SessaoDAO();
    }

    /**
     * Cadastra uma sessão
     *
     * @param sessao
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    @Override
    public void cadastrar(Sessao sessao) throws DadosRepetidosException, CadastroInexistenteException {
        LocalController localC = new LocalController();
        LocalGenerico buscaLocal = sessao.getLocal().getId() == null ? localC.buscar(sessao.getLocal()) : sessao.getLocal();

        String nomeSessao = buscaLocal.getId() + "-" + sessao.getSala().getNome() + ":" + sessao.getNome();
        if (dao.buscarSessao(nomeSessao) == null && dao.buscarSessao(sessao.getSala(),
                sessao.getDataInicial(), sessao.getDataFinal()) == null) {
            sessao.setNome(nomeSessao);
            dao.incluirAtomico(sessao);
        } else {
            throw new DadosRepetidosException("Sessão");
        }
    }

    /**
     * Cadastro de uma Sessao Com verificações
     *
     * @param local
     * @param sala
     * @param nome
     * @param dataInicial
     * @param entreterimento
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    public void cadastrar(LocalGenerico local, Sala sala, String nome, Calendar dataInicial, Entretenimento entreterimento) throws DadosRepetidosException, CadastroInexistenteException {
        LocalController localC = new LocalController();
        SalaController salaC = new SalaController();
        EntretenimentoController entC = new EntretenimentoController();
        //Lançam cadastro inexistente caso o resutado da busca seja null
        LocalGenerico buscaLocal = local.getId() == null ? localC.buscar(local) : local;
        Sala buscaSala = sala.getId() != null ? sala : salaC.buscar(sala);
        Entretenimento buscaEnt = entreterimento.getId() == null ? entC.buscar(entreterimento) : entreterimento;

        this.cadastrar(new Sessao(buscaLocal, buscaSala, nome, dataInicial, buscaEnt));
    }

    /**
     * Busca uma Sessao, verificando seu nome OBS: Nome da sessão é criado em
     * seu cadastro, logo seu nome é único
     *
     * @param sessao
     * @return buscar(String)
     * @throws CadastroInexistenteException
     */
    @Override
    public Sessao buscar(Sessao sessao) throws CadastroInexistenteException {
        SalaController sc = new SalaController();
        LocalController lc = new LocalController();
        if (sessao.getNome().contains(":")) {
            return this.buscar(sessao.getNome());
        } else {
            return this.buscar(lc.buscar(sessao.getLocal()).getId() + "-" + sc.buscar(sessao.getSala()).getNome() + ":" + sessao.getNome());
        }
    }

    /**
     * Busca uma Sessao pelo nome
     *
     * @param nome
     * @return
     * @throws CadastroInexistenteException
     */
    public Sessao buscar(String nome) throws CadastroInexistenteException {
        Sessao busca = dao.buscarSessao(nome);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Sessão");
        }
    }

    /**
     * Busca as sessoes de um local
     *
     * @param local
     * @return List
     * @throws CadastroInexistenteException
     */
    public List<Sessao> buscar(LocalGenerico local) throws CadastroInexistenteException {
        LocalDAO localD = new LocalDAO();
        LocalGenerico busca = local.getId() == null ? localD.buscarLocal(local) : local;
        List<Sessao> sessoes = dao.consultar("sessoesDoLocal", "id", busca);
        if (!sessoes.isEmpty()) {
            return sessoes;
        } else {
            throw new CadastroInexistenteException("Sessao");
        }
    }

    /**
     * Busca uma sessao por id
     *
     * @param id
     * @return
     */
    public Sessao buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    /**
     * Retorna as Sessões existentes por entreterimento e Local, sendo as mesmas
     * ativas
     *
     * @param ent
     * @param local
     * @return
     * @throws CadastroInexistenteException
     */
    public List<Sessao> sessoesPorEntELocal(Entretenimento ent, LocalGenerico local) throws CadastroInexistenteException {
        EntretenimentoDAO entD = new EntretenimentoDAO();
        LocalDAO localD = new LocalDAO();

        LocalGenerico busca = local.getId() == null ? localD.buscarLocal(local) : local;
        Entretenimento buscaEnt = ent.getId() == null ? entD.buscarEntreterimento(ent.getNome()) : ent;

        SessaoDAO sessaoD = new SessaoDAO();

        List<Sessao> sessoes = sessaoD.consultar("sessoesPorEntreterimentoELocal", "entreterimento", buscaEnt, "id", busca.getId());
        if (!sessoes.isEmpty()) {
            List<Sessao> ativas = new ArrayList<>();
            for (Sessao s : sessoes) {
                if (s.isAtiva()) {
                    ativas.add(s);
                }
            }
            return ativas;
        } else {
            throw new CadastroInexistenteException("Sessao");
        }
    }

    /**
     * Sessoes de um local por entretenimento e data, sendo elas ativas
     *
     * @param ent
     * @param local
     * @param dataInicial
     * @return
     * @throws CadastroInexistenteException
     */
    public List<Sessao> sessoesPorEntEData(Entretenimento ent, LocalGenerico local, Calendar dataInicial) throws CadastroInexistenteException {

        Calendar dataFinal = (Calendar) dataInicial.clone();
        dataFinal.set(Calendar.HOUR_OF_DAY, 23);
        dataFinal.set(Calendar.MINUTE, 59);
        dataFinal.set(Calendar.SECOND, 59);

        List<Sessao> sessoes = dao.sessoesPorData(local, dataInicial, dataFinal);
        List<Sessao> result = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s.getEntretenimento().getNome().equalsIgnoreCase(ent.getNome()) && s.isAtiva()) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Retorna a lista de sessões que ocorreram antes da data informada
     *
     * @param data
     * @return List
     */
    public List<Sessao> sessoesPassadas(Calendar data) {
        return dao.sessoesPassadas(data);
    }

    /**
     * Retorna a lista de sessões de uma sala
     *
     * @param sala
     * @return List
     * @throws CadastroInexistenteException
     */
    public List<Sessao> sessoesDaSala(Sala sala) throws CadastroInexistenteException {
        SalaController salaC = new SalaController();
        Sala buscaSala = sala.getId() == null ? salaC.buscar(sala) : sala;

        List<Sessao> sessoes = dao.consultar("sessoesDaSala", "sala", buscaSala);
        return sessoes;
    }

    /**
     * Atualiza os dados de uma sessão Sua chave (nome) deve permanescer o mesmo
     * nesta atualização. Para atualizar a sua chave é necessario utilizar o
     * outro metodo de atualização presente em Sessao(atualizarNome)
     *
     * @param nova
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     */
    @Override
    public void atualizar(Sessao nova) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        SalaController salaC = new SalaController();
        EntretenimentoController entC = new EntretenimentoController();

        Sessao busca = this.buscar(nova);

        Sala salaAntiga = busca.getSala();
        try {
            Sala novaSala = salaC.buscar(nova.getSala());
            if (!busca.getSala().equals(novaSala)) {
                busca.setSala(salaAntiga);
            }
        } catch (CadastroInexistenteException ex) {
            throw new AtualizacaoMalSucedidaException("Sala");
        }

        Entretenimento entAntigo = busca.getEntretenimento();
        if (!entAntigo.equals(nova.getEntretenimento())) {
            try {
                Entretenimento entNovo = entC.buscar(nova.getEntretenimento());
                busca.setEntretenimento(entNovo);
            } catch (CadastroInexistenteException ex) {
                throw new AtualizacaoMalSucedidaException("Entreterimento");
            }
        }
        //verificar
        if (!busca.getDataInicial().equals(nova.getDataInicial())) {
            Sessao buscaSessaoPorData = dao.buscarSessao(salaAntiga, nova.getDataInicial(), nova.getDataFinal());
            if (buscaSessaoPorData == null) {
                busca.setDataInicial(nova.getDataInicial());
                busca.setDataFinal(nova.getDataFinal());
            } else {
                throw new AtualizacaoMalSucedidaException("Data");
            }
        }
        dao.atualizarAtomico(busca);
    }

    /**
     * Atualiza a chave de identificação secundária (sendo a primaria o ID, que
     * é identificado diretamente pelo BD)
     *
     * @param sessao
     * @param chave
     * @throws CadastroInexistenteException
     * @throws AtualizacaoMalSucedidaException
     */
    public void atualizarChave(Sessao sessao, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        Sessao busca = sessao.getId() == null ? this.buscar(sessao) : sessao;
        busca.atualizarNome((String) chave);
    }

    /**
     * Remove uma Sessão e as Reservas relacionadas a mesma. Porém, o histórico
     * de reservas de um cliente continua a existir
     *
     * @param sessao
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Sessao sessao) throws CadastroInexistenteException {
        ReservaDAO reservaD = new ReservaDAO();
        dao.abrirTransacao();
        Sessao busca = sessao.getId() == null ? this.buscar(sessao) : sessao;
        List<Reserva> reservas = reservaD.consultar("reservasDaSessao", "sessao", busca);

        if (!reservas.isEmpty()) {
            for (Reserva r : reservas) {
                reservaD.removerAtomico(r);
            }
        }

        dao.removerDetached(busca);
        dao.fecharTransacao();
    }

    /**
     * Transforma uma lista de sessoes em um vetor String com seus respectivos dados
     * @param sessoes
     * @return String[]
     */
    @Override
    public String[] formataDados(List<Sessao> sessoes) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String[] dadosFormatados = null;
        dadosFormatados = new String[sessoes.size()];

        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                dadosFormatados[i] = s.getSala().getTipoSala().toString() + " | " + s.getSala().getNome() + " | "
                        + df.format(s.getDataInicial().getTime());
            }
            i++;
        }
        return dadosFormatados;
    }

    /**
     * Transforma uma lista de sessoes em um vetor String com seus respectivos dados abreviados
     * @param sessoes
     * @return String[]
     */
    public String[] formataDadosAbreviados(List<Sessao> sessoes) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String[] dadosFormatados = null;
        dadosFormatados = new String[sessoes.size()];

        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                dadosFormatados[i] = s.getSala().getTipoSala().toString() + " | " + s.getSala().getNome() + " | "
                        + df.format(s.getDataInicial().getTime());
            }
            i++;
        }
        return dadosFormatados;
    }

    /**
     * Retorna a lista de IDs de uma lista de sessoes
     * @param sessoes
     * @return Long[]
     */
    @Override
    public Long[] listarIDs(List<Sessao> sessoes) {
        Long[] idSessoes = new Long[sessoes.size()];
        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                idSessoes[i] = s.getId();
            }
            i++;
        }
        return idSessoes;
    }
    
     public Sessao[] converterListEmArray(List<Sessao> sessoes){
        Sessao[] dados = new Sessao[sessoes.size()];
         int i = 0;
        for (Sessao s : sessoes) {
            dados[i] = s;
            i++;
        }
        return dados;
    }
}
