package br.com.monilog.atmonit;

import Log.Log;
import br.com.monilog.atmonit.view.Login;


public class Application {

    public static void main(String[] args) {
        Log log = new Log();

        log.saveLog("INFO: Iniciando a aplicação via GUI");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
