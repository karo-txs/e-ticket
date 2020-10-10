package br.unicap.eticket.dao;

import br.unicap.eticket.model.usuarios.Admin;
import java.util.List;

public class AdminDAO extends BaseDAO<Admin> {
     public AdminDAO(){ super(Admin.class); }
     
     public Admin buscarAdmin(Admin a){
        List<Admin> aux = this.consultar("adminDoEmail", "email",a.getEmail());
        if(aux.isEmpty()) return null;
        else return aux.get(0);
    }
}
