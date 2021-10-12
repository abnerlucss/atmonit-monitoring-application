package br.com.monilog.atmonit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){}

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/atmonit" ,"root", "Af1bf2cf3df4");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
