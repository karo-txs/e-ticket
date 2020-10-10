package br.unicap.eticket.model.auxiliares;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String num;
    private String complemento;

    public Endereco() {

    }

    public Endereco(String cep, String estado, String cidade, String bairro, String rua, String numCasa, String comp) {
        this(cep, estado, cidade, bairro, rua, numCasa);
        this.complemento = comp;
    }

    public Endereco(String cep, String estado, String cidade, String bairro, String rua, String numCasa) {
        this.cep = cep;
        this.uf = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = rua;
        this.num = numCasa;
    }

    public String getUf() {
        return this.uf == null ? "" : this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return this.bairro == null ? "" : this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return this.logradouro == null ? "" : this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNum() {
        return this.num == null ? "" : this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCidade() {
        return this.cidade == null ? "" : this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return this.complemento == null ? "" : this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return this.cep == null ? "" : this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.uf);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.logradouro);
        hash = 67 * hash + Objects.hashCode(this.num);
        hash = 67 * hash + Objects.hashCode(this.complemento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.num, other.num)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        return true;
    }

}
