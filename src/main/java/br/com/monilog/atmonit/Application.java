package br.com.monilog.atmonit;

import br.com.monilog.atmonit.service.ComponentRegistrationService;
import br.com.monilog.atmonit.service.EmployeeService;
import br.com.monilog.atmonit.service.TerminalService;

import java.net.SocketException;
import java.net.UnknownHostException;

public class Application {

    public static void main(String[] args) throws SocketException, UnknownHostException {

        EmployeeService employeeService = new EmployeeService();
        TerminalService terminalService = new TerminalService();

        Integer idCompany = employeeService.loginFuncionario();
        Integer idTerminal = terminalService.checkTerminalRegister(idCompany);

        new ComponentRegistrationService(idTerminal);
    }
}
