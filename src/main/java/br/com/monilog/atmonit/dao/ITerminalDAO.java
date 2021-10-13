package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.dto.TerminalDTO;

public interface ITerminalDAO {
    boolean checkMachineRegister(String macAddress, Integer idEmpresa);
    Integer save(TerminalDTO terminalDTO);
}
