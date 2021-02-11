/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fubb.sys.ComponentesLista;
import fubb.sys.DBSSH;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sistemas
 */
public class frmPartidosNuevo extends javax.swing.JFrame {

    /**
     * Creates new form frmPartidosNuevo
     */
    public frmPartidosNuevo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        dtpDesde = new com.toedter.calendar.JDateChooser();
        dtpHasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
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
        jScrollPane1.setBounds(10, 40, 800, 500);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 10, 110, 23);
        getContentPane().add(dtpDesde);
        dtpDesde.setBounds(50, 10, 90, 20);
        getContentPane().add(dtpHasta);
        dtpHasta.setBounds(200, 10, 95, 20);

        jLabel1.setText("Hasta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 50, 20);

        jLabel2.setText("Desde");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 40, 20);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LUB", "METRO", "DTA", "LIGA FEMENINA", "SUB 21", "FORMATIVAS MASCULINA", "FORMATIVAS FEMENINA", "VETERANOS", "LIGA UNIVERSITARIA", "LIGA SORIANO", "LIGA MALDONADO", "LIGA SALTO" }));
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(510, 10, 200, 20);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(720, 10, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     String usuario = "";
    
    public void abrir(String usu)
    {
        usuario = usu;
        this.setVisible(true);
        this.setTitle("PARTIDOS   (" + usuario + ")  -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 600)); 
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        resetear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resetear()
    {
        SimpleDateFormat unF = new SimpleDateFormat("yyyy-MM-dd");
        String desde = unF.format(dtpDesde.getDate());
        String hasta = unF.format(dtpHasta.getDate());

        String url = "Select p.id_partido as ID, p.TIPO, p.nomenclator as TITULO, c.nombre_cancha AS CANCHA, e1.nombre as LOCAL, e2.nombre as VISITANTE, DATE_FORMAT(p.fecha_hora, '%d/%m/%Y %H:%i') as FECHA , p.tv as TV " + 
        "from fubb.partidos p " +
        "left join fubb.equipos e1 on p.local = e1.id_equipo " +
        "left join fubb.equipos e2 on p.visitante = e2.id_equipo " +
        "left join fubb.canchas c on c.id_cancha = p.cancha " + 
        "where fecha_hora >= '" + desde + " 00:00:00' and fecha_hora <= '" + hasta + " 23:59:59' order by p.tipo, p.fecha_hora";                
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla(url, tbl);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList updates = new ArrayList();
        
        for(int i = 0; i < tbl.getSelectedRowCount(); i++)
        {
            int x = 0;
            String id = tbl.getValueAt(tbl.getSelectedRows()[i], 0).toString();
            String url = "UPDATE fubb.partidos set tipo = '" + cmbTipo.getSelectedItem().toString() + "' where id_partido = '" + id + "'";
            updates.add(url);
        }

        if(updates.size() > 0)
        {
            DBSSH unb = new DBSSH();
            unb.Todos(updates);
            resetear();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPartidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPartidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPartidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPartidosNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPartidosNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTipo;
    private com.toedter.calendar.JDateChooser dtpDesde;
    private com.toedter.calendar.JDateChooser dtpHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
