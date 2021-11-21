package br.com.monilog.atmonit.database;

import br.com.monilog.atmonit.util.Log;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

public class CreateConnection {

    public Connection createConnection() throws SQLException {
        Log.logr.info("asdasdasdasdasdasdasdasdasdasd");

        Connection connection = null;
        SwitchConnection switchConnection = new SwitchConnection();

        if (switchConnection.getEnvironment().equals("DEV")) {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.recoverConnectionSQL();
        } else if (switchConnection.getEnvironment().equals("PROD")) {
            JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
            connection = javaConnect2SQL.recoverConnectionAzure();
        }

        return connection;
    }
}
