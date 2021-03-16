package gui;

import domain.usuarios;
import java.awt.Dimension;

public class frmMenu extends javax.swing.JFrame {
    
    public frmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuReserva = new javax.swing.JMenu();
        mnuEntidades = new javax.swing.JMenuItem();
        mnuReservas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mnuReserva.setText("Mantenimiento");

        mnuEntidades.setText("Entidades");
        mnuEntidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEntidadesActionPerformed(evt);
            }
        });
        mnuReserva.add(mnuEntidades);

        mnuReservas.setText("Reservas");
        mnuReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReservasActionPerformed(evt);
            }
        });
        mnuReserva.add(mnuReservas);

        jMenuItem1.setText("Mails CCO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuReserva.add(jMenuItem1);

        jMenuBar1.add(mnuReserva);

        jMenu2.setText("Reportes");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //VARIABLES
    
    
    //EVENTOS
    private void mnuEntidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEntidadesActionPerformed
        // TODO add your handling code here:
        frmEntidades unE = new frmEntidades();
        unE.abrir();
    }//GEN-LAST:event_mnuEntidadesActionPerformed

    private void mnuReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReservasActionPerformed
        // TODO add your handling code here:
        frmReservas unE = new frmReservas();
        unE.abrir(miUsuario);
    }//GEN-LAST:event_mnuReservasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmMailCliente unf = new frmMailCliente();
        unf.abrir("Select distinct(mail) as mails from sif_entidades", "", "Envio Masivo", miUsuario);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public usuarios miUsuario;
    
    //METODOS
    public void abrir(usuarios U)
    {   
        miUsuario = U;
        //setLocationRelativeTo(null);
        this.setTitle("MENU    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnuEntidades;
    private javax.swing.JMenu mnuReserva;
    private javax.swing.JMenuItem mnuReservas;
    // End of variables declaration//GEN-END:variables
}
