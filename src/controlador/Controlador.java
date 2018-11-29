/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Terminal;
import modelo.*;

/**
 *
 * @author usuario
 */
public class Controlador {

    private IVenta vista;
    private IFinSesion vistaFS;

    public Controlador(IVenta vista) {
        this.setVista(vista);
    }
 
    public Controlador(IFinSesion vista){
        this.setVistaFS(vista);
    }

    public IVenta getVista() {
        return vista;
    }

    public void setVista(IVenta vista) {
        this.vista = vista;
    }
    public void setVistaFS(IFinSesion vista){
        this.vistaFS = vista;
    }
    //metodo que se encargue de capturar los datos de un producto y llame un metodo de terminal
    public void crearVenta(Terminal terminal) {
        terminal.crearVenta();
        System.out.println("Venta Creada");
    }

    public void agregarProducto(Terminal terminal, int cantidad, int idp) {
        terminal.introducirProducto(idp, cantidad, Creador.getCatalogo());        
    }
    
    //TODO
//    public void agregarAgregado(Terminal terminal, int idp, ArrayList<Agregado> agregados) {
//        terminal.introducirAgregado(idp, agregados, Creador.getCatalogo());
//    }
//
//    public boolean disponibilidad(String text, String text0) {
//        return true;
//    }
//
//    public boolean isSandwich(String text) {
//        int codigo = Integer.parseInt(text);
//        if (codigo == 1 || codigo == 2) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static Producto getProducto(String codigo) {
//        return Creador.getProducto(Integer.parseInt(codigo));
//    }

    public void facturar(Terminal terminal, int cbteTipo, int nroDocumento, int docTipo, String montId) {
        terminal.facturar(cbteTipo, nroDocumento, docTipo, montId);
    }
    
    public void ObtenerRecaudacion(Terminal terminal){
        terminal.getTurno().obtenerRendicion();
    }
    
}
