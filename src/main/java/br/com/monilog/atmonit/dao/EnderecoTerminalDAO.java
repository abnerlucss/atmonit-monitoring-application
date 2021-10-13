package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.dto.CepDTO;

import java.sql.*;

public class EnderecoTerminalDAO implements IEnderecoTerminal {
    @Override
    public Integer save(CepDTO cepDTO) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlQuery = "Insert into endereco_terminal (logradouro, cidade, estado, bairro) " +
                    "values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cepDTO.getLogradouro());
            preparedStatement.setString(2, cepDTO.getLocalidade());
            preparedStatement.setString(3, cepDTO.getUf());
            preparedStatement.setString(4, cepDTO.getBairro());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                return rs.getInt(1);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
