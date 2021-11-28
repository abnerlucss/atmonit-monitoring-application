package br.com.monilog.atmonit.dao;

import Log.Log;
import br.com.monilog.atmonit.database.CreateConnection;
import br.com.monilog.atmonit.model.ComponentRegistration;
import br.com.monilog.atmonit.util.FormatDateTime;
import br.com.monilog.atmonit.webhook.Slack;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;

public class ComponentRegistrationDAO implements IComponentRegistrationDAO {
    Log logs = new Log();

    public Integer save(ComponentRegistration componentRegistration) throws SQLException {
        Connection connection = new CreateConnection().createConnection();

        FormatDateTime formatDateTime = new FormatDateTime();

        Integer generatedKey = null;

        String sql = "insert into component_registration (name_component, percentage_usage, date_time, fk_terminal)" +
                " values (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            String nameComponent = componentRegistration.getNameComponent();
            statement.setString(1, nameComponent);

            Double porcentageUsage = componentRegistration.getPercentageUsage();
            statement.setDouble(2, porcentageUsage == null ? 0.0 : componentRegistration.getPercentageUsage());

            statement.setString(3, formatDateTime.formatDateTimeSQL());

            Integer idTerminal = componentRegistration.getIdTerminal();
            statement.setInt(4, idTerminal);

            if(porcentageUsage >= 70.0){
                JSONObject json = new JSONObject();
                String msgSlack = String.format("*Maquina id:* %d apresentou um estresse acima do normal que pode deixar sua operacao\n" +
                        "suscetivel a falhas! Sugerimos a avaliacao do componente: %s.\n\n" +
                        "*Acompanhe em tempo real:*\n" +
                        "https://monilog-atmonit-web.azurewebsites.net/", idTerminal, nameComponent);
                json.put("text",msgSlack);

                Slack.sendMessage(json);
                logs.saveLog("INFO: Enviando mensagem de alerta ao slack.");

            }
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
            logs.saveLog("ERROR: Falha ao enviar mensagem slack.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            logs.saveLog("ERROR: Falha ao enviar mensagem slack.");
        }
        return generatedKey;
    }
}
