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
public class LineaVenta {
    private int cantidad;
    private double subTotal;
    private Producto producto;
    private ArrayList<Agregado> agregados = new ArrayList();

    public LineaVenta() {
    }

    public LineaVenta(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal() {
        double precioP = 0;
        if(!getProducto().getAgregado().isEmpty()){
         for (int i = 0; i < getProducto().getAgregado().size(); i++) {
            if(getProducto().getAgregado().get(i).isIncluido()){
                precioP = getProducto().getPrecio() + getProducto().getAgregado().get(i).getPrecio();
            }
        }
         
        } else
            precioP = getProducto().getPrecio();
        this.subTotal = precioP * getCantidad();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Agregado> getAgregados() {
        return agregados;
    }

    public void setAgregados(ArrayList<Agregado> agregados) {
        this.agregados = agregados;
    }
    
    
}
