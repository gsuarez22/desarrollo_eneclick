/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author SistemasGaby
 */
public class bl 
{

    //ATRIBUTOS
    public String discharge1="", discharge="", SHPRCD="", servicio="",decla = "",eta="",tipobulto ="",ppt ="", cct="", origencode ="", destinocode ="", escala= "", formadepago = "", numerobl = "", pol = "", pod = "", origen = "", destino = "", shipper="", consignee="",notify="",cantbultos="",kilaje="",ncm="",mercaderia="",buque="",viaje="",m3= "", temperatura = "", tipo = "MSC", imo = "", unn = "", pesotot = "0";
    public ArrayList containers = new ArrayList();
    public ArrayList puertodescarga;
    
    public bl()
    {
        
/*        try
        {
            BD unb = new BD();
            String url = "SELECT puerto FROM bridge_dischargeport";

            CachedRowSet lista = unb.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

            puertodescarga = new ArrayList();

            while (lista.next())
            {
                puertodescarga.add(lista.getString(1));
            }
        }
        catch(Exception ex)
        {
        
        }*/
        
    }
    
    public ArrayList leerExcelT(String ruta, String usu) throws FileNotFoundException, IOException
    {
               /* ArrayList una = new ArrayList();
             
          	InputStream ExcelFileToRead = new FileInputStream(ruta);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

                int i = 1;
                try
                {
                    boolean fin = false;
                    while (i < 1000 && fin == false)
                    {
                        bl b = new bl();
                        container c = new container();
                        row = sheet.getRow(i);
                        cell = row.getCell((short) 2);
                        c.vaciolleno = cell.getStringCellValue();

                        if (c.vaciolleno.equals(" "))
                        {
                            fin = true;
                        }
                        else
                        {
                            cell = row.getCell((short) 1);
                            try{b.numerobl = cell.getStringCellValue();}catch(Exception ex){}
                            
                            cell = row.getCell((short) 14);
                            try{b.escala = cell.getStringCellValue();}catch(Exception ex){}

                            cell = row.getCell((short) 7);
                            try{b.shipper = cell.getStringCellValue();}catch(Exception ex){}

                            cell = row.getCell((short) 10);
                            try{b.consignee = cell.getStringCellValue();}catch(Exception ex){}
                            
                            cell = row.getCell((short) 65);
                            try{b.notify = cell.getStringCellValue();}catch(Exception ex){}
                            
                            cell = row.getCell((short) 15);
                            try{b.buque  = cell.getStringCellValue();}catch(Exception ex){}

                            cell = row.getCell((short) 20);
                            try{b.origencode = cell.getStringCellValue();}catch(Exception ex){}

                            cell = row.getCell((short) 22);
                            try{b.destinocode = cell.getStringCellValue();}catch(Exception ex){}

                            cell = row.getCell((short) 25);
                            try{b.kilaje = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                            cell = row.getCell((short) 27);
                            try{b.cantbultos = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}

                            cell = row.getCell((short) 28);
                            try{b.tipobulto = cell.getStringCellValue();}catch(Exception ex){}
                            
                            cell = row.getCell((short) 30);
                            try{b.mercaderia = cell.getStringCellValue();}catch(Exception ex){}

                            String finale = notify;
        
                            if(notify.contains("SAME AS CONSIGNEE"))
                            {
                                finale = consignee;
                            }
                            
                            cell = row.getCell((short) 14);
                            try
                            {
                                b.viaje = cell.getStringCellValue();
                                b.viaje = b.viaje.substring(b.viaje.length() - 5, b.viaje.length());
                            }catch(Exception ex){}

                            corroborarPuertoDestino();
                            
                            String sql = "INSERT INTO bridge_bls (discharge, SHPRCD, servicio, clienteFinal,eta_bl,tipobultos_bl,origencodigo_bl,destinocodigo_bl,m3_bl,escala_bl,numero_bl,buque_bl,viaje_bl,consignatario_bl,cargador_bl,notificador_bl,origen_bl,destino_bl,formadepago_bl,cantidaddebultos_bl,decripcioncarga_bl,ncm_bl,pesototal_bl) VALUES (";
        sql += "'" + discharge + "','" + SHPRCD + "','" + b.servicio + "','" + finale + "','" + b.eta + "','" + b.tipobulto + "','" + b.origencode + "','" + b.destinocode + "','" + b.m3 + "','" + b.escala + "','" + b.numerobl + "','" + b.buque + "','" + b.viaje + "','" + b.consignee + "','" + b.shipper + "','" + b.notify + "','" + b.origen + "','" + b.destino + "','" + b.formadepago + "','" + b.cantbultos + "','" + b.mercaderia + "','" + b.ncm + "','" + b.kilaje + "')";
       
                            c = new container();
                            
                            cell = row.getCell((short) 17);
                            una.add (sql);
                            
                            try
                            {                                
                                String ca [] = cell.getStringCellValue().split(",");
                            
                                int x = 0;
                                while(ca.length > x)                            
                                {
                                    c.marca = ca[x];
                                
                                    cell = row.getCell((short) 18);
                                    try{c.tipo = cell.getStringCellValue();}catch(Exception ex){}
                                    
                                    try
                                    {
                                        double v = Double.parseDouble(b.kilaje) / ca.length; 
                                        c.peso = String.valueOf(v);
                                    }catch(Exception ex){}
                                    
                                    try
                                    {
                                        double v = Double.parseDouble(b.cantbultos) / ca.length; 
                                        c.cantidadbultos = String.valueOf(v);
                                    }catch(Exception ex){}

                                    c.vaciolleno="f";
                                    
                                    
                                    sql = "INSERT INTO bridge_contenedores (temp_con,cantidadbultos_con,numero_bl,numero_con,tipoequipoOPUS_con,precinto_con,vaciolleno_con,peso_con,ncm) VALUES (";
                                    sql += "'" + c.temp + "','" + c.cantidadbultos + "','" + b.numerobl + "','" + c.marca + "','" + c.tipo + "','" + c.seal + "','" + c.vaciolleno + "','" + c.peso + "','" + c.ncm + "')";
     
                                    una.add(sql);
                                    
                                    x++;
                                }
                            }
                            catch(Exception ex)
                            {
                            }
                            
                            
                        }
                        i++;
                    }
                   
                }
                catch(Exception ex)
                {
                }
                 BD unb = new BD();
                    unb.sistema = "BRIDGE";
                    unb.usuario = usu;
                    unb.Todos(una, "one");
        return una;*/ 
        return null;
    }
    
