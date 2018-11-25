/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.CatalogoProducto;
import modelo.Rubro;
import modelo.Venta;
import modelo.Producto;

/**
 *
 * @author usuario
 */
public interface IVenta {
    public void mostrarRubros();
    public void mostrarProductos(CatalogoProducto catalogo, Rubro rubro);
    public void mostrarDetaVenta(Producto producto, int cantidad);
}
