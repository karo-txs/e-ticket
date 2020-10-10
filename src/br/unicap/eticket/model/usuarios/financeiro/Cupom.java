package br.unicap.eticket.model.usuarios.financeiro;

import br.unicap.eticket.model.locais.LocalGenerico;
import java.util.Calendar;

public class Cupom {
    /* NÃO IMPLEMENTADO */
    private LocalGenerico local;
    private String codigo;
    private double valor;
    private Calendar dataExpiracao;
    private boolean validez;

    public Cupom(LocalGenerico local,String codigo, double valor, Calendar dataExpiracao) {
        this.local=local;
        this.codigo = codigo;
        this.valor = valor;
        this.dataExpiracao = dataExpiracao;
        this.validez=true;
    }
    
    public void desvalidarCupom(){
        this.validez=false;
    }

    public boolean isValidez() {
        return validez;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Calendar dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public LocalGenerico getLocal() {
        return local;
    }
    
}
