package br.com.monilog.atmonit.database;


import br.com.monilog.atmonit.view.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
   
    public Connection recoverConnectionSQL() throws SQLException {
        try {
            Log.logWriter("> Conexão Ok < ");
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atmonit?useTimezone=true&serverTimezone=UTC",
                "atmonit",
                "bandtec");
         
    }

    
}
