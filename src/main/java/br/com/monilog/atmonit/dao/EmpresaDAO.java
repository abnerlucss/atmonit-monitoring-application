package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpresaDAO implements IEmpresaDAO {
    @Override
    public Empresa save(Empresa empresa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlQuery = "Insert into empresa (nome, cnpj) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, empresa.getNome());
            preparedStatement.setString(2, empresa.getCnpj());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return empresa;
    }
}
