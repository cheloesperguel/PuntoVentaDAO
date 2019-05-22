/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Marcelo Esperguel
 */
public class Venta {
    
    private int id;
    private String sucursal;
    private int monto;
    private String fecha;
    private Vendedor vendedor;

    public Venta(int id, String sucursal, int monto, String fecha, Vendedor vendedor) {
        this.id = id;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }

    public Venta(String sucursal, int monto, String fecha, Vendedor vendedor) {
        
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
    
}
