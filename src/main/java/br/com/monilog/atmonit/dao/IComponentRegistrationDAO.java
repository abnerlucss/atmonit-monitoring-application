package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.ComponentRegistration;

import java.sql.SQLException;

public interface IComponentRegistrationDAO {
    Integer saveSQL(ComponentRegistration componentRegistration) throws SQLException;

    Integer saveAzure(ComponentRegistration componentRegistration) throws SQLException;
}
