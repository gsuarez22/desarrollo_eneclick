package dominio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
//import sun.jdbc.odbc.JdbcOdbcDriver;

/**
 *
 * @author gsuarez
 */
public class BD {
    
    public String usuario = "GENERICO";
    public String sistema = "DESCONOCIDO";
    
    public CachedRowSet Function(String sql)
    {
            try
            {
                
                    Class.forName("com.mysql.jdbc.Driver");

//                    String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                    String url = "jdbc:mysql://192.168.0.134/cantegrill";
                    Connection con = DriverManager.getConnection(url, "admin","admin");
                    
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs= s.executeQuery(sql);
 
                    CachedRowSet crs = new CachedRowSetImpl();
                    crs.populate(rs);
                                       
                    rs.close();
                    s.close();
                    con.close();
 
                    return crs;
 
            }
            catch(Exception e)
            {
                 return null;
            }
    }
	
    public ResultSet FunctionREsultset (String sql, String base)
    {
            try
            {
                
                    Class.forName("com.mysql.jdbc.Driver");

//                    String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                    String url = "jdbc:mysql://192.168.0.134/cantegrill";
                    Connection con = DriverManager.getConnection(url, "admin","admin");

                    
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs= s.executeQuery(sql);
 
                    return rs;
 
            }
            catch(Exception e)
            {
                try
                {

                        Class.forName("com.mysql.jdbc.Driver");

//                      String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                        String url = "jdbc:mysql://192.168.0.134/cantegrill";
                        Connection con = DriverManager.getConnection(url, "admin","admin");

                    
                        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_READ_ONLY);

                        ResultSet rs= s.executeQuery(sql);

                        return rs;

                }
                catch(Exception ed)
                {

                }
            }
 
	            return null;
    }
    
    public CachedRowSet Function(String sql, String bd)
    {
            try
            {
                
                    Class.forName("com.mysql.jdbc.Driver");

 //                    String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                    String url = "jdbc:mysql://192.168.0.134/cantegrill";
                    Connection con = DriverManager.getConnection(url, "admin","admin");

                    
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs= s.executeQuery(sql);
 
                    CachedRowSet crs = new CachedRowSetImpl();
                    crs.populate(rs);
 
                    rs.close();
                    s.close();
                    con.close();
 
                    return crs;
 
            }
            catch(Exception e)
            {

            }
 
            return null;
    }
    
    public void StoreProcedure(String sql, String bd)
    {
 
            try
            {
                    Class.forName("com.mysql.jdbc.Driver");
 
 //                    String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                    String url = "jdbc:mysql://192.168.0.134/cantegrill";
                    Connection con = DriverManager.getConnection(url, "admin","admin");

                    
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);
             
                    s.execute(sql);
 
                    sql = sql.replace("'","#");
                    
//                    s.execute("insert into a_log (sqls, sistema, usuarios, bd) VALUES ('" + sql + "','" + sistema + "','" + usuario + "','" + bd + "')");
                    
                    s.close();
                    con.close();
 
	    }
	    catch(Exception e)
	    {


            }   
    }
    
    public void Todos(ArrayList c, String bd)
    {
 
            try
            {
                    Class.forName("com.mysql.jdbc.Driver");
 
 //                    String url = "jdbc:mysql://170.249.205.50/cantegri_eneclick";
                    String url = "jdbc:mysql://192.168.0.134/cantegrill";
                    Connection con = DriverManager.getConnection(url, "admin","admin");

                    
                    int i = 0;
                    while (c.size() > i)
                    {
                        if(i == 1558 )
                        {
                            i = i;
                        }
                    
                        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                   ResultSet.CONCUR_READ_ONLY);
                        String sql = c.get(i).toString();
                        
                        if (sql.equals("") == false)
                        {
                            try{s.execute(sql);}catch(Exception ex){//JOptionPane.showMessageDialog(null, ex.toString() + " " + sql
                            }
                            
                            if(sql.length() > 29)
                            {
/*                                if(usuario.equals("AUTOMATICO") == false && usuario.equals("GENERICO") == false)
                                {
                                    sql = sql.replace("'","#");
                                    s.execute("insert into a_log (sqls, sistema, usuarios, bd) VALUES ('" + sql + "','" + sistema + "','" + usuario + "','" + bd + "')");
                                }*/
                            }
                        } 
                        
                        s.close();
                        i++;
                    }                
                    
                    con.close();
 
	    }
	    catch(Exception e)
	    {
  
            }   
    }
    
}