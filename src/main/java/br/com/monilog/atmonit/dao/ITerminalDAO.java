package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.model.Terminal;

import java.sql.SQLException;

public interface ITerminalDAO {
    Integer checkMachineRegisterSQL(String macAddress, Integer idCompany) throws SQLException;

    Integer saveSQL(Terminal terminal) throws SQLException;
}
