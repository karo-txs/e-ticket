package br.unicap.eticket.model.locaisAuxiliares;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
@Table(name = "filmes")
public class Filme extends Entretenimento implements Serializable {
    
    public Filme() {
    }
    
    public Filme(String nome) {
        super(nome);
    }
    
    public Filme(String nome, String diretor, int duracao, String sinopse, byte[] capa) {
        super(nome,diretor,duracao,sinopse,capa);
    }

    public Filme(String nome, String diretor, int duracao, String sinopse) {
        super(nome,diretor,duracao,sinopse);
    }

    public Filme(String nome, String diretor, int duracao, Classificacao classificacao, String sinopse) {
        super(nome, diretor, duracao, classificacao, sinopse);
    }
    
}
