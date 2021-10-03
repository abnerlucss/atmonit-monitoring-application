package br.com.monilog.atmonit;

import br.com.monilog.atmonit.dao.EmpresaDAO;
import br.com.monilog.atmonit.model.Empresa;

public class Application {
    public static void main(String[] args) {
        Empresa empresa = new Empresa(
                "Banco24horas",
                "83763538000185"
        );

        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.save(empresa);
    }

}
