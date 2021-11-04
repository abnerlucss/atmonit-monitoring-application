package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.ComponentRegistration;

public interface IComponentRegistrationDAO {
    Integer saveSQL(ComponentRegistration componentRegistration);
}
