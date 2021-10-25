package br.com.monilog.atmonit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaConnect2SQL {

    public void connectionSQLServer() {
        String url = "jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;user=atmonit@srvalunoatmonit;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        String user = "atmonit";
        String password = "Bandtec123";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao Microsoft Azure!");
            String sql =  "insert into teste (nome, senha) values ('brurola','789');";
            Statement statement = connection.createStatement();
            Integer rows = statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
    }
}