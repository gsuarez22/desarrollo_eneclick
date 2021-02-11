package domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class sueldo 
{

    public String numero="", nombre="", mesliquidado="", cobro="", jornal="", presentismo="", antiguedad="", totalhaberes="", cedula="", fecIngreso="";
    public String bps="", snis="", frl="", fondo="", judicial="", irpf="", retencion="", anda="", totaldto="", a_cobrar="", licencia="", salario="";
    
    ArrayList detalle = new ArrayList();
    
    public void cargarDetalle(HSSFWorkbook wb, HSSFSheet sheet)
    {
        detalle = new ArrayList();
        String val = numero;
        if(numero.length() < 2)
        {
            val = "00" + numero;
        }
        else
        {
            if(numero.length() < 3)
            {
                val = "0" + numero;
            }
            else
            {
                val = numero.substring(0,3);

            }
        }
        val = "21355" + val;
        sheet=wb.getSheet(val);
        HSSFRow row;
        HSSFCell cell;
        
        int i = 1;
        boolean fin = false;
        
        
        
        while (i < 200 && fin == false)
        {
            row = sheet.getRow(i);
        
            val = "";
            try
            {
                cell = row.getCell((short) 4);
                detallesueldo s = new detallesueldo();
                
                try
                {
                    s.saldo1 = String.valueOf(cell.getNumericCellValue());
                    s.saldo1 = s.saldo1.replace(".0", "");
                    
                    SimpleDateFormat unF = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try{cell = row.getCell((short) 0);
                    s.fecha = unF.format(cell.getDateCellValue());}catch(Exception ex){}

                    try{cell = row.getCell((short) 1);
                    s.concepto = cell.getStringCellValue();}catch(Exception ex){}

                    try{cell = row.getCell((short) 2);
                    s.debe1 = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                                        
                    try{cell = row.getCell((short) 3);
                    s.haber = String.valueOf(cell.getNumericCellValue());}catch(Exception ex){}
                            
                    detalle.add(s);
                    
                    
                }
                catch(Exception ex)
                {
                    fin = true;
                }
                
                
            }
            catch(Exception ex)
            {
                
                
            }
            
            i++;
            
        }
        ajustarNumeracion();
    }

    public void ajustarNumeracion()
    {

        this.a_cobrar = numeros.acotarDecimales(2, this.a_cobrar);
        this.jornal = numeros.acotarDecimales(2, this.jornal);
        this.presentismo = numeros.acotarDecimales(2, this.presentismo);
        this.totalhaberes = numeros.acotarDecimales(2, this.totalhaberes);
        this.antiguedad = numeros.acotarDecimales(2, this.antiguedad);
        this.bps = numeros.acotarDecimales(2, this.bps);
        this.snis = numeros.acotarDecimales(2, this.snis);
        this.frl = numeros.acotarDecimales(2, this.frl);
        this.fondo = numeros.acotarDecimales(2, this.fondo);
        this.judicial = numeros.acotarDecimales(2, this.judicial);
        this.irpf = numeros.acotarDecimales(2, this.irpf);
        this.retencion = numeros.acotarDecimales(2, this.retencion);
        this.anda = numeros.acotarDecimales(2, this.anda);
        this.totaldto = numeros.acotarDecimales(2, this.totaldto);
        this.a_cobrar = numeros.acotarDecimales(2, this.a_cobrar);
        
    }
    
}
