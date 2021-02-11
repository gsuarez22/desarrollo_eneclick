package gui;

import java.awt.Dimension;
import javax.management.remote.JMXProviderException;
import javax.swing.JOptionPane;

public class frmLoguin extends javax.swing.JFrame {

    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("LOG IN    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(400, 200)); 
    }
    
    public frmLoguin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmdLoguin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("USUARIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 380, 14);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(10, 30, 360, 20);

        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 380, 14);

        cmdLoguin.setText("Log in");
        cmdLoguin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoguinActionPerformed(evt);
            }
        });
        getContentPane().add(cmdLoguin);
        cmdLoguin.setBounds(260, 120, 110, 23);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(10, 80, 360, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoguinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoguinActionPerformed
        // TODO add your handling code here:
        String usuario = "";
        boolean flag = false;
        
        if(txtUsuario.getText().equals("secretaria") && txtPassword.getText().equals("FUBB.2021"))
        {
            flag = true;
            usuario = txtUsuario.getText();
        }
        
        if(txtUsuario.getText().equals("contaduria") && txtPassword.getText().equals("Acceso.2021"))
        {
            flag = true;
            usuario = txtUsuario.getText();
        }
        
        if(flag)
        {
            frmMenu unF = new frmMenu();
            unF.abrir(usuario);
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error de acceso");
        }
        
    }//GEN-LAST:event_cmdLoguinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLoguin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
