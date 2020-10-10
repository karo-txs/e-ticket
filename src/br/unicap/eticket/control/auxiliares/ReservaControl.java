package br.unicap.eticket.control.auxiliares;

import br.unicap.eticket.control.interfaces.BaseControl;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;

public class ReservaControl implements BaseControl<Reserva> {

    private ReservaDAO dao = new ReservaDAO();

    /**
     * Cadastro de uma Reserva
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
     * @param reserva
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Reserva buscar(Reserva reserva) throws CadastroInexistenteException {
        SalaDAO sc = new SalaDAO();
        if (reserva.getSessao().getId() == null) {
            reserva.getSessao().setNome(sc.buscarSala(reserva.getSessao().getSala().getNome()).getNome()
                    + ":" + reserva.getSessao().getNome());
        }
        Reserva busca = dao.buscarReserva(reserva);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Reserva");
        }
    }
    
    /**
     * Busca por id de uma Reserva
     * @param id
     * @return
     */
    public Reserva buscaPorId(Long id){
        return dao.buscarPorId(id);
    }

    /**
     * Atualização de uma Reserva
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
     * @param reserva
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Reserva reserva) throws CadastroInexistenteException {
        Reserva busca = reserva.getId() == null ? this.buscar(reserva) : reserva;
        dao.removerAtomico(busca);
    }

}
