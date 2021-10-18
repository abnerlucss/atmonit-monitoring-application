package br.com.monilog.atmonit.model;

public class Company {
    private Integer idCompany;
    private String name;
    private String cnpj;

    public Company(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
