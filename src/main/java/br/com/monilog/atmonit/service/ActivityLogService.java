/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.ActivityLogDAO;
import br.com.monilog.atmonit.model.ActivityLog;
import com.github.britooo.looca.api.core.Looca;

import java.sql.SQLException;

/**
 *
 * @author jonas
 */
public class ActivityLogService {
    private Integer idTerminal;

    public ActivityLogService(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public void startLoop() {
        Boolean terminalEmUso = false; //Dado mocado
        Looca looca = new Looca();
        Boolean activeSession = false;

        while (true) {
            if (terminalEmUso) {
                if (!activeSession) {
                    insertData(false);
                    //Salvar data e hora no banco
                    activeSession = true;
                }
            } else {
                if (activeSession) {
                    insertData(true);
                    activeSession = false;
                }
            }
        }
    }

    public void insertData(Boolean activeSession) {
        new Thread() {

            @Override
            public void run() {
                ActivityLogDAO activityLogDAO = new ActivityLogDAO();
                ActivityLog activityLog = new ActivityLog(activeSession,19);

                try {
                    activityLogDAO.save(activityLog);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
