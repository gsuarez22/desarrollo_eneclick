
package gui;

import domain.BD;
import domain.ComponentesLista;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class frmEntidades extends javax.swing.JFrame {
    
    public frmEntidades() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        labeler = new javax.swing.JLabel();
        labeler1 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        labeler2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labeler3 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        labeler4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        labeler5 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        labeler6 = new javax.swing.JLabel();
        labeler7 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        cmdActualizar = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        txtEmpresa = new javax.swing.JTextField();
        labeler8 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("0");
        getContentPane().add(lblID);
        lblID.setBounds(50, 20, 50, 20);

        labeler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler.setText("RAZON SOCIAL");
        getContentPane().add(labeler);
        labeler.setBounds(270, 60, 240, 20);

        labeler1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler1.setText("ID:");
        getContentPane().add(labeler1);
        labeler1.setBounds(10, 20, 50, 20);

        txtRazonSocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtRazonSocial);
        txtRazonSocial.setBounds(270, 80, 240, 20);

        labeler2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler2.setText("DIRECCION");
        getContentPane().add(labeler2);
        labeler2.setBounds(520, 60, 240, 20);

        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(520, 80, 240, 20);

        labeler3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler3.setText("TIPO:");
        getContentPane().add(labeler3);
        labeler3.setBounds(90, 20, 80, 20);

        cmbTipo.setBackground(new java.awt.Color(255, 255, 204));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGENTE", "CLIENTE", "PROVEEDOR" }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTipo);
        cmbTipo.setBounds(170, 20, 120, 20);

        labeler4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler4.setText("TELEFONO");
        getContentPane().add(labeler4);
        labeler4.setBounds(520, 100, 110, 20);

        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(520, 120, 110, 20);

        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCelular);
        txtCelular.setBounds(650, 120, 110, 20);

        labeler5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler5.setText("CELULAR");
        getContentPane().add(labeler5);
        labeler5.setBounds(650, 100, 110, 20);

        txtRut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtRut);
        txtRut.setBounds(20, 120, 170, 20);

        labeler6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler6.setText("RUT");
        getContentPane().add(labeler6);
        labeler6.setBounds(20, 100, 180, 20);

        labeler7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler7.setText("MAIL");
        getContentPane().add(labeler7);
        labeler7.setBounds(210, 100, 290, 20);

        txtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMail);
        txtMail.setBounds(210, 120, 290, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 120, 0, 2);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(200, 120, 0, 2);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 150, 760, 20);

        cmdActualizar.setBackground(new java.awt.Color(0, 153, 204));
        cmdActualizar.setText("ACTUALIZAR");
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdActualizar);
        cmdActualizar.setBounds(650, 20, 110, 23);

        cmdGuardar.setBackground(new java.awt.Color(102, 255, 102));
        cmdGuardar.setText("GUARDAR");
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdGuardar);
        cmdGuardar.setBounds(450, 20, 90, 23);

        cmdBorrar.setBackground(new java.awt.Color(255, 102, 102));
        cmdBorrar.setText("BORRAR");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdBorrar);
        cmdBorrar.setBounds(550, 20, 90, 23);

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 760, 380);

        txtEmpresa.setBackground(new java.awt.Color(204, 255, 204));
        txtEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmpresa);
        txtEmpresa.setBounds(20, 80, 240, 20);

        labeler8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeler8.setText("EMPRESA");
        getContentPane().add(labeler8);
        labeler8.setBounds(20, 60, 240, 20);

        cmbEstado.setBackground(new java.awt.Color(255, 255, 204));
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVOS", "BAJADOS" }));
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(340, 20, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ATRIBUTOS
    ComponentesLista unC = new ComponentesLista();
    
    //EVENTO
    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        // TODO add your handling code here:
        String id = "", empresa = "", razon = "", direccion = "", telefono = "", celular = "", mail = "", rut = "";
        
        try{id = tblLista.getValueAt(tblLista.getSelectedRow(), 0).toString();}catch(Exception ex){}
        try{empresa = tblLista.getValueAt(tblLista.getSelectedRow(), 1).toString();}catch(Exception ex){}
        try{razon = tblLista.getValueAt(tblLista.getSelectedRow(), 2).toString();}catch(Exception ex){}
        try{direccion = tblLista.getValueAt(tblLista.getSelectedRow(), 3).toString();}catch(Exception ex){}
        try{telefono = tblLista.getValueAt(tblLista.getSelectedRow(), 4).toString();}catch(Exception ex){}
        try{celular = tblLista.getValueAt(tblLista.getSelectedRow(), 5).toString();}catch(Exception ex){}
        try{mail = tblLista.getValueAt(tblLista.getSelectedRow(), 6).toString();}catch(Exception ex){}
        try{rut = tblLista.getValueAt(tblLista.getSelectedRow(), 7).toString();}catch(Exception ex){}
        
        lblID.setText(id);
        txtRazonSocial.setText(razon);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        txtCelular.setText(celular);
        txtMail.setText(mail);
        txtRut.setText(rut);
        txtEmpresa.setText(empresa);
        //refrescar(cmbEstado.getSelectedItem().toString());
        
    }//GEN-LAST:event_tblListaMouseClicked

    public void vaciarTextos()
    {
        lblID.setText("0");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        txtMail.setText("");
        txtRut.setText(""); 
        //txtEmpresa.setText("");
        //txtEmpresa.setText("");
    }
    
    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
        //refrescar("CLIENTE");
        String estado = cmbEstado.getSelectedItem().toString().substring(0,1);
        vaciarTextos();
        unC.cargarTabla("SELECT ID, EMPRESA, RAZON_SOCIAL, DIRECCION, TELEFONO, CELULAR, MAIL, RUT FROM sif_entidades WHERE TIPO = '" + cmbTipo.getSelectedItem() + "' and estado  = '" + estado + "' order by empresa", tblLista);        

    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            refrescar(cmbTipo.getSelectedItem().toString());
            //cmbTipo.setSelectedItem("CLIENTE");
            //vaciarTextos();
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        // TODO add your handling code here:
        String id = "", razon = "", direccion = "", telefono = "", celular = "", mail = "", rut = "", url = "", empresa = "";
        
        id = lblID.getText();
        razon =  txtRazonSocial.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();
        celular = txtCelular.getText();
        mail = txtMail.getText();
        rut = txtRut.getText();
        empresa = txtEmpresa.getText();
        
        if (id.equals("0"))
        {
            url = "insert into sif_entidades (empresa, razon_social, direccion, telefono, celular, mail, rut, tipo) values ('" + empresa + "','" + razon + "','" + direccion + "','" + telefono + "','" + celular + "','" + mail + "','" + rut + "','" + cmbTipo.getSelectedItem().toString() + "')";
        }
        else
        {
            url = "update sif_entidades set razon_social = '" + razon + "', direccion = '" + direccion + "', telefono = '" + telefono + "',  celular = '" + celular + "',  mail = '" + mail + "',  rut = '" + rut + "', estado = 'A'  where id = " + id + "";            
        }
 
        BD unb = new BD();    
        unb.StoreProcedure(url, "sif_agente");
        JOptionPane.showMessageDialog(null, "Procesado con éxito");
        vaciarTextos();
        refrescar(cmbTipo.getSelectedItem().toString());
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
        String id = "", razon = "", direccion = "", telefono = "", celular = "", mail = "", rut = "", url = "", empresa = "";
        
        id = lblID.getText();
        
        if (id.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "ID = 0. Seleccione un registro ya creado para dar de baja");
        }
        else
        {
            url = "update sif_entidades SET estado = 'B' where id = " + id + "";            
            BD unb = new BD();    
            unb.StoreProcedure(url, "sif_agente");
            JOptionPane.showMessageDialog(null, "Procesado con éxito");
            vaciarTextos();
            refrescar(cmbTipo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void txtEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyPressed
        // TODO add your handling code here:
//        refrescar(cmbTipo.getSelectedItem().toString());
    }//GEN-LAST:event_txtEmpresaKeyPressed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1)
        {
            refrescar(cmbTipo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void txtEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyReleased
        // TODO add your handling code here:
        refrescar(cmbTipo.getSelectedItem().toString());

    }//GEN-LAST:event_txtEmpresaKeyReleased

    //METODO
    public void abrir()
    {   
        //setLocationRelativeTo(null);
        this.setTitle("Entidades    -    SIF CARGAS");
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);
        refrescar("CLIENTE");
        cmbTipo.setSelectedItem("CLIENTE");
    }
     
    public void refrescar(String Tipo_Entidad)
    {
        String estado = cmbEstado.getSelectedItem().toString().substring(0,1);
        
        if(txtEmpresa.getText().equals(""))
        {
            unC.cargarTabla("SELECT ID, EMPRESA, RAZON_SOCIAL, DIRECCION, TELEFONO, CELULAR, MAIL, RUT FROM sif_entidades WHERE TIPO = '" + Tipo_Entidad + "' and estado  = '" + estado + "' order by empresa", tblLista);        
        }
        else
        {
            unC.cargarTabla("SELECT ID, EMPRESA, RAZON_SOCIAL, DIRECCION, TELEFONO, CELULAR, MAIL, RUT FROM sif_entidades WHERE empresa like '%" + txtEmpresa.getText() + "%' and TIPO = '" + Tipo_Entidad + "' and estado = '" + estado + "' order by empresa", tblLista);        
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labeler;
    private javax.swing.JLabel labeler1;
    private javax.swing.JLabel labeler2;
    private javax.swing.JLabel labeler3;
    private javax.swing.JLabel labeler4;
    private javax.swing.JLabel labeler5;
    private javax.swing.JLabel labeler6;
    private javax.swing.JLabel labeler7;
    private javax.swing.JLabel labeler8;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
