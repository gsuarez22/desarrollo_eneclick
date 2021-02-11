
package gui;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class frmSelectorA extends javax.swing.JFrame {

    public frmSelectorA() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(10, 10, 624, 397);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    frmConvertirExcel padre = new frmConvertirExcel();
    frmSueldos padreS = new frmSueldos();
    frmSubirFijacion padreF = new frmSubirFijacion();
    frmClubes padreC = new frmClubes();
    
    public void abrir(frmConvertirExcel unf)
    {
        padre = unf;
        this.setVisible(true);
        this.setTitle("SELECTOR    -    ADM");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 690)); 
    }

    public void abrir(frmClubes unf)
    {
        padreC = unf;
        this.setVisible(true);
        this.setTitle("SELECTOR    -    ADM");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 690)); 
    }

    
    public void abrir(frmSueldos unf)
    {
        padreS = unf;
        this.setVisible(true);
        this.setTitle("SELECTOR    -    ADM");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 690)); 
    }
    
    public void abrir(frmSubirFijacion unf)
    {
        padreF = unf;
        this.setVisible(true);
        this.setTitle("SELECTOR    -    ADM");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 690)); 
    }
    
    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        
        String ruta = "";
        
        if(evt.getActionCommand().equals("ApproveSelection"))
        {
            ruta = jFileChooser1.getCurrentDirectory().getPath() + "\\" + jFileChooser1.getSelectedFile().getName();            
        }
        try{if(padre != null){padre.completarArchivo(jFileChooser1.getCurrentDirectory().getPath() + "\\", jFileChooser1.getSelectedFile().getName());}}catch(Exception ex){}
        try{if(padreS != null){padreS.completarArchivo(jFileChooser1.getCurrentDirectory().getPath() + "\\", jFileChooser1.getSelectedFile().getName());}}catch(Exception ex){}
        try{if(padreF != null){padreF.completarArchivo(jFileChooser1.getCurrentDirectory().getPath() + "\\", jFileChooser1.getSelectedFile().getName());}}catch(Exception ex){}         
        try{if(padreC != null){padreC.completarArchivo(jFileChooser1.getCurrentDirectory().getPath() + "\\", "");}}catch(Exception ex){}
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmSelectorA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSelectorA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSelectorA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSelectorA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSelectorA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables


}
