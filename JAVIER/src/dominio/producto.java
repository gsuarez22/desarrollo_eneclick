
package dominio;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class producto 
{

    public String preciounitario = "",id = "",nombre = "",codigo = "",precio = "",cantidadunitaria = "", url = "", barra = "", familia = "", peso = "";
    
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
                this.familia = lista.getString("familia");
                this.barra = lista.getString("barra");
                this.url = lista.getString("url");
                this.cantidadunitaria = lista.getString("cantidadunitaria");
                
                try
                {
                    double calc = Double.parseDouble(this.precio) / Double.parseDouble(this.cantidadunitaria);
                    this.preciounitario = String.valueOf(Math.round(calc));
                }
                catch(Exception ex)
                {
                    
                }
                
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
            String ur = "update productos set precio = '" + precio + "' where id = '" + id + "'";
            unB.StoreProcedure(ur, "javier");
        }
        catch (Exception ex)
        {
             
        }
    }   

        public void borrar(String id)
    {
        try
        {
            BD unB = new BD();
            String ur = "delete from productos where id = '" + id + "'";
            unB.StoreProcedure(ur, "javier");
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
            String ur = "insert into productos (url, familia, nombre, codigo, precio, barra, peso, cantidadunitaria) VALUES ('" + url + "','" + familia + "','" + nombre + "','" + codigo + "','" + precio + "','" + barra + "','" + peso + "','" + cantidadunitaria + "')";
            unB.StoreProcedure(ur, "javier");            
        }
        else
        {
            BD unB = new BD();
            String ur = "update productos set cantidadunitaria = '" + cantidadunitaria + "', url = '" + url + "', familia = '" + familia + "', nombre = '" + nombre + "', codigo = '" + codigo + "', precio = '" + precio + "', barra = '" + barra + "', peso = '" + peso + "' where id = '" + id + "'";
            unB.StoreProcedure(ur, "javier");
        }
    }
    
}
