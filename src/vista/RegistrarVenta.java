/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.VendedorController;
import controlador.VentaController;
import javax.swing.*;
import modelo.Vendedor;
/**
 *
 * @author Marcelo Esperguel
 */
public class RegistrarVenta extends JFrame{

    private JTextField fechaTf;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField montoTf;
    private JButton registrarVentaButton;
    private JComboBox<String> sucursalCb;
    private JComboBox<Vendedor> vendedorCb;
    
    public RegistrarVenta() {
        super("Registrar nueva venta");
        initComponents();
        
        VendedorController vendCont = new VendedorController(this);
        vendCont.cargarEmpleados(); //
        
        VentaController ventaCont = new VentaController(this);
        registrarVentaButton.addActionListener(ventaCont);
        
         
        
    }

    public JComboBox<Vendedor> getVendedorCb() {
        return vendedorCb;
    }

    public void setVendedorCb(JComboBox<Vendedor> vendedorCb) {
        this.vendedorCb = vendedorCb;
    }

    public JTextField getFechaTf() {
        return fechaTf;
    }

    public void setFechaTf(JTextField fechaTf) {
        this.fechaTf = fechaTf;
    }

    public JTextField getMontoTf() {
        return montoTf;
    }

    public void setMontoTf(JTextField montoTf) {
        this.montoTf = montoTf;
    }

    public JComboBox<String> getsucursalCb() {
        return sucursalCb;
    }

    public void setsucursalCb(JComboBox<String> sucursalTf) {
        this.sucursalCb = sucursalTf;
    }
    
    
    private void initComponents() {

        registrarVentaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        vendedorCb = new javax.swing.JComboBox<>();
        sucursalCb = new javax.swing.JComboBox<String>();
        fechaTf = new javax.swing.JTextField();
        montoTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registrarVentaButton.setText("Registrar");

        jLabel1.setText("Vendedor:");

        jLabel2.setText("Sucursal:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Monto:");
        
        sucursalCb.addItem("Centro");
        sucursalCb.addItem("Portal Temuco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vendedorCb, 0, 174, Short.MAX_VALUE)
                            .addComponent(sucursalCb)
                            .addComponent(fechaTf)
                            .addComponent(montoTf)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(registrarVentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vendedorCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sucursalCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(fechaTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(montoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registrarVentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }
    
}
