package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.EmployeeDAO;
import br.com.monilog.atmonit.model.EmployeeLogin;

import java.util.Scanner;

public class EmployeeService {

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

            EmployeeLogin employeeLogin = new EmployeeLogin(login, senha, empresa);

            EmployeeDAO employeeDAO = new EmployeeDAO();

            idEmpresa = employeeDAO.loginFuncionario(employeeLogin);

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
