package Log;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Log {

    List<String> listLog = new ArrayList<>();
    DateTimeFormatter dateLog = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    public static void createFile(String path) throws IOException {
        File file = new File("Logs");
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    public void saveLog(String log) {
        listLog.add(String.format(dateLog.format(LocalDateTime.now()) + " ---->    " + log));
        try {
            writeLog();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeLog() throws IOException {
        File file = new File("log.txt");
//        file.createNewFile();
        FileWriter log = new FileWriter(file, true);

        PrintWriter saveLog = new PrintWriter(log);
        for (String a : listLog) {
            saveLog.println(a);
        }
        log.close();
    }
}

