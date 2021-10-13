package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.dto.FuncionarioLoginDTO;

import java.sql.*;

public class FuncionarioDAO implements IFuncionarioDAO {
    @Override
    public Integer loginFuncionario(FuncionarioLoginDTO funcionarioLoginDTO) {
        Integer idEmpresa = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlQuery = "select e.id_empresa from funcionario as f join empresa as e on f.fk_empresa = e.id_empresa" +
                    " where e.nome = ? and f.login = ? and f.senha = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, funcionarioLoginDTO.getEmpresa());
            preparedStatement.setString(2, funcionarioLoginDTO.getLogin());
            preparedStatement.setString(3, funcionarioLoginDTO.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idEmpresa = resultSet.getInt("id_empresa");
            }
            return idEmpresa;
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }
}
