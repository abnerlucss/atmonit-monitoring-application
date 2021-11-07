package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.model.Terminal;

public interface ITerminalDAO {
    Integer checkMachineRegisterSQL(String macAddress, Integer idCompany);

    Integer saveSQL(Terminal terminal);
}
