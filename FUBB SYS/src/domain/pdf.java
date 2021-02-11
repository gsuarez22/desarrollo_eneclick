/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
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
    private static final Font textochico = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
    private static final Font textochicos = new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL);
    
    private static final String iTextExampleImage = "C:\\fubb\\logosueldos.png";
        
    public void memo (sueldo s)
    {
        try 
        {
            Document document = new Document(PageSize.A4, 36, 54, 36, 54);
            Paragraph parrafo;
            String rut = "C:\\fubb\\jueces\\" + s.numero + ", Recibo " + s.nombre + " Fecha " + s.mesliquidado.replace("/", "-").toString() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(rut));

            document.open();

            document.addTitle("Recibo de Sueldo");
            document.addSubject("FUBB");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("IT FUBB");
            document.addCreator("FUBB");
                 
            Image imagen = Image.getInstance(iTextExampleImage);
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.setAlignment(0);
            imagen.scalePercent(45);
            
            document.add(imagen);    
            
            String tex = "";
            Chunk chunk;
            try
            {
                chunk = new Chunk("\n");
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                                
                PdfPTable table = new PdfPTable(8);
                
                PdfPCell celdaFinal = new PdfPCell(parrafo);
                //celdaFinal.setColspan(19);
                celdaFinal.setBackgroundColor(BaseColor.WHITE);
                celdaFinal.setBorder(0);
                
                //LINEA 1
                chunk = new Chunk("NRO:" + s.numero, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0); table.addCell(celdaFinal);
                chunk = new Chunk(s.nombre, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Mes Liquidado:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.mesliquidado, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cobro:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.cobro, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 2
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 3
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Categoría:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("JUECES", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 4
                chunk = new Chunk("JORNAL:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.jornal, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cargo:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Juez Oficial", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 5
                chunk = new Chunk("PRESENTISMO:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.presentismo, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cédula de Identidad:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.cedula, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
   
                //LINEA 5
                chunk = new Chunk("ANTIGUEDAD:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.antiguedad, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);   table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Fecha Ingreso:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.fecIngreso, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 6
                chunk = new Chunk("TOTAL DE HABERES:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.totalhaberes, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 7 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 8
                chunk = new Chunk("Cant. de Jornales:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("0", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("BPS: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.bps, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
             
                //LINEA 9
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("SNIS: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.snis, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 10
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("FRL: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.frl, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 11
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("FONDO 4%: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.fondo, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Firma:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 12
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Retención Judicial:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.judicial, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                
                //LINEA 13
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("DTO IRPF:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.irpf, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 14
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Otras Retenciones:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.retencion, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                
                //LINEA 15
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("ANDA:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.anda, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 16 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 17 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 18
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("TOTAL DTOS:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.totaldto, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 19 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 20 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 21
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("LIQ. A COBRAR:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
               s.a_cobrar = s.a_cobrar.replace(",,", ",");
                chunk = new Chunk(s.a_cobrar, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                
                table.setWidthPercentage(99);
                document.add(table);

                String text = "\n\n"
                        + "La empresa declara haber efectuado los aportes de Seguridad Social correspondiente a los haberes liquidados								\n" 
                        + "\nal trabajador del mes anterior, según decreto 337/992.								\n" 
                        + "\nEste Recibo tiene valor de Resguardo a Efectos Impositivos - 					Fecha Valor:		Fecha de Pago:	" + s.cobro + "\n" 
                        + "\n" 
                        + "\nMonto Gravado: $		" + s.totalhaberes + "						";
                
                chunk = new Chunk(text, texto);
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                
                document.newPage();
                
                chunk = new Chunk("\n\nDETALLE\n\n");
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                                
                table = new PdfPTable(5);
                
                celdaFinal = new PdfPCell(parrafo);
                //celdaFinal.setColspan(19);
                celdaFinal.setBackgroundColor(BaseColor.WHITE);
                
                //LINEA 1
                chunk = new Chunk("FECHA", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("CONCEPTO", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("DEBE", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("HABER", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("SALDO", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                
                int i = 0;
                
                while(i < s.detalle.size())
                {
                    detallesueldo ss = (detallesueldo) s.detalle.get(i);
                    chunk = new Chunk(ss.fecha, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.concepto, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.debe1, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.haber, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.saldo1, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    
                    i++;
                }
                
                table.setWidthPercentage(99);
                document.add(table);
                
                document.close();
                System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");

                //Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ rut);

            
            } 
            catch (Exception ex) 
            {
                       
            }
        } 
        catch (Exception ex) 
        {
                       
        }
    }
    
    public void memolic (sueldo s)
    {
        try 
        {
            Document document = new Document(PageSize.A4, 36, 54, 36, 54);
            Paragraph parrafo;
            String rut = "C:\\fubb\\jueces\\" + s.numero + ", Recibo " + s.nombre + " Fecha " + s.mesliquidado.replace("/", "-").toString() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(rut));

            document.open();

            document.addTitle("Recibo de Sueldo");
            document.addSubject("FUBB");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("IT FUBB");
            document.addCreator("FUBB");
                 
            Image imagen = Image.getInstance(iTextExampleImage);
            imagen.setAlignment(Element.ALIGN_CENTER);
            imagen.setAlignment(0);
            imagen.scalePercent(45);
            
            document.add(imagen);    
            
            String tex = "";
            Chunk chunk;
            try
            {
                chunk = new Chunk("\n");
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                                
                PdfPTable table = new PdfPTable(8);
                
                PdfPCell celdaFinal = new PdfPCell(parrafo);
                //celdaFinal.setColspan(19);
                celdaFinal.setBackgroundColor(BaseColor.WHITE);
                celdaFinal.setBorder(0);
                
                //LINEA 1
                chunk = new Chunk("NRO:" + s.numero, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0); table.addCell(celdaFinal);
                chunk = new Chunk(s.nombre, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Mes Liquidado:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.mesliquidado, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cobro:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.cobro, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 2
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("\n\n", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 3
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Categoría:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("JUECES", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 4
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cargo:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Juez Oficial", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 5
                chunk = new Chunk("LICENCIA:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.licencia, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Cédula de Identidad:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.cedula, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
   
                //LINEA 5
                chunk = new Chunk("SALARIO VACACIONAL:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(" ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.salario, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);   table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Fecha Ingreso:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.fecIngreso, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                //LINEA 6
                chunk = new Chunk("TOTAL DE HABERES:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.totalhaberes, tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 7 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 8
                chunk = new Chunk("Cant. de Jornales:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("0", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("BPS: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.bps, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
             
                //LINEA 9
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("SNIS: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.snis, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 10
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("FRL: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.frl, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 11
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("FONDO 4%: ", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.fondo, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Firma:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 12
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Retención Judicial:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.judicial, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                
                //LINEA 13
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("DTO IRPF:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.irpf, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 14
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("Otras Retenciones:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.retencion, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                
                //LINEA 15
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("ANDA:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.anda, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 16 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 17 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 18
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("TOTAL DTOS:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk(s.totaldto, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 19 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 20 BLANCA
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);  chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal); chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                //LINEA 21
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss); parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("LIQ. A COBRAR:", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
               s.a_cobrar = s.a_cobrar.replace(",,", ",");
                chunk = new Chunk(s.a_cobrar, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);
                chunk = new Chunk("", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(0);  table.addCell(celdaFinal);

                
                table.setWidthPercentage(99);
                document.add(table);

                String text = "\n\n"
                        + "La empresa declara haber efectuado los aportes de Seguridad Social correspondiente a los haberes liquidados								\n" 
                        + "\nal trabajador del mes anterior, según decreto 337/992.								\n" 
                        + "\nEste Recibo tiene valor de Resguardo a Efectos Impositivos - 					Fecha Valor:		Fecha de Pago:	" + s.cobro + "\n" 
                        + "\n" 
                        + "\nMonto Gravado: $		" + s.totalhaberes + "						";
                
                chunk = new Chunk(text, texto);
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                /*
                document.newPage();
                
                chunk = new Chunk("\n\nDETALLE\n\n");
                parrafo = new Paragraph(chunk);
                document.add(parrafo);
                                
                table = new PdfPTable(5);
                
                celdaFinal = new PdfPCell(parrafo);
                //celdaFinal.setColspan(19);
                celdaFinal.setBackgroundColor(BaseColor.WHITE);
                
                //LINEA 1
                chunk = new Chunk("FECHA", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("CONCEPTO", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("DEBE", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("HABER", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                chunk = new Chunk("SALDO", tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.YELLOW); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                
                int i = 0;
                
                while(i < s.detalle.size())
                {
                    detallesueldo ss = (detallesueldo) s.detalle.get(i);
                    chunk = new Chunk(ss.fecha, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.concepto, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.debe1, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.haber, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    chunk = new Chunk(ss.saldo1, tituloss);  parrafo = new Paragraph(chunk);  celdaFinal = new PdfPCell(parrafo); celdaFinal.setColspan(1); celdaFinal.setBackgroundColor(BaseColor.WHITE); celdaFinal.setBorder(1); table.addCell(celdaFinal);
                    
                    i++;
                }
                
                table.setWidthPercentage(99);
                document.add(table);
                */
                document.close();
                System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");

                //Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ rut);

            
            } 
            catch (Exception ex) 
            {
                       
            }
        } 
        catch (Exception ex) 
        {
                       
        }
    }
    
}
