package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.CreateConnection;
import br.com.monilog.atmonit.model.ActivityLog;
import java.sql.SQLException;
import java.sql.*;

public class ActivityLogDAO implements IActivityLogDAO {

    @Override
    public Integer save(ActivityLog activityLog) throws SQLException {
        Connection connection = new CreateConnection().createConnection();

        Integer generatedKey = null;

        String sql = "INSERT INTO activity_log (active_terminal, fk_terminal) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setBoolean(1, activityLog.getActiveSession());
            statement.setInt(2, activityLog.getIdTerminal());
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