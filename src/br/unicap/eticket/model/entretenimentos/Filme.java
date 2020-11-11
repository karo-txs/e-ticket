package br.unicap.eticket.model.entretenimentos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
@Table(name = "filmes")
public class Filme extends Entretenimento implements Serializable {

    @Column(nullable = false)
    private String diretor;

    public Filme() {
    }

    public Filme(String nome) {
        super(nome);
    }

    public Filme(String nome, String diretor, int duracao, String sinopse, byte[] capa) {
        super(nome,duracao, sinopse, capa);
        this.diretor = diretor;
    }

    public Filme(String nome, String diretor, int duracao, String sinopse) {
        super(nome, duracao, sinopse);
        this.diretor = diretor;
    }

    public Filme(String nome, String diretor, int duracao, Classificacao classificacao, String sinopse) {
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
