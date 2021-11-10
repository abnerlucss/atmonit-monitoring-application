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
        Integer generatedKey = null;

        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            PreparedStatement statement = connection.prepareStatement("insert into component_registration (name_component, percentage_usage, frequency, fk_terminal)" +
                    " values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, componentRegistration.getNameComponent());
            statement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0 : componentRegistration.getPercentageUsage());
            statement.setDouble(3, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            statement.setInt(4, componentRegistration.getIdTerminal());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
        return generatedKey;
    }

    public Integer saveSQL(ComponentRegistration componentRegistration) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnection();

        Integer component_registration = null;

        String sql = "insert into component_registration (name_component, percentage_usage, frequency, fk_terminal)" +
                " values (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, componentRegistration.getNameComponent());
            statement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0 : componentRegistration.getPercentageUsage());
            statement.setDouble(3, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            statement.setInt(4, componentRegistration.getIdTerminal());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                component_registration = rs.getInt(1);
            }
            connection.close();
        }
        return component_registration;
    }
}
