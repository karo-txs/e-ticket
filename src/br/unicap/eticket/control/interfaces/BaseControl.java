package br.unicap.eticket.control.interfaces;

import br.unicap.eticket.excecoes.AtualizacaoMalSucedidaException;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.excecoes.DadosRepetidosException;

public interface BaseControl<T> {
    public abstract void cadastrar(T obj) throws DadosRepetidosException, DadosInvalidosException,CadastroInexistenteException;
    public abstract void atualizar(T obj) throws CadastroInexistenteException, AtualizacaoMalSucedidaException, DadosInvalidosException;
    public abstract T buscar(T obj) throws CadastroInexistenteException;
    public abstract void remover(T obj) throws CadastroInexistenteException;
}
