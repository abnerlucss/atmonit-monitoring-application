package br.com.monilog.atmonit.model;

public class EmployeeLogin {
    private String login;
    private String password;
    private String company;

    public EmployeeLogin(String login, String password, String company) {
        this.login = login;
        this.password = password;
        this.company = company;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
