package br.com.monilog.atmonit.model;

public class ComponentRegistration {
    private Double percentageUsage;
    private Double frequency;
    private Double temperature;
    private Integer idTerminal;
    private String nameComponent;

    public ComponentRegistration(Double percentageUsage, Double frequency, Double temperature, Integer idTerminal, String nameComponent) {
        this.percentageUsage = percentageUsage;
        this.frequency = frequency;
        this.temperature = temperature;
        this.idTerminal = idTerminal;
        this.nameComponent = nameComponent;
    }

    @Override
    public String toString() {
        return "ComponentRegistration{" +
                "percentageUsage=" + percentageUsage +
                ", frequency=" + frequency +
                ", temperature=" + temperature +
                ", idTerminal=" + idTerminal +
                ", nameComponent='" + nameComponent + '\'' +
                '}';
    }

    public Double getPercentageUsage() {
        return percentageUsage;
    }

    public void setPercentageUsage(Double percentageUsage) {
        this.percentageUsage = percentageUsage;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getNameComponent() {
        return nameComponent;
    }

    public void setNameComponent(String nameComponent) {
        this.nameComponent = nameComponent;
    }
}
