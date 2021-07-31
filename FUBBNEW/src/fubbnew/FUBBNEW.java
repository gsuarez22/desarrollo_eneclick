/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fubbnew;

import java.sql.SQLException;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sistemas
 */
public class FUBBNEW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
         String passsql = "PASSWORD";
        
        
        JSch jsch = new JSch();
        try
        {
            //Nuevo en Amazon
            jsch.addIdentity("C:/fubb/fuentes/FUBBKEYPAIR2.pem");
            jsch.setConfig("StrictHostKeyChecking", "no");

            //enter your own EC2 instance IP here
            Session session=jsch.getSession("ubuntu", "13.58.138.148", 22);
            session.connect();
    
            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception ex) {
                        String salir = "d";
            }

            
            int lport = 1234;
            String rhost = "localhost";
            int rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);

            JOptionPane.showMessageDialog(null, "Hola 1");
            
        
            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "fubb",passsql);
                    
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

            ResultSet rs= s.executeQuery("Select * from partidos");
 
            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);
            rs.close();
            s.close();
            con.close();
            session.disconnect();
            //return crs;     
            JOptionPane.showMessageDialog(null, "Hola");

        }         
        catch(Exception e)
        {
            System.err.print(e);
        }
        
        //return null;
        

        
        
    }
    
}
