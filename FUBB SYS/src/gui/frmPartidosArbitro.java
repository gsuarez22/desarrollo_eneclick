package gui;

import fubb.sys.ComponentesLista;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

public class frmPartidosArbitro extends javax.swing.JFrame {

    public frmPartidosArbitro() {
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
        cmbArbitros = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblArbitros = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDisponibilidad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(10, 30, 780, 130);

        lblAfinidad.setText("label1");
        getContentPane().add(lblAfinidad);
        lblAfinidad.setBounds(10, 10, 570, 20);

        cmbArbitros.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbArbitros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbArbitrosItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbArbitros);
        cmbArbitros.setBounds(10, 170, 240, 20);

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
        jScrollPane3.setViewportView(tblArbitros);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 200, 780, 110);

        tblDisponibilidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblDisponibilidad);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 340, 780, 130);

        jLabel1.setText("DISPONIBILIDAD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 320, 210, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbArbitrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbArbitrosItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            try
            {
                String valor = cmbArbitros.getSelectedItem().toString();
                String [] separador = valor.split("-");
                String id_arbitro = separador[2];

                SimpleDateFormat unD = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String fec = unD.format(new Date());
                
                String url = "select distinct(p.id_partido) as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv " +
            " from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev, fubb.arbitros a " +
            " where p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and p.fecha_hora >= '" + fec + "' AND (p.arbitro1 = '" + id_arbitro + "' or p.arbitro2 = '" + id_arbitro + "' or  p.arbitro3 = '" + id_arbitro + "') order by p.fecha_hora ";

                ComponentesLista unC = new ComponentesLista();
                unC.cargarTabla(url, tblArbitros);

                unC.cargarTabla(url, tblArbitros);

                url = "select d.dia, d.fecha, d.hora_desde, d.hora_hasta from fubb.disponibilidad d where d.id_arbitro = '" + id_arbitro + "' and hora_hasta >= '" + fec + "'";
                unC.cargarTabla(url, tblDisponibilidad);
     
                recorrerTablaDisponibilidad();
                
            }
            catch(Exception ex){}
        }
    }//GEN-LAST:event_cmbArbitrosItemStateChanged

    public void abrir(String id_arbitro, String nombre, String apellido)
    {
        this.setVisible(true);
        this.setTitle("PARTIDOS ARBITRO");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(840, 500)); 
        ComponentesLista unC = new ComponentesLista();
       
        SimpleDateFormat unD = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fec = unD.format(new Date());
        
        if(id_arbitro.equals("0") == false)
        {
            String url = "select distinct(p.id_partido) as id, p.fecha_hora as fec, p.nomenclator as nomen, p.division1 as divi1, c.nombre_cancha, el.nombre, ev.nombre, p.sub, p.tv " +
            " from fubb.partidos p, fubb.canchas c, fubb.equipos el, fubb.equipos ev, fubb.arbitros a " +
            " where p.fecha_hora >= '" + fec + "' AND p.cancha = c.id_cancha and p.local = el.id_equipo and p.visitante = ev.id_equipo and (p.arbitro1 = '" + id_arbitro + "' or p.arbitro2 = '" + id_arbitro + "' or  p.arbitro3 = '" + id_arbitro + "') order by p.fecha_hora ";

            unC.cargarTabla(url, tblArbitro);
            lblAfinidad.setText("PARTIDOS DEL ARBITRO " + nombre + ", " + apellido);

            recorrerTablaPartidos(tblArbitro);

            url = "select d.dia, d.fecha, d.hora_desde, d.hora_hasta from fubb.disponibilidad d where d.id_arbitro = '" + id_arbitro + "' and hora_hasta >= '" + fec + "'";
            unC.cargarTabla(url, tblDisponibilidad);

            
        }

        unC.cargarCombo("Select CONCAT(a.nombre, '-', a.apellido, '-', a.id_arbitro) as valor from fubb.arbitros a order by a.nombre, a.apellido", cmbArbitros);

    }
    
    public void recorrerTablaPartidos(JTable J)
    {
        int i = 0;
        while(J.getRowCount() > i)
        {
            String fec = J.getValueAt(i, 1).toString();
            String fecha = fec.substring(8,10) + "/" + fec.substring(5,7) + "/" + fec.substring(0,4) + " "  + fec.substring(11,13) + ":"  + fec.substring(14,16);
            J.setValueAt(fecha, i, 1);
            i++;
        }
    }

    public void recorrerTablaDisponibilidad()
    {
        int i = 0;
        while(tblDisponibilidad.getRowCount() > i)
        {
            String fec = tblDisponibilidad.getValueAt(i, 1).toString();
            String fecha = fec.substring(8,10) + "/" + fec.substring(5,7) + "/" + fec.substring(0,4);
            tblDisponibilidad.setValueAt(fecha, i, 1);
            
            String hora = tblDisponibilidad.getValueAt(i, 2).toString();
            hora = hora.substring(11,13) + ":"  + hora.substring(14,16);
            tblDisponibilidad.setValueAt(hora, i, 2);
            
            hora = tblDisponibilidad.getValueAt(i, 3).toString();
            hora = hora.substring(11,13) + ":"  + hora.substring(14,16);
            tblDisponibilidad.setValueAt(hora, i, 3);
            
            i++;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbArbitros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private java.awt.Label lblAfinidad;
    private javax.swing.JTable tblArbitro;
    private javax.swing.JTable tblArbitros;
    private javax.swing.JTable tblDisponibilidad;
    // End of variables declaration//GEN-END:variables
}
