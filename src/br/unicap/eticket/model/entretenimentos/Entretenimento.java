package br.unicap.eticket.model.entretenimentos;

import br.unicap.eticket.controller.auxiliares.Conversor;
import br.unicap.eticket.dao.EntreterimentoDAO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CATEGORIA", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "entretenimentos")
public abstract class Entretenimento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int duracao;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @Column(nullable = false)
    private double nota;
    
    private int qtdeEspectadores;
    
    @Column
    private Classificacao classificacao;

    @Lob
    @Column(name = "ent_capa", columnDefinition = "mediumblob")
    private byte[] capa;
    
    public Entretenimento() {
    }
    
    public Entretenimento(String nome) {
        this.nome=nome;
    }
    
    public Entretenimento(String nome, int duracao, String sinopse) {
        this.nome = nome;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.nota = -1; //sem classificação
        this.qtdeEspectadores=0;
    }
    
    public Entretenimento(String nome, int duracao, String sinopse, byte[] capa) {
        this(nome,duracao,sinopse);
        this.capa = capa;
    }

    public Entretenimento(String nome, int duracao, Classificacao classificacao,String sinopse) {
        this(nome,duracao,sinopse);
        this.classificacao = classificacao;
    }

     public void receberNota(double nota){
        EntreterimentoDAO dao = new EntreterimentoDAO();
        dao.abrirTransacao();
        
        Entretenimento ent = this.getId()==null ? dao.buscarEntreterimento(this.getNome()) : this;
        ent.somarEspectador();
        if(ent.getNota()==-1) ent.adicaoDeNota(nota+1);
        else ent.adicaoDeNota(nota);
        dao.atualizar(ent);
        
        dao.fecharTransacao();
    }
    
    private void adicaoDeNota(double nota){
        this.nota = (this.nota+nota)/this.qtdeEspectadores;
    }
    
    private void somarEspectador(){
        this.qtdeEspectadores++;
    }

     public void inserirCapa(String urlCapa) {
        this.setCapa(Conversor.converterImagemEmByte(urlCapa));
    }

    public void inserirCapaESalvar(String urlCapa){
        EntreterimentoDAO cineD = new EntreterimentoDAO();
        Entretenimento busca = this.getId() == null ? cineD.buscarEntreterimento(this.getNome()) : this;
        
        busca.inserirCapa(urlCapa);
        cineD.atualizarAtomico(busca);
    }
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getQtdeEspectadores() {
        return qtdeEspectadores;
    }

    public void setQtdeEspectadores(int qtdeEspectadores) {
        this.qtdeEspectadores = qtdeEspectadores;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    public abstract String getDiretor();
    
    @Override
    public String toString() {
        return "Entreterimento{" + "id=" + id + ", nome=" + nome +", duracao=" + duracao + ", sinopse=" + sinopse + ", nota=" + nota + ", qtdeEspectadores=" + qtdeEspectadores + ", capa=" + capa + '}';
    }
    
}
