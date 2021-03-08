package gui;

import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("FLOTA EME UNO - MENU PRINCIPAL");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);                
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
