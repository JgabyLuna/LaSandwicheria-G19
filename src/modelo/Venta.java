/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

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
        obtenerFecha();
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

    public void setTotal() {
        this.total = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            this.total = this.total + lineaVenta.getSubTotal();
        }
        
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

    public void agregarProducto(Producto producto, int cantidad) {
        setLineasVenta(producto, cantidad);
        setTotal();
    }

    public final void obtenerFecha() {
//        Calendar cal1 = Calendar.getInstance();
//        int anioI = cal1.get(Calendar.YEAR);
//        int mesI = cal1.get(Calendar.MONTH);
//        int diaI = cal1.get(Calendar.DATE);
//        String mes = ("" + mesI);
//        if(mes.length() < 2)
//            mes = ("0" + mes);
//        String dia = ("" + diaI);
//        if(dia.length() < 2)
//            dia = ("0" + dia);
//        this.setFecha(anioI + "" + mes + "" + dia);
        this.setFecha("20180912");
    }

}
