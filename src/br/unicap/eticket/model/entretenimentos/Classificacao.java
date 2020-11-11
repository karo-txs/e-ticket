package br.unicap.eticket.model.entretenimentos;
public enum Classificacao {
    LIVRE("/imagens/classLivre.png"), 
    DEZ("/imagens/class10.png"), 
    DOZE("/imagens/class12.png"), 
    QUATORZE("/imagens/class14.png"), 
    DEZESSEIS("/imagens/class16.png"), 
    DEZOITO("/imagens/class18.png");
    
    private String caminho;
    
    private Classificacao(){ }
    
    private Classificacao(String caminho){
        this.caminho=caminho;
    }
    public static Classificacao getClassificacao(String classif){
    switch(classif){
        case "Livre": return Classificacao.LIVRE;
        case "Dez": return Classificacao.DEZ;
        case "Doze": return Classificacao.DOZE;
        case "Quatorze": return Classificacao.QUATORZE;
        case "Dezesseis": return Classificacao.DEZESSEIS;
        case "Dezoito": return Classificacao.DEZOITO;
    }
    return null;
}
    
    public String getCaminho(){
        return caminho;
    }
}
