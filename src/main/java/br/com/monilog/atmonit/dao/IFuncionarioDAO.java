package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.dto.FuncionarioLoginDTO;

public interface IFuncionarioDAO {
    Integer loginFuncionario(FuncionarioLoginDTO funcionarioLoginDTO);
}
