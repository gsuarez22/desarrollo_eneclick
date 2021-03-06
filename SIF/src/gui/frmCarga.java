
package gui;

import domain.Carga;
import domain.ComponentesLista;
import domain.Contenedor;
import domain.Imo;
import domain.Notificacion;
import domain.Reserva;
import java.awt.Dimension;
import javax.swing.JOptionPane;


public class frmCarga extends javax.swing.JFrame {

    Reserva miReserva = new Reserva();
    Contenedor miContenedor = new Contenedor();
  
    public frmCarga() {
        initComponents();
    }

    //ATRIBUTOS
    ComponentesLista unC = new ComponentesLista();
        
    //METODOS
    public void abrir(Reserva r, Contenedor c)
    {   
        //setLocationRelativeTo(null);
        this.setTitle("Carga e Imo    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(800, 720));
        this.setVisible(true);
        miReserva = r;
        miContenedor = c;
        
        resetearCarga();
        resetearIMO();
    
        lblEstado.setText("Reserva: " + r.numero_sif + "      ID: " + r.id_reserva + "      Cliente: " + r.entidad_cliente );
    }
    
    private void resetearIMO ()
    {
        unC.cargarCombo("SELECT DISTINCT (tipo_imo) AS imo FROM sif_imos ORDER BY tipo_imo", cmbImo);
        unC.cargarCombo("SELECT DISTINCT (unn) AS imo FROM sif_imos ORDER BY unn", cmbUNN);
        unC.cargarTabla("Select ID,MARCA AS CONTENEDOR,TIPO_IMO AS IMO,UNN from sif_imos where id_reserva = '" + miReserva.id_reserva + "' and id_carga = '" + lblID.getText() + "'", tblImo);
        lblID1.setText("0");
    }
    
    private void resetearCarga()
    {
        unC.cargarCombo("SELECT DISTINCT (ncm) AS imo FROM sif_tipomercaderias ORDER BY ncm", cmbMercaderia);
        unC.cargarCombo("SELECT DISTINCT (aduana_bul) AS imo FROM sif_tipobultos ORDER BY aduana_bul", cmbTipoBulto);
        unC.cargarTabla("Select ID, TIPO_BULTOS,ID_MERCADERIA AS MERCADERIA,CANTIDAD_BULTOS AS CANTIDAD,PESO_BULTOS AS PESO, VOLUMEN from sif_cargas where id_reserva = '" + miReserva.id_reserva + "' and marca = '" + miContenedor.id + "'", tblLista);
        lblMarca.setText(miContenedor.marca);
        txtCantidad.setText("");
        txtPeso.setText("");
        txtVolumen.setText("");
        lblID.setText("0");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        labeler2 = new javax.swing.JLabel();
        labeler3 = new javax.swing.JLabel();
        cmbTipoBulto = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cmbMercaderia = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        lblMarca = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblID1 = new javax.swing.JLabel();
        labeler4 = new javax.swing.JLabel();
        labeler5 = new javax.swing.JLabel();
        labeler7 = new javax.swing.JLabel();
        cmbImo = new javax.swing.JComboBox();
        jSeparator5 = new javax.swing.JSeparator();
        cmdActualizar1 = new javax.swing.JButton();
        cmdGuardar1 = new javax.swing.JButton();
        cmdBorrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblImo = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        cmbUNN = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(20, 40, 80, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler.setText("CONTENEDOR");
        getContentPane().add(labeler);
        labeler.setBounds(110, 10, 110, 20);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler1.setText("ID");
        getContentPane().add(labeler1);
        labeler1.setBounds(20, 10, 80, 20);

        txtPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPeso);
        txtPeso.setBounds(320, 40, 60, 20);

        labeler2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler2.setText("TIPO MERCADERIA");
        getContentPane().add(labeler2);
        labeler2.setBounds(530, 20, 110, 14);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler3.setText("TIPO BULTO");
        getContentPane().add(labeler3);
        labeler3.setBounds(650, 20, 120, 14);

        cmbTipoBulto.setEditable(true);
        cmbTipoBulto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONSOLIDADO", "FULL" }));
        cmbTipoBulto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoBultoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTipoBulto);
        cmbTipoBulto.setBounds(650, 40, 120, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 130, 760, 20);

        cmdActualizar.setBackground(new java.awt.Color(0, 153, 204));
        cmdActualizar.setText("ACTUALIZAR");
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdActualizar);
        cmdActualizar.setBounds(270, 90, 110, 23);

