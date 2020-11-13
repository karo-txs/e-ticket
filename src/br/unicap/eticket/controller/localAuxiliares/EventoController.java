package br.unicap.eticket.controller.localAuxiliares;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.dao.EventoDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Evento;

public class EventoController implements BaseControl<Evento> {

    private EventoDAO dao;

    public EventoController(){
        this.dao =  new EventoDAO();
    }
    /**
     * Cadastra um evento
     *
     * @param evento
     * @throws DadosRepetidosException
     * @throws CadastroInexistenteException
     */
    @Override
    public void cadastrar(Evento evento) throws DadosRepetidosException, CadastroInexistenteException {
       
        if (dao.buscarEvento(evento) == null) {
            dao.incluirAtomico(evento);
            evento.getSessao().ativarEvento(true);
        } else {
            throw new DadosRepetidosException("Evento");
        }
    }

    /**
     * Busca um Evento
     *
     * @param evento
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Evento buscar(Evento evento) throws CadastroInexistenteException {
        Evento busca = dao.buscarEvento(evento);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Evento");
        }
    }

    /**
     * Atualiza os dados de um evento
     *
     * @param novo
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     */
    @Override
    public void atualizar(Evento novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        Evento busca = this.buscar(novo);
        dao.atualizarAtomico(busca);
    }

    /**
     * Remove um evento independentemente de estar ativo ou não
     * @param evento
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Evento evento) throws CadastroInexistenteException {
        dao.abrirTransacao();
        dao.removerDetached(evento);
        evento.getSessao().ativarEvento(false);
        dao.fecharTransacao();
    }
}
