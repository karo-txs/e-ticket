package br.unicap.eticket.dao;

import br.unicap.eticket.model.usuarios.Cliente;
import java.util.List;

public class ClienteDAO extends BaseDAO<Cliente> {
    public ClienteDAO(){ super(); }
    
    public Cliente buscarCliente(Cliente c){
        List<Cliente> aux = this.consultar("clienteDoEmail", "email",c.getEmail());
        if(aux.isEmpty()) return null;
        else return aux.get(0);
    }
    /*
    public Cliente buscarCliente(String nick){
        List<Cliente> aux = this.consultar("clienteDoNick", nick);
        if(aux.isEmpty()) return null;
        else return aux.get(0);
    }*/
}
