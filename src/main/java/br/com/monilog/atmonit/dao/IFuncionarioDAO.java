package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.EmployeeLogin;

public interface IFuncionarioDAO {
    Integer loginFuncionarioSQL(EmployeeLogin employeeLogin);
}
