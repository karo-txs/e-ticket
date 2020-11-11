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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReservaController implements BaseControl<Reserva>, Formatador<Reserva> {

    private ReservaDAO dao = new ReservaDAO();

    /**
     * Cadastro de uma Reserva
     *
     * @param reserva
     * @throws DadosRepetidosException
     */
    @Override
    public void cadastrar(Reserva reserva) throws DadosRepetidosException {
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
        dao.abrirTransacao();
        busca.setAssento(reserva.getAssento());
        busca.setSessao(reserva.getSessao());
        dao.atualizar(busca);
        dao.fecharTransacao();
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
        dao.removerAtomico(busca);
    }

    private double[] retornaIngresso(Cliente cliente, Reserva reserva) throws CadastroInexistenteException {
        double[] ingresso = new double[2];
        Reserva buscaR = reserva.getId() == null ? this.buscar(reserva) : reserva;
        Sessao sessao = buscaR.getSessao();
        if (cliente.isEspecial()) {
            ClienteEspecial clienteE = (ClienteEspecial) cliente;
            if (clienteE.getDesconto(sessao.getLocal()) != 0) {
                ingresso[1] = clienteE.getDesconto(sessao.getLocal());
                if (!sessao.isEventoAtivado()) {
                    ingresso[0] = sessao.getSala().getValorIngresso() - (buscaR.getValorIngresso()
                            * clienteE.getDesconto(sessao.getLocal()));
                }
            }
        } else {
            ingresso[0] = sessao.getValorIngresso();
            ingresso[1] = 0;
        }
        return ingresso;
    }

    public double[] mostrarIngresso(Cliente cliente, Reserva r) {
        double[] ingresso = new double[3];
        ingresso[1] = r.getValorIngresso();

        Sessao sessao = r.getSessao();
        if (cliente.isEspecial()) {
            ClienteEspecial clienteE = (ClienteEspecial) cliente;
            if (clienteE.getDesconto(sessao.getLocal()) != 0) {
                ingresso[1] = clienteE.getDesconto(sessao.getLocal());
                if (!sessao.isEventoAtivado()) {
                    ingresso[0] = sessao.getSala().getValorIngresso() - (r.getValorIngresso()
                            * clienteE.getDesconto(sessao.getLocal()));
                }
            }
        } else {
            ingresso[0] = r.getValorIngresso();
            ingresso[2] = 0;
        }
        return ingresso;
    }

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
