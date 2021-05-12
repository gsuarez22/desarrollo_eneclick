/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import gui.frmABMProductos;
import gui.frmMenu;
import gui.frmPrecios;

/**
 *
 * @author sistemas
 */
public class Galena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmABMProductos unA = new frmABMProductos();
        unA.abrir();
        frmPrecios unP = new frmPrecios();
        unP.abrir();
        frmMenu unM = new frmMenu();
        unM.abrir();
        
    }
    
}
