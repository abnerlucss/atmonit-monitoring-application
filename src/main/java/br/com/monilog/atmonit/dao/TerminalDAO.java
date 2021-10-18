package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.Terminal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class TerminalDAO implements ITerminalDAO {
    @Override
    public Integer checkMachineRegister(String macAddress, Integer idCompany) {
        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());

        String querySql = String.format("select t.* from terminal as t join company as c on t.fk_company = c.id_company" +
                " where t.mac_address = '%s' and c.id_company = %d limit 1", macAddress, idCompany);

        List<Terminal> terminal = con.query(
                querySql,
                new BeanPropertyRowMapper(Terminal.class)
        );

        if(terminal.isEmpty()){
            return null;
        }
        return terminal.get(0).getIdTerminal();
    }

    @Override
    public Integer save(Terminal terminal) {

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
