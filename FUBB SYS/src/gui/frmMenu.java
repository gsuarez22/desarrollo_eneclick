package gui;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class frmMenu extends javax.swing.JFrame {

    public frmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuProcesarFijacion = new javax.swing.JMenuItem();
        mnuSubirFijación = new javax.swing.JMenuItem();
        mnuPartidos = new javax.swing.JMenuItem();
        mnuRecaudadores = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuSueldos = new javax.swing.JMenuItem();
        mnuClubes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\fubb\\logo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 810, 340);

        jMenu1.setText("Operaciones");

        mnuProcesarFijacion.setText("Procesar Fijación");
        mnuProcesarFijacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProcesarFijacionActionPerformed(evt);
            }
        });
        jMenu1.add(mnuProcesarFijacion);

        mnuSubirFijación.setText("Subir Fijación");
        mnuSubirFijación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSubirFijaciónActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSubirFijación);

        mnuPartidos.setText("Partidos");
        mnuPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPartidosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuPartidos);

        mnuRecaudadores.setText("Recaudadores");
        mnuRecaudadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecaudadoresActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRecaudadores);

        jMenuItem1.setText("Designacion Arbitral");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tesoreria");

        mnuSueldos.setText("Recibos de Sueldo");
        mnuSueldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSueldosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuSueldos);

        mnuClubes.setText("Clubes");
        mnuClubes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClubesActionPerformed(evt);
            }
        });
        jMenu2.add(mnuClubes);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String usuario = "";
    
    public void abrir(String usu)
    {
        usuario = usu;
        this.setVisible(true);
        this.setTitle("MENU   (" + usuario + ")  -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 500)); 
    }
    
    private void mnuProcesarFijacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProcesarFijacionActionPerformed
        // TODO add your handling code here:
        if(usuario.equals("secretaria"))
        {
            frmConvertirExcel unF = new frmConvertirExcel();
            unF.abrir();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
     
    }//GEN-LAST:event_mnuProcesarFijacionActionPerformed

    private void mnuPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPartidosActionPerformed
        // TODO add your handling code here:
        if(usuario.equals("secretaria"))
        {
            frmPartidosNuevo unP = new frmPartidosNuevo();
            unP.abrir(usuario);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
    }//GEN-LAST:event_mnuPartidosActionPerformed

    private void mnuSueldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSueldosActionPerformed
        // TODO add your handling code here:
        if(usuario.equals("contaduria"))
        {
            frmSueldos unS = new frmSueldos();
            unS.abrir();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
    }//GEN-LAST:event_mnuSueldosActionPerformed

    private void mnuSubirFijaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSubirFijaciónActionPerformed
        // TODO add your handling code here:
        if(usuario.equals("secretaria"))
        {
            frmSubirFijacion unF = new frmSubirFijacion();
            unF.abrir();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
    }//GEN-LAST:event_mnuSubirFijaciónActionPerformed

    private void mnuRecaudadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecaudadoresActionPerformed
        // TODO add your handling code here:
        if(usuario.equals("secretaria"))
        {
            frmRecaudadores unF = new frmRecaudadores();
            unF.abrir();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
    }//GEN-LAST:event_mnuRecaudadoresActionPerformed

    private void mnuClubesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClubesActionPerformed
        // TODO add your handling code here:
        frmClubes unC = new frmClubes();
        unC.abrir();
    }//GEN-LAST:event_mnuClubesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        if(usuario.equals("secretaria"))
        {
            frmDesignacionArbitral unF = new frmDesignacionArbitral();
            unF.abrir(usuario);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Acceso denegado");
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnuClubes;
    private javax.swing.JMenuItem mnuPartidos;
    private javax.swing.JMenuItem mnuProcesarFijacion;
    private javax.swing.JMenuItem mnuRecaudadores;
    private javax.swing.JMenuItem mnuSubirFijación;
    private javax.swing.JMenuItem mnuSueldos;
    // End of variables declaration//GEN-END:variables
}
