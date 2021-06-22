/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



/**
 *
 * @author SistemasGaby
 */
public class container 
{
    
    //ATRIBUTOS
    public String marca = "", tipo = "", peso = "",seal = "",vaciolleno = "",ncm="",destino="",servicio="",cantidadbultos="",temp = "",bl="";
    public double cantidades = 0;
    public ArrayList imo = new ArrayList();
    /*
    public String cargarDestino(String c)
    {
        String flag = "";
        
        c = c.toUpperCase();
        if(c.equals("MONTEVIDEO")){flag = "UYMVD";}
        if(c.equals("BUENOS AIRES")){flag = "ARBUE";}
        if(c.equals("SANTOS")){flag = "BRSSZ";}
        if(c.equals("PUSAN")){flag = "KRPUS";}
        if(c.equals("SINGAPORE")){flag = "SGSIN";}
        if(c.equals("HONG KONG")){flag = "HKHKG";}
        if(c.equals("YANTIAN")){flag = "CNYNT";}
        if(c.equals("SHANGAI")){flag = "CNSHA";}
        if(c.equals("QINDAO")){flag = "CNTAO";}
        if(c.equals("KELANG")){flag = "MYPKG";}
        if(c.equals("NINGBO")){flag = "CNNGB";}
        if(c.equals("CHIWAN")){flag = "CNCWN";}
        if(c.equals("PARANAGUA")){flag = "BRPNG";}
        if(c.equals("CARTAGENA")){flag = "COCTG";}
        if(c.equals("HOUSTON")){flag = "USHOU";}
        if(c.equals("VERACRUZ")){flag = "MXVER";}
        if(c.equals("COEGA")){flag = "ZAZBA";}
        if(c.equals("SHANGHAI")){flag = "CNSHA";}
                
        return flag;
    }
    
    public ArrayList leerExcel(String ruta, String usu)
    {
            ArrayList una = new ArrayList();
            try
            {
          	InputStream ExcelFileToRead = new FileInputStream(ruta);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
                SimpleDateFormat unF = new SimpleDateFormat("dd/MM/yyyy");
		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

                String buque = "", viaje = "", servicio = "", eta = "", codigobuque = "";

                row = sheet.getRow(1);
                cell = row.getCell((short) 6);
                buque = cell.getStringCellValue();
                String [] val = buque.split("v");
                try{buque = val[0];
                viaje = val[1]; viaje = viaje.replace(".", ""); viaje = viaje.replace(" ", "");}catch(Exception ex){JOptionPane.showMessageDialog(null, "El buque debe estar separado del viaje por una v en la celda G2");}
                cell = row.getCell((short) 8);
                codigobuque = cell.getStringCellValue();

                row = sheet.getRow(2);
                cell = row.getCell((short) 6);
                try{ eta = unF.format(cell.getDateCellValue()); } catch(Exception ex){}
                cell = row.getCell((short) 8);
                servicio = cell.getStringCellValue();
                
                if(servicio.equals("") || codigobuque.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Faltan los datos de servicio I2 o escala I3. Sin ellos no se puede procesar la informacion");
                }
                else
                {
                    int i = 8;
                    bl b = new bl();    
                    boolean unavez = true;
                    boolean fin = false;
                    String ultimobl = "";
                    while (i < 1000 && fin == false)
                    {
                            row = sheet.getRow(i);
                            try{cell = row.getCell((short) 1); b.numerobl = cell.getStringCellValue(); } catch(Exception ex){}

                            if(b.numerobl.equals("") == false)
                            {
                                b.numerobl = b.numerobl.replace(" ", "");
                                b.numerobl = b.numerobl + "I";
                                ultimobl = b.numerobl;
                                try{cell = row.getCell((short) 6); b.shipper = cell.getStringCellValue(); } catch(Exception ex){}
                                try{cell = row.getCell((short) 7); b.consignee = cell.getStringCellValue(); } catch(Exception ex){}
                                try{cell = row.getCell((short) 8); b.origen = cell.getStringCellValue(); } catch(Exception ex){}
                                try{cell = row.getCell((short) 9); b.destino = cell.getStringCellValue(); } catch(Exception ex){}

                                b.pod = cargarDestino(b.destino);
                                b.pol = cargarDestino(b.origen);
                                
                                //TIPO
                                String tipo = "";
                                double bul = 0;
                                try{ cell = row.getCell((short) 11); bul = cell.getNumericCellValue(); if(bul > 0) {tipo = "D2"; b.cantbultos = String.valueOf(bul);} }catch(Exception ex){bul = 0;}
                                try{ cell = row.getCell((short) 12); bul = cell.getNumericCellValue(); if(bul > 0) {tipo = "D4"; b.cantbultos = String.valueOf(bul);} } catch(Exception ex){bul = 0;}
                                try{ cell = row.getCell((short) 13); bul = cell.getNumericCellValue(); if(bul > 0) {tipo = "D5"; b.cantbultos = String.valueOf(bul);} } catch(Exception ex){bul = 0;}
                                try{ cell = row.getCell((short) 14); bul = cell.getNumericCellValue(); if(bul > 0) {tipo = "R4"; b.cantbultos = String.valueOf(bul);} } catch(Exception ex){bul = 0;}
                                b.tipo = tipo;

                                try{cell = row.getCell((short) 18); b.pesotot = String.valueOf(cell.getNumericCellValue()); } catch(Exception ex){}
                                try{cell = row.getCell((short) 19); b.mercaderia = cell.getRichStringCellValue().toString(); } catch(Exception ex){}

                                b.buque = buque;
                                b.viaje = viaje;
                                b.eta = eta;
                                b.escala = codigobuque + "IBR";
                                b.servicio = servicio;
                                
                                if(unavez)
                                {
                                    unavez = false;
                                    b.borrarTodoPorBuque(buque, viaje);
                                }
                                
                                b.agregar(usu);
                            }

                            container c = new container();
                            //try{cell = row.getCell((short) 1); b.numerobl = cell.getStringCellValue(); } catch(Exception ex){}
                            c.bl = b.numerobl;
                            try{cell = row.getCell((short) 4); c.marca = cell.getStringCellValue(); } catch(Exception ex){}
                            c.tipo = b.tipo;
                            try { int pesoInd = Integer.parseInt(b.pesotot) / Integer.parseInt(b.cantbultos);  c.peso = String.valueOf(pesoInd); } catch(Exception ex) {}
                            try{cell = row.getCell((short) 22); c.temp = String.valueOf(cell.getNumericCellValue()); } catch(Exception ex){}

                            if (c.marca.equals("") == false)
                            {
                                if(ultimobl.equals("") == false && ultimobl.equals(" ") == false)
                                {
                                    
                                    c.marca = c.marca.replace("/","");
                                    c.marca = c.marca.replace("-","");
                                    c.marca = c.marca.replace(" ","");
                                    imo uni = new imo();
                                    try{cell = row.getCell((short) 21); uni.un = cell.getStringCellValue(); } catch(Exception ex){}
                                    try{cell = row.getCell((short) 20); uni.imo = cell.getStringCellValue(); } catch(Exception ex){}

                                    c.cargar(ultimobl,"AUTOMATICO");
                                    if(uni.imo.equals("") == false)
                                    {
                                        uni.marca = c.marca;
                                        uni.numerobl = b.numerobl;
                                        uni.guardar();
                                    }
                                }
                            }

                            i++;
                        }
               
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "No se pudo procesar el archivo");
            }
            return una;
    }

    public ArrayList leerSQL(String escala) 
    {
        ArrayList una = new ArrayList();
        
        BD unB = new BD();
               
        try
        {
            CachedRowSet lista = unB.Function("SELECT b.servicio, b.cantidaddebultos_bl, b.tipobultos_bl, b.destinocodigo_bl, b.pesototal_bl, b.numero_bl, b.decripcioncarga_bl FROM bridge_bls b WHERE b.escala_bl = '" + escala + "' AND b.origen_bl = 'MONTEVIDEO'");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            this.imo = new ArrayList();
                
            while (lista.next())
            {
                boolean fin = false;
                container c = new container();
            
                c.servicio = lista.getString(1);
                c.cantidades = Double.parseDouble(lista.getString(2));
                c.tipo = lista.getString(3);
                c.destino = lista.getString(4);
                double tot = 0;
                try{tot = Double.parseDouble(lista.getString(5));}catch(Exception ex){}
                c.peso = String.valueOf(tot);
                c.bl = lista.getString(6);
                c.vaciolleno = lista.getString(7);
                c.vaciolleno = c.vaciolleno.toUpperCase();
                if (c.vaciolleno.equals("MTY")){c.vaciolleno = "m";}else{c.vaciolleno = "f";}
                una.add (c);
            }
        }
        catch(Exception ex)
        {
        }
                
        return una;
    }
    
    private void cargarCeldasCalculos(HSSFCell celda, HSSFRow fila)
    {
        celda = fila.getCell((short) 2);
        String strFormula= "+C8+C13+C18+C23+C28+C33+C43+C48+C53+C58+C63+C38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
                
        celda = fila.getCell((short) 3);
        strFormula= "+D8+D13+D18+D23+D28+D33+D43+D48+D53+D58+D63+D38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
            
        celda = fila.getCell((short) 4);
        strFormula= "+E8+E13+E18+E23+E28+E33+E43+E48+E53+E58+E63+E38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
                
        celda = fila.getCell((short) 5);
        strFormula= "+F8+F13+F18+F23+F28+F33+F43+F48+F53+F58+F63+F38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
                
        celda = fila.getCell((short) 6);
        strFormula= "+G8+G13+G18+G23+G28+G33+G43+G48+G53+G58+G63+G38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 8);
        strFormula= "+I8+I13+I18+I23+I28+I33+I43+I48+I53+I58+I63+I38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 9);
        strFormula= "+J8+J13+J18+J23+J28+J33+J43+J48+J53+J58+J63+J38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 10);
        strFormula= "+K8+K13+K18+K23+K28+K33+K43+K48+K53+K58+K63+K38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);

        celda = fila.getCell((short) 12);
        strFormula= "+M8+M13+M18+M23+M28+M33+M43+M48+M53+M58+M63+M38";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 13);
        strFormula= "+C68+D68+E68+E68+F68+F68+G68+G68+I68+J68+J68+K68+K68";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
    }
    
    private void cargarCeldasFormulas(HSSFCell celda, HSSFRow fila, int desde, int hasta)
    {
        celda = fila.getCell((short) 2);
        String strFormula= "SUM(C" + desde + ":C" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 3);
        strFormula= "SUM(D" + desde + ":D" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);

        celda = fila.getCell((short) 4);
        strFormula= "SUM(E" + desde + ":E" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);        
        
        celda = fila.getCell((short) 5);
        strFormula= "SUM(F" + desde + ":F" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);

        celda = fila.getCell((short) 6);
        strFormula= "SUM(G" + desde + ":G" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 8);
        strFormula= "SUM(I" + desde + ":I" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);

        celda = fila.getCell((short) 9);
        strFormula= "SUM(J" + desde + ":J" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
        
        celda = fila.getCell((short) 10);
        strFormula= "SUM(K" + desde + ":K" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);

        celda = fila.getCell((short) 12);
        strFormula= "SUM(M" + desde + ":M" + hasta + ")";
        celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
        celda.setCellFormula(strFormula);
    }
    
    private void cargarPuerto (HSSFCell celda, HSSFRow fila,HSSFSheet hoja, String puerto, ArrayList arch, int fil1, int fil2, int fil3)
    {
                double pesotot = 0;
                
                fila = hoja.getRow(fil1);
                traer("F","D2",puerto,arch);
                celda = fila.getCell((short) 2);
                celda.setCellValue(cant);
                pesotot+= pes;
                
                fila = hoja.getRow(fil1);
                traer("F","R2",puerto,arch);
                celda = fila.getCell((short) 3);
                celda.setCellValue(cant);
                pesotot+= pes;
                
                fila = hoja.getRow(fil1);
                traer("F","D4",puerto,arch);
                celda = fila.getCell((short) 4);
                celda.setCellValue(cant);
                pesotot+= pes;

                fila = hoja.getRow(fil1);
                traer("F","D5",puerto,arch);
                celda = fila.getCell((short) 5);
                celda.setCellValue(cant);
                pesotot+= pes;

                fila = hoja.getRow(fil1);
                traer("F","R4",puerto,arch);
                celda = fila.getCell((short) 6);
                celda.setCellValue(cant);
                pesotot+= pes;

                fila = hoja.getRow(fil1);
                traer("E","D2",puerto,arch);
                celda = fila.getCell((short) 8);
                celda.setCellValue(cant);
                pesotot+= pes;

                fila = hoja.getRow(fil1);
                traer("E","D4",puerto,arch);
                celda = fila.getCell((short) 9);
                celda.setCellValue(cant);
                pesotot+= pes;

                fila = hoja.getRow(fil1);
                traer("E","D5",puerto,arch);
                celda = fila.getCell((short) 10);
                celda.setCellValue(cant);
                pesotot+= pes;

                celda = fila.getCell((short) 12);
                pesotot = Math.ceil(pesotot);
                celda.setCellValue(pesotot);
                pesotot = 0;

                fila = hoja.getRow(fil3);
                cargarCeldasFormulas(celda,fila,fil2,fil3);
                
    }
    
    private void cargarPuertoT (HSSFCell celda, HSSFRow fila,HSSFSheet hoja, String puerto, ArrayList arch, int fil1)
    {
        double pesotot = 0;
                
        fila = hoja.getRow(fil1);
        traer("F","D2",puerto,arch);
        celda = fila.getCell((short) 2);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
        fila = hoja.getRow(fil1 + 1);
        traer("F","R2",puerto,arch);
        celda = fila.getCell((short) 2);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
              
        fila = hoja.getRow(fil1 + 4);
        traer("M","D2",puerto,arch);
        celda = fila.getCell((short) 2);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
        fila = hoja.getRow(fil1 + 5);
        traer("M","R2",puerto,arch);
        celda = fila.getCell((short) 2);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
              
        fila = hoja.getRow(fil1 + 6);
        celda = fila.getCell((short) 2);
        celda.setCellValue(pesotot);
                
        //---------------------------------------------------------------------------------------------------------
                
        fila = hoja.getRow(fil1);
        traer("F","D4",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot= pes;

        fila = hoja.getRow(fil1);
        traer("F","R4",puerto,arch);
        celda = fila.getCell((short) 3);
        celda.setCellValue(cant);
        pesotot+= pes;

        fila = hoja.getRow(fil1 + 4);
        traer("M","D4",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
        fila = hoja.getRow(fil1 + 5);
        traer("M","R4",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
                
        fila = hoja.getRow(fil1 + 2);
        traer("F","R5",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot= pes;

        fila = hoja.getRow(fil1 + 3);
        traer("F","D5",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;

        fila = hoja.getRow(fil1 + 4);
        traer("M","D5",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
        fila = hoja.getRow(fil1 + 5);
        traer("M","R5",puerto,arch);
        celda = fila.getCell((short) 3);
        if(cant > 0){celda.setCellValue(cant);}
        pesotot+= pes;
                
        fila = hoja.getRow(fil1 + 6);
        celda = fila.getCell((short) 3);
        celda.setCellValue(pesotot);
                
                
    }
    
    private void cargarPuertoB (HSSFCell celda, HSSFRow fila,HSSFSheet hoja, ArrayList arch, int fil1)
    {
        double pesotot = 0;
        double canti = 0;        
        
        fila = hoja.getRow(fil1);
        traer("F","D2","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("F","D2","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 2);
        if(canti > 0){celda.setCellValue(canti);}
        
                
        fila = hoja.getRow(fil1 + 1);
        traer("F","D4","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("F","D4","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 2);
        if(canti > 0){celda.setCellValue(canti);}
        
        
        fila = hoja.getRow(fil1 + 4);
        traer("M","D2","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","D2","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 2);
        if(canti > 0){celda.setCellValue(canti);}
                
        fila = hoja.getRow(fil1 + 5);
        traer("M","R2","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","R2","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 2);
        if(canti > 0){celda.setCellValue(canti);}
              
        fila = hoja.getRow(fil1 + 6);
        celda = fila.getCell((short) 2);
        celda.setCellValue(pesotot);
                
        //---------------------------------------------------------------------------------------------------------
                
        fila = hoja.getRow(fil1);
        traer("F","D4","BRSSZ",arch);
        canti = cant;
        pesotot = pes;
        traer("F","D4","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
        
        traer("F","R4","BRSSZ",arch);
        canti+= cant;
        pesotot+= pes;
        traer("F","R4","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
        
        fila = hoja.getRow(fil1 + 4);
        traer("M","D4","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","D4","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
                        
        fila = hoja.getRow(fil1 + 5);
        traer("M","R4","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","R4","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
                                      
                
        fila = hoja.getRow(fil1 + 2);
        traer("F","R5","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("F","R5","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
       
        fila = hoja.getRow(fil1 + 3);
        traer("F","D5","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("F","D5","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
        
        fila = hoja.getRow(fil1 + 4);
        traer("M","D5","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","D5","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
                
        fila = hoja.getRow(fil1 + 5);
        traer("M","R5","BRSSZ",arch);
        canti = cant;
        pesotot+= pes;
        traer("M","R5","BRRIO",arch);
        canti+= cant;
        pesotot+= pes;
        celda = fila.getCell((short) 3);
        if(canti > 0){celda.setCellValue(canti);}
                        
        fila = hoja.getRow(fil1 + 6);
        celda = fila.getCell((short) 3);
        celda.setCellValue(pesotot);
                
                
    }    
    
    private ArrayList ref = new ArrayList();
    
    private void cargarPuertocsw (HSSFCell celda, HSSFRow fila,HSSFSheet hoja, String puerto, ArrayList arch, int fil)
    {
        double pesotot = 0;
        int cantr5 = 0;
        int cantr4 = 0;
        int cantr2 = 0;
        
        if(puerto.equals(""))
        {
            //CALCULO DE CANTIDADES
            double canthc40 = 0;
            
            //DRY
            fila = hoja.getRow(13);
            traercsw("F","D2","",arch);
            celda = fila.getCell((short) 16);
            celda.setCellValue(cant);

            pesotot+= pes;

            traercsw("F","D4","",arch);
            celda = fila.getCell((short) 17);
            celda.setCellValue(cant);

            canthc40 = cant;
            pesotot+= pes;

            fila = hoja.getRow(13);
            traercsw("E","D2","",arch);
            celda = fila.getCell((short) 18);
            celda.setCellValue(cant);

            pesotot+= pes;

            traercsw("E","D4","",arch);
            celda = fila.getCell((short) 19);
            celda.setCellValue(cant);

            pesotot+= pes;


            //HIGH CUBE DRY
            fila = hoja.getRow(13);
            traercsw("F","D5","",arch);
            celda = fila.getCell((short) 17);

            canthc40+= cant;
            celda.setCellValue(canthc40);

            pesotot+= pes;

            traercsw("M","D5","",arch);
            celda = fila.getCell((short) 19);
            celda.setCellValue(cant);


            //HIGH CUBE REFFER
            fila = hoja.getRow(14);
            traercsw("F","R5","",arch);
            celda = fila.getCell((short) 17);
            celda.setCellValue(cant);
                        
            pesotot+= pes;

            traercsw("M","R5","",arch);
            celda = fila.getCell((short) 19);
            celda.setCellValue(cant);

            //REEFER 20
            fila = hoja.getRow(15);
            traercsw("F","R2","",arch);
            celda = fila.getCell((short) 16);
            celda.setCellValue(cant);
            pesotot+= pes;

            traer("F","R4","",arch);
            celda = fila.getCell((short) 17);
            celda.setCellValue(cant);
            pesotot+= pes;

            
            traercsw("M","R2","",arch);
            celda = fila.getCell((short) 18);
            celda.setCellValue(cant);
            pesotot+= pes;

            traer("M","R4","",arch);
            celda = fila.getCell((short) 19);
            celda.setCellValue(cant);
            pesotot+= pes;

            fila = hoja.getRow(19);
            celda = fila.getCell((short) 16);
            celda.setCellValue(pesotot);
        }
        else
        {
            //CALCULO POR PUERTO
            fila = hoja.getRow(fil);
            traercsw("F","2",puerto,arch);
            celda = fila.getCell((short) 16);
            celda.setCellValue(cant);
            
            pesotot+= pes;
            
            traercsw("F","4",puerto,arch);
            celda = fila.getCell((short) 17);
            celda.setCellValue(cant);
            
            pesotot+= pes;
            
            traercsw("M","2",puerto,arch);
            celda = fila.getCell((short) 18);
            celda.setCellValue(cant);
            
            pesotot+= pes;
            
            traercsw("M","4",puerto,arch);
            celda = fila.getCell((short) 19);
            celda.setCellValue(cant);
            
            pesotot+= pes;
            
            celda = fila.getCell((short) 20);
            celda.setCellValue(pesotot);
            
        }
        //cargarCeldasFormulas(celda,fila,fil2,fil3); 
    }
    
    private void cargarPuertocswT (String puerto, ArrayList arch)
    {
        int cantr5 = 0;
        int cantr4 = 0;
        int cantr2 = 0;
        
        int i = 0;
        while (arch.size() > i)
        {
            container c = (container) arch.get(i);
            if(c.vaciolleno.equals("F") && c.tipo.equals("R5") && c.destino.equals(puerto)){cantr5+=c.cantidades;}
            if(c.vaciolleno.equals("F") && c.tipo.equals("R4") && c.destino.equals(puerto)){cantr4+=c.cantidades;}
            if(c.vaciolleno.equals("F") && c.tipo.equals("R2") && c.destino.equals(puerto)){cantr2+=c.cantidades;}
            
            i++;
        }
 
        if(cantr5 > 0){ref.add(cantr5 + "XHR40" + puerto);}
        if(cantr4 > 0){ref.add(cantr4 + "XRH40" + puerto);}
        if(cantr2 > 0){ref.add(cantr2 + "XRH20" + puerto);}
        
    }
    
    public void nx2 (ArrayList arch, String buq, String via) throws FileNotFoundException, IOException
    {
        String rut = "\\\\10.59.226.199\\sistemas\\almacenamiento_sw_operativo\\";
        String strRutaArchivo= rut + "ibr\\matrices\\nx2.xls";
        
        FileInputStream archivoEntrada;
                
        try 
        {
            POIFSFileSystem poiArchivo;
            archivoEntrada = new FileInputStream(strRutaArchivo);
            poiArchivo = new POIFSFileSystem(archivoEntrada);
            HSSFWorkbook libro;
            libro = new HSSFWorkbook(poiArchivo);
            HSSFSheet hoja = libro.getSheetAt(0);

            HSSFRichTextString texto = new HSSFRichTextString("");
            
            HSSFRow fila = hoja.createRow(1);
            HSSFCell celda = fila.createCell((short) 0);
            //celda.setCellValue("REPORTE PERSONALIZADO");    
            HSSFCellStyle f = null;

            fila = hoja.createRow(0);
            celda = fila.createCell((short) 4);
            celda.setCellValue(buq);

            fila = hoja.createRow(0);
            celda = fila.createCell((short) 8);
            celda.setCellValue(via);
            
            //El primer numerico indica la posicion donde se escribiran los campos, el segundo y el tercero los campos que implican la suma en las formulas
             
                cargarPuerto(celda,fila,hoja,"SGSIN",arch, 7, 6, 9);
                cargarPuerto(celda,fila,hoja,"HKHKG",arch, 12, 11, 14);
                cargarPuerto(celda,fila,hoja,"KRPUS",arch, 17, 16, 19);
                cargarPuerto(celda,fila,hoja,"CNSHA",arch, 22, 21, 24);
                cargarPuerto(celda,fila,hoja,"CNTAO",arch, 27, 26, 29);
                cargarPuerto(celda,fila,hoja,"MYPKG",arch, 32, 31, 34);
                cargarPuerto(celda,fila,hoja,"CNNGB",arch, 37, 36, 39);
                cargarPuerto(celda,fila,hoja,"UYMVD",arch, 42, 41, 44);
                
                cargarPuerto(celda,fila,hoja,"CNCWN",arch, 42, 46, 49);
                cargarPuerto(celda,fila,hoja,"BRPNG",arch, 47, 51, 54);
                cargarPuerto(celda,fila,hoja,"BRSSZ",arch, 52, 56, 59);
                cargarPuerto(celda,fila,hoja,"ARBUE",arch, 57, 61, 64);
                
                int i = 0;
                //reefer
                try
                {
                    BD unb = new BD();
                    String url = "SELECT c.numero_con, c.temp_con, tipoequipoopus_con FROM bridge_bls b, bridge_contenedores c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.numero_bl AND origen_bl = 'MONTEVIDEO' AND c.tipoequipoopus_con LIKE 'R%' ORDER BY b.discharge";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 220);
                        celda = fila.createCell((short) 1);
                        celda.setCellValue(lista.getString(1));
                        celda = fila.createCell((short) 2);
                        String valorr = "WAIT";
                        if(lista.getString(2).equals("") == false)
                        {
                            valorr = lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                }
                
                //imo
                try
                {
                    BD unb = new BD();
                    String url = "SELECT c.numero_imo, c.un_imo, c.numero_con FROM bridge_bls b, bridge_imo c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.id_escala AND origen_bl = 'MONTEVIDEO' GROUP BY  c.numero_con, c.numero_imo, c.un_imo";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    i = 0;
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 221);
                        celda = fila.createCell((short) 3);
                        celda.setCellValue(lista.getString(3));
                        celda = fila.createCell((short) 4);
                        String valorr = "WAIT";
                        if(lista.getString(1).equals("") == false)
                        {
                            valorr = lista.getString(1) + " " +  lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                } 
                     
                
            // Fin    
                        
            //FORMULAS GENERALES

                fila = hoja.getRow(67);    
                cargarCeldasCalculos(celda,fila);

                fila = hoja.getRow(69);
                cargarCeldasFormulas(celda,fila,66,69);

                String strFormula = "+C70+D70+E70+E70+F70+F70+G70+G70+I70+J70+J70+K70+K70";
                celda = fila.getCell((short) 13);
                celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                celda.setCellFormula(strFormula);

            //FIN FORMULAS
            
            
            String archi = "nx2-" + buq + via + ".xls";
            String ruta = rut + "\\ibr\\nx2-" + buq + via + ".xls";
            FileOutputStream elFichero = new FileOutputStream(ruta);
            libro.write(elFichero);
            elFichero.close();
            
            ArrayList unL = new ArrayList();
            adjuntos ad = new adjuntos();
            ad.nombre = archi;
            ad.adjunto = ruta;
            unL.add(ad);
            
            ArrayList pers = new ArrayList();
            pers.add("uy.operations@one-line.com");
            pers.add("gabriel.suarez@one-line.com");
            //Mail unM = new Mail ("uy.operations@one-line.com", "IBR NX2 " + buq + " " + via, "Mensaje Servicio NX2 generado y adjunto en este mensaje.", null, unL, null);
            Mail unM = new Mail ("", "IBR NX2 " + buq + " " + via, "Servicio NX2 generado y adjunto en este mensaje.", "SYSTEM", unL, pers);        
            
             File fichero = new File(ruta);

            if (fichero.delete())
            {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            }
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void ang (ArrayList arch, String buq, String via) throws FileNotFoundException, IOException
    {
        String rut = "\\\\10.59.226.199\\sistemas\\almacenamiento_sw_operativo\\";
        String strRutaArchivo= rut + "ibr\\matrices\\ang.xls";
        
        FileInputStream archivoEntrada;
                
        try 
        {
            POIFSFileSystem poiArchivo;
            archivoEntrada = new FileInputStream(strRutaArchivo);
            poiArchivo = new POIFSFileSystem(archivoEntrada);
            HSSFWorkbook libro;
            libro = new HSSFWorkbook(poiArchivo);
            HSSFSheet hoja = libro.getSheetAt(0);

            HSSFRichTextString texto = new HSSFRichTextString("");
            
            HSSFRow fila = hoja.createRow(2);
            HSSFCell celda = fila.createCell((short) 2);
            celda.setCellValue(buq);    
            HSSFCellStyle f = null;

            celda = fila.createCell((short) 8);
            celda.setCellValue(via);

            try{cargarPuertoT(celda,fila,hoja,"COCTG",arch, 8);
            cargarPuertoT(celda,fila,hoja,"MXVER",arch, 114);
            cargarPuertoT(celda,fila,hoja,"MXATM",arch, 122);
            cargarPuertoT(celda,fila,hoja,"USHOU",arch, 130);
            cargarPuertoT(celda,fila,hoja,"USNOL",arch, 138);
            cargarPuertoB(celda,fila,hoja,arch, 186);
            
            String strFormula = "C9+C17+C25+C33+C41+C49+C57+C65+C115+C123+C131+C139+C147+C155+C163+C171+C179+C187+C73+C81+C89+C97+C105";
            fila = hoja.createRow(194);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C10+C18+C26+C34+C42+C50+C58+C66+C116+C124+C132+C140+C148+C156+C164+C172+C180+C188+C74+C82+C90+C98+C106";
            fila = hoja.createRow(195);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C11+C19+C27+C35+C43+C51+C59+C67+C117+C125+C133+C141+C149+C157+C165+C173+C181+C189+C75+C83+C91+C99+C107";
            fila = hoja.createRow(196);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C12+C20+C28+C36+C44+C52+C60+C68+C118+C126+C134+C142+C150+C158+C166+C174+C182+C190+C76+C84+C92+C100+C108";
            fila = hoja.createRow(197);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C13+C21+C29+C37+C45+C53+C61+C69+C119+C127+C135+C143+C151+C159+C167+C175+C183+C191+C77+C85+C93+C101+C109";
            fila = hoja.createRow(198);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C14+C22+C30+C38+C46+C54+C62+C70+C120+C128+C136+C144+C152+C160+C168+C176+C184+C192+C78+C86+C94+C102+C110";
            fila = hoja.createRow(199);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "C15+C23+C31+C39+C47+C55+C63+C71+C121+C129+C137+C145+C153+C161+C169+C177+C185+C193+C79+C87+C95+C103+C111";
            fila = hoja.createRow(200);
            celda = fila.createCell((short) 2);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            //----------------------------------------------------------------------------------------------------------------------------------------
            
            strFormula = "E9+E17+E25+E33+E41+E49+E57+E65+E115+E123+E131+E139+E147+E155+E163+E171+E179+E187+E73+E81+E89+E97+E105";
            fila = hoja.createRow(194);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "E10+E18+E26+E34+E42+E50+E58+E66+E116+E124+E132+E140+E148+E156+E164+E172+E180+E188+E74+E82+E90+E98+E106";
            fila = hoja.createRow(195);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "E11+E19+E27+E35+E43+E51+E59+E67+E117+E125+E133+E141+E149+E157+E165+E173+E181+E189+E75+E83+E91+E99+E107";
            fila = hoja.createRow(196);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "E12+E20+E28+E36+E44+E52+E60+E68+E118+E126+E134+E142+E150+E158+E166+E174+E182+E190+E76+E84+E92+E100+E108";
            fila = hoja.createRow(197);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "E13+E21+E29+E37+E45+E53+E61+E69+E119+E127+E135+E143+E151+E159+E167+E175+E183+E191+E77+E85+E93+E101+E109";
            fila = hoja.createRow(198);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "E14+E22+E30+E38+E46+E54+E62+E70+E120+E128+E136+E144+E152+E160+E168+E176+E184+E192+E78+E86+E94+E102+E110";
            fila = hoja.createRow(199);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
                                    
            strFormula = "E15+E23+E31+E39+E47+E55+E63+E71+E121+E129+E137+E145+E153+E161+E169+E177+E185+E193+E79+E87+E95+E103+E111";
            fila = hoja.createRow(200);
            celda = fila.createCell((short) 4);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            
            //------------------------------------------------------------------------------------------------------------------------------------------------
            
            strFormula = "D9+D17+D25+D33+D41+D49+D57+D65+D115+D123+D131+D139+D147+D155+D163+D171+D179+D187+D73+D81+D89+D97+D105";
            fila = hoja.createRow(194);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D10+D18+D26+D34+D42+D50+D58+D66+D116+D124+D132+D140+D148+D156+D164+D172+D180+D188+D74+D82+D90+D98+D106";
            fila = hoja.createRow(195);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D11+D19+D27+D35+D43+D51+D59+D67+D117+D125+D133+D141+D149+D157+D165+D173+D181+D189+D75+D83+D91+D99+D107";
            fila = hoja.createRow(196);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D12+D20+D28+D36+D44+D52+D60+D68+D118+D126+D134+D142+D150+D158+D166+D174+D182+D190+D76+D84+D92+D100+D108";
            fila = hoja.createRow(197);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D13+D21+D29+D37+D45+D53+D61+D69+D119+D127+D135+D143+D151+D159+D167+D175+D183+D191+D77+D85+D93+D101+D109";
            fila = hoja.createRow(198);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D14+D22+D30+D38+D46+D54+D62+D70+D120+D128+D136+D144+D152+D160+D168+D176+D184+D192+D78+D86+D94+D102+D110";
            fila = hoja.createRow(199);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            strFormula = "D15+D23+D31+D39+D47+D55+D63+D71+D121+D129+D137+D145+D153+D161+D169+D177+D185+D193+D79+D87+D95+D103+D111";
            fila = hoja.createRow(200);
            celda = fila.createCell((short) 3);
            celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda.setCellFormula(strFormula);
            
            
            }catch(Exception ex){}
            
            
             int i = 0;
                //reefer
                try
                {
                    BD unb = new BD();
                    String url = "SELECT c.numero_con, c.temp_con, tipoequipoopus_con FROM bridge_bls b, bridge_contenedores c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.numero_bl AND origen_bl = 'MONTEVIDEO' AND c.tipoequipoopus_con LIKE 'R%' ORDER BY b.discharge";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 97);
                        celda = fila.createCell((short) 1);
                        celda.setCellValue(lista.getString(1));
                        celda = fila.createCell((short) 2);
                        String valorr = "WAIT";
                        if(lista.getString(2).equals("") == false)
                        {
                            valorr = lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                }
                
                //imo
                try
                {
                    BD unb = new BD();
                    String url = "SELECT c.numero_imo, c.un_imo, c.numero_con FROM bridge_bls b, bridge_imo c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.id_escala AND origen_bl = 'MONTEVIDEO' GROUP BY  c.numero_con, c.numero_imo, c.un_imo";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    i = 0;
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 97);
                        celda = fila.createCell((short) 3);
                        celda.setCellValue(lista.getString(3));
                        celda = fila.createCell((short) 4);
                        String valorr = "WAIT";
                        if(lista.getString(1).equals("") == false)
                        {
                            valorr = lista.getString(1) + " " +  lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                } 
            
            
            
            
            String archi = "ang-" + buq + via + ".xls";
            String ruta = rut + "\\ibr\\ang-" + buq + via + ".xls";
            FileOutputStream elFichero = new FileOutputStream(ruta);
            libro.write(elFichero);
            elFichero.close();
            
            ArrayList unL = new ArrayList();
            adjuntos ad = new adjuntos();
            ad.nombre = archi;
            ad.adjunto = ruta;
            unL.add(ad);
            
            ArrayList pers = new ArrayList();
            pers.add("uy.operations@one-line.com");
            pers.add("gabriel.suarez@one-line.com");
            //Mail unM = new Mail ("uy.operations@one-line.com", "IBR NX2 " + buq + " " + via, "Mensaje Servicio NX2 generado y adjunto en este mensaje.", null, unL, null);
            Mail unM = new Mail ("", "IBR ANG " + buq + " " + via, "Servicio ANG generado y adjunto en este mensaje.", "SYSTEM", unL, pers);        
            
             File fichero = new File(ruta);

            if (fichero.delete())
            {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            }
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    public void csw (ArrayList arch, String buq, String via) throws FileNotFoundException, IOException
    {
        String rut = "\\\\10.59.226.199\\sistemas\\almacenamiento_sw_operativo\\";
        String strRutaArchivo= rut + "ibr\\matrices\\csw.xls";
        
        FileInputStream archivoEntrada;
                
        try 
        {
            POIFSFileSystem poiArchivo;
            archivoEntrada = new FileInputStream(strRutaArchivo);
            poiArchivo = new POIFSFileSystem(archivoEntrada);
            HSSFWorkbook libro;
            libro = new HSSFWorkbook(poiArchivo);
            HSSFSheet hoja = libro.getSheetAt(0);

            HSSFRichTextString texto = new HSSFRichTextString("");
            
            HSSFRow fila = hoja.createRow(1);
            HSSFCell celda = fila.createCell((short) 0);
            //celda.setCellValue("REPORTE PERSONALIZADO");    
            HSSFCellStyle f = null;

            fila = hoja.createRow(1);
            celda = fila.createCell((short) 4);
            celda.setCellValue(buq + " - " + via);
            
            //El primer numerico indica la posicion donde se escribiran los campos, el segundo y el tercero los campos que implican la suma en las formulas
             
                cargarPuertocsw(celda,fila,hoja,"",arch, 0);
                cargarPuertocsw(celda,fila,hoja,"ZAZBA",arch, 24);
                cargarPuertocsw(celda,fila,hoja,"SGSIN",arch, 25);
                cargarPuertocsw(celda,fila,hoja,"HKHKG",arch, 26);
                cargarPuertocsw(celda,fila,hoja,"KRPUS",arch, 27);
                cargarPuertocsw(celda,fila,hoja,"CNSHA",arch, 28);
                cargarPuertocsw(celda,fila,hoja,"CNNGB",arch, 29);
                cargarPuertocsw(celda,fila,hoja,"CNCWN",arch, 30);
                cargarPuertocsw(celda,fila,hoja,"CNYTN",arch, 31);
                
                cargarPuertocsw(celda,fila,hoja,"BRSSZ",arch, 32);
                cargarPuertocsw(celda,fila,hoja,"BRPNG",arch, 33);
                cargarPuertocsw(celda,fila,hoja,"ARBUE",arch, 34);
                
                ref = new ArrayList();
                cargarPuertocswT("ZAZBA",arch);
                cargarPuertocswT("SGSIN",arch);
                cargarPuertocswT("HKHKG",arch);
                cargarPuertocswT("KRPUS",arch);
                cargarPuertocswT("CNSHA",arch);
                cargarPuertocswT("CNNGB",arch);
                cargarPuertocswT("CNCWN",arch);
                cargarPuertocswT("CNYTN",arch);
                
                cargarPuertocswT("BRSSZ",arch);
                cargarPuertocswT("BRPNG",arch);
                cargarPuertocswT("ARBUE",arch);
                
                int i = 0;
                while(ref.size() > i)
                {
                    fila = hoja.createRow(i + 54);
                    celda = fila.createCell((short) 17);
                    celda.setCellValue(ref.get(i).toString());
                    i++;
                }           
                    
                //reefer
                 try
                 {
                    BD unb = new BD();
                    String url = "SELECT c.numero_con, c.temp_con, tipoequipoopus_con FROM bridge_bls b, bridge_contenedores c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.numero_bl AND origen_bl = 'MONTEVIDEO' AND c.tipoequipoopus_con LIKE 'R%' ORDER BY b.discharge";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    i = 0;
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 90);
                        celda = fila.createCell((short) 16);
                        celda.setCellValue(lista.getString(1));
                        celda = fila.createCell((short) 19);
                        String valorr = "WAIT";
                        if(lista.getString(2).equals("") == false)
                        {
                            valorr = lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                }
                
                //imo
                 try
                 {
                    BD unb = new BD();
                    String url = "SELECT c.numero_imo, c.un_imo, c.numero_con FROM bridge_bls b, bridge_imo c WHERE b.buque_bl = '" + buq + "' AND viaje_bl = '" + via + "' AND b.numero_bl = c.id_escala AND origen_bl = 'MONTEVIDEO' GROUP BY  c.numero_con, c.numero_imo, c.un_imo";

                    CachedRowSet lista = unb.Function(url);
                    RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

                    i = 0;
                    while (lista.next())
                    {
                        fila = hoja.createRow(i + 42);
                        celda = fila.createCell((short) 16);
                        celda.setCellValue(lista.getString(3));
                        celda = fila.createCell((short) 19);
                        String valorr = "WAIT";
                        if(lista.getString(1).equals("") == false)
                        {
                            valorr = lista.getString(1) + " " +  lista.getString(2);
                        }
                        celda.setCellValue(valorr);
                        i++;
                    }
                }
                catch(Exception ex)
                {
                } 
                 
                 
                 
            String archi = "csw-" + buq + via + ".xls";
            String ruta = rut + "\\ibr\\csw-" + buq + via + ".xls";
            FileOutputStream elFichero = new FileOutputStream(ruta);
            libro.write(elFichero);
            elFichero.close();
            
            ArrayList unL = new ArrayList();
            adjuntos ad = new adjuntos();
            ad.nombre = archi;
            ad.adjunto = ruta;
            unL.add(ad);
            
            ArrayList pers = new ArrayList();
            pers.add("uy.operations@one-line.com");
            pers.add("gabriel.suarez@one-line.com");
            Mail unM = new Mail ("", "IBR CSW " + buq + " " + via, "Servicio CSW generado y adjunto en este mensaje.", "SYSTEM", unL, pers);        
            
             File fichero = new File(ruta);

            if (fichero.delete())
            {
                System.out.println("El fichero ha sido borrado satisfactoriamente");
            }
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
    }
    
    //METODO
    public BufferedReader cargarContainer (BufferedReader br, bl unb) throws IOException
    {
        container unC = new container();
        boolean seguir = true;
        ArrayList containers = new ArrayList();
        String linea = "";
        while(seguir)
        {
            if((linea=br.readLine())!=null)
            {
                //CNTRWGT
                //CNTRGWGT
                
                String[] lin = linea.split(":");
                try{if(lin[0].equals("CNTRNBR")){unC.marca = lin[1];}}catch(Exception ex){unC.marca = "";}
                try{if(lin[0].equals("CNTRTYPE")){unC.tipo = lin[1];}}catch(Exception ex){unC.tipo = "";}
                try{if(lin[0].equals("CNTRGWGT")){unC.peso = lin[1];}}catch(Exception ex){unC.peso = "";}
                try{if(lin[0].equals("PKG")){unC.cantidadbultos = lin[1];}}catch(Exception ex){unC.cantidadbultos = "";}
                try{if(lin[0].equals("TEMP")){unC.temp = lin[1];}}catch(Exception ex){unC.temp = "";}
                //SEAL SECUENCIA POR MAS DE UNO, SE SEPARAN POR :
                try{if(lin[0].equals("SEALNBR")){if(unC.seal.equals("")){unC.seal = lin[1];}else{unC.seal = unC.seal + ";" + lin[1];}}}catch(Exception ex){unC.seal = "";}
               
                //CAMBIO 30122020 CARO ME LO PIDIO
                //try{if(lin[0].equals("CMDTCD")){if(unC.ncm.equals("")){unC.ncm = lin[1];}else{unC.ncm = unC.ncm + ";" + lin[1];}}}catch(Exception ex){unC.ncm = "";}
                try{if(lin[0].equals("D_NCM_CD")){if(unC.ncm.equals("")){unC.ncm = lin[1];}else{unC.ncm = unC.ncm + ";" + lin[1];}}}catch(Exception ex){unC.ncm = "";}                      
                try{if(lin[0].equals("D_HS_CD")){if(unC.ncm.equals("")){unC.ncm = lin[1];}else{unC.ncm = unC.ncm + ";" + lin[1];}}}catch(Exception ex){unC.ncm = "";}
                try{if(lin[0].equals("D_HTS_CD")){if(unC.ncm.equals("")){unC.ncm = lin[1];}else{unC.ncm = unC.ncm + ";" + lin[1];}}}catch(Exception ex){unC.ncm = "";}
                
                
                try{if(lin[0].equals("BLPOD1")){
                    unb.discharge = lin[1];}}catch(Exception ex){unb.discharge = "";}
                try{if(lin[0].equals("BLPOL1")){
                    unb.discharge1 = lin[1];}}catch(Exception ex){unb.discharge1 = "";}
                
                
                if(lin[0].equals("{CNTR_DANGER"))
                {
                    imo unimo = new imo();
                    br = unimo.cargarImo(br, unb, unC);
                    unC.imo = unimo.misimo;
                }
                
                if(lin[0].equals("}CNTR_INFO"))
                {
                    containers.add(unC);
                    unC = new container();
                }

                if(lin[0].equals("}BL_INFO"))
                {
                    containers.add(unC);
                    unb.containers = containers;
                    seguir = false;
                }
            }
        }
        return br;
    }
   
    public boolean cargar(String vnumerobl, String usu) 
    {
        boolean flag = true;
        ONE.BD unb = new ONE.BD();
        if(this.marca.equals("") == false)
        {
            this.seal = depurarPrecintos(this.seal);
            //if(this.seal.equals("")){this.vaciolleno="m";}else{this.vaciolleno="f";}
            this.vaciolleno = "f";
            String sql = "INSERT INTO bridge_contenedores (temp_con,cantidadbultos_con,numero_bl,numero_con,tipoequipoOPUS_con,precinto_con,vaciolleno_con,peso_con,ncm) VALUES (";
            sql += "'" + this.temp + "','" + this.cantidadbultos + "','" + vnumerobl + "','" + this.marca + "','" + this.tipo + "','" + this.seal + "','" + this.vaciolleno + "','" + this.peso + "','" + this.ncm + "')";
                
            try 
            {
                unb.sistema = "BRIDGE";
                unb.usuario = usu;
                unb.StoreProcedure(sql, "one");
                
                imo uni = new imo();
                uni.cargar (this.imo, vnumerobl, this.marca, usu);
                
            }
            catch(Exception ex)
            {
                flag = false;
            }
        }
        return flag;
    }

    public String ConcatenarContenedoresPorBL(String vnumerobl) 
    {
        String flag = "";
        ONE.BD unb = new ONE.BD();
        
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function("Select numero_con from bridge_contenedores where numero_bl = '" + vnumerobl + "' group by numero_con");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while (lista.next())
            {
                flag = lista.getString(1) + " " + flag;
            }
        }
        catch (Exception ex)
        {
        }
 
        return flag;
    }

    
    public String depurarPrecintos(String precintos)
    {
        String[] lin = precintos.split(";");
        String pre = "";
        if(lin.length >= 2)
        {
            if (lin[0].equals(lin[1]))
            {
                for(int x=1;x < lin.length;x++)
                {
                    pre = pre + lin[x] + ";";
                }
                pre = pre.substring(0,pre.length() - 1);
            }
        }
        else
        {
            pre = precintos;
        }
        return pre;
    }

    public double pes = 0;
    public double cant = 0;
    
    private void traer(String MF, String TIP, String DEST, ArrayList arch) {
        pes = 0;
        cant = 0;
        int i = 0;
        while (arch.size() > i)
        {
            container c = (container) arch.get(i);
            if(c.vaciolleno.equals(MF) && c.tipo.equals(TIP)){cant+=c.cantidades;pes = pes + Double.parseDouble(c.peso);}
            i++;
        }
       // pes = pes / 1000;
    }
    
    private void traercsw(String MF, String TIP, String DEST, ArrayList arch) {
        pes = 0;
        cant = 0;
        int i = 0;
        while (arch.size() > i)
        {
            container c = (container) arch.get(i);
            c.vaciolleno = c.vaciolleno.toUpperCase();
            if(DEST.length() < 1)
            {
                if(c.vaciolleno.equals(MF) && c.tipo.equals(TIP)){cant+=c.cantidades;pes = pes + Double.parseDouble(c.peso);}
            }
            else
            {
                String titi = c.tipo.substring(1,2);
                if(titi.equals("5")){titi = "4";}
                if(c.vaciolleno.equals(MF) && c.destino.equals(DEST) && titi.equals(TIP))
                {
                    cant+=c.cantidades;
                    pes+= Double.parseDouble(c.peso);
                }
            }
            i++;
                
        }
        //pes = pes / 1000;
    }*/
}