        cmdGuardar.setBackground(new java.awt.Color(102, 255, 102));
        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar);
        cmdGuardar.setBounds(10, 90, 110, 23);

        cmdBorrar.setBackground(new java.awt.Color(255, 102, 102));
        cmdBorrar.setText("BORRAR");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdBorrar);
        cmdBorrar.setBounds(140, 90, 110, 23);

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 760, 200);

        cmbMercaderia.setEditable(true);
        cmbMercaderia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DRY 20", "DRY 40", "HIGH CUBE 40", "REEFER 20", "REEFER 40", "ESPECIAL 20", "ESPECIAL 40" }));
        getContentPane().add(cmbMercaderia);
        cmbMercaderia.setBounds(530, 40, 110, 20);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 70, 760, 10);
        getContentPane().add(lblMarca);
        lblMarca.setBounds(110, 40, 110, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PESO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 10, 70, 20);

        jLabel2.setText("M3");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(490, 40, 20, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANTIDAD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 10, 70, 20);

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(230, 40, 70, 20);

        lblID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID1.setText("0");
        getContentPane().add(lblID1);
        lblID1.setBounds(20, 380, 100, 20);

        labeler4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler4.setText("UN");
        getContentPane().add(labeler4);
        labeler4.setBounds(260, 350, 100, 30);

        labeler5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler5.setText("ID");
        getContentPane().add(labeler5);
        labeler5.setBounds(20, 350, 100, 30);

        labeler7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler7.setText("TIPO IMO");
        getContentPane().add(labeler7);
        labeler7.setBounds(140, 350, 100, 30);

        cmbImo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONSOLIDADO", "FULL" }));
        cmbImo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbImoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbImo);
        cmbImo.setBounds(140, 380, 100, 20);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(10, 350, 760, 20);

        cmdActualizar1.setBackground(new java.awt.Color(0, 153, 204));
        cmdActualizar1.setText("ACTUALIZAR");
        cmdActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizar1ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdActualizar1);
        cmdActualizar1.setBounds(660, 370, 110, 23);

        cmdGuardar1.setBackground(new java.awt.Color(102, 255, 102));
        cmdGuardar1.setText("GUARDAR");
        cmdGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar1);
        cmdGuardar1.setBounds(400, 370, 110, 23);

        cmdBorrar1.setBackground(new java.awt.Color(255, 102, 102));
        cmdBorrar1.setText("BORRAR");
        cmdBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdBorrar1);
        cmdBorrar1.setBounds(530, 370, 110, 23);

        tblImo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblImo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblImo);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 420, 760, 200);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(10, 410, 760, 10);

        cmbUNN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONSOLIDADO", "FULL" }));
        cmbUNN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUNNItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbUNN);
        cmbUNN.setBounds(260, 380, 100, 20);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("sss");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(10, 630, 760, 30);

        txtVolumen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtVolumen);
        txtVolumen.setBounds(420, 40, 60, 20);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VOLUMEN");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 10, 70, 20);

        jLabel5.setText(" KG");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(390, 40, 20, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoBultoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoBultoItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbTipoBultoItemStateChanged

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
        resetearCarga();
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        //  ID, TIPO_BULTOS,ID_MERCADERIA AS MERCADERIA,CANTIDAD_BULTOS AS CANTIDAD,PESO_BULTOS AS PESO 
        
        Carga unC = new Carga();
        lblID.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString());
        cmbTipoBulto.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 1).toString());
        cmbMercaderia.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString());
        txtCantidad.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 3).toString());
        txtPeso.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 4).toString());
        txtVolumen.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 5).toString());
        resetearIMO();
        
    }//GEN-LAST:event_tblListaMouseClicked

    private void cmbImoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbImoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbImoItemStateChanged

    private void cmdActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizar1ActionPerformed
        // TODO add your handling code here:
        resetearIMO();
    }//GEN-LAST:event_cmdActualizar1ActionPerformed

    private void tblImoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImoMouseClicked
        // ID,MARCA AS CONTENEDOR,TIPO_IMO AS IMO,UNN

        lblID1.setText(tblImo.getValueAt(tblImo.getSelectedRow(), 0).toString());
        String imo = tblImo.getValueAt(tblImo.getSelectedRow(), 2).toString();
        cmbImo.setSelectedItem(imo);
        String unn = tblImo.getValueAt(tblImo.getSelectedRow(), 3).toString();
        cmbUNN.setSelectedItem(unn);
            
    }//GEN-LAST:event_tblImoMouseClicked

    private void cmbUNNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUNNItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUNNItemStateChanged

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:

        Carga unC = new Carga();
        unC.id = lblID.getText();
        unC.id_reserva = miReserva.id_reserva;
        unC.marca = miContenedor.id;
        unC.cantidad_bultos = txtCantidad.getText();
        unC.peso_bultos = txtPeso.getText();
        unC.id_mercaderia = cmbMercaderia.getSelectedItem().toString();
        unC.tipo_bultos = cmbTipoBulto.getSelectedItem().toString();
        unC.volumen = txtVolumen.getText();
        unC.guardar();
        resetearCarga();

    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        Carga unC = new Carga();
        unC.id = lblID.getText();
        unC.borrar();
        resetearCarga();
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmdGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardar1ActionPerformed
        // TODO add your handling code here:
        if(lblID.getText().equals("0") == false)
        {
            Imo uni = new Imo();
            uni.id = lblID1.getText();
            uni.id_carga = lblID.getText();
            uni.id_reserva = miReserva.id_reserva;
            uni.marca = miContenedor.marca;
            uni.tipo_imo = cmbImo.getSelectedItem().toString();
            uni.unn = cmbUNN.getSelectedItem().toString();
            uni.guardar();
            resetearIMO();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una carga para declarar el imo");
        }
    }//GEN-LAST:event_cmdGuardar1ActionPerformed

    private void cmdBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrar1ActionPerformed
        // TODO add your handling code here:
        if(lblID1.getText().equals("0") == false)
        {
            Imo uni = new Imo();
            uni.id = lblID1.getText();
            uni.borrar();
            resetearIMO();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un imo");
        }
    }//GEN-LAST:event_cmdBorrar1ActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbImo;
    private javax.swing.JComboBox cmbMercaderia;
    private javax.swing.JComboBox cmbTipoBulto;
    private javax.swing.JComboBox cmbUNN;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdActualizar1;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdBorrar1;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdGuardar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler2;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel labeler4;
    private javax.swing.JLabel labeler5;
    private javax.swing.JLabel labeler7;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JTable tblImo;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
