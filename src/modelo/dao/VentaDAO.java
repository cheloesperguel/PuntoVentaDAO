/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import modelo.Vendedor;
import modelo.Venta;

/**
 *
 * @author Marcelo Esperguel
 */
public class VentaDAO {
    
    Conexion con;
    
    public VentaDAO(){
        this.con=new Conexion();
    }
    
 
    
    public boolean registrarVenta(Venta nuevaVenta) throws SQLException{
        Connection accesoBD = con.getConexion();
        
        String sucursal= nuevaVenta.getSucursal();
        int monto = nuevaVenta.getMonto();
        String fecha = nuevaVenta.getFecha();
        int idVendedor = nuevaVenta.getVendedor().getId();

        try{
            String sql="INSERT INTO venta (id_venta, sucursal, monto, fecha, id_vendedor) VALUES (NULL, '"+sucursal+"', '"+monto+"', '"+fecha+"', '"+idVendedor+"')";
            
            
            //ejemplo: SELECT * FROM Customers WHERE Country='Mexico'; 
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            
            
            st.executeUpdate(sql);
            System.out.println("Venta ingresada con exito");
            accesoBD.close();
            return true;
            
           
        }catch (Exception e){
            System.out.println("Error al ingresar venta");
            accesoBD.close();
            return false;
        }
        
    }
    
    public ArrayList<Venta> getVentas() throws SQLException{
        
        ArrayList<Venta> ventas = new ArrayList();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM ventas";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id= Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("apellido");
                String fecha =resultados.getString("fecha");
                int idVendedor= resultados.getInt("id_vendedor");
                
                
                
                //Obtengo el vendedor de cada venta
                String sqlVendedor = "SELECT * FROM vendedor WHERE id = "+idVendedor;
               
                try{
                    ResultSet resVendedor = st.executeQuery(sql);
                    while(resVendedor.next()){
                        int idVendedorBD= Integer.parseInt(resVendedor.getString("id_vendedor"));
                        String nombre = resultados.getString("nombre");
                        String apellido = resultados.getString("apellido");
                        String rut =resultados.getString("rut");

                        Vendedor v = new Vendedor(idVendedorBD,nombre, apellido,rut);
                        //Ya teniendo el vendedor creo una venta y la añado a la lista
                        ventas.add(new Venta(id, sucursal, monto, fecha, v));
                    }
          
                }catch(Exception ex2){
                    System.out.println("Error al obtener el vendedor de la venta");
                }
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al obtener");
             accesoBD.close();
            return null;
        }
        
        
    }
    
    public ArrayList<Venta> getVentasMes(int mes) throws SQLException{
        
        ArrayList<Venta> ventas = new ArrayList();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM venta WHERE MONTH(fecha) = "+mes+" AND YEAR(fecha) = "+2019; //ASume solo año 2019
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id= Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha =resultados.getString("fecha");
                int idVendedor= resultados.getInt("id_vendedor");
                
                
                
                //Obtengo el vendedor de cada venta
                String sqlVendedor = "SELECT * FROM vendedor WHERE id_vendedor = "+idVendedor;
               
                try{
                    Statement stVendedor = accesoBD.createStatement();
                    ResultSet resVendedor = stVendedor.executeQuery(sqlVendedor);
                    while(resVendedor.next()){
                        int idVendedorBD= Integer.parseInt(resVendedor.getString("id_vendedor"));
                        String nombre = resVendedor.getString("nombre");
                        String apellido = resVendedor.getString("apellido");
                        String rut =resVendedor.getString("rut");

                        Vendedor v = new Vendedor(idVendedorBD,nombre, apellido,rut);
                        //Ya teniendo el vendedor creo una venta y la añado a la lista
                        ventas.add(new Venta(id, sucursal, monto, fecha, v));
                    }
          
                }catch(Exception ex2){
                    System.out.println("Error al obtener el vendedor de la venta");
                    ex2.printStackTrace();
                }
                
                
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al obtener");
             accesoBD.close();
             e.printStackTrace();
            return null;
        }
        
        
    }
}
