package br.unicap.eticket.dao;

import br.unicap.eticket.control.auxiliares.SalaControl;
import br.unicap.eticket.control.locais.LocalControl;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locais.LocalGenerico;
import br.unicap.eticket.model.locaisAuxiliares.Sala;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

public class SessaoDAO extends BaseDAO<Sessao> {

    public SessaoDAO() {
        super(Sessao.class);
    }

    public Sessao buscarSessao(String nome) {
        List<Sessao> sessao = this.consultar("sessaoPorNome", "nome", nome);
        if (sessao.isEmpty()) {
            return null;
        } else {
            return sessao.get(0);
        }
    }

    public Sessao buscarSessao(Sala sala, Calendar Inicio, Calendar fim) throws CadastroInexistenteException {
        List<Sessao> sessoes = this.sessoesPorData(sala, Inicio, fim);
        if (sessoes.isEmpty()) {
            return null;
        } else {
            return sessoes.get(0);
        }
    }

    public List<Sessao> sessoesPorData(Sala sala, Calendar inicio, Calendar fim) throws CadastroInexistenteException {
        SalaControl sc = new SalaControl();
        Sala buscaSala = sala.getId() == null ? sc.buscar(sala) : sala;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1 = df.format(inicio.getTime());
        String data2 = df.format(fim.getTime());

        Query q = super.criarQueryNativa("SELECT * FROM SESSOES WHERE dataFinal between "
                + "'" + data1 + ".000000' and '" + data2 + ".000000';", new Sessao());
        List<Sessao> sessoes = q.getResultList();
        List<Sessao> resultado = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s.getSala().getId().equals(buscaSala.getId())) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Sessao> sessoesPorData(LocalGenerico local, Calendar inicio, Calendar fim) throws CadastroInexistenteException {
        LocalControl lc = new LocalControl();
        LocalGenerico buscaLocal = local.getId() == null ? lc.buscar(local) : local;
        System.out.println("LOCALID"+buscaLocal.getId());
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1 = df.format(inicio.getTime());
        String data2 = df.format(fim.getTime());
        
        Query q = super.criarQueryNativa("SELECT * FROM SESSOES WHERE dataFinal between "
                + "'" + data1 + ".000000' and '" + data2 + ".000000';", new Sessao());
        List<Sessao> sessoes = q.getResultList();
        
        List<Sessao> resultado = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s.getLocal().getId().equals(buscaLocal.getId())) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Sessao> sessoesPassadas(Calendar data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar inicio = Calendar.getInstance();
        inicio.set(Calendar.YEAR, 2000);
        inicio.set(Calendar.MONTH, 0);
        inicio.set(Calendar.DAY_OF_MONTH, 1);

        String data1 = df.format(inicio.getTime());
        String data2 = df.format(data.getTime());

        Query q = super.criarQueryNativa("SELECT * FROM SESSOES WHERE dataFinal between "
                + "'" + data1 + ".000000' and '" + data2 + ".000000';", new Sessao());
        List<Sessao> sessoes = q.getResultList();
        List<Sessao> resultado = new ArrayList<>();

        for (Sessao s : sessoes) {
            resultado.add(s);
        }

        return resultado;
    }

}
