package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.CreateConnection;
import br.com.monilog.atmonit.model.Cep;

import java.sql.*;

public class TerminalAddressDAO implements ITerminalAddress {
    public Integer save(Cep cep) throws SQLException {
        Connection connection = new CreateConnection().createConnection();

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
}
