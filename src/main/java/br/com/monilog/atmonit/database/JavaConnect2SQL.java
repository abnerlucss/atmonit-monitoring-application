package br.com.monilog.atmonit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JavaConnect2SQL {

    public Connection recoverConnectionAzure() throws SQLException {
        String urlMonilogAzure = System.getenv("URL_MONILOG_AZURE");
        String userAzure = System.getenv("USER_AZURE");
        String passwordAzure = System.getenv("PASSWORD_AZURE");

        return DriverManager.getConnection(
                "jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                userAzure,
                passwordAzure);
    }
}
