package gui;

import fubb.sys.ComponentesLista;
import fubb.sys.DBSSH;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class frmPartidos extends javax.swing.JFrame {

    public frmPartidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidos = new javax.swing.JTable();
        PARTIDOS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArbitros = new javax.swing.JTable();
        cmdVerMAs = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cmbArbitros = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tblPartidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPartidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPartidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPartidos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 800, 320);

        PARTIDOS.setText("PARTIDOS");
        getContentPane().add(PARTIDOS);
        PARTIDOS.setBounds(10, 4, 180, 20);

        jLabel2.setText("ARBITROS DISPONIBLES");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 350, 370, 30);

        tblArbitros.setModel(new javax.swing.table.DefaultTableModel(
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
        tblArbitros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArbitrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblArbitros);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 390, 800, 130);

        cmdVerMAs.setText("VER MAS");
        cmdVerMAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerMAsActionPerformed(evt);
            }
        });
        getContentPane().add(cmdVerMAs);
        cmdVerMAs.setBounds(693, 360, 120, 20);

        jButton1.setText("QUITAR ASIGNACION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(533, 360, 150, 20);

        cmbArbitros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "arbitro1", "arbitro2", "arbitro3", "todos" }));
        getContentPane().add(cmbArbitros);
        cmbArbitros.setBounds(396, 360, 130, 20);

        jButton2.setText("Arbitros Disponibles");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 0, 160, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPartidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPartidosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblPartidosMouseClicked

    private void tblArbitrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArbitrosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblArbitrosMouseClicked

    private void cmdVerMAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerMAsActionPerformed
        // TODO add your handling code here:
        
        try
        {
            ComponentesLista unC = new ComponentesLista();
        
            String id_arbitro = tblArbitros.getValueAt(tblArbitros.getSelectedRow(),0).toString();
            String nombre = tblArbitros.getValueAt(tblArbitros.getSelectedRow(),1).toString();
            String apellido = tblArbitros.getValueAt(tblArbitros.getSelectedRow(),2).toString();

            frmAfinidad una = new frmAfinidad();
            una.abrir(id_arbitro, nombre, apellido);

            frmPartidosArbitro unb = new frmPartidosArbitro();
            unb.abrir(id_arbitro, nombre, apellido);
        }
        catch(Exception ex)
        {
            frmAfinidad una = new frmAfinidad();
            una.abrir("0", "", "");

            frmPartidosArbitro unb = new frmPartidosArbitro();
            unb.abrir("0", "", "");
        }
    }//GEN-LAST:event_cmdVerMAsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = tblPartidos.getValueAt(tblPartidos.getSelectedRow(),0).toString();
        
        if (cmbArbitros.getSelectedItem().toString().equals("arbitro1"))
        {
            DBSSH.StoreProcedure("update fubb.partidos set arbitro1 = null where id_partido = '" + id + "'");
        }
        if (cmbArbitros.getSelectedItem().toString().equals("arbitro2"))
        {
            DBSSH.StoreProcedure("update fubb.partidos set arbitro2 = null where id_partido = '" + id + "'");
        }
        if (cmbArbitros.getSelectedItem().toString().equals("arbitro3"))
        {
            DBSSH.StoreProcedure("update fubb.partidos set arbitro3 = null where id_partido = '" + id + "'");
        }
        if (cmbArbitros.getSelectedItem().toString().equals("todos"))
        {
            DBSSH.StoreProcedure("update fubb.partidos set arbitro1 = null, arbitro2 = null, arbitro3 = null where id_partido = '" + id + "'");
        }
        resetear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            ComponentesLista unC = new ComponentesLista();
            String id_partido = tblPartidos.getValueAt(tblPartidos.getSelectedRow(),0).toString();
            String url = "select d.id_arbitro as ID, a.nombre as NOMBRE, a.apellido AS APELLIDO, d.hora_desde as DESDE, d.hora_hasta as HASTA, a.categoria AS CAT, a.barrio as BARRIO_ARBITRO, c.barrio_cancha as BARRIO_CANCHA, p.fecha_hora " +
            "from fubb.canchas c, fubb.partidos p, fubb.disponibilidad d, fubb.arbitros a " +
            "where p.id_partido = '" + id_partido + "' AND p.cancha = c.id_cancha and p.fecha_hora > d.hora_desde and p.fecha_hora < d.hora_hasta and d.id_arbitro = a.id_arbitro and a.habilitado = 'SI' " +
            "order by a.nombre, a.apellido";

            unC.cargarTablaSiPuede(url, tblArbitros, id_partido);
            JOptionPane.showMessageDialog(null, "Procesado");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("PARTIDOS    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 600)); 
        resetear();
    }
    
    public void resetear()
    {

        ComponentesLista unC = new ComponentesLista();
        SimpleDateFormat unF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaahora = unF.format(new Date());
        String url = "select p.id_partido as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv, CONCAT(a1.nombre, ',', a1.apellido) as arbitro1, CONCAT(a2.nombre, ',', a2.apellido) as arbitro2, CONCAT(a3.nombre, ',', a3.apellido) as arbitro3 " +
"from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev, fubb.arbitros a1, fubb.arbitros a2, fubb.arbitros a3 " +
"where p.fecha_hora > '" + fechaahora + "' AND p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and p.arbitro1 = a1.id_arbitro and p.arbitro2 = a2.id_arbitro and  p.arbitro3 = a3.id_arbitro  " +
" " +
"UNION " +
"" +
"select p.id_partido as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv, CONCAT(a1.nombre, ',', a1.apellido) as arbitro1, CONCAT(a2.nombre, ',', a2.apellido) as arbitro2, '' as arbitro3 " +
"from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev, fubb.arbitros a1, fubb.arbitros a2 " +
"where p.fecha_hora > '" + fechaahora + "' AND p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and p.arbitro1 = a1.id_arbitro and p.arbitro2 = a2.id_arbitro and p.arbitro3 is null " +
" " +
"UNION " +
"" +
"select p.id_partido as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv, CONCAT(a1.nombre, ',', a1.apellido) as arbitro1, '' as arbitro2, '' as arbitro3 " +
"from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev, fubb.arbitros a1 " +
"where p.fecha_hora > '" + fechaahora + "' AND p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and p.arbitro1 = a1.id_arbitro  and p.arbitro2 is null  and p.arbitro3 is null " +
" " +
"UNION " +
" " +
"select p.id_partido as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv, '' as arbitro1, '' as arbitro2, '' as arbitro3 " +
"from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev " +
"where p.fecha_hora > '" + fechaahora + "' AND p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and p.arbitro1 = null and p.arbitro2 = null and p.arbitro3 = null " +
" " +
"order by  nomen, divi1, fec";
        
        unC.cargarTabla(url , tblPartidos);
        recorrerTablaPartidos();
        
        unC.cargarTabla("select '' as ID, '' as NOMBRE, '' AS APELLIDO, '' as DESDE, '' as HASTA, '' as CAT, '' as BARRIO_ARBITRO, '' as BARRIO_CANCHA from fubb.partidos p where p.id_partido = 0", tblArbitros);       
    }
    
    public void recorrerTablaPartidos()
    {
        int i = 0;
        while(tblPartidos.getRowCount() > i)
        {
            String fec = tblPartidos.getValueAt(i, 1).toString();
            String fecha = fec.substring(8,10) + "/" + fec.substring(5,7) + "/" + fec.substring(0,4) + " "  + fec.substring(11,13) + ":"  + fec.substring(14,16);
            tblPartidos.setValueAt(fecha, i, 1);
            i++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PARTIDOS;
    private javax.swing.JComboBox cmbArbitros;
    private javax.swing.JButton cmdVerMAs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArbitros;
    private javax.swing.JTable tblPartidos;
    // End of variables declaration//GEN-END:variables

}