    //METODO
    public BufferedReader cargarBL (BufferedReader br, String vbuque, String vviaje, String vescalacode, String usu, String vEta, String vServicio) throws IOException
    {
        
       /* String error = ""; 
        bl unb = new bl();
        boolean seguir = true;
        
        String linea = "";
        
        boolean entre = false;
        
        while(seguir)
        {
            if(linea == null){seguir = false;}
            if((linea=br.readLine())!=null)
            {
                unb.buque = vbuque;
                unb.viaje = vviaje;
                unb.eta = vEta;
                unb.escala = vescalacode;
                unb.servicio = vServicio;
                String[] lin = linea.split(":");
                try{if(lin[0].equals("BLNBR")){unb.numerobl = lin[1];}}catch(Exception ex){unb.numerobl = "";}

                //PUERTOS
                try{if(lin[0].equals("POL_FULLNAME")){unb.pol = lin[1];}}catch(Exception ex){unb.pol = "";}
                try{if(lin[0].equals("POD_FULLNAME")){unb.pod = lin[1];}}catch(Exception ex){unb.pod = "";}
                try{if(lin[0].equals("POR_FULLNAME")){unb.origen = lin[1];}}catch(Exception ex){unb.origen = "";}
                try{if(lin[0].equals("DEL_FULLNAME")){unb.destino = lin[1];}}catch(Exception ex){unb.destino = "";}
                try{if(lin[0].equals("BLPOR")){unb.origencode = lin[1];}}catch(Exception ex){unb.origencode = "";}
                try{if(lin[0].equals("BLDEL")){unb.destinocode = lin[1];}}catch(Exception ex){unb.destinocode = "";}
                
                //EMPRESAS
                try{if(lin[0].equals("SHPRCD")){unb.SHPRCD = lin[1];}}catch(Exception ex){unb.SHPRCD = "";}

                try{if(lin[0].equals("SHPR1")){unb.shipper = lin[1];}}catch(Exception ex){unb.shipper = "";}
                try{if(lin[0].equals("CNEE1")){unb.consignee = lin[1];}}catch(Exception ex){unb.consignee = "";}
                try{if(lin[0].equals("NTFY1")){unb.notify = lin[1];}}catch(Exception ex){unb.notify = "";}
                try{if(lin[0].equals("PPD_PAYER")){unb.decla = lin[1];}}catch(Exception ex){unb.decla = "";}
                try{if(lin[0].equals("BLPOD1")){
                    unb.discharge = lin[1];}}catch(Exception ex){unb.discharge = "";}
                try{if(lin[0].equals("BLPOL1")){
                    unb.discharge1 = lin[1];}}catch(Exception ex){unb.discharge1 = "";}
                
                //CARGA
                try{if(lin[0].equals("BLPKG")){unb.cantbultos = lin[1];}}catch(Exception ex){unb.cantbultos = "";}
                try{if(lin[0].equals("BLWGT")){unb.kilaje = lin[1];}}catch(Exception ex){unb.kilaje = "";}
                try{if(lin[0].equals("NTFY1")){unb.notify = lin[1];}}catch(Exception ex){unb.notify = "";}
                try{if(lin[0].equals("CMDESC")){unb.mercaderia = lin[1];}}catch(Exception ex){unb.mercaderia = "";}
                try{if(lin[0].equals("BLMEA")){unb.m3 = lin[1];}}catch(Exception ex){unb.m3 = "";}
                try{if(lin[0].equals("BLPKGU")){unb.tipobulto = lin[1];}}catch(Exception ex){unb.tipobulto = "";}
                try{if(lin[0].equals("COMMODITY")){unb.ncm = lin[1];}}catch(Exception ex){unb.ncm = "";}
                
                try{if(lin[0].equals("PPD")){unb.ppt = lin[1];}}catch(Exception ex){unb.ppt = "";}
                try{if(lin[0].equals("CCT")){unb.cct = lin[1];}}catch(Exception ex){unb.cct = "";}
             
                
                if(lin[0].equals("{CHARGE"))
                {
                    charge unc = new charge();
                    br = unc.cargarCharge(br, unb);
                                    
                    unc.cargar(usu, unb.numerobl);                    
                    
                }
                
                if(unb.numerobl.equals("HKGU94097400"))
                {
                    boolean flag = true;
                }
                
                if(lin[0].equals("}BL_INFO"))
                {
                    if(entre == false)
                    {
                        unb.cargar(usu);
                        unb = new bl();
                    }                   
                    entre = false;
                }
                if(lin[0].equals("{CNTR_INFO"))
                {
                    container uncont = new container();
                    br = uncont.cargarContainer(br, unb);
                
                    entre = true;
                    
                    seguir = false;
                    if(unb.cargar(usu))
                    {
                        if(unb.cargarContainers(usu) != false)
                        {
                            error += "\n error containers bl: " + unb.numerobl;
                        }
                    }
                    else
                    {
                        error += "\n error en bl: " + unb.numerobl;
                    }
                    unb = new bl();
                }
            }
        }
        
        return br;*/
        return null;
        
    }
    
