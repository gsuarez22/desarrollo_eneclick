
package dominio;

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
            unB.StoreProcedure(url, "javier");
            traerElUltimo();
        }
        else
        {
            BD unB = new BD();
            String url = "update ventas set cliente = '" + cliente + "', total = '" + total + "' where idventas = '" + idventas + "'";
            unB.StoreProcedure(url, "javier");
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
    
}
