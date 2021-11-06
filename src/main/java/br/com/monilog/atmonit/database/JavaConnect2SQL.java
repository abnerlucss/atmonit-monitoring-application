package br.com.monilog.atmonit.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class JavaConnect2SQL {
    private BasicDataSource dataSource;

    public JavaConnect2SQL() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;user=atmonit@srvalunoatmonit;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("atmonit");
        dataSource.setPassword("Bandtec123");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}