/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Vendedor;
import modelo.Venta;
import modelo.dao.VentaDAO;
import vista.RegistrarVenta;

/**
 *
 * @author Marcelo Esperguel
 */
public class VentaController implements ActionListener{
    
    RegistrarVenta regVenta;
    
    public VentaController(RegistrarVenta regVenta) {
        this.regVenta=regVenta;
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        VentaDAO ventaDao = new VentaDAO();
        
        Vendedor vendedor =(Vendedor) regVenta.getVendedorCb().getSelectedItem();
        String sucursal = regVenta.getsucursalCb().getSelectedItem().toString();
        int monto = Integer.parseInt( regVenta.getMontoTf().getText());
        String fecha = regVenta.getFechaTf().getText();
        
        try{
            
            boolean resp=ventaDao.registrarVenta(new Venta(sucursal, monto, fecha, vendedor));
           
            if(resp){
                JOptionPane.showMessageDialog(regVenta, "Venta Ingresada con exito");
                regVenta.dispose();
                
            }else{
               System.out.println("Error al registrar venta"); 
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Error al registrar venta");
        }
    }
    
}
