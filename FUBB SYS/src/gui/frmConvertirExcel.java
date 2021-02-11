
package gui;

import com.sun.rowset.CachedRowSetImpl;
import domain.partido;
import fubb.sys.ComponentesLista;
import fubb.sys.DBSSH;
import java.awt.Dimension;
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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class frmConvertirExcel extends javax.swing.JFrame {
       
    public frmConvertirExcel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdProcesar = new javax.swing.JButton();
        cmdsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmdProcesar.setText("PROCESAR");
        cmdProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdProcesar);
        cmdProcesar.setBounds(630, 40, 100, 23);

        cmdsearch.setText("...");
        cmdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsearchActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsearch);
        cmdsearch.setBounds(590, 40, 30, 23);

        jLabel1.setText("ARCHIVO:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 70, 20);
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(100, 40, 480, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsearchActionPerformed
        // TODO add your handling code here:
        frmSelectorA unS = new frmSelectorA();
        unS.abrir(this);
    }//GEN-LAST:event_cmdsearchActionPerformed

    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:
        try{procesarExcelDeViejoChoooto();}catch(Exception ex){}
    }//GEN-LAST:event_cmdProcesarActionPerformed

    public void procesarExcelDeViejoChoooto() throws IOException
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
                    
                    row = sheet.getRow(0);
                    cell = row.getCell((short) 0);                    

                    String valorControl = "";
                    try{cell = row.getCell((short) 0); valorControl = cell.getRichStringCellValue().toString(); } catch(Exception ex){valorControl = "";}
                    int i = 0;
                    String pivot = "";
                    while(valorControl.equals("") == false)
                    {
                        if (i == 216)
                        {
                            boolean entre = true;
                        }
                        partido unp = new partido();
                        row = sheet.getRow(i);
                        try
                        {
                            cell = row.getCell((short) 0); valorControl = cell.getRichStringCellValue().toString(); 
                        } 
                        catch(Exception ex)
                        {
                            try
                            {
                                cell = row.getCell((short) 0); 
                                valorControl = String.valueOf(cell.getNumericCellValue());
                                valorControl = valorControl.replace(".0", "");
                            }
                            catch(Exception ex1)
                            {
                                valorControl = "";
                            }
                        }
                
                        try{pivot = valorControl.toLowerCase().substring(0,2);}catch(Exception ex){}
                        
                        if(valorControl.equals("MAXI")){unp.sub = "MAXI"; valorControl = "hora";}
                        
                        if(valorControl.toLowerCase().equals("hora") || pivot.toLowerCase().equals("u1") || pivot.toLowerCase().equals("s1") || pivot.toLowerCase().equals("s2") || pivot.toLowerCase().equals("u2") || pivot.equals("30") || pivot.equals("35") || pivot.equals("45"))
                        {
                            if(pivot.toLowerCase().equals("s1") || pivot.toLowerCase().equals("s2") || pivot.toLowerCase().equals("u1") || pivot.toLowerCase().equals("u2") || pivot.equals("30") || pivot.equals("35") || pivot.equals("45"))
                            {
                                try{cell = row.getCell((short) 0); unp.sub = cell.getStringCellValue(); } catch(Exception ex){unp.sub = valorControl;}
                            
                                unp.sub = unp.sub.toUpperCase();
                                unp.sub = unp.sub.replace("30", "+30");
                                unp.sub = unp.sub.replace("35", "+35");
                                unp.sub = unp.sub.replace("45", "+45");
                                String ese = unp.sub.substring(0,1);
                                if(ese.toLowerCase().equals("s"))
                                {
                                    unp.sub  = unp.sub.replace("s", "U");
                                    unp.sub  = unp.sub.replace("S", "U");
                                }
                                
                                SimpleDateFormat unf = new SimpleDateFormat("HH:mm");
                                try
                                {
                                    cell = row.getCell((short) 1); unp.hora = cell.getStringCellValue(); 
                                } 
                                catch(Exception ex)
                                {
                                    try{cell = row.getCell((short) 1); unp.hora = unf.format(cell.getDateCellValue()); } catch(Exception e){unp.hora = "";}
                                }                                

                            }
                            else
                            {  
                                SimpleDateFormat unf = new SimpleDateFormat("HH:mm");
                                try
                                {
                                    cell = row.getCell((short) 1); unp.hora = cell.getStringCellValue(); 
                                } 
                                catch(Exception ex)
                                {
                                    try{cell = row.getCell((short) 1); unp.hora = unf.format(cell.getDateCellValue()); } catch(Exception e){unp.hora = "";}
                                }                                
                            }
                            try{cell = row.getCell((short) 2); unp.cancha = cell.getStringCellValue(); } catch(Exception ex){unp.cancha = "";}
                            try{cell = row.getCell((short) 3); pivot = cell.getStringCellValue(); } catch(Exception ex){pivot = "";}
                            try
                            {
                                String [] pivots = pivot.split("-");
                                unp.local = pivots[0];  unp.visitante = pivots[1];
                                unp.local = unp.local.substring(0, unp.local.length() - 1);
                                unp.visitante = unp.visitante.substring(1, unp.visitante.length());
                                
                                try
                                {
                                    if(unp.cancha.substring(unp.cancha.length() - 4, unp.cancha.length()).equals("(TV)"))
                                    {
                                        unp.cancha = unp.cancha.substring(0, unp.cancha.length()-4);
                                        unp.tv = "TV";
                                    }
                                }
                                catch(Exception ex){}
                                
                                unp.cancha = depurarCancha(unp.cancha);
                                unp.local = depurarEquipo(unp.local);
                                unp.visitante = depurarEquipo(unp.visitante);
                                
                            }
                            catch(Exception ex)
                            {
                            }     
                        }
                        else
                        {
                            //unp.titulo = "";
                            //partidos.add(unp);
                            if(valorControl.equals("CAT") || valorControl.equals("FECHA"))
                            {
                                //NO AGREGO
                            }
                            else
                            {    
                            unp.titulo = valorControl;
                            }
                            try
                            { 
                                if(valorControl.substring(0,5).toLowerCase().equals("lunes") || valorControl.substring(0,5).toLowerCase().equals("marte") || valorControl.substring(0,5).toLowerCase().equals("mierc") || valorControl.substring(0,5).toLowerCase().equals("jueve") || valorControl.substring(0,5).toLowerCase().equals("viern") || valorControl.substring(0,5).toLowerCase().equals("sábad") || valorControl.substring(0,5).toLowerCase().equals("sabad") || valorControl.substring(0,5).toLowerCase().equals("domin"))
                                {
                                    unp.titulo = unp.titulo.replace("Lunes", "");
                                    unp.titulo = unp.titulo.replace("lunes", "");
                                    unp.titulo = unp.titulo.replace("Martes", "");
                                    unp.titulo = unp.titulo.replace("martes", "");
                                    unp.titulo = unp.titulo.replace("Miercoles", "");
                                    unp.titulo = unp.titulo.replace("miercoles", "");
                                    unp.titulo = unp.titulo.replace("Jueves", "");
                                    unp.titulo = unp.titulo.replace("jueves", "");
                                    unp.titulo = unp.titulo.replace("Viernes", "");
                                    unp.titulo = unp.titulo.replace("Sábado", "");
                                    unp.titulo = unp.titulo.replace("sábado", "");
                                    unp.titulo = unp.titulo.replace("Sabado", "");
                                    unp.titulo = unp.titulo.replace("sabado", "");
                                    unp.titulo = unp.titulo.replace("Domingo", "");
                                    unp.titulo = unp.titulo.replace("domingo", "");
                                    unp.titulo = unp.titulo.replace("de", "");
                                    unp.titulo = unp.titulo.replace(" ", "");
                                    unp.titulo = unp.titulo.replace("Enero", "01");
                                    unp.titulo = unp.titulo.replace("enero", "01");
                                    unp.titulo = unp.titulo.replace("Febrero", "02");
                                    unp.titulo = unp.titulo.replace("febrero", "02");
                                    unp.titulo = unp.titulo.replace("Marzo", "03");
                                    unp.titulo = unp.titulo.replace("marzo", "03");
                                    unp.titulo = unp.titulo.replace("Abril", "04");
                                    unp.titulo = unp.titulo.replace("abril", "04");
                                    unp.titulo = unp.titulo.replace("Mayo", "05");
                                    unp.titulo = unp.titulo.replace("mayo", "05");
                                    unp.titulo = unp.titulo.replace("Junio", "06");
                                    unp.titulo = unp.titulo.replace("junio", "06");
                                    unp.titulo = unp.titulo.replace("Agosto", "08");
                                    unp.titulo = unp.titulo.replace("agosto", "08");
                                    unp.titulo = unp.titulo.replace("Setiembre", "09");
                                    unp.titulo = unp.titulo.replace("setiembre", "09");
                                    unp.titulo = unp.titulo.replace("Octubre", "10");
                                    unp.titulo = unp.titulo.replace("octubre", "10");
                                    unp.titulo = unp.titulo.replace("Noviembre", "11");
                                    unp.titulo = unp.titulo.replace("noviembre", "11");
                                    unp.titulo = unp.titulo.replace("Diciembre", "12");
                                    unp.titulo = unp.titulo.replace("diciembre", "12");

                                    if(unp.titulo.length() == 3)
                                    {
                                        unp.titulo = "0" + unp.titulo;
                                    }
                                    SimpleDateFormat unS = new SimpleDateFormat("yyyy");
                                    unp.titulo = unS.format(new Date()) + "-" + unp.titulo.substring(2,4) + "-" + unp.titulo.substring(0,2);
                                    partidos.add(new partido());
                                }
                            
                            }
                            catch(Exception ex)
                            {
                            }
                            
                        }
                                       
                        partidos.add(unp);
                        
                        try
                        {
                            if(valorControl.substring(0,5).toLowerCase().equals("lunes") || valorControl.substring(0,5).toLowerCase().equals("marte") || valorControl.substring(0,5).toLowerCase().equals("mierc") || valorControl.substring(0,5).toLowerCase().equals("jueve") || valorControl.substring(0,5).toLowerCase().equals("viern") || valorControl.substring(0,5).toLowerCase().equals("sábad") || valorControl.substring(0,5).toLowerCase().equals("domin"))
                            {
                                unp = new partido();
                                unp.titulo = "";
                                partidos.add(unp);
                            }
                        }catch(Exception ex){}
                        
                        i++;


                    }
                }
                catch(Exception ex)
                {

                }


                if(partidos.size() > 0)
                {
                    procesarMatriz(partidos);
                    JOptionPane.showMessageDialog(null, "Procesado.");
                }

            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija un archivo");
        }
    }

