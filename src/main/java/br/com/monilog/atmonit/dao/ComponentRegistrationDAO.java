package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.CreateConnection;
import br.com.monilog.atmonit.model.ComponentRegistration;
import br.com.monilog.atmonit.util.FormatDateTime;

import java.sql.*;

public class ComponentRegistrationDAO implements IComponentRegistrationDAO {

    public Integer save(ComponentRegistration componentRegistration) throws SQLException {
        Connection connection = new CreateConnection().createConnection();

        FormatDateTime formatDateTime = new FormatDateTime();

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
}
