package br.unicap.eticket.testes;

import br.unicap.eticket.control.usuarios.AdminControl;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.Teatro;
import br.unicap.eticket.model.usuarios.Admin;

public class CadastroLocais {

    public static void main(String[] args) throws DadosRepetidosException, CadastroInexistenteException {
        //CINEMAS
        Endereco end1 = new Endereco("BR", "PE", "Recife", "Pina", "AVENIDA REPUBLICA DO LIBANO", "251");
        Endereco end2 = new Endereco("BR", "PE", "Jaboatão dos Guararapes", "Piedade", "AVENIDA BARRETO DE MENEZES", "800");
        Endereco end3 = new Endereco("BR", "PE", "Paulista", "Centro", "ROD. PE-15", "242");
        Endereco end4 = new Endereco("BR", "PE", "Camaragibe", "Vila da Fabríca", "RUA MANOEL HONORATO DA COSTA", "555");
        Endereco end5 = new Endereco("BR", "PE", "Recife", "Boa Viagem", "RUA PADRE CARAPUCEIRO", "777");

        Cinema cine1 = new Cinema("Cinemark Shopping Rio Mar", end1);
        Cinema cine2 = new Cinema("Cinepolis Shopping Guararapes", end2);
        Cinema cine3 = new Cinema("CineSystem Paulista", end3);
        Cinema cine4 = new Cinema("MovieMax Camará", end4);
        Cinema cine5 = new Cinema("UCI Kinoplex Delux Recife", end5);

        Admin adm1 = new Admin("admCinemark", "adm@Cinemark.com", "cine123", cine1);
        Admin adm2 = new Admin("admCinepolis", "adm@Cinepolis.com", "cine123", cine2);
        Admin adm3 = new Admin("admCineSystem", "adm@CineSystem.com", "cine123", cine3);
        Admin adm4 = new Admin("admMovieMax", "adm@MovieMax.com", "cine123", cine4);
        Admin adm5 = new Admin("admKinoplex", "adm@Kinoplex.com", "cine123", cine5);

        AdminControl admC = new AdminControl();
        admC.cadastrar(adm1);
        admC.cadastrar(adm2);
        admC.cadastrar(adm3);
        admC.cadastrar(adm4);
        admC.cadastrar(adm5);
        
        cine1.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Cinemark.png");
        
        cine2.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Cinépolis.png");
        
        cine3.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\CineSystem.png");
        
        cine4.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\MovieMax.png");
        
        cine5.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\UCI Kinoplex.png");

        //TEATROS
        end1 = new Endereco("BR", "PE", "Recife", "Pina", "Rua Estudante Jeremias Bastos", "s/n");
        end2 = new Endereco("BR", "PE", "Olinda", "Salgadinho", "Avenida Professor Andrade Bezerra", "s/n");
        end3 = new Endereco("BR", "PE", "Recife", "Boa Viagem", "Avenida Boa Viagem", "s/n");
        end4 = new Endereco("BR", "PE", "Recife", "Pina", "Avenida República do Líbano", "251 / Piso L4");
        end5 = new Endereco("BR", "PE", "Recife", "Santo Antonio", "Praça da República", "s/n");

        Teatro teatro1 = new Teatro("Teatro Barreto Júnior", end1);//400 lugares
        Teatro teatro2 = new Teatro("Teatro Guararapes", end2);//2396
        Teatro teatro3 = new Teatro("Teatro Luiz Mendonça - Parque Dona Lindu", end3);//587
        Teatro teatro4 = new Teatro("Teatro Rio Mar", end4);//696
        Teatro teatro5 = new Teatro("Teatro Santa Isabel", end5);//570

        adm1 = new Admin("admBarreto", "adm@BarretoJunior.com", "teatro123", teatro1);
        adm2 = new Admin("admGuararapes", "adm@Guararapes.com", "teatro123", teatro2);
        adm3 = new Admin("admLuizMendonca", "adm@LuizMendonca.com", "teatro123", teatro3);
        adm4 = new Admin("admRioMar", "adm@RioMar.com", "teatro123", teatro4);
        adm5 = new Admin("admSantaIsabel", "adm@SantaIsabel.com", "teatro123", teatro5);
        
        admC.cadastrar(adm1);
        admC.cadastrar(adm2);
        admC.cadastrar(adm3);
        admC.cadastrar(adm4);
        admC.cadastrar(adm5);
        
        teatro1.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Barreto Junior.png");
        teatro2.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Guararapes.png");
        teatro3.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Luiz Mendonça.png");
        teatro4.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Rio Mar.png");
        teatro5.inserirCapaESalvar("src\\br\\unicap\\eticket\\imagens\\locais\\Santa Isabel.png");
        /*
        SalaControl salaC = new SalaControl();
        Sala sala1 = new Sala(cine1,TiposDeSala.BISTRO, "SalaA", 5, 5, 30);
        salaC.cadastrar(sala1);
        
        SessaoControl sesC = new SessaoControl();
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.set(Calendar.YEAR, 2020);
        dataInicial.set(Calendar.MONTH, 9);
        dataInicial.set(Calendar.DATE, 10);
        dataInicial.set(Calendar.HOUR, 1);
        dataInicial.set(Calendar.MINUTE, 0);
        dataInicial.set(Calendar.SECOND, 0);
        Filme filme1 =  new Filme("40 Dias - O Milagre da Vida", "Cary Solomon, Chuck Konzelman", 110, "Basead");
       
        Sessao sessao1 = new Sessao(cine1,sala1,"Sessao1",dataInicial,filme1);
        sesC.cadastrar(sessao1);*/
    }
}
