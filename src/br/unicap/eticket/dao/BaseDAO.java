package br.unicap.eticket.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public abstract class BaseDAO<T> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("eticket-jpa");
        } catch (Exception e) {
            throw e;
        }
    }

    public BaseDAO() {
        this(null);
    }

    public BaseDAO(Class<T> obj) {
        em = emf.createEntityManager();
        this.classe = obj;
    }

    /**
     * Abrindo Transação com o Banco
     * @return
     */
    public BaseDAO<T> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    /**
     * Fechando Transação com o Banco
     * @return
     */
    public BaseDAO<T> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    /**
     * Adição de um objeto ao banco
     * @param obj
     * @return
     */
    public BaseDAO<T> incluir(T obj) {
        em.persist(obj);
        return this;
    }

    /**
     * Adição de um objeto no banco fazendo a abertura e o fechamento de transação
     * @param obj
     * @return
     */
    public BaseDAO<T> incluirAtomico(T obj) {
        return this.abrirTransacao().incluir(obj).fecharTransacao();
    }

    /**
     * Retorna todos os elementos de acordo com a quantidade pedida
     * @param qtdeRegistros
     * @param delocamento
     * @return
     */
    public List<T> obterTodos(int qtdeRegistros, int delocamento) {
        if (this.classe == null) {
            throw new UnsupportedOperationException("Classe nula");
        }
        String jpql = "select e from " + this.classe.getName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, this.classe);
        query.setMaxResults(qtdeRegistros);
        query.setFirstResult(delocamento);
        return query.getResultList();
    }

    /**
     * Retorna por padrao os 10 primeiros elementos
     * @return
     */
    public List<T> obterTodos() {
        return this.obterTodos(10, 0);
    }

    /**
     * Busca um objeto por seu id
     * @param id
     * @return
     */
    public T buscarPorId(long id) {
        try {
            return em.find(this.classe, id);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Consulta a partir de uma query, com os devidos parametros
     * @param nomeConsulta
     * @param params
     * @return
     */
    public List<T> consultar(String nomeConsulta, Object... params) {
        TypedQuery<T> query = em.createNamedQuery(nomeConsulta, classe);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }
        return query.getResultList();
    }
    
    /**
     * Consulta retornando valores numericos
     * @param nomeConsulta
     * @param params
     * @return
     */
    public List<Double> consultarValores(String nomeConsulta, Object... params) {
        TypedQuery<Double> query = em.createNamedQuery(nomeConsulta, Double.class);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }
        return (List<Double>) query.getResultList();
    }
    
     public Number somarValores(String nomeConsulta, Object... params) {
        TypedQuery<Long> query = em.createNamedQuery(
            nomeConsulta,
            Long.class);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }
        return (Number) query.getSingleResult().doubleValue();
    }

    /**
     * Remoção de um objeto do banco
     * @param obj
     */
    public void remover(T obj) {
        try {
            em.remove(obj);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Remoção de um objeto "solto" do banco
     * @param obj
     */
    public void removerDetached(T obj){
        em.remove(em.contains(obj) ? obj : em.merge(obj));
    }

    /**
     * Remoção de um objeto fazendo a abertura e o fechamento de transação
     * @param obj
     */
    public void removerAtomico(T obj) {
        this.abrirTransacao();
        this.remover(obj);
        this.fecharTransacao();
    }

    /**
     * Atualização de um obj do banco
     * @param obj
     */
    public void atualizar(T obj) {
        try {
            em.merge(obj);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Atualização de um objeto do banco fazendo a abertura e o fechamento de transação
     * @param obj
     */
    public void atualizarAtomico(T obj) {
        this.abrirTransacao();
        this.atualizar(obj);
        this.fecharTransacao();
    }
    
    /**
     * Permite a criação de uma Query Nativa
     * @param query
     * @param classe
     * @return Query
     */
    public Query criarQueryNativa(String query, T classe){
        return  em.createNativeQuery( query, classe.getClass()); 
    }
}
