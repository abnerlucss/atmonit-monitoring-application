package br.com.monilog.atmonit.database;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateConnection {

    public Connection createConnection() throws SQLException {
        SwitchConnection switchConnection = new SwitchConnection();

        Connection connection = null;

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
