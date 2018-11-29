/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author usuario
 */
public class Venta {

    private String fecha;
    private double total;
    private boolean isCompleta;
    private ArrayList<LineaVenta> lineasVenta = new ArrayList();
    private int nroFactura;

    public Venta() {
        this.setFecha("" + obtenerFecha());
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isIsCompleta() {
        return isCompleta;
    }

    public void setIsCompleta(boolean isCompleta) {
        this.isCompleta = isCompleta;
    }

    public ArrayList<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(Producto p, int cantidad) {
        LineaVenta lv = new LineaVenta(cantidad, p);
        lv.setSubTotal();
        this.lineasVenta.add(lv);
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }
    
    
    public void agregarProducto(Producto producto, int cantidad) {
        this.setLineasVenta(producto, cantidad);
        this.setTotal(calcularTotal());
    }

    public boolean consultarDisponibilidad(Producto pro, int cantidad) {
        return pro.consultarDisponibilidad(cantidad);
    }

    public void actualizarDisponibilidad() {
        for (int i = 0; i < this.lineasVenta.size(); i++) {
            this.lineasVenta.get(i).getProducto().actualizarDisponibilidad(this.lineasVenta.get(i).getCantidad());
        }
    }

    public final int obtenerFecha() {
        int fecha;
        Calendar cal1 = Calendar.getInstance();
        int anio = cal1.get(Calendar.YEAR);
        int mes = cal1.get(Calendar.MONTH);
        int dia = cal1.get(Calendar.DATE);
        fecha = Integer.parseInt("" + anio + mes + dia);
        return fecha;

    }

    public double calcularTotal() {
        double total = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            total = total + lineaVenta.getSubTotal();
        }
        return total;
    }
}
