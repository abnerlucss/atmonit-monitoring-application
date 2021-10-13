package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.database.ConnectionFactory;
import br.com.monilog.atmonit.dto.TerminalDTO;

import java.sql.*;

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

    @Override
    public Integer save(TerminalDTO terminalDTO) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sqlQuery = "Insert into terminal (processador, ram, armazenamento, modelo_placa_mae," +
                    "modelo_cpu, endereco_mac, fk_endereco, fk_empresa) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, terminalDTO.getProcessador());
            preparedStatement.setString(2, terminalDTO.getRam().toString());
            preparedStatement.setString(3, terminalDTO.getArmazenamento().toString());
            preparedStatement.setString(4, terminalDTO.getModeloPlacaMae());
            preparedStatement.setString(5, terminalDTO.getModeloCpu());
            preparedStatement.setString(6, terminalDTO.getEnderecoMac());
            preparedStatement.setInt(7, terminalDTO.getIdEndereco());
            preparedStatement.setInt(8, terminalDTO.getIdEmpresa());

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
