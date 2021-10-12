package br.com.monilog.atmonit.dao;


public interface ITerminalDAO {
    boolean checkMachineRegister(String macAddress, Integer idEmpresa);
}
