package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.Cep;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class TerminalAddressDAO implements IEnderecoTerminal {
    @Override
    public Integer save(Cep cep) {

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
