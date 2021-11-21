package br.com.monilog.atmonit.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recoverConnectionSQL() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://3.95.157.176:3306/atmonit?useTimezone=true&serverTimezone=UTC",
                "atmonit",
                "bandtec");
    }

    
}
