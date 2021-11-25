
package br.com.monilog.atmonit.model;

public class ActivityLog {
    private Boolean activeSession;
    private Integer idTerminal;
    
    public ActivityLog(Boolean activeSession, Integer idTerminal) {
        this.activeSession = activeSession;
        this.idTerminal = idTerminal;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "activeSession=" + activeSession +
                ", idTerminal=" + idTerminal + 
                '}';
    }

    public Boolean getActiveSession() {
        return activeSession;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }
}
