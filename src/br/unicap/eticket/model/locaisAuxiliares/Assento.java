package br.unicap.eticket.model.locaisAuxiliares;

import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.factoryMethod.GerenciadorLista;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embeddable;

@Embeddable
public class Assento implements Serializable {

    private String numeracao;
    private ArrayList<Long> idReservas;

    public Assento() {
    }

    public Assento(String numeracao) {
        GerenciadorLista<Long> gl = new GerenciadorLista<>();
        this.numeracao = numeracao;
        this.idReservas = (ArrayList)gl.criaLista();
    }

    /**
     * Preenche um Assento
     * @param reserva
     */
    public void preencherAssento(Reserva reserva) {
        this.idReservas.add(reserva.getId());
    }
    
    /**
     * Retorna as reservas feitas no assento
     * @return List
     */
    public List<Long> getReservas() {
        return idReservas;
    }

    //Gets e Sets
    public String getNumeracao() {
        return this.numeracao;
    }

    public void setNumeracao(String num) {
        this.numeracao = num;
    }

}
