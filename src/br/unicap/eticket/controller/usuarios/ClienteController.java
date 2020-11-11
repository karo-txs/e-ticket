package br.unicap.eticket.controller.usuarios;

import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.excecoes.SubiuDeTierException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Cliente;
import br.unicap.eticket.model.usuarios.ClienteEspecial;
import br.unicap.eticket.model.usuarios.TierCliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController extends UsuarioController implements BaseControl<Cliente> {

    private ClienteDAO dao = new ClienteDAO();

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
    public void atualizar(Cliente novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {

        Cliente busca = this.buscar(novo);
        if (novo.getNome() != null && !novo.getNome().equals("") && !novo.getNome().equals(busca.getNome())) {
            if (ValidaDados.validaNome(novo.getNome())) {
                busca.setNome(novo.getNome());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Nome"));
            }
        }

        if (novo.getNickName() != null && !novo.getNickName().equals("") && !novo.getNome().equals(busca.getNome())) {
            if (ValidaDados.validaNickName(novo.getNickName())) {
                busca.setNickName(novo.getNickName());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("NickName"));
            }
        }

        if (novo.getIdade() != 0 && novo.getIdade() != busca.getIdade()) {
            if (ValidaDados.validaQuantidade(String.valueOf(novo.getIdade()))) {
                busca.setIdade(novo.getIdade());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Idade"));
            }
        }

        if (novo.getTelefone() != null && !novo.getTelefone().equals("") && !novo.getTelefone().equals(busca.getTelefone())) {
            System.out.println(novo.getTelefone());
            if (ValidaDados.validaTelefone(novo.getTelefone())) {
                busca.setTelefone(novo.getTelefone());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Telefone"));
            }
        }
        if (novo.getCpf() != null && !novo.getCpf().equals("") && !busca.getCpf().equals(novo.getCpf())) {
            if (ValidaDados.validaCpf(novo.getCpf())) {
                busca.setCpf(novo.getCpf());
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Cpf"));
            }
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

        if (novo.getSenha() != null && !novo.getSenha().equals("") && !busca.getSenha().equals(novo.getSenha())) {
            try {
                if (ValidaDados.validaSenha(novo.getSenha())) {
                    busca.setSenha(novo.getSenha());
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
}
