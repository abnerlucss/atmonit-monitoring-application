package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TerminalDAO implements ITerminalDAO {
    @Override
    public boolean checkMachineRegister(String macAddress, Integer idEmpresa) {
        Integer idTerminal = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            String querySql =
                    "select t.id_terminal from terminal as t join empresa as e on t.fk_empresa = e.id_empresa" +
                            " where t.endereco_mac = ? and e.id_empresa = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, macAddress);
            preparedStatement.setInt(2, idEmpresa);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idTerminal = resultSet.getInt("id_terminal");
            }

            return idTerminal != null ? true : false;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
