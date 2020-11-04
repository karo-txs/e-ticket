package br.unicap.eticket.model.locaisAuxiliares;

public enum TipoEvento {

    DEZ_TICKETS_GRATIS("10 Tickets Grátis", 10),
    VINTE_TICKETS_GRATIS("20 Tickets Grátis", 20),
    TRINTA_TICKETS_GRATIS("30 Tickets Grátis", 30);

    private int qtd;
    private String nome;

    TipoEvento(String nome, int n) {
        this.qtd = n;
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static TipoEvento eventoSelecionado(String nome) {
        switch (nome) {
            case "10 Tickets Grátis":
                return TipoEvento.DEZ_TICKETS_GRATIS;
            case "20 Tickets Grátis":
                return TipoEvento.VINTE_TICKETS_GRATIS;
            case "30 Tickets Grátis":
                return TipoEvento.TRINTA_TICKETS_GRATIS;
            default:
                return null;
        }
    }
    
    public static String[] eventos(){
        int i =0;
        String[] eventos = new String[TiposDeSala.values().length];
        for(TipoEvento t: TipoEvento.values()){
            eventos[i] = t.getNome();
            i++;
        }
        return eventos;
    }
}
