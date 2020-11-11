
package br.unicap.eticket.model.entretenimentos;

import br.unicap.eticket.model.locais.Auditorio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("3")
@Table(name = "palestras")
public class Palestra extends Entretenimento implements Serializable{
    
    @Column(nullable = false)
    private String palestrante;
    
    @ManyToOne
    private Auditorio auditorio;
    
    public Palestra() {
    }

    public Palestra(String nome, Auditorio audi) {
        super(nome);
        this.auditorio= audi;
    }

    public Palestra(String nome, String palestrante, int duracao, String sinopse, byte[] capa, Auditorio audi) {
        super(nome, duracao, sinopse, capa);
        this.palestrante = palestrante;
        this.auditorio= audi;
    }

    public Palestra(String nome, String palestrante, int duracao, String sinopse,Auditorio audi) {
        super(nome, duracao, sinopse);
        this.palestrante = palestrante;
        this.auditorio= audi;
    }

    public Palestra(String nome, String palestrante, int duracao, Classificacao classificacao, String sinopse,Auditorio audi) {
        super(nome, duracao, classificacao, sinopse);
        this.palestrante = palestrante;
        this.auditorio= audi;
    }

    @Override
    public String getDiretor() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public Auditorio getAuditorio() {
        return auditorio;
    }

    public void setAuditorio(Auditorio auditorio) {
        this.auditorio = auditorio;
    }
    
    
}
