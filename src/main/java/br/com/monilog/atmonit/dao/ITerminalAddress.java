package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.Cep;

public interface ITerminalAddress {
    Integer saveSQL(Cep cep);
}
