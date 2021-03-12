/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author sistemas
 */
public class frmABMFlota extends javax.swing.JFrame {

    public controlador miControlador;
    
    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("FLOTA EME UNO - Mantenimiento Flota");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);        
    }    
    
    public frmABMFlota() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
