package br.com.monilog.atmonit;

import br.com.monilog.atmonit.view.Login;
import br.com.monilog.atmonit.view.LoginCLI;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SocketException, UnknownHostException, SQLException {

        LoginCLI loginCLI = new LoginCLI();
        loginCLI.loginEmployee();

    }
}
