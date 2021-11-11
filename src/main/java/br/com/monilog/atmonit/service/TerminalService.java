package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.TerminalDAO;
import br.com.monilog.atmonit.util.HardwareInfo;
import com.github.britooo.looca.api.core.Looca;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

public class TerminalService {

    public Integer checkTerminalRegister(Integer idEmpresa) throws SocketException, UnknownHostException, SQLException {
        TerminalDAO terminalDAO = new TerminalDAO();
        Scanner userInput = new Scanner(System.in);
        String cep;
        Looca looca = new Looca();
        Integer idTerminal = terminalDAO.checkMachineRegister(HardwareInfo.getMacAddress(), idEmpresa);

        if (idTerminal != null) {
            System.out.println("Maquina ja possui cadastro");
            return idTerminal;
        }
        return null;
    }
}
