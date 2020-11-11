package br.unicap.eticket.controller.auxiliares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Gerador {

    public static String[] geraSemana() {
        Locale.setDefault(new Locale("pt", "BR"));
        Calendar cal = Calendar.getInstance();
        Date dt = cal.getTime();
        DateFormat diaSemana;
        DateFormat diaMes = new SimpleDateFormat("dd/MM");

        String[] semana = new String[7];
        semana[0] = "<html><center>HOJE " + diaMes.format(dt);
        for (int i = 1; i <= 6; i++) {
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_WEEK, i);

            dt = cal.getTime();
            diaSemana = new SimpleDateFormat("EEE");
            diaMes = new SimpleDateFormat("dd/MM");
            semana[i] = diaSemana.format(dt).toUpperCase() + " " + diaMes.format(dt);
        }

        return semana;
    }
}
