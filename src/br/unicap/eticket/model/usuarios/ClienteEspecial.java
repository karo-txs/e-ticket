package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.control.locais.LocalControl;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;

@Entity
@DiscriminatorValue("1")
public class ClienteEspecial extends Cliente {

    @ElementCollection
    @JoinTable(name = "cliente_fidelidades", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "Local")
    @Column(name = "TierCliente")
    private Map<LocalGenerico, TierCliente> fidelidades = new HashMap<>();

    public ClienteEspecial() {
    }

    public ClienteEspecial(String nome, String nick, String email, String senha) {
        super(nome, nick, email, senha);
    }

    public ClienteEspecial(String nome, String email, String senha, int idade, String cpf, String telefone) {
        super(nome, email, senha, idade, cpf, telefone);
    }

    public ClienteEspecial(String nome, String nick, String email, String senha, int idade, String cpf, String telefone, Endereco endereco) {
        super(nome, nick, email, senha, idade, cpf, telefone, endereco);
    }

    @Override
    public double pagarReserva(Reserva reserva) throws CadastroInexistenteException {
        ClienteDAO clienteD = new ClienteDAO();
        ClienteEspecial buscaC = this.getId() == null ? (ClienteEspecial) clienteD.buscarCliente(this) : this;

        ReservaControl reservaC = new ReservaControl();
        Reserva buscaR = reserva.getId() == null ? reservaC.buscar(reserva) : reserva;
        LocalGenerico local = buscaR.getSessao().getLocal();

        double valorPago;
        int qtdeTickets = this.qtdeTickets(local);

        if (fidelidades.containsKey(local)) {
            valorPago = buscaR.getValorIngresso() - (buscaR.getValorIngresso() * fidelidades.get(local).getDesconto());

            if (qtdeTickets == TierCliente.TIER1.getQtdeTickets() || qtdeTickets == TierCliente.TIER2.getQtdeTickets()) {
                buscaC.subirDeTier(local);
            }

        } else {
            if (qtdeTickets == TierCliente.TIER3.getQtdeTickets()) {
                buscaC.criarFidelidade(local);
                valorPago = buscaR.getValorIngresso() - (buscaR.getValorIngresso() * fidelidades.get(local).getDesconto());
            } else {
                valorPago = buscaR.getValorIngresso();
            }
        }
        clienteD.atualizarAtomico(buscaC);
        return valorPago;
    }

    public void criarFidelidade(LocalGenerico local) throws CadastroInexistenteException {
        LocalControl localC = new LocalControl();
        this.fidelidades = new LinkedHashMap<>();
        LocalGenerico busca = local.getId() == null ? localC.buscar(local) : local;
        this.fidelidades.put(busca, TierCliente.TIER3);
    }

    private void subirDeTier(LocalGenerico local) throws CadastroInexistenteException {
        LocalControl localC = new LocalControl();
        TierCliente novoTier = null;
        TierCliente tierAtual = this.fidelidades.get(local);
        LocalGenerico busca = local.getId() == null ? localC.buscar(local) : local;

        switch (tierAtual) {
            case TIER3:
                novoTier = TierCliente.TIER2;
                break;
            case TIER2:
                novoTier = TierCliente.TIER1;
                break;
            case TIER1:
                novoTier = TierCliente.TIER1;
                break;
        }
        this.fidelidades.replace(busca, novoTier);
    }

    public double getDesconto(LocalGenerico local) {
        if (fidelidades.containsKey(local)) {
            return fidelidades.get(local).getDesconto();
        } else {
            return 0;
        }
    }

    public String getTierImg(LocalGenerico local) {
        if (fidelidades.containsKey(local)) {
            return fidelidades.get(local).getCaminho();
        } else {
            return null;
        }
    }
    
    public TierCliente getTier(LocalGenerico local){
        if (fidelidades.containsKey(local)) {
            return fidelidades.get(local).getTier(fidelidades.get(local).getDesconto());
        } else {
            return null;
        }
    }

    @Override
    public boolean isEspecial() {
        return true;
    }
}
