package gui;

import dominio.BD;
import dominio.ComponentesLista;
import dominio.linea;
import dominio.producto;
import dominio.venta;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

public class frmMenu extends javax.swing.JFrame {

    public void abrir()
    {
        this.setVisible(true);
        this.setTitle("SISTEMA DE FACTURACION - ALMACEN");
        this.setMinimumSize(new Dimension(1050, 550)); 
        ComponentesLista unC = new ComponentesLista();
        unC.cargarCombo("Select distinct (cliente) as cli from ventas", cmbCLiente);
        resetear();
        //Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/eme.png"));
        //this.setIconImage(icon);  
        cmbCLiente.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel3.setVisible(false);
        lblFecha.setVisible(false);
        lblId.setVisible(false);
        cargarLinea1();
    }    
    
    public void cargarLinea1()
    {
      String id = tblVentas.getModel().getValueAt(0 , 0).toString();
        String cli = tblVentas.getModel().getValueAt(0 , 1).toString();
        String tot = tblVentas.getModel().getValueAt(0 , 2).toString();
        String fec = tblVentas.getModel().getValueAt(0 , 3).toString();
        
        lblId.setText(id);
        cmbCLiente.setSelectedItem(cli);
        lblTotal.setText(tot);
        lblFecha.setText(fec);
        
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select ID, NOMBREPRODUCTO AS NOMBRE, CANTIDAD, CANTIDADUNITARIA AS UNIDADES, PRECIOUNITARIO AS UNITARIO, PRECIOFINAL AS TOTAL from ventas_lineas where idventas = '" + id + "'", tblCompra);
        recalcular();
        txtProducto.requestFocus();
    }
    
    public void resetear()
    {
        ComponentesLista unC = new ComponentesLista();
        txtProducto.setText("");
        //unC.cargarTabla("Select ID, NOMBRE, PRECIO, cantidadunitaria as UNIDADES from Productos", tblProducto);
        unC.cargarTabla("Select ID, NOMBREPRODUCTO AS NOMBRE, CANTIDAD, CANTIDADUNITARIA AS UNIDADES, PRECIOUNITARIO AS UNITARIO, PRECIOFINAL AS TOTAL from ventas_lineas where idventas = '" + lblId.getText() + "'", tblCompra);
        unC.cargarTabla("SELECT IDventas as ID, CLIENTE, TOTAL, DATE_FORMAT(FECHA, '%d/%m/%Y') as FECHA from ventas order by FECHA DESC, ID DESC", tblVentas);
        txtCantidad.setText("");
        lblTrae1.setText("0");
        lblPrecioU.setText("0");
        lblPrecioU1.setText("0");
        lblPrecioT.setText("0");
        lblProducto.setText("");
        lblCodigo.setText("");
        lblPrecioU2.setText("");
        unC.cargarTabla("Select ID, NOMBRE, PRECIO, cantidadunitaria as UNIDADES from Productos", tblProducto);
        txtProducto.requestFocus();
    }
    
