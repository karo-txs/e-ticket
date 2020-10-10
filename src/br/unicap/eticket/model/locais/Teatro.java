package br.unicap.eticket.model.locais;

import br.unicap.eticket.dao.SalaDAO;
import br.unicap.eticket.dao.SessaoDAO;
import br.unicap.eticket.dao.TeatroDAO;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.usuarios.Admin;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("2")
@Table(name = "teatros")
public class Teatro extends LocalGenerico {

    @OneToOne
    private Sala sala;

    public Teatro() {
    }

    public Teatro(Admin admin, String nome, Endereco endereco, byte[] capa) {
        super(admin, nome, endereco, capa);
    }

    public Teatro(Admin admin, String nome, Endereco endereco) {
        super(admin, nome, endereco);
    }
    
    public Teatro(String nome, Endereco endereco) {
        super(nome, endereco);
    }

    @Override
    public void setImagemPadrao() {
        this.inserirCapa("src\\br\\unicap\\eticket\\imagens\\locais\\TeatroPadrao.png");
        this.inserirBanner("src\\imagensRework\\BannerPadraoTeatro.png");
    }

    @Override
    public void inserirCapaESalvar(String urlCapa) {
        TeatroDAO teaD = new TeatroDAO();
        Teatro busca = this.getId() == null ? teaD.buscarTeatro(this) : this;

        busca.inserirCapa(urlCapa);
        teaD.atualizarAtomico(busca);
    }
    
    @Override
    public void inserirBannerESalvar(String urlCapa) {
        TeatroDAO teaD = new TeatroDAO();
        Teatro busca = this.getId() == null ? teaD.buscarTeatro(this) : this;

        busca.inserirBanner(urlCapa);
        teaD.atualizarAtomico(busca);
    }

    @Override
    public List<Sala> getSalas() {
        TeatroDAO td = new TeatroDAO();
        SalaDAO salaD = new SalaDAO();
        Teatro busca = this.getId() == null ? td.buscarTeatro(this) : this;
        return salaD.consultar("salasDoLocal", "id", busca.getId());
    }

    public void setSala(Sala s) {
        this.sala = s;
    }

    @Override
    public List<Sessao> getSessoes() {
        TeatroDAO td = new TeatroDAO();
        SessaoDAO sessaoD = new SessaoDAO();
        Teatro busca = this.getId() == null ? td.buscarTeatro(this) : this;
        return sessaoD.consultar("sessoesDoLocal", "id", busca.getId());
    }
}
