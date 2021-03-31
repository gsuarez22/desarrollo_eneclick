/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author gsuarez
 */
public class ComponentesLista {
    
    DefaultTableModel tableModel;
    DefaultListModel listModel;
     
    
    public ComponentesLista()
    {
        
    }
    
     public boolean isCellEditable(int rowIndex, int colIndex) {
        return false; //Disallow the editing of any cell
    }
    
   
    public int buscarEnLista(String texto, Choice c)
    {
        int valor = 0;
        
        try
        {
           for (int i = 0;i < c.getItemCount();i++)
           {
               if (texto.equals(c.getItem(i)))
               {
                   valor = i;
                   i = c.getItemCount();
               }
           } 
            return valor;
        }
        catch(Exception ex)
        {
            return valor;    
        }
        
    }
    
     public int buscarEnLista(String texto, javax.swing.JComboBox c)
    {
        int valor = 0;
        
        try
        {
           for (int i = 0;i < c.getItemCount();i++)
           {
               if (texto.equals(c.getItemAt(i)))
               {
                   valor = i;
                   i = c.getItemCount();
               }
           } 
            return valor;
        }
        catch(Exception ex)
        {
            return valor;    
        }
        
    }
    
    
    public void cargarCombo(String url, Choice c)
    {
      
        try{
                               
            BD unb = new BD();
            CachedRowSet lista = unb.Function(url);        
            String valor = "";
            
            c.removeAll();
            
            while (lista.next()) 
            {
                valor = lista.getString(1);
		c.addItem(valor);
            }
                          	            
            lista.close();
            
        }
        catch(Exception ex)
        {
            
        }
      
    }
    
      public void cargarCombo(String url, javax.swing.JComboBox c)
    {
      
        try{
        
            BD unb = new BD();
            CachedRowSet lista = unb.Function(url);        
            String valor = "";
            
            try{c.removeAllItems();}catch(Exception ex){}
            
            c.addItem("");
            
            while (lista.next()) 
            {
                valor = lista.getString(1);
		c.addItem(valor);
            }
                          	            
            lista.close();
            
        }
        catch(Exception ex)
        {
            
        }
      
    }
    
    
    private int darMes (String mes)
    {
        int flag = 0;
        if (mes.toUpperCase().equals("ENERO")){flag = 1;}
        if (mes.toUpperCase().equals("FEBRERO")){flag = 2;}
        if (mes.toUpperCase().equals("MARZO")){flag = 3;}
        if (mes.toUpperCase().equals("ABRIL")){flag = 4;}
        if (mes.toUpperCase().equals("MAYO")){flag = 5;}
        if (mes.toUpperCase().equals("JUNIO")){flag = 6;}
        if (mes.toUpperCase().equals("JULIO")){flag = 7;}
        if (mes.toUpperCase().equals("AGOSTO")){flag = 8;}
        if (mes.toUpperCase().equals("SETIEMBRE")){flag = 9;}
        if (mes.toUpperCase().equals("OCTUBRE")){flag = 10;}
        if (mes.toUpperCase().equals("NOVIEMBRE")){flag = 11;}
        if (mes.toUpperCase().equals("DICIEMBRE")){flag = 12;}
        
        return flag;
    }      
    
    private String darMesNumero (int mes, int año)
    {
        String flag = "";

        if (mes == 1){flag = "enero " + año;}
        if (mes == 2){flag = "febrero " + año;}        
        if (mes == 3){flag = "marzo " + año;}
        if (mes == 4){flag = "abril " + año;}
        if (mes == 5){flag = "mayo " + año;}
        if (mes == 6){flag = "junio " + año;}
        if (mes == 7){flag = "julio " + año;}
        if (mes == 8){flag = "agosto " + año;}
        if (mes == 9){flag = "setiembre " + año;}
        if (mes == 10){flag = "octubre " + año;}
        if (mes == 11){flag = "noviembre " + año;}
        if (mes == 12){flag = "diciembre " + año;}
        
        return flag;
    }      
    
    
    public void cargarComboEspecial(String url, javax.swing.JComboBox c)
    {
      
        try{
    
            Calendar c1 = Calendar.getInstance();
                        
            String actual = darMesNumero(c1.get(Calendar.MONTH) + 1, c1.get(Calendar.YEAR) - 2000);
            String anterior = "";
            
            int dia = c1.get(Calendar.DATE);
            
            if (c1.get(Calendar.DATE) <= 4)
            {
                int mes = c1.get(Calendar.MONTH);
                int año = c1.get(Calendar.YEAR) - 2000;
                if (c1.get(Calendar.MONTH) +1 == 1)
                {
                    mes = 12;
                    año = c1.get(Calendar.YEAR) - 2001;
                }
                anterior = darMesNumero(mes, año);
            }   
            
            c.removeAllItems();
            
            c.addItem(actual);
            
            if (!anterior.equals(""))
            {
                c.addItem(anterior);
            }
            
        }
        catch(Exception ex)
        {
            
        }
      
    }
    
    public void cargarTabla(String url, JTable t)
    {
      
        try{
            BD unb = new BD();
            CachedRowSet lista = unb.Function(url);
            Vector v = new Vector();
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            tableModel = new DefaultTableModel(0,rsmd.getColumnCount())
            {
            @Override
            public boolean isCellEditable(int row, int col)
            {
                return false;
            }
            };
                          
            for (int i = 1; i <= rsmd.getColumnCount();i++)
            {
                v.add(rsmd.getColumnLabel(i));
            }
            
            tableModel.setColumnIdentifiers(v);
                                             
            while (lista.next()) 
            {
                  
                Vector ar = new Vector();
                
                for (int i = 1; i <= rsmd.getColumnCount();i++)
                {
                    ar.add (lista.getString(i));
                }

                tableModel.addRow(ar);
            }
            
            t.setModel(tableModel);
            
            //t.setValueAt("ID", 0, 1);
            
            lista.close();
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
      
    }

    public void cargarTablaConfirmada(String url, JTable t)
    {
      
        try{
            
            BD unb = new BD();
            CachedRowSet lista = unb.Function(url);
            Vector v = new Vector();
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            tableModel = new DefaultTableModel(0,rsmd.getColumnCount());
            
            for (int i = 1; i <= rsmd.getColumnCount();i++)
            {
                v.add(rsmd.getColumnLabel(i));
            }
            
            tableModel.setColumnIdentifiers(v);
                                             
            while (lista.next()) 
            {
                  
                Vector ar = new Vector();
                
                for (int i = 1; i <= rsmd.getColumnCount();i++)
                {
                    if (i == rsmd.getColumnCount())
                    {
                        try
                        {
                            String d = lista.getString(i).toString();
                            if (!"".equals(d))
                            {
                                ar.add ("CONFIRMADA");
                            }
                            else
                            {
                                ar.add ("PENDIENTE");
                            }
                        }
                        catch(Exception ex)
                        {
                            
                        }
                    }
                    else
                    {
                        ar.add (lista.getString(i));
                    }
                }

                tableModel.addRow(ar);
            }
            
            t.setModel(tableModel);
            
            //t.setValueAt("ID", 0, 1);
            
            lista.close();
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
      
    }
    
    public void cargarLista(String url, java.awt.List l)
    {
      
        try{
            
            BD unb = new BD();
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
                       
            l.removeAll();
            
            while (lista.next()) 
            {
                               
                l.add(lista.getString(1)); 
                
            }
                      
            lista.close();
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
      
    }
    
}
