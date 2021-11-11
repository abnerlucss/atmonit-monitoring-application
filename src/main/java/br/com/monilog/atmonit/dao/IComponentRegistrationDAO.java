package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.ComponentRegistration;

import java.sql.SQLException;

public interface IComponentRegistrationDAO {
    Integer save(ComponentRegistration componentRegistration) throws SQLException;
}
