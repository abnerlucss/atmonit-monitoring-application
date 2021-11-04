package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.ComponentRegistrationDAO;
import br.com.monilog.atmonit.model.ComponentRegistration;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;

import java.util.ArrayList;
import java.util.List;
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
        List<Volume> diskList = looca.getGrupoDeDiscos().getVolumes();

        public void run() {
            ComponentRegistrationDAO componentRegistrationDAO = new ComponentRegistrationDAO();

            List<ComponentRegistration> componentsList = new ArrayList();

            componentsList.add(new ComponentRegistration(
                    looca.getProcessador().getUso(),
                    getFrequency(),
                    null,
                    idTerminal,
                    "Processor"
            ));

            componentsList.add(new ComponentRegistration(
                    looca.getMemoria().getEmUso().doubleValue(),
                    null,
                    null,
                    idTerminal,
                    "Ram memory"
            ));

            for (Integer i = 0; i < diskList.size(); i++) {
                componentsList.add(new ComponentRegistration(
                        getPercentageUsageDisk(i),
                        null,
                        null,
                        idTerminal,
                        "Hard Disk " + (i + 1)
                ));
            }

            for (ComponentRegistration component : componentsList) {
                componentRegistrationDAO.saveSQL(component);
            }
        }

        private double getPercentageUsageDisk(Integer i) {
            return (double) (diskList.get(i).getTotal() * ((diskList.get(i).getTotal() - diskList.get(i).getDisponivel()) / 100));
        }

        private double getFrequency() {
            return looca.getProcessador().getFrequencia() * (looca.getProcessador().getFrequencia() - looca.getProcessador().getUso() / 100);
        }
    }
}
