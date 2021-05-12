/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gabriel.suarez
 */
public class archivo 
{

    public static String varchivo, vrutorg, vrutdest;
    
    public static DefaultTableCellRenderer alinearCentro1, alinearDerecha1, alinearIzquierda1 = new DefaultTableCellRenderer();
    
    public static String guardarArchivo (String rutaorigen, String rutadestino)
    {
        vrutorg = rutaorigen;
        vrutdest = rutadestino;
        String flag = "";
        
        try
        {
            if (copyFile(new File(vrutorg), new File(vrutdest)))
            {
                flag = "OK";
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error de Copia, revise que el archivo este cerrado. Intentelo nuevamente");
                eliminarArchivoDirectorio(new File(vrutdest));
                flag = "";
            }            
        }
        catch (Exception ex)
        {
        }

        return flag;
        
    }
    
    public static void cargarAlinecion()
    {
        
        alinearCentro1 = new DefaultTableCellRenderer();
        alinearCentro1.setHorizontalAlignment(SwingConstants.CENTER);
 
        alinearDerecha1 = new DefaultTableCellRenderer();
        alinearDerecha1.setHorizontalAlignment(SwingConstants.RIGHT);
 
        alinearIzquierda1 = new DefaultTableCellRenderer();
        alinearIzquierda1.setHorizontalAlignment(SwingConstants.LEFT);

    }
    
    public static String cargarURL(String id)
    {
                    
        BD unB = new BD();
        String flag = "";
        String url = "select ruta_adj from adjuntos where id_adj = '" + id + "'";
              
        try
        {
             CachedRowSet lista = unB.Function(url);
           
             while (lista.next()) 
             {
                flag = lista.getString(1);
             }
                
                     
        }
        catch(Exception ex)
        {
           
        }
        
        return flag;
        
    }
    
    private static void crearCarpetaLocal(String directorio)
    {
       File fichero = new File(directorio);
       boolean flag = true;
       if (fichero.mkdirs())
       {
           flag = true;
       } 
       else
       {
           flag = false;
       }

    }
    
    public static boolean eliminarArchivoDirectorio(File file) {
      if(file.isDirectory()){
        File[] files = file.listFiles();  
        for(int i = 0; i < files.length; i++) {  
            if(files[i].isDirectory()) {  
             eliminarArchivoDirectorio(files[i]);  
            } else {  
             files[i].delete();  
            }  
         }
      }else{
       file.delete();
      }
      return file.delete();  
     }  


    public static boolean copyFile(File s, File t)
    {
            boolean flag = false;
            try
            {
                  FileChannel in = (new FileInputStream(s)).getChannel();
                  FileChannel out = (new FileOutputStream(t)).getChannel();

                  in.transferTo(0, s.length(), out);
                  flag = true;

                  in.close();
                  out.close();
                  return flag;
            }
            catch(Exception e)
            {
                  System.out.println(e);
                  return false;
            }
    }
    
}
