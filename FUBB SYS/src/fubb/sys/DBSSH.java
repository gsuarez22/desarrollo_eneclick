package fubb.sys;

import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.sun.rowset.CachedRowSetImpl;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

public class DBSSH {
    
    static int lport;
    static String rhost;
    static int rport;

    public static CachedRowSet Function(String sql){
        
        String passsql = "Xt2zKZXk@7X^H!U=";
        String user = "root";
        String password = "salu2carrito";
        String host = "179.27.99.90";
        int port=22;
        JSch jsch = new JSch();
            
        try
        {
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            
            lport = 1234;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "root",passsql);
                    
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
        
        String passsql = "Xt2zKZXk@7X^H!U=";
        String user = "root";
        String password = "salu2carrito";
        String host = "179.27.99.90";
        int port=22;
        JSch jsch = new JSch();
            
        try
        {
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            
            lport = 1234;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "root",passsql);
                    
            
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
        
        String passsql = "Xt2zKZXk@7X^H!U=";
        String user = "root";
        String password = "salu2carrito";
        String host = "179.27.99.90";
        int port=22;
        JSch jsch = new JSch();
            
        try
        {
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            
            lport = 1234;
            rhost = "localhost";
            rport = 3306;
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:" + assinged_port + "/fubb";
            Connection con = DriverManager.getConnection(url, "root",passsql);
                    
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

            
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