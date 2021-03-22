
package domain;

import javax.sql.rowset.CachedRowSet;

public class Contenedor 
{

    //ATRIBUTOS
    public String id = "0", terminal = "", vacios = "", dias = "", id_reserva = "", marca = "", tipo = "", tipo_carga = "", precintos = "";
   
    
    //METODOS
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_contenedores (terminal, vacios, dias, id_reserva, marca, tipo, tipo_carga, precintos) VALUES ";
            url = url + " ('" + terminal + "','" + vacios + "','" + dias + "','" + id_reserva + "','" + marca + "','" + tipo + "','" + tipo_carga + "','" + precintos + "')";
        }
        else
        {
            url = "update sif_contenedores set terminal = '" + terminal + "', vacios = '" + vacios + "', dias = '" + dias + "', marca = '" + marca + "',tipo = '" + tipo + "',tipo_carga = '" + tipo_carga + "', precintos = '" + precintos + "' ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }
    
    public void borrar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0") == false)
        {
            url = "delete from sif_tarifas ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }

    private Contenedor hayContenedor(String vid_reserva)
    {
        Contenedor flag = new Contenedor();
        BD unB = new BD();
        String url = "Select id, marca, id_reserva from sif_contenedores where id_reserva = '" + vid_reserva + "'";
        int numero = 0;
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {
                flag.id = lista.getString("id");
                flag.marca = lista.getString("marca");
                flag.id_reserva = lista.getString("id_reserva");
            }
            
        }
        catch(Exception ex)
        {
        
        }
        return flag;
        
    }
    
    public Contenedor traerContenedorAvion(String vid_reserva) 
    {
    
        Contenedor cont = hayContenedor(vid_reserva);
        if(cont.id.equals("0"))
        {
            cont.id_reserva = vid_reserva;
            cont.marca = "AEREO";
            cont.tipo_carga = "CONSOLIDADO";
            cont.guardar();
            cont = hayContenedor(vid_reserva);
        }
        return cont;
    }
    
}
