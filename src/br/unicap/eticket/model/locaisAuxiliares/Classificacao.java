package br.unicap.eticket.model.locaisAuxiliares;
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
    
    public String getCaminho(){
        return caminho;
    }
}
