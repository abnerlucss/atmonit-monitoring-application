package br.com.monilog.atmonit.model;

public class Terminal {
    private Integer idTerminal;
    private String processor;
    private String ramMemory;
    private String terminalStorage;
    private String cpuModel;
    private String macAddress;
    private Integer idTerminalAddress;
    private Integer idCompany;

    public Terminal(String processor, String ramMemory, String terminalStorage, String cpuModel, String macAddress, Integer idTerminalAddress, Integer idCompany) {
        this.processor = processor;
        this.ramMemory = ramMemory;
        this.terminalStorage = terminalStorage;
        this.cpuModel = cpuModel;
        this.macAddress = macAddress;
        this.idTerminalAddress = idTerminalAddress;
        this.idCompany = idCompany;
    }

    public Terminal() {
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(String ramMemory) {
        this.ramMemory = ramMemory;
    }

    public String getTerminalStorage() {
        return terminalStorage;
    }

    public void setTerminalStorage(String terminalStorage) {
        this.terminalStorage = terminalStorage;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getIdTerminalAddress() {
        return idTerminalAddress;
    }

    public void setIdTerminalAddress(Integer idTerminalAddress) {
        this.idTerminalAddress = idTerminalAddress;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }
}
