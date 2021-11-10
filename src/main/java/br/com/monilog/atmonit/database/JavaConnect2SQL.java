package br.com.monilog.atmonit.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JavaConnect2SQL {

    public Connection recoverConnectionAzure() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                "atmonit",
                "Bandtec123");
    }
}
