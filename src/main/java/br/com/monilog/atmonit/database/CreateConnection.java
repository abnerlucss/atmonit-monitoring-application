package br.com.monilog.atmonit.database;

import Log.Log;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateConnection {
    Log logs = new Log();
    public Connection createConnection() throws SQLException {

        Connection connection = null;
        SwitchConnection switchConnection = new SwitchConnection();

        try {
            if (switchConnection.getEnvironment().equals("DEV")) {
                ConnectionFactory connectionFactory = new ConnectionFactory();
                connection = connectionFactory.recoverConnectionSQL();
                logs.saveLog("Conexão com o banco local realizada!");
            } else if (switchConnection.getEnvironment().equals("PROD")) {
                JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
                connection = javaConnect2SQL.recoverConnectionAzure();
                logs.saveLog("Conexão com a nuvem realizada!");
            }
        }catch(SQLException ex){
            logs.saveLog("Falha ao criar conexão");
        }

        return connection;
    }
}
