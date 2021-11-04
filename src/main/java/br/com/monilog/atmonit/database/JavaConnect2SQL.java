package br.com.monilog.atmonit.database;

import java.sql.*;

public class JavaConnect2SQL {

    public void connectionAzure(String sql) {
        String url = "jdbc:sqlserver://srvalunoatmonit.database.windows.net:1433;database=bdProjeto2sem;user=atmonit@srvalunoatmonit;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        String user = "atmonit";
        String password = "Bandtec123";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao Microsoft Azure!");
            //sql = "insert into teste (nome, senha) values ('caio','tvxtf');";
            System.out.println("Comando realizado com sucesso!");
            Statement statement = connection.createStatement();
            //Integer rows = statement.executeUpdate(sql);
            ResultSet rows = statement.executeQuery(sql);
            connection.close();

        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
    }
}