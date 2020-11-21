package br.unicap.eticket.model.entretenimentos;

public enum Classificacao {
    LIVRE("Livre", "/imagens/classLivre.png"),
    DEZ("Dez", "/imagens/class10.png"),
    DOZE("Doze", "/imagens/class12.png"),
    QUATORZE("Quatorze", "/imagens/class14.png"),
    DEZESSEIS("Dezesseis", "/imagens/class16.png"),
    DEZOITO("Dezoito", "/imagens/class18.png");

    private String caminho;
    private String classif;

    private Classificacao() {
    }

    private Classificacao(String classif, String caminho) {
        this.classif = classif;
        this.caminho = caminho;
    }

    public static Classificacao getClassificacao(String classif) {
        switch (classif) {
            case "Livre":
                return Classificacao.LIVRE;
            case "Dez":
                return Classificacao.DEZ;
            case "Doze":
                return Classificacao.DOZE;
            case "Quatorze":
                return Classificacao.QUATORZE;
            case "Dezesseis":
                return Classificacao.DEZESSEIS;
            case "Dezoito":
                return Classificacao.DEZOITO;
        }
        return null;
    }

    public String getCaminho() {
        return caminho;
    }

    public String getClassif() {
        return classif;
    }

    public static String[] tipos() {
        int i = 0;
        String[] tipos = new String[Classificacao.values().length];
        for (Classificacao t : Classificacao.values()) {
            tipos[i] = t.getClassif();
            i++;
        }
        return tipos;
    }
}
