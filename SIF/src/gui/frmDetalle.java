
package gui;

import domain.Reserva;
import java.awt.Dimension;

public class frmDetalle extends javax.swing.JFrame {

    Reserva miReserva = new Reserva();
  
    public frmDetalle() {
        initComponents();
    }

    //METODOS
    public void abrir(Reserva r)
    {   
        //setLocationRelativeTo(null);
        this.setTitle("RESERVAS    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(600, 400));
        this.setVisible(true);
        miReserva = r;
        lblEstado.setText("Reserva: " + r.numero_sif + "      ID: " + r.id_reserva + "      Cliente: " + r.entidad_cliente );
        txtDetalle.setText(r.detalle);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        cmdGuardar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 540, 280);

        cmdGuardar.setBackground(new java.awt.Color(255, 102, 102));
        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar);
        cmdGuardar.setBounds(460, 10, 100, 23);

        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setText("sss");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(20, 330, 540, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        miReserva.detalle = txtDetalle.getText();
        miReserva.guardarDetalle();
        this.setVisible(false);
    }//GEN-LAST:event_cmdGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
