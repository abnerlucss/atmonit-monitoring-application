/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.monilog.atmonit.view;

import br.com.monilog.atmonit.dao.EmployeeDAO;
import br.com.monilog.atmonit.dao.TerminalAddressDAO;
import br.com.monilog.atmonit.dao.TerminalDAO;
import br.com.monilog.atmonit.database.SwitchConnection;
import br.com.monilog.atmonit.model.EmployeeLogin;
import br.com.monilog.atmonit.model.Terminal;
import br.com.monilog.atmonit.service.ComponentRegistrationService;
import br.com.monilog.atmonit.service.TerminalService;
import br.com.monilog.atmonit.util.ClientCep;
import br.com.monilog.atmonit.util.HardwareInfo;
import br.com.monilog.atmonit.view.systemtray.TrayClass;
import com.github.britooo.looca.api.core.Looca;

import javax.swing.*;
import java.awt.*;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import static br.com.monilog.atmonit.util.Log.logr;

/**
 * @author Monilog
 */
public class Login extends javax.swing.JFrame {
    StringsJframe stringsJframe = new StringsJframe();

    Image image = Toolkit.getDefaultToolkit().getImage(stringsJframe.image);

    public Login() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        this.setLocationRelativeTo(null);
        this.textFieldCep.setVisible(false);
        this.lblCep.setVisible(false);
        setSize(this.getWidth(), this.getHeight() - 50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        imgAtmonit = new javax.swing.JLabel();
        textFieldCompany = new javax.swing.JTextField();
        lblCompany = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        textFieldLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        textFieldCep = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monilog - ATMonit");
        setBackground(new java.awt.Color(255, 159, 67));

        imgAtmonit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atmonit.png"))); // NOI18N

        textFieldCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCompanyActionPerformed(evt);
            }
        });

        lblCompany.setText("Empresa");

        lblLogin.setText("Login");

        textFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLoginActionPerformed(evt);
            }
        });

        lblPassword.setText("Senha");

        lblCep.setText("Cep");

        textFieldCep.setToolTipText("Precisamos do Cep para cadastrar esse terminal");
        textFieldCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCepActionPerformed(evt);
            }
        });

        btnEnter.setBackground(new java.awt.Color(16, 172, 132));
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("Entrar");
        btnEnter.setBorder(null);
        btnEnter.setBorderPainted(false);
        btnEnter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEnterActionPerformed(evt);
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        passwordField.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblPassword)
                                                        .addComponent(lblCep)
                                                        .addComponent(lblCompany)
                                                        .addComponent(imgAtmonit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldCompany)
                                                        .addComponent(textFieldLogin)
                                                        .addComponent(textFieldCep)
                                                        .addComponent(passwordField)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(181, 181, 181)
                                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(imgAtmonit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCompany)
                                .addGap(3, 3, 3)
                                .addComponent(textFieldCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLogin)
                                .addGap(3, 3, 3)
                                .addComponent(textFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPassword)
                                .addGap(3, 3, 3)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCep)
                                .addGap(3, 3, 3)
                                .addComponent(textFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loginEmployee() throws SocketException, UnknownHostException, SQLException {
        TerminalAddressDAO terminalAddressDAO = new TerminalAddressDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        TerminalDAO terminalDAO = new TerminalDAO();
        TerminalService terminalService = new TerminalService();
        Looca looca = new Looca();
        EmployeeLogin employeeLogin;

        String empresa, login, senha;
        Integer idEmpresa = null;
        Integer idTerminal = null;

        empresa = textFieldCompany.getText();
        login = textFieldLogin.getText();
        senha = passwordField.getText();

        employeeLogin = new EmployeeLogin(login, senha, empresa);

        SwitchConnection switchConnection = new SwitchConnection();

        idEmpresa = employeeDAO.loginFuncionario(employeeLogin);

        if (idEmpresa != null) {
            StringsJframe stringsJframe = new StringsJframe();
            System.out.println(stringsJframe.loginSucess);

            logr.info("Login realizado com sucesso!");


            idTerminal = terminalService.checkTerminalRegister(idEmpresa);

            if (idTerminal != null) {
                JOptionPane.showMessageDialog(this, stringsJframe.identifySucess);
                new ComponentRegistrationService(idTerminal);
                setVisible(false);
                TrayClass trayClass = new TrayClass(image);

            } else {
                Integer idAddress = saveAddress(terminalAddressDAO);
                System.out.println(stringsJframe.addressSave + idAddress);

                idTerminal = saveTerminal(terminalDAO, looca, idEmpresa, idAddress);

                System.out.println(stringsJframe.terminalSave + idTerminal);

                if (idTerminal != null) {
                    JOptionPane.showMessageDialog(this, stringsJframe.terminalRegistered);
                    new ComponentRegistrationService(idTerminal);
                    setVisible(false);
                    TrayClass trayClass = new TrayClass(image);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, stringsJframe.loginIncorrect);
        }
    }


    private Integer saveAddress(TerminalAddressDAO terminalAddressDAO) throws SQLException {
        String cep = JOptionPane.showInputDialog(this, stringsJframe.impossibleIdentify);
        Integer idCep = 0;

        idCep = terminalAddressDAO.save(ClientCep.getAddressByCep(cep));

        return idCep;
    }

    private Integer saveTerminal(TerminalDAO terminalDAO, Looca looca, Integer idEmpresa, Integer idAddress) throws UnknownHostException, SocketException, SQLException {
        Terminal terminalToSave = new Terminal(
                looca.getProcessador().getNome(),
                looca.getMemoria().getTotal().toString(),
                looca.getGrupoDeDiscos().getTamanhoTotal().toString(),
                looca.getProcessador().getMicroarquitetura(),
                HardwareInfo.getMacAddress(),
                idAddress,
                idEmpresa
        );

        return terminalDAO.save(terminalToSave);
    }

    private void textFieldCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCompanyActionPerformed

    private void textFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLoginActionPerformed

    private void textFieldCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCepActionPerformed
        // TODO add your handling code here:
        //textFieldCep
    }//GEN-LAST:event_textFieldCepActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) throws SocketException, UnknownHostException, SQLException {//GEN-FIRST:event_btnEnterActionPerformed
        loginEmployee();
    }//GEN-LAST:event_btnEnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel imgAtmonit;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textFieldCep;
    private javax.swing.JTextField textFieldCompany;
    private javax.swing.JTextField textFieldLogin;
    // End of variables declaration//GEN-END:variables
}
