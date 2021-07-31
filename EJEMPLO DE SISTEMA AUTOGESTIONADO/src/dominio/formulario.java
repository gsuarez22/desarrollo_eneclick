/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import gui.frmABMFlota;
import gui.frmABMUsuarios;
import gui.frmRepFallas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class formulario implements ActionListener
{
    public JMenuBar mb;
    public controlador miControlador;
    private ArrayList menus = new ArrayList();
    
    public formulario(JMenuBar mb, controlador mic) 
    {
        miControlador = mic;
        inicializarMenu();  
        
        String Madre = "";
        JMenu menu1 = new JMenu();
        
        for(int i=0;i < menus.size();i++)
        {
            menu m = (menu) menus.get(i);            
            if(m.menumadre.equals(Madre) == false)
            {
                menu1 = new JMenu(m.menumadre);
                mb.add(menu1);            
                Madre = m.menumadre;
            }
            
            JMenuItem mi1 = new JMenuItem(m.menuhijo);
            mi1.addActionListener(this);
            menu1.add(mi1);
        }
   
    }
    
    private void inicializarMenu()
    {
        String url = "SELECT m.id, m.menumadre, m.menuhijo, m.formulario FROM eme_flota.menus m, eme_flota.permisos p where p.id_usuario = '" + miControlador.miUsuario.id_usuario + "' and p.id_acceso = m.id order by m.menumadre";
        menus = new ArrayList();
        
        try
        {
            BD unB = new BD();
            CachedRowSet lista = unB.Function(url, "eme_flota");
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            
            while(lista.next())
            {
                menu m = new menu();
                m.id = lista.getString("id");
                m.menuhijo = lista.getString("menuhijo");
                m.menumadre = lista.getString("menumadre");
                m.formulario = lista.getString("formulario");
                menus.add(m);
            }
            
        }
        catch (Exception ex)
        {
        }
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String accion = e.getActionCommand();
    	ejecutar(accion);                
    }

    public void ejecutar (String accion)
    {
        int i = 0;

        while(i < menus.size())
        {
            menu m = (menu) menus.get(i);
            if(m.menuhijo.equals(accion))
            {
                if(m.formulario.equals("frmABMFlota")){frmABMFlota frm = new frmABMFlota(); frm.abrir(miControlador);}
                if(m.formulario.equals("frmABMUsuarios")){frmABMUsuarios frm = new frmABMUsuarios(); frm.abrir(miControlador);}
                if(m.formulario.equals("frmRepFallas")){frmRepFallas frm = new frmRepFallas(); frm.abrir(miControlador);}
                
                i = menus.size();
            }
            i++;
        }
    
    }
    
}