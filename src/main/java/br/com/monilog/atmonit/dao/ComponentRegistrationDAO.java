package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.ComponentRegistration;
import br.com.monilog.atmonit.util.FormatDateTime;

import java.sql.*;

public class ComponentRegistrationDAO extends JavaConnect2SQL implements IComponentRegistrationDAO {
    public Integer saveAzure(ComponentRegistration componentRegistration) throws SQLException {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        FormatDateTime formatDateTime = new FormatDateTime();
        Connection connection = javaConnect2SQL.recoverConnectionAzure();

        Integer generatedKey = null;

        String sql = "insert into component_registration (name_component, percentage_usage, date_time, frequency, fk_terminal)" +
                " values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, componentRegistration.getNameComponent());
            statement.setDouble(2, componentRegistration.getPercentageUsage() == null ? 0.0 : componentRegistration.getPercentageUsage());
            statement.setString(3, formatDateTime.formatDateTimeSQL());
            statement.setDouble(4, componentRegistration.getFrequency() == null ? 0.0 : componentRegistration.getFrequency());
            statement.setInt(5, componentRegistration.getIdTerminal());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            connection.close();
        }
        return generatedKey;
    }

    public Integer saveSQL(ComponentRegistration componentRegistration) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnectionSQL();

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
