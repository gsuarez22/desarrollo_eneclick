package domain;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;

public class SFTPFile
{

    public void ftp()
    {
        String user = "root";
        String password = "salu2carrito";
        String host = "179.27.99.90";
        int port=22;

        String remoteFile="/var/www/lubb/storage/documentos/jueces";

        try
        {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
                session.setPassword(password);
                session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
                System.out.println("Connection established.");
            System.out.println("Creating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            sftpChannel.cd(remoteFile);
           
            File f = new File("C:/fubb/jueces/");
            File[] ficheros = f.listFiles();
            for (int x=0;x<ficheros.length;x++)
            {
                File ff = ficheros[x];
                String [] v = ff.getName().split(",");
                String carpeta = v[0];  
                try{sftpChannel.mkdir(remoteFile + "/" + carpeta);
                sftpChannel.chmod(333, remoteFile + "/" + carpeta);}catch(Exception ex){}
                try{sftpChannel.cd(remoteFile + "/" + carpeta);
                sftpChannel.put(new FileInputStream(ff), ff.getName());}catch(Exception ex){}
                //permisos sobre los archivos
                String nom = ff.getName().replace("C:\\fubb\\jueces\\", "");
                try
                {
                    sftpChannel.chmod(644, remoteFile + "/" + carpeta + "/" + nom);
                }
                catch(Exception ex)
                {
                 System.out.println(ex.toString());
                }
                
                System.out.println("File transfered successfully to host.");
            }       
            
            sftpChannel.disconnect();
           
        }
        catch(Exception e){System.err.print(e);}
        }
   }