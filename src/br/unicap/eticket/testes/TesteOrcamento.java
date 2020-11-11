package br.unicap.eticket.testes;

import br.unicap.eticket.model.auxiliares.Endereco;
import br.unicap.eticket.controller.financeiro.Orcamento;
import br.unicap.eticket.controller.locais.LocalController;
import br.unicap.eticket.controller.usuarios.ClienteController;
import br.unicap.eticket.dao.ClienteDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;
import br.unicap.eticket.model.locais.Cinema;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.entretenimentos.Filme;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locaisAuxiliares.TiposDeSala;
import br.unicap.eticket.model.usuarios.Cliente;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteOrcamento {
    public static void main(String[] args) throws CadastroInexistenteException{
        LocalController tC = new LocalController();
        
        //Considerando a existencia de:
        LocalDAO localC = new LocalDAO();
        LocalGenerico cine1 = localC.buscarPorId(1L);
        
        Filme filme2 = new Filme("40 Dias - O Milagre da Vida");
        Sala sala2 = new Sala(cine1,TiposDeSala.BISTRO, "SalaA");
        Sessao sessao1 = new Sessao(cine1,sala2,"Sessao1");
        
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2020);
        data.set(Calendar.MONTH, 11);
        data.set(Calendar.DAY_OF_MONTH, 9);
        
        ClienteController cc = new ClienteController();
        Cliente c = cc.buscar(new Cliente("kah@hotmail.com","ka"));
        try {
            c.fazerReserva(sessao1, "A3");
        } catch (DadosRepetidosException ex) {
            System.out.println(ex);
        } catch (DadosInvalidosException ex) {
            System.out.println(ex);
        }
        
        
        //Fazendo orçamentos
        LocalGenerico cine = tC.buscar(cine1);
        Orcamento o = new Orcamento(cine); //criando orcamento do cinema
        
        double orcamentoDia = o.orcamentoTotalDia(data);
        System.out.println("Orçamento do dia="+orcamentoDia);
        
        double orcamentoDiaFilme = o.orcamentoTotalDia(filme2, data);
        System.out.println("Orçamento do filme="+orcamentoDiaFilme);
        
        double orcamentoDiaSala = o.orcamentoTotalDia(sala2, data);
        System.out.println("Orçamento da sala="+orcamentoDiaSala);
        /*
        double orcamentoDiaSessao = o.orcamentoTotalDia(sessao1, data);
        System.out.println("Orçamento da sessao="+orcamentoDiaSessao);
        */
        System.out.println("---------");
        Double ex = o.orcamentoTotalDia2(sala2, data);
        System.out.println(ex);
        
    }
}
