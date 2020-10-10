package br.unicap.eticket.dao;

import br.unicap.eticket.model.usuarios.Usuario;
import java.util.List;

public class UsuarioDAO extends BaseDAO<Usuario>{
    public UsuarioDAO(){super(Usuario.class);}
    
    public Usuario buscarUser(String email){
        List<Usuario> aux = this.consultar("clienteDoEmail", "email",email);
        List<Usuario> aux2 = this.consultar("adminDoEmail","email",email);
        aux.addAll(aux2);
        if(aux.isEmpty()) return null;
        else return aux.get(0);
    }
}
