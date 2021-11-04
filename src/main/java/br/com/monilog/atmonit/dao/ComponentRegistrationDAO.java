package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.ComponentRegistration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class ComponentRegistrationDAO implements IComponentRegistrationDAO {
    @Override
    public Integer saveSQL(ComponentRegistration componentRegistration) {

        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        KeyHolder keyHolder = new GeneratedKeyHolder();


        String sqlQuery =
                "insert into component_registration (name_component, percentage_usage, frequency, fk_terminal)" +
                        " values (?, ?, ?, ?)";

        con.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, componentRegistration.getNameComponent());
            preparedStatement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0: componentRegistration.getPercentageUsage());
            preparedStatement.setDouble(3, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            preparedStatement.setInt(4, componentRegistration.getIdTerminal());

            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
    public Integer saveAzure(ComponentRegistration componentRegistration) {

        ConnectionFactory config = new ConnectionFactory();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        KeyHolder keyHolder = new GeneratedKeyHolder();


        String sqlQuery =
                "insert into component_registration (name_component, percentage_usage, frequency, fk_terminal)" +
                        " values (?, ?, ?, ?)";

        con.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, componentRegistration.getNameComponent());
            preparedStatement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0: componentRegistration.getPercentageUsage());
            preparedStatement.setDouble(3, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            preparedStatement.setInt(4, componentRegistration.getIdTerminal());

            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}
