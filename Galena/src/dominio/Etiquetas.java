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
        int y = 40;
        switch (pageIndex)
        {
            case 0 : //Página 1: Dibujamos sobre g y luego lo pasamos a g2
                
            try
            {
                g.setFont(fuente);
                g.drawString("ALMACEN GALENA", 45 , y);
                
                y = y + 15;
                g.drawString("FECHA: " + unaV.fecha, 45 , y);
                y = y + 30;
                
                g.drawString("PRODUCTO", 30 , y);
                g.drawString("TOTAL", 135 , y);
                
                y = y + 10;
                fuente = new Font("",1,7);
                g.setFont(fuente);
                g.drawString("------------------------------------------------------------------", 30 , y);
                for (int i =0; i < lista.size();i++)
                {
                    linea unL = (linea) lista.get(i);
                    y = y + 15;
                    
                    int tope = unL.nombreproducto.length();
                    if(tope > 35){tope = 35;}
                    g.drawString(unL.nombreproducto.substring(0,tope) + " (" + unL.cantidad + ")", 30 , y);
                    g.drawString(unL.preciofinal, 150 , y);
                }
                y = y + 15;
                g.drawString("------------------------------------------------------------------", 30 , y);
                y = y + 15;
                g.drawString(unaV.total, 150 , y);
            }
            catch(Exception ex)
            {
                
            }
                
                return PAGE_EXISTS; //La página 1 existe y se imprimirá
           
            default: return NO_SUCH_PAGE;        //No se imprimirán más páginas
        }
            
   }
   
}