package gui;

import dominio.formulario;
import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author ENECLICK
 * 
 */

public class frmMenu extends javax.swing.JFrame {

    //ATRIBUTOS DE CLASE
    public controlador miControlador = new controlador();
    
    public frmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPrincipal = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setJMenuBar(mnuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("VELMAREN - MENU PRINCIPAL");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);
        armarMenu();
    }    
    
    public void armarMenu()
    {
        formulario formulario = new formulario(mnuPrincipal, miControlador);
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mnuPrincipal;
    // End of variables declaration//GEN-END:variables
}
