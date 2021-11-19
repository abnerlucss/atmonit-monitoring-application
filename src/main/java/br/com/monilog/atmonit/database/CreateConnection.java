package br.com.monilog.atmonit.database;

import br.com.monilog.atmonit.view.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CreateConnection {

    public Connection createConnection() throws SQLException {
        
        Connection connection = null;
        
        try{
             SwitchConnection switchConnection = new SwitchConnection();

            connection = null;

        if (switchConnection.getEnvironment().equals("DEV")) {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.recoverConnectionSQL();
        } else if (switchConnection.getEnvironment().equals("PROD")) {
            JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
            connection = javaConnect2SQL.recoverConnectionAzure();
        }
        Log.logWriter("> Conexão realizada <");
        }catch(Exception ex){
        //Configurar classe de excessão;
    }
        return connection;
    }
}
