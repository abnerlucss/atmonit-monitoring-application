package br.com.monilog.atmonit;

import br.com.monilog.atmonit.service.FuncionarioService;
import br.com.monilog.atmonit.service.RegistroComponenteService;
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

        FuncionarioService funcionarioService = new FuncionarioService();
        TerminalService terminalService = new TerminalService();

        Integer idEmpresa = funcionarioService.loginFuncionario();
        Integer idTerminal = terminalService.checkTerminalRegister(idEmpresa);
        System.out.println(idTerminal);
        new RegistroComponenteService(idTerminal);
    }
}
