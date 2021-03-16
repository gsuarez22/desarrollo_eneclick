package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


public final class Mail {
       
    // partes del mail declaradas como privadas
    private String user = "";
    private String pass = "";
    private String server = "";
    private String smtpport = "";

    public  static String value = "";
    private String destino , subject, mensaje;

    private Properties props;

    public ArrayList senders = new ArrayList();
    public ArrayList osenders = new ArrayList();
    public ArrayList attachers = new ArrayList();
    public String errores = "";
    

    //METODO QUE FUNCIONA
    public Mail(String vdestino, String vsubject, String vmensaje, String vtipo, ArrayList vadjuntos, ArrayList vreceptors, String CCO, String firma) 
    {
       errores = ""; 
       destino = vdestino;
       subject = vsubject;
       mensaje = vmensaje;

        mensaje = mensaje.replace("á", "&aacute;");
        mensaje = mensaje.replace("é", "&eacute;");
        mensaje = mensaje.replace("í", "&iacute;");
        mensaje = mensaje.replace("ó", "&oacute;");
        mensaje = mensaje.replace("ú", "&uacute;");
       
        String bod = "<html><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
        "      <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">" +
        "      <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />" +
        "  </head><body>";
                    
        mensaje = bod + " " + mensaje + "<br><br> " + firma + "</body></html>";
        
       if(vadjuntos != null){attachers = vadjuntos;}
       if(CCO.toLowerCase().equals("cco"))
       {
            if(vreceptors != null){osenders = vreceptors;} 
       }
       else
       {
            if(vreceptors != null){senders = vreceptors;}
       }
       props = new Properties();

       String seEnvio = "";
       
       if(vtipo == null || vtipo == "")
       {
            this.setPropsSIF();
            seEnvio = this.send();

            if(seEnvio.equals("") == false)
            {
              //  seEnvio = this.send2();
            }
       }
       else
       {
            this.setPropsGM();
            //seEnvio = this.send2();
       }
       
       
       
    }
    
    
    
    
    
    
    //METODOS DE ENVIO
    private void setPropsVE() 
    {
       // partes del mail declaradas como privadas
       user = "oneuymvdsistemas@vera.com.uy";
       pass = "Ch1y4s.5229-1";
       server = "smtp.vera.com.uy";
       smtpport = "587"; 
       props.setProperty("mail.smtp.host", server);
       props.setProperty("mail.smtp.port", smtpport);
       props.setProperty("mail.smtp.user", user);
       props.setProperty("mail.smtp.pass", pass);
       //props.setProperty("mail.smtp.auth", "true");
       //props.put("mail.smtp.starttls.enable","true");
    }
    
    private void setPropsANDA()
    {
       server = "smtp.gmail.com";
       smtpport = "587";
       user = "oneuymvdsistemas@gmail.com";
       pass = "25D2m1y4.491";
       props.setProperty("mail.smtp.host", "smtp.gmail.com");
       props.setProperty("mail.smtp.port", "587");
       props.setProperty("mail.smtp.user", "oneuymvdsistemas@gmail.com");
       props.setProperty("mail.smtp.pass", "25D2m1y4.491");
       props.put("mail.smtp.starttls.enable","true");
    }

    
    private void setPropsSIF()
    {
       server = "smtp.gmail.com";
       smtpport = "587";
       user = "documentos@sif.com.uy";
       pass = "V2nt1s.2021";
       props.setProperty("mail.smtp.host", "smtp.gmail.com");
       props.setProperty("mail.smtp.port", "587");
       props.setProperty("mail.smtp.user", "documentos@sif.com.uy");
       props.setProperty("mail.smtp.pass", "V2nt1s.2021");
       props.put("mail.smtp.starttls.enable","true");
    }
    
     
    private void setPropsGM() 
    {
       server = "mail.eneclick.net";
       smtpport = "25";
       user = "no-reply@eneclick.net";
       pass = "*Zkd%zV]JhUB";
       props.setProperty("mail.smtp.host", server);
       props.setProperty("mail.smtp.port", smtpport);
       props.setProperty("mail.smtp.user", user);
       props.setProperty("mail.smtp.pass", pass);
      // props.put("mail.smtp.starttls.enable","true");
    }

    
    
    
    
    //ENVIO
    public String send() 
    {
       String destinatarios = "";
       String adjuntos = "";
       String error = "";
       try 
       {
           Session session = Session.getDefaultInstance(props);
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(user));
           
           //Destinatarios
           if(senders.size() > 0)
           {
               int i = 0;
               while (i < senders.size())
                {
                    String destinatario = senders.get(i).toString();
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                    destinatarios = destinatario + ";" + destinatarios;
                    i++;
                }
           }
           else
           {
               if(destino.equals("") == false)
               {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
               }
           }
           
           //Destinatarios
           if(osenders.size() > 0)
           {
               int i = 0;
               while (i < osenders.size())
                {
                    String destinatario = osenders.get(i).toString();
                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(destinatario));
                    destinatarios = destinatario + ";" + destinatarios;
                    i++;
                }
                if (Mail.value.equals("") == false)
                {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(Mail.value));    
                }
                else
                {
                    //message.addRecipient(Message.RecipientType.TO, new InternetAddress(""));        
                }
                
           }
          
               
           message.setSubject(subject);

           if(attachers.size() > 0)
           {
           
                MimeMultipart multiParte = new MimeMultipart();
                BodyPart ad = new MimeBodyPart();
                for (int i=0 ; i < attachers.size() ; i++)
                {
                     adjuntos adj = (adjuntos)attachers.get(i);
                     if (adj.adjunto.equals("") == false)
                     { 
                         ad = new MimeBodyPart();
                         ad.setDataHandler(new DataHandler(new FileDataSource(adj.adjunto)));
                         ad.setFileName(adj.nombre);
                         
                         if( adj.nombre.substring(adj.nombre.length() - 3,adj.nombre.length()).toLowerCase().equals("jpg") || adj.nombre.substring(adj.nombre.length() - 3,adj.nombre.length()).toLowerCase().equals("png"))
                         {
                            ad.setHeader("Content-ID", "<img_cid>");
                         }
                         multiParte.addBodyPart(ad);
                         adjuntos = adj.nombre + ";" + adjuntos;
                     }
                }

                //Texto
                BodyPart texto = new MimeBodyPart();
                texto.setText(mensaje);
                texto.setContent(mensaje, "text/html");

                //message.setContent(mensaje, "text/html");
                multiParte.addBodyPart(texto);

                message.setContent(multiParte, "html");
           }
           else
           {
                message.setContent(mensaje, "text/html");
           }
 
           Transport t = session.getTransport("smtp");
           t.connect(user, pass);
           t.sendMessage(message, message.getAllRecipients());
           t.close();

           error = "";
       } 
       catch (Exception e) 
       {
           error = e.toString();
           errores = error;
       }
       
       BD unb = new BD();
       unb.sistema = "MAIL";
       unb.usuario = "AUTOMATICO";
       mensaje = mensaje.replace("'", "-");
       unb.StoreProcedure("insert into a_mails (de, para, asunto, mensaje, adjuntos, error) VALUES ('" + this.user + "', '" + destinatarios + "','" + subject + "','" + mensaje + "','" + adjuntos + "','" + error + "')","sif_ticket");

       return error;
       
    } 
               
}
