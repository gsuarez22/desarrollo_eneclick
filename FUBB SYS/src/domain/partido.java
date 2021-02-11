package domain;

import fubb.sys.DBSSH;
import java.util.ArrayList;
import java.util.Vector;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class partido 
{

    public String id_partido = "", titulo = "", division1 = "", division2 = "", fecha = "", hora = "", sub = "", cancha = "", local = "", visitante = "" , tv  = "", tipo = "", arbitro1, arbitro2, arbitro3;
    public int horaMil;
    public ArrayList recaudadores = new ArrayList();
    
    private boolean existe(String url)
    {
        boolean flag = false;
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            if(lista.size() > 0){flag = true;}
        }
        catch(Exception ex)
        {
            
        }
        return flag;
    }
    
    public boolean puede (String id_partido, String id_arbitro, String fecha_hora)
    {
        boolean flag = true;

        //NO ARBITRA OTRO PARTIDO ESE DIA A ESA hora
        String url = "select * FROM fubb.partidos WHERE id_partido <> '" + id_partido + "' AND arbitro1 = '" + id_arbitro + "' AND fecha_hora = '" + fecha_hora + "' " 
                + " UNION "
                + "select * FROM fubb.partidos WHERE id_partido <> '" + id_partido + "' AND arbitro2 = '" + id_arbitro + "' AND fecha_hora = '" + fecha_hora + "' "
                + " UNION "
                + "select * FROM fubb.partidos WHERE id_partido <> '" + id_partido + "' AND arbitro3 = '" + id_arbitro + "' AND fecha_hora = '" + fecha_hora + "' ";
        if(existe(url)){flag = false;}
        
        
        if(flag)
        {
        //REVISA AFINIDAD
            url = "select a.id_afinidad FROM fubb.afinidades a, fubb.equipos e, fubb.partidos p " +
            "WHERE a.id_arbitro = '" + id_arbitro + "' AND e.id_equipo = p.local AND e.nombre = a.id_equipo AND p.id_partido = '" + id_partido + "' " +
            " UNION " +
            " select a.id_afinidad FROM fubb.afinidades a, fubb.equipos e, fubb.partidos p " +
            " WHERE a.id_arbitro = '" + id_arbitro + "' AND e.id_equipo = p.visitante AND e.nombre = a.id_equipo AND p.id_partido = '" + id_partido + "' ";
            if(existe(url)){flag = false;}

            if(flag)
            {
                //REVISA QUE ESE PARTIDO YA NO TENGA ESTE ARBITRO ASIGNADO
                url = "select id_partido from fubb.partidos where id_partido = '" + id_partido + "' and (arbitro1 = '" + id_arbitro + "' OR arbitro2 = '" + id_arbitro + "' OR arbitro3 = '" + id_arbitro + "')";
                if(existe(url)){flag = false;}
            }
        }

        return flag;
    }
 
    public void afinarFechaHora()
    {
        String hm = "0";

        hm = fecha;
        hm = hm.substring(11,hm.length());
        hm = hm.replace(":", "");
        hm = hm.substring(0,4);
        horaMil = Integer.parseInt(hm);

    }    
    
}
