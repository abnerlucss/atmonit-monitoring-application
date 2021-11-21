package br.com.monilog.atmonit;

import br.com.monilog.atmonit.view.Login;

public class Application {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
