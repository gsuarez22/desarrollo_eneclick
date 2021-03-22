
package gui;

import domain.ComponentesLista;
import domain.Contenedor;
import domain.Reserva;
import domain.usuarios;
import java.awt.Component;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class frmReservas extends javax.swing.JFrame {

    
    public frmReservas() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        txtHOUSEBL = new javax.swing.JTextField();
        txtDrive = new javax.swing.JTextField();
        labeler3 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        txtContrato = new javax.swing.JTextField();
        labeler6 = new javax.swing.JLabel();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        cmbOrigen = new javax.swing.JComboBox();
        labeler8 = new javax.swing.JLabel();
        labeler9 = new javax.swing.JLabel();
        cmbTrasbordo1 = new javax.swing.JComboBox();
        labeler10 = new javax.swing.JLabel();
        cmbTrasbordo2 = new javax.swing.JComboBox();
        labeler11 = new javax.swing.JLabel();
        cmbDestino = new javax.swing.JComboBox();
        labeler12 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        lblMedio = new javax.swing.JLabel();
        cmbMedio = new javax.swing.JComboBox();
        lblVia = new javax.swing.JLabel();
        labeler15 = new javax.swing.JLabel();
        labeler16 = new javax.swing.JLabel();
        txtViaje = new javax.swing.JTextField();
        dtpETA = new com.toedter.calendar.JDateChooser();
        dtpETD = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        labeler17 = new javax.swing.JLabel();
        cmbHOUSETIPO = new javax.swing.JComboBox();
        labeler18 = new javax.swing.JLabel();
        txtMASTERBL = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();
        labeler19 = new javax.swing.JLabel();
        labeler20 = new javax.swing.JLabel();
        cmdIR = new javax.swing.JButton();
        labeler21 = new javax.swing.JLabel();
        cmbMASTERTIPO = new javax.swing.JComboBox();
        labeler22 = new javax.swing.JLabel();
        cmbTransporte_Entidad1 = new javax.swing.JComboBox();
        cmbAgente = new javax.swing.JComboBox();
        labeler23 = new javax.swing.JLabel();
        labeler24 = new javax.swing.JLabel();
        txtNumeroSif = new javax.swing.JTextField();
        cmdContenedor = new javax.swing.JButton();
        cmdNotificaciones = new javax.swing.JButton();
        cmdDetalle = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        labeler25 = new javax.swing.JLabel();
        cmbEmbarque = new javax.swing.JComboBox();
        labeler26 = new javax.swing.JLabel();
        cmbReserva = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblbook = new javax.swing.JLabel();
        txtBooking = new javax.swing.JTextField();
        Labells = new javax.swing.JLabel();
        dtpCRD = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtIncoterm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtConsignee = new javax.swing.JTextField();
        chkCourrier = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(10, 30, 90, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler.setText("HOUSE TIPO");
        labeler.setToolTipText("");
        getContentPane().add(labeler);
        labeler.setBounds(910, 160, 130, 20);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler1.setText("ESTADO");
        getContentPane().add(labeler1);
        labeler1.setBounds(1190, 10, 130, 14);

        txtHOUSEBL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtHOUSEBL);
        txtHOUSEBL.setBounds(770, 180, 130, 20);

        txtDrive.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDrive);
        txtDrive.setBounds(10, 180, 710, 20);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler3.setText("CLIENTE");
        getContentPane().add(labeler3);
        labeler3.setBounds(380, 10, 290, 20);

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbCliente);
        cmbCliente.setBounds(380, 30, 290, 20);

        txtContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtContrato);
        txtContrato.setBounds(1190, 80, 130, 20);

        labeler6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler6.setText("CONTRATO");
        getContentPane().add(labeler6);
        labeler6.setBounds(1190, 60, 130, 20);

        cmdActualizar.setBackground(new java.awt.Color(0, 153, 204));
        cmdActualizar.setText("ACTUALIZAR");
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdActualizar);
        cmdActualizar.setBounds(250, 220, 110, 20);

        cmdGuardar.setBackground(new java.awt.Color(102, 255, 102));
        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar);
        cmdGuardar.setBounds(10, 220, 110, 20);

        cmdBorrar.setBackground(new java.awt.Color(255, 102, 102));
        cmdBorrar.setText("BORRAR");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdBorrar);
        cmdBorrar.setBounds(130, 220, 110, 20);

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
        jScrollPane1.setBounds(10, 260, 1320, 280);

        cmbOrigen.setEditable(true);
        cmbOrigen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrigenItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbOrigen);
        cmbOrigen.setBounds(770, 130, 130, 20);

        labeler8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler8.setText("ORIGEN");
        getContentPane().add(labeler8);
        labeler8.setBounds(770, 110, 130, 20);

        labeler9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler9.setText("TRASBORDO 1");
        getContentPane().add(labeler9);
        labeler9.setBounds(910, 110, 130, 20);

        cmbTrasbordo1.setEditable(true);
        cmbTrasbordo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTrasbordo1ItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTrasbordo1);
        cmbTrasbordo1.setBounds(910, 130, 130, 20);

        labeler10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler10.setText("TRASBORDO 2");
        getContentPane().add(labeler10);
        labeler10.setBounds(1050, 110, 130, 20);

        cmbTrasbordo2.setEditable(true);
        cmbTrasbordo2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTrasbordo2ItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTrasbordo2);
        cmbTrasbordo2.setBounds(1050, 130, 130, 20);

        labeler11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler11.setText("DESTINO");
        getContentPane().add(labeler11);
        labeler11.setBounds(1190, 110, 130, 20);

        cmbDestino.setEditable(true);
        cmbDestino.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDestinoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbDestino);
        cmbDestino.setBounds(1190, 130, 130, 20);

        labeler12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler12.setText("PROVEEDOR");
        getContentPane().add(labeler12);
        labeler12.setBounds(320, 110, 260, 20);

        cmbProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProveedorItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbProveedor);
        cmbProveedor.setBounds(320, 130, 260, 20);

        lblMedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblMedio);
        lblMedio.setBounds(440, 60, 320, 20);

        cmbMedio.setEditable(true);
        cmbMedio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedioItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbMedio);
        cmbMedio.setBounds(440, 80, 320, 20);

        lblVia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVia.setText("VUELO");
        getContentPane().add(lblVia);
        lblVia.setBounds(770, 60, 130, 20);

        labeler15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler15.setText("ETA");
        getContentPane().add(labeler15);
        labeler15.setBounds(1050, 60, 130, 14);

        labeler16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler16.setText("ETD");
        labeler16.setToolTipText("");
        getContentPane().add(labeler16);
        labeler16.setBounds(910, 60, 130, 14);
        getContentPane().add(txtViaje);
        txtViaje.setBounds(770, 80, 130, 20);
        getContentPane().add(dtpETA);
        dtpETA.setBounds(1050, 80, 130, 20);
        getContentPane().add(dtpETD);
        dtpETD.setBounds(910, 80, 130, 20);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 250, 1320, 20);

        labeler17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler17.setText("VINCULO CON EL DRIVE");
        getContentPane().add(labeler17);
        labeler17.setBounds(10, 160, 750, 20);

        cmbHOUSETIPO.setEditable(true);
        getContentPane().add(cmbHOUSETIPO);
        cmbHOUSETIPO.setBounds(910, 180, 130, 20);

        labeler18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler18.setText("MASTER BL");
        getContentPane().add(labeler18);
        labeler18.setBounds(1050, 160, 130, 20);

        txtMASTERBL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMASTERBL);
        txtMASTERBL.setBounds(1050, 180, 130, 20);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDIENTE", "CERRADO", "CANCELADO" }));
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(1190, 30, 130, 20);

        labeler19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler19.setText("MASTER TIPO");
        labeler19.setToolTipText("");
        getContentPane().add(labeler19);
        labeler19.setBounds(1190, 160, 130, 20);

        labeler20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler20.setText("HOUSE BL");
        getContentPane().add(labeler20);
        labeler20.setBounds(770, 160, 130, 20);

        cmdIR.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdIR.setText("IR");
        getContentPane().add(cmdIR);
        cmdIR.setBounds(720, 180, 43, 20);

        labeler21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler21.setText("ID RESERVA");
        getContentPane().add(labeler21);
        labeler21.setBounds(10, 10, 90, 20);

        cmbMASTERTIPO.setEditable(true);
        getContentPane().add(cmbMASTERTIPO);
        cmbMASTERTIPO.setBounds(1190, 180, 130, 20);

        labeler22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler22.setText("TRANSPORTISTA");
        getContentPane().add(labeler22);
        labeler22.setBounds(110, 60, 320, 20);

        cmbTransporte_Entidad1.setEditable(true);
        cmbTransporte_Entidad1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTransporte_Entidad1ItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTransporte_Entidad1);
        cmbTransporte_Entidad1.setBounds(110, 80, 320, 20);

        cmbAgente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAgenteItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbAgente);
        cmbAgente.setBounds(10, 130, 290, 20);

        labeler23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler23.setText("AGENTE");
        getContentPane().add(labeler23);
        labeler23.setBounds(10, 110, 290, 14);

        labeler24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler24.setText("NUMERO SIF");
        getContentPane().add(labeler24);
        labeler24.setBounds(110, 10, 130, 20);

        txtNumeroSif.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNumeroSif);
        txtNumeroSif.setBounds(110, 30, 110, 20);

        cmdContenedor.setBackground(new java.awt.Color(204, 204, 0));
        cmdContenedor.setText("CONTENEDOR");
        cmdContenedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdContenedorActionPerformed(evt);
            }
        });
        getContentPane().add(cmdContenedor);
        cmdContenedor.setBounds(1190, 220, 130, 20);

        cmdNotificaciones.setBackground(new java.awt.Color(255, 153, 255));
        cmdNotificaciones.setText("NOTIFICACIONES");
        cmdNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNotificacionesActionPerformed(evt);
            }
        });
        getContentPane().add(cmdNotificaciones);
        cmdNotificaciones.setBounds(1050, 220, 130, 20);

        cmdDetalle.setText("DETALLE");
        cmdDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDetalleActionPerformed(evt);
            }
        });
        getContentPane().add(cmdDetalle);
        cmdDetalle.setBounds(910, 220, 130, 20);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(10, 210, 1320, 10);

        labeler25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler25.setText("EMBARQUE");
        getContentPane().add(labeler25);
        labeler25.setBounds(910, 10, 130, 20);

        cmbEmbarque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AEREO", "MARITIMO", "TERRESTRE" }));
        cmbEmbarque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmbarqueItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbEmbarque);
        cmbEmbarque.setBounds(910, 30, 130, 20);

        labeler26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler26.setText("RESERVA");
        getContentPane().add(labeler26);
        labeler26.setBounds(1050, 10, 130, 20);

        cmbReserva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IMPO", "EXPO", "TRANSITO", "CROSS-TRADE", " " }));
        cmbReserva.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbReservaItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbReserva);
        cmbReserva.setBounds(1050, 30, 130, 20);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 30, 20, 20);

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setText("TARIFA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(773, 220, 130, 20);

        lblbook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblbook);
        lblbook.setBounds(250, 10, 120, 20);
        getContentPane().add(txtBooking);
        txtBooking.setBounds(250, 30, 120, 20);

        Labells.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Labells.setText("INCOTERM");
        getContentPane().add(Labells);
        Labells.setBounds(800, 10, 100, 14);
        getContentPane().add(dtpCRD);
        dtpCRD.setBounds(680, 30, 110, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CRD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(680, 10, 110, 14);
        getContentPane().add(txtIncoterm);
        txtIncoterm.setBounds(800, 30, 100, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSIGNEE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(590, 110, 170, 20);
        getContentPane().add(txtConsignee);
        txtConsignee.setBounds(589, 130, 170, 20);

        chkCourrier.setText("COURRIER");
        getContentPane().add(chkCourrier);
        chkCourrier.setBounds(10, 70, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     //ATRIBUTOS
    ComponentesLista unC = new ComponentesLista();
    
    //EVENTOS
    
    private void cargarTabla()
    {
       unC.cargarTabla("select * from sif_reservas where tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' and tipo_reserva = '" + cmbReserva.getSelectedItem().toString() + "' and estado = '" + cmbEstado.getSelectedItem().toString() + "' AND fechaentrada > '2021-01-01 00:00:00'  order by -fechaentrada", tblLista);
       // unC.cargarTabla("select * from sif_reservas where tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' and fechaentrada > '2021-01-01 00:00:00'  order by -fechaentrada", tblLista);
    }
    
    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
        resetearCombos();
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void cargarObjetoReserva(Reserva r)
    {
        SimpleDateFormat unS = new SimpleDateFormat("yyyy-MM-dd");
        
        lblID.setText(r.id_reserva);
        cmbCliente.setSelectedItem(r.entidad_cliente);
        cmbEmbarque.setSelectedItem(r.tipo_embarque);
        cmbReserva.setSelectedItem(r.tipo_reserva);
        txtNumeroSif.setText(r.numero_sif);
        txtContrato.setText(r.contrato);
        cmbEstado.setSelectedItem(r.estado);
        cmbTransporte_Entidad1.setSelectedItem(r.transporte_entidad);
        cmbMedio.setSelectedItem(r.transporte_nombre);
        txtViaje.setText(r.transporte_viaje);
        if (r.eta.equals("1900-01-01 00:00:00.0")){dtpETA.setDate(null);} 
        else {
            try{dtpETA.setDate(unS.parse(r.eta));}catch(Exception ex){}
        }
        if (r.etd.equals("1900-01-01 00:00:00.0")){dtpETD.setDate(null);} 
        else {
            try{dtpETD.setDate(unS.parse(r.etd));}catch(Exception ex){}
        }
        cmbAgente.setSelectedItem(r.agente_entidad);
        cmbProveedor.setSelectedItem(r.proveedor_entidad);
        cmbOrigen.setSelectedItem(r.origen);
        cmbTrasbordo1.setSelectedItem(r.trasbordo1);
        cmbTrasbordo2.setSelectedItem(r.trasbordo2);
        cmbDestino.setSelectedItem(r.destino);
        txtDrive.setText(r.url_drive);
        txtHOUSEBL.setText(r.house_bl);
        cmbHOUSETIPO.setSelectedItem(r.house_tipo);
        txtMASTERBL.setText(r.master_bl);
        cmbMASTERTIPO.setSelectedItem(r.master_tipo);
        txtBooking.setText(r.booking);
        
        SimpleDateFormat UND = new SimpleDateFormat("yyyy-MM-dd");
        if (r.crd.equals("1900-01-01")){dtpCRD.setDate(null);} 
        else {
            try{dtpCRD.setDate(UND.parse(r.crd));}catch(Exception ex){dtpCRD.setDate(null);}
        }
        txtIncoterm.setText(r.incoterm);
        txtConsignee.setText(r.consignee);
        if(r.courrier.equals("0")){chkCourrier.setSelected(false);} else{chkCourrier.setSelected(true);};
        
    }
    
    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString();
        r.cargarPorId();
        cargarObjetoReserva(r);
    }//GEN-LAST:event_tblListaMouseClicked

    private void cmbOrigenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrigenItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrigenItemStateChanged

    private void cmbTrasbordo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTrasbordo1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrasbordo1ItemStateChanged

    private void cmbTrasbordo2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTrasbordo2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrasbordo2ItemStateChanged

    private void cmbDestinoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDestinoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDestinoItemStateChanged

    private void cmbProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProveedorItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorItemStateChanged

    private void cmbMedioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMedioItemStateChanged

    private void cmbTransporte_Entidad1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTransporte_Entidad1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTransporte_Entidad1ItemStateChanged

    private void cmbAgenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAgenteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAgenteItemStateChanged

    private void cmbEmbarqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmbarqueItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            unC.cargarCombo("SELECT DISTINCT (transporte_entidad) AS val FROM sif_reservas WHERE  fechaentrada > '2021-01-01 00:00:00' and tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' order by val", cmbTransporte_Entidad1);
            unC.cargarCombo("SELECT DISTINCT (transporte_nombre) AS val FROM sif_reservas WHERE  fechaentrada > '2021-01-01 00:00:00' and tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' order by val", cmbMedio);
            cargarTabla();
            chkCourrier.setVisible(false);
            if(cmbEmbarque.getSelectedItem().toString().equals("MARITIMO"))
            {
                lblMedio.setText("BUQUE");
                lblVia.setText("VIAJE");
                lblbook.setText("BOOKING");
                txtBooking.setEnabled(true);
            }
            
            if(cmbEmbarque.getSelectedItem().toString().equals("AEREO"))
            {
                lblMedio.setText("");
                lblVia.setText("VUELO");
                txtBooking.setEnabled(false);
                lblbook.setText("");
                chkCourrier.setVisible(true);
            }
            
            if(cmbEmbarque.getSelectedItem().toString().equals("TERRESTRE"))
            {
                lblMedio.setText("MIC");
                lblVia.setText("CRT");
                txtBooking.setEnabled(false);
                lblbook.setText("");
            }
        }
    }//GEN-LAST:event_cmbEmbarqueItemStateChanged

    private void cmbReservaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbReservaItemStateChanged
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_cmbReservaItemStateChanged

    private void cmdContenedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdContenedorActionPerformed
     
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = lblID.getText();
        r.cargarPorId();
        if(r.id_reserva.equals("0") == false)
        {
            if(r.tipo_embarque.equals("AEREO"))
            {
                Contenedor c = new Contenedor();
                c = c.traerContenedorAvion(r.id_reserva);
                if(c.id.equals("0") == false)
                {
                    frmCargaConsolidado unF = new frmCargaConsolidado();
                    unF.abrir(r, c);
                }
            }
            else
            {             
                frmContenedores unF = new frmContenedores();
                unF.abrir(r);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar la carga");
        }
     
    }//GEN-LAST:event_cmdContenedorActionPerformed

    private void cmdDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDetalleActionPerformed
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = lblID.getText();
        if(r.id_reserva.equals("0") == false)
        {
            frmDetalle unF = new frmDetalle();
            r.cargarPorId();
            unF.abrir(r);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar detalle");
        }
    }//GEN-LAST:event_cmdDetalleActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        try 
        {
            SimpleDateFormat unS = new SimpleDateFormat("yyyy-MM-dd");
            Reserva r = new Reserva();
            r.id_reserva = lblID.getText();
            r.entidad_cliente = cmbCliente.getSelectedItem().toString();
            r.tipo_embarque = cmbEmbarque.getSelectedItem().toString();
            r.tipo_reserva = cmbReserva.getSelectedItem().toString();
            r.numero_sif = txtNumeroSif.getText();
            r.contrato = txtContrato.getText();
            r.estado = cmbEstado.getSelectedItem().toString();
            r.transporte_entidad = cmbTransporte_Entidad1.getSelectedItem().toString();
            r.transporte_nombre = cmbMedio.getSelectedItem().toString();
            r.transporte_viaje = txtViaje.getText();
            try{r.eta = unS.format(dtpETA.getDate());}catch(Exception ex){r.eta = "1900-01-01";}
            try{r.etd = unS.format(dtpETD.getDate());}catch(Exception ex){r.etd = "1900-01-01";}
            r.agente_entidad = cmbAgente.getSelectedItem().toString();
            r.proveedor_entidad = cmbProveedor.getSelectedItem().toString();
            r.origen = cmbOrigen.getSelectedItem().toString();
            r.trasbordo1 = cmbTrasbordo1.getSelectedItem().toString();
            r.trasbordo2 = cmbTrasbordo2.getSelectedItem().toString();
            r.destino= cmbDestino.getSelectedItem().toString();
            r.url_drive = txtDrive.getText();
            r.house_bl = txtHOUSEBL.getText();
            r.house_tipo = cmbHOUSETIPO.getSelectedItem().toString();
            r.master_bl = txtMASTERBL.getText();
            r.master_tipo = cmbMASTERTIPO.getSelectedItem().toString();
            r.booking = txtBooking.getText();
            
            SimpleDateFormat UND = new SimpleDateFormat("yyyy-MM-dd");
            try{r.crd = UND.format(dtpCRD.getDate());}catch(Exception ex){r.crd = "1900-01-01";}
            r.incoterm = txtIncoterm.getText();
            r.consignee = txtConsignee.getText();
            if(chkCourrier.isSelected()){r.courrier = "1";} else{r.courrier = "0";};

            
            r.guardar();
            JOptionPane.showMessageDialog(null, "Procesado con éxito");
            resetearCombos();
        } 
        catch (Exception e) 
        {
        
        }
        
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = lblID.getText();
        int resultado = JOptionPane.showConfirmDialog(null, "Confirma que desea borrar la reserva " + r.id_reserva);
        if(resultado == 0)
        {
            if(r.borrar())
            {
                JOptionPane.showMessageDialog(null, "Procesado con èxito");
                resetearCombos();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se puede procesar");
            }
        }
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Reserva unr = new Reserva();
        unr.cargarPorSif(txtNumeroSif.getText());
        cargarObjetoReserva(unr);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmdNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNotificacionesActionPerformed
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = lblID.getText();
        if(r.id_reserva.equals("0") == false)
        {
            r.cargarPorId();
            frmNotificaciones unN = new frmNotificaciones();
            unN.abrir(r, miUsuario);        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar notificaciones");
        }

    }//GEN-LAST:event_cmdNotificacionesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Reserva r = new Reserva();
        r.id_reserva = lblID.getText();
        if(r.id_reserva.equals("0") == false)
        {
            r.cargarPorId();
            frmTarifa unN = new frmTarifa();
            unN.abrir(r, miUsuario);        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para anexar notificaciones");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private usuarios miUsuario;
     
    //METODOS
    public void abrir(usuarios u)
    {   
        miUsuario = u;
        //setLocationRelativeTo(null);
        this.setTitle("RESERVAS    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(1350, 600));
        this.setVisible(true);
        resetearCombos();
         txtBooking.setEnabled(false);
    }


    private void resetearCombos()
    {
        //unC.cargarCombo("SELECT DISTINCT (aduana) AS imo FROM sif_puertos ORDER BY imo", cmbOrigen);
        //unC.cargarCombo("SELECT DISTINCT (aduana) AS imo FROM sif_puertos ORDER BY imo", cmbDestino);
        //unC.cargarCombo("SELECT DISTINCT (aduana) AS imo FROM sif_puertos ORDER BY imo", cmbTrasbordo1);
        //unC.cargarCombo("SELECT DISTINCT (aduana) AS imo FROM sif_puertos ORDER BY imo", cmbTrasbordo2);
        unC.cargarCombo("SELECT DISTINCT (origen) AS imo FROM sif_reservas WHERE fechaentrada > '2021-03-10'  ORDER BY imo", cmbOrigen);
        unC.cargarCombo("SELECT DISTINCT (destino) AS imo FROM sif_reservas WHERE fechaentrada > '2021-03-10'  ORDER BY imo", cmbDestino);
        unC.cargarCombo("SELECT DISTINCT (trasbordo1) AS imo FROM sif_reservas WHERE fechaentrada > '2021-03-10'  ORDER BY imo", cmbTrasbordo1);
        unC.cargarCombo("SELECT DISTINCT (trasbordo2) AS imo FROM sif_reservas WHERE fechaentrada > '2021-03-10'  ORDER BY imo", cmbTrasbordo2);
        
        unC.cargarCombo("SELECT DISTINCT (empresa) AS imo FROM sif_entidades where tipo = 'CLIENTE' or mixto = '1' ORDER BY empresa", cmbCliente);
        unC.cargarCombo("SELECT DISTINCT (empresa) AS imo FROM sif_entidades where tipo = 'AGENTE'  or mixto = '1' ORDER BY empresa", cmbAgente);
        unC.cargarCombo("SELECT DISTINCT (empresa) AS imo FROM sif_entidades where tipo = 'PROVEEDOR'  or mixto = '1' ORDER BY empresa", cmbProveedor);
        unC.cargarCombo("SELECT DISTINCT (house_tipo) AS val FROM sif_reservas where fechaentrada > '2021-01-01 00:00:00' order by val", cmbHOUSETIPO);
        unC.cargarCombo("SELECT DISTINCT (master_tipo) AS val FROM sif_reservas where fechaentrada > '2021-01-01 00:00:00'  order by val", cmbMASTERTIPO);
        
        unC.cargarCombo("SELECT DISTINCT (transporte_entidad) AS val FROM sif_reservas WHERE  fechaentrada > '2021-01-01 00:00:00' and tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' order by val", cmbTransporte_Entidad1);
        unC.cargarCombo("SELECT DISTINCT (transporte_nombre) AS val FROM sif_reservas WHERE  fechaentrada > '2021-01-01 00:00:00' and tipo_embarque = '" + cmbEmbarque.getSelectedItem().toString() + "' order by val", cmbMedio);
            
        
        lblID.setText("0");
        txtNumeroSif.setText("");
        txtContrato.setText("");
        txtViaje.setText("");
        dtpETA.setDate(null);
        dtpETD.setDate(null);
        txtDrive.setText("");
        txtHOUSEBL.setText("");
        txtMASTERBL.setText("");     
        txtBooking.setText("");
        chkCourrier.setSelected(false);
        txtIncoterm.setText("");
        dtpCRD.setDate(null);
        txtConsignee.setText("");
        
        cargarTabla();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Labells;
    private javax.swing.JCheckBox chkCourrier;
    private javax.swing.JComboBox cmbAgente;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbDestino;
    private javax.swing.JComboBox cmbEmbarque;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbHOUSETIPO;
    private javax.swing.JComboBox cmbMASTERTIPO;
    private javax.swing.JComboBox cmbMedio;
    private javax.swing.JComboBox cmbOrigen;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox cmbReserva;
    private javax.swing.JComboBox cmbTransporte_Entidad1;
    private javax.swing.JComboBox cmbTrasbordo1;
    private javax.swing.JComboBox cmbTrasbordo2;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdContenedor;
    private javax.swing.JButton cmdDetalle;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdIR;
    private javax.swing.JButton cmdNotificaciones;
    private com.toedter.calendar.JDateChooser dtpCRD;
    private com.toedter.calendar.JDateChooser dtpETA;
    private com.toedter.calendar.JDateChooser dtpETD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler10;
    private javax.swing.JLabel labeler11;
    private javax.swing.JLabel labeler12;
    private javax.swing.JLabel labeler15;
    private javax.swing.JLabel labeler16;
    private javax.swing.JLabel labeler17;
    private javax.swing.JLabel labeler18;
    private javax.swing.JLabel labeler19;
    private javax.swing.JLabel labeler20;
    private javax.swing.JLabel labeler21;
    private javax.swing.JLabel labeler22;
    private javax.swing.JLabel labeler23;
    private javax.swing.JLabel labeler24;
    private javax.swing.JLabel labeler25;
    private javax.swing.JLabel labeler26;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel labeler6;
    private javax.swing.JLabel labeler8;
    private javax.swing.JLabel labeler9;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMedio;
    private javax.swing.JLabel lblVia;
    private javax.swing.JLabel lblbook;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtBooking;
    private javax.swing.JTextField txtConsignee;
    private javax.swing.JTextField txtContrato;
    private javax.swing.JTextField txtDrive;
    private javax.swing.JTextField txtHOUSEBL;
    private javax.swing.JTextField txtIncoterm;
    private javax.swing.JTextField txtMASTERBL;
    private javax.swing.JTextField txtNumeroSif;
    private javax.swing.JTextField txtViaje;
    // End of variables declaration//GEN-END:variables
}
