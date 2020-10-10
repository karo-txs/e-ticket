package br.unicap.eticket.model.locaisAuxiliares;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("2")
@Table(name = "pecas")
public class Peca extends Entretenimento implements Serializable{
    
    public Peca() {
    }
    
    public Peca(String nome) {
        super(nome);
    }

    public Peca(String nome, String diretor, int duracao, String sinopse, byte[] capa) {
        super(nome,diretor,duracao,sinopse,capa);
    }

    public Peca(String nome, String diretor, int duracao, String sinopse) {
        super(nome,diretor,duracao,sinopse);
    }

    public Peca(String nome, String diretor, int duracao, Classificacao classificacao, String sinopse) {
        super(nome, diretor, duracao, classificacao, sinopse);
    }
    
}
