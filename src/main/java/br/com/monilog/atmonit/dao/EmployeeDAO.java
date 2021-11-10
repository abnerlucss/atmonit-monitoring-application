package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.EmployeeLogin;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class EmployeeDAO extends JavaConnect2SQL implements IFuncionarioDAO {
    public Integer loginFuncionarioAzure(EmployeeLogin employeeLogin) {
        JavaConnect2SQL config = new JavaConnect2SQL();

        JdbcTemplate con = new JdbcTemplate(config.getDataSource());

        Integer idCompany = null;

        try {

            String sqlQuery = String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                    " where c.company_name = \'%s\' and e.login = \'%s\' and e.password =\'%s\'", employeeLogin.getCompany(), employeeLogin.getLogin(), employeeLogin.getPassword());

            idCompany = con.queryForObject(sqlQuery, Integer.class);

        } catch (Exception e) {
            System.out.println("Ops, temos um erro:");
        }
        return idCompany;
    }

    @Override
    public Integer loginFuncionarioSQL(EmployeeLogin employeeLogin) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnection();

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
                idCompany = rs.getInt("id_company");
            }
            connection.close();
        }
        return idCompany;
    }
}
