package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.Cep;

import java.sql.SQLException;

public interface ITerminalAddress {
    Integer saveSQL(Cep cep) throws SQLException;
}
