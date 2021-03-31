
package dominio;

import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class venta 
{

    public String idventas = "",fecha = "",cliente = "",total = "";
    
    public void ActualizarVenta()
    {
        if(idventas.equals("0"))
        {
            BD unB = new BD();
            String url = "insert into ventas (cliente, total) VALUES ('" + cliente + "','" + total + "')";
            unB.StoreProcedure(url, "galena");
            traerElUltimo();
        }
        else
        {
            BD unB = new BD();
            String url = "update ventas set cliente = '" + cliente + "', total = '" + total + "' where idventas = '" + idventas + "'";
            unB.StoreProcedure(url, "galena");
        }
    }
    
    public void traerElUltimo()
    {
    
        boolean flag = false;
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function("Select MAX(idventas) as ultimo from ventas");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.next();
            if (lista.getRow() > 0)
            {
                this.idventas = lista.getString("ultimo");
            }
            
        }
        catch (Exception ex)
        {
             
        }
    }

    public void borrarVentas() {
        BD unB = new BD();
        ArrayList lista= new ArrayList();
                   
        String url="delete from ventas_lineas";
        lista.add(url);
        url ="delete from ventas";
        lista.add(url);
        
        unB.Todos(lista, "galena");
        
    }
    
}
