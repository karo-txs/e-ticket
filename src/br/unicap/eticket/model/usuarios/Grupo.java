package br.unicap.eticket.model.usuarios;

import br.unicap.eticket.controller.usuarios.FachadaUsuarios;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import java.util.ArrayList;
import java.util.List;

public class Grupo {
     /* NÃO IMPLEMENTADO */
    private Cliente lider;
    private List<Cliente> grupo;
    
    public Grupo(Cliente lider){
        this.lider=lider;
        grupo = new ArrayList<>();
    }
    
    public void adicionarIntegrante(Cliente cliente) throws CadastroInexistenteException{
        Cliente busca = cliente.getId()==null ? FachadaUsuarios.getInstance().buscar(cliente) : cliente;
        
        if(busca!=null){
            grupo.add(busca);
          //atualiza o lider e os participantes
        }
    }
    
    public void removerIntegrante(Cliente cliente) throws CadastroInexistenteException{
        Cliente busca = cliente.getId()==null ? FachadaUsuarios.getInstance().buscar(cliente) : cliente;
        
        if(busca!=null){
          grupo.remove(cliente);
          //atualiza o lider e os participantes
        }
    }
    
    public List<Cliente> getGrupo() {
        return grupo;
    }

    public Cliente getLider() {
        return lider;
    }

}
