package br.com.monilog.atmonit.model;

public class RegistroComponente {
    private Double porcentagemUso;
    private Double frequencia;
    private Double temperatura;
    private Integer idTerminal;
    private String nomeComponente;

    public RegistroComponente(Double porcentagemUso, Double frequencia, Double temperatura, Integer idTerminal, String nomeComponente) {
        this.porcentagemUso = porcentagemUso;
        this.frequencia = frequencia;
        this.temperatura = temperatura;
        this.idTerminal = idTerminal;
        this.nomeComponente = nomeComponente;
    }



    @Override
    public String toString() {
        return "RegistroComponente{" +
                "porcentagemUso=" + porcentagemUso +
                ", frequencia=" + frequencia +
                ", temperatura=" + temperatura +
                ", idTerminal=" + idTerminal +
                ", nomeComponente='" + nomeComponente + '\'' +
                '}';
    }

    public Double getPorcentagemUso() {
        return porcentagemUso;
    }

    public void setPorcentagemUso(Double porcentagemUso) {
        this.porcentagemUso = porcentagemUso;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }
}
