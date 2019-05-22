/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import modelo.Vendedor;
import modelo.dao.VendedorDAO;
import vista.RegistrarVenta;

/**
 *
 * @author Marcelo Esperguel
 */
public class VendedorController implements ActionListener{
    
    RegistrarVenta ventanaRegistrar;

    public VendedorController(RegistrarVenta ventanaRegistrar) {
        this.ventanaRegistrar=ventanaRegistrar;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        VendedorDAO vendDao = new VendedorDAO();
     
    }
    
    public void cargarEmpleados(){
        VendedorDAO vendDao = new VendedorDAO();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        
        try{
            vendedores = vendDao.getVendedores(); 
            JComboBox vendedoresCB = ventanaRegistrar.getVendedorCb();
        
            vendedoresCB.removeAllItems();
            for (int i = 0; i < vendedores.size(); i++) {
 
                vendedoresCB.addItem(vendedores.get(i));
            }

            ventanaRegistrar.setVendedorCb(vendedoresCB);
        }catch(Exception e){
            System.out.println("Hubo un error al cargar vendedores");
        }
        
        
        
        
    }
    
}
