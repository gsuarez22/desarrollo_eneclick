
package gui;

import domain.ComponentesLista;
import domain.Contenedor;
import domain.Notificacion;
import domain.Reserva;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class frmContenedores extends javax.swing.JFrame {

    Reserva miReserva = new Reserva();
  
    public frmContenedores() {
        initComponents();
    }

    //METODOS
    public void abrir(Reserva r)
    {   
        //setLocationRelativeTo(null);
        this.setTitle("Contenedores    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);       
        miReserva = r;
        lblEstado.setText("Reserva: " + r.numero_sif + "      ID: " + r.id_reserva + "      Cliente: " + r.entidad_cliente );
        resetear();
    }

    public void resetear()
    {
        ComponentesLista unc = new ComponentesLista();
        unc.cargarTabla("Select ID, MARCA, TIPO, TIPO_CARGA, PRECINTOS from sif_contenedores where id_reserva = '" + miReserva.id_reserva + "'", tblLista);
        lblID.setText("0");
        txtMarca.setText("");
        txtPrecintos.setText("");
        cmbTipo.setSelectedItem(" ");
        cmbTipo.setVisible(false);
        titi.setVisible(false);
        toto.setVisible(false);
        txtPrecintos.setVisible(false);
        if(miReserva.tipo_embarque.equals("MARITIMO")){cmbTipo.setVisible(true);titi.setVisible(true);toto.setVisible(true);txtPrecintos.setVisible(true);}
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        txtPrecintos = new javax.swing.JTextField();
        toto = new javax.swing.JLabel();
        labeler3 = new javax.swing.JLabel();
        cmbTipo_Carga = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cmbTipo = new javax.swing.JComboBox();
        cmdCarga = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        lblEstado = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        titi = new javax.swing.JLabel();

        jButton2.setBackground(new java.awt.Color(255, 153, 255));
        jButton2.setText("NOTIFICACIONES");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(20, 40, 90, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler.setText("CONTENEDOR");
        getContentPane().add(labeler);
        labeler.setBounds(120, 20, 100, 14);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler1.setText("ID");
        getContentPane().add(labeler1);
        labeler1.setBounds(20, 10, 90, 20);

        txtPrecintos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrecintos);
        txtPrecintos.setBounds(240, 40, 170, 20);

        toto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toto.setText("PRECINTOS");
        getContentPane().add(toto);
        toto.setBounds(240, 20, 170, 14);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler3.setText("TIPO CARGA");
        getContentPane().add(labeler3);
        labeler3.setBounds(570, 20, 190, 14);

        cmbTipo_Carga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONSOLIDADO", "FULL" }));
        cmbTipo_Carga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipo_CargaItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTipo_Carga);
        cmbTipo_Carga.setBounds(570, 40, 190, 20);
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
        jScrollPane1.setBounds(10, 140, 760, 370);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "DRY 20", "DRY 40", "HIGH CUBE 40", "REEFER 20", "REEFER 40", "ESPECIAL 20", "ESPECIAL 40" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(430, 40, 130, 20);

        cmdCarga.setBackground(new java.awt.Color(204, 204, 0));
        cmdCarga.setText("CARGA");
        cmdCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCargaActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCarga);
        cmdCarga.setBounds(663, 90, 100, 23);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 70, 760, 20);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("sss");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(10, 520, 760, 30);

        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMarca);
        txtMarca.setBounds(120, 40, 100, 20);

        titi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titi.setText("TIPO CONTENEDOR");
        getContentPane().add(titi);
        titi.setBounds(430, 20, 130, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipo_CargaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipo_CargaItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbTipo_CargaItemStateChanged

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
 
        resetear();
 
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // ID, MARCA, TIPO, TIPO_CARGA, PRECINTOS
        Notificacion unN = new Notificacion();
        lblID.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString());
        txtMarca.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 1).toString());
        cmbTipo.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString());
        cmbTipo_Carga.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 3).toString());
        txtPrecintos.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tblListaMouseClicked

    private void cmdCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCargaActionPerformed
        // TODO add your handling code here:

        if(cmbTipo_Carga.getSelectedItem().toString().equals("CONSOLIDADO") == false)
        {
            Contenedor c = new Contenedor();
            c.id = lblID.getText();
            c.marca = txtMarca.getText();
            if(c.id.equals("0") == false)
            {
                frmCarga unF = new frmCarga();
                unF.abrir(miReserva, c);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar la carga");
            }
        }
        else
        {
            Contenedor c = new Contenedor();
            c.id = lblID.getText();
            c.marca = txtMarca.getText();
            if(c.id.equals("0") == false)
            {
                frmCargaConsolidado unF = new frmCargaConsolidado();
                unF.abrir(miReserva, c);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar la carga");
            }
        }
        
    }//GEN-LAST:event_cmdCargaActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        Contenedor unC = new Contenedor();
        unC.id = lblID.getText();
        unC.id_reserva = miReserva.id_reserva;
        unC.marca = txtMarca.getText();
        unC.precintos = txtPrecintos.getText();
        unC.tipo = cmbTipo.getSelectedItem().toString();
        unC.tipo_carga = cmbTipo_Carga.getSelectedItem().toString();
        unC.guardar();
        resetear();
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        
        Contenedor unC = new Contenedor();
        unC.id = lblID.getText();
        unC.borrar();
        resetear();

    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbTipo_Carga;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdCarga;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblLista;
    private javax.swing.JLabel titi;
    private javax.swing.JLabel toto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecintos;
    // End of variables declaration//GEN-END:variables
}
