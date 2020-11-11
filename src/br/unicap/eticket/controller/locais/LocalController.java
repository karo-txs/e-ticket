package br.unicap.eticket.controller.locais;

import br.unicap.eticket.controller.localAuxiliares.SalaController;
import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.usuarios.AdminController;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Teatro;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.usuarios.Admin;
import java.util.List;

public class LocalController implements BaseControl<LocalGenerico> {

    private LocalDAO dao = new LocalDAO();

    /**
     * Cadastra um Local, caso o admin tenha excluido o seu local original, e
     * faz verificações acerca dos dados
     *
     * @param local
     * @throws DadosRepetidosException
     * @throws DadosInvalidosException
     * @throws CadastroInexistenteException
     */
    @Override
    public void cadastrar(LocalGenerico local) throws DadosRepetidosException, DadosInvalidosException, CadastroInexistenteException {
        AdminController admDao = new AdminController();

        if (!ValidaDados.validaEndereco(local.getEndereco())) {
            throw new DadosInvalidosException("Endereço");
        }
        if (!ValidaDados.validaNome(local.getNome())) {
            throw new DadosInvalidosException("Nome do Local");
        }
        dao.abrirTransacao();
        Admin adm = admDao.buscar(local.getAdmin());
        if (adm != null) {
            if (dao.buscarLocal(local) == null) {
                local.setImagemPadrao();
                adm.setLocalAdministrado(local);
                dao.incluir(local);
                try {
                    admDao.atualizar(adm);
                } catch (AtualizacaoMalSucedidaException ex) {
                    throw new DadosInvalidosException(ex.getMessage());
                }
            } else {
                throw new DadosRepetidosException("Local");
            }
        } else {

        }
        dao.fecharTransacao();
    }

    /**
     * Cadastra uma Sala Única OBS: Caso especifico de Teatro, ou locais com
     * apenas uma sala
     *
     * @param local
     * @param sala
     * @throws CadastroInexistenteException
     */
    public void cadastrarSalaUnica(LocalGenerico local, Sala sala) throws CadastroInexistenteException {
        SalaController sd = new SalaController();
        if (local instanceof Teatro) {
            Teatro busca = local.getId() == null ? (Teatro) this.buscar(local) : (Teatro) local;
            Sala buscaSala = sala.getId() == null ? sd.buscar(sala) : sala;
            if (buscaSala != null) {
                busca.setSala(buscaSala);
                dao.atualizarAtomico(busca);
            }
        } else {
            Auditorio busca = local.getId() == null ? (Auditorio) this.buscar(local) : (Auditorio) local;
            Sala buscaSala = sala.getId() == null ? sd.buscar(sala) : sala;
            if (buscaSala != null) {
                busca.setSala(buscaSala);
                dao.atualizarAtomico(busca);
            }
        }

    }

    /**
     * Busca um Local
     *
     * @param local
     * @return
     * @throws CadastroInexistenteException
     */
    @Override
    public LocalGenerico buscar(LocalGenerico local) throws CadastroInexistenteException {
        LocalGenerico busca = dao.buscarLocal(local);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Local");
        }
    }

    public LocalGenerico buscarPorId(Long id) throws CadastroInexistenteException {
        LocalGenerico busca = dao.buscarPorId(id);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Local");
        }
    }

    /**
     * Retorna todos os Teatros Cadastrados
     *
     * @return locais
     */
    public List<LocalGenerico> todosTeatros() {
        List<LocalGenerico> locais = dao.consultar("todosTeatros");
        return locais;
    }

    /**
     * Retorna Todos os Cinemas Cadastrados
     *
     * @return
     */
    public List<LocalGenerico> todosCinemas() {
        List<LocalGenerico> locais = dao.consultar("todosCinemas");
        return locais;
    }

    /**
     * Retorna Todos os Auditorios Cadastrados
     * @return
     */
    public List<LocalGenerico> todosAuditorios() {
        List<LocalGenerico> locais = dao.consultar("todosAuditorios");
        return locais;
    }

    /**
     * Atualização de um Local, com verificações previas
     *
     * @param novo
     * @throws CadastroInexistenteException
     * @throws br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException
     */
    @Override
    public void atualizar(LocalGenerico novo) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        LocalGenerico busca = novo.getId() == null ? this.buscar(novo) : novo;
        if (novo.getNome() != null) {
            if (!novo.getNome().equals("") && !novo.getNome().equalsIgnoreCase(busca.getNome())) {
                if (ValidaDados.validaNome(novo.getNome())) {
                    busca.setNome(novo.getNome());
                } else {
                    throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Nome"));
                }
            }
        }
        if (novo.getEmail() != null) {
            if (!novo.getEmail().equals("") && !novo.getEmail().equalsIgnoreCase(busca.getEmail())) {
                if (ValidaDados.validaEmail(novo.getEmail())) {
                    busca.setEmail(novo.getEmail());
                } else {
                    throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Email"));
                }
            }
        }

        if (novo.getTelefone() != null) {
            if (!novo.getTelefone().equals("") && !novo.getTelefone().equals(busca.getTelefone())) {
                if (ValidaDados.validaTelefone(novo.getTelefone())) {
                    busca.setTelefone(novo.getTelefone());
                } else {
                    throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Telefone"));
                }
            }
        }

        if (novo.getRedeSocial_facebook() != null) {
            if (!novo.getRedeSocial_facebook().equals("") && !novo.getRedeSocial_facebook().
                    equalsIgnoreCase(busca.getRedeSocial_facebook())) {
                if (ValidaDados.validaSite(novo.getRedeSocial_facebook())) {
                    busca.setRedeSocial_facebook(novo.getRedeSocial_facebook());
                } else {
                    throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Facebook"));
                }
            }
        }

        if (novo.getRedeSocial_instragam() != null) {
            if (!novo.getRedeSocial_instragam().equals("") && !novo.getRedeSocial_instragam().
                    equalsIgnoreCase(busca.getRedeSocial_instragam())) {
                if (ValidaDados.validaNickName(novo.getRedeSocial_instragam())) {
                    busca.setRedeSocial_facebook(novo.getRedeSocial_instragam());
                } else {
                    throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Instagram"));
                }
            }
        }
        dao.atualizarAtomico(busca);
    }

    /**
     * Remove um Local juntamante com suas salas
     *
     * @param local
     * @throws CadastroInexistenteException
     */
    @Override
    public void remover(LocalGenerico local) throws CadastroInexistenteException {
        LocalGenerico busca = local.getId() == null ? this.buscar(local) : local;
        this.removerSalas(local);
        dao.removerAtomico(busca);
    }

    /**
     * Remove as Salas de um Local
     *
     * @param local
     * @throws CadastroInexistenteException
     */
    public void removerSalas(LocalGenerico local) throws CadastroInexistenteException {
        SalaController salaC = new SalaController();
        LocalGenerico busca = local.getId() == null ? this.buscar(local) : local;
        List<Sala> salas = busca.getSalas();
        if (busca instanceof Teatro) {
            Teatro localAux = (Teatro) busca;
            localAux.setSala(null);
            dao.atualizarAtomico(localAux);
        }

        if (salas != null) {
            for (Sala s : salas) {
                salaC.remover(s);
            }
        }
    }
}
