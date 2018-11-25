/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Terminal;
import modelo.*;
import vista.*;

/**
 *
 * @author usuario
 */
public class Controlador {

    private IVenta vista;
    private IFactura vistaF;

    public Controlador(IVenta vista) {
        //vista.mostrarProductos(Creador.getCatalogo());
        this.setVista(vista);
    }

    public Controlador(IFactura vista, Terminal terminal) {
        this.setVistaF(vista);
        vista.mostrar(terminal.getVenta());
    }

    public IFactura getVistaF() {
        return vistaF;
    }

    public void setVistaF(IFactura vistaF) {
        this.vistaF = vistaF;
    }

    public IVenta getVista() {
        return vista;
    }

    public void setVista(IVenta vista) {
        this.vista = vista;
    }

    //metodo que se encargue de capturar los datos de un producto y llame un metodo de terminal
    public void crearVenta(Terminal terminal) {
        //vista.mostrarProductos(Creador.getCatalogo());
        terminal.crearVenta();
        System.out.println("Venta Creada");
    }

    public void agregarProducto(Terminal terminal, int cantidad, int idp) {
        terminal.introducirProducto(idp, cantidad, Creador.getCatalogo());
        System.out.println("Producto: "+Creador.getProducto(idp).getNombre()+" Agregado");
        //vista.mostrarDetaVenta(terminal.getVenta());
    }

    public void agregarAgregado(Terminal terminal, int idp, ArrayList<Agregado> agregados) {
        terminal.introducirAgregado(idp, agregados, Creador.getCatalogo());
        //vista.mostrarDetaVenta(terminal.getVenta());
    }

    public boolean disponibilidad(String text, String text0) {
        return true;
    }

    public boolean isSandwich(String text) {
        int codigo = Integer.parseInt(text);
        if (codigo == 1 || codigo == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static Producto getProducto(String codigo) {
        return Creador.getProducto(Integer.parseInt(codigo));
    }

    public void facturar(Terminal terminal, int cbteTipo, int nroDocumento, int docTipo, String montId) {
        terminal.facturar(cbteTipo, nroDocumento, docTipo, montId);
    }

    public void mostrarVistaFactura(Tienda tienda) {
        VistaFacturar vista3 = new VistaFacturar(tienda);
    }

}
