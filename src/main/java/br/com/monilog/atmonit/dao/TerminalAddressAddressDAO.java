package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.Cep;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class TerminalAddressAddressDAO extends JavaConnect2SQL implements ITerminalAddress {
    public Integer saveAzure(Cep cep) {

        JavaConnect2SQL config = new JavaConnect2SQL();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            String sqlQuery = String.format("Insert into terminal_address (street, city, state, district) " +
                    "values ('%s', '%s', '%s', '%s')", cep.getLogradouro(), cep.getLocalidade(), cep.getUf(), cep.getBairro());

            con.update(
                    con1 -> con1.prepareStatement(sqlQuery, new String[]{"id_terminal_address"}), keyHolder);

            return keyHolder.getKey().intValue();

        } catch (Exception e) {
            System.out.println("Opps, temos um erro:");
        }
        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer saveSQL(Cep cep) {

        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());

        String sqlQuery = String.format("Insert into terminal_address (street, city, state, district) " +
                "values ('%s', '%s', '%s', '%s')", cep.getLogradouro(), cep.getLocalidade(), cep.getUf(), cep.getBairro());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        con.update(
                con1 -> con1.prepareStatement(sqlQuery, new String[]{"id_terminal_address"}), keyHolder);

        return keyHolder.getKey().intValue();
    }
}
