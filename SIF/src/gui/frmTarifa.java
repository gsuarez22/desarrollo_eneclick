
package gui;

import domain.ComponentesLista;
import domain.Contenedor;
import domain.Notificacion;
import domain.Reserva;
import domain.Tarifa;
import domain.usuarios;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class frmTarifa extends javax.swing.JFrame {

    Reserva miReserva = new Reserva();
  
    public frmTarifa() {
        initComponents();
    }

    private usuarios miUsuario = new usuarios(); 
    //METODOS
    public void abrir(Reserva r, usuarios usu)
    {   
        miUsuario = usu;
        //setLocationRelativeTo(null);
        this.setTitle("Tarifas    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);       
        miReserva = r;
        lblEstado.setText("Reserva: " + r.numero_sif + "      ID: " + r.id_reserva + "      Cliente: " + r.entidad_cliente );
        resetear();
    }

    public void resetear()
    {
        ComponentesLista unc = new ComponentesLista();
        unc.cargarTabla("Select ID, TIPO, COMPRA, VENTA, MONEDA, CONTENEDOR from sif_tarifas where id_reserva = '" + miReserva.id_reserva + "'", tblLista);
        unc.cargarCombo("select distinct(tipo) as tipos from sif_tarifas where tipoReserva = '" + miReserva.tipo_embarque + "' order by tipos;", cmbTipoCon);
        lblID.setText("0");
        cmbTipoCon.setSelectedItem("");
        txtCompra.setText("0");
        txtVentas.setText("0");
        cmbTipo.setSelectedItem(" ");
        cmbTipo.setVisible(false);
        titi.setVisible(false);
        if(miReserva.tipo_embarque.equals("MARITIMO")){cmbTipo.setVisible(true);titi.setVisible(true);}
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        txtVentas = new javax.swing.JTextField();
        labeler2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cmbTipoCon = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        lblEstado = new javax.swing.JLabel();
        txtCompra = new javax.swing.JTextField();
        titi = new javax.swing.JLabel();
        cmbMoneda = new javax.swing.JComboBox<>();
        labeler3 = new javax.swing.JLabel();
        labeler5 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();

        jButton2.setBackground(new java.awt.Color(255, 153, 255));
        jButton2.setText("NOTIFICACIONES");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(20, 40, 90, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler.setText("MONEDA");
        getContentPane().add(labeler);
        labeler.setBounds(410, 20, 110, 14);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler1.setText("ID");
        getContentPane().add(labeler1);
        labeler1.setBounds(20, 10, 90, 20);

        txtVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtVentas);
        txtVentas.setBounds(650, 40, 110, 20);

        labeler2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler2.setText("VENTA");
        getContentPane().add(labeler2);
        labeler2.setBounds(650, 20, 110, 14);
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

        cmbTipoCon.setEditable(true);
        cmbTipoCon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DRY 20", "DRY 40", "HIGH CUBE 40", "REEFER 20", "REEFER 40", "ESPECIAL 20", "ESPECIAL 40" }));
        getContentPane().add(cmbTipoCon);
        cmbTipoCon.setBounds(120, 40, 140, 20);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 70, 760, 10);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("sss");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(10, 520, 760, 30);

        txtCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCompra);
        txtCompra.setBounds(530, 40, 110, 20);

        titi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titi.setText("TIPO");
        getContentPane().add(titi);
        titi.setBounds(270, 20, 130, 14);

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD", "UY", "EURO" }));
        getContentPane().add(cmbMoneda);
        cmbMoneda.setBounds(416, 40, 100, 20);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler3.setText("COMPRA");
        getContentPane().add(labeler3);
        labeler3.setBounds(530, 20, 110, 14);

        labeler5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler5.setText("TARIFA");
        getContentPane().add(labeler5);
        labeler5.setBounds(120, 20, 140, 14);

        cmbTipo.setEditable(true);
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "DRY 20", "DRY 40", "HIGH CUBE 40", "REEFER 20", "REEFER 40", "ESPECIAL 20", "ESPECIAL 40" }));
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(270, 40, 130, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
 
        resetear();
 
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // ID, MARCA, TIPO, TIPO_CARGA, PRECINTOS
        Notificacion unN = new Notificacion();
        lblID.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString());
        cmbTipoCon.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 1).toString());
        txtCompra.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString());
        txtVentas.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 3).toString());
        cmbMoneda.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 4).toString());
        cmbTipo.setSelectedItem(tblLista.getValueAt(tblLista.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tblListaMouseClicked

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        Tarifa unC = new Tarifa();
        unC.id = lblID.getText();
        unC.id_reserva = miReserva.id_reserva;
        unC.tipo = cmbTipoCon.getSelectedItem().toString();
        unC.moneda = cmbMoneda.getSelectedItem().toString();
        unC.compra = txtCompra.getText();
        unC.venta = txtVentas.getText();
        unC.tipoReserva = miReserva.tipo_embarque;        
        unC.contenedor = cmbTipo.getSelectedItem().toString();
        unC.guardar();
        resetear();
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        if(lblID.getText().equals("0") == false)
        {        
            Contenedor unC = new Contenedor();
            unC.id = lblID.getText();
            unC.borrar();
            resetear();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para borrar");
        }
    }//GEN-LAST:event_cmdBorrarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbTipoCon;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler2;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel labeler5;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblLista;
    private javax.swing.JLabel titi;
    private javax.swing.JTextField txtCompra;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
