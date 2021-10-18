package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.FuncionarioLogin;
import org.springframework.jdbc.core.JdbcTemplate;

public class FuncionarioDAO implements IFuncionarioDAO {
    @Override
    public Integer loginFuncionario(FuncionarioLogin funcionarioLogin) {
        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        Integer idEmpresa = null;

        String sqlQuery = String.format("select c.id_company from employee as e join company as c on e.fk_company = c.id_company" +
                " where c.company_name = \'%s\' and e.login = \'%s\' and e.password =\'%s\'", funcionarioLogin.getEmpresa(), funcionarioLogin.getLogin(), funcionarioLogin.getSenha());

        try {
            idEmpresa = con.queryForObject(sqlQuery, Integer.class);
        } catch (Exception e) {
        }

        return idEmpresa;
    }
}
