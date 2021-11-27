package br.com.monilog.atmonit.database;


import Log.Log;

public class SwitchConnection {
    // DEV Environment and PROD Production
    private String environment = "PROD";
//    private String environment = "PROD";

    public String getEnvironment() {
        Log log = new Log();
        log.saveLog("INFO: Enviroment: " + environment);
        return environment;
    }

}
