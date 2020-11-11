package br.unicap.eticket.model.locais;

import br.unicap.eticket.dao.AuditorioDAO;
import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Admin;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@DiscriminatorValue("3")
@Table(name = "auditorios")
public class Auditorio extends LocalGenerico {

    @OneToOne
    private Sala sala;

    public Auditorio() {
    }

    public Auditorio(Admin admin, String nome, Endereco endereco, String email, String telefone, String redeSocial_facebook, String redeSocial_instragam) {
        super(admin, nome, endereco, email, telefone, redeSocial_facebook, redeSocial_instragam);
    }

    public Auditorio(Admin admin, String nome, Endereco endereco, byte[] capa) {
        super(admin, nome, endereco, capa);
    }

    public Auditorio(Admin admin, String nome, Endereco endereco) {
        super(admin, nome, endereco);
    }

    public Auditorio(String nome, Endereco endereco) {
        super(nome, endereco);
    }
    
   @Override
    public void setImagemPadrao() {
       this.inserirCapa("src\\br\\unicap\\eticket\\imagens\\locais\\CinemaPadrao.png");
       this.inserirBanner("src\\imagensRework\\BannerPadraoCinema.png");
    }
    
    @Override
    public void inserirCapaESalvar(String urlCapa){
        AuditorioDAO cineD = new AuditorioDAO();
       Auditorio busca = this.getId() == null ? cineD.buscarAuditorio(this) : this;
        
        busca.inserirCapa(urlCapa);
        cineD.atualizarAtomico(busca);
    }
    
    @Override
    public void inserirBannerESalvar(String urlCapa){
        AuditorioDAO cineD = new AuditorioDAO();
        Auditorio busca = this.getId() == null ? cineD.buscarAuditorio(this) : this;
        
        busca.inserirBanner(urlCapa);
        cineD.atualizarAtomico(busca);
    }
    
    @Override
    public List<Sala> getSalas(){
        AuditorioDAO cineD = new AuditorioDAO();
        SalaDAO salaD = new SalaDAO();
        Auditorio busca = this.getId() == null ? cineD.buscarAuditorio(this) : this;
        List<Sala> salas =  salaD.consultar("salasDoLocal", "id", busca.getId());
        List<Sala> result = new LinkedList<>();
        for(Sala s: salas){
            if(s.isAtiva()){
                result.add(s);
            }
        }
        return result;
    }
    
    public void setSala(Sala s) {
        this.sala = s;
    }
    
    @Override
    public List<Sessao> getSessoes(){
        AuditorioDAO cineD = new AuditorioDAO();
        SessaoDAO sessaoD = new SessaoDAO();
        Auditorio busca = this.getId() == null ? cineD.buscarAuditorio(this) : this;
        List<Sessao> sessoes = sessaoD.consultar("sessoesDoLocal", "id", busca.getId());
        List<Sessao> result = new LinkedList<>();
        for(Sessao s: sessoes){
            if(s.isAtiva()){
                result.add(s);
            }
        }
        
        return result;
    } 
}
