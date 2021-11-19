/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monilog.atmonit.view;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author kened
 */
public class Log {
      static FileWriter arquivo;
    
     public static void logOperation()throws IOException{
        
        //Criando diretorio
        //File file = new File("Diretorio");
        //Criando diretorio
        // file.mkdir();
        
        //Excluindo Diretorio
        //file.delete();
        
        //Gerando arquivo
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        arquivo = new FileWriter("C:\\Users\\kened\\Desktop\\Atmonit-API\\atmonit-monitoring-application\\src" + timeStamp + ".txt");
        
    }
     
     public static void logClose()throws IOException{
         arquivo.close();
     }
    
     public static void logWriter(String msg)throws IOException{
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.printf(msg);
     }   
   
}
