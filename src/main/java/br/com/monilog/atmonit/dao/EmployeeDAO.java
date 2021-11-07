package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.database.SwitchConnection;
import br.com.monilog.atmonit.model.EmployeeLogin;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.*;

public class EmployeeDAO extends JavaConnect2SQL implements IFuncionarioDAO {

    public Integer loginFuncionarioAzure(EmployeeLogin employeeLogin) {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        Integer idCompany = null;

        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                            " where c.company_name = \'%s\' and e.login = \'%s\' and e.password = \'%s\'", employeeLogin.getCompany(), employeeLogin.getLogin(), employeeLogin.getPassword()));
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
        return idCompany;

    }

    @Override
    public Integer loginFuncionarioSQL(EmployeeLogin employeeLogin) {
        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        Integer idCompany = null;

        String sqlQuery = String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                " where c.company_name = \'%s\' and e.login = \'%s\' and e.password =\'%s\'", employeeLogin.getCompany(), employeeLogin.getLogin(), employeeLogin.getPassword());

        try {
            idCompany = con.queryForObject(sqlQuery, Integer.class);
        } catch (Exception e) {
        }

        return idCompany;
    }
}
