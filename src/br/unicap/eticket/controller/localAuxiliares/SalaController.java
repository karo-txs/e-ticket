package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Teatro;
import br.unicap.eticket.model.locaisAuxiliares.TiposDeSala;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SalaController implements BaseControl<Sala> {

    private SalaDAO dao;

    public SalaController() {
        this.dao = new SalaDAO();
    }

    /**
     * Cadastro de uma Sala
     *
     * @param sala
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    @Override
    public void cadastrar(Sala sala) throws DadosRepetidosException, CadastroInexistenteException {
        ExecutorService es = Executors.newCachedThreadPool();
        LocalController localC = new LocalController();
        LocalGenerico local;
        Sala buscaSala;
        String nomeSala;

        try {
            local = es.submit(() -> sala.getLocal().getId() == null ? localC.buscar(sala.getLocal()) : sala.getLocal()).get();
            nomeSala = local.getId() + "-" + sala.getNome();
            buscaSala = es.submit(() -> dao.buscarSala(nomeSala)).get();
            if (buscaSala == null) {
                Sala s = new Sala(sala.getLocal(), sala.getTipoSala(), nomeSala, sala.getFileirasX(), sala.getFileirasY(),
                        sala.getValorIngresso());
                dao.incluirAtomico(s);
                if (local instanceof Teatro || local instanceof Auditorio) {
                    localC.cadastrarSalaUnica(local, s);
                }
            } else {
                throw new DadosRepetidosException("Sala");
            }

        } catch (InterruptedException | ExecutionException ex) {
        }
    }

    /**
     * Cadastra uma Sala, porém faz as validações básicas antes
     *
     * @param local
     * @param tipo
     * @param nome
     * @param linhas
     * @param colunas
     * @param valorIngresso
     * @throws DadosInvalidosException
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    public void cadastrar(LocalGenerico local, TiposDeSala tipo, String nome, int linhas, int colunas, double valorIngresso)
            throws DadosInvalidosException, DadosRepetidosException, CadastroInexistenteException {
        LocalController localC = new LocalController();
        LocalGenerico buscaLocal = local.getId() == null ? localC.buscar(local) : local;

        if (!ValidaDados.validaNomeSemCaracteresEspeciais(nome)) {
            throw new DadosInvalidosException("Nome da Sala");
        }
        if (!ValidaDados.validaQuantidade(String.valueOf(linhas))) {
            throw new DadosInvalidosException("Fileiras X");
        }
        if (!ValidaDados.validaQuantidade(String.valueOf(colunas))) {
            throw new DadosInvalidosException("Fileiras Y");
        }
        if (!ValidaDados.validaValor(String.valueOf(valorIngresso))) {
            throw new DadosInvalidosException("Valor Ingresso");
        }
        Sala sala = new Sala(buscaLocal, tipo, nome, linhas, colunas, valorIngresso);
        this.cadastrar(sala);
    }

    /**
     * Busca uma Sala, validando seu nome antes
     *
     * @param sala
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Sala buscar(Sala sala) throws CadastroInexistenteException {
        LocalDAO localD = new LocalDAO();

        return !sala.getNome().contains("-") ? this.buscar(localD.buscarLocal(sala.getLocal()).getId() + "-" + sala.getNome())
                : this.buscar(sala.getNome());
    }

    /**
     * Busca uma Sala pedindo seu nome
     *
     * @param nome
     * @return
     * @throws CadastroInexistenteException
     */
    public Sala buscar(String nome) throws CadastroInexistenteException {
        Sala busca = dao.buscarSala(nome);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Sala");
        }
    }

    /**
     * Retorna os dados das salas de um determinado local
     *
     * @param local
     * @param dadosCompletos
     * @return String[]
     */
    public String[] salasDoLocal(LocalGenerico local, boolean dadosCompletos) {
        List<Sala> s = local.getSalas();
        String[] salas = new String[s.size()];
        int i = 0;
        for (Sala a : s) {
            if (a.isAtiva()) {
                if (dadosCompletos) {
                    salas[i] = a.toString();
                } else {
                    salas[i] = a.getNome();
                }
            }
            i++;
        }
        return salas;
    }

    /**
     * Atualiza os dados de uma Sala
     *
     * @param nova
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     */
    @Override
    public void atualizar(Sala nova) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {

        Sala busca = this.buscar(nova);

        boolean assentosMudaram = false;

        if (ValidaDados.validaQuantidade(String.valueOf(nova.getFileirasX()))) {
            busca.setFileirasX(nova.getFileirasX());
            assentosMudaram = true;
        }
        if (ValidaDados.validaQuantidade(String.valueOf(nova.getFileirasY()))) {
            busca.setFileirasY(nova.getFileirasY());
            assentosMudaram = true;
        }
        if (assentosMudaram) {
            busca.setCapacidade(busca.getFileirasX() * busca.getFileirasY());
            busca.initAssentos(busca.getFileirasX(), busca.getFileirasY(), busca.getCapacidade());

        }

        if (!busca.getTipoSala().equals(nova.getTipoSala())) {
            busca.setTipoSala(nova.getTipoSala());
        }

        if (ValidaDados.validaValor(String.valueOf(nova.getFileirasX()))) {
            busca.setValorIngresso(nova.getValorIngresso());
        }

        dao.atualizarAtomico(busca);
    }

    /**
     * Atualiza a chave de identificação secundária (sendo a primaria o ID, que
     * é identificado diretamente pelo BD)
     *
     * @param sala
     * @param chave
     * @throws CadastroInexistenteException
     */
    public void atualizarChave(Sala sala, Object chave) throws CadastroInexistenteException {
        String nomeNovo = (String) chave;
        if (ValidaDados.validaNome(nomeNovo)) {
            if (!nomeNovo.equalsIgnoreCase(sala.getNome())) {
                sala.alterarNome(nomeNovo);
            }
        }
    }

    /**
     * Remove uma Sala. Caso existam Sessoes vinculadas a ela as sessões são
     * removidas também
     *
     * @param sala
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Sala sala) throws CadastroInexistenteException {
        SessaoDAO sessaoD = new SessaoDAO();
        SessaoController sessaoC = new SessaoController();
        dao.abrirTransacao();
        Sala busca = sala.getId() == null ? this.buscar(sala) : sala;

        List<Sessao> sessoes = sessaoD.consultar("sessoesDaSala", "sala", busca);

        if (!sessoes.isEmpty()) {
            sessoes.forEach((s) -> {
                sessaoC.remover(s);
            });
        }

        dao.removerDetached(busca);
        dao.fecharTransacao();
    }

    public void desativar(Sala sala) throws CadastroInexistenteException {
        Sala busca = sala.getId() == null ? this.buscar(sala) : sala;
        busca.desativarSala();
    }
}