    public frmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCLiente = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblPrecioT = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTrae1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmdReset = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblPrecioU1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblPrecioU2 = new javax.swing.JLabel();
        lblPrecioU = new javax.swing.JTextField();
        lblPeso = new javax.swing.JLabel();
        cmdABMP = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCompra);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 100, 680, 290);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVentas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 420, 1010, 70);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 10, 20, 14);

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("0");
        getContentPane().add(lblId);
        lblId.setBounds(10, 10, 50, 14);

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblFecha);
        lblFecha.setBounds(10, 10, 80, 20);

        jLabel6.setText("PRODUCTO:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 30, 80, 14);

        jLabel7.setText("VENTAS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 400, 110, 14);

        cmbCLiente.setBackground(new java.awt.Color(255, 255, 153));
        cmbCLiente.setEditable(true);
        cmbCLiente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCLiente);
        cmbCLiente.setBounds(10, 10, 70, 20);

        jLabel8.setText("CLIENTE:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 10, 60, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FECHA PEDIDO:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 10, 100, 20);

        txtProducto.setBackground(new java.awt.Color(255, 255, 153));
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });
        getContentPane().add(txtProducto);
        txtProducto.setBounds(80, 30, 230, 20);

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 60, 320, 330);

        txtCantidad.setBackground(new java.awt.Color(255, 255, 153));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(550, 70, 70, 20);

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");
        getContentPane().add(lblTotal);
        lblTotal.setBounds(910, 390, 100, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TRAE:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(350, 50, 60, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PRECIO");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 50, 70, 20);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(910, 70, 50, 20);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(970, 70, 50, 20);

        lblPrecioT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioT.setText("0");
        getContentPane().add(lblPrecioT);
        lblPrecioT.setBounds(820, 70, 80, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TOTAL:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(840, 390, 70, 30);

        lblTrae1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrae1.setText("0");
        getContentPane().add(lblTrae1);
        lblTrae1.setBounds(350, 70, 60, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("TOTAL:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(830, 50, 60, 20);

        jLabel4.setText("COMPRA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 80, 14);

        cmdReset.setBackground(new java.awt.Color(51, 255, 204));
        cmdReset.setText("COBRAR");
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });
        getContentPane().add(cmdReset);
        cmdReset.setBounds(930, 10, 90, 40);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PRODUCTO:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(340, 20, 80, 20);

        lblProducto.setForeground(new java.awt.Color(51, 51, 255));
        lblProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblProducto);
        lblProducto.setBounds(420, 20, 340, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CODIGO:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(760, 20, 80, 20);

        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigo.setText("0");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(830, 20, 70, 20);

        lblPrecioU1.setForeground(new java.awt.Color(255, 51, 51));
        lblPrecioU1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioU1.setText("0");
        getContentPane().add(lblPrecioU1);
        lblPrecioU1.setBounds(750, 70, 80, 20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("PRECIO U:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(740, 50, 90, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CANT TOTAL");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(640, 50, 80, 20);

        lblPrecioU2.setForeground(new java.awt.Color(255, 51, 51));
        lblPrecioU2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioU2.setText("0");
        getContentPane().add(lblPrecioU2);
        lblPrecioU2.setBounds(650, 70, 70, 20);

        lblPrecioU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblPrecioU.setText("0");
        getContentPane().add(lblPrecioU);
        lblPrecioU.setBounds(440, 70, 80, 20);

        lblPeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPeso.setText("CANTIDAD");
        getContentPane().add(lblPeso);
        lblPeso.setBounds(550, 50, 70, 20);

        cmdABMP.setText("PRODUCTOS");
        cmdABMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdABMPActionPerformed(evt);
            }
        });
        getContentPane().add(cmdABMP);
        cmdABMP.setBounds(310, 30, 20, 20);

        jButton3.setText("PRECIOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(213, 3, 120, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        // TODO add your handling code here:
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select ID, NOMBRE, PRECIO, cantidadunitaria as UNIDADES from Productos where (nombre like '%" + txtProducto.getText() + "%' OR barra like '%" + txtProducto.getText() + "%' OR codigo like '%" + txtProducto.getText() + "%')", tblProducto);
        
        //if(Double.parseDouble(txtProducto.getText()) > Double.parseDouble("100000000000"))
        //{
        if(evt.getKeyCode() == 10)
        {
            String id = tblProducto.getModel().getValueAt(0 , 0).toString();
            aislar(id);
            txtCantidad.setText("1");
            txtCantidad.requestFocus();//jButton2ActionPerformed(null);
        }
        
    }//GEN-LAST:event_txtProductoKeyReleased

    private void aislar(String id)
    {
        producto p = new producto();
        p.cargarPorId(id);
        
        lblTrae1.setText(p.cantidadunitaria);
        lblPrecioU.setText(p.precio);
        lblProducto.setText(p.nombre);
        lblCodigo.setText(p.codigo);
        
        if (p.peso.equals("1")){lblPeso.setText("PESO");}else{lblPeso.setText("CANTIDAD");}
        
        double can = 0;
        try{can = Double.parseDouble(lblPrecioU.getText()) / Double.parseDouble(lblTrae1.getText());} catch(Exception ex){}
        lblPrecioU1.setText("(" + Math.floor(can) + ")");
     
        int coco = 0;
        try{coco = Integer.parseInt(txtCantidad.getText()) * Integer.parseInt(lblTrae1.getText());} catch(Exception ex){}
        lblPrecioU2.setText(String.valueOf(coco));
    }
    
    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        // TODO add your handling code here:
        String id = tblProducto.getModel().getValueAt(tblProducto.getSelectedRow() , 0).toString();
        aislar(id);
        txtCantidad.requestFocus();
    }//GEN-LAST:event_tblProductoMouseClicked

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        // TODO add your handling code here:
        int val = Integer.parseInt(txtCantidad.getText());
        if(val != 0)
        {
            double precio = 0;
            if(lblPeso.getText().equals("PESO"))
            {
                precio = Double.parseDouble(lblPrecioU.getText()) * val / 1000;
            }
            else
            {
                precio = Double.parseDouble(lblPrecioU.getText()) * val;
            }
            
            lblPrecioT.setText(String.valueOf(precio));
            
            double can = 0;
            try{can = Double.parseDouble(lblPrecioU.getText()) / Double.parseDouble(lblTrae1.getText());} catch(Exception ex){}
            lblPrecioU1.setText("(" + Math.floor(can) + ")");

            int coco = 0;
            try{coco = Integer.parseInt(txtCantidad.getText()) * Integer.parseInt(lblTrae1.getText());} catch(Exception ex){}
            lblPrecioU2.setText(String.valueOf(coco));

            //JOptionPane.showMessageDialog(null, evt.getKeyCode());
            
            if(evt.getKeyCode() == 10)
            {
                //if(Double.parseDouble(txtProducto.getText()) > Double.parseDouble("100000000000"))
                //{
                    //double ddd = Double.parseDouble(lblPrecioU.getText());
                    //lblPrecioT.setText(String.valueOf(ddd));
                    //txtCantidad.setText("1");
                //}
                jButton2ActionPerformed(null);
            }
            
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if(lblPrecioT.getText().equals("0") == false)
        {
            String id = "0";
            try{id = tblProducto.getModel().getValueAt(tblProducto.getSelectedRow() , 0).toString();}
            catch (Exception ex) {id = tblProducto.getModel().getValueAt(0 , 0).toString();}
            producto p = new producto();
            p.cargarPorId(id);
            p.precio = lblPrecioU.getText();
            p.guardarPrecio();
            
            String idventa = lblId.getText();
            venta v = new venta();
            v.idventas = idventa;
            v.cliente = cmbCLiente.getSelectedItem().toString();

            double valor = Double.parseDouble(lblTotal.getText()) + Double.parseDouble(lblPrecioT.getText());
            valor = Math.round(valor);
            lblTotal.setText(String.valueOf(valor));
            v.total = lblTotal.getText();
            v.ActualizarVenta();

            linea l = new linea();
            l.idventas = v.idventas;
            l.cantidad = txtCantidad.getText();
            l.cantidadunitaria = lblTrae1.getText();
            l.idproducto = p.id;
            l.nombreproducto = p.nombre;
            l.preciounitario = p.precio;
       
            double d = Math.round(Double.parseDouble(lblPrecioT.getText()));
            l.preciofinal = String.valueOf(d);
            lblPrecioT.setText(l.preciofinal);
            l.guardar();

            lblId.setText(v.idventas);

            resetear();
            txtProducto.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void mostrarResumen()
    {
        String url = "SELECT p.familia, SUM(v.preciofinal) AS precio FROM ventas_lineas v, productos p WHERE v.idventas = '" + lblId.getText() + "' AND v.idproducto = p.id " +
                     " GROUP BY p.familia " +
                     " ORDER BY p.familia ";
        
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            String texto = "";
            while (lista.next())
            {
                String familia = lista.getString("familia");
                String precio = lista.getString("precio");
                texto = "(" + familia + ") " + precio + " \n\r " + texto;
            }
            
            JOptionPane.showMessageDialog(null, texto);
            
        }
        catch (Exception ex)
        {
             
        }
    }    
    
    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        // TODO add your handling code here:

        mostrarResumen();
//        imprimir();
        
        ComponentesLista unC = new ComponentesLista();
        unC.cargarCombo("Select distinct (cliente) as cli from ventas", cmbCLiente);
        lblId.setText("0");
        lblFecha.setText("");
        lblTotal.setText("0");
        lblPeso.setText("CANTIDAD");
        venta unV = new venta();
        unV.borrarVentas();
        
        

        resetear();
        
        //txtProducto.requestFocus();
    }//GEN-LAST:event_cmdResetActionPerformed

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
        // TODO add your handling code here:
        String id = tblVentas.getModel().getValueAt(tblVentas.getSelectedRow() , 0).toString();
        String cli = tblVentas.getModel().getValueAt(tblVentas.getSelectedRow() , 1).toString();
        String tot = tblVentas.getModel().getValueAt(tblVentas.getSelectedRow() , 2).toString();
        String fec = tblVentas.getModel().getValueAt(tblVentas.getSelectedRow() , 3).toString();
        
        lblId.setText(id);
        cmbCLiente.setSelectedItem(cli);
        lblTotal.setText(tot);
        lblFecha.setText(fec);
        
        ComponentesLista unC = new ComponentesLista();
        unC.cargarTabla("Select ID, NOMBREPRODUCTO AS NOMBRE, CANTIDAD, CANTIDADUNITARIA AS UNIDADES, PRECIOUNITARIO AS UNITARIO, PRECIOFINAL AS TOTAL from ventas_lineas where idventas = '" + id + "'", tblCompra);
        recalcular();
        txtProducto.requestFocus();
    }//GEN-LAST:event_tblVentasMouseClicked

    private void recalcular()
    {
        int i = 0;
        double suma = 0;
        while (i < tblCompra.getRowCount())
        {
            String valor = tblCompra.getModel().getValueAt(i , 5).toString();
            suma = suma + Double.parseDouble(valor);
            i++;
        }
        lblTotal.setText(String.valueOf(suma));
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = tblCompra.getModel().getValueAt(tblCompra.getSelectedRow() , 0).toString();
        String val = tblCompra.getModel().getValueAt(tblCompra.getSelectedRow() , 5).toString();
        
        if(id.equals("0") == false)
        {
            linea l = new linea();
            l.id = id;
            l.borrar();
            recalcular();
            venta v = new venta();
            v.idventas = lblId.getText();
            v.cliente = cmbCLiente.getSelectedItem().toString();
            double vv = Double.parseDouble(lblTotal.getText()) - Double.valueOf(val);
            v.total = String.valueOf(vv);
            v.ActualizarVenta();
            resetear();
            recalcular();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmdABMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdABMPActionPerformed
        // TODO add your handling code here:
        frmABMProductos unF = new frmABMProductos();
        unF.abrir();
    }//GEN-LAST:event_cmdABMPActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        frmPrecios unF = new frmPrecios();
        unF.abrir();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void imprimir ()
    {
        linea unL = new linea();
        venta unV = new venta();
        ArrayList lista = new ArrayList();
        PrinterJob job = PrinterJob.getPrinterJob();
        if (job.printDialog())
        {            
            try
            {
                int i = 0;
                Etiquetas unObj = new Etiquetas();

                try{unV.idventas = tblVentas.getModel().getValueAt(0 , 0).toString(); } catch(Exception e){}
                try{unV.cliente = tblVentas.getModel().getValueAt(0 , 1).toString(); } catch(Exception e){}
                try{unV.total = tblVentas.getModel().getValueAt(0 , 2).toString();} catch(Exception e){}
                //JOptionPane.showMessageDialog(null, unV.total);
                try{unV.fecha = tblVentas.getModel().getValueAt(0 , 3).toString();} catch(Exception e){}
                
                while (tblCompra.getRowCount() > i)
                {
                    unL = new linea();
                    try{unL.id = tblCompra.getModel().getValueAt(i , 0).toString();} catch(Exception e){}
                    try{unL.nombreproducto = tblCompra.getModel().getValueAt(i , 1).toString();} catch(Exception e){}
                    try{unL.cantidad = tblCompra.getModel().getValueAt(i , 2).toString();} catch(Exception e){}
                    try{unL.cantidadunitaria = tblCompra.getModel().getValueAt(i , 3).toString();} catch(Exception e){}
                    try{unL.preciounitario = tblCompra.getModel().getValueAt(i, 4).toString();} catch(Exception e){}
                    try{unL.preciofinal = tblCompra.getModel().getValueAt(i, 5).toString();} catch(Exception e){}
                    lista.add(unL);
                    i++;
                }    
                
                unObj.lista = lista;
                unObj.unaV = unV;
                
                job.setPrintable(unObj);
                job.print(); 
                        
            }
            catch (Exception e) 
            {
            }                    
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCLiente;
    private javax.swing.JButton cmdABMP;
    private javax.swing.JButton cmdReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblPrecioT;
    private javax.swing.JTextField lblPrecioU;
    private javax.swing.JLabel lblPrecioU1;
    private javax.swing.JLabel lblPrecioU2;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTrae1;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
