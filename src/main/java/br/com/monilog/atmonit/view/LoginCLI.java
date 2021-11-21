package br.com.monilog.atmonit.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.monilog.atmonit.dao.EmployeeDAO;
import br.com.monilog.atmonit.dao.TerminalAddressDAO;
import br.com.monilog.atmonit.dao.TerminalDAO;
import br.com.monilog.atmonit.database.SwitchConnection;
import br.com.monilog.atmonit.model.EmployeeLogin;
import br.com.monilog.atmonit.model.Terminal;
import br.com.monilog.atmonit.service.ComponentRegistrationService;
import br.com.monilog.atmonit.service.TerminalService;
import br.com.monilog.atmonit.util.ClientCep;
import br.com.monilog.atmonit.util.HardwareInfo;
import br.com.monilog.atmonit.view.systemtray.TrayClass;
import com.github.britooo.looca.api.core.Looca;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Monilog
 */
public class LoginCLI {


    public LoginCLI() {

    }

    public void loginEmployee() throws SocketException, UnknownHostException, SQLException {
        StringsJframe stringsJframe = new StringsJframe();
        Scanner reader = new Scanner(System.in);

        TerminalAddressDAO terminalAddressDAO = new TerminalAddressDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        TerminalDAO terminalDAO = new TerminalDAO();
        TerminalService terminalService = new TerminalService();
        Looca looca = new Looca();
        EmployeeLogin employeeLogin;

        String empresa, login, senha;
        Integer idEmpresa = null;
        Integer idTerminal = null;

        do {
            System.out.println("Insira o nome da sua empresa:");
            empresa = reader.nextLine();

            System.out.println("Insira o seu login:");
            login = reader.nextLine();

            System.out.println("Insira a sua senha:");
            senha = reader.nextLine();

        employeeLogin = new EmployeeLogin(login, senha, empresa);

        idEmpresa = employeeDAO.loginFuncionario(employeeLogin);

        if (idEmpresa == null){
            System.out.println(stringsJframe.loginIncorrect);
        }
        }while (idEmpresa == null);

        if (idEmpresa != null) {
            System.out.println(stringsJframe.loginSucess);

            idTerminal = terminalService.checkTerminalRegister(idEmpresa);

            if (idTerminal != null) {

                System.out.println(stringsJframe.identifySucess);
                new ComponentRegistrationService(idTerminal);

            } else {
                Integer idAddress = saveAddress(terminalAddressDAO);
                System.out.println(stringsJframe.addressSave + idAddress);

                idTerminal = saveTerminal(terminalDAO, looca, idEmpresa, idAddress);

                System.out.println(stringsJframe.terminalSave + idTerminal);

                if (idTerminal != null) {

                    System.out.println(stringsJframe.terminalRegistered);
                    new ComponentRegistrationService(idTerminal);

                }
            }
        } else {
            System.out.println(stringsJframe.loginIncorrect);
        }
    }


    private Integer saveAddress(TerminalAddressDAO terminalAddressDAO) throws SQLException {
        Scanner reader = new Scanner(System.in);
        StringsJframe stringsJframe = new StringsJframe();
        System.out.println(stringsJframe.impossibleIdentify);

        String cep = reader.nextLine();
        Integer idCep = 0;

        idCep = terminalAddressDAO.save(ClientCep.getAddressByCep(cep));

        return idCep;
    }

    private Integer saveTerminal(TerminalDAO terminalDAO, Looca looca, Integer idEmpresa, Integer idAddress) throws UnknownHostException, SocketException, SQLException {
        Terminal terminalToSave = new Terminal(
                looca.getProcessador().getNome(),
                looca.getMemoria().getTotal().toString(),
                looca.getGrupoDeDiscos().getTamanhoTotal().toString(),
                looca.getProcessador().getMicroarquitetura(),
                HardwareInfo.getMacAddress(),
                idAddress,
                idEmpresa
        );

        return terminalDAO.save(terminalToSave);
    }
}
