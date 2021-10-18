package br.com.monilog.atmonit.database;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
    private BasicDataSource dataSource;

    public ConnectionFactory() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/atmonit");
        dataSource.setUsername("root");
        dataSource.setPassword("Af1bf2cf3df4");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
