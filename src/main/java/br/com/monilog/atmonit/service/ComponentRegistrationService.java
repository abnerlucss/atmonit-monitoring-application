package br.com.monilog.atmonit.service;

import br.com.monilog.atmonit.dao.ComponentRegistrationDAO;
import br.com.monilog.atmonit.model.ComponentRegistration;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import java.sql.SQLException;
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
                    getPercentageUsageMemory(),
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
                try {
                    componentRegistrationDAO.save(component);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        private double getPercentageUsageDisk(Integer i) {
            double total = diskList.get(i).getTotal();
            double disponivel = diskList.get(i).getDisponivel();
            double porcentagemDisponivel = (100 * disponivel) / total;
            double porcentagemUso = 100 - porcentagemDisponivel;
            return porcentagemUso;
        }

        private double getFrequency() {
            double uso = looca.getProcessador().getUso();
            double scale = Math.pow(10, 2);
            uso = Math.round(uso * scale) / scale;

            return uso;
        }

        private double getPercentageUsageMemory() {
            double total = looca.getMemoria().getTotal();
            double uso = looca.getMemoria().getEmUso();
            double porcentagemUso = (100 * uso) / total;
            return porcentagemUso;
        }
    }
}