    public void corroborarPuertoDestino()
    {
       /*int i = 0;
        
        while(i<puertodescarga.size())
        {
            String valor = puertodescarga.get(i).toString(); 
            if(discharge1.equals(valor))
            {
                discharge = discharge1;
            }
            i++;
        }*/
        
    }

    
    
    private boolean cargar(String usu) 
    {
/*        boolean flag = true;
        ONE.BD unb = new ONE.BD();
        
        if(this.cct.equals("0")){this.formadepago = "PP";}else{this.formadepago = "CC";}
        if(this.ppt.equals("0")){this.formadepago = "CC";}else{this.formadepago = "PP";}
        
        this.shipper = this.shipper.replace("'","");
        this.consignee = this.consignee.replace("'","");
        this.notify = this.notify.replace("'","");
        
        char c = (char)34;        
        this.mercaderia = this.mercaderia.replace(String.valueOf(c), "*");
        this.mercaderia = this.mercaderia.replace(String.valueOf(c), " ");
        this.mercaderia = this.mercaderia.replace("'", " ");
        
        if (this.mercaderia.length() > 100)
        {
            
            this.mercaderia = this.mercaderia.substring(0,100);
            
        }
        
        String finale = notify;
        
        if(notify.contains("SAME AS CONSIGNEE"))
        {
            finale = consignee;
        }
        
        corroborarPuertoDestino();
        
        String sql = "INSERT INTO bridge_bls (discharge,SHPRCD,servicio, decla,clienteFinal,eta_bl,tipobultos_bl,origencodigo_bl,destinocodigo_bl,m3_bl,escala_bl,numero_bl,buque_bl,viaje_bl,consignatario_bl,cargador_bl,notificador_bl,origen_bl,destino_bl,formadepago_bl,cantidaddebultos_bl,decripcioncarga_bl,ncm_bl,pesototal_bl) VALUES (";
        sql += "'" + discharge + "','" + SHPRCD + "','" + this.servicio + "','" + decla + "','" + finale + "','" + this.eta + "','" + this.tipobulto + "','" + this.origencode + "','" + this.destinocode + "','" + this.m3 + "','" + this.escala + "','" + this.numerobl + "','" + this.buque + "','" + this.viaje + "','" + this.consignee + "','" + this.shipper + "','" + this.notify + "','" + this.origen + "','" + this.destino + "','" + this.formadepago + "','" + this.cantbultos + "','" + this.mercaderia + "','" + this.ncm + "','" + this.kilaje + "')";
                
        try 
        {
            unb.sistema = "BRIDGE";
            unb.usuario = usu;
            unb.StoreProcedure(sql, "one");
        }
        catch(Exception ex)
        {
            flag = false;
        }
        return flag;*/
        return false;
    }
    
