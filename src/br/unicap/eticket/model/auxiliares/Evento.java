package br.unicap.eticket.model.auxiliares;

import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locaisAuxiliares.TipoEvento;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @OneToOne
    private Sessao sessao;
    
    @Column
    private TipoEvento tipoEvento;

    @ManyToOne
    private LocalGenerico local;
    
    public Evento() {
    }

    public Evento(Sessao sessao) {
        this.sessao = sessao;
    }

    public Evento(Sessao s, TipoEvento t) {
        this.sessao = s;
        this.tipoEvento = t;
    }

    public Long getId() {
        return id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public LocalGenerico getLocal() {
        return local;
    }

    public void setLocal(LocalGenerico local) {
        this.local = local;
    }
 
}
