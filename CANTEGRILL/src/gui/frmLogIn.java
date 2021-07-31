
package gui;

import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author ENECLICK
 */

public class frmLogIn extends javax.swing.JFrame {

    //ATRIBUTOS DE CLASE
    public controlador miControlador = new controlador();
    
    public frmLogIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
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

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(160, 110, 110, 23);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(100, 30, 250, 20);
        getContentPane().add(txtClave);
        txtClave.setBounds(100, 70, 250, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:

        if(miControlador.conectarUsuario ( txtUsuario.getText(), txtClave.getText()) )
        {
            frmMenu frm = new frmMenu();
            frm.abrir(miControlador);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Vuelva a intentarlo.");
        }  
        
    }//GEN-LAST:event_btnIngresarActionPerformed

   
    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("CANTEGRILL - LOGIN");
        this.setMinimumSize(new Dimension(400, 200)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);                
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
