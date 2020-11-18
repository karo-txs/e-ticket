package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.interfaces.Formatador;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.ClienteEspecial;
import java.util.List;

public class ReservaController implements BaseControl<Reserva>, Formatador<Reserva> {

    private ReservaDAO dao;

    public ReservaController() {
        this.dao = new ReservaDAO();
    }

    /**
     * Cadastro de uma Reserva
     *
     * @param reserva
     * @throws DadosRepetidosException
     */
    @Override
    public void cadastrar(Reserva reserva) throws DadosRepetidosException {
        SessaoController sessaoC = new SessaoController();
        Sessao busca = reserva.getSessao().getId() == null ? sessaoC.buscar(reserva.getSessao()) : reserva.getSessao();
        reserva.setSessao(busca);

        if (dao.buscarReserva(reserva) == null) {
            dao.incluirAtomico(reserva);
        } else {
            throw new DadosRepetidosException("Reserva");
        }
    }

    /**
     * Busca de uma Reserva
     *
     * @param reserva
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Reserva buscar(Reserva reserva) throws CadastroInexistenteException {
        SessaoController sessaoC = new SessaoController();
        Sessao buscaS = reserva.getId() == null ? sessaoC.buscar(reserva.getSessao()) : reserva.getSessao();
        Reserva busca = dao.buscarReserva(new Reserva(buscaS, reserva.getAssento()));

        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Reserva");
        }
    }

    /**
     * Busca por id de uma Reserva
     *
     * @param id
     * @return
     */
    public Reserva buscaPorId(Long id) {
        return dao.buscarPorId(id);
    }

    /**
     * Atualização de uma Reserva
     *
     * @param reserva
     * @throws CadastroInexistenteException
     */
    @Override
    public void atualizar(Reserva reserva) throws CadastroInexistenteException {
        Reserva busca = this.buscar(reserva);
        busca.setAssento(reserva.getAssento());
        busca.setSessao(reserva.getSessao());
        dao.atualizarAtomico(busca);
    }

    /**
     * Remoção de uma Reserva
     *
     * @param reserva
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Reserva reserva) throws CadastroInexistenteException {
        Reserva busca = reserva.getId() == null ? this.buscar(reserva) : reserva;
        dao.abrirTransacao();
        dao.removerDetached(busca);
        dao.fecharTransacao();
    }

    /**
     * Coloca os valores do ingresso em um vetor double
     * 
     * @param cliente
     * @param reserva
     * @return
     */
    public double[] mostrarIngresso(Cliente cliente, Reserva reserva) {
        double[] ingresso = new double[3];
        ingresso[1] = reserva.getValorIngresso();

        Sessao sessao = reserva.getSessao();
        if (cliente.isEspecial()) {
            ClienteEspecial clienteE = (ClienteEspecial) cliente;
            if (clienteE.getDesconto(sessao.getLocal()) != 0) {
                ingresso[1] = clienteE.getDesconto(sessao.getLocal());
                if (!sessao.isEventoAtivado()) {
                    ingresso[0] = sessao.getSala().getValorIngresso() - (reserva.getValorIngresso()
                            * clienteE.getDesconto(sessao.getLocal()));
                }
            }
        } else {
            ingresso[0] = reserva.getValorIngresso();
            ingresso[2] = 0;
        }
        return ingresso;
    }

    /**
     * Transforma a lista de reservas em um vetor String com informações adicionais
     * @param reservas
     * @return
     */
    @Override
    public String[] formataDados(List<Reserva> reservas) {
        String dados[];
        dados = new String[reservas.size()];
        int i = 0;
        if (reservas != null) {
            for (Reserva r : reservas) {
                if (!r.getSessao().isAtiva() && r.isAvaliacaoDisp()) {
                    dados[i] = r.toString() + " - Avaliação Disponível!";
                } else {
                    dados[i] = r.toString();
                }
                i++;
            }
        }
        return dados;
    }

    /**
     * Lista os ids de uma determinada lista de reservas
     * 
     * @param reservas
     * @return
     */
    @Override
    public Long[] listarIDs(List<Reserva> reservas) {
        int i = 0;
        Long[] idReservas = new Long[reservas.size()];
        if (reservas != null) {
            for (Reserva r : reservas) {
                idReservas[i] = r.getId();
                i++;
            }
        }
        return idReservas;
    }
}
