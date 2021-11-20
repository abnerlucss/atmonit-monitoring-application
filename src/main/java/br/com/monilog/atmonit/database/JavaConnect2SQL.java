package br.com.monilog.atmonit.database;

import br.com.monilog.atmonit.view.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaConnect2SQL {

    public Connection recoverConnectionAzure() throws SQLException {
        
        try {
            Log.logWriter(" > Recover Connection  < ");
            
        } catch (IOException ex) {
            Logger.getLogger(JavaConnect2SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DriverManager.getConnection(
                "jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "atmonit",
                "Bandtec123");
    }
}
