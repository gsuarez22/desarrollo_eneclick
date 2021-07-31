/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dominio.BD;
import dominio.ComponentesLista;
import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sistemas
 */
public class frmABMFlota extends javax.swing.JFrame {

    public controlador miControlador;

    public ComponentesLista unC = new ComponentesLista();
    
    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("FLOTA EME UNO - Mantenimiento Flota");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);  
        cargarComboAño();
        cmbTipo.setSelectedItem("AMBULANCIA");
    }    
    
    public void cargarComboAño()
    {
        SimpleDateFormat unS = new SimpleDateFormat("yyyy");
        String año = unS.format(new Date());
        
        cmbAño.removeAll();
        
        for(int i=Integer.parseInt(año); i>1990; i--)
        {
            cmbAño.addItem(i);
        }
    
  
    }
    
    
    public frmABMFlota() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        cmbAño = new javax.swing.JComboBox();
        txtMatricula = new javax.swing.JTextField();
        cmbMarca = new javax.swing.JComboBox();
        cmbModelo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 20, 20);

        lblId.setText("0");
        getContentPane().add(lblId);
        lblId.setBounds(30, 20, 30, 20);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(500, 30, 81, 23);

        btnBorrar.setText("BORRAR");
        getContentPane().add(btnBorrar);
        btnBorrar.setBounds(500, 60, 80, 23);

        btnLimpiar.setText("LIMPIAR");
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(500, 90, 80, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 580, 220);

        jLabel3.setText("Tipo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 20, 40, 20);

        jLabel4.setText("Matricula");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 50, 14);

        jLabel5.setText("Marca");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 110, 29, 14);

        jLabel6.setText("Modelo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(200, 110, 34, 14);

        jLabel7.setText("Año");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 70, 40, 20);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AMBULANCIA", "MOVIL" }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(240, 20, 140, 20);

        getContentPane().add(cmbAño);
        cmbAño.setBounds(240, 70, 70, 20);
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(60, 70, 120, 20);

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbMarca);
        cmbMarca.setBounds(60, 110, 120, 20);

        cmbModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbModelo);
        cmbModelo.setBounds(240, 110, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            unC.cargarCombo("select distinct (modelo) as modelo from flotas  where marca = '" + cmbMarca.getSelectedItem().toString() + "' order by modelo", cmbModelo);
        }
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            unC.cargarCombo("select distinct (marca) as marca from flotas where tipo = '" + cmbTipo.getSelectedItem().toString() + "' order by marca", cmbMarca);
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbAño;
    private javax.swing.JComboBox cmbMarca;
    private javax.swing.JComboBox cmbModelo;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
