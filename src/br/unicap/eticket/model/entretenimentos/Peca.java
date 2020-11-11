package br.unicap.eticket.model.entretenimentos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("2")
@Table(name = "pecas")
public class Peca extends Entretenimento implements Serializable {

    @Column(nullable = false)
    private String diretor;

    public Peca() {
    }

    public Peca(String nome) {
        super(nome);
    }

    public Peca(String nome, String diretor, int duracao, String sinopse, byte[] capa) {
        super(nome, duracao, sinopse, capa);
        this.diretor = diretor;
    }

    public Peca(String nome, String diretor, int duracao, String sinopse) {
        super(nome, duracao, sinopse);
        this.diretor = diretor;
    }

    public Peca(String nome, String diretor, int duracao, Classificacao classificacao, String sinopse) {
        super(nome, duracao, classificacao, sinopse);
        this.diretor = diretor;
    }

    @Override
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
