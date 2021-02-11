/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import fubb.sys.DBSSH;
import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author sistemas
 */
public class cancha {
    
    public String id_cancha = "0", nombre_cancha = "", dia = "", tipo_torneo = ""; 
    
    public ArrayList partidosDelDia;
    
    public ArrayList cargarCanchas (String url)
    {
        //id_equipo,nombre
        ArrayList flag = new ArrayList();
          
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.first();
            cancha unR = new cancha();
            unR.id_cancha = lista.getString("id_cancha");
            lista.beforeFirst();
            while(lista.next())
            {
                if(unR.id_cancha.equals(lista.getString("id_cancha")) == false)
                {                    
                    flag.add(unR);
                    unR = new cancha();
                }
                unR.id_cancha = lista.getString("id_cancha");
                unR.nombre_cancha = lista.getString("nombre_cancha");
                
            }
            flag.add(unR);
        }
        catch(Exception ex)
        {
            
        }
          
        return flag;

    }
}
