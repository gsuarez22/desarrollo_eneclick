
package dominio;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class producto 
{

    public String id = "",nombre = "",codigo = "",precio = "",cantidadunitaria = "";
    
    public void cargarPorId(String id)
    {
    
        boolean flag = false;
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function("Select * from productos where id = '" + id + "'");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.next();
            if (lista.getRow() > 0)
            {
                this.id = lista.getString("id");
                this.nombre = lista.getString("nombre");
                this.codigo = lista.getString("codigo");
                this.precio = lista.getString("precio");
                this.cantidadunitaria = lista.getString("cantidadunitaria");
            }
            
        }
        catch (Exception ex)
        {
             
        }
    }
    
}
