package br.com.monilog.atmonit.dto;

public class TerminalDTO {
    private String processador;
    private Long ram;
    private Long armazenamento;
    private String modeloPlacaMae;
    private String modeloCpu;
    private String enderecoMac;
    private Integer idEmpresa;
    private Integer idEndereco;

    public TerminalDTO(String processador, Long ram, Long armazenamento, String modeloPlacaMae, String modeloCpu, String enderecoMac, Integer idEmpresa, Integer idEndereco) {
        this.processador = processador;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.modeloPlacaMae = modeloPlacaMae;
        this.modeloCpu = modeloCpu;
        this.enderecoMac = enderecoMac;
        this.idEmpresa = idEmpresa;
        this.idEndereco = idEndereco;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public Long getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(Long armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getModeloPlacaMae() {
        return modeloPlacaMae;
    }

    public void setModeloPlacaMae(String modeloPlacaMae) {
        this.modeloPlacaMae = modeloPlacaMae;
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
