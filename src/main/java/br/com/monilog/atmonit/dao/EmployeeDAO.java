package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.database.SwitchConnection;
import br.com.monilog.atmonit.model.EmployeeLogin;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO extends JavaConnect2SQL implements IFuncionarioDAO {

    public  Integer loginFuncionarioAzure(EmployeeLogin employeeLogin){
        Integer idCompany = null;

        String sqlQuery = String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                " where c.company_name = \'%s\' and e.login = \'%s\' and e.password = \'%s\'", employeeLogin.getCompany(),
                employeeLogin.getLogin(), employeeLogin.getPassword());

        System.out.println(sqlQuery);
        connectionAzure(sqlQuery);
        System.out.println(idCompany);
        return idCompany;

    }
    @Override
    public Integer loginFuncionarioSQL(EmployeeLogin employeeLogin) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(connectionFactory.getDataSource());
        Integer idCompany = null;

        String sqlQuery = String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                " where c.company_name = %s and e.login = %s and e.password = %s ", employeeLogin.getCompany(), employeeLogin.getLogin(), employeeLogin.getPassword());

        try {
            idCompany = con.queryForObject(sqlQuery, Integer.class);
        } catch (Exception e) {
        }

        return idCompany;
    }
}
