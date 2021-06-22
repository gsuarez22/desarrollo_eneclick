/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author gabriel.suarez
 */
public class imo 
{
    
    public String un = "";
    public String imo = "";
    public String numerobl = "";
    public String marca = "";
    public ArrayList misimo = new ArrayList();
    
    /*
    public BufferedReader cargarImo (BufferedReader br, bl unb, container unC) throws IOException
    {
        boolean seguir = true;
        ArrayList imo = new ArrayList();
        String linea = "";
        imo unI = new imo();
  
        while(seguir)
        {
            if((linea=br.readLine())!=null)
            {
                String[] lin = linea.split(":");
                try{if(lin[0].equals("UNNBR")){unI.un = lin[1];}}catch(Exception ex){unI.un = "";}
                try{if(lin[0].equals("CLASS")){unI.imo = lin[1];}}catch(Exception ex){unI.imo = "";}
     
                if(lin[0].equals("}CNTR_DANGER"))
                {
                    imo.add(unI);
                    unI = new imo();
                }
                
                if(lin[0].equals("{CNTR_DESC"))
                {
                    seguir = false;
                    misimo = imo;
                }
            }
        }
        return br;
    }

    public boolean cargar(ArrayList im, String vnumerobl, String marca, String usu) 
    {
        boolean flag = true;
        ONE.BD unb = new ONE.BD();
        
            int i = 0;
            while (i < im.size())
            {
                imo uni = (imo) im.get(i);
                String sql = "INSERT INTO bridge_imo (un_imo,id_escala,numero_imo,numero_con) VALUES (";
                sql += "'" + uni.un + "','" + vnumerobl + "','" + uni.imo + "','" + marca + "')";
                
                try 
                {
                    unb.sistema = "BRIDGE";
                    unb.usuario = usu;
                    unb.StoreProcedure(sql, "one");
                }
                catch(Exception ex)
                {
                    flag = false;
                }
                
                i++;                
            }
                
        return flag;
        
    }

    public boolean guardar() 
    {
            boolean flag = true;
            ONE.BD unb = new ONE.BD();
        
            int i = 0;

            String sql = "INSERT INTO bridge_imo (un_imo,id_escala,numero_imo,numero_con) VALUES (";
            sql += "'" + this.un + "','" + this.numerobl + "','" + this.imo + "','" + this.marca + "')";
                
            try 
            {
                unb.sistema = "BRIDGE";
                unb.usuario = "AUTOMATICO";
                unb.StoreProcedure(sql, "one");
            }
            catch(Exception ex)
            {
                flag = false;
            }
                
            i++;                
        
            return flag;
        
    }
    
    public void cargarDatos(String bl, String cont) 
    {
          String url = "SELECT distinct(un_imo) as un, numero_imo FROM bridge_imo WHERE id_escala = '" + bl + "' AND numero_con = '" + cont + "' GROUP BY un_imo, numero_imo order by numero_imo";
            
            //ONE.BD unb = new ONE.BD();
        
            try
            {
                BD unB = new BD();
                CachedRowSet lista = unB.Function(url);
                RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
                this.misimo = new ArrayList();
                
                while (lista.next())
                {
                    imo unI = new imo();
                    
                    unI.un = lista.getString(1);
                    unI.imo = lista.getString(2);
                    
                    this.misimo.add(unI);                    
                }
            }
            catch(Exception ex)
            {
            
            }
            
    }
    */
}
