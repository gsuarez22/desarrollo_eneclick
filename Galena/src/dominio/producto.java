
package dominio;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class producto 
{

    public String id = "",nombre = "",codigo = "",precio = "0",cantidadunitaria = "", barra= "", peso="", familia = "";
    
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
                this.familia = lista.getString("familia");
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
            String url = "insert into productos (familia, nombre, codigo, precio, barra, peso) VALUES ('" + familia + "','" + nombre + "','" + codigo + "','" + precio + "','" + barra + "','" + peso + "')";
            unB.StoreProcedure(url, "galena");            
        }
        else
        {
            BD unB = new BD();
            String url = "update productos set familia = '" + familia + "', nombre = '" + nombre + "', codigo = '" + codigo + "', precio = '" + precio + "', barra = '" + barra + "', peso = '" + peso + "' where id = '" + id + "'";
            unB.StoreProcedure(url, "galena");
        }
    }
    
}
    
