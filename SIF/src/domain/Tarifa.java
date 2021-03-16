/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author instalador
 */
public class Tarifa 
{

    public String id = "0", id_reserva = "", compra = "", venta = "", moneda = "", tipo = "",tipoReserva="", contenedor = "";
    
        //METODOS
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id.equals("0"))
        {
            url = "insert into sif_tarifas (id_reserva, tipo, compra, venta, moneda,tipoReserva, contenedor) VALUES ";
            url = url + " ('" + id_reserva + "','" + tipo + "','" + compra + "','" + venta + "','" + moneda + "','" + tipoReserva + "', '" + contenedor + "')";
        }
        else
        {
            url = "update sif_tarifas set tipo = '" + tipo + "',compra = '" + compra + "',venta = '" + venta + "', moneda = '" + moneda + "', tipoReserva = '" + tipoReserva + "', contenedor = '" + contenedor + "'";
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
    
}
