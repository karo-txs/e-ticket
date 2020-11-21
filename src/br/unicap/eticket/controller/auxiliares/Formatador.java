/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.eticket.controller.auxiliares;

import br.unicap.eticket.model.auxiliares.Reserva;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class Formatador {

    /**
     * Transforma a lista de reservas em um vetor String com informações
     * adicionais
     *
     * @param reservas
     * @return
     */
    public static String[] formataDadosReservas(List<Reserva> reservas) {
        String dados[];
        dados = new String[reservas.size()];
        int i = 0;
        if (reservas != null) {
            for (Reserva r : reservas) {
                if (!r.getSessao().isAtiva() && r.isAvaliacaoDisp()) {
                    dados[i] = r.toString() + " - Avaliação Disponível!";
                } else {
                    dados[i] = r.toString();
                }
                i++;
            }
        }
        return dados;
    }

    /**
     * Lista os ids de uma determinada lista de reservas
     *
     * @param reservas
     * @return
     */
    public static Long[] listarIDsReservas(List<Reserva> reservas) {
        int i = 0;
        Long[] idReservas = new Long[reservas.size()];
        if (reservas != null) {
            for (Reserva r : reservas) {
                idReservas[i] = r.getId();
                i++;
            }
        }
        return idReservas;
    }

    /**
     * Retorna a lista de IDs de uma lista de sessoes
     *
     * @param sessoes
     * @return Long[]
     */
    public static Long[] listarIDsSessao(List<Sessao> sessoes) {
        Long[] idSessoes = new Long[sessoes.size()];
        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                idSessoes[i] = s.getId();
            }
            i++;
        }
        return idSessoes;
    }

    public static Sessao[] converterListEmArray(List<Sessao> sessoes) {
        Sessao[] dados = new Sessao[sessoes.size()];
        int i = 0;
        for (Sessao s : sessoes) {
            dados[i] = s;
            i++;
        }
        return dados;
    }

    /**
     * Transforma uma lista de sessoes em um vetor String com seus respectivos
     * dados
     *
     * @param sessoes
     * @return String[]
     */
    public static String[] formataDadosSessao(List<Sessao> sessoes) {
        String[] dadosFormatados;
        dadosFormatados = new String[sessoes.size()];

        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                dadosFormatados[i] = s.toString();
            }
            i++;
        }
        return dadosFormatados;
    }

    /**
     * Transforma uma lista de sessoes em um vetor String com seus respectivos
     * dados abreviados
     *
     * @param sessoes
     * @return String[]
     */
    public static String[] formataDadosAbreviados(List<Sessao> sessoes) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        String[] dadosFormatados;
        dadosFormatados = new String[sessoes.size()];

        int i = 0;
        for (Sessao s : sessoes) {
            if (s.isAtiva()) {
                dadosFormatados[i] = s.getSala().getTipoSala().toString() + " | " + s.getSala().getNome() + " | "
                        + df.format(s.getDataInicial().getTime());
            }
            i++;
        }
        return dadosFormatados;
    }

}
