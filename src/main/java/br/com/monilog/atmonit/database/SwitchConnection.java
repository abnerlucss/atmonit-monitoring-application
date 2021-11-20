package br.com.monilog.atmonit.database;

import br.com.monilog.atmonit.view.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwitchConnection {
    // DEV Environment and PROD Production
    private String environment = "DEV";
    //private String environment = "PROD";

    
    public String getEnvironment() {
        
        try {
            Log.logWriter(" > Ambiente Alternado < ");
        } catch (IOException ex) {
            Logger.getLogger(SwitchConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return environment;
    }

}
