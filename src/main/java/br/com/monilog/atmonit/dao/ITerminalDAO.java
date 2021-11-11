package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.model.Terminal;

import java.sql.SQLException;

public interface ITerminalDAO {
    Integer checkMachineRegister(String macAddress, Integer idCompany) throws SQLException;

    Integer save(Terminal terminal) throws SQLException;
}
