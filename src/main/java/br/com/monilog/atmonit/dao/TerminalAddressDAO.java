package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.database.JavaConnect2SQL;
import br.com.monilog.atmonit.model.Cep;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class TerminalAddressDAO extends JavaConnect2SQL implements ITerminalAddress {
    public Integer saveAzure(Cep cep) {
        JavaConnect2SQL config = new JavaConnect2SQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Integer generatedKey = null;

        try {
            Connection connection = DriverManager.getConnection(getDataSource().getUrl(), getDataSource().getUsername(), getDataSource().getPassword());

            PreparedStatement statement = connection.prepareStatement("Insert into terminal_address (street, city, state, district) " +
                    "values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cep.getLogradouro());
            statement.setString(2, cep.getLocalidade());
            statement.setString(3, cep.getUf());
            statement.setString(4, cep.getBairro());

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Opps, temos um erro:");
            throwables.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public Integer saveSQL(Cep cep) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recoverConnection();

        Integer id_terminal_address = null;

        String sql = "Insert into terminal_address (street, city, state, district) " +
                "values (?, ?, ?, ?)";
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
