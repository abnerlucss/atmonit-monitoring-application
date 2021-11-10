package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.EmployeeLogin;

import java.sql.*;

public class EmployeeDAO implements IFuncionarioDAO {
    public Integer loginFuncionarioAzure(EmployeeLogin employeeLogin) throws SQLException {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        Connection connection = javaConnect2SQL.recoverConnectionAzure();

        Integer idCompany = null;

        String sql = "select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                " where c.company_name = ? and e.login = ? and e.password = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employeeLogin.getCompany());
            statement.setString(2, employeeLogin.getLogin());
            statement.setString(3, employeeLogin.getPassword());
            statement.execute();

            ResultSet rs = statement.getResultSet();

            while(rs.next()){
                idCompany = rs.getInt(1);
            }
            connection.close();
        }
        return idCompany;
    }

    @Override
    public Integer loginFuncionarioSQL(EmployeeLogin employeeLogin) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnectionSQL();

        Integer idCompany = null;

        String sql = "select c.id_company from employee as e join company as c on e.fk_company = c.id_company where" +
                " c.company_name = ? and e.login = ? and e.password = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employeeLogin.getCompany());
            statement.setString(2, employeeLogin.getLogin());
            statement.setString(3, employeeLogin.getPassword());
            statement.execute();

            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                idCompany = rs.getInt(1);
            }
            connection.close();
        }
        return idCompany;
    }
}
