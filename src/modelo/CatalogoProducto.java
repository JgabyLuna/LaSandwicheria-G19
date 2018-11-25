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
public class CatalogoProducto {
    private ArrayList<Producto> productos = new ArrayList();

    public CatalogoProducto() {
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Producto producto) {
        this.productos.add(producto);
    }

    public Producto obtenerProducto(int idP, int cantidad) {
        for (Producto producto : productos) {
            if(producto.getId_Producto() == idP)
                return producto;
        }
        return null;
    }
}
