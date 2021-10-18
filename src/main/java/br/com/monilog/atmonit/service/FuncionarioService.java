package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.FuncionarioDAO;
import br.com.monilog.atmonit.model.FuncionarioLogin;

import java.util.Scanner;

public class FuncionarioService {

    public Integer loginFuncionario(){
        Scanner userInput = new Scanner(System.in);
        boolean hasLogged = false;
        String empresa, login, senha;
        Integer idEmpresa = null;

        while (!hasLogged) {
            System.out.println("Digite sua empresa");
            empresa = userInput.nextLine();

            System.out.println("Digite seu login");
            login = userInput.nextLine();

            System.out.println("Digite sua senha");
            senha = userInput.nextLine();

            FuncionarioLogin funcionarioLogin = new FuncionarioLogin(login, senha, empresa);

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            idEmpresa = funcionarioDAO.loginFuncionario(funcionarioLogin);

            if (idEmpresa != null) {
                System.out.println("Login realizado com sucesso!");
                hasLogged = true;
                return idEmpresa;
            } else {
                System.out.println("Login falhou");
            }
        }
        return null;
    }
}
