
package gui;

import dominio.BD;
import dominio.ComponentesLista;
import dominio.controlador;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import javax.swing.Timer;


public class frmPedidos extends javax.swing.JFrame {

    public controlador miControlador;
    
    public void abrir(controlador unC)
    {
        miControlador = unC;
        this.setVisible(true);
        this.setTitle("CANTEGRILL - Elaborados");
        this.setMinimumSize(new Dimension(800, 600)); 
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        this.setIconImage(icon);    
        reset();
        abrirTimer();
    }    

    public frmPedidos() {
        initComponents();
    }

    public void reset()
    {
        ComponentesLista unc = new ComponentesLista();
        unc.cargarTabla("SELECT id, nombre FROM articulos WHERE estado = 'v' ORDER BY nombre", tblv);
        unc.cargarTabla("SELECT id, nombre FROM articulos WHERE estado = 'r' ORDER BY nombre", tblr);
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblr = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblv = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tblr.setBackground(new java.awt.Color(255, 204, 204));
        tblr.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(450, 20, 330, 440);

        tblv.setBackground(new java.awt.Color(153, 255, 153));
        tblv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblv);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 20, 340, 440);

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 240, 50, 23);

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 190, 50, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = 0;
        ArrayList una = new ArrayList();
        while (i < tblv.getSelectedRowCount())
        {
            String id = tblv.getValueAt(tblv.getSelectedRows()[i], 0).toString();
            una.add("update articulos set estado = 'r' where id = '" + id + "'");
            i++;
        }
        BD unb = new BD();
        unb.Todos(una, "cantegrill");
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int i = 0;
        ArrayList una = new ArrayList();
        while (i < tblr.getSelectedRowCount())
        {
            String id = tblr.getValueAt(tblr.getSelectedRows()[i], 0).toString();
            una.add("update articulos set estado = 'v' where id = '" + id + "'");
            i++;
        }
        BD unb = new BD();
        unb.Todos(una, "cantegrill");
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

   //public int cantidadActual = 0;

    public Timer timer = new Timer (60000, new ActionListener ()
    {
        public void actionPerformed(ActionEvent e)
        {
            //int pivot = cantidadActual;
            reset();
            //if(pivot != cantidadActual)
            //{
            //    pivot = cantidadActual - pivot;
                //JOptionPane.showMessageDialog(null, "Tabla Actualizada con " + pivot + " ticket de diferencia");
            //}
        }
    });


    
    public void abrirTimer()
    {
        timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblr;
    private javax.swing.JTable tblv;
    // End of variables declaration//GEN-END:variables
}
