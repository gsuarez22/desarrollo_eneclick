package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.rowset.CachedRowSet;

public class usuarios 
{
    
    public String id = "0", usuario = "", password = "", firma = "";
    
    public boolean soyYo(String usu, String pass)
    {
        boolean flag = false;
        
        BD unB = new BD();
        String url = "Select * from users where usuario = '" + usu + "' and password = '"  + pass + "'";
      
        try
        {
            CachedRowSet lista = unB.Function(url);
            if (lista.next()) 
            {
                
                this.id = lista.getString("id");
                this.firma = lista.getString("firma");
                this.password = pass;
                this.usuario = usu;
                
                flag = true;
            }
            
        }
        catch(Exception ex)
        {
        
        }
        return flag;
    }       

}
