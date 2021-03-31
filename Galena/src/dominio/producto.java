
package dominio;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class producto 
{

    public String id = "",nombre = "",codigo = "",precio = "",cantidadunitaria = "", barra= "", peso="";
    
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
                this.peso = lista.getString("peso");
                this.barra = lista.getString("barra");
            }
            
        }
        catch (Exception ex)
        {
             
        }
    }
    
    public void guardarPrecio()
    {
        try
        {
            BD unB = new BD();
            String url = "update productos set precio = '" + precio + "' where id = '" + id + "'";
            unB.StoreProcedure(url, "galena");
        }
        catch (Exception ex)
        {
             
        }
    }   
    
    public void guardar()
    {
        if(id.equals("0"))
        {
            BD unB = new BD();
            String url = "insert into productos (nombre, codigo, precio, barra, peso) VALUES ('" + nombre + "','" + codigo + "','" + precio + "','" + barra + "','" + peso + "')";
            unB.StoreProcedure(url, "galena");            
        }
        else
        {
            BD unB = new BD();
            String url = "update productos set nombre = '" + nombre + "', codigo = '" + codigo + "', precio = '" + precio + "', barra = '" + barra + "', peso = '" + peso + "' where id = '" + id + "'";
            unB.StoreProcedure(url, "galena");
        }
    }
    
}
    
