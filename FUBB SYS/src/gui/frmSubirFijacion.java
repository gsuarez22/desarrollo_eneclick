
package gui;

import com.sun.rowset.CachedRowSetImpl;
import domain.cancha;
import domain.equipo;
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



public class frmSubirFijacion extends javax.swing.JFrame {

    public ArrayList equipos, canchas, partidos;
    
    public frmSubirFijacion() {
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

        cmdProcesar.setText("PREVIEW");
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

        jLabel2.setText("PREVIO Archivo procesado en Procesar Fijacion  PASOS  1 Elegir el archivo denominado como Procesado.xls ,  2 Click en botón Subir ");
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

    public void CargarArrays()
    {
        //canchas
        String url = "SELECT id_cancha, nombre_cancha FROM fubb.canchas ORDER BY nombre_cancha";
        
        try
        {
            canchas = new ArrayList();
            
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            while(lista.next())
            {
                cancha unC = new cancha();
                unC.id_cancha = lista.getString(1);  
                unC.nombre_cancha = lista.getString(2);
                canchas.add(unC);
            }
        }
        catch (Exception ex)
        {
        }            
        
        //equipos
        url = "SELECT id_equipo, nombre FROM fubb.equipos ORDER BY nombre";
        
        try
        {
            equipos = new ArrayList();
            
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            while(lista.next())
            {
                equipo unE = new equipo();
                unE.id_equipo = lista.getString(1);  
                unE.nombre = lista.getString(2);
                equipos.add(unE);
            }
        }
        catch (Exception ex)
        {
        }            
        
    }
    
    
    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:
        
        try{procesarExcelDelViejoChoooto();}catch(Exception ex){}
    }//GEN-LAST:event_cmdProcesarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList base = new ArrayList();
        
        int i = 0;
        
        int cantidad = tblLista.getRowCount();
        
        //("TORNEO")("D1")("D2")("FECHA")("HORA")("CANCHA")("LOCAL")("VISITANTE")("SUB")("TV")
        
        while (cantidad > i) 
        {
            partido p = new partido();
            try{p.titulo = tblLista.getValueAt(i, 0).toString();}catch(Exception ex){p.titulo = "";}
            try{p.division1 = tblLista.getValueAt(i, 1).toString();}catch(Exception ex){p.division1 = "";}
            try{p.division2 = tblLista.getValueAt(i, 2).toString();}catch(Exception ex){p.division2 = "";}
            try{p.fecha = tblLista.getValueAt(i, 3).toString();}catch(Exception ex){p.fecha = "";}
            try{p.hora = tblLista.getValueAt(i, 4).toString();}catch(Exception ex){p.hora = "";}
            try{p.cancha = tblLista.getValueAt(i, 5).toString();}catch(Exception ex){p.cancha = "";}
            try{p.local = tblLista.getValueAt(i, 6).toString();}catch(Exception ex){p.local = "";}
            try{p.visitante = tblLista.getValueAt(i, 7).toString();}catch(Exception ex){p.visitante = "";}
            try{p.sub = tblLista.getValueAt(i, 8).toString();}catch(Exception ex){p.sub = "";}
            try{p.tv = tblLista.getValueAt(i, 9).toString();}catch(Exception ex){p.tv = "";}
            
            String url = "insert into fubb.partidos (nomenclator,division1,division2,sub,local,visitante,cancha,fecha_hora,tv,amistoso,jugado)";
            url = url + " VALUES ('" + p.titulo + "','" + p.division1 + "','" + p.division2 + "','" + p.sub + "','" + p.local + "','" + p.visitante + "','" + p.cancha + "','" + p.fecha + " " + p.hora + ":00','" + p.tv + "','0','0')";
            
            base.add(url);
            i++;
        }
            
        DBSSH.Todos(base);
        partidos = new ArrayList();
        
        JOptionPane.showMessageDialog(null, "Procesado");
        
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
                HSSFSheet sheet=wb.getSheetAt(1);
                HSSFRow row;
                HSSFCell cell;
                    
                String valorControl = "";

                int i = 0;
                String nomenclator = "", D1 = "", D2 = "", fecha = "";
                partido unp = new partido();
                String referente = "";
                
                while(valorControl.equals("FIN") == false)
                {
                    //buscador en debug
                    if (i == 216)
                    {
                        boolean entre = true;
                    }
                    row = sheet.getRow(i);
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

    public String canchaPorNombre(String nombre)
    {
        String flag = "0";
        int i = 0;
        
        nombre = quitarBlancosDelFinal(nombre);
        
        while (canchas.size() > i)
        {
            cancha unc = (cancha) canchas.get(i);
            if(unc.nombre_cancha.toLowerCase().equals(nombre.toLowerCase()))
            {
                flag = unc.id_cancha;
                i = canchas.size();
            }
            i++;
        }
        
        return flag;
    }

    public String quitarBlancosDelFinal(String nombre)
    {
        if(nombre.length() > 1)
        {
            boolean fv = true;
            while (fv)
            {
                String valorcito = nombre.substring(nombre.length() - 1, nombre.length());
                if(valorcito.equals(" "))
                {
                    nombre = nombre.substring(0, nombre.length() - 1);
                }
                else
                {
                    fv = false;
                }
            }
        }
        return nombre;
    }
    
    public String equipoPorNombre(String nombre)
    {
        String flag = "0";
        
       
            nombre = quitarBlancosDelFinal(nombre);

            int i = 0;

            while (equipos.size() > i)
            {
                equipo unc = (equipo) equipos.get(i);
                if(unc.nombre.toLowerCase().equals(nombre.toLowerCase()))
                {
                    flag = unc.id_equipo;
                    i = equipos.size();
                }
                i++;
            }
        
        return flag;
    }
    
    public boolean EsFecha (String valor)
    {
        boolean flag = false;
        String reg = valor.replace(" ", "");
        if (reg.length() == 10)
        {
            String year = reg.substring(4,5);
            String month = reg.substring(7,8);
            String first = reg.substring(0,1);
            
            if(first.equals("2") && year.equals("-") && month.equals("-"))
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean EsHora (String valor)
    {
        boolean flag = false;
        String reg = valor.replace(" ", "");
        if (reg.length() == 5)
        {
            String hour = reg.substring(2,3);
            String first = reg.substring(0,1);
            
            if(first.equals("0") || first.equals("1") || first.equals("2"))
            {
                if(hour.equals(":"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
    
    public void procesarMatriz(ArrayList partidos) throws IOException
    {
        //ESCRIBIR INSERT DE ARRAY partidos
   
        try
        {
            DefaultTableModel tableModel;
            
            tableModel = new DefaultTableModel(0,10);
             Vector v = new Vector();
             
            v.add("TORNEO");
            v.add("D1");
            v.add("D2");
            v.add("FECHA");
            v.add("HORA");
            v.add("CANCHA");
            v.add("LOCAL");
            v.add("VISITANTE");
            v.add("SUB");
            v.add("TV");
            
            tableModel.setColumnIdentifiers(v);
            
            int i = 0;
            
            while (partidos.size() > i) 
            {
                  
                Vector ar = new Vector();
              
                partido p = (partido) partidos.get(i);

                ar.add(p.titulo);
                ar.add(p.division1);
                ar.add(p.division2);
                ar.add(p.fecha);
                ar.add(p.hora);
                ar.add(p.cancha);
                ar.add(p.local);
                ar.add(p.visitante);
                ar.add(p.sub);
                ar.add(p.tv);
                tableModel.addRow(ar);
                
                i++;
            }
          
            tblLista.setModel(tableModel);
            tblLista.setPreferredScrollableViewportSize(new Dimension(1500,1500));
                       
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
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

    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("SELECTOR    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(800, 650)); 
        
        CargarArrays();
    }
    
    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string + name);
    }


}
