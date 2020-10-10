
package br.unicap.eticket.dao;

import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locais.LocalGenerico;
import java.util.List;

public class LocalDAO extends BaseDAO<LocalGenerico> {
    public LocalDAO(){ super(LocalGenerico.class); }
    
     public LocalGenerico buscarLocal(LocalGenerico obj){
        Endereco end = obj.getEndereco();
        List<LocalGenerico> local = this.consultar("localDoEndereco", "estado",end.getUf(),
                                                              "cidade",end.getCidade(),
                                                              "bairro",end.getBairro(),
                                                              "rua",end.getLogradouro(),
                                                              "num",end.getNum());
        if(local.isEmpty()) return null;
        else return local.get(0);
    }
     
      public LocalGenerico buscarLocal(Endereco end){
        List<LocalGenerico> local = this.consultar("localDoEndereco", "estado",end.getUf(),
                                                              "cidade",end.getCidade(),
                                                              "bairro",end.getBairro(),
                                                              "rua",end.getLogradouro(),
                                                              "num",end.getNum());
        if(local.isEmpty()) return null;
        else return local.get(0);
    }
}
