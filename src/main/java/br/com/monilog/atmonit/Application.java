package br.com.monilog.atmonit;

import Log.Log;
import br.com.monilog.atmonit.view.Login;


public class Application {

    public static void main(String[] args) {
        Log log = new Log();

        log.saveLog("INFO: Iniciando a aplicacao via interface grafica.");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
