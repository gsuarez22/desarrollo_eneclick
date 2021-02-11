package gui;

import domain.arbitro;
import domain.cancha;
import domain.operativaA;
import domain.partido;
import domain.recaudador;
import fubb.sys.DBSSH;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmDesignacionArbitral extends javax.swing.JFrame {

    public void abrir(String usu)
    {
        this.setVisible(true);
        this.setTitle("DESIGNACION ARBITRAL  -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(1200, 500)); 
    }
    
    public frmDesignacionArbitral() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdProcesar = new javax.swing.JButton();
        dtpHasta = new com.toedter.calendar.JDateChooser();
        dtpDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPartidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArbitros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmdProcesar.setText("Consultar");
        cmdProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdProcesar);
        cmdProcesar.setBounds(440, 10, 140, 23);
        getContentPane().add(dtpHasta);
        dtpHasta.setBounds(320, 10, 95, 20);
        getContentPane().add(dtpDesde);
        dtpDesde.setBounds(120, 10, 95, 20);

        jLabel1.setText("Periodo Desde:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 100, 20);

        jLabel2.setText("Hasta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 10, 60, 20);

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
        jScrollPane1.setViewportView(tblPartidos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 1160, 120);

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1060, 10, 110, 23);

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
        jScrollPane2.setViewportView(tblArbitros);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 190, 1160, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public operativaA operador; 
    
    private void cmdProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat unF = new SimpleDateFormat("yyyy-MM-dd");
        String desde = unF.format(dtpDesde.getDate());
        String hasta = unF.format(dtpHasta.getDate());

        operador = new operativaA();
        operador.cargarDesdeLaBase(desde, hasta);
        
        operador.designar(desde, hasta);
        
        cargarTablaPartidos();
        cargarTablaArbitros();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblPartidos.getModel());
        tblPartidos.setRowSorter(sorter);

        TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(tblArbitros.getModel());
        tblArbitros.setRowSorter(sorter1);

    }//GEN-LAST:event_cmdProcesarActionPerformed

    private void llenarArbitro (ArrayList n, DefaultTableModel tableModel)
    {
        int i = 0;
        while (n.size() > i) 
        {
            arbitro P = (arbitro) n.get(i);
            Vector ar = new Vector();
            ar.add (P.id); ar.add(P.nombreCompleto); ar.add(P.categoria); ar.add(P.nota); 
            int suma = 0;
            int tt = 0;
            if(operador.fechasT.size() > 7){tt = operador.fechasT.size() - 7;}
            for(int t=tt;t < operador.fechasT.size();t++)
            {
                int val = operador.cantidadDePartidosXArbitroXDia(P.id, operador.fechasT.get(t).toString());
                suma = val + suma;     
                ar.add(val);
            }
            ar.add(suma);           
            ar.add(operador.cantidadDePartidosXArbitro(P.id));
                    
            tableModel.addRow(ar);
            i++; 
        }
    }
    
    public void cargarTablaArbitros()
    {
        //id, nombrecompleto, categoria, nota
        try
        {
            Vector v = new Vector();
            
            DefaultTableModel tableModel = new DefaultTableModel(0,4);
            
            v.add("ID_ARBITRO"); v.add("NOMBRE"); v.add("CATEGORIA"); v.add("NOTA");
            int tt = 0;
            if(operador.fechasT.size() > 7){tt = operador.fechasT.size() - 7;}
            for(int t=tt;t < operador.fechasT.size();t++)
            {
                v.add(operador.fechasT.get(t).toString());
            }
            v.add("SEMANA");
            v.add("ACUMULADO");
            tableModel.setColumnIdentifiers(v);

            int i = 0;
            
            try
            {
                
                llenarArbitro(operador.n1, tableModel);
                llenarArbitro(operador.n2, tableModel);
                llenarArbitro(operador.d1, tableModel);
                llenarArbitro(operador.d2, tableModel);
                llenarArbitro(operador.senior, tableModel);
           
            }catch(Exception ex){}    
            
                        
            tblArbitros.setModel(tableModel);
           
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList updates = new ArrayList();

        for(int i = 0; i < tblPartidos.getSelectedRowCount(); i++)
        {
            int x = 0;
            String id = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 0).toString();
            String arb1 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 7).toString();
            String arb2 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 8).toString();
            String arb3 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 9).toString();
            if(arb1.length() > 10)
            {
                String [] parse = arb1.split("-");
                arb1 = parse[0];
            }
            else
            {
                arb1 = "";
            }
            if(arb2.length() > 10)
            {
                String [] parse = arb2.split("-");
                arb2 = parse[0];
            }
            else
            {
                arb2 = "";
            }
            if(arb3.length() > 10)
            {
                String [] parse = arb3.split("-");
                arb3 = parse[0];
            }
            else
            {
                arb3 = "";
            }
            String url = "";
            url = "update fubb.partidos set arbitro1 = '" + arb1 + "', arbitro2 = '" + arb2 + "', arbitro3 = '" + arb3 + "' where id_partido = '" + id + "'"; 
            updates.add(url);
        }

        if(updates.size() > 0)
        {
            DBSSH unb = new DBSSH();
            unb.Todos(updates);
            JOptionPane.showMessageDialog(null, "Procesado");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarTablaPartidos()
    {
        //id partido, local, visitante, cancha, fecha, tv, fiscal, alterno, boletero1, boletero2, portero1, portero2, portero3
        try
        {
            Vector v = new Vector();
            
            DefaultTableModel tableModel = new DefaultTableModel(0,10);
            
            v.add("ID_PARTIDO"); v.add("TIPO"); v.add("LOCAL"); v.add("VISITANTE"); v.add("CANCHA"); v.add("FECHA"); v.add("TV"); v.add("ARBITRO1"); v.add("ARBITRO2"); v.add("ARBITRO3");
            tableModel.setColumnIdentifiers(v);

            int i = 0;
            
            try
            {
                while (operador.partidosxcanchaxdiaxtipo.size() > i) 
                {
                    cancha unaC = (cancha) operador.partidosxcanchaxdiaxtipo.get(i);
                    Vector ar = new Vector();

                    int z = 0;
                    while (unaC.partidosDelDia.size() > z)
                    {
                        ar = new Vector();
                        partido P = new partido();
                        P = (partido) unaC.partidosDelDia.get(z);
                        String id = "", titulo = "", local = "", visitante = "", cancha = "", fecha = "", tv = "", arbitro1 = "", arbitro2 = "", arbitro3 = "";
                        id = P.id_partido; titulo = P.titulo; local = operador.miEquipo(P.local); visitante = operador.miEquipo(P.visitante); cancha = operador.miCancha(P.cancha); tv = P.tv; fecha = P.fecha.replace(":00.0", ""); arbitro1 = P.arbitro1 + "-" + operador.miArbitro(P.arbitro1); arbitro2 = P.arbitro2 + "-" + operador.miArbitro(P.arbitro2); arbitro3 =  P.arbitro3 + "-" + operador.miArbitro(P.arbitro3);                       
                        ar.add (id); ar.add (titulo); ar.add(local); ar.add(visitante); ar.add(cancha); ar.add(fecha); ar.add(tv); ar.add(arbitro1); ar.add(arbitro2); ar.add(arbitro3); 
                        z++;    
                        tableModel.addRow(ar);
                    }                    
                    i++; 
                }
            }catch(Exception ex){}    
            
                        
            tblPartidos.setModel(tableModel);
           
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdProcesar;
    private com.toedter.calendar.JDateChooser dtpDesde;
    private com.toedter.calendar.JDateChooser dtpHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArbitros;
    private javax.swing.JTable tblPartidos;
    // End of variables declaration//GEN-END:variables
}