//PEÑAROL - DEF.MAROÑAS
    
    
    public String depurarCancha(String cancha)
    {
        String flag = cancha;
        try{if (cancha.substring(0,10).toUpperCase().equals("U.ATLETICA")){flag = "Union Atletica";}}catch(Exception ex){}
        try{if (cancha.substring(0,15).toUpperCase().equals("PALACIO PEÑAROL")){flag = "Palacio Penarol";}}catch(Exception ex){}
        try{if (cancha.substring(0,5).toUpperCase().equals("BIGUA")){flag = "Bigua";}}catch(Exception ex){}
        try{if (cancha.substring(0,3).toUpperCase().equals("DSC")){flag = "Defensor Sporting Club";}}catch(Exception ex){}
        try{if (cancha.substring(0,9).toUpperCase().equals("MALDONADO")){flag = "Campus de Maldonado";}}catch(Exception ex){}
        try{if (cancha.substring(0,9).toUpperCase().equals("O.MUNDIAL")){flag = "Olivol Mundial";}}catch(Exception ex){}
        try{if (cancha.substring(0,3).toUpperCase().equals("GPC")){flag = "Nacional de Football";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("NAUTICO")){flag = "Nautico";}}catch(Exception ex){}
        try{if (cancha.substring(0,8).toUpperCase().equals("JUVENTUD")){flag = "Juventud Las Piedras";}}catch(Exception ex){}
        try{if (cancha.substring(0,8).toUpperCase().equals("H.MACABI")){flag = "Hebraica y Macabi del Uruguay";}}catch(Exception ex){}                              
        try{if (cancha.substring(0,11).toUpperCase().equals("DEF.MAROÑAS")){flag = "Defensores de Maroñas";}}catch(Exception ex){}
        try{if (cancha.substring(0,12).toUpperCase().equals("DEF. MAROÑAS")){flag = "Defensores de Maroñas";}}catch(Exception ex){}
        try{if (cancha.substring(0,8).toUpperCase().equals("L.BORGES")){flag = "Larre Borges";}}catch(Exception ex){}
        try{if (cancha.substring(0,6).toUpperCase().equals("URUPAN")){flag = "Urupan Pando";}}catch(Exception ex){}
        try{if (cancha.substring(0,13).toUpperCase().equals("DS DE MAROÑAS")){flag = "Deportivo Defensores de Maronas";}}catch(Exception ex){}
        try{if (cancha.substring(0,10).toUpperCase().equals("VERDIRROJO")){flag = "Verdirrojo";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("LAGOMAR")){flag = "Lagomar";}}catch(Exception ex){}
        try{if (cancha.substring(0,18).toUpperCase().equals("UNION DE VETERANOS")){flag = "Union de Veteranos";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("URUNDAY")){flag = "Urunday Universitario";}}catch(Exception ex){}
        try{if (cancha.substring(0,10).toUpperCase().equals("MONTEVIDEO")){flag = "Montevideo";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("MIRAMAR")){flag = "Miramar B. B. C.";}}catch(Exception ex){}
        try{if (cancha.substring(0,9).toUpperCase().equals("SAN TELMO")){flag = "San Telmo";}}catch(Exception ex){}
        try{if (cancha.substring(0,5).toUpperCase().equals("COLON")){flag = "Colon";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("PENAROL")){flag = "Palacio Penarol";}}catch(Exception ex){}
        try{if (cancha.substring(0,7).toUpperCase().equals("PEÑAROL")){flag = "Palacio Penarol";}}catch(Exception ex){}
        try{if (cancha.substring(0,6).toUpperCase().equals("CEFUBB")){flag = "CEFUBB";}}catch(Exception ex){}
        try{if (cancha.substring(0,19).toUpperCase().equals("REMEROS DE MERCEDES")){flag = "Club de Remeros Mercedes";}}catch(Exception ex){}
        return flag;
    }
    public String depurarEquipo(String equipo)
    {
        
        String flag = equipo;
        try{if (equipo.substring(0,9).toUpperCase().equals("LARRAÑAGA")){flag = "LARRANAGA";}}catch(Exception ex){}
        try{if (equipo.substring(0,7).toUpperCase().equals("PEÑAROL")){flag = "Penarol";}}catch(Exception ex){}
        try{if (equipo.substring(0,11).toUpperCase().equals("DEF.MAROÑAS")){flag = "DEF.MARONAS";}}catch(Exception ex){}
        try{if (equipo.substring(0,15).toUpperCase().equals("BOHEMIOS MARRON")){flag = "BOHEMIOS B";}}catch(Exception ex){}
        try{if (equipo.substring(0,8).toUpperCase().equals("H.MACABI")){flag = "HEBRAICA MACABI";}}catch(Exception ex){}
        try{if (equipo.substring(0,17).toUpperCase().equals("HEBRAICA Y MACABI")){flag = "HEBRAICA MACABI";}}catch(Exception ex){}
        try{if (equipo.substring(0,13).toUpperCase().equals("DS DE MAROÑAS")){flag = "DEF.MARONAS";}}catch(Exception ex){}
        try{if (equipo.substring(0,7).toUpperCase().equals("URUNDAY")){flag = "URUNDAY UNIVERSITARIO";}}catch(Exception ex){}
        try{if (equipo.substring(0,7).toUpperCase().equals("URUNDAY")){flag = "URUNDAY UNIVERSITARIO";}}catch(Exception ex){}
        try{if (equipo.substring(0,9).toUpperCase().equals("SAN TELMO")){flag = "SAN TELMO RS";}}catch(Exception ex){}
        try{if (equipo.substring(0,12).toUpperCase().equals("LARRE BORGES")){flag = "L.BORGES";}}catch(Exception ex){}
        try{if (equipo.substring(0,14).toUpperCase().equals("LARRE BORGES A")){flag = "L.BORGES AMARILLO";}}catch(Exception ex){}
        try{if (equipo.substring(0,10).toUpperCase().equals("BOHEMIOS B")){flag = "BOHEMIOS B";}}catch(Exception ex){}
        try{if (equipo.substring(0,5).toUpperCase().equals("COLON")){flag = "COLON BBC";}}catch(Exception ex){}
        try{if (equipo.substring(0,13).toUpperCase().equals("DOMINGO SAVIO")){flag = "DGO SAVIO";}}catch(Exception ex){}
        try{if (equipo.substring(0,7).toUpperCase().equals("CRANDON")){flag = "CRANDON";}}catch(Exception ex){}
        try{if (equipo.substring(0,14).toUpperCase().equals("UNION ATLETICA")){flag = "U.ATLETICA";}}catch(Exception ex){}
        try{if (equipo.substring(0,5).toUpperCase().equals("ISASA")){flag = "I.S.A.S.A";}}catch(Exception ex){}
        return flag;

    }

    
    public void procesarMatriz(ArrayList partidos) throws IOException
    {

        String ruta = "C:\\fubb\\matriz\\MatrizV15.xls";

        if(ruta.equals("") == false)
        {

                try
                {
                    InputStream ExcelFileToRead = new FileInputStream(ruta);
                    HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                    HSSFSheet sheet=wb.getSheetAt(1);
                    HSSFRow row;
                    HSSFCell cell;
                    
                    row = sheet.getRow(0);
                    cell = row.getCell((short) 0);                    

                    String valorControl = "";
                    int i = 5;
                    while(partidos.size() > i - 54)
                    {
                        try
                        {
                            partido unp = (partido) partidos.get(i - 5);
                        
                            row = sheet.createRow(i);

                            if(unp.titulo.equals("") == false)
                            {
                                try{cell = row.createCell((short) 0); cell.setCellValue(unp.titulo);} catch(Exception ex){}
                            }
                            else
                            {   
                                unp.cancha = unp.cancha.substring(0,1) + unp.cancha.substring(1,unp.cancha.length()).toLowerCase();
                                try{cell = row.createCell((short) 0); cell.setCellValue(unp.hora); } catch(Exception ex){}
                                try{cell = row.createCell((short) 1); cell.setCellValue(unp.cancha); } catch(Exception ex){}
                                try{cell = row.createCell((short) 2); cell.setCellValue(unp.local); } catch(Exception ex){}
                                try{cell = row.createCell((short) 3); cell.setCellValue(unp.visitante); } catch(Exception ex){}
                                try{cell = row.createCell((short) 4); cell.setCellValue(unp.sub); } catch(Exception ex){}
                                try{cell = row.createCell((short) 5); cell.setCellValue(unp.tv); } catch(Exception ex){}                        
                            }                        
                        }
                        catch(Exception ex)
                        {
                        }                        
                        i++;

                    }

                    try{cell = row.createCell((short) 0); cell.setCellValue("FIN");} catch(Exception ex){}

                    
                    String archi = "Procesado.xls";
                    String rut = "C:\\fubb\\" + "Procesado.xls";
                    FileOutputStream elFichero = new FileOutputStream(rut);
                    wb.write(elFichero);
                    elFichero.close();
                    
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ rut);
                       
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
