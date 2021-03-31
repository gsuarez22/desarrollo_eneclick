package gui;

import dominio.linea;
import dominio.venta;
import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import java.util.ArrayList;

//La clase debe de implementar la impresión implements Printable
class Etiquetas implements Printable
{
   public ArrayList lista = new ArrayList();
   public venta unaV = new venta();
   public Boolean flag = true;
   
   public int print (Graphics g, PageFormat f, int pageIndex)
   {         
        Font fuente = new Font("",1,12);
        int y = 80;
        switch (pageIndex)
        {
            case 0 : //Página 1: Dibujamos sobre g y luego lo pasamos a g2
                
            try
            {
                g.setFont(fuente);
                g.drawString("ALMACEN JAVIER", 30 , y);
                g.drawString("FECHA: " + unaV.fecha, 450 , y);
                y = y + 15;
                g.drawString("NUMERO: " + unaV.idventas, 30 , y);
                y = y + 15;
                g.drawString("CLIENTE: " + unaV.cliente, 30 , y);
                y = y + 60;
                
                g.drawString("PRODUCTO", 30 , y);
                g.drawString("CANTIDAD", 230 , y);
                g.drawString("UNIDAD", 310 , y);
                g.drawString("TOTAL U", 370 , y);
                g.drawString("PRECIO U", 435 , y);
                g.drawString("TOTAL", 510 , y);
                
                y = y + 10;
                fuente = new Font("",1,9);
                g.setFont(fuente);
                g.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", 30 , y);
                for (int i =0; i < lista.size();i++)
                {
                    linea unL = (linea) lista.get(i);
                    y = y + 15;
                    
                    int tope = unL.nombreproducto.length();
                    if(tope > 35){tope = 35;}
                    g.drawString(unL.nombreproducto.substring(0,tope), 30 , y);
                    g.drawString(unL.cantidad, 230 , y);
                    g.drawString(unL.cantidadunitaria, 310 , y);
                    int cant = 0;
                    try{cant = Integer.parseInt(unL.cantidad) * Integer.parseInt(unL.cantidadunitaria);} catch(Exception ex){}
                    g.drawString(String.valueOf(cant), 370 , y);
                    double can = 0;
                    try{can = Double.parseDouble(unL.preciounitario) / Double.parseDouble(unL.cantidadunitaria);} catch(Exception ex){}
                    
                    g.drawString(unL.preciounitario + " (" + String.valueOf(can) + ")", 435 , y);
                    g.drawString(unL.preciofinal, 510 , y);
                }
                y = y + 15;
                g.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", 30 , y);
                y = y + 15;
                g.drawString(unaV.total, 510 , y);
            }
            catch(Exception ex)
            {
                
            }
                
                return PAGE_EXISTS; //La página 1 existe y se imprimirá
           
            default: return NO_SUCH_PAGE;        //No se imprimirán más páginas
        }
            
   }
   
}