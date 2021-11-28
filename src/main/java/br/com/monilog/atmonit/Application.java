package br.com.monilog.atmonit;

import Log.Log;
import br.com.monilog.atmonit.view.Login;
import br.com.monilog.atmonit.view.LoginCLI;

import java.io.IOException;
import java.sql.SQLException;


public class Application {

    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        Log log = new Log();

        log.saveLog("INFO: Iniciando a aplicacao via CLI.");

        LoginCLI loginCLI = new LoginCLI();
        loginCLI.loginEmployee();
    }
}
