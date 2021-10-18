package br.com.monilog.atmonit;

import br.com.monilog.atmonit.service.EmployeeService;
import br.com.monilog.atmonit.service.ComponentRegistrationService;
import br.com.monilog.atmonit.service.TerminalService;
import com.github.britooo.looca.api.core.Looca;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        Looca looca = new Looca();
        Scanner userInput = new Scanner(System.in);
        String cep;

        EmployeeService employeeService = new EmployeeService();
        TerminalService terminalService = new TerminalService();

        Integer idCompany = employeeService.loginFuncionario();
        Integer idTerminal = terminalService.checkTerminalRegister(idCompany);

        new ComponentRegistrationService(idTerminal);
    }
}
