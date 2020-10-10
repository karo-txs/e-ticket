package br.unicap.eticket.control.usuarios;
import br.unicap.eticket.dao.UsuarioDAO;
import br.unicap.eticket.model.usuarios.Usuario;
import java.util.List;
import br.unicap.eticket.excecoes.DadosInvalidosException;

public class UsuarioControl{
    private UsuarioDAO dao = new UsuarioDAO();
    
    /**
     * Busca um usuario pelo e-mail, seja ele um Cliente ou Admin
     * @param user
     * @return
     */
    public Usuario buscarUser(Usuario user){
        return dao.buscarUser(user.getEmail());
    }
    
    /**
     * Usuario (Cliente ou Admin) pode fazer login se suas informações estiverem corretas
     * @param email
     * @param senha
     * @return
     * @throws DadosInvalidosException
     */
    public Usuario login(String email, String senha)throws DadosInvalidosException{
        List<Usuario> aux = dao.consultar("adminLogin", "email", email, "senha", senha);
        List<Usuario> aux2 = dao.consultar("clienteLogin", "email", email, "senha", senha);
        aux.addAll(aux2);
        if (aux.isEmpty()) {
            throw new DadosInvalidosException("Login");
        } else {
            return aux.get(0);
        }
    }
    
}
