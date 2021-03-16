
package domain;

public class Notificacion {
    
    public String id = "0", notificacion = "", cliente = "", mailto = "", mailfrom = "", reserva = "", asunto= "";
    
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_notificaciones (notificacion, cliente, mailto, mailfrom, reserva, asunto) VALUES ";
            url = url + " ('" + notificacion + "','" + cliente + "','" + mailto + "','" + mailfrom + "','" + reserva + "','" + asunto + "')";
        }
        else
        {
            url = "update sif_notificaciones set asunto = '" + asunto + "', notificacion = '" + notificacion + "',cliente = '" + cliente + "',mailto = '" + mailto + "',mailfrom = '" + mailfrom + "' ";
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
            url = "delete from sif_notificaciones ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }

    public void guardarArchivo(String ruta, String id) 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0") == false)
        {
            ruta = ruta.replace("\\", "/");
            url = "update sif_notificaciones set adjunto = '" + ruta + "' where id = '" + id + "' ";
            unb.StoreProcedure(url, "sif_agente");
        }
     
    }
    
}
