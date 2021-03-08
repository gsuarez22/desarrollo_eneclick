
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ENECLICK
 */

public class frmLogIn extends javax.swing.JFrame {

    public frmLogIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 60, 20);

        jLabel2.setText("Clave:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 60, 20);

        jButton1.setText("Ingresar");
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 110, 110, 23);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 30, 250, 20);
        getContentPane().add(txtClave);
        txtClave.setBounds(100, 70, 250, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("FLOTA EME UNO - LOGIN");
        this.setMinimumSize(new Dimension(400, 200)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);                
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
