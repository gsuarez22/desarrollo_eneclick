
package gui;

import domain.Mail;
import domain.adjuntos;
import domain.clubes;
import domain.recaudador;
import fubb.sys.ComponentesLista;
import java.awt.Dimension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmClubes extends javax.swing.JFrame {

    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("CLUBES    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(950, 530)); 
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select ID, NOMBRE, CUENTA, MAIL from fubb.clubes", tbl);
    }
    
    public frmClubes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        cmdsearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txttexto = new javax.swing.JTextArea();
        chkDesc = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 910, 170);

        jLabel1.setText("ARCHIVOS:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 20);
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(80, 10, 510, 20);

        cmdsearch.setText("...");
        cmdsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsearchActionPerformed(evt);
            }
        });
        getContentPane().add(cmdsearch);
        cmdsearch.setBounds(590, 10, 30, 23);

        jButton1.setText("ENVIAR MAILS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(790, 10, 130, 23);

        txttexto.setColumns(20);
        txttexto.setLineWrap(true);
        txttexto.setRows(5);
        txttexto.setText("Buenas tardes,  \n\nAdjunto estamos enviando el Estado de Cuenta de su club correspondiente al mes de ----- . \nRecordamos que en caso de que su equipo cuente con un saldo a pagar el último plazo para \nrealizar el pago por el monto adeudado al mes de ---- es el día --- de -------\n\nDe no cumplir con el plazo estipulado anteriormente se procederá a aplicar lo establecido en las normas del Ordenamiento Financiero.\n\nDesde ya quedamos a las órdenes por cualquier diferencia y/o consulta en relación a la información enviada, por igual vía al correo electrónico consultastesoreria@fubb.org.uy y en caso de ser necesario, posteriormente coordinar una reunión.\n \nAgradecemos realizar acuso de recibo,\n\nDesde ya muchas gracias,\n\nSaluda atentamente,\nCr. Ignacio Lapaz\nconsultastesoreria@fubb.org.uy");
        txttexto.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txttexto);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(6, 40, 920, 220);

        chkDesc.setText("Desconectado de la BD");
        chkDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkDescMouseClicked(evt);
            }
        });
        getContentPane().add(chkDesc);
        chkDesc.setBounds(620, 270, 200, 23);

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(820, 270, 100, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsearchActionPerformed
        // TODO add your handling code here:
        frmSelectorA unS = new frmSelectorA();
        unS.abrir(this);
    }//GEN-LAST:event_cmdsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        File dir = new File (lblArchivo.getText());
        String[] ficheros = dir.list(); 
        if (ficheros == null)
        {
            JOptionPane.showMessageDialog(null, "No hay ficheros en el directorio especificado");
        }
        else 
        { 
            for (int x=0;x<ficheros.length;x++)
            {
                try
                {
                    String archivo = ficheros[x];
                    String archivoenviar = ficheros[x];
                    archivo = archivo.substring(0, 8);
                    archivo = archivo.replace(" ", "");
                    String mailto = MisCorreos(archivo);

                    ArrayList pers = new ArrayList();
                    String cco = mailto.replace(",", ";");

                    String mails [] = cco.split(";");

                    for(int i = 0; mails.length > i; i++)
                    {
                        //cuando hay un solo registro el ultimo esta en blanco y no hay que agregarlo
                        String to = mails[i];
                        to = to.replace(" ", "");
                        if (to.equals("") == false)
                        {
                            pers.add(to);
                            //pers.add(mails[i]);
                        }
                    }

                    Date d = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d); // Configuramos la fecha que se recibe
                    calendar.add(Calendar.DAY_OF_YEAR, - 28);
                    SimpleDateFormat formateador = new SimpleDateFormat("MMMM"); 
                    Date desde = calendar.getTime();

                    String fec = formateador.format(desde);

                    String textin = txttexto.getText().replace("\n", "<br>");
                    String bod = "<H3>Estimados: " + MiNombre(archivo) + "<br>" + textin;

                    String asunto = "ESTADO DE CUENTA " + archivo;

                    if(mails.length >= 1)
                    {
                        ArrayList unL = new ArrayList();
                        adjuntos ad = new adjuntos();
                        ad.nombre = archivoenviar;
                        ad.adjunto = lblArchivo.getText() + archivoenviar;
                        unL.add(ad);

                        Mail unM = new Mail ("", asunto, bod, "", unL, pers, "CC", "");                
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cuenta " + archivo + " sin email asosciado");
                    }
                    archivoenviar = "";
                }
                catch(Exception ex)
                {
                
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarDesconectada()
    {
        ArrayList unL = new ArrayList();
        clubes unC = new clubes();
        
        unC.cuenta = "1141003"; unC.nombre = "Olimpia"; unC.mail = "jbarrio@bntours.com;fstagnari@olimpia.uy;mcaretti@olimpia.uy;";unL.add(unC); unC = new clubes();
        unC.cuenta = "1141006"; unC.nombre = "Aguada"; unC.mail = "secretaria.aguada@hotmail.com;cardinarb@hotmail.com;mcdanielolivera@gmail.com;hernan@distrishop.com.uy;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141009"; unC.nombre = "Trouville "; unC.mail = "fbf.fev@adinet.com:federicorestuccia@gmail.com;alebertolini@gmail.com;pineyro.marcelo@uy.sika.com;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141013"; unC.nombre = "Nacional"; unC.mail = "arielmartinezcr@gmail.com;valepertusatti@gmail.com;damina7903@hotmail.com;camilomaidanalauz@gmail.com;" ;unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141014"; unC.nombre = "Bigua"; unC.mail = "joseg@farmed.com.uy;y.mendoza@bigua.com.uy;administracion@bigua.com.uy;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141015"; unC.nombre = "Defensor Sporting"; unC.mail = "gabi1@adinet.com.uy;eduardo@orvent.com.uy;josebonanata@gmail.com;fernandesnacho@gmail.com;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141018"; unC.nombre = "Goes"; unC.mail = "goesriver22@gmail.com;fpiazzaesgorlo@hotmail.com;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141021"; unC.nombre = "Capitol"; unC.mail = "cgarbuyo@notusdigital.com;quiquedugros@hotmail.com;alelopez@adinet.com.uy;spelufo@gmail.com;clubsportivocapitol@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1141024"; unC.nombre = "Malvin"; unC.mail = "ssomma@santarosa.com.uy;msomma@clubmalvin.uy;ebravo@clubmalvin.uy;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141026"; unC.nombre = "Peñarol"; unC.mail = "basket@capenarol.com.uy;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141033"; unC.nombre = "Hebraica y Macabi"; unC.mail = "daugustower@gmail.com;bloopers@vera.com.uy;akam@montevideo.com.uy;pedro@grauser.com.uy;Admin@hebraicamacabi.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1141035"; unC.nombre = "Urunday Universitario"; unC.mail = "basquetbol@urundayuniversitario.com;lsarachu0@gmail.com;";unL.add(unC);  unC = new clubes();
        unC.cuenta = "1141052"; unC.nombre = "M iramar"; unC.mail = "jardinmitai@hotmail.com;nicofm1@hotmail.com;paromahe@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142004"; unC.nombre = "Stockolmo"; unC.mail = "adepalma@adinet.com.uy;reytru@hotmail.com;castockolmo@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142007"; unC.nombre = "Union Atlética"; unC.mail = "sciuto@tiemponuevo.com.uy;jfilevich@ancap.com.uy;jorgedel@montevideo.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142016"; unC.nombre = "Tabaré"; unC.mail = "nicomay@hotmail.com;barrioscarlos1987@gmail.com;nicoalba1@gmail.com;alejo2112@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142020"; unC.nombre = "Sayago"; unC.mail = "mrusconicorbo@gmail.com;dvillero@gmail.com;alesilva25@hotmail.com;clubsayago1923@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142022"; unC.nombre = "Larre Borges"; unC.mail = "hecassir@gmail.com;javier.assir@gmail.com;info@larreborges.org.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142032"; unC.nombre = "Colón FC"; unC.mail = "info@colonfc.com;alejandro@verdesoft.com.uy;danielmesa@hotmail.com;rovebl71@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142036"; unC.nombre = "Olivol Mundial"; unC.mail = "noseramucho-@hotmail.com;gzannier@adinet.com.uy;Nicodeolivol@gmail.com;carlypala2014@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142038"; unC.nombre = "Cordón"; unC.mail = "nitocapo@adinet.com.uy;gag1973@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142044"; unC.nombre = "Verdirrojo"; unC.mail = "horacioparodi77@gmail.com;gabriela.vargas1966@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142054"; unC.nombre = "25 de Agosto"; unC.mail = "damianpirrocco@gmail.com;rborio@yahoo.com;c.a.25deagosto1948@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142061"; unC.nombre = "Urupan"; unC.mail = "fernando.alzugaray@urupan.com.uy;pablo.casanova@intel.com;info@urupan.com.uy ;Jorgedl30@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142079"; unC.nombre = "Lagomar Country Club"; unC.mail = "clagomar@adinet.com.uy;hhcruz@adinet.com.uy;lagomarcc@vera.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1142101"; unC.nombre = "Danubio F.C."; unC.mail = "castellucci.adrian1932@gmail.com;valentina3071993@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143002"; unC.nombre = "Atenas"; unC.mail = "";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143008"; unC.nombre = "Welcome"; unC.mail = "club.a.welcome@gmail.com;copello23@gmail.com;doseme02@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143012"; unC.nombre = "Reducto"; unC.mail = "csdreducto@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143017"; unC.nombre = "Bohemios"; unC.mail = "meijonlaplace@gmail.com;nachopla2014@gmail.com;jorgebonelli2012@gmail.com;gerencia@bohemios.com.uy;basquetbol@bohemios.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143019"; unC.nombre = "Montevideo"; unC.mail = "nelson.martella@uruglass.com;hebalsas1@hotmail.com;eduardosava20@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143027"; unC.nombre = "Yale"; unC.mail = "renatotab@hotmail.com;mjdelucchi@gmail.com;alozano@adinet.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143028"; unC.nombre = "Albatros"; unC.mail = "anodursrl@gmail.com;clubd.albatros@gmail.com;panduru14@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143030"; unC.nombre = "Larrañaga"; unC.mail = "josemab@adinet.com.uy;larra.secretaria@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143043"; unC.nombre = "Capurro"; unC.mail = "lvargas@adinet.com.uy;clubcapurro@hotmail.com;cacapurro1943@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143047"; unC.nombre = "Marne"; unC.mail = "danicas1964@hotmail.com;cafidesi@hotmail.com;victorcorreasoca@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143055"; unC.nombre = "Auriblanco"; unC.mail = "joselavalleja@gmail.com;mato@ort.edu.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143088"; unC.nombre = "San Telmo Rápido Sport"; unC.mail = "alussich@montevideo.com.uy;lato_carro@hotmail.com;labrujafabian@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1143098"; unC.nombre = "Deportivo Paysandú"; unC.mail = "tabatorrano@gmail.com;mauricio.bonelli@gmail.com;cdpaysandu@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1144513"; unC.nombre = "Liga de Maldonado"; unC.mail = "OPTICAMALDONADO-PERBAT@ADINET.COM.UY;GESTORSILVABAEZ@GMAIL.COM;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1144514"; unC.nombre = "Liga de Soriano"; unC.mail = "ligadesoriano@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1144517"; unC.nombre = "Liga de Paysandú"; unC.mail = "apiaggio@adinet.com.uy;basquetpay@adinet.com.uy;becejolu@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1144519"; unC.nombre = "Liga de Salto"; unC.mail = "ligasaltobasquet@yahoo.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1145060"; unC.nombre = "Club de Remeros Mercedes"; unC.mail = "remeros@adinet.com.uy;panchomargalef@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1146103"; unC.nombre = "Asociación de Veteranos"; unC.mail = "dcladera@montevideo.com.uy;crgorondona@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147034"; unC.nombre = "Defensores de Maroñas"; unC.mail = "ferrebelloni@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147050"; unC.nombre = "Layva"; unC.mail = "b.b.c.layva@gmail.com;arq.cesarpadilla@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147062"; unC.nombre = "Juventud de las Piedras"; unC.mail = "jmaldo@vera.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147068"; unC.nombre = "Plaza Nueva Helvecia"; unC.mail = "carfontb@gmail.com;facuchava@hotmail.com;martinabraham68@yahoo.com.ar;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147075"; unC.nombre = "Náutico Punta Gorda"; unC.mail = "direcciondeportiva@clubnautico.com;sebmartinez07@gmail.com ;lghirardelli@clubnautico.com.uy;compras@clubnautico.com.uy;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147090"; unC.nombre = "Sparta de Minas"; unC.mail = "oscartel@vera.com.uy;spartaminas1928@gmail.com;rodige@gmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147097"; unC.nombre = "Country el Pinar"; unC.mail = "ta-macla@hotmail.com; mcastro1963@hotmail.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1147104"; unC.nombre = "Club Banco Republica"; unC.mail = "mariela@clubbancorepublica.com;julio@clubbancorepublica.com;";unL.add(unC);unC = new clubes();
        unC.cuenta = "1148102"; unC.nombre = "Liga Universitaria"; unC.mail = "paul.emery@ligauniversitaria.org.uy;matias.garcia@ligauniversitaria.org.uy;deportes@ligauniversitaria.org.uy;";unL.add(unC); unC = new clubes();unC = new clubes();
    
        cargarTablaDesc(unL);
    }
    
    public void cargarTablaDesc(ArrayList unL)
    {
        try
        {
            Vector v = new Vector();
            
            DefaultTableModel tableModel = new DefaultTableModel(0,4);
            
            v.add("ID"); v.add("NOMBRE"); v.add("CUENTA"); v.add("MAIL");
            tableModel.setColumnIdentifiers(v);

            int i = 0;
            
            try
            {
                while (unL.size() > i) 
                {
                    clubes P = (clubes) unL.get(i);
                    Vector ar = new Vector();
                    ar.add (P.id); ar.add(P.nombre); ar.add(P.cuenta); ar.add(P.mail); 
                    tableModel.addRow(ar);
                    i++; 
                }
            }catch(Exception ex){}    
            
                        
            tbl.setModel(tableModel);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tbl.getModel());
            tbl.setRowSorter(sorter);
        
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
    }
    
    private void chkDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkDescMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_chkDescMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(chkDesc.isSelected())
        {
            cargarDesconectada();
        }
        else
        {
            ComponentesLista unC = new ComponentesLista();
            unC.cargarTabla("Select ID, NOMBRE, CUENTA, MAIL from fubb.clubes", tbl);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkDesc;
    private javax.swing.JButton cmdsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txttexto;
    // End of variables declaration//GEN-END:variables

    private String MisCorreos(String archivo) 
    {
        String flag = "";
        int i = 0;
        while (i < tbl.getRowCount())
        {
            String cuenta = tbl.getValueAt(i, 2).toString();
            if(cuenta.equals(archivo))
            {
                flag = tbl.getValueAt(i, 3).toString();
                i = tbl.getRowCount();
            }
            i++;
        }
        return flag;
    }
    
    private String MiNombre(String archivo) 
    {
        String flag = "";
        int i = 0;
        while (i < tbl.getRowCount())
        {
            String cuenta = tbl.getValueAt(i, 2).toString();
            if(cuenta.equals(archivo))
            {
                flag = tbl.getValueAt(i, 1).toString();
                i = tbl.getRowCount();
            }
            i++;
        }
        return flag;
    }
        
}
