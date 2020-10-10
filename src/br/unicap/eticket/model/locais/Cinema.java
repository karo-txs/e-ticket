package br.unicap.eticket.model.locais;

import br.unicap.eticket.dao.CinemaDAO;
import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Admin;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
@Table(name = "cinemas")
public class Cinema extends LocalGenerico {
   
    public Cinema() { }

    public Cinema(Admin admin, String nome, Endereco endereco, byte[] capa) {
        super(admin, nome, endereco, capa);
    }

    public Cinema(Admin admin, String nome, Endereco endereco) {
        super(admin, nome, endereco);
    }
    
     public Cinema(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    @Override
    public void setImagemPadrao() {
       this.inserirCapa("src\\br\\unicap\\eticket\\imagens\\locais\\CinemaPadrao.png");
       this.inserirBanner("src\\imagensRework\\BannerPadraoCinema.png");
    }
    
    @Override
    public void inserirCapaESalvar(String urlCapa){
        CinemaDAO cineD = new CinemaDAO();
        Cinema busca = this.getId() == null ? cineD.buscarCinema(this) : this;
        
        busca.inserirCapa(urlCapa);
        cineD.atualizarAtomico(busca);
    }
    
    @Override
    public void inserirBannerESalvar(String urlCapa){
        CinemaDAO cineD = new CinemaDAO();
        Cinema busca = this.getId() == null ? cineD.buscarCinema(this) : this;
        
        busca.inserirBanner(urlCapa);
        cineD.atualizarAtomico(busca);
    }
    
    @Override
    public List<Sala> getSalas(){
        CinemaDAO cineD = new CinemaDAO();
        SalaDAO salaD = new SalaDAO();
        Cinema busca = this.getId() == null ? cineD.buscarCinema(this) : this;
        return salaD.consultar("salasDoLocal", "id", busca.getId());
    }
    
    @Override
    public List<Sessao> getSessoes(){
        CinemaDAO cineD = new CinemaDAO();
        SessaoDAO sessaoD = new SessaoDAO();
        Cinema busca = this.getId() == null ? cineD.buscarCinema(this) : this;
        return sessaoD.consultar("sessoesDoLocal", "id", busca.getId());
    }
}
