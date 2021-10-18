package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.FuncionarioLogin;

public interface IFuncionarioDAO {
    Integer loginFuncionario(FuncionarioLogin funcionarioLogin);
}
