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
public class equipo 
{
 
    public String id_equipo = "0", nombre = ""; 

    public ArrayList cargarEquipos (String url)
    {
        //id_equipo,nombre
        ArrayList flag = new ArrayList();
          
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.first();
            equipo unR = new equipo();
            unR.id_equipo = lista.getString("id_equipo");
            lista.beforeFirst();
            while(lista.next())
            {
                if(unR.id_equipo.equals(lista.getString("id_equipo")) == false)
                {                    
                    flag.add(unR);
                    unR = new equipo();
                }
                unR.id_equipo = lista.getString("id_equipo");
                unR.nombre = lista.getString("nombre");
                
            }
            flag.add(unR);
        }
        catch(Exception ex)
        {
            
        }
          
        return flag;

    }
    
}
