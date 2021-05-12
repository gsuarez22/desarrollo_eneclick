
package gui;

import com.sun.rowset.CachedRowSetImpl;
import dominio.BD;
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmdProcesar.setText("CARGAR");
        cmdProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdProcesar);
        cmdProcesar.setBounds(670, 80, 100, 23);

        cmdsearch.setText("...");
        cmdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsearchActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsearch);
        cmdsearch.setBounds(630, 80, 30, 23);

        jLabel1.setText("ARCHIVO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 80, 70, 20);
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(100, 80, 510, 20);

        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 760, 60);

        jButton1.setText("PROCESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 570, 120, 23);

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
        jScrollPane1.setViewportView(tblLista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 760, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsearchActionPerformed
        // TODO add your handling code here:
        frmSelectorA unS = new frmSelectorA();
        unS.abrir(this);
    }//GEN-LAST:event_cmdsearchActionPerformed
    
    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:
        
        try{procesarExcelDelViejoChoooto();}catch(Exception ex){}
    }//GEN-LAST:event_cmdProcesarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void procesarExcelDelViejoChoooto() throws IOException
    {
        String ruta = lblArchivo.getText();
        ArrayList partidos = new ArrayList();

        if(ruta.equals("") == false)
        {
            try
            {
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheetAt(0);
                HSSFRow row;
                HSSFCell cell;
                    
                String valorControl = "";

                int i = 0;

                row = sheet.getRow(1);
                cell = row.getCell((short) 4);
                String buque = cell.getStringCellValue();
                
                cell = row.getCell((short) 8);
                String viaje = cell.getStringCellValue();
                
                
/*                while(valorControl.equals("Total containers:") == false)
                {
                    row = sheet.getRow(1);
                    try 
                    {                        
                        cell = row.getCell((short) 0);
                    }
                    catch(Exception ex){}
                    
                    try{cell = row.getCell((short) 0); valorControl = cell.getRichStringCellValue().toString(); } catch(Exception ex){valorControl = "";}

                    boolean Hora = false;
                    boolean Fecha = false;
                    if(EsFecha(valorControl)){fecha = valorControl;Fecha=true;}
                    if(EsHora(valorControl)){Hora = true;}

                    if(referente.equals("D2") && Hora == false && Fecha == false && valorControl.length() > 0)
                    {
                        nomenclator = valorControl; referente = "nomenclator"; D1 = ""; D2 = "";
                    }
                    else
                    {
                        //ANALISIS PARA VER QUE TENGO
                        row = sheet.getRow(i);
                        try { cell = row.getCell((short) 0); valorControl = cell.getRichStringCellValue().toString(); } catch(Exception ex) {}

                        if(referente.equals("D1")) {D2 = valorControl; referente = "D2"; }
                        if(referente.equals("nomenclator")) {D1 = valorControl; referente = "D1"; }
                        if(i==0) {nomenclator = valorControl; referente = "nomenclator"; D1 = ""; D2 = "";}
                    }
                        
                    if(Hora)
                    {
                        //TENGO PARTIDOS
                        unp = new partido();
                        unp.hora = valorControl; 
                        unp.fecha = fecha;
                        unp.titulo = nomenclator;
                        unp.division1 = D1;
                        unp.division2 = D2;
                        try{cell = row.getCell((short) 1); unp.cancha = canchaPorNombre(cell.getStringCellValue()); } catch(Exception ex){unp.cancha = "0";}
                        try{cell = row.getCell((short) 2); unp.local = equipoPorNombre(cell.getStringCellValue()); } catch(Exception ex){unp.cancha = "0";}
                        try{cell = row.getCell((short) 3); unp.visitante = equipoPorNombre(cell.getStringCellValue()); } catch(Exception ex){unp.cancha = "0";}
                        try{cell = row.getCell((short) 4); unp.sub = cell.getStringCellValue(); } catch(Exception ex){unp.sub = "";}
                        try{cell = row.getCell((short) 5); unp.tv = cell.getStringCellValue(); } catch(Exception ex){unp.tv = "";}
                        partidos.add(unp);                        
                    }
                    
                    i++;


                }*/
            }
            catch(Exception ex)
            {

            }

            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
    }
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdProcesar;
    private javax.swing.JButton cmdsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables

    public controlador miControlador;
    
    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("SUBIR MSC - Mantenimiento Usuarios");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);        
    }    
    
    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string + name);
    }


}
