package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.dto.CepDTO;
import br.com.monilog.atmonit.model.EnderecoTerminal;

public interface IEnderecoTerminal {
    EnderecoTerminal save(CepDTO cepDTO);
}
