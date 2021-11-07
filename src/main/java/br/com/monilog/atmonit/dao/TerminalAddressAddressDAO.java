package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.Cep;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class TerminalAddressAddressDAO extends JavaConnect2SQL implements ITerminalAddress {
    public Integer saveAzure(Cep cep) {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(String.format("Insert into terminal_address (street, city, state, district) " +
                    "values ('%s', '%s', '%s', '%s')", cep.getLogradouro(), cep.getLocalidade(), cep.getUf(), cep.getBairro()));

            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
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
