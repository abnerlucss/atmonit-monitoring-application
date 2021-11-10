package br.com.monilog.atmonit.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDateTime {

    public String formatDateTimeSQL(){
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String localDateTime = dtf5.format(LocalDateTime.now());

        return localDateTime;
    }

}
