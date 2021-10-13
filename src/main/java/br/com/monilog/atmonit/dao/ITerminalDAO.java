package br.com.monilog.atmonit.dao;


import br.com.monilog.atmonit.dto.TerminalDTO;
import br.com.monilog.atmonit.model.Terminal;

public interface ITerminalDAO {
    boolean checkMachineRegister(String macAddress, Integer idEmpresa);
    Terminal save(TerminalDTO terminalDTO);
}
