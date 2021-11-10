package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.EmployeeLogin;

import java.sql.SQLException;

public interface IFuncionarioDAO {
    Integer loginFuncionarioSQL(EmployeeLogin employeeLogin) throws SQLException;

    Integer loginFuncionarioAzure(EmployeeLogin employeeLogin) throws SQLException;
}
