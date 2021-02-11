package gui;

import fubb.sys.ComponentesLista;
import java.awt.Dimension;

public class frmAfinidad extends javax.swing.JFrame {

    public frmAfinidad() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArbitro = new javax.swing.JTable();
        lblAfinidad = new java.awt.Label();
        lblAfinidad1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAfinidades = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tblArbitro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArbitro);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 670, 90);

        lblAfinidad.setText("label1");
        getContentPane().add(lblAfinidad);
        lblAfinidad.setBounds(10, 10, 170, 20);

        lblAfinidad1.setText("AFINIDADES");
        getContentPane().add(lblAfinidad1);
        lblAfinidad1.setBounds(10, 140, 590, 20);

        tblAfinidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblAfinidades);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 160, 670, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void abrir(String id_arbitro, String nombre, String apellido)
    {
        this.setVisible(true);
        this.setTitle("AFINIDADES ");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 500)); 
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("select e.nombre from fubb.equipos e, fubb.afinidades f where f.id_arbitro = '" + id_arbitro + "' and f.id_equipo = e.nombre", tblArbitro);
        unC.cargarTabla("select e.nombre, CONCAT(a.nombre,', ',a.apellido) as arbitro from fubb.arbitros a, fubb.equipos e, fubb.afinidades f where f.id_arbitro = a.id_arbitro and f.id_equipo = e.nombre", tblAfinidades);
        lblAfinidad.setText("AFINIDAD DE " + nombre + ", " + apellido);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private java.awt.Label lblAfinidad;
    private java.awt.Label lblAfinidad1;
    private javax.swing.JTable tblAfinidades;
    private javax.swing.JTable tblArbitro;
    // End of variables declaration//GEN-END:variables
}
