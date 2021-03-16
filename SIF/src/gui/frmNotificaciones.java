package gui;

import domain.BD;
import domain.archivo;
import domain.ComponentesLista;
import domain.Mail;
import domain.Notificacion;
import domain.Reserva;
import domain.adjuntos;
import domain.usuarios;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class frmNotificaciones extends javax.swing.JFrame {

    Reserva miReserva = new Reserva();
    usuarios miUsuario;

    public void completarArchivo(String string, String name)
    {
        lblAdjunto.setText(string + name);
        if(lblID.equals("0") == false)
        {
            String anterior = tblLista.getValueAt(tblLista.getSelectedRow(), 7).toString();
            SimpleDateFormat unS = new SimpleDateFormat("yyyyMMddHHmmss");
            String ruta = unS.format(new Date()) + name.replace(" ","");
            archivo.copyFile(new File(lblAdjunto.getText()), new File ("\\\\serversif\\sistemas\\ADJUNTOS\\cargas\\" + ruta));
            Notificacion unN = new Notificacion();
            unN.guardarArchivo(ruta, lblID.getText());
            archivo.eliminarArchivoDirectorio(new File ("\\\\serversif\\sistemas\\ADJUNTOS\\cargas\\" + anterior));
            cmdActualizarActionPerformed(null);
        }
    }
    
    //METODOS
    public void abrir(Reserva r, usuarios u)
    {   
        miUsuario = u;
        //setLocationRelativeTo(null);
        this.setTitle("Notificaciones    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(820, 620));
        this.setVisible(true);       
        miReserva = r;
        lblEstado.setText("Reserva: " + r.numero_sif + "      ID: " + r.id_reserva + "      Cliente: " + r.entidad_cliente );
        resetear();
    }
    
    public void resetear()
    {
        ComponentesLista unc = new ComponentesLista();
        unc.cargarTabla("Select ID, MAILFROM, MAILTO, CLIENTE, NOTIFICACION, ASUNTO, DATE_FORMAT(Fecha, \"%d-%m-%Y %H:%i\") as FECHA, adjunto as ADJUNTO from sif_notificaciones where reserva = '" + miReserva.id_reserva + "'", tblLista);
        txtMailto.setText(miReserva.darMailCliente());
        txtNotificacion.setText("");
        lblID.setText("0");
        txtAsunto.setText(miReserva.asunto());
        lblAdjunto.setText("");
    }
    
    public frmNotificaciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        labeler2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotificacion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMailto = new javax.swing.JTextArea();
        lblEstado = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        labeler3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labeler4 = new javax.swing.JLabel();
        lblAdjunto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        chkCarga = new javax.swing.JCheckBox();
        chkInfo = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        chkHouse = new javax.swing.JCheckBox();
        chkTarifas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(60, 10, 50, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeler.setText("NOTIFICACION:");
        getContentPane().add(labeler);
        labeler.setBounds(10, 110, 460, 20);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeler1.setText("ADJUNTO:");
        getContentPane().add(labeler1);
        labeler1.setBounds(10, 50, 70, 20);

        labeler2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeler2.setText("MAIL TO:");
        getContentPane().add(labeler2);
        labeler2.setBounds(480, 110, 290, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 240, 760, 20);

        cmdActualizar.setBackground(new java.awt.Color(0, 153, 204));
        cmdActualizar.setText("ACTUALIZAR");
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdActualizar);
        cmdActualizar.setBounds(660, 10, 110, 23);

        cmdGuardar.setBackground(new java.awt.Color(102, 255, 102));
        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar);
        cmdGuardar.setBounds(430, 10, 100, 23);

        cmdBorrar.setBackground(new java.awt.Color(255, 102, 102));
        cmdBorrar.setText("BORRAR");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdBorrar);
        cmdBorrar.setBounds(540, 10, 110, 23);

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
        jScrollPane1.setBounds(10, 250, 760, 250);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 40, 760, 10);

        txtNotificacion.setColumns(20);
        txtNotificacion.setLineWrap(true);
        txtNotificacion.setRows(5);
        txtNotificacion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtNotificacion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 130, 460, 100);

        txtMailto.setColumns(20);
        txtMailto.setLineWrap(true);
        txtMailto.setRows(5);
        txtMailto.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtMailto);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(480, 130, 290, 100);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("sss");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(10, 530, 760, 40);
        getContentPane().add(txtAsunto);
        txtAsunto.setBounds(70, 80, 700, 20);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeler3.setText("ID:");
        getContentPane().add(labeler3);
        labeler3.setBounds(20, 10, 40, 20);

        jButton1.setText("ENVIAR MAIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(640, 510, 130, 23);

        labeler4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeler4.setText("ASUNTO:");
        getContentPane().add(labeler4);
        labeler4.setBounds(10, 80, 70, 20);
        getContentPane().add(lblAdjunto);
        lblAdjunto.setBounds(70, 50, 590, 20);

        jButton2.setText("VER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(700, 50, 70, 23);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(670, 50, 20, 23);

        chkCarga.setText("Carga");
        getContentPane().add(chkCarga);
        chkCarga.setBounds(280, 510, 100, 23);

        chkInfo.setText("Información General");
        getContentPane().add(chkInfo);
        chkInfo.setBounds(10, 510, 160, 23);

        jButton4.setText("TEST");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(503, 510, 120, 23);

        chkHouse.setText("Master");
        chkHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHouseActionPerformed(evt);
            }
        });
        getContentPane().add(chkHouse);
        chkHouse.setBounds(170, 510, 100, 23);

        chkTarifas.setText("Tarifas");
        chkTarifas.setEnabled(false);
        getContentPane().add(chkTarifas);
        chkTarifas.setBounds(390, 510, 100, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
        resetear();
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // TODO add your handling code here:
        Notificacion unN = new Notificacion();
        lblID.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString());
        txtMailto.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString());
        txtNotificacion.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 4).toString());
        txtAsunto.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 5).toString());
        lblAdjunto.setText(tblLista.getValueAt(tblLista.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tblListaMouseClicked

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        Notificacion unN = new Notificacion();
        unN.id = lblID.getText();
        unN.cliente = miReserva.entidad_cliente;
        unN.mailfrom = "info@sif.com.uy";
        unN.mailto = txtMailto.getText();
        unN.notificacion = txtNotificacion.getText();
        unN.reserva = miReserva.id_reserva;
        unN.asunto = txtAsunto.getText();
        unN.guardar();
        resetear();
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        Notificacion unN = new Notificacion();
        unN.id = lblID.getText();
        unN.borrar();
        resetear();
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(lblID.getText().equals("0") == false)
        {
            ArrayList pers = new ArrayList();
            String cc = txtMailto.getText().replace(",", ";");

            String mails [] = cc.split(";");

            for(int i = 0; mails.length > i; i++)
            {
                String to = mails[i];
                to = to.replace(" ", "");
                pers.add(mails[i]);
            }

            enviar(pers);

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe marcar una notificación para enviar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public String cargarInfo()
    {
        boolean entre = false;
        String flag = "";
        
        BD unB = new BD();
        String url = "SELECT numero_sif, entidad_cliente, origen, destino, trasbordo1, trasbordo2, transporte_entidad, transporte_nombre, transporte_viaje, DATE_FORMAT(etd, '%d-%m-%Y') AS ETD, DATE_FORMAT(eta, '%d-%m-%Y') AS ETA, proveedor_entidad, agente_entidad, estado, house_bl, house_tipo FROM sif_reservas where id_reserva = '" + miReserva.id_reserva + "'";
      
        flag = "<left><table border = 0 cellspacing = 0 cellpadding = 1 width = '50%'>";
        
        try
        {
            CachedRowSet lista = unB.Function(url);
            if (lista.next()) 
            {                
                String tit = "";
                entre = true;
                flag += "<font size = 10><tr valign = center align = left><td><b><p>Ref. SIF:</p></b></td><td><p>" + lista.getString("numero_sif") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>CLIENTE / CUSTOMER:</p></b></td><td><p>" + lista.getString("entidad_cliente") + "</p></td></tr>";
                if(chkHouse.isSelected())
                {
                    if(miReserva.tipo_embarque.equals("MARITIMO")){tit = "MBL";} if(miReserva.tipo_embarque.equals("AEREO")){tit = "MAWB";} if(miReserva.tipo_embarque.equals("TERRESTRE")){tit = "MIC DTA";}
                    flag += "<tr valign = center align = left><td><b><p>" + tit + ":</p></b></td><td><p>" + miReserva.master_bl + "</p></td></tr>";    
                }                
                if(miReserva.tipo_embarque.equals("MARITIMO")){tit = "HBL";} if(miReserva.tipo_embarque.equals("AEREO")){tit = "HAWB";} if(miReserva.tipo_embarque.equals("TERRESTRE")){tit = "CRT";}
                flag += "<tr valign = center align = left><td><b><p>" + tit + ":</p></b></td><td><p>" + lista.getString("house_bl") + " " + lista.getString("house_tipo") + "</p></td></tr>";
                if(miReserva.tipo_embarque.equals("AEREO")){tit = "AOL";} else{tit = "POL";} 
                flag += "<tr valign = center align = left><td><b><p>" + tit + ":</p></b></td><td><p>" + lista.getString("origen") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>TRANSHIPMENT:</p></b></td><td><p>" + lista.getString("trasbordo1") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>TRANSHIPMENT:</p></b></td><td><p>" + lista.getString("trasbordo2") + "</p></td></tr>";
                if(miReserva.tipo_embarque.equals("AEREO")){tit = "AOD";} else{tit = "POD";}
                flag += "<tr valign = center align = left><td><b><p>" + tit + ":</b></p></td><td><p>" + lista.getString("destino") + "</p></td></tr>";
                if(miReserva.tipo_embarque.equals("MARITIMO")){tit = "TRANSPORTE / CARRIER";} if(miReserva.tipo_embarque.equals("AEREO")){tit = "AEROLINEA / AIRLINE";} if(miReserva.tipo_embarque.equals("TERRESTRE")){tit = "TRANSPORTISTA";}
                flag += "<tr valign = center align = left><td><b><p>Transporte:</p></b></td><td><p>" + lista.getString("transporte_entidad") + "</p></td></tr>";
                if(miReserva.tipo_embarque.equals("MARITIMO"))
                {
                    flag += "<tr valign = center align = left><td><b><p>BUQUE / VESSEL:</p></b></td><td><p>" + lista.getString("transporte_nombre") + "</p></td></tr>";                
                }
                if(miReserva.tipo_embarque.equals("TERRESTRE") == false)
                {
                    flag += "<tr valign = center align = left><td><b><p>VIAJE / VOYAGE:</p></b></td><td><p>" + lista.getString("transporte_viaje") + "</p></td></tr>";
                }
                flag += "<tr valign = center align = left><td><b><p>ETD:</p></b></td><td><p>" + lista.getString("ETD") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>ETA:</p></b></td><td><p>" + lista.getString("ETA") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>PROVEEDOR / SHIPPER:</p></b></td><td><p>" + lista.getString("proveedor_entidad") + "</p></td></tr>";
                flag += "<tr valign = center align = left><td><b><p>AGENTE / AGENT:</p></b></td><td><p>" + lista.getString("agente_entidad") + "</p></td></tr></font>";
                
            }
            
        }
        catch(Exception ex)
        {
        
        }
        if(entre)
        {
            //flag += "</table><br></left>";
        }
        else
        {
            flag = "";
        }
        
        return flag;
    }
        
    public String cargarCargaFull()
    {
        boolean entre = false;
        String flag = "";
        
        BD unB = new BD();
        String url = "SELECT tipo, c.marca, precintos, SUM(ca.peso_bultos) AS PESOS " +
        "FROM sif_contenedores c, sif_cargas ca WHERE c.id_reserva = '" + miReserva.id_reserva + "' AND ca.marca = c.id AND c.tipo_carga = 'FULL'  GROUP BY ca.marca";
                
        String typ = "", fcl = "", qty = "", seal = "", wei = "";
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {                
                entre = true;
                typ = typ + "," + lista.getString(1);
                fcl = fcl + "," + lista.getString(2);
                //qty = qty + "," + lista.getString(3);
                seal = seal + "," + lista.getString(3);
                wei = wei + "," + lista.getString(4);
            }
            typ = typ.substring(1, typ.length());
            fcl = fcl.substring(1, fcl.length());
            //qty = qty.substring(1, qty.length());
            seal = seal.substring(1, seal.length());
            wei = wei.substring(1, wei.length());
            
        }
        catch(Exception ex)
        {
        
        }
        if(entre)
        {
            flag += "<tr bgcolor = 'cyan'><td><p>TIPO / TYPE:</p></td><td><p>" + typ + "</p></td></tr>";
            flag += "<tr bgcolor = 'cyan'><td><p>FCL NO:</p></td><td><p>" + fcl + "</p></td></tr>";
            //flag += "<tr bgcolor = 'cyan'><td><p>CANTIDAD / QTY:</p></td><td><p>" + qty + "</p></td></tr>";
            flag += "<tr bgcolor = 'cyan'><td><p>PRECINTO / SEAL:</p></td><td><p>" + seal + "</p></td></tr>";
            flag += "<tr bgcolor = 'cyan'><td><p>PESO / WEIGHT:</p></td><td><p>" + wei + "</p></td></tr>";                
            flag += "</table><br></left>";
        }
        else
        {
            flag = "";
        }
        
        return flag;
    }
    
    
    public String cargarCargaConsolidada()
    {
        boolean entre = false;
        String flag = "";
        
        BD unB = new BD();
        String url = "SELECT ca.tipo_bultos, CONCAT(ca.largo, ' X ', ca.ancho, ' X ', ca.alto, ' mts') AS medidas, ca.peso_bultos as peso FROM sif_contenedores c, sif_cargas_consolidadas ca " +
        "WHERE c.id_reserva = '" + miReserva.id_reserva + "' AND ca.id_reserva = c.id_reserva AND c.tipo_carga = 'CONSOLIDADO' order by ca.tipo_bultos";
      
        flag = "<left><p>CARGA / CHARGE</p><table border = 1 cellspacing = 0 cellpadding = 4  width = '50%'>";
        flag += "<tr bgcolor = 'cyan'><td><p>TIPO / TYPE</p></td><td><p>MEDIDAS / DIMENSIONS</p></td><td><p>PESO / WEIGHT</p></td></tr>";
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {                
                entre = true;
                flag += "<tr valign = center align = left><td><p>" + lista.getString("tipo_bultos") + "</p></td>";
                flag += "<td><p>" + lista.getString("medidas") + "</p></td>";
                flag += "<td><p>" + lista.getString("peso") + "</p></td></tr>";
            }
            
        }
        catch(Exception ex)
        {
        
        }
        if(entre)
        {
            flag += "</table><br></left>";
        }
        else
        {
            flag = "";
        }
        
        return flag;
    }
    

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(lblID.getText().equals("0") == false)
        {
            frmSelectorDOC S = new frmSelectorDOC();
            S.abrir(this);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe guardar una notificación antes de asignar un adjunto");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(lblID.getText().equals("0") == false)
        {
            String ruta = "\\\\serversif\\sistemas\\ADJUNTOS\\cargas\\" + lblAdjunto.getText();
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ ruta);
            } catch (IOException ex) {
                Logger.getLogger(frmNotificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(lblID.getText().equals("0") == false)
        {
            ArrayList pers = new ArrayList();
            pers.add("gsuarez22@yahoo.com");
            pers.add("ignacio@sif.com.uy");
            pers.add("info@sif.com.uy");
            enviar(pers);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe marcar una notificación para enviar");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void chkHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkHouseActionPerformed

    public void enviar(ArrayList pers)
    {
            String asunto = txtAsunto.getText();
            
            ArrayList unL = new ArrayList();

            if(lblAdjunto.getText().equals("") == false)
            {
                adjuntos ad = new adjuntos();
                ad.nombre = lblAdjunto.getText();
                ad.adjunto = "\\\\serversif\\sistemas\\ADJUNTOS\\cargas\\" + lblAdjunto.getText();
                unL.add(ad);
            }

            String bod = "<center><img src = 'http://eneclick.net/sif/sif.png' width = 30%><br>";
            bod = bod + "<H3>" + txtNotificacion.getText().replace("\n", "<BR>") + "<H3>";
           
            if(chkInfo.isSelected()){bod = bod + cargarInfo();}
            
            if(chkCarga.isSelected()){bod = bod + cargarCargaFull() + cargarCargaConsolidada();}
            
            //if(chkTarifas.isSelected()){bod = bod + cargarTarifas();}
            
            bod = bod + "</table><br></left></center>";
            
            Mail unM = new Mail ("", asunto, bod, "", unL, pers, "CC", miUsuario.firma);  

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkCarga;
    private javax.swing.JCheckBox chkHouse;
    private javax.swing.JCheckBox chkInfo;
    private javax.swing.JCheckBox chkTarifas;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler2;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel labeler4;
    private javax.swing.JLabel lblAdjunto;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextArea txtMailto;
    private javax.swing.JTextArea txtNotificacion;
    // End of variables declaration//GEN-END:variables
}
