package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.TerminalAddressDAO;
import br.com.monilog.atmonit.dao.TerminalDAO;
import br.com.monilog.atmonit.model.Terminal;
import br.com.monilog.atmonit.util.ClienteViaCep;
import br.com.monilog.atmonit.util.HardwareInfo;
import com.github.britooo.looca.api.core.Looca;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TerminalService {

    public Integer checkTerminalRegister(Integer idEmpresa) throws SocketException, UnknownHostException {
        TerminalDAO terminalDAO = new TerminalDAO();
        Scanner userInput = new Scanner(System.in);
        String cep;
        Looca looca = new Looca();
        Integer idTerminal = terminalDAO.checkMachineRegister(HardwareInfo.getMacAddress(), idEmpresa);

        if (idTerminal != null) {
            System.out.println("Máquina já possui cadastro");
            return idTerminal;
        } else {
            System.out.println("Máquina não possui cadastro");
            System.out.println("Por favor digite o cep aonde a máquina será instalada:");
            cep = userInput.nextLine();
            TerminalAddressDAO terminalAddressDAO = new TerminalAddressDAO();
            Integer idCep = terminalAddressDAO.save(ClienteViaCep.getAddressByCep(cep));

            Terminal terminalToSave = new Terminal(
                    looca.getProcessador().getNome(),
                    looca.getMemoria().getTotal().toString(),
                    looca.getGrupoDeDiscos().getTamanhoTotal().toString(),
                    looca.getProcessador().getMicroarquitetura(),
                    HardwareInfo.getMacAddress(),
                    idCep,
                    idEmpresa
            );

            return terminalDAO.save(terminalToSave);
        }
    }
}
