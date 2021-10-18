package br.com.monilog.atmonit.model;

public class Company {
    private java.lang.Integer idEmpresa;
    private String nome;
    private String cnpj;

    public Company(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public java.lang.Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(java.lang.Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
