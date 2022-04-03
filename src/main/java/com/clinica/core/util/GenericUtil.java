package com.clinica.core.util;

import com.clinica.core.constants.Constantes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GenericUtil {

    public static LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }

    public static String formaDate(LocalDateTime date, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format).withLocale(Constantes.LOCAL_ES);
        return (date != null) ? date.format(dateTimeFormatter) : "Fecha no asignada";
    }

    public static LocalDateTime getCurrentDateByRegion(){
        ZonedDateTime fecha = ZonedDateTime.now(ZoneId.systemDefault());
        return fecha.withZoneSameInstant(ZoneId.of(Constantes.TIME_ZONE)).toLocalDateTime();
    }

}
