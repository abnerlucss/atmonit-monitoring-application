package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.Terminal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerminalDAO extends JavaConnect2SQL implements ITerminalDAO {

    public Integer checkMachineRegisterAzure(String macAddress, Integer idCompany) {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        List<Terminal> terminal = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(String.format("select t.* from terminal as t join company as c on t.fk_company = c.id_company" +
                    " where t.mac_address = '%s' and c.id_company = %d limit 1", macAddress, idCompany));
            terminal = (List<Terminal>) statement.executeQuery(String.valueOf(rows));

            if (terminal.isEmpty()) {
                return null;
            }
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
        return terminal.get(0).getIdTerminal();

    }

    @Override
    public Integer checkMachineRegisterSQL(String macAddress, Integer idCompany) {
        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());

        String querySql = String.format("select t.* from terminal as t join company as c on t.fk_company = c.id_company" +
                " where t.mac_address = '%s' and c.id_company = %d limit 1", macAddress, idCompany);

        List<Terminal> terminal = con.query(
                querySql,
                new BeanPropertyRowMapper(Terminal.class)
        );

        if (terminal.isEmpty()) {
            return null;
        }
        return terminal.get(0).getIdTerminal();
    }

    public Integer saveAzure(Terminal terminal) {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            String getProcessor = terminal.getProcessor();
            String getRamMemory = terminal.getRamMemory();
            String getTerminalStorage = terminal.getTerminalStorage();
            String getCpuModel = terminal.getCpuModel();
            String getMacAddress = terminal.getMacAddress();
            Integer getIdTerminalAddress = terminal.getIdTerminalAddress();
            Integer getIdCompany = terminal.getIdCompany();

            Statement statement = connection.createStatement();

            int sqlQuery = statement.executeUpdate(String.format("Insert into terminal (processor, ram_memory, terminal_storage, cpu_model," +
                    "mac_address, fk_terminal_address, fk_company) " +
                    "values (%s, %s, %s, %s, %s, %d, %d)", getProcessor, getRamMemory, getTerminalStorage, getCpuModel, getMacAddress, getIdTerminalAddress, getIdCompany));

        }catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }

        return keyHolder.getKey().intValue();
    }

    @Override
    public Integer saveSQL(Terminal terminal) {

        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sqlQuery = "Insert into terminal (processor, ram_memory, terminal_storage, cpu_model," +
                "mac_address, fk_terminal_address, fk_company) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        con.update(connection -> {

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, terminal.getProcessor());
            preparedStatement.setString(2, terminal.getRamMemory());
            preparedStatement.setString(3, terminal.getTerminalStorage());
            preparedStatement.setString(4, terminal.getCpuModel());
            preparedStatement.setString(5, terminal.getMacAddress());
            preparedStatement.setInt(6, terminal.getIdTerminalAddress());
            preparedStatement.setInt(7, terminal.getIdCompany());

            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}
