package gui;

import domain.operativaR;
import domain.partido;
import domain.recaudador;
import fubb.sys.ComponentesLista;
import fubb.sys.DBSSH;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmRecaudadores extends javax.swing.JFrame {

    ComponentesLista unC = new ComponentesLista();
    
    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("RECAUDADORES    -    FUBB");
        this.setTitle(this.getTitle());
        this.setMinimumSize(new Dimension(1000, 700));
        //unC.cargarTabla("Select id_recaudador as ID, CONCAT(nombre,' ',apellido) AS NOMBRE, categoria AS CATEGORIA, '0' as PARTIDOS from fubb.recaudadores", tblRecaudadores);
    }

    
    public frmRecaudadores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecaudadores = new javax.swing.JTable();
        RECAUDADORES = new javax.swing.JLabel();
        dtpHasta = new com.toedter.calendar.JDateChooser();
        dtpDesde = new com.toedter.calendar.JDateChooser();
        cmdConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPartidos = new javax.swing.JTable();
        RECAUDADORES1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tblRecaudadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRecaudadores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 430, 960, 200);

        RECAUDADORES.setText("Partidos");
        getContentPane().add(RECAUDADORES);
        RECAUDADORES.setBounds(10, 20, 100, 20);
        getContentPane().add(dtpHasta);
        dtpHasta.setBounds(380, 10, 110, 20);
        getContentPane().add(dtpDesde);
        dtpDesde.setBounds(190, 10, 110, 20);

        cmdConsultar.setText("Consultar");
        cmdConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdConsultar);
        cmdConsultar.setBounds(510, 10, 120, 23);

        jLabel1.setText("Período Desde:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 90, 20);

        jLabel2.setText("Hasta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 10, 50, 20);

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
        jScrollPane2.setViewportView(tblPartidos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 40, 960, 360);

        RECAUDADORES1.setText("Recaudadores");
        getContentPane().add(RECAUDADORES1);
        RECAUDADORES1.setBounds(10, 410, 100, 20);

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(860, 10, 110, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public operativaR miOperador;
    
    private void cmdConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConsultarActionPerformed
        // TOMA UN RANGO Y CUENTA LA CANTIDAD DE PARTIDOS QUE LLEVA CADA RECAUDADOR
        
        SimpleDateFormat unF = new SimpleDateFormat("yyyy-MM-dd");
        String desde = unF.format(dtpDesde.getDate());
        String hasta = unF.format(dtpHasta.getDate());
        
        miOperador = new operativaR();
        miOperador.cargarDesdeLaBase(desde, hasta);
        
        miOperador.AsignarPartidos();
        
        cargarTablaPartidos();
        cargarRecaudadores();
        
    }//GEN-LAST:event_cmdConsultarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                ArrayList updates = new ArrayList();
        
        for(int i = 0; i < tblPartidos.getSelectedRowCount(); i++)
        {
            int x = 0;
            String id = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 0).toString();
            String fis = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 7).toString();
            String al = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 8).toString();
            String bol = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 9).toString();
            String por1 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 10).toString();
            String por2 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 11).toString();
            String por3 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 12).toString();
            String por4 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 13).toString();
            String por5 = tblPartidos.getValueAt(tblPartidos.getSelectedRows()[i], 14).toString();
            String url = "delete from fubb.partidos_recaudadores where id_partido = '" + id + "'"; updates.add(url);            
            if(fis.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + fis + "', 'FISCAL')"; updates.add(url);} 
            if(al.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + al + "', 'ALTERNO')"; updates.add(url);}
            if(bol.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + bol + "', 'BOLETERO')"; updates.add(url);}
            if(por1.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + por1 + "', 'PORTERO')"; updates.add(url);}
            if(por2.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + por2 + "', 'PORTERO')"; updates.add(url);}
            if(por3.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + por3 + "', 'PORTERO')"; updates.add(url);}
            if(por4.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + por4 + "', 'PORTERO')"; updates.add(url);}
            if(por5.equals("") == false){url = "insert into fubb.partidos_recaudadores (id_partido,id_recaudador,tipo) VALUES ('" + id + "', '" + por5 + "', 'PORTERO')"; updates.add(url);}
                        
        }

        if(updates.size() > 0)
        {
            DBSSH unb = new DBSSH();
            unb.Todos(updates);
            JOptionPane.showMessageDialog(null, "Procesado");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
     
    public void cargarRecaudadores()
    {
        //id recaudador, nombre, categoria, cantidad
        try
        {
            Vector v = new Vector();
            
            DefaultTableModel tableModel = new DefaultTableModel(0,4);
            
            v.add("ID_RECAUDADOR"); v.add("NOMBRE"); v.add("CATEGORIA"); v.add("CANTIDAD");
            tableModel.setColumnIdentifiers(v);

            int i = 0;
            
            try
            {
                while (miOperador.recaudadores.size() > i) 
                {
                    recaudador P = (recaudador) miOperador.recaudadores.get(i);
                    Vector ar = new Vector();
                    ar.add (P.id_recaudador); ar.add(P.nombre); ar.add(P.categoria); ar.add(P.cantidad); 
                    tableModel.addRow(ar);
                    i++; 
                }
            }catch(Exception ex){}    
            
                        
            tblRecaudadores.setModel(tableModel);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblRecaudadores.getModel());
            tblRecaudadores.setRowSorter(sorter);
        
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
    }
    
    public void cargarTablaPartidos()
    {
        //id partido, local, visitante, cancha, fecha, tv, fiscal, alterno, boletero1, boletero2, portero1, portero2, portero3
        try
        {
            Vector v = new Vector();
            
            DefaultTableModel tableModel = new DefaultTableModel(0,15);
            
            v.add("ID_PARTIDO"); v.add("TIPO"); v.add("LOCAL"); v.add("VISITANTE"); v.add("CANCHA"); v.add("FECHA"); v.add("TV"); v.add("FISCAL"); v.add("ALTERNO"); v.add("BOLETERO_1"); v.add("PORTERO_1"); v.add("PORTERO_2"); v.add("PORTERO_3"); v.add("PORTERO_4"); v.add("PORTERO_5");
            tableModel.setColumnIdentifiers(v);

            int i = 0;
            
            try
            {
                while (miOperador.partidos.size() > i) 
                {
                    partido P = (partido) miOperador.partidos.get(i);
                    Vector ar = new Vector();

                    ar.add (P.id_partido); ar.add (P.titulo); ar.add(miOperador.miEquipo(P.local)); ar.add(miOperador.miEquipo(P.visitante)); ar.add(miOperador.miCancha(P.cancha)); ar.add(P.fecha.replace(":00.0", "")); ar.add(P.tv); 

                    int x = 0;
                    String bol1 = "", por1 = "", por2 = "", por3 = "", por4= "", por5 = "", fiscal = "", alterno = "";

                    while (P.recaudadores.size() > x)
                    {
                        recaudador R = (recaudador) P.recaudadores.get(x);
                        if(R.categoria.toLowerCase().equals("fiscal")){fiscal = R.id_recaudador;}
                        if(R.categoria.toLowerCase().equals("alterno")){alterno = R.id_recaudador;}
                        if(R.categoria.toLowerCase().equals("boletero"))
                        {
                            if ( bol1.equals("") ) { bol1 = R.id_recaudador; } //else { bol2 = R.id_recaudador; }
                        }
                        if(R.categoria.toLowerCase().equals("portero"))
                        {
                            if ( por1.equals("") ) 
                            {
                                por1 = R.id_recaudador; 
                            }
                            else
                            {
                                if ( por2.equals("") ) 
                                { 
                                    por2 = R.id_recaudador;
                                } 
                                else
                                {
                                    if ( por3.equals("") ) 
                                    { 
                                        por3 = R.id_recaudador;
                                    } 
                                    else
                                    {
                                        if ( por4.equals("") ) 
                                        { 
                                            por4 = R.id_recaudador;
                                        } 
                                        else
                                        {
                                            if ( por5.equals("") ) { por5 = R.id_recaudador; }
                                        }

                                    }

                                }
                            }
                        }
                        x++;    
                    }
                    if(fiscal.equals("")){fiscal = "0";}
                    if(alterno.equals("")){alterno = "0";}
                    if(bol1.equals("")){bol1 = "0";}
                    if(por1.equals("")){por1 = "0";}if(por2.equals("")){por2 = "0";}if(por3.equals("")){por3 = "0";}if(por4.equals("")){por4 = "0";}if(por5.equals("")){por5 = "0";}
                    ar.add(fiscal); ar.add(alterno); ar.add(bol1); ar.add(por1); ar.add(por2); ar.add(por3); ar.add(por4); ar.add(por5);
                    tableModel.addRow(ar);
                    i++; 
                }
            }catch(Exception ex){}    
            
                        
            tblPartidos.setModel(tableModel);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblPartidos.getModel());
            tblPartidos.setRowSorter(sorter);       
            
        }
        catch(Exception ex)
        {
           System.out.println(ex.toString());  
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RECAUDADORES;
    private javax.swing.JLabel RECAUDADORES1;
    private javax.swing.JButton cmdConsultar;
    private com.toedter.calendar.JDateChooser dtpDesde;
    private com.toedter.calendar.JDateChooser dtpHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPartidos;
    private javax.swing.JTable tblRecaudadores;
    // End of variables declaration//GEN-END:variables
}
