package br.com.monilog.atmonit.model;

public class Terminal {
    private Integer idTerminal;
    private String processador;
    private String ram;
    private String armazenamento;
    private String modeloCpu;
    private String enderecoMac;
    private Integer fkEndereco;
    private Integer fkEmpresa;

    public Terminal(String processador, String ram, String armazenamento, String modeloCpu, String enderecoMac, Integer fkEndereco, Integer fkEmpresa) {
        this.processador = processador;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.modeloCpu = modeloCpu;
        this.enderecoMac = enderecoMac;
        this.fkEndereco = fkEndereco;
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "idTerminal=" + idTerminal +
                ", processador='" + processador + '\'' +
                ", ram='" + ram + '\'' +
                ", armazenamento='" + armazenamento + '\'' +
                ", modeloCpu='" + modeloCpu + '\'' +
                ", enderecoMac='" + enderecoMac + '\'' +
                ", fkEndereco=" + fkEndereco +
                ", fkEmpresa=" + fkEmpresa +
                '}';
    }

    public Terminal() {
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getModeloCpu() {
        return modeloCpu;
    }

    public void setModeloCpu(String modeloCpu) {
        this.modeloCpu = modeloCpu;
    }

    public String getEnderecoMac() {
        return enderecoMac;
    }

    public void setEnderecoMac(String enderecoMac) {
        this.enderecoMac = enderecoMac;
    }

    public Integer getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Integer fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}
