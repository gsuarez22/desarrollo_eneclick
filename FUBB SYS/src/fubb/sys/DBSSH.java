package fubb.sys;

import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.sun.rowset.CachedRowSetImpl;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

public class DBSSH {
    
    static int lport;
    static String rhost;
    static int rport;

    public static CachedRowSet Function(String sql){
        
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
    
        
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            //lport = 1234;
            lport = 3306;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            
            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "fubb",passsql);
                    
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

            ResultSet rs= s.executeQuery(sql);
 
            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);
            rs.close();
            s.close();
            con.close();
            session.disconnect();
            return crs;                              

        }         
        catch(Exception e)
        {
            System.err.print(e);
        }
        
        return null;
    }
    
    public static void Todos (ArrayList c)
    {
        
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
    
        
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            //lport = 1234;
            lport = 3306;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            
            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "fubb",passsql);
            
            int i = 0;
            while (c.size() > i)
            {
                Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);
                String sql = c.get(i).toString();
                s.execute(sql);
                i++;
                s.close();
            }
            
            con.close();
            session.disconnect();

        }         
        catch(Exception e)
        {
            System.err.print(e);
        }
        
    }
    
    public static void StoreProcedure(String sql){
        
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
    
        
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            //lport = 1234;
            lport = 3306;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            
            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "fubb",passsql);
                    
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

            ResultSet rs= s.executeQuery(sql);

            
            s.execute(sql);
            
            s.close();
            con.close();
            session.disconnect();

        }         
        catch(Exception e)
        {
            System.err.print(e);
        }
        

    }
    
}