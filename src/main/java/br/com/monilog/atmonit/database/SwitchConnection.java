package br.com.monilog.atmonit.database;

public class SwitchConnection {
    // DEV Environment and PROD Production
    private String environment = "DEV";
//    private String environment = "PROD";

    
    public String getEnvironment() {
        return environment;
    }

}
