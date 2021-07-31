
package gui;

import com.sun.rowset.CachedRowSetImpl;
import dominio.BD;
import dominio.ComponentesLista;
import dominio.GeneradorCargas;
import dominio.bl;
import dominio.container;
import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class frmSubirArchivoMSC extends javax.swing.JFrame {

    public ArrayList equipos, canchas, partidos;
    
    public frmSubirArchivoMSC() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdProcesar = new javax.swing.JButton();
        cmdsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCOntT = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCant = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBuques = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCOnt = new javax.swing.JTable();
        lblBls = new javax.swing.JLabel();
        lblContenedores = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblContenedoresbl = new javax.swing.JLabel();
        lblRe = new javax.swing.JLabel();
        lblsuma = new javax.swing.JLabel();
        cmdCargas = new javax.swing.JButton();
        chkTcp = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmdProcesar.setText("CARGAR");
        cmdProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdProcesar);
        cmdProcesar.setBounds(670, 10, 100, 20);

        cmdsearch.setText("...");
        cmdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsearchActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsearch);
        cmdsearch.setBounds(630, 10, 30, 23);

        jLabel1.setText("ARCHIVO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 20);
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(100, 10, 510, 20);

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
        jScrollPane1.setBounds(20, 200, 1150, 140);

        tblCOntT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCOntT);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 490, 900, 90);

        tblCant.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCantMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCant);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(930, 370, 240, 210);

        tblBuques.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuquesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBuques);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 70, 1160, 100);

        jLabel3.setText("CONTENEDORES");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 470, 420, 20);

        jLabel4.setText("BUQUE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 40, 580, 20);

        jLabel5.setText("BL");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 180, 760, 20);

        jLabel6.setText("RESUMEN MANIFIESTO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(930, 350, 180, 20);

        tblCOnt.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblCOnt);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(10, 370, 900, 90);

        lblBls.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBls.setForeground(new java.awt.Color(0, 0, 255));
        lblBls.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBls.setText("0");
        getContentPane().add(lblBls);
        lblBls.setBounds(1100, 340, 70, 20);

        lblContenedores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblContenedores.setForeground(new java.awt.Color(255, 0, 0));
        lblContenedores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContenedores.setText("0");
        getContentPane().add(lblContenedores);
        lblContenedores.setBounds(840, 580, 70, 20);

        jLabel9.setText("CONTENEDORES POR BL");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 350, 510, 20);

        lblContenedoresbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblContenedoresbl.setForeground(new java.awt.Color(255, 0, 0));
        lblContenedoresbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContenedoresbl.setText("0");
        getContentPane().add(lblContenedoresbl);
        lblContenedoresbl.setBounds(840, 460, 70, 20);

        lblRe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRe.setForeground(new java.awt.Color(0, 0, 255));
        lblRe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRe.setText("0");
        getContentPane().add(lblRe);
        lblRe.setBounds(960, 580, 70, 20);

        lblsuma.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblsuma.setForeground(new java.awt.Color(255, 0, 0));
        lblsuma.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblsuma.setText("0");
        getContentPane().add(lblsuma);
        lblsuma.setBounds(1080, 580, 70, 20);

        cmdCargas.setText("EXPORTAR");
        cmdCargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCargasActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCargas);
        cmdCargas.setBounds(1000, 10, 100, 23);

        chkTcp.setSelected(true);
        chkTcp.setText("TCP");
        getContentPane().add(chkTcp);
        chkTcp.setBounds(1110, 10, 60, 23);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Quitar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1090, 170, 80, 20);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MSC", "COSCO", "HAPAG" }));
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(780, 10, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsearchActionPerformed
        // TODO add your handling code here:
        frmSelectorA unS = new frmSelectorA();
        unS.abrir(this);
    }//GEN-LAST:event_cmdsearchActionPerformed
    
    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:
        if (cmbTipo.getSelectedItem().toString().equals("MSC"))
        {
            try{procesarExcel();}catch(Exception ex){}
        }
        if (cmbTipo.getSelectedItem().toString().equals("COSCO"))
        {
            try{procesarExcelCosco();}catch(Exception ex){}
        }
        if (cmbTipo.getSelectedItem().toString().equals("HAPAG"))
        {
            try{procesarExcelHapag();}catch(Exception ex){}
        }
    }//GEN-LAST:event_cmdProcesarActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // TODO add your handling code here:
        String valor = tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString();
        //String buque = tblLista.getValueAt(tblLista.getSelectedRow(), 1).toString();
        //String viaje = tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString();
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select numero_bl AS BL, numero_con AS CONTENEDOR, tipoequipoOPUS_con AS TIPO, precinto_con AS PRECINTO, peso_con AS PESO from bridge_contenedores where numero_bl = '" + valor + "'", tblCOnt);
        lblContenedoresbl.setText(String.valueOf(tblCOnt.getRowCount()));
          
       
      
    }//GEN-LAST:event_tblListaMouseClicked

    private void tblBuquesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuquesMouseClicked
        // TODO add your handling code here:
        ComponentesLista unc = new ComponentesLista();
        
        String buque = tblBuques.getValueAt(tblBuques.getSelectedRow(), 0).toString();
        String viaje = tblBuques.getValueAt(tblBuques.getSelectedRow(), 1).toString();
        String eta = tblBuques.getValueAt(tblBuques.getSelectedRow(), 2).toString();
        
        unc.cargarTabla("SELECT numero_bl AS BL, buque_bl AS BUQUE, viaje_bl AS VIAJE, eta_bl AS ETA, cargador_bl AS SHIPPER, consignatario_bl AS CONSIGNEE, notificador_bl AS NOTIFY, origen_bl AS ORIGEN, destino_bl AS DESTINO, origencodigo_bl as COD_ORIGEN, destinocodigo_bl AS COD_DESTINO, pesototal_bl as PESO, cantidaddebultos_bl as BULTOS, tipobultos_bl  AS TIPO from bridge_bls where buque_bl = '" + buque + "' AND viaje_bl = '" + viaje + "' and eta_bl = '" + eta + "' order by numero_bl", tblLista);
        unc.cargarTabla("SELECT c.numero_bl AS BL, numero_con AS CONTENEDOR, tipoequipoOPUS_con AS TIPO, precinto_con AS PRECINTO, peso_con AS PESO FROM bridge_contenedores c, bridge_bls b WHERE b.buque_bl = '" + buque + "' AND b.viaje_bl =  '" + viaje + "' AND b.eta_bl = '" + eta + "' AND b.numero_bl = c.numero_bl ORDER BY c.numero_con", tblCOntT);
        lblContenedores.setText(String.valueOf(tblCOntT.getRowCount()));
        lblBls.setText(String.valueOf(tblLista.getRowCount()));
                
        String url = "SELECT c.numero_bl AS BL, COUNT(c.numero_con) AS CANTIDAD FROM bridge_bls b, bridge_contenedores c WHERE b.buque_bl = '" + buque + "' AND b.viaje_bl = '" + viaje + "' AND b.eta_bl = '" + eta +  "' AND c.numero_bl = b.numero_bl  "
                + "GROUP BY b.numero_bl ORDER BY cantidad DESC, c.numero_bl";
        unc.cargarTabla(url, tblCant);
        lblRe.setText(String.valueOf(tblCant.getRowCount()));
        sumarContenedores();
        
        actualizarPesoBultos(buque, viaje, eta);
        
    }//GEN-LAST:event_tblBuquesMouseClicked

    private void actualizarPesoBultos (String buque, String viaje, String eta)
    {
        BD unB = new BD();

        String url = "SELECT COUNT(c.id_con) cantidad, SUM(c.peso_con) pesototal, c.numero_bl FROM bridge_contenedores c, bridge_bls bl WHERE c.numero_bl = bl.numero_bl AND buque_bl = '" + buque + "' AND viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "' and pesototal_bl IS NULL GROUP BY bl.numero_bl";
        ArrayList actualizar = new ArrayList();
        try
        {
            CachedRowSet lista = unB.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                //actualizar.add ("update bridge_bls set cantidaddebultos_bl = '" + lista.getString(1) + "', pesototal_bl = '" + lista.getString(2) + "' where numero_bl = '" + lista.getString(3) + "'  AND buque_bl = '" + buque + "' AND viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'");
                actualizar.add ("update bridge_bls set pesototal_bl = '" + lista.getString(2) + "' where numero_bl = '" + lista.getString(3) + "'  AND buque_bl = '" + buque + "' AND viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'");
            }
        }
        catch (Exception ex)
        {
        }
 
        unB.Todos(actualizar);
        
    }
    
    private void sumarContenedores()
    {
        int i = 0;
        int suma = 0;
        while (tblCant.getRowCount() > i)
        {
            try{String cant = tblCant.getValueAt(i, 1).toString();
            suma = suma + Integer.parseInt(cant);} catch(Exception ex){}
            i++;
        }
        lblsuma.setText (String.valueOf(suma));
    }    
    
    private void tblCantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCantMouseClicked
        // TODO add your handling code here:
        String valor = tblCant.getValueAt(tblCant.getSelectedRow(), 0).toString();
        
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select numero_bl AS BL, numero_con AS CONTENEDOR, tipoequipoOPUS_con AS TIPO, precinto_con AS PRECINTO, peso_con AS PESO from bridge_contenedores where numero_bl = '" + valor + "'", tblCOnt);
        lblContenedoresbl.setText(String.valueOf(tblCOnt.getRowCount()));
    }//GEN-LAST:event_tblCantMouseClicked

    private void cmdCargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCargasActionPerformed
        // TODO add your handling code here:
        GeneradorCargas ung = new GeneradorCargas();
        String terminal = "MONTECON";
        String tipo = "EXPO";
        
        if(chkTcp.isSelected()){terminal = "TCP";}
        tipo = "EXPO";
                
        try{ung.buque = tblBuques.getModel().getValueAt(tblBuques.getSelectedRow() , 0).toString();}catch(Exception ex){}
        try{ung.viaje = tblBuques.getModel().getValueAt(tblBuques.getSelectedRow() , 1).toString();}catch(Exception ex){}
        try{ung.eta = tblBuques.getModel().getValueAt(tblBuques.getSelectedRow() , 2).toString();}catch(Exception ex){}
        
        ung.terminal = terminal;
        ung.tipo = tipo;
                
        if(ung.puedo())
        {
            JOptionPane.showMessageDialog(null, "Procesado con éxito");
            BD unb = new BD();
            unb.sistema = "VELMAREN";
            unb.usuario = "ROBOT";
            unb.StoreProcedure("UPDATE bridge_bls SET enviadoCargas = '1' WHERE escala_bl = '" + ung.escala + "'", "one");
                    
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Faltan datos como escala, terminal o tipo manifiesto para armar los archivos de cargas");
        }
        
    }//GEN-LAST:event_cmdCargasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String buque = tblBuques.getValueAt(tblBuques.getSelectedRow(), 0).toString();
        String viaje = tblBuques.getValueAt(tblBuques.getSelectedRow(), 1).toString();
        String eta = tblBuques.getValueAt(tblBuques.getSelectedRow(), 2).toString();

        BD unB = new BD();
        String url = "DELETE c.*, bl.* FROM bridge_bls bl, bridge_contenedores c WHERE bl.buque_bl = '" + buque + "' AND bl.viaje_bl = '" + viaje + "' AND bl.eta_bl = '" + eta + "' AND bl.numero_bl = c.numero_bl";
        unB.StoreProcedure(url, "velmaren");
        url = "DELETE bl.* FROM bridge_bls bl WHERE bl.buque_bl = '" + buque + "' AND bl.viaje_bl = '" + viaje + "' AND bl.eta_bl = '" + eta + "'";
        unB.StoreProcedure(url, "velmaren");
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    public String sacarNumeros(String tipobulto)
    {
        String val = tipobulto;
        try
        {
            int numero = Integer.parseInt(val.substring(0,1));
            while(numero > 0)
            {
                val = val.substring(1,val.length());
                                
                if (val.substring(0,1).equals(" "))
                {
                    numero = 1;
                }
                else
                {
                    if (val.substring(0,1).equals("0"))
                    {
                        numero = 1;
                    }
                    else
                    {
                        numero = Integer.parseInt(val.substring(0,1));
                    }
                }            
            }
        }
        catch(Exception ex)
        {
        }
        
        if(val.contains("INTERMEDIATE BULK CONTAINER")){val = "BULK";}
        if(val.equals(" ") || val.equals("")) { val = "EMPTY"; }
        
        return val;
    }
    
    public void procesarExcel() throws IOException
    {
        String ruta = lblArchivo.getText();
        ArrayList barco = new ArrayList();
        int ultimaposicionbl = 0;
        if(ruta.equals("") == false)
        {
            try
            {
                //LEVANTOP EL EXCEL
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheetAt(0);
                HSSFRow row;
                HSSFCell cell;

                int i = 0;

                //CARGO DATOS INICIALES
                String buque = "", viaje = "", eta = "", origen = "", destino = "", shipper = "", consignee = "", notify = "";
                
                row = sheet.getRow(1);
                cell = row.getCell((short) 4);
                buque = cell.getStringCellValue();
                
                try
                {cell = row.getCell((short) 8);
                viaje = cell.getStringCellValue();}catch(Exception ex){viaje = "";}
                
                try{
                cell = row.getCell((short) 11);
                eta = cell.getStringCellValue();
                eta = eta.substring(6, 10) + "-" + eta.substring(3, 5) + "-" + eta.substring(0, 2);
                }catch(Exception ex){eta = "1900-01-01";}                
                
                try{
                row = sheet.getRow(3);
                cell = row.getCell((short) 7);
                origen = cell.getStringCellValue();}catch(Exception ex){origen = "";}
                
                try{
                cell = row.getCell((short) 9);
                destino = cell.getStringCellValue();}catch(Exception ex){destino = "";}
                
                String cierre = "";
                String varbl = "";
                bl unbl = new bl();
                container unC = new container();
                i = 7;

                
                
                //RECORRO EL EXCEL
                while (cierre.equals("Total containers:") == false)
                {    
                    try{row = sheet.getRow(i);
                    cell = row.getCell((short) 2);
                    varbl = cell.getStringCellValue();}catch(Exception ex){varbl = "";}

                    if (varbl.length() > 10)
                    {                        
                        //RECORRO SHIPPER, CONSIGNEE, NOTIFY
                        ultimaposicionbl = i;
                        int x = i + 1;
                        String salir = "NO";
                        while (salir.equals("SI") == false)
                        {
                            //BL
                            String varblaux = "", varclientes = "";
                            try{row = sheet.getRow(x);
                            cell = row.getCell((short) 2);
                            varblaux = cell.getStringCellValue();}catch(Exception ex){varblaux = "";}
                            if (varblaux.length() > 10)
                            {
                                salir = "SI";
                            }
                            
                            //CLIENTES
                            try{row = sheet.getRow(x);
                            cell = row.getCell((short) 0);
                            varclientes = cell.getStringCellValue();}catch(Exception ex){varclientes = "";}
                            
                            if(varclientes.length() > 3)
                            {
                                //ACA PUEDE VENIR UN SHIPPER UN CONSIGNEE O UN NOTIFY
                                if(shipper.length() > 3)
                                {
                                   if(consignee.length() > 3)
                                   {
                                       notify = varclientes;
                                       salir = "SI";
                                   }
                                   else
                                   {
                                       consignee = varclientes;
                                   }   
                                }
                                else
                                {
                                    shipper = varclientes;
                                }
                                
                                while (varclientes.length() > 3 && salir.equals("NO"))
                                {
                                    x++;
                                    try{row = sheet.getRow(x);
                                    cell = row.getCell((short) 0);
                                    varclientes = cell.getStringCellValue();}catch(Exception ex){varclientes = "";}                                    
                                }
                                
                            }
                                                        
                            x++;
                        }
                        
                        
                        
                     
                        //Busco info en las posiciones de bl y contenedor         
                        unbl.numerobl = varbl;
                        unbl.buque = buque;
                        unbl.viaje = viaje;
                        unbl.eta = eta;
                        unbl.origen = origen;
                        unbl.destino = destino;
                        unbl.shipper = shipper; shipper = "";
                        unbl.consignee = consignee; consignee = "";
                        unbl.notify = notify; notify = "";
                        unbl.shipper = unbl.shipper.replace("'","");
                        unbl.notify = unbl.notify.replace("'","");
                        unbl.consignee = unbl.consignee.replace("'","");
                        
                        //CARGAR CONTENEDORES A BL
                        salir = "NO";
                        while (salir.equals("NO"))
                        {
                            ultimaposicionbl++;
                            if(ultimaposicionbl > 100000)
                            {
                                salir = "SI";
                            }
                              //BL
                            String varblaux = "";
                            try{row = sheet.getRow(ultimaposicionbl);
                            cell = row.getCell((short) 2);
                            varblaux = cell.getStringCellValue();}catch(Exception ex){varblaux = "";}
                            if (varblaux.length() > 10)
                            {
                                salir = "SI";
                            }
                            else
                            {
                            
                                String varcontenedor = "";
                                try{row = sheet.getRow(ultimaposicionbl);
                                cell = row.getCell((short) 4);
                                varcontenedor = cell.getStringCellValue();}catch(Exception ex){}

                                if (varcontenedor.length() > 10)
                                {
                                    container c = new container();
                                    try
                                    {
                                        String [] valor = varcontenedor.split("/");
                                        c.marca = valor[0];
                                        c.tipo = valor[1].replace("'", "");
                                        
                                        try{cell = row.getCell((short) 10);
                                        varcontenedor = cell.getStringCellValue();}catch(Exception ex){}
                                        varcontenedor = varcontenedor.replace("Gross:", "");
                                        varcontenedor = varcontenedor.replace("kgs", "");
                                        varcontenedor = varcontenedor.replace(".000", "");                                c.peso = varcontenedor;
                                        varcontenedor = varcontenedor.replace(" ", "");

                                        c.peso = varcontenedor;

                                        cell = row.getCell((short) 7);
                                        try
                                        {
                                            if(unbl.cantbultos.equals("")){unbl.cantbultos= "0";}
                                            unbl.mercaderia = cell.getStringCellValue();
                                            int cant = Integer.parseInt(unbl.mercaderia.split(" ")[0]) + Integer.parseInt(unbl.cantbultos);
                                            unbl.cantbultos = String.valueOf(cant);
                                            unbl.tipobulto = unbl.mercaderia.replace(unbl.cantbultos + " ", "");
                                            
                                            unbl.tipobulto = sacarNumeros(unbl.tipobulto);
                                            
                                        }catch(Exception ex){}
                                        
                                        ultimaposicionbl++;
                                        try{row = sheet.getRow(ultimaposicionbl);
                                        cell = row.getCell((short) 4);
                                        varcontenedor = cell.getStringCellValue();}catch(Exception ex){}
                                        valor = varcontenedor.split("/");
                                        c.seal = valor[0].replace("SEAL:", "");
                                        
                                         
                                        
                                        unbl.containers.add(c);
                                    }
                                    catch(Exception ex){}
                                }
                            }
                            
                        }
                        
                        
                        //GUARDO BL EN ARRAY BARCO
                        barco.add(unbl);
                        unbl = new bl();
                    }	

                    
                    //COTNROL DE CIERRE
                    try{row = sheet.getRow(i);
                    cell = row.getCell((short) 4);
                    cierre = cell.getStringCellValue();}catch(Exception ex){cierre = "";}
                    
                    if (cierre.length() > 17)
                    {
                        cierre = cierre.substring(0,17);
                    }


                    //COTNROL DE CAMBIOS DE DESTINOS
                    String destinoCambia = "";
                    try{row = sheet.getRow(i);
                    cell = row.getCell((short) 0);
                    destinoCambia = cell.getStringCellValue();}catch(Exception ex){destinoCambia = "";}
                    
                    if (destinoCambia.equals("MSC URUGUAY SA"))
                    {
                        try{
                        row = sheet.getRow(i + 2);    
                        cell = row.getCell((short) 7);
                        origen = cell.getStringCellValue();}catch(Exception ex){origen = "";}

                        try{
                        cell = row.getCell((short) 9);
                        destino = cell.getStringCellValue();}catch(Exception ex){destino = "";}
                    }
                    
                    i = i + 1;
                    
                }
                
                i = i;
                
            }
            catch(Exception ex)
            {

            }

            guardarArrayBarco(barco);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
    }
    
    public void procesarExcelCosco() throws IOException
    {
        String ruta = lblArchivo.getText();
        ArrayList barco = new ArrayList();
        int ultimaposicionbl = 0;
        if(ruta.equals("") == false)
        {
            try
            {
                //LEVANTOP EL EXCEL
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheetAt(0);
                HSSFRow row;
                HSSFCell cell;

                int i = 0;

                //CARGO DATOS INICIALES
                String tipo = "", varblaux = "", buque = "", viaje = "", eta = "", origen = "", destino = "", shipper = "", consignee = "", notify = "";
                
                row = sheet.getRow(0);
                cell = row.getCell((short) 4);
                bl unB = new bl();
                unB.numerobl = cell.getStringCellValue();
                
                //RECORRO EL EXCEL
                while (unB.numerobl.equals("") == false)
                {       
                    row = sheet.getRow(i);
                    //CARGO POR PRIMERA VEZ
                    if(varblaux.equals(""))
                    {
                        unB.tipo = "COSCO";
                        //ETA
                        try{row = sheet.getRow(i);
                            SimpleDateFormat unf = new SimpleDateFormat("yyyy-MM-dd");
                            cell = row.getCell((short) 18);
                            unB.eta = unf.format(cell.getDateCellValue());
                            //eta = eta.substring(6, 10) + "-" + eta.substring(3, 5) + "-" + eta.substring(0, 2);
                        }catch(Exception ex){eta = "1900-01-01";}  

                        //BUQUE
                        try{row = sheet.getRow(i);
                            cell = row.getCell((short) 16);
                            unB.buque = cell.getStringCellValue();
                            String [] viajes = unB.buque.split(" ");
                            unB.viaje = viajes[viajes.length - 1];
                            unB.buque = unB.buque.replace(unB.viaje, "");
                        }catch(Exception ex){buque="";viaje="";}  

                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 8);
                        unB.origen = cell.getStringCellValue();}catch(Exception ex){}    
                        
                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 9);
                        unB.destino = cell.getStringCellValue();}catch(Exception ex){}
                        
                        //CLIENTE
                        try{
                            cell = row.getCell((short) 12);
                            unB.shipper = cell.getStringCellValue();
                            unB.consignee = unB.shipper;
                        }catch(Exception ex){}
                            
                        unB.tipobulto = "CN";
                        unB.cantbultos = "1";
                        
                    }
                    
                    //BL                                        
                    try{
                        cell = row.getCell((short) 4);
                        varblaux = cell.getStringCellValue();
                    }catch(Exception ex){}
                    
                                        
                    if(unB.numerobl.equals(varblaux))
                    {
                        //CARGA CONTENEDORES
                        container c = new container();
                                                
                        try{cell = row.getCell((short) 0);
                            c.marca = cell.getStringCellValue();
                            c.marca = c.marca.replace(" ", "").replace("-", "");
                            
                        }catch(Exception ex){}

                        try{cell = row.getCell((short) 1);
                            c.tipo = cell.getStringCellValue();
                            if(c.tipo.equals("20DC")){c.tipo="20DV";}
                            if(c.tipo.equals("40DC")){c.tipo="40DV";}
                            if(c.tipo.equals("40HQ")){c.tipo="40HC";}
                            if(c.tipo.equals("20TK")){c.tipo="20TK";}
                            if(c.tipo.equals("40TK")){c.tipo="40TK";}
                        }catch(Exception ex){}
                        
                        try{cell = row.getCell((short) 2);
                            c.peso = String.valueOf(cell.getNumericCellValue());
                        }catch(Exception ex){}
                        
                        try
                        {
                            cell = row.getCell((short) 3);
                            c.seal = cell.getStringCellValue();
                        }catch(Exception ex){}                 
                        
                        unB.containers.add(c);
                        
                    }
                    else
                    {
                        try{unB = reestructurarPeso(unB);}catch(Exception ex){}

                        //GUARDAR DATOS
                        barco.add(unB);         
                        unB = new bl();
                        unB.numerobl = varblaux;

                        if(unB.numerobl.equals("COSU6297561510"))
                        {
                            String entre = "";
                        }
                        
                        //CARGA TODOS LOS DATOS DE BL
                        unB.tipo = "COSCO";
                        //ETA
                        try{row = sheet.getRow(i);
                           SimpleDateFormat unf = new SimpleDateFormat("yyyy-MM-dd");
                            cell = row.getCell((short) 18);
                            unB.eta = unf.format(cell.getDateCellValue());
                        }catch(Exception ex){eta = "1900-01-01";}  

                        //BUQUE
                        try{row = sheet.getRow(i);
                            cell = row.getCell((short) 16);
                            unB.buque = cell.getStringCellValue();
                            String [] viajes = unB.buque.split(" ");
                            unB.viaje = viajes[viajes.length - 1];
                            unB.buque = unB.buque.replace(unB.viaje, "");
                        }catch(Exception ex){buque="";viaje="";}  

                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 8);
                        unB.origen = cell.getStringCellValue();}catch(Exception ex){}    
                        
                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 9);
                        unB.destino = cell.getStringCellValue();}catch(Exception ex){}
                        
                        //CLIENTE
                        try{
                            cell = row.getCell((short) 12);
                            unB.shipper = cell.getStringCellValue();
                            unB.consignee = unB.shipper;
                        }catch(Exception ex){}
                        
                        unB.tipobulto = "CN";
                        unB.cantbultos = "1";
                        
                        
                        //CARGA CONTENEDORES
                        container c = new container();
                                                
                        try{cell = row.getCell((short) 0);
                            c.marca = cell.getStringCellValue();
                            c.marca = c.marca.replace(" ", "").replace("-", "");
                            
                        }catch(Exception ex){}

                        try{cell = row.getCell((short) 1);
                            c.tipo = cell.getStringCellValue();
                            if(c.tipo.equals("20DC")){c.tipo="20DV";}
                            if(c.tipo.equals("40DC")){c.tipo="40DV";}
                            if(c.tipo.equals("40HQ")){c.tipo="40HC";}
                            if(c.tipo.equals("20TK")){c.tipo="20TK";}
                            if(c.tipo.equals("40TK")){c.tipo="40TK";}
                        }catch(Exception ex){}
                        
                        try{cell = row.getCell((short) 2);
                            c.peso = String.valueOf(cell.getNumericCellValue());
                        }catch(Exception ex){}
                        
                        try
                        {
                            cell = row.getCell((short) 3);
                            c.seal = cell.getStringCellValue();
                        }catch(Exception ex){}                 
                        
                        unB.containers.add(c);
                        
                        
                        
                        
                    }
                    i++;
                }
            }
            catch(Exception ex)
            {

            }

            guardarArrayBarco(barco);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
    }
    
    public void procesarExcelHapag() throws IOException
    {
        String ruta = lblArchivo.getText();
        ArrayList barco = new ArrayList();
        int ultimaposicionbl = 0;
        if(ruta.equals("") == false)
        {
            try
            {
                //LEVANTOP EL EXCEL
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheetAt(0);
                HSSFRow row;
                HSSFCell cell;

                int i = 20;

                //CARGO DATOS INICIALES
                String tipo = "", varblaux = "", buque = "", viaje = "", eta = "", origen = "", destino = "", shipper = "", consignee = "", notify = "";
                
                row = sheet.getRow(20);
                cell = row.getCell((short) 9);
                bl unB = new bl();
                unB.numerobl = cell.getStringCellValue();
                
                //RECORRO EL EXCEL
                while (unB.numerobl.equals("") == false)
                {       
                    row = sheet.getRow(i);
                    //CARGO POR PRIMERA VEZ
                    if(varblaux.equals(""))
                    {
                        unB.tipo = "HAPAG";
                        //ETA
                        try{row = sheet.getRow(i);
                            SimpleDateFormat unf = new SimpleDateFormat("yyyy-MM-dd");
                            row = sheet.getRow(13);
                            cell = row.getCell((short) 2);
                            unB.eta = cell.getStringCellValue();
                            unB.eta = unB.eta.substring(0, 10);
                        }catch(Exception ex){unB.eta = "1900-01-01";}  

                        //BUQUE
                        try{row = sheet.getRow(i);
                            row = sheet.getRow(5);
                            cell = row.getCell((short) 2);
                            unB.buque = cell.getStringCellValue();
                            row = sheet.getRow(8);
                            cell = row.getCell((short) 2);
                            unB.viaje = cell.getStringCellValue();
                            
                        }catch(Exception ex){buque="";viaje="";}  
                        
                        row = sheet.getRow(i);
                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 29);
                        unB.origen = cell.getStringCellValue();}catch(Exception ex){}    
                        
                        //DESTINO                                        
                        try{
                        cell = row.getCell((short) 32);
                        unB.destino = cell.getStringCellValue();}catch(Exception ex){}
                        
                        //CLIENTE
                        try{
                            cell = row.getCell((short) 12);
                            unB.shipper = "HAPAG-LLOYD";
                            unB.consignee = "HAPAG-LLOYD";
                        }catch(Exception ex){}
                            
                        unB.tipobulto = "CN";
                        unB.cantbultos = "1";
                        
                    }
                    
                    //BL                                        
                    try{
                        cell = row.getCell((short) 9);
                        varblaux = cell.getStringCellValue();
                    }catch(Exception ex){}
                    
                                        
                    if(unB.numerobl.equals(varblaux))
                    {
                        //CARGA CONTENEDORES
                        container c = new container();
                                                
                        try{cell = row.getCell((short) 1);
                            c.marca = cell.getStringCellValue();
                            c.marca = c.marca.replace(" ", "").replace("-", "");
                            
                        }catch(Exception ex){}

                        try{cell = row.getCell((short) 2);
                            c.tipo = cell.getStringCellValue();
                            if(c.tipo.equals("22G1")){c.tipo="20DV";}
                            if(c.tipo.equals("42G1")){c.tipo="40DV";}
                            if(c.tipo.equals("45G1")){c.tipo="40HC";}
                            if(c.tipo.equals("22R1")){c.tipo="20HR";}
                            if(c.tipo.equals("45R1")){c.tipo="40HR";}
                        }catch(Exception ex){}
                        
                        try{cell = row.getCell((short) 39);
                            c.peso = cell.getStringCellValue().replace("KGM", "");
                        }catch(Exception ex){}
                        
                        try
                        {
                            cell = row.getCell((short) 3);
                            c.seal = cell.getStringCellValue();
                        }catch(Exception ex){}                 
                        
                        unB.containers.add(c);
                        
                    }
                    else
                    {
                        try{unB = reestructurarPeso(unB);}catch(Exception ex){}

                        //GUARDAR DATOS
                        barco.add(unB);         
                        unB = new bl();
                        unB.numerobl = varblaux;

                        if(unB.numerobl.equals("COSU6297561510"))
                        {
                            String entre = "";
                        }
                        
                        //CARGA TODOS LOS DATOS DE BL
                        unB.tipo = "HAPAG";

                        //ETA
                        try{row = sheet.getRow(i);
                            SimpleDateFormat unf = new SimpleDateFormat("yyyy-MM-dd");
                            row = sheet.getRow(13);
                            cell = row.getCell((short) 2);
                            unB.eta = cell.getStringCellValue();
                            unB.eta = unB.eta.substring(0, 10);
                        }catch(Exception ex){unB.eta = "1900-01-01";}  

                        //BUQUE
                        try{row = sheet.getRow(i);
                            row = sheet.getRow(5);
                            cell = row.getCell((short) 2);
                            unB.buque = cell.getStringCellValue();
                            row = sheet.getRow(8);
                            cell = row.getCell((short) 2);
                            unB.viaje = cell.getStringCellValue();
                        }catch(Exception ex){}

                       row = sheet.getRow(i);
                        //ORIGEN                                        
                        try{
                        cell = row.getCell((short) 29);
                        unB.origen = cell.getStringCellValue();}catch(Exception ex){}    
                        
                        //DESTINO                                        
                        try{
                        cell = row.getCell((short) 32);
                        unB.destino = cell.getStringCellValue();}catch(Exception ex){}
                        
                        //CLIENTE
                        try{
                            cell = row.getCell((short) 12);
                            unB.shipper = "HAPAG-LLOYD";
                            unB.consignee = "HAPAG-LLOYD";
                        }catch(Exception ex){}
                        
                        unB.tipobulto = "CN";
                        unB.cantbultos = "1";
                        
                        
                        //CARGA CONTENEDORES
                        container c = new container();
                                                
                        try{cell = row.getCell((short) 1);
                            c.marca = cell.getStringCellValue();
                            c.marca = c.marca.replace(" ", "").replace("-", "");
                            
                        }catch(Exception ex){}

                        try{cell = row.getCell((short) 2);
                            c.tipo = cell.getStringCellValue();
                            if(c.tipo.equals("22G1")){c.tipo="20DV";}
                            if(c.tipo.equals("42G1")){c.tipo="40DV";}
                            if(c.tipo.equals("45G1")){c.tipo="40HC";}
                            if(c.tipo.equals("22R1")){c.tipo="20HR";}
                            if(c.tipo.equals("45R1")){c.tipo="40HR";}
                        }catch(Exception ex){}
                        
                        try{cell = row.getCell((short) 39);
                            c.peso = cell.getStringCellValue().replace("KGM", "");
                        }catch(Exception ex){}
                        
                        
                        try
                        {
                            cell = row.getCell((short) 3);
                            c.seal = cell.getStringCellValue();
                        }catch(Exception ex){}                 
                        
                        unB.containers.add(c);
                        
                        
                        
                        
                    }
                    i++;
                }
            }
            catch(Exception ex)
            {

            }

            guardarArrayBarco(barco);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
    }
    
    private bl reestructurarPeso(bl unb)
    {
        int i = 0;
                
        while (unb.containers.size() > i)
        {
            container c = new container();
            c = (container) unb.containers.get(i);
            unb.pesotot = String.valueOf(Double.parseDouble(c.peso) + Double.parseDouble(unb.pesotot));
            i++;
        }
        unb.cantbultos = String.valueOf(unb.containers.size());
        return unb;
        
    /*    int i = 0;
        if (unb.containers.size() > 1)
        {
            container c = new container();
            c = (container) unb.containers.get(i);
            unb.cantbultos = String.valueOf(unb.containers.size());
            unb.pesotot = c.peso;
        }
        
        while (unb.containers.size() > i)
        {
            container c = new container();
            c = (container) unb.containers.get(i);
            c.peso = String.valueOf(Double.parseDouble(c.peso) / unb.containers.size());
            unb.containers.set(i, c);
            i++;
        }
        
        return unb;*/
    }
    
    private String darCodigoCiudad (String ciudad)
    {
        String flag = ciudad;
        
        try
        {
            BD unb = new BD();
            String url = "SELECT aduana_tipociudad FROM `bridge_tipociudad` WHERE descripcion_tipociudad LIKE '%" + ciudad +  "%'";
        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

            while (lista.next())
            {
                flag = lista.getString("aduana_tipociudad");
            }
        }
        catch(Exception ex)
        {
        
        }
        
        return flag;        
    }    
    public void guardarArrayBarco (ArrayList b)
    {
        int i = 0;
        ArrayList lista = new ArrayList();
        while (b.size() > i)
        {
            bl unb = (bl) b.get(i);
                    
            unb.destinocode = darCodigoCiudad (unb.destino);
                    
            unb.numerobl = unb.numerobl.toUpperCase().replace("EXPRESS","");
            unb.numerobl = unb.numerobl.toUpperCase().replace("BL","");
            unb.numerobl = unb.numerobl.toUpperCase().replace(" ","");
            
            String valor = "INSERT INTO bridge_bls (tipo, decripcioncarga_bl, cantidaddebultos_bl, tipobultos_bl, numero_bl, buque_bl, viaje_bl, eta_bl, consignatario_bl, cargador_bl, notificador_bl, destino_bl, origen_bl, origencodigo_bl, destinocodigo_bl) "
            + "VALUES ('" + unb.tipo  + "','" + unb.mercaderia + "','" + unb.cantbultos + "','" + unb.tipobulto + "','" + unb.numerobl + "','" + unb.buque + "','" + unb.viaje + "','" + unb.eta + "','" + unb.consignee + "','" + unb.shipper + "','" + unb.notify + "','" + unb.destino + "','" + unb.origen + "','UYMVD','" + unb.destinocode + "');";
       
            int cont = 0;
            while (unb.containers.size() > cont)
            {
                container c = (container) unb.containers.get(cont);

                if (c.marca.length() > 10 && c.marca.length() < 12)
                {
                    if(c.tipo.toUpperCase().equals("TYPE") == false)
                    {
                        String vali = "INSERT INTO bridge_contenedores (precinto_con, numero_bl,numero_con,tipoequipoOPUS_con,vaciolleno_con,peso_con,ncm,cantidadbultos_con,temp_con) "
                        + "VALUES ('" + c.seal + "','" + unb.numerobl + "','" + c.marca + "','" + c.tipo + "','f','" + c.peso + "','','','');";
                        lista.add(vali);
                    }
                }
                cont++;
            }
            
            lista.add(valor);
            
            i++;
        }
        
        BD unaB = new BD();
        unaB.Todos(lista);
        
        reset();
        
    }
    
    public void reset()
    {
        ComponentesLista unc = new ComponentesLista();
        //unc.cargarTabla("SELECT numero_bl AS BL, buque_bl AS BUQUE, viaje_bl AS VIAJE, eta_bl AS ETA, cargador_bl AS SHIPPER, consignatario_bl AS CONSIGNEE, notificador_bl AS NOTIFY, origen_bl AS ORIGEN, destino_bl AS DESTINO, origencodigo_bl as COD_ORIGEN, destinocodigo_bl AS COD_DESTINO from bridge_bls", tblLista);
        unc.cargarTabla("SELECT buque_bl AS BUQUE, viaje_bl AS VIAJE, eta_bl AS ETA FROM bridge_bls GROUP BY buque_bl, viaje_bl, eta_bl", tblBuques);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkTcp;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JButton cmdCargas;
    private javax.swing.JButton cmdProcesar;
    private javax.swing.JButton cmdsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JLabel lblBls;
    private javax.swing.JLabel lblContenedores;
    private javax.swing.JLabel lblContenedoresbl;
    private javax.swing.JLabel lblRe;
    private javax.swing.JLabel lblsuma;
    private javax.swing.JTable tblBuques;
    private javax.swing.JTable tblCOnt;
    private javax.swing.JTable tblCOntT;
    private javax.swing.JTable tblCant;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables

    public controlador miControlador;
    
    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("SUBIR MSC - Mantenimiento Usuarios");
        this.setMinimumSize(new Dimension(1200, 650)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);  
        reset();
    }    
    
    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string + name);
    }


}
