package br.unicap.eticket.controller.usuarios;

import br.unicap.eticket.controller.localAuxiliares.FachadaLocais;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosFinanceirosInvalidosException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.excecoes.SubiuDeTierException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Admin;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.Usuario;
import java.io.IOException;
import java.util.Calendar;

public class FachadaUsuarios {

    private static FachadaUsuarios instance;

    AdminController admC;
    ClienteController cliC;
    UsuarioController userC;

    private FachadaUsuarios() {
        this.userC = new UsuarioController();
        this.cliC = new ClienteController();
        this.admC = new AdminController();
    }

    public static FachadaUsuarios getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new FachadaUsuarios();
            return instance;
        }
    }

//---------------------------- CADASTROS ----------------------------//
    public void cadastrar(Admin adm) throws DadosRepetidosException {
        admC.cadastrar(adm);
    }

    public void cadastrar(String nome, String email, String senha, String tipoLocal, String nomeDoLocal, Endereco end) throws DadosInvalidosException, DadosRepetidosException, SenhaInvalidaException, IOException {
        admC.cadastrar(nome, email, senha, tipoLocal, nomeDoLocal, end);
    }

    public void cadastrar(Cliente cliente) throws DadosRepetidosException {
        cliC.cadastrar(cliente);
    }

    public void cadastrar(String nome, String email, String senha) throws DadosRepetidosException, DadosInvalidosException, SenhaInvalidaException, IOException {
        cliC.cadastrar(nome, email, senha);
    }
//---------------------------- BUSCAS ----------------------------//

    public Admin buscar(Admin adm) throws CadastroInexistenteException {
        return admC.buscar(adm);
    }

    public Cliente buscar(Cliente cliente) throws CadastroInexistenteException {
        return cliC.buscar(cliente);
    }

    public Usuario buscarUser(Usuario user) {
        return userC.buscarUser(user);
    }

    //---------------------------- ATUALIZAÇÃO ----------------------------//
    public void atualizar(Admin novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException, DadosInvalidosException {
        admC.atualizar(novo);
    }

    public void atualizar(Cliente novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException, DadosInvalidosException {
        cliC.atualizar(novo);
    }

    //---------------------------- REMOÇÕES ----------------------------//
    public void remover(Admin adm) throws CadastroInexistenteException {
        admC.remover(adm);
    }

    public void removerLocalAdm(Admin adm) throws CadastroInexistenteException {
        admC.removerLocalAdm(adm);
    }

    public void remover(Cliente cliente) throws CadastroInexistenteException {
        cliC.remover(cliente);
    }

    //---------------------------- OUTROS ----------------------------//
    public void validarDadosAdmin(String nome, String email, String senha) throws DadosInvalidosException, SenhaInvalidaException, IOException {
        admC.validarDadosAdmin(nome, email, senha);
    }

    public void adicionarLocalAdm(Admin adm, LocalGenerico local) throws CadastroInexistenteException {
        admC.adicionarLocalAdm(adm, local);
    }

    public void atualizarChave(Admin adm, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        admC.atualizarChave(adm, chave);
    }

    public String retornaImagemTier(Cliente cliente, LocalGenerico local) {
        return cliC.retornaImagemTier(cliente, local);
    }

    public double pagaReserva(Cliente cliente, Reserva reserva) throws CadastroInexistenteException, SubiuDeTierException {
        return cliC.pagaReserva(cliente, reserva);
    }

    public void atualizarChave(Cliente cliente, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        cliC.atualizarChave(cliente, chave);
    }

    public Reserva fazerReserva(Cliente cliente, Sessao sessao, String numCadeira) throws CadastroInexistenteException, DadosInvalidosException, DadosRepetidosException {
        return cliC.fazerReserva(cliente, sessao, numCadeira);
    }

    public void cancelarReserva(Cliente cliente, Reserva rFeita) throws CadastroInexistenteException {
        cliC.cancelarReserva(cliente, rFeita);
    }

    public void preencherDadosFinanceiros(Cliente cliente, String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) throws DadosFinanceirosInvalidosException {
        cliC.preencherDadosFinanceiros(cliente, numero, nomeNoCartao, dataExpiracao, codigoSeguranca);
    }

    public Usuario login(String email, String senha) throws DadosInvalidosException {
        return userC.login(email, senha);
    }
}
