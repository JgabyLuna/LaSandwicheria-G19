/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Enlazador;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Terminal {

    private ArrayList<Turno> turnos = new ArrayList();
    private Venta venta;
    private Tienda tienda;

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno turno) {
        this.turnos.add(turno);
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
        Turno turno = new Turno();
        turno.setCajero(cajero);
        this.setTurnos(turno);

    }

    public void crearVenta() {
        Venta v = new Venta();
        this.venta = v;
    }

    public void introducirProducto(int id_Producto, int cantidad, CatalogoProducto catalogo) {
        Producto producto = new Producto();
        producto = catalogo.obtenerProducto(id_Producto, cantidad);
        venta.agregarProducto(producto, cantidad);
//        v.setTotal();
//        System.out.println(v.getTotal());
//        // hacer venta.crearDetaVenta()
    }

    public void introducirAgregado(int idp, ArrayList<Agregado> agregados, CatalogoProducto catalogo) {
        Producto producto = new Producto();
        producto.setAgregado(agregados);
        producto = catalogo.obtenerProducto(idp, 1);
        venta.agregarProducto(producto, 1);
    }

    public void facturar(int cbteTipo, int nroDocumento, int docTipo, String montId) {
        Cliente cliente = new Cliente(nroDocumento, new DocTipo(docTipo, ""));
        String estado = "";
        estado = Enlazador.autorizarComprobante(tienda.getPtoVta().getNro(), cbteTipo, "91CCD580-37DB-4B27-8F49-B5BC4F786330", venta, montId, 1, 1, cliente, 1);
        if (estado.equals("A")) {
            venta.setIsCompleta(true);
        } else if (estado.equals("R")) {
            venta.setIsCompleta(false);
        }
        //mostrar el resultado por pantalla
        System.out.println(estado);
        finalizar();
    }

    public void obtenerRendicio(Turno turno) {
        turno.obtenerRendicion();
    }

    public void finalizarTurno(Turno turno, Cajero cajero) {

    }

    private void finalizar() {
        turnos.get(turnos.size() - 1).finalizarTurno(venta);
    }

}
