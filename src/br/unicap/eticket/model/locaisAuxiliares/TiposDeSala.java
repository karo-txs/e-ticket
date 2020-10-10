package br.unicap.eticket.model.locaisAuxiliares;
public enum TiposDeSala {
    NORMAL("NORMAL"),
    IMAX("IMAX"), 
    DMAX("DMAX"), 
    SALA3D("SALA3D"), 
    PRIME("PRIME"), 
    BISTRO("BISTRO");
    
    private String tipo;
    
    private TiposDeSala(String tipo){
        this.tipo=tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public static String[] tipos(){
        int i =0;
        String[] tipos = new String[TiposDeSala.values().length];
        for(TiposDeSala t: TiposDeSala.values()){
            tipos[i] = t.getTipo();
            i++;
        }
        return tipos;
    }
}
