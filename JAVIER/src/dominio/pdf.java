/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;



/**
 *
 * @author gabriel.suarez
 */
public class pdf 
{
    
    private static final Font titulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
    private static final Font titulos = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font tituloss = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.BOLD);
     
    private static final Font textobold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font textoboldo = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.LIGHT_GRAY);
    private static final Font texto = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static final Font textosubrayado = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDERLINE);
    private static final Font textochicobold = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
    private static final Font textochicobold8 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
    private static final Font textochico = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
    private static final Font textochicorojo = new Font(Font.FontFamily.TIMES_ROMAN, 22, Font.BOLD, BaseColor.RED);
    private static final Font textochicos = new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL);
    
    private static final String iTextExampleImage = "C:\\javier\\adjuntos\\logo.png";
    //private static final String iTextExamplepie = "\\\\10.59.226.199\\sistemas\\almacenamiento_sw_operativo\\linea.png";
   
    public void armarMailing (JTable tbl, String nombre)
    {
        try
        {
            Document document = new Document(PageSize.A4.rotate(), 5, 5, 5, 5);
            Paragraph parrafo;
            //String desktopPath = System.getProperty("user.home") + "/Desktop/";
            //nombre = desktopPath + nombre;
            PdfWriter.getInstance(document, new FileOutputStream(nombre));
            document.open();

            document.addTitle("Mailing - Sistema Javier)");
            document.addSubject("Sistema Javier");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("IT ENECLICK");
            document.addCreator("Gabriel Suarez - Viviana Villanueva");
            
           
            int ajuste = 0;
            int i = 1;            
            int x = 45;
            int y = 325;
            PdfPTable table = new PdfPTable(3);     
            
            Chunk chunk = new Chunk("\n \n \n \n \n", textobold);
            parrafo = new Paragraph(chunk);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            document.add(parrafo);

            Image imagen = Image.getInstance(iTextExampleImage);
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.setAlignment(0);
            imagen.scalePercent(50);
            imagen.setAbsolutePosition(10, 420);
            document.add(imagen); 

            String tex = "";
            chunk = new Chunk("\n\n\n\n\n\n\n", textobold);
            parrafo = new Paragraph(chunk);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            document.add(parrafo);
            PdfPCell celdaFinal = new PdfPCell(parrafo); 
            
            try
            {
                while(tbl.getRowCount() > i)
                {
                    
                    if (ajuste > 12)
                    {
                       
                        table.setWidthPercentage(95);
                        document.add(table);
                        document.newPage();

                        chunk = new Chunk("\n \n \n \n \n", textobold);
                        parrafo = new Paragraph(chunk);
                        parrafo.setAlignment(Element.ALIGN_CENTER);
                        document.add(parrafo);

                        imagen = Image.getInstance(iTextExampleImage);
                        imagen.setAlignment(Element.ALIGN_CENTER);
                        imagen.setAlignment(0);
                        imagen.scalePercent(50);
                        imagen.setAbsolutePosition(10, 420);
                        document.add(imagen); 

                        tex = "";
                        chunk = new Chunk("\n\n\n\n\n\n\n", textobold);
                        parrafo = new Paragraph(chunk);
                        parrafo.setAlignment(Element.ALIGN_CENTER);
                        document.add(parrafo);

                        table = new PdfPTable(3);                


                        //ESPACIOS EN BLANCO 2
                        celdaFinal = new PdfPCell(parrafo);

                        ajuste = 1;
                        x = 45;
                        y = 325;
                        i = i-1;
                        String valor = tbl.getValueAt(i, 0).toString();
                        producto p = new producto();
                        p.cargarPorId(valor);
                        //try{if (p.nombre.length() > 25) {p.nombre = p.nombre.substring(0,25) + "-\n" + p.nombre.substring(25,p.nombre.length()) + "\n\n";}
                        /*else {*/p.nombre = p.nombre + "\n\n";//} } catch(Exception ex){}
                        chunk = new Chunk("\n" + p.nombre , textochico);
                        parrafo = new Paragraph(chunk); 
                        chunk = new Chunk (" $" + p.preciounitario + " X " + p.cantidadunitaria + " U. \n\n", textochicorojo);
                        parrafo.add(chunk);
                        //parrafo.setAlignment(Element.ALIGN_RIGHT);
                        celdaFinal = new PdfPCell(parrafo); 
                        celdaFinal.setColspan(1);
                        celdaFinal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        celdaFinal.setVerticalAlignment(Element.ALIGN_CENTER);
                        celdaFinal.setBorder(Rectangle.NO_BORDER);
                        //celdaFinal.setBackgroundColor(BaseColor.WHITE);  
                        table.addCell(celdaFinal); 

                        String ruta = p.url;
                        if (p.url == null){p.url = "c:/javier/no_image.jpg";}
                        if (p.url.length() < 10){p.url = "c:/javier/no_image.jpg";}
                        imagen = Image.getInstance(p.url);
                        imagen.setAlignment(Element.ALIGN_CENTER);
                        imagen.setAlignment(0);
                        imagen.scaleToFit(125, 90);
                        imagen.setAbsolutePosition(x, y);
                        document.add(imagen); 
                        if (x == 595) {x = 45; y = y - 105;}
                        else{if (x == 325){ x = 595;}
                        else{if (x == 45){ x = 325;}}}

                    }
                    else
                    {
                       
                        String valor = tbl.getValueAt(i, 0).toString();
                        producto p = new producto();
                        p.cargarPorId(valor);
                        //try{if (p.nombre.length() > 25) {p.nombre = p.nombre.substring(0,25) + "-\n" + p.nombre.substring(25,p.nombre.length()) + "\n\n";}
                        /*else {*/p.nombre = p.nombre + "\n\n";//} } catch(Exception ex){} 
                        chunk = new Chunk("\n" + p.nombre , textochico);
                        parrafo = new Paragraph(chunk); 
                        if(p.cantidadunitaria.equals("1")){chunk = new Chunk (" $" + p.precio + " \n\n", textochicorojo);}
                        else{chunk = new Chunk (" $" + p.preciounitario + " X " + p.cantidadunitaria + " U. \n\n", textochicorojo);}
                        parrafo.add(chunk);
                        //parrafo.setAlignment(Element.ALIGN_RIGHT);
                        celdaFinal = new PdfPCell(parrafo); 
                        celdaFinal.setColspan(1);
                        celdaFinal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        celdaFinal.setVerticalAlignment(Element.ALIGN_CENTER);
                        celdaFinal.setBorder(Rectangle.NO_BORDER);
                        //celdaFinal.setBackgroundColor(BaseColor.WHITE);  
                        table.addCell(celdaFinal);

                        String ruta = p.url;
                        if (p.url == null){p.url = "c:/javier/no_image.jpg";}
                        if (p.url.length() < 10){p.url = "c:/javier/no_image.jpg";}
                        imagen = Image.getInstance(p.url);
                        imagen.setAlignment(Element.ALIGN_CENTER);
                        imagen.setAlignment(0);
                        imagen.scaleToFit(125, 90);
                        imagen.setAbsolutePosition(x, y);
                        document.add(imagen); 
                        if (x == 595) {x = 45; y = y - 105;}
                        else{if (x == 325){ x = 595;}
                        else{if (x == 45){ x = 325;}}}
                    }    
                    ajuste = ajuste + 1;
                    i++;
                }

                if (ajuste < 12)
                {
                    int cuentatres = 0;
                    if(ajuste > 3) 
                    {
                        if (ajuste >= 11)
                        {
                            ajuste = ajuste - 6;
                        }
                        else
                        {
                            if(ajuste >= 8){ajuste = ajuste - 3;}
                        }
                        cuentatres = ajuste -3;
                    }
                    else
                    {
                        cuentatres = ajuste;
                    }
                    
                    while(cuentatres < 4 && cuentatres > 1)
                    {
                            chunk = new Chunk("\n  " , textochico);
                            parrafo = new Paragraph(chunk); 
                            parrafo.add(chunk);
                            //parrafo.setAlignment(Element.ALIGN_RIGHT);
                            celdaFinal = new PdfPCell(parrafo); 
                            celdaFinal.setColspan(1);
                            celdaFinal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            celdaFinal.setVerticalAlignment(Element.ALIGN_CENTER);
                            celdaFinal.setBorder(Rectangle.NO_BORDER);
                            //celdaFinal.setBackgroundColor(BaseColor.WHITE);  
                            table.addCell(celdaFinal); cuentatres++;
                    }
                }
                table.setWidthPercentage(95);
                document.add(table);
            }
            catch(Exception ex){}
        
        
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");

        } 
        catch(Exception ex)
        {
        }
        
        
    }   
 
    
}