    private boolean cargarContainers(String usu) 
    {
        /*boolean flag = true;
        ONE.BD unb = new ONE.BD();
        
        for (Object container : this.containers) {
            container unc = new container();
            unc = (container) container;
            flag = unc.cargar(this.numerobl, usu);
        }
        
        return flag;*/
        return false;
    }

    public void borrarTodo(String idEscala, String usu) 
    {
       /* String sql = "";
        BD unb = new BD();
        unb.sistema = "BRIDGE";
        unb.usuario = usu;
        
        sql = "DELETE c FROM bridge_contenedores c, bridge_bls b WHERE b.escala_bl = '" + idEscala + "' AND b.numero_bl = c.numero_bl";
        unb.StoreProcedure(sql, "one");
        sql = "DELETE t FROM bridge_bls b, bridge_charge t WHERE b.escala_bl = '" + idEscala + "' AND t.numero_bl = b.numero_bl";
        unb.StoreProcedure(sql, "one");
        
        sql = "delete from bridge_imo where id_escala = '" + idEscala + "'";
        unb.StoreProcedure(sql, "one");
    
        sql = "delete from bridge_bls where escala_bl = '" + idEscala + "'";
        unb.StoreProcedure(sql, "one");*/
        
    }

    public void borrarTodoPorBuque(String buque, String viaje) 
    {
       /* String sql = "DELETE c FROM bridge_contenedores c, bridge_bls b WHERE b.buque_bl = '" + buque + "' AND b.viaje_bl = '" + viaje + "' AND b.numero_bl = c.numero_bl";
        BD unb = new BD();
        unb.sistema = "BRIDGE";
        unb.usuario = "AUTOMATICO";
        
        unb.StoreProcedure(sql, "one");
    
        sql = "DELETE i FROM bridge_imo i, bridge_bls b WHERE b.buque_bl = '" + buque + "' AND b.viaje_bl = '" + viaje + "' AND b.numero_bl = i.id_escala";
        unb.StoreProcedure(sql, "one");
                
        sql = "delete b from bridge_bls b where b.buque_bl = '" + buque + "' AND b.viaje_bl = '" + viaje + "'";
        unb.StoreProcedure(sql, "one");*/
        
    }
    private void actualizardestinos() {
       /* try
        {        
            BD unb = new BD();
            unb.sistema = "BRIDGE";
            unb.usuario = "automatico";
            unb.StoreProcedure("update discharge = '" + discharge + "' from bridge_bl where numero_bl = '" + numerobl + "'", "one");
        }
        catch(Exception ex)
        {
        
        }*/
    }

    public void agregar(String usu) 
    {
      /*  BD unb = new BD();
                
        try 
        {
            unb.sistema = "BRIDGE";
            unb.usuario = usu;
            
            String sql = "INSERT INTO bridge_bls (destino_bl,origen_bl,tipobultos_bl,numero_bl,escala_bl,consignatario_bl,cargador_bl,eta_bl,origencodigo_bl,destinocodigo_bl,cantidaddebultos_bl,pesototal_bl,decripcioncarga_bl,buque_bl,viaje_bl, temperatura) VALUES (";
            sql += "'" + this.destino + "','" + this.origen + "','" + this.tipo + "','" + this.numerobl + "','" + this.escala + "','" + this.consignee + "','" + this.shipper + "','" + this.eta + "','" + this.pol + "','" + this.pod + "','" + this.cantbultos + "','" + this.pesotot + "','" + this.mercaderia + "','" + this.buque + "','" + this.viaje + "','" + this.temperatura + "')";
            unb.StoreProcedure(sql, "one");
        }
        catch(Exception ex)
        {

        }*/
    }
    
    
}
