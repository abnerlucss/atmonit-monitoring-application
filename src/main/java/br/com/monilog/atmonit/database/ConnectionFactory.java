package br.com.monilog.atmonit.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static br.com.monilog.atmonit.util.Log.logr;

public class ConnectionFactory {

    public Connection recoverConnectionSQL() throws SQLException {

        logr.info("Abrindo conexão com o banco local");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/atmonit?useTimezone=true&serverTimezone=UTC",
                "root",
                "Af1bf2cf3df4");

    }
}
