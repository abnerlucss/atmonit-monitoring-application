package br.com.monilog.atmonit;

import br.com.monilog.atmonit.view.Login;

import static br.com.monilog.atmonit.util.Log.setupLogger;

public class Application {

    public static void main(String[] args) {
        setupLogger();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
