package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.Cep;

import java.sql.*;

public class TerminalAddressDAO implements ITerminalAddress {
    public Integer saveAzure(Cep cep) throws SQLException {
        JavaConnect2SQL javaConnect2SQL = new JavaConnect2SQL();
        Connection connection = javaConnect2SQL.recoverConnectionAzure();

        Integer generatedKey = null;

        String sql = "Insert into terminal_address (street, city, state, district) values (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cep.getLogradouro());
            statement.setString(2, cep.getLocalidade());
            statement.setString(3, cep.getUf());
            statement.setString(4, cep.getBairro());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            connection.close();
        }
        return generatedKey;
    }

    @Override
    public Integer saveSQL(Cep cep) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnectionSQL();

        Integer id_terminal_address = null;

        String sql = "Insert into terminal_address (street, city, state, district) values (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cep.getLogradouro());
            statement.setString(2, cep.getLocalidade());
            statement.setString(3, cep.getUf());
            statement.setString(4, cep.getBairro());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                id_terminal_address = rs.getInt("id_terminal_address");
            }
            connection.close();
        }

        return id_terminal_address;
    }
}
