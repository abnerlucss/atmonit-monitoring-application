package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.ComponentRegistration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class ComponentRegistrationDAO extends JavaConnect2SQL implements IComponentRegistrationDAO {
    public Integer saveAzure(ComponentRegistration componentRegistration) {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String getNameComponent = componentRegistration.getNameComponent();
        Double getPercentageUsage = componentRegistration.getPercentageUsage() == null ? 0.0 : componentRegistration.getPercentageUsage();
        Double getFrequency = componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency();
        Integer getIdTerminal = componentRegistration.getIdTerminal();

        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(String.format("insert into component_registration (name_component, percentage_usage, frequency, fk_terminal)" +
                    " values (%s, %.2f, %.2f, %d)",getNameComponent,getPercentageUsage,getFrequency,getIdTerminal));
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
        return keyHolder.getKey().intValue();
    }

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
            preparedStatement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0 : componentRegistration.getPercentageUsage());
            preparedStatement.setDouble(3, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            preparedStatement.setInt(4,    componentRegistration.getIdTerminal());

            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}
