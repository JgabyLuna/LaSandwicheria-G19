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
public class Producto {
    private int id_Producto;
    private String nombre;
    private double precio;
    private int cantidad;
    private ArrayList<Agregado> agregado = new ArrayList();
    private Rubro rubro;

    public Producto() {
       
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Agregado> getAgregado() {
        return agregado;
    }

    public void setAgregado(Agregado agregado) {
        this.agregado.add(agregado);
    }

    public void setAgregado(ArrayList<Agregado> agregado) {
        this.agregado = agregado;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
    public Producto(int id_Producto, String nombre, double precio, int cantidad) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.precio = precio;        
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
