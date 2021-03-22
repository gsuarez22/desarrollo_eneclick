package domain;

public class Carga 
{

    //ATRIBUTOS
    
    public String numero_stock, acta, deposito, dua, volumen = "", id = "0", id_reserva = "", marca = "", tipo_bultos = "", id_mercaderia = "", cantidad_bultos = "", peso_bultos = "", largo= "",ancho ="", alto="", coeficiente= "";
    
    //METODOS
    public void guardarConsolidado() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_cargas_consolidadas (numero_stock, acta, deposito, dua, largo,ancho,alto,coeficiente,id_reserva, marca, tipo_bultos, id_mercaderia, cantidad_bultos, peso_bultos) VALUES ";
            url = url + " ('" + numero_stock + "','" + acta + "','" + deposito + "','" + dua + "','" + largo + "','" + ancho + "','" + alto + "','" + coeficiente + "','" + id_reserva + "','" + marca + "','" + tipo_bultos + "','" + id_mercaderia + "','" + cantidad_bultos + "', '" + peso_bultos + "')";
        }
        else
        {
            url = "update sif_cargas_consolidadas set numero_stock = '" + numero_stock + "', acta = '" + acta + "', deposito = '" + deposito + "', dua = '" + dua + "', alto = '" + alto + "', ancho = '" + ancho + "', largo = '" + largo + "', tipo_bultos = '" + tipo_bultos + "',id_mercaderia = '" + id_mercaderia + "',cantidad_bultos = '" + cantidad_bultos + "', peso_bultos = '" + peso_bultos + "' ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }

    public void borrarConsolidado() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0") == false)
        {
            url = "delete from sif_cargas_consolidadas ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }

    
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_cargas (volumen, id_reserva, marca, tipo_bultos, id_mercaderia, cantidad_bultos, peso_bultos) VALUES ";
            url = url + " ('" + volumen + "','" + id_reserva + "','" + marca + "','" + tipo_bultos + "','" + id_mercaderia + "','" + cantidad_bultos + "', '" + peso_bultos + "')";
        }
        else
        {
            url = "update sif_cargas set volumen = '" + volumen + "', tipo_bultos = '" + tipo_bultos + "',id_mercaderia = '" + id_mercaderia + "',cantidad_bultos = '" + cantidad_bultos + "', peso_bultos = '" + peso_bultos + "' ";
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
            url = "delete from sif_cargas ";
            url = url + " where id = '" + id + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }
    
}
