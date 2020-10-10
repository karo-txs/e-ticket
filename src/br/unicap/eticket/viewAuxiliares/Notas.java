package br.unicap.eticket.viewAuxiliares;

public enum Notas {
    nota0("/imagensRework/estrelas (1).png",0),
    nota1("/imagensRework/estrelas (2).png",1),
    nota15("/imagensRework/estrelas (3).png",1.5),
    nota2("/imagensRework/estrelas (4).png",2),
    nota25("/imagensRework/estrelas (5).png",2.5),
    nota3("/imagensRework/estrelas (6).png",3),
    nota35("/imagensRework/estrelas (7).png",3.5),
    nota4("/imagensRework/estrelas (8).png",4),
    nota45("/imagensRework/estrelas (9).png",4.5),
    nota5("/imagensRework/estrelas (10).png",5);
    
    private double nota;
    private String caminho;
    
    private Notas(String caminho, double nota){
        this.nota = nota;
        this.caminho=caminho;
    }
    
    public double getNota(){
        return this.nota;
    }
    public String getCaminho(){
        return this.caminho;
    }
    
    public static Notas qualCaminho(double nota){
        Notas notaAux = nota<=Notas.nota0.getNota() ? Notas.nota0: 
                        nota<=Notas.nota1.getNota() ? Notas.nota1:
                        nota<=Notas.nota15.getNota() ? Notas.nota15:
                        nota<=Notas.nota2.getNota() ? Notas.nota2:
                        nota<=Notas.nota25.getNota() ? Notas.nota25:
                        nota<=Notas.nota3.getNota() ? Notas.nota3:
                        nota<=Notas.nota35.getNota() ? Notas.nota35:
                        nota<=Notas.nota4.getNota() ? Notas.nota4:
                        nota<=Notas.nota45.getNota() ? Notas.nota45:
                        nota<=Notas.nota5.getNota() ? Notas.nota5: null;
        return notaAux;
    }
}
