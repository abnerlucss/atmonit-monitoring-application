
package br.com.monilog.atmonit.model;

public class ActivityLog {
    private Boolean activeSession;
    private Integer idTerminal;
    
    public ActivityLog(Boolean actBoolean, Integer idTInteger) {
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

    public void setActiveSession(Boolean activeSession) {
        this.activeSession = activeSession;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
