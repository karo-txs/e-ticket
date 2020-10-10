package br.unicap.eticket.viewAuxiliares;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Format {

    public static String diaSemana(int incrementar) {

        Calendar cal = Calendar.getInstance();
        Locale.setDefault(new Locale("pt", "BR"));
        cal.add(Calendar.DAY_OF_WEEK, incrementar);

        Date dt = cal.getTime();
        DateFormat diaSemana = new SimpleDateFormat("EEE");
        DateFormat diaMes = new SimpleDateFormat("dd/MM");

        return diaSemana.format(dt).toUpperCase() + " " + diaMes.format(dt);
    }
}
