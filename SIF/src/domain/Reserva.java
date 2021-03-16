
package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.rowset.CachedRowSet;


public class Reserva 
{

    public String numsif = "0",id_reserva = "0", entidad_cliente = "", origen = "", destino = "", trasbordo1 = "", trasbordo2 = "", url_drive = "";
    public String detalle = "", transporte_entidad = "", transporte_nombre = "", transporte_viaje = "", etd = "", eta = "", house_bl = "";
    public String house_tipo = "", master_bl= "", master_tipo = "", contrato = "", tipo_embarque = "", tipo_reserva = "";
    public String proveedor_entidad = "", agente_entidad = "", numero_sif = "", estado = "";

    public String darNumeroSif()
    {
        SimpleDateFormat unS = new SimpleDateFormat("yyyy");
        String ano = unS.format(new Date());
        String flag = "";
        BD unB = new BD();
        String url = "Select max(numsif) as numero from sif_reservas";
        int numero = 0;
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {
                try{numero = Integer.parseInt(lista.getString("numero"));}catch(Exception ex){numero = 2923;}
            }
            numero++;
            numsif = String.valueOf(numero);
            flag = "SIF-" + numero + "-" + ano;
            
        }
        catch(Exception ex)
        {
        
        }
        return flag;
    }
    
    public void guardar() 
    {
        BD unb = new BD();
        String url = "";
        if(id_reserva.equals("0"))
        {
            numero_sif = darNumeroSif();
            
            url = "insert into sif_reservas (numsif,id_reserva,entidad_cliente,origen,destino,trasbordo1,trasbordo2,url_drive,transporte_entidad,transporte_nombre,transporte_viaje,etd,eta,house_bl,house_tipo,master_bl,master_tipo,contrato,tipo_embarque,tipo_reserva,proveedor_entidad,agente_entidad,numero_sif,estado) VALUES ";
            url = url + " ('" + numsif + "','" + id_reserva + "','" + entidad_cliente + "','" + origen + "','" + destino + "','" + trasbordo1 + "','" + trasbordo2 + "','" + url_drive + "','" + transporte_entidad + "','" + transporte_nombre + "','" + transporte_viaje + "','" + etd + "','" + eta + "','" + house_bl + "','" + house_tipo + "','" + master_bl + "','" + master_tipo + "','" + contrato + "','" + tipo_embarque + "','" + tipo_reserva + "','" + proveedor_entidad + "','" + agente_entidad + "','" + numero_sif + "','" + estado + "')";
        }
        else
        {
            url = "update sif_reservas set entidad_cliente = '" + entidad_cliente + "',origen = '" + origen + "',destino = '" + destino + "',trasbordo1 = '" + trasbordo1 + "',trasbordo2 = '" + trasbordo2 + "',url_drive = '" + url_drive + "',transporte_entidad = '" + transporte_entidad + "',transporte_nombre = '" + transporte_nombre + "',transporte_viaje = '" + transporte_viaje + "',etd = '" + etd + "',eta = '" + eta + "',house_bl = '" + house_bl + "',house_tipo = '" + house_tipo + "',master_bl = '" + master_bl + "',master_tipo = '" + master_tipo + "',contrato = '" + contrato + "',tipo_embarque = '" + tipo_embarque + "',tipo_reserva = '" + tipo_reserva + "',proveedor_entidad = '" + proveedor_entidad + "',agente_entidad = '" + agente_entidad + "',estado = '" + estado + "' ";
            url = url + " where id_reserva = '" + id_reserva + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
    }

    public void cargarPorId() 
    {
        BD unB = new BD();
        String url = "Select * from sif_reservas where id_reserva = '" + id_reserva + "'";
        
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {
                this.id_reserva = lista.getString("id_reserva");
                this.agente_entidad = lista.getString("agente_entidad");
                this.contrato = lista.getString("contrato");
                this.destino = lista.getString("destino");
                this.detalle = lista.getString("detalle");
                this.entidad_cliente = lista.getString("entidad_cliente");
                this.estado = lista.getString("estado");
                this.eta = lista.getString("eta");
                this.etd = lista.getString("etd");
                this.house_bl = lista.getString("house_bl");
                this.house_tipo = lista.getString("house_tipo");
                this.master_bl = lista.getString("master_bl");
                this.master_tipo = lista.getString("master_tipo");
                this.numero_sif = lista.getString("numero_sif");
                this.origen = lista.getString("origen");
                this.proveedor_entidad = lista.getString("proveedor_entidad");
                this.tipo_embarque = lista.getString("tipo_embarque");
                this.tipo_reserva = lista.getString("tipo_reserva");
                this.transporte_entidad = lista.getString("transporte_entidad");
                this.transporte_nombre = lista.getString("transporte_nombre");
                this.transporte_viaje = lista.getString("transporte_viaje");
                this.trasbordo1 = lista.getString("trasbordo1");
                this.trasbordo2 = lista.getString("trasbordo2");
                this.url_drive = lista.getString("url_drive");
            }
        }
        catch(Exception ex)
        {
        }
             
    }

    public void cargarPorSif(String num) 
    {
        BD unB = new BD();
        String url = "SELECT * FROM sif_reservas WHERE numero_sif like '%" + num + "%'";
        
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {
                this.id_reserva = lista.getString("id_reserva");
                this.agente_entidad = lista.getString("agente_entidad");
                this.contrato = lista.getString("contrato");
                this.destino = lista.getString("destino");
                this.detalle = lista.getString("detalle");
                this.entidad_cliente = lista.getString("entidad_cliente");
                this.estado = lista.getString("estado");
                this.eta = lista.getString("eta");
                this.etd = lista.getString("etd");
                this.house_bl = lista.getString("house_bl");
                this.house_tipo = lista.getString("house_tipo");
                this.master_bl = lista.getString("master_bl");
                this.master_tipo = lista.getString("master_tipo");
                this.numero_sif = lista.getString("numero_sif");
                this.origen = lista.getString("origen");
                this.proveedor_entidad = lista.getString("proveedor_entidad");
                this.tipo_embarque = lista.getString("tipo_embarque");
                this.tipo_reserva = lista.getString("tipo_reserva");
                this.transporte_entidad = lista.getString("transporte_entidad");
                this.transporte_nombre = lista.getString("transporte_nombre");
                this.transporte_viaje = lista.getString("transporte_viaje");
                this.trasbordo1 = lista.getString("trasbordo1");
                this.trasbordo2 = lista.getString("trasbordo2");
                this.url_drive = lista.getString("url_drive");
            }
        }
        catch(Exception ex)
        {
        }
             
    }
    
    public boolean borrar() 
    {
        boolean flag = false;
        BD unb = new BD();
        String url = "";
        if(id_reserva.equals("0") == false)
        {
            flag = true;
            url = "delete from sif_reservas where id_reserva = '" + id_reserva + "'";
            unb.StoreProcedure(url, "sif_agente");
        }
        
        return flag;
        
    }

    public void guardarDetalle() {
    
        BD unb = new BD();
        String url = "";
        if(id_reserva.equals("0") == false)
        {
            url = "update sif_reservas set detalle = '" + this.detalle + "' ";
            url = url + " where id_reserva = '" + id_reserva + "'";
        }
        unb.StoreProcedure(url, "sif_agente");
        
    }

    public String darMailCliente() 
    {
        String flag = "";
        
        BD unB = new BD();
        String url = "SELECT mail FROM `sif_entidades` WHERE tipo = 'CLIENTE' and empresa = '" + this.entidad_cliente + "'";
        
        try
        {
            CachedRowSet lista = unB.Function(url);
            while (lista.next()) 
            {
                flag = lista.getString(1);
            }
        }
        catch(Exception ex)
        {
        }
        return flag;
        
    }
    
    public String asunto ()
    {
        String flag = "";
        
        flag = "Notificación ID: " + id_reserva + " SIF_NUM: " + numero_sif + " Cliente: " + entidad_cliente + " HOUSE: " + house_bl;
        
        return flag;
    }
    
}
