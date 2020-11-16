package br.unicap.eticket.controller.locais;

import br.unicap.eticket.controller.localAuxiliares.SalaController;
import br.unicap.eticket.controller.interfaces.BaseControl;
import br.unicap.eticket.controller.usuarios.AdminController;
import br.unicap.eticket.controller.auxiliares.ValidaDados;
import br.unicap.eticket.controller.interfaces.FunctionSimple;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locais.Auditorio;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locais.Teatro;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.usuarios.Admin;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalController implements BaseControl<LocalGenerico> {

    private LocalDAO dao;

    public LocalController() {
        this.dao = new LocalDAO();
    }

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
        ExecutorService es = Executors.newCachedThreadPool();
        AdminController admDao = new AdminController();

        if (!ValidaDados.validaEndereco(local.getEndereco())) {
            throw new DadosInvalidosException("Endereço");
        }

        if (!ValidaDados.validaNome(local.getNome())) {
            throw new DadosInvalidosException("Nome do Local");
        }

        dao.abrirTransacao();

        Admin adm = null;
        LocalGenerico buscaLocal = null;

        try {
            adm = es.submit(() -> admDao.buscar(local.getAdmin())).get();
            buscaLocal = es.submit(() -> dao.buscarLocal(local)).get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (buscaLocal == null && adm != null) {
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
        ExecutorService es = Executors.newCachedThreadPool();
        SalaController sd = new SalaController();
        if (local instanceof Teatro) {
            Teatro busca = null;
            Sala buscaSala = null;

            try {
                busca = es.submit(() -> local.getId() == null ? (Teatro) LocalController.this.buscar(local) : (Teatro) local).get();
                buscaSala = es.submit(() -> sala.getId() == null ? sd.buscar(sala) : sala).get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (buscaSala != null && busca != null) {
                busca.setSala(buscaSala);
                dao.atualizarAtomico(busca);
            }
        } else {
            Auditorio busca = null;
            Sala buscaSala = null;

            try {
                busca = es.submit(() -> local.getId() == null ? (Auditorio) LocalController.this.buscar(local) : (Auditorio) local).get();
                buscaSala = es.submit(() -> sala.getId() == null ? sd.buscar(sala) : sala).get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (buscaSala != null && busca != null) {
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

    /**
     * Retorna um local pelo id
     *
     * @param id
     * @return LocalGenerico
     * @throws CadastroInexistenteException
     */
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
     *
     * @return
     */
    public List<LocalGenerico> todosAuditorios() {
        List<LocalGenerico> locais = dao.consultar("todosAuditorios");
        return locais;
    }

    public List<LocalGenerico> todosLocais(Class c) {
        List<LocalGenerico> locais = null;
        if (c.equals(Cinema.class)) {
            FunctionSimple<List<LocalGenerico>> function = () -> {
                return dao.consultar("todosCinemas");
            };
            locais = function.apply();
        } else if (c.equals(Teatro.class)) {
            FunctionSimple<List<LocalGenerico>> function = () -> {
                return dao.consultar("todosTeatros");
            };
            locais = function.apply();
        } else if (c.equals(Auditorio.class)) {
            FunctionSimple<List<LocalGenerico>> function = () -> {
                return dao.consultar("todosAuditorios");
            };
            locais = function.apply();
        }
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

        if (ValidaDados.validaNome(novo.getNome())) {
            busca.setNome(novo.getNome());
        }

        if (ValidaDados.validaEmail(novo.getEmail())) {
            busca.setEmail(novo.getEmail());
        }
        if (ValidaDados.validaTelefone(novo.getEmail())) {
            busca.setTelefone(novo.getTelefone());
        }

        if (ValidaDados.validaSite(novo.getRedeSocial_facebook())) {
            busca.setRedeSocial_facebook(novo.getRedeSocial_facebook());
        }

        if (ValidaDados.validaSite(novo.getRedeSocial_instagram())) {
            busca.setRedeSocial_instragam(novo.getRedeSocial_instagram());
        }
        if (novo.getSobre() != null) {
            if (!novo.getSobre().equals("") && !novo.getSobre().
                    equalsIgnoreCase(busca.getSobre())) {
                busca.setSobre(novo.getSobre());
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
            salas.forEach((s) -> {
                salaC.remover(s);
            });
        }
    }

    /**
     * Atualiza a chave de identificação secundária (sendo a primaria o ID, que
     * é identificado diretamente pelo BD)
     *
     * @param local
     * @param chave
     * @throws CadastroInexistenteException
     * @throws AtualizacaoMalSucedidaException
     */
    public void atualizarChave(LocalGenerico local, Object chave) throws CadastroInexistenteException, AtualizacaoMalSucedidaException {
        LocalGenerico busca = local.getId() == null ? this.buscar(local) : local;
        if (ValidaDados.validaEndereco((Endereco) chave)) {
            busca.atualizarEnd((Endereco) chave);
        } else {
            throw new AtualizacaoMalSucedidaException(new DadosInvalidosException("Endereço"));
        }
    }

    /**
     * Inserção de um banner no local (homepageLocal)
     *
     * @param local
     * @param caminho
     */
    public void inserirBanner(LocalGenerico local, String caminho) {
        if (caminho != null && !caminho.equals("")) {
            local.inserirBannerESalvar(caminho);
        }
    }

    /**
     * Inserção da capa do local
     *
     * @param local
     * @param caminho
     */
    public void inserirCapa(LocalGenerico local, String caminho) {
        if (caminho != null && !caminho.equals("")) {
            local.inserirCapaESalvar(caminho);
        }
    }
}
