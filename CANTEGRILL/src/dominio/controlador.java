
package dominio;

/**
 *
 * @author ENECLICK
 * 
 */

public class controlador 
{
    public usuario miUsuario = new usuario();
    
    public boolean conectarUsuario (String nick, String pass)
    {
        boolean flag = false;
        
        flag = miUsuario.loguearme(nick, pass);
        
        return flag;
    }
    
}
