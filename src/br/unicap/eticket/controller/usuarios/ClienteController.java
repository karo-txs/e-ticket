package br.unicap.eticket.controller.usuarios;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.controller.localAuxiliares.SessaoController;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.dao.ReservaDAO;
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
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.ClienteEspecial;
import br.unicap.eticket.model.usuarios.TierCliente;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController extends UsuarioController implements BaseControl<Cliente> {

    private ClienteDAO dao;

    public ClienteController() {
        this.dao = new ClienteDAO();
    }

    /**
     * Cadastro de um Cliente
     *
     * @param cliente
     * @throws DadosRepetidosException
     */
    @Override
    public void cadastrar(Cliente cliente) throws DadosRepetidosException {
        if (super.buscarUser(cliente) == null) {
            dao.incluirAtomico(cliente);
        } else {
            throw new DadosRepetidosException("Usuario");
        }
    }

    /**
     * Cadastro de Cliente com verificação dos dados básicos
     *
     * @param nome
     * @param email
     * @param senha
     * @throws DadosRepetidosException
     * @throws DadosInvalidosException
     * @throws br.unicap.eticket.excecoes.SenhaInvalidaException
     */
    public void cadastrar(String nome, String email, String senha) throws DadosRepetidosException, DadosInvalidosException, SenhaInvalidaException, IOException {
        Cliente c = new Cliente();

        if (ValidaDados.validaNome(nome)) {
            c.setNome(nome);
        } else {
            throw new DadosInvalidosException("Nome");
        }

        if (ValidaDados.validaEmail(email)) {
            c.setEmail(email);
        } else {
            throw new DadosInvalidosException("Email");
        }

        if (ValidaDados.validaSenha(senha)) {
            c.setSenha(senha);
        } else {
            throw new DadosInvalidosException("Senha");
        }
        this.cadastrar(c);
    }

    /**
     * Busca de um cliente
     *
     * @param cliente
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Cliente buscar(Cliente cliente) throws CadastroInexistenteException {
        Cliente busca = dao.buscarCliente(cliente);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Cliente");
        }
    }

    /**
     * Atualização com verificação de dados
     *
     * @param novo
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     */
    @Override
    public void atualizar(Cliente novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException, DadosInvalidosException {

        Cliente busca = this.buscar(novo);

        if (ValidaDados.validaNome(novo.getNome())) {
            busca.setNome(novo.getNome());
        }

        if (ValidaDados.validaIdade(String.valueOf(novo.getIdade()))) {
            busca.setIdade(novo.getIdade());
        }

        if (novo.getNickName() != null && !novo.getNickName().equals("") && !novo.getNome().equals(busca.getNome())) {
            if (ValidaDados.validaNickName(novo.getNickName())) {
                busca.setNickName(novo.getNickName());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("NickName"));
            }
        }

        if (ValidaDados.validaTelefone(novo.getTelefone())) {
            busca.setTelefone(novo.getTelefone());
        }

        if (ValidaDados.validaCpf(novo.getCpf())) {
            busca.setCpf(novo.getCpf());
        }

        Endereco end = novo.getEndereco();
        if (end.getCep().equals("") || end.getUf().equals("") || end.getCidade().equals("") || end.getBairro().equals("")
                || end.getLogradouro().equals("") || end.getNum().equals("")) {
            end = null;
        }
        if (end != null && !busca.getEndereco().equals(novo.getEndereco())) {
            if (ValidaDados.validaEndereco(novo.getEndereco())) {
                busca.setEndereco(novo.getEndereco());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Endereço"));
            }
        }

        if (novo.getSenha() != null && !novo.getSenha().equals("")) {
            try {
                if (ValidaDados.validaSenha(novo.getSenha())) {
                    if (!busca.getSenha().equals(novo.getSenha())) {
                        busca.setSenha(novo.getSenha());
                    }
                }
            } catch (SenhaInvalidaException ex) {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Senha"));
            } catch (IOException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        dao.atualizarAtomico(busca);
    }

    /**
     * Remoção de um Cliente existente
     *
     * @param cliente
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Cliente cliente) throws CadastroInexistenteException {
        Cliente busca = cliente.getId() == null ? this.buscar(cliente) : cliente;
        dao.removerAtomico(busca);
    }

    /**
     * Retorna o caminho do tier de um cliente
     * 
     * @param cliente
     * @param local
     * @return
     */
    public String retornaImagemTier(Cliente cliente, LocalGenerico local) {
        String caminho = null;
        if (cliente.isEspecial()) {
            ClienteEspecial clienteE = (ClienteEspecial) cliente;
            if (clienteE.getDesconto(local) != 0) {
                caminho = clienteE.getTierImg(local);
            }
        }
        return caminho;
    }

    /**
     * Paga reserva, retornando o valor pago
     * 
     * @param cliente
     * @param reserva
     * @return
     * @throws CadastroInexistenteException
     * @throws SubiuDeTierException
     */
    public double pagaReserva(Cliente cliente, Reserva reserva) throws CadastroInexistenteException, SubiuDeTierException {

        double val;
        if (cliente.isEspecial()) {
            ClienteEspecial clienteE = (ClienteEspecial) cliente;
            TierCliente tierAtual = clienteE.getTier(reserva.getSessao().getLocal());
            val = cliente.pagarReserva(reserva);

            cliente = (ClienteEspecial) this.buscar(cliente);
            clienteE = (ClienteEspecial) cliente;

            if (tierAtual != clienteE.getTier(reserva.getSessao().getLocal())) {
                throw new SubiuDeTierException("Tier");
            }
        } else {
            val = cliente.pagarReserva(reserva);
            Cliente buscaC = this.buscar(cliente);
            if (buscaC.isEspecial()) {
                throw new SubiuDeTierException("Tier");
            }
        }
        return val;
    }

    /**
     * Atualiza a chave de identificação secundária (sendo a primaria o ID, que
     * é identificado diretamente pelo BD)
     *
     * @param cliente
     * @param chave
     * @throws CadastroInexistenteException
     * @throws AtualizacaoMalSucedidaException
     */
    public void atualizarChave(Cliente cliente, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        String email = (String) chave;
        if (chave != null && !email.equalsIgnoreCase(cliente.getEmail())) {
            Cliente busca = cliente.getId() == null ? this.buscar(cliente) : cliente;
            busca.atualizarEmail(email);
        }
    }

    /**
     * Faz a reserva de um assento
     * 
     * @param cliente
     * @param sessao
     * @param numCadeira
     * @return
     * @throws CadastroInexistenteException
     * @throws DadosInvalidosException
     * @throws DadosRepetidosException
     */
    public Reserva fazerReserva(Cliente cliente, Sessao sessao, String numCadeira) throws CadastroInexistenteException, DadosInvalidosException, DadosRepetidosException {
        ReservaDAO reservaC = new ReservaDAO();
        ClienteDAO dao = new ClienteDAO();
        SessaoController sc = new SessaoController();
        Sessao buscaS = sessao.getId() == null ? sc.buscar(sessao) : sessao;

        Reserva busca = reservaC.buscarReserva(new Reserva(buscaS, numCadeira));
        Cliente c = cliente.getId() == null ? dao.buscarCliente(cliente) : cliente;
        if (busca == null) {
            return c.fazerReserva(sessao, numCadeira);
        } else {
            throw new DadosRepetidosException("Reserva");
        }
    }

    /**
     * Cancela a reserva de um assento
     * 
     * @param cliente
     * @param rFeita
     * @throws CadastroInexistenteException
     */
    public void cancelarReserva(Cliente cliente, Reserva rFeita) throws CadastroInexistenteException {
        cliente.cancelarReserva(rFeita);
    }
    
    /**
     * Preenchimento dos dados financeiros, com validação previa
     * 
     * @param cliente
     * @param numero
     * @param nomeNoCartao
     * @param dataExpiracao
     * @param codigoSeguranca
     * @throws DadosFinanceirosInvalidosException
     */
    public void preencherDadosFinanceiros(Cliente cliente, String numero, String nomeNoCartao, Calendar dataExpiracao, int codigoSeguranca) throws DadosFinanceirosInvalidosException{
        ClienteController clienteC = new ClienteController();
        String validade = ValidaDados.validaDadosFinanceirosCredito(numero, nomeNoCartao, dataExpiracao, codigoSeguranca);

        if (validade.equals("VALIDO")) {
            Cliente busca = clienteC.buscar(cliente);
            busca.preencherDadosFinanceiros(numero, nomeNoCartao, dataExpiracao, codigoSeguranca);
        } else {
            throw new DadosFinanceirosInvalidosException(validade);
        }
    }
}
