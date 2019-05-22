/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Vendedor;
import modelo.Venta;
import modelo.dao.VendedorDAO;
import modelo.dao.VentaDAO;
import vista.Reporte;

/**
 *
 * @author Marcelo Esperguel
 */
public class ReporteController implements ActionListener{

    Reporte ventanaReporte;
    
    public ReporteController(Reporte ventanaReporte){
        
        this.ventanaReporte = ventanaReporte;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        VentaDAO vDao = new VentaDAO();
        String mesConsulta = ventanaReporte.getMesesCb().getSelectedItem().toString();
        
        System.out.println("Reporte para el mes: "+mesConsulta);
        try{
            ArrayList<Venta> ventas = vDao.getVentasMes(getIntMes(mesConsulta));
            
            Venta mayorVenta = calculaMayorVenta(ventas);
            Vendedor mejorVendedor = calculaMejorVendedor(ventas);
            
            ventanaReporte.getMejorVendedorLabel().setText("$ "+mejorVendedor.getNombre()+" "+mejorVendedor.getApellido());
            ventanaReporte.getTotalVentasLabel().setText("$ "+totalVendedor(ventas,mejorVendedor));
            //////////////////////
            ventanaReporte.getMayorVentaLabel().setText("$ "+mayorVenta.getMonto());
            ventanaReporte.getVendedorLabel().setText("$ "+ mayorVenta.getVendedor().getNombre()+" "+mayorVenta.getVendedor().getApellido());
            ///////////////////////
            ventanaReporte.getPromVentasLabel().setText("$ "+ calculaPromVentas(ventas) );
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(ventanaReporte, "Error al obtener información del mes");
            ex.printStackTrace();
        }
        
        
    }
    
    public int getIntMes(String mes){
        
        switch (mes) {
            case "Enero":
                return 1;
            case "Febrero":
                return 2;
            case "Marzo":
                return 3;
            case "Abril":
                return 4;
            case "Mayo":
                return 5;
            case "Junio":
                return 6;
            case "Julio":
                return 7;
            case "Agosto":
                return 8;
            case "Septiembre":
                return 9;
            case "Octubre":
                return 10;
            case "Noviembre":
                return 11;
            case "Diciembre":
                return 12;
            default:
                return  -1;
        }
        
    }
    
    public Vendedor calculaMejorVendedor(ArrayList<Venta> ventas) throws SQLException{
        VendedorDAO vendedorDao = new VendedorDAO();
        
        ArrayList<Vendedor> vendedores = vendedorDao.getVendedores();
        
        Vendedor vendedorAux = vendedores.get(0);
        int montoVendedorAux =  totalVendedor(ventas,vendedores.get(0));
        
        for (int i = 1; i < vendedores.size(); i++) {
            
            int montoaux=totalVendedor(ventas,vendedores.get(i));
            if(montoVendedorAux<montoaux){
                vendedorAux=vendedores.get(i);
                montoVendedorAux=montoaux;
            }
        }
        return vendedorAux;
    }
    
    public int totalVendedor(ArrayList<Venta> ventas, Vendedor vendedor){
        
        ArrayList<Venta> subVentas = new ArrayList();
        
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).getVendedor().getId()==vendedor.getId()){
                subVentas.add(ventas.get(i));
            }
        }
        
        int sumaVendedor=0;
        for (int i = 0; i < subVentas.size(); i++) {
            sumaVendedor+= subVentas.get(i).getMonto();
            
        }
        
        
        return sumaVendedor;
    }
    
    
    public int calculaPromVentas(ArrayList<Venta> ventas){
        
        int sumaTotal=0;
        for (int i = 0; i < ventas.size(); i++) {
            sumaTotal+=ventas.get(i).getMonto();
            
        }
        
        return sumaTotal/ventas.size();
    }
    
    public Venta calculaMayorVenta(ArrayList<Venta> ventas){
        Venta mayor = ventas.get(0); //temporal
        
        for (int i = 0; i < ventas.size(); i++) {
            if(mayor.getMonto()<ventas.get(i).getMonto()){
                mayor=ventas.get(i);
            }
            
        }
        
        return mayor;
    }
}
