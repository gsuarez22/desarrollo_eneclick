
package dominio;

public class linea 
{

    public String id = "",idventas = "",idproducto = "",nombreproducto = "",cantidad = "",cantidadunitaria = "",preciounitario = "",preciofinal = "";
    
    public void guardar()
    {
        if(id.equals("0") || id.equals(""))
        {
            BD unB = new BD();
            String url = "insert into ventas_lineas (idventas, idproducto, nombreproducto, cantidad, cantidadunitaria, preciounitario, preciofinal) VALUES ('" + idventas + "','" + idproducto + "','" + nombreproducto + "','" + cantidad + "','" + cantidadunitaria + "','" + preciounitario + "','" + preciofinal + "')";
            unB.StoreProcedure(url, "galena");
        }
        else
        {
            //BD unB = new BD();
            //String url = "update ventas set cliente = '" + cliente + "', total = '" + total + "' where idventas = '" + idventas + "'";
            //unB.StoreProcedure(url, "javier");
        }
    }
    
    public void borrar()
    {
        if(id.equals("0") == false || id.equals("") == false)
        {
            BD unB = new BD();
            String url = "delete from ventas_lineas where id = '" + id + "'";
            unB.StoreProcedure(url, "galena");
        }
    }
    
}
