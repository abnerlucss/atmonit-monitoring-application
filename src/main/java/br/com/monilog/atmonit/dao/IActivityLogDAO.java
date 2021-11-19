package br.com.monilog.atmonit.dao;

import br.com.monilog.atmonit.model.ActivityLog;
import java.sql.SQLException;

public interface IActivityLogDAO {
    Integer save(ActivityLog activityLog) throws SQLException;
}
