package br.com.monilog.atmonit;

import Log.Log;
import br.com.monilog.atmonit.view.LoginCLI;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class AplicationCLI {
    public static void main(String[] args) throws SocketException, UnknownHostException, SQLException {
        Log log = new Log();

        log.saveLog("INFO: Iniciando a aplicacao via CLI.");

        LoginCLI loginCLI = new LoginCLI();
        loginCLI.loginEmployee();

    }
}
