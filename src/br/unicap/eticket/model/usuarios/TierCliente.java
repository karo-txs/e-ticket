package br.unicap.eticket.model.usuarios;

public enum TierCliente {

    TIER1(0.20F, 20, "/imagensRework/icones/Tier1.png"),
    TIER2(0.15F, 10, "/imagensRework/icones/Tier2.png"),
    TIER3(0.10F, 5, "/imagensRework/icones/Tier3.png");

    private float desconto;
    private int qtdeTickets;
    private String caminhoImg;

    private TierCliente(float desconto, int qtdeTickets, String caminhoImg) {
        this.desconto = desconto;
        this.qtdeTickets = qtdeTickets;
        this.caminhoImg = caminhoImg;
    }

    public float getDesconto() {
        return this.desconto;
    }

    public int getQtdeTickets() {
        return qtdeTickets;
    }

    public String getCaminho() {
        return this.caminhoImg;
    }

    public TierCliente getTier(float desconto) {
        if (desconto == 0) {
            return null;
        } else if (desconto <= TierCliente.TIER3.getDesconto()) {
            return TierCliente.TIER3;
        } else if (desconto <= TierCliente.TIER2.getDesconto()) {
            return TierCliente.TIER2;
        } else {
            return TierCliente.TIER1;
        }
    }
}
