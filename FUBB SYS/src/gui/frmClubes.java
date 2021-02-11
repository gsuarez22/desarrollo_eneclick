
package gui;

import domain.Mail;
import domain.adjuntos;
import fubb.sys.ComponentesLista;
import java.awt.Dimension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

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
        jScrollPane1.setBounds(10, 270, 910, 200);

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
                    String to = mails[i];
                    to = to.replace(" ", "");
                    pers.add(mails[i]);
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
        
                if(mails.length > 1)
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
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void completarArchivo(String string, String name)
    {
        lblArchivo.setText(string);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdsearch;
    private javax.swing.JButton jButton1;
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
