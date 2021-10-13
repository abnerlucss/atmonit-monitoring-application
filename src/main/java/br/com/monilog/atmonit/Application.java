package br.com.monilog.atmonit;

import br.com.monilog.atmonit.dao.EnderecoTerminalDAO;
import br.com.monilog.atmonit.dao.FuncionarioDAO;
import br.com.monilog.atmonit.dao.TerminalDAO;
import br.com.monilog.atmonit.dto.FuncionarioLoginDTO;
import br.com.monilog.atmonit.dto.TerminalDTO;
import br.com.monilog.atmonit.util.ClienteViaCep;
import br.com.monilog.atmonit.util.HardwareInfo;
import com.github.britooo.looca.api.core.Looca;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        Looca looca = new Looca();
        Scanner userInput = new Scanner(System.in);
        String empresa, login, senha, cep;
        Integer idEmpresa = null;
        boolean hasLogged = false;

        while (!hasLogged) {
            System.out.println("Digite sua empresa");
            empresa = userInput.nextLine();

            System.out.println("Digite seu login");
            login = userInput.nextLine();

            System.out.println("Digite sua senha");
            senha = userInput.nextLine();

            FuncionarioLoginDTO funcionarioLogin = new FuncionarioLoginDTO(login, senha, empresa);

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            idEmpresa = funcionarioDAO.loginFuncionario(funcionarioLogin);

            if (idEmpresa != null) {
                System.out.println("Login realizado com sucesso!");
                hasLogged = true;
            } else {
                System.out.println("Login falhou");
            }
        }

        TerminalDAO terminalDAO = new TerminalDAO();

        if (terminalDAO.checkMachineRegister(HardwareInfo.getMacAddress(), idEmpresa)) {
            System.out.println("Máquina já possui cadastro");
        } else {
            System.out.println("Máquina não possui cadastro");
            System.out.println("Por favor digite o cep aonde a máquina será instalada:");
            cep = userInput.nextLine();

            EnderecoTerminalDAO enderecoTerminalDAO = new EnderecoTerminalDAO();
            TerminalDTO terminalToSave = new TerminalDTO(
                    looca.getProcessador().getNome(),
                    looca.getMemoria().getTotal(),
                    looca.getGrupoDeDiscos().getTamanhoTotal(),
                    "Azus 115a1s56x1",
                    looca.getProcessador().getMicroarquitetura(),
                    HardwareInfo.getMacAddress(),
                    idEmpresa,
                    enderecoTerminalDAO.save(ClienteViaCep.getAddressByCep(cep))
            );

            System.out.println(terminalDAO.save(terminalToSave));


        }

    }


}
