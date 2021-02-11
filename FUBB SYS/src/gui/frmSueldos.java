
package gui;

import com.sun.rowset.CachedRowSetImpl;
import domain.SFTPFile;
import domain.numeros;
//import domain.ftpclass;
import domain.partido;
import domain.pdf;
import domain.sueldo;
import fubb.sys.ComponentesLista;
import fubb.sys.DBSSH;
import java.awt.Dimension;
import java.io.File;
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
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class frmSueldos extends javax.swing.JFrame {
       
    public frmSueldos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdProcesar = new javax.swing.JButton();
        cmdsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmdProcesar.setBackground(new java.awt.Color(102, 102, 255));
        cmdProcesar.setText("PROCESAR REC");
        cmdProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdProcesar);
        cmdProcesar.setBounds(600, 20, 140, 23);

        cmdsearch.setText("...");
        cmdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsearchActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsearch);
        cmdsearch.setBounds(550, 20, 30, 23);

        jLabel1.setText("ARCHIVO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 60, 20);
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(10, 50, 570, 50);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("ENVIAR WEB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 80, 140, 23);

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setText("PROCESAR LIC");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(600, 50, 140, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsearchActionPerformed
        // TODO add your handling code here:
        frmSelectorA unS = new frmSelectorA();
        unS.abrir(this);
    }//GEN-LAST:event_cmdsearchActionPerformed

    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:

        borrarExcels();
        try{procesarExcelpdf();}catch(Exception ex){}
        JOptionPane.showMessageDialog(null, "Procesado con Exito, por favor corrobore");
                 
    }//GEN-LAST:event_cmdProcesarActionPerformed

    public void borrarExcels()
    {
        File f = new File("C:/fubb/jueces/");
        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++)
        {
            File ff = ficheros[x];
            ff.delete();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
   
        SFTPFile unFF = new SFTPFile();
        unFF.ftp();
        JOptionPane.showMessageDialog(null, "Procesado con Exito, por favor corrobore");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        borrarExcels();
        try{procesarExcelpdfLic();}catch(Exception ex){}
        JOptionPane.showMessageDialog(null, "Procesado con Exito, por favor corrobore");

    }//GEN-LAST:event_jButton2ActionPerformed

    public static XSSFWorkbook leerxlsxxsheet(String ruta)
    {
            ArrayList filas = new ArrayList();
            ArrayList columnas = new ArrayList();
            org.apache.poi.xssf.usermodel.XSSFWorkbook worbook = null;
            String rutaArchivo = ruta;
 
            try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) 
            {
        	worbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook(file);
            } 
            catch (Exception e) 
            {
		e.getMessage();
            }
            
            return worbook;
            
    }
    
    public void procesarExcelpdf() throws IOException
    {     
        
        String ruta = lblArchivo.getText();
        sueldo s = new sueldo();

        if(ruta.equals("") == false)
        {

            try
            {
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheet("Hoja1");
                HSSFRow row;
                HSSFCell cell;

                try
                {
                    row = sheet.getRow(0);
                    cell = row.getCell((short) 31);
                    String mesliquidado = cell.getStringCellValue();
                
                String aviso = ""; 
                
                int i = 1;
                if(mesliquidado.equals("") == false)
                {
                        try
                        {
                            boolean fin = false;
                            while (i < 200 && fin == false)
                            {
                                row = sheet.getRow(i);
                                String val = "";
                                try
                                {
                                    cell = row.getCell((short) 0);
                                    s.numero = String.valueOf(cell.getNumericCellValue());
                                    s.numero = s.numero.replace(".0", "");
                                    cell = row.getCell((short) 1);
                                    s.cedula = cell.getStringCellValue();

                                    try{cell = row.getCell((short) 3);
                                    s.nombre = cell.getStringCellValue();}catch(Exception ex){}

                                    try{cell = row.getCell((short) 4);
                                    s.nombre = s.nombre + " " + cell.getStringCellValue();}catch(Exception ex){}

                                    try{cell = row.getCell((short) 5);
                                    s.jornal = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 6);
                                    s.presentismo  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 7);
                                    s.totalhaberes  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 19);
                                    s.antiguedad  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{SimpleDateFormat unF = new SimpleDateFormat("dd/MM/yyyy");   
                                    cell = row.getCell((short) 25);
                                    s.fecIngreso = unF.format(cell.getDateCellValue());}catch(Exception ex){}

                                    try{SimpleDateFormat unSS = new SimpleDateFormat("dd/MM/yyyy");
                                    cell = row.getCell((short) 31);
                                    s.mesliquidado = mesliquidado;}catch(Exception ex){}

                                    try{SimpleDateFormat unS = new SimpleDateFormat("MM/yyyy");
                                    s.cobro = "10/" + unS.format(new Date());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 8);
                                    s.bps  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 9);
                                    s.snis  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 10);
                                    s.frl  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 14);
                                    s.fondo  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 13);
                                    s.judicial  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 15);
                                    s.irpf  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 16);
                                    s.retencion  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 17);
                                    s.anda  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 18);
                                    s.a_cobrar  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                    s.a_cobrar = s.a_cobrar.replace(",,", ",");

                                    try{cell = row.getCell((short) 11);
                                    s.totaldto  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                    double ifondo = 0, iirpf = 0, idto = 0;

                                    try
                                    {
                                        ifondo = Double.parseDouble(s.fondo);
                                        iirpf = Double.parseDouble(s.irpf);
                                        idto = Double.parseDouble(s.totaldto);
                                        ifondo = ifondo + iirpf + idto;
                                    }
                                    catch(Exception ex){}

                                    s.totaldto = String.valueOf(ifondo);

                                    if(Double.parseDouble(s.totalhaberes) > 31633 && Double.parseDouble(s.irpf) == 0)
                                    {
                                        aviso = s.nombre + " irpf en 0, ";
                                    }
                                    if(Double.parseDouble(s.totalhaberes) > 31633 && Double.parseDouble(s.fondo) == 0)
                                    {
                                        aviso = s.nombre + " fondo en 0, ";
                                    }
                                    try{s.cargarDetalle(wb, sheet);}catch(Exception ex){}

                                    pdf unp = new pdf();
                                    if(s.numero.equals("") == false || s.numero.equals("0") == false)
                                    {
                                        s.totalhaberes = numeros.acotarDecimales(2, s.totalhaberes);
                                        s.totaldto = numeros.acotarDecimales(2, s.totaldto);
                                        unp.memo(s);                                                   
                                    }
                                }
                                catch(Exception ex)
                                {

                                }        


                                i++;
                            }
                        }
                        catch(Exception ex)
                        {

                        }

                        sheet = null;
                        ExcelFileToRead.close();
                        ExcelFileToRead = null;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Falta fecha de emision en fila 1 columna 32 de la Hoja1 del excel seleccionado");
                }
            }
            catch(Exception ex)
            {
                    
            }
             
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Falta fecha de emision en fila 1 columna 32 de la Hoja1 del excel seleccionado");
        }
                
                
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
        
    }

    
    public void procesarExcelpdfLic() throws IOException
    {     
        
        String ruta = lblArchivo.getText();
        sueldo s = new sueldo();

        if(ruta.equals("") == false)
        {

            try
            {
                InputStream ExcelFileToRead = new FileInputStream(lblArchivo.getText());
                HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                HSSFSheet sheet=wb.getSheet("Hoja1");
                HSSFRow row;
                HSSFCell cell;

                try
                {
                    row = sheet.getRow(0);
                    cell = row.getCell((short) 34);
                    String mesliquidado = cell.getStringCellValue();
                
                String aviso = ""; 
                
                int i = 1;
                if(mesliquidado.equals("") == false)
                {
                        try
                        {
                            boolean fin = false;
                            while (i < 200 && fin == false)
                            {
                                row = sheet.getRow(i);
                                String val = "";
                                try
                                {
                                    cell = row.getCell((short) 0);
                                    s.numero = String.valueOf(cell.getNumericCellValue());
                                    s.numero = s.numero.replace(".0", "");
                                    cell = row.getCell((short) 1);
                                    s.cedula = cell.getStringCellValue();

                                    try{cell = row.getCell((short) 2);
                                    s.jornal = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 3);
                                    s.nombre = cell.getStringCellValue();}catch(Exception ex){}

                                    try{cell = row.getCell((short) 4);
                                    s.nombre = s.nombre + " " + cell.getStringCellValue();}catch(Exception ex){}

                                    try{cell = row.getCell((short) 5);
                                    s.licencia  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                   
                                    try{cell = row.getCell((short) 30);
                                    s.salario  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    double toti = Double.parseDouble(s.salario) + Double.parseDouble(s.licencia); 
                                    s.totalhaberes = String.valueOf(toti);
                                    
                                    try{cell = row.getCell((short) 6);
                                    s.presentismo  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                                                        
                                    try{cell = row.getCell((short) 19);
                                    s.antiguedad  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{SimpleDateFormat unF = new SimpleDateFormat("dd/MM/yyyy");   
                                    cell = row.getCell((short) 25);
                                    s.fecIngreso = unF.format(cell.getDateCellValue());}catch(Exception ex){}

                                    try{SimpleDateFormat unSS = new SimpleDateFormat("dd/MM/yyyy");
                                    cell = row.getCell((short) 34);
                                    s.mesliquidado = mesliquidado;}catch(Exception ex){}

                                    try{SimpleDateFormat unS = new SimpleDateFormat("MM/yyyy");
                                    s.cobro = "10/" + unS.format(new Date());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 8);
                                    s.bps  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 9);
                                    s.snis  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 10);
                                    s.frl  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 14);
                                    s.fondo  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 13);
                                    s.judicial  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 15);
                                    s.irpf  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 16);
                                    s.retencion  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 17);
                                    s.anda  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                                    try{cell = row.getCell((short) 32);
                                    s.a_cobrar  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                    s.a_cobrar = s.a_cobrar.replace(",,", ",");

                                    try{cell = row.getCell((short) 11);
                                    s.totaldto  = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                    double ifondo = 0, iirpf = 0, idto = 0;

                                    try
                                    {
                                        ifondo = Double.parseDouble(s.fondo);
                                        iirpf = Double.parseDouble(s.irpf);
                                        idto = Double.parseDouble(s.totaldto);
                                        ifondo = ifondo + iirpf + idto;
                                    }
                                    catch(Exception ex){}

                                    s.totaldto = String.valueOf(ifondo);

                                    if(Double.parseDouble(s.totalhaberes) > 31633 && Double.parseDouble(s.irpf) == 0)
                                    {
                                        aviso = s.nombre + " irpf en 0, ";
                                    }
                                    if(Double.parseDouble(s.totalhaberes) > 31633 && Double.parseDouble(s.fondo) == 0)
                                    {
                                        aviso = s.nombre + " fondo en 0, ";
                                    }
                                    try{s.cargarDetalle(wb, sheet);}catch(Exception ex){}

                                    pdf unp = new pdf();
                                    if(s.numero.equals("") == false || s.numero.equals("0") == false)
                                    {
                                        s.licencia = numeros.acotarDecimales(2, s.licencia);
                                        s.a_cobrar = numeros.acotarDecimales(2, s.a_cobrar);
                                        s.salario = numeros.acotarDecimales(2, s.salario);
                                        s.totalhaberes = numeros.acotarDecimales(2, s.totalhaberes);
                                        s.totaldto = numeros.acotarDecimales(2, s.totaldto);
                                        unp.memolic(s);  
                                        
                                    }
                                }
                                catch(Exception ex)
                                {

                                }        


                                i++;
                            }
                        }
                        catch(Exception ex)
                        {

                        }

                        sheet = null;
                        ExcelFileToRead.close();
                        ExcelFileToRead = null;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Falta fecha de emision en fila 1 columna 32 de la Hoja1 del excel seleccionado");
                }
            }
            catch(Exception ex)
            {
                    
            }
             
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Falta fecha de emision en fila 1 columna 32 de la Hoja1 del excel seleccionado");
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblArchivo;
    // End of variables declaration//GEN-END:variables

    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("SELECTOR    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(800, 150)); 
    }
    
    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string + name);
    }


}
