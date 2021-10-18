package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.model.Terminal;

public interface ITerminalDAO {
    Integer checkMachineRegister(String macAddress, Integer idEmpresa);
    Integer save(Terminal terminal);
}
