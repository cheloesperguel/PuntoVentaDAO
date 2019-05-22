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
import modelo.Vendedor;

/**
 *
 * @author Marcelo Esperguel
 */
public class VendedorDAO {
    
    Conexion con;
    public VendedorDAO() {
        con = new Conexion();
    }
    
    public ArrayList<Vendedor> getVendedores() throws SQLException{
        
        ArrayList<Vendedor> vendedores = new ArrayList();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM vendedor";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id= Integer.parseInt(resultados.getString("id_vendedor"));
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut =resultados.getString("rut");
                
                vendedores.add(new Vendedor(id,nombre, apellido,rut));
            }
            accesoBD.close();
            return vendedores;
        }catch (Exception e){
            System.out.println("Error al obtener");
             accesoBD.close();
            return null;
        }
    }
}
