package br.com.monilog.atmonit.model;

public class FuncionarioLogin {
    private String login;
    private String senha;
    private String empresa;

    public FuncionarioLogin(String login, String senha, String empresa) {
        this.login = login;
        this.senha = senha;
        this.empresa = empresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
