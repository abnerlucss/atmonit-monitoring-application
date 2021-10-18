package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.RegistroComponente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class ComponentRegistrationDAO implements IRegistroComponenteDAO {
    @Override
    public Integer save(RegistroComponente registroComponente) {

        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        System.out.println(registroComponente);

        String sqlQuery =
                "insert into component_registration (nome_component, percentage_usage, frequency, fk_terminal)" +
                        " values (?, ?, ?, ?)";

        con.update(connection -> {

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, registroComponente.getNomeComponente());
            preparedStatement.setDouble(2, registroComponente.getPorcentagemUso());
            preparedStatement.setDouble(3, registroComponente.getFrequencia());
            preparedStatement.setInt(4, registroComponente.getIdTerminal());

            System.out.println(preparedStatement);
            return preparedStatement;
        }, keyHolder);

        System.out.println(keyHolder.getKey().intValue());

        return keyHolder.getKey().intValue();
    }
}
