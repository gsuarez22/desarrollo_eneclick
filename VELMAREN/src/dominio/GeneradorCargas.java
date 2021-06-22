/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JTable;

/**
 *
 * @author SistemasGaby
 */
public class GeneradorCargas 
{
    private char c = (char)34;
    public String terminal= "", tipo = "", escala = "", bls="", buque= "", viaje= "", eta = "";
   
    public void generarBls(JTable tbl)
    {
        int i = 0;
        while(tbl.getSelectedRows().length > i)
        {
            bls = " bl.numero_bl = '" + tbl.getModel().getValueAt(tbl.getSelectedRows()[i], 0).toString() + "' AND " + bls;
            i++;
        }
    }
    
    public boolean puedoUno(String mani, JTable tbl)
    {
   
        generarBls(tbl);
        
        boolean flag = true;
                
        if(escala.equals("") || tipo.equals("") || terminal.equals(""))
        {
            flag = false;
        }
        else
        {
            if(bls.length() > 10)
            {
                bls = bls.substring(0, bls.length() - 4);
                generarbllineqpttxt(mani, tbl);
                generarbllinetxt(mani, tbl);
                generarbltxt(mani,tbl);
                generareqpttxt(mani, tbl);
                generarmanifesttxt(mani, tbl);
            }
        }
        
        return flag;
        
    }
    
    
    public boolean puedo()
    {
        
        boolean flag = true;
                
        if(buque.equals("") || tipo.equals("") || terminal.equals("") || viaje.equals("") || eta.equals(""))
        {
            flag = false;
        }
        else
        {
            generarbltxt();
            generarbllineqpttxt();
            //NO LO GENERA
            generarbllinetxt(); 
            //NO LO GENERA
            generareqpttxt();
            generarmanifesttxt();
        }
        
        return flag;
        
    }
    
    
     private void generarbltxt(String mani, JTable tbl)
    {
        //  1         2        3               4                                          5           6       7      8    9   10   11  12  13 14 15 16 17 18 19 20 21       22 
        // 2999,"13023435311","1","WORLDWIDE LOGISTICS CO,,LTD,XIAMEN BRANCH","REPREMAR LOGISTICS","CNXMN","UYMVD","usd","2","CC","2","CC","","","","","","","","","","REPREMAR LOGISTICS"
       
            File unF = new File("c:\\velmaren-cargas\\");
            unF.mkdirs();

            FileWriter fichero = null;
            PrintWriter pw = null;
            try
            {
                fichero = new FileWriter("c:/velmaren-cargas/bl.txt");
                pw = new PrintWriter(fichero);

                BD unb = new BD();
                String url = "";

                url = "SELECT 2999,numero_bl,'1',cargador_bl,consignatario_bl,origencodigo_bl, destinocodigo_bl,'usd',2,formadepago_bl,2,formadepago_bl,'','','','','','','','','',notificador_bl FROM bridge_bls bl WHERE bl.buque_bl = '" + buque + "' AND bl.viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "' " + bls; 

                CachedRowSet lista = unb.Function(url);
                RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                while (lista.next())
                {
                    pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + ","  + c + lista.getString(6).replace("DOCAU", "DOSDQ") + c + "," + c + lista.getString(7).replace("DOCAU", "DOSDQ") + c + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + lista.getString(15) + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c + "," + c + lista.getString(18) + c + "," + c + lista.getString(19) + c + "," + c + lista.getString(20) + c + "," + c + lista.getString(21) + c + "," + c + lista.getString(22) + c) ;
                }

            }catch (Exception e) {e.printStackTrace();} 
            finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
            
        
        
    }   
    
    private void generareqpttxt(String mani, JTable tbl)
    {
        //   1        2         3     4   5     6    7        8
        // 2999,"MORU5812935","42R0","5","95","kgm",8088,"MOL564108M"
        
        File unF = new File("c:\\opus-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/opus-cargas/eqpt.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999, c.numero_con, t.aduana_tipo, IF(precinto_con='','4','5'), '95', 'kgm', c.peso_con, c.precinto_con FROM bridge_contenedores c, bridge_tipocontenedores t, bridge_bls bl WHERE bl.numero_bl = c.numero_bl AND c.tipoequipoOPUS_con = t.opus_tipo AND bl.escala_bl = '" + escala + "'  AND " + bls; 
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c) ;
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
        
    private void generarbllinetxt(String mani, JTable tbl)
    {
        //  1        2        3   4   5    6      7      8            9  10   11   12     13   14     15     16      17 
        //2999,"13023435311","1",385,CTN,"kgm",3588.2,"CASUAL SHOES ","","","n/s","n/s","n/s","n/s","1647","6404","49.95"
        
        File unF = new File("c:\\opus-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/opus-cargas/blline.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999,bl.numero_bl,'1',cantidaddebultos_bl, aduana_bul,'kgm',pesototal_bl,decripcioncarga_bl,'','','n/s','n/s','n/s','n/s',1644,ncm_bl,m3_bl  FROM  bridge_bls bl, bridge_tipobultos b WHERE bl.tipobultos_bl= b.opus_bul AND bl.escala_bl = '" + escala + "'  AND " + bls; 
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                if(terminal.equals("TCP"))
                {
                    pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + lista.getString(4) + "," + lista.getString(5) + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + "1644" + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c);
                }
                else
                {
                    pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + lista.getString(4) + "," + lista.getString(5) + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + "1647" + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c);
                }
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
            
    private void generarbllineqpttxt(String mani, JTable tbl)
    {
        //  1       2        3      4         5
        //2999,"13023435311",1,"MORU5812935",385
        
        File unF = new File("c:\\opus-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/opus-cargas/bllineqp.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999,bl.numero_bl,'1',numero_con, e.cantidadbultos_con FROM bridge_bls bl, bridge_contenedores e WHERE bl.numero_bl = e.numero_bl AND bl.escala_bl = '" + escala + "'  AND " + bls; 
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + lista.getString(3) + "," + c + lista.getString(4) + c + "," + lista.getString(5));
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
        
    }   
                
    private void generarmanifesttxt(String mani, JTable tbl)
    {
        // 1    2      3           4     5     6       7
        //2999,13,"MAERSK SHAMS","2999","s","jpyok","uymvd"
        
        File unF = new File("c:\\opus-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/opus-cargas/manifest.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            if(tipo.equals("EXPO"))
            {
                url = "SELECT distinct(buque_bl) as buque, 2999, '12', '2999', 's', 'uymvd', 'jpyok' FROM bridge_bls WHERE escala_bl = '" + escala + "'";
            }
            else
            {
                url = "SELECT distinct(buque_bl) as buque, 2999, '13', '2999', 's', 'jpyok', 'uymvd' FROM bridge_bls WHERE escala_bl = '" + escala + "'"; 
            }
            
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(2) + "," + lista.getString(3) + "," + c + lista.getString(1) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + "," + c + lista.getString(6) + c + "," + c + lista.getString(7) + c);
            }
                        
        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
    
    
    
    
    
    
    
    
    
    
    private void generarbltxt()
    {
        //  1         2        3               4                                          5           6       7      8    9   10   11  12  13 14 15 16 17 18 19 20 21       22 
        // 2999,"13023435311","1","WORLDWIDE LOGISTICS CO,,LTD,XIAMEN BRANCH","REPREMAR LOGISTICS","CNXMN","UYMVD","usd","2","CC","2","CC","","","","","","","","","","REPREMAR LOGISTICS"
  //SELECT 2999,numero_bl,'1',cargador_bl,consignatario_bl,origencodigo_bl, destinocodigo_bl,'usd',2,formadepago_bl,2,formadepago_bl,'','','','','','','','','',notificador_bl FROM bridge_bls WHERE buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'"
        File unF = new File("c:\\velmaren-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/velmaren-cargas/bl.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999,numero_bl,'1','MSC URUGUAY S.A.','MSC URUGUAY S.A.',origencodigo_bl, destinocodigo_bl,'usd',2,'',2,'','','','','','','','','','','' FROM bridge_bls WHERE buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'"; 
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + ","  + c + lista.getString(6).replace("DOCAU", "DOSDQ") + c + "," + c + lista.getString(7).replace("DOCAU", "DOSDQ") + c + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + lista.getString(15) + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c + "," + c + lista.getString(18) + c + "," + c + lista.getString(19) + c + "," + c + lista.getString(20) + c + "," + c + lista.getString(21) + c + "," + c + lista.getString(22) + c) ;
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
    
    private void generareqpttxt()
    {
        //   1        2         3     4   5     6    7        8
        // 2999,"MORU5812935","42R0","5","95","kgm",8088,"MOL564108M"
        
        File unF = new File("c:\\velmaren-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/velmaren-cargas/eqpt.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999, c.numero_con, t.aduana_tipo, IF(precinto_con='','4','5'), '95', 'kgm', c.peso_con, c.precinto_con FROM bridge_contenedores c, bridge_tipocontenedores t, bridge_bls bl WHERE bl.numero_bl = c.numero_bl AND c.tipoequipoOPUS_con = t.opus_tipo AND bl.buque_bl = '" + buque + "' and bl.viaje_bl = '" + viaje + "' AND bl.eta_bl = '" + eta + "'";  
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c) ;
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
        
    private void generarbllinetxt()
    {
        //  1        2        3   4   5    6      7      8            9  10   11   12     13   14     15     16      17 
        //2999,"13023435311","1",385,CTN,"kgm",3588.2,"CASUAL SHOES ","","","n/s","n/s","n/s","n/s","1647","6404","49.95"
// SELECT 2999,bl.numero_bl,'1',cantidaddebultos_bl, aduana_bul,'kgm',pesototal_bl,decripcioncarga_bl,'','','n/s','n/s','n/s','n/s',1644,ncm_bl,m3_bl  
        
        File unF = new File("c:\\velmaren-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/velmaren-cargas/blline.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999,bl.numero_bl,'1',cantidaddebultos_bl, aduana_bul,'kgm',pesototal_bl,'','','','n/s','n/s','n/s','n/s',1644,'',''  FROM  bridge_bls bl, bridge_tipobultos b WHERE bl.tipobultos_bl= b.opus_bul AND bl.buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'"; ; 
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                 if(terminal.equals("TCP"))
                {
                    pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + lista.getString(4) + "," + lista.getString(5) + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + "1644" + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c);
                }
                else
                {
                    pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + c + lista.getString(3) + c + "," + lista.getString(4) + "," + lista.getString(5) + ","  + c + lista.getString(6) + c + "," + lista.getString(7) + "," + c + lista.getString(8) + c + "," + c + lista.getString(9) + c + "," + c + lista.getString(10) + c + "," + c + lista.getString(11) + c + "," + c + lista.getString(12) + c + "," + c + lista.getString(13) + c + "," + c + lista.getString(14) + c + "," + c + "1647" + c + "," + c + lista.getString(16) + c + "," + c + lista.getString(17) + c);
                }
                
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
            
    private void generarbllineqpttxt()
    {
        //  1       2        3      4         5
        //2999,"13023435311",1,"MORU5812935",385
        
        File unF = new File("c:\\velmaren-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/velmaren-cargas/bllineqp.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            
            url = "SELECT 2999,bl.numero_bl,'1',numero_con, e.cantidadbultos_con FROM bridge_bls bl, bridge_contenedores e WHERE bl.numero_bl = e.numero_bl AND bl.buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'";  
                        
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(1) + "," + c + lista.getString(2) + c + "," + lista.getString(3) + "," + c + lista.getString(4) + c + "," + lista.getString(5));
            }

        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
        
    }   
                
    private void generarmanifesttxt()
    {
        // 1    2      3           4     5     6       7
        //2999,13,"MAERSK SHAMS","2999","s","jpyok","uymvd"
        
        File unF = new File("c:\\velmaren-cargas\\");
        unF.mkdirs();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/velmaren-cargas/manifest.txt");
            pw = new PrintWriter(fichero);

            BD unb = new BD();
            String url = "";
            if(tipo.equals("EXPO"))
            {
                url = "SELECT distinct(buque_bl) as buque, 2999, '12', '2999', 's', 'uymvd', 'jpyok' FROM bridge_bls WHERE  buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'"; 
            }
            else
            {
                url = "SELECT distinct(buque_bl) as buque, 2999, '13', '2999', 's', 'jpyok', 'uymvd' FROM bridge_bls WHERE  buque_bl = '" + buque + "' and viaje_bl = '" + viaje + "' AND eta_bl = '" + eta + "'";  
            }
            
            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                pw.println(lista.getString(2) + "," + lista.getString(3) + "," + c + lista.getString(1) + c + "," + c + lista.getString(4) + c + "," + c + lista.getString(5) + c + "," + c + lista.getString(6) + c + "," + c + lista.getString(7) + c);
            }
                        
        }catch (Exception e) {e.printStackTrace();} 
        finally {try {if (null != fichero)fichero.close();}catch (Exception e2){e2.printStackTrace();}}
    }   
                    
}
