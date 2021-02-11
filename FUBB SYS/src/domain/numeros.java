/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author gabriel.suarez
 */
public class numeros 
{
    
    
    public static String acotarDecimales(int decimales, String valor)
    {
        String flag = "0";
        
        int i = 0;
        while (i < valor.length())
        {
            String pi = valor.substring(i,i + 1);
            if (pi.equals("."))
            {
                i = i + decimales + 1;
                if (i <= valor.length())
                {
                    valor = valor.substring(0,i);
                }
               
                if (i > valor.length())
                {
                    int resta = i - valor.length();
                    while(resta > 0)
                    {
                        valor = valor + "0";
                        resta--;
                    }
                }
                
                i = valor.length();
                        
            }
            i++;
        }
        
        valor = ponermiles(valor);
        
        flag = valor;
        
        return flag;
    }
    
    public static String ponermiles(String val)
    {
        String flag = val;
        
        int pos = 0;
        int i = 0;
        while (i < val.length())
        {
            String pi = val.substring(i,i + 1);
            if (pi.equals("."))
            {
                flag = val.substring(0,i);
                pos = i;
                i = val.length() + 1;
            }
            i++;
        }
        
        if(pos == 0){pos = val.length();}
        
        if(pos > 3)
        {
            flag = val;
            
            if (pos == 4)
            {
                flag = val.substring(0,1) + "," + val.substring(1,val.length());
            }

            if (pos == 5)
            {
                flag = val.substring(0,2) + "," + val.substring(2,val.length());
            }
            if (pos == 6)
            {
                flag = val.substring(0,3) + "," + val.substring(3,val.length());
            }         
            if(pos == 7)
            {
                    flag = val.substring(0,1) + "," + val.substring(1,4) + "," + val.substring(4,val.length());
            }
            
            if(pos == 10){flag = val.substring(0,1) + "," + val.substring(1,4) + "," +  val.substring(4,7) + "," + val.substring(7,val.length());}
                       
        }
        else
        {
            flag = val;
        }
        
        return flag;
    }

    public static void ExcelPorTabla (ArrayList mail, JTable tbl, int cantcolumnas)
    {
       FileInputStream archivoEntrada;
        
        try
        {        
            
            String rut = "\\\\10.59.226.199\\sistemas\\almacenamiento_sw_operativo\\documentos\\";    
            
            int x = 6;
            POIFSFileSystem poiArchivo;
            archivoEntrada = new FileInputStream(rut + "molde.xls");
            poiArchivo = new POIFSFileSystem(archivoEntrada);
            HSSFWorkbook libro;
            libro = new HSSFWorkbook(poiArchivo);
            HSSFSheet hoja = libro.getSheetAt(0);
            HSSFRow fila = hoja.createRow(0);
            HSSFCell celda = fila.createCell((short) 0);
            HSSFCellStyle f = null;                       
            
            boolean salir = true;
        
            try
            {
            
                fila = hoja.getRow(4);

               //CANT COLUMNAS ES PARA PONER LA CANTIDAD QUE ME MANDAN; ARMARLO PARA REPORTE EN EXCEL PUESTOS EN TABLAS ESTA MUY BUENO ESTO
                
                //CABEZAL
                try{celda = fila.getCell((short) 0);    
                celda.setCellValue(tbl.getColumnName(0));}catch(Exception ex){}
                    
                try{celda = fila.getCell((short) 1);  
                celda.setCellValue(tbl.getColumnName(1));}catch(Exception ex){}
                    
                try{celda = fila.getCell((short) 2);  
                celda.setCellValue(tbl.getColumnName(3));}catch(Exception ex){}
                
                           
                for(int i = 0; i < tbl.getRowCount(); i++)
                {                                                
                    fila = hoja.getRow(i + 5);
                    
                    try{celda = fila.getCell((short) 0);    
                    celda.setCellValue(tbl.getValueAt(i, 0).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 1);    
                    celda.setCellValue(tbl.getValueAt(i, 1).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 2);    
                    celda.setCellValue(tbl.getValueAt(i, 2).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 3);    
                    celda.setCellValue(tbl.getValueAt(i, 3).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 4);    
                    celda.setCellValue(tbl.getValueAt(i, 4).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 5);    
                    celda.setCellValue(tbl.getValueAt(i, 5).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 6);    
                    celda.setCellValue(tbl.getValueAt(i, 6).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 7);    
                    celda.setCellValue(tbl.getValueAt(i, 7).toString());}catch(Exception ex){}
                    
                    try{celda = fila.getCell((short) 8);    
                    celda.setCellValue(tbl.getValueAt(i, 8).toString());}catch(Exception ex){}

                }                               
                
            }
            catch(Exception ex)
            {
        
            }    
            
            
            String archi = "Procesado.xls";
            String ruta = rut + "Procesado.xls";
            FileOutputStream elFichero = new FileOutputStream(ruta);
            libro.write(elFichero);
            elFichero.close();
                        
            /*ArrayList unL = new ArrayList();
            adjuntos ad = new adjuntos();
            ad.nombre = archi;
            ad.adjunto = ruta;
            unL.add(ad);
            
            ArrayList pers = mail;
            
//            pers.add("uy.accounting@one-line.com");
            pers.add("gabriel.suarez@one-line.com");
                    
            Mail unM = new Mail("", "Reporte Layout Comisiones Excel" , "Envio de excel con lista de documentos","", unL, pers);
            */
        }
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
}
