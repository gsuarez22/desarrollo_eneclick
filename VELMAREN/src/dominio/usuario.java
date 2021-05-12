package dominio;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author ENECLICK
 * 
 */

public class usuario 
{

    //ATRIBUTOS INICIALIZADOS
    public String id_usuario = "0", nombre = "", tipo = "", clave = "", nick = "";
    
    public boolean loguearme (String nick, String pass)
    {
        boolean flag = false;
        
        String url = "SELECT * FROM usuarios WHERE nick = '" + nick + "' AND clave = '" + pass + "'";
      
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function(url, "velmaren");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while(lista.next())
            {
                //RECORRO CON EL WHILE EL RESULTADO DE LA CONSULTA ESPERANDO UN ITEM SOLO
                flag = true;
                this.id_usuario = lista.getString("id_usuario");
                this.nombre = lista.getString("nombre");
                this.tipo = lista.getString("tipo");
                this.nick = lista.getString("nick");
                this.clave = lista.getString("clave");
                
            }
            
        }
        catch (Exception ex)
        {
        }     
        
        return flag;
    }
    
}
