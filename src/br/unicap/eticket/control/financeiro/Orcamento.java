package br.unicap.eticket.control.financeiro;

import br.unicap.eticket.control.auxiliares.SalaControl;
import br.unicap.eticket.control.auxiliares.SessaoControl;
import br.unicap.eticket.dao.EntreterimentoDAO;
import br.unicap.eticket.dao.LocalDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Entretenimento;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import br.unicap.eticket.model.locaisAuxiliares.TiposDeSala;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Orcamento implements Serializable {
    //NÃO IMPLEMENTADO//
    private LocalGenerico local;
    private LocalDAO dao;
    private EntreterimentoDAO entD;
    private SalaControl salaC;
    private SessaoControl sessaoC;

    public Orcamento() {
    }

    public Orcamento(LocalGenerico local) {
        this.local = local;
        dao = new LocalDAO();
        entD = new EntreterimentoDAO();
        salaC = new SalaControl();
        sessaoC = new SessaoControl();
    }

    public double orcamentoTotalDia(Calendar data) {
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        List<Double> aux = dao.consultarValores("ganhosPorDia", "local", local,
                "data", d);

        return somar(aux);
    }

    public double orcamentoTotalDia(Entretenimento ent, Calendar data) {
        Entretenimento e = entD.buscarEntreterimento(ent.getNome());
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        List<Double> aux = dao.consultarValores("ganhosPorEntreterimentoNoDia", "local", local,
                "entreterimento", e,
                "data", d);
        return somar(aux);
    }

    public double orcamentoTotalDia(Sala sala, Calendar data) throws CadastroInexistenteException {
        Sala s = salaC.buscar(local.getId() + "-" + sala.getNome());
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        List<Double> aux = dao.consultarValores("ganhosPorSalaNoDia", "local", local,
                "sala", s,
                "data", d);
        return somar(aux);
    }
    
    public Double orcamentoTotalDia2(Sala sala, Calendar data) throws CadastroInexistenteException {
        Sala s = salaC.buscar(local.getId() + "-" + sala.getNome());
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        Double aux = (Double)dao.somarValores("ganhosPorSalaNoDia2", "local", local,
                "sala", s,
                "data", d);
        return aux;
        //return somar(aux);
    }

    public double orcamentoTotalDia(TiposDeSala tipoSala, Calendar data) {
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        List<Double> aux = dao.consultarValores("ganhosPorTipoDeSalaNoDia", "local", local,
                "tipoSala", tipoSala,
                "data",d);
        return somar(aux);
    }

    public double orcamentoTotalDia(Sessao sessao, Calendar data) throws CadastroInexistenteException {
       // Sessao buscaSessao = sessao.getId()==null  ? sessaoC.buscar(sessao) : sessao;
        
        Sessao s = sessaoC.buscar(local.getId() + "-" + sessao.getSala().getNome() + ":" + sessao.getNome());
        String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);

        List<Double> aux = dao.consultarValores("ganhosPorSessaoNoDia", "local", local,
                "sessao", s,
                "data", d);
        return somar(aux);
    }
    //TABELA DE ORÇAMENTOS
/*
    public HashMap<Calendar, Double> tabelaOrcamento(){
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(Calendar.YEAR, 2020);
        dataAux.set(Calendar.MONTH, 1);
        dataAux.set(Calendar.DATE, 1);
        
        HashMap<Calendar,Double> tabela = new HashMap<>();
        
        tabela.put(dataAux, this.orcamentoTotalDia(dataAux));
        dataAux.add(Calendar.DATE, 1);
        
        return tabela;
     }*/
    
    //ORÇAMENTOS TOTAIS
    public double orcamentoTotal() {
        List<Double> aux = dao.consultarValores("ganhosDoLocal", "local", local);
        return somar(aux);
    }

    public double orcamentoTotal(Entretenimento ent) {
        List<Double> aux = dao.consultarValores("ganhosTotaisDoEntreterimento", "local", local,
                "ent", ent);
        return somar(aux);
    }

    public double orcamentoTotal(Sala sala) {
        List<Double> aux = dao.consultarValores("ganhosTotaisDaSala", "local", local,
                "sala", sala);
        return somar(aux);
    }

    public double orcamentoTotal(TiposDeSala tipoSala) {
        List<Double> aux = dao.consultarValores("ganhosTotaisPorTipoSala", "local", local,
                "tipoSala", tipoSala);
        return somar(aux);
    }

    //OUTROS
    private double somar(List<Double> valores) {
        double soma = 0;
        for (Double val : valores) {
            soma += val;
        }
        return soma;
    }
}
