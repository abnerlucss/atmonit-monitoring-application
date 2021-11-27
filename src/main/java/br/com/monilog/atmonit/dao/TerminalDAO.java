package br.com.monilog.atmonit.dao;

import Log.Log;
import br.com.monilog.atmonit.database.CreateConnection;
import br.com.monilog.atmonit.model.Terminal;

import java.sql.*;

public class TerminalDAO implements ITerminalDAO {

    public Integer checkMachineRegister(String macAddress, Integer idCompany) throws SQLException {
        Log log = new Log();

        Connection connection = new CreateConnection().createConnection();
        log.saveLog("INFO: Checando registro da maquina.");
        Integer terminalRtn = null;
        String sql = "select t.* from terminal as t join company as c on t.fk_company = c.id_company" +
                " where t.mac_address = ? and c.id_company = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, macAddress);
            statement.setInt(2, idCompany);
            statement.execute();

            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                terminalRtn = rs.getInt("id_terminal");
            }

            if (terminalRtn == null) {
                terminalRtn = null;
            }
            connection.close();
        }
        return terminalRtn;
    }

    @Override


    public Integer save(Terminal terminal) throws SQLException {
        Log log = new Log();

        Connection connection = new CreateConnection().createConnection();

        Integer generatedKey = null;
        log.saveLog("INFO: Salvando dados da máquina.");

        String sql = "Insert into terminal (processor, ram_memory, terminal_storage, cpu_model," +
                "mac_address, fk_terminal_address, fk_company) values (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, terminal.getProcessor());
            statement.setString(2, terminal.getRamMemory());
            statement.setString(3, terminal.getTerminalStorage());
            statement.setString(4, terminal.getCpuModel());
            statement.setString(5, terminal.getMacAddress());
            statement.setInt(6, terminal.getIdTerminalAddress());
            statement.setInt(7, terminal.getIdCompany());
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
