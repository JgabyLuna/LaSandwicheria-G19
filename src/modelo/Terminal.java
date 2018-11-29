/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Enlazador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.VistaComanda;
import vista.VistaFactura;

/**
 *
 * @author usuario
 */
public class Terminal {

    private Turno turno;
    private Venta venta;
    private Tienda tienda;

    public Terminal() {
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void IniciarSesion(String nombre, int legajo) {
        Cajero cajero = new Cajero(nombre, legajo);
        Turno t = new Turno();
        t.setCajero(cajero);
        this.setTurno(t);

    }

    public void crearVenta() {
        this.venta = new Venta();
    }

    public void introducirProducto(int id_Producto, int cantidad, CatalogoProducto catalogo) {
        Producto producto = new Producto();
        producto = catalogo.obtenerProducto(id_Producto);
        venta.agregarProducto(producto, cantidad);
    }

    public void introducirAgregado(int idp, ArrayList<Agregado> agregados, CatalogoProducto catalogo) {
        Producto producto = new Producto();
        producto.setAgregado(agregados);
        producto = catalogo.obtenerProducto(idp);
        venta.agregarProducto(producto, 1);
    }
    
    public void facturar(int cbteTipo, int nroDocumento, int docTipo, String montId) {
        Cliente cliente = new Cliente(nroDocumento, new DocTipo(docTipo, ""));
        Object [] resultado;        
        try {
            resultado = Enlazador.autorizarComprobante(tienda.getPtoVta().getNro(), cbteTipo, "91CCD580-37DB-4B27-8F49-B5BC4F786330", venta, montId, 1, 1, cliente, 1);
            String estado = (String)resultado [0];
            if (estado.equals("A")) {
                venta.setIsCompleta(true);
                venta.setNroFactura(Integer.parseInt(""+resultado [1]));
                venta.actualizarDisponibilidad();
            } else if (estado.equals("R")) {
                venta.setIsCompleta(false);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por el momento no se puede conectar al Sistema externo", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        finalizar();
    }

    public void obtenerRendicio(Turno turno) {
        turno.obtenerRendicion();
    }

    public void finalizarTurno(Turno turno, Cajero cajero) {

    }

    private void finalizar() {
        turno.finalizarTurno(venta);
        VistaComanda vista = new VistaComanda(venta);
        VistaFactura vista1 = new VistaFactura(tienda);
    }

}
