package br.com.monilog.atmonit.database;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
    private BasicDataSource dataSource;

    public ConnectionFactory() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10445380");
        dataSource.setUsername("sql10445380");
        dataSource.setPassword("fHD2ZNeJm5");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
