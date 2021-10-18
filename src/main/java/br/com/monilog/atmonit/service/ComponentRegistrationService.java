package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.ComponentRegistrationDAO;
import br.com.monilog.atmonit.model.ComponentRegistration;
import com.github.britooo.looca.api.core.Looca;

import java.util.Timer;
import java.util.TimerTask;

public class ComponentRegistrationService {
    private Timer timer;
    private Integer idTerminal;

    public ComponentRegistrationService(Integer idTerminal) {
        this.idTerminal = idTerminal;
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1 * 5000);
    }

    class RemindTask extends TimerTask {
        Looca looca = new Looca();

        public void run() {
            ComponentRegistrationDAO componentRegistrationDAO = new ComponentRegistrationDAO();
            ComponentRegistration componentRegistration = new ComponentRegistration(
                    looca.getProcessador().getUso(),
                    looca.getProcessador().getFrequencia().doubleValue(),
                    looca.getProcessador().getUso(),
                    idTerminal,
                    looca.getProcessador().getNome()
            );

            componentRegistrationDAO.save(componentRegistration);
        }
    }
}
