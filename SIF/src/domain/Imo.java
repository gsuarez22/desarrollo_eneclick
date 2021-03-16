
package domain;


public class Imo 
{

    //ATRIBUTOS
    
    public String id = "0", id_reserva = "", marca = "", tipo_imo = "", id_carga = "", unn = "";

    
    //METODOS
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_imos (id_carga, id_reserva, marca, unn, tipo_imo) VALUES ";
            url = url + " ('" + id_carga + "','" + id_reserva + "','" + marca + "','" + unn + "','" + tipo_imo + "')";
        }
        else
        {
            url = "update sif_imos set unn = '" + unn + "',tipo_imo = '" + tipo_imo + "' ";
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
            url = "delete from sif_imos ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }
    
}
