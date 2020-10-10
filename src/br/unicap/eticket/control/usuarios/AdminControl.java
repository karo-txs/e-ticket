package br.unicap.eticket.control.usuarios;

import br.unicap.eticket.control.interfaces.BaseControl;
import br.unicap.eticket.control.locais.LocalControl;
import br.unicap.eticket.control.validacoes.ValidaDados;
import br.unicap.eticket.dao.AdminDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.excecoes.SenhaInvalidaException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.usuarios.Admin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminControl extends UsuarioControl implements BaseControl<Admin> {

    private AdminDAO dao = new AdminDAO();

    /**
     * Cadastro de um Admin
     *
     * @param adm
     * @throws DadosRepetidosException
     */
    @Override
    public void cadastrar(Admin adm) throws DadosRepetidosException {
        LocalDAO localD = new LocalDAO();

        if (super.buscarUser(adm) == null && localD.buscarLocal(adm.getLocalAdministrado()) == null) {
            LocalGenerico admLocal = adm.getLocalAdministrado();
            if (admLocal.getCapa() == null) {
                admLocal.setImagemPadrao();
            }
            admLocal.setAdmin(adm);

            dao.incluirAtomico(adm);
        } else {
            throw new DadosRepetidosException("Usuario ou Local");
        }
    }

    /**
     * Cadastro de Admin com verificação dos dados básicos
     *
     * @param nome
     * @param email
     * @param senha
     * @param local
     * @throws DadosInvalidosException
     * @throws DadosRepetidosException
     * @throws br.unicap.eticket.excecoes.SenhaInvalidaException
     */
    public void cadastrar(String nome, String email, String senha, LocalGenerico local) throws DadosInvalidosException, DadosRepetidosException, SenhaInvalidaException, IOException {
        Admin c = new Admin();
        c.setNome(nome);
        c.setEmail(email);
        c.setSenha(senha);

        if (!ValidaDados.validaEndereco(local.getEndereco())) {
            throw new DadosInvalidosException("Endereço");
        }
        if (!ValidaDados.validaNome(local.getNome())) {
            throw new DadosInvalidosException("Nome do Local");
        }
        c.setLocalAdministrado(local);
        this.cadastrar(c);
    }

    public void validarDadosAdmin(String nome, String email, String senha) throws DadosInvalidosException, SenhaInvalidaException, IOException {
        Admin c = new Admin();
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
    }

    /**
     * Busca de um admin
     *
     * @param adm
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public Admin buscar(Admin adm) throws CadastroInexistenteException {
        Admin busca = dao.buscarAdmin(adm);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Admin");
        }
    }

    /**
     * Atualização com verificação de dados
     *
     * @param novo
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     * @throws br.unicap.eticket.excecoes.DadosInvalidosException
     */
    @Override
    public void atualizar(Admin novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException, DadosInvalidosException {

        Admin busca = this.buscar(novo);

        if (novo.getNome()!=null && !novo.getNome().equals("")) {
            if (ValidaDados.validaNome(novo.getNome())) {
                if (!novo.getNome().equals(busca.getNome())) {
                    busca.setNome(novo.getNome());
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Nome"));
            }
        }
        
        if (novo.getIdade() != 0) {
            if (ValidaDados.validaQuantidade(String.valueOf(novo.getIdade()))) {
                if (novo.getIdade() != busca.getIdade()) {
                    busca.setIdade(novo.getIdade());
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Idade"));
            }
        }

        if (novo.getTelefone()!=null && !novo.getTelefone().equals("")) {
            if (ValidaDados.validaTelefone(novo.getTelefone())) {
                if (!novo.getTelefone().equals(busca.getTelefone())) {
                    busca.setTelefone(novo.getTelefone());
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Telefone"));
            }
        }

        if (novo.getCpf()!=null && !novo.getCpf().equals("")) {
            if (ValidaDados.validaCpf(novo.getCpf())) {
                if (!busca.getCpf().equals(novo.getCpf())) {
                    busca.setCpf(novo.getCpf());
                }
            } else {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Cpf"));
            }
        }

        if (novo.getSenha()!=null && !novo.getSenha().equals("")) {
            try {
                if (ValidaDados.validaSenha(novo.getSenha())) {
                    if (!busca.getSenha().equals(novo.getSenha())) {
                        busca.setSenha(novo.getSenha());
                    }
                }
            } catch (SenhaInvalidaException ex) {
                throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Senha"));
            } catch (IOException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dao.atualizarAtomico(busca);
    }

    /**
     * Remoção de um Admin existente
     *
     * @param adm
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(Admin adm) throws CadastroInexistenteException {
        LocalControl localC = new LocalControl();
        Admin busca = adm.getId() == null ? this.buscar(adm) : adm;

        localC.removerSalas(busca.getLocalAdministrado());
        busca.setLocalAdministrado(null);
        dao.removerAtomico(adm);
    }

    /**
     * Remoção do Local do Admin, sem remove-lo
     *
     * @param adm
     * @throws CadastroInexistenteException
     */
    public void removerLocalAdm(Admin adm) throws CadastroInexistenteException {
        LocalControl localC = new LocalControl();
        dao.abrirTransacao();
        Admin busca = adm.getId() == null ? this.buscar(adm) : adm;
        LocalGenerico auxLocal = busca.getLocalAdministrado();
        if (auxLocal != null) {

            busca.setLocalAdministrado(null);
            dao.atualizar(busca);
            dao.fecharTransacao();

            localC.remover(auxLocal);
        }
    }

    /**
     * Adição de um Local ao Admin que não tem Local cadastrado
     *
     * @param adm
     * @param local
     * @throws CadastroInexistenteException
     */
    public void adicionarLocalAdm(Admin adm, LocalGenerico local) throws CadastroInexistenteException {
        dao.abrirTransacao();
        Admin busca = adm.getId() == null ? this.buscar(adm) : adm;

        local.setImagemPadrao();
        local.setAdmin(busca);

        busca.setLocalAdministrado(local);
        dao.atualizar(busca);
        dao.fecharTransacao();

    }
}
