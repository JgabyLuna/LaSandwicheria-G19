/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author usuario
 */
public class Creador {

    public static void crear() {
        //datos del punto de venta

//        
//        //productos
//        Producto p1 = new Producto(1, "Sandwich de Milanesa", 60, Rubro.SANDWICH);
//        Producto p2 = new Producto(2, "queso", 5, Rubro.AGREGADO);
//        Producto p3 = new Producto(3, "jamon", 5, Rubro.AGREGADO);
//        Producto p4 = new Producto(4, "huevo", 5, Rubro.AGREGADO);
//        
//        Producto p5 = new Producto(5, "gaseosa cola 500ml", 40, Rubro.BEBIDA_SIN_ALCOHOL);
//
//        //catalogo
//        CatalogoProducto catalogo = new CatalogoProducto();
//        catalogo.setProductos(p1);
//        catalogo.setProductos(p2);
//        catalogo.setProductos(p3);
//        catalogo.setProductos(p4);
//        catalogo.setProductos(p5);
        //cajeros
        Cajero c1 = new Cajero("Juan", 1234);
        Cajero c2 = new Cajero("Juan", 5678);

        //pasa cajeros a tienda
        Tienda t = new Tienda();
        t.setCajeros(c1);
        t.setCajeros(c2);

    }

    public static Tienda getTienda() {
        Tienda t = new Tienda();
        Cajero c1 = new Cajero("Juan", 1234);
        Cajero c2 = new Cajero("Juan", 5678);
        t.setCajeros(c1);
        t.setCajeros(c2);
        return t;
    }

    public static CatalogoProducto getCatalogo() {
        //rubros
        Rubro r1 = new Rubro("Sandwich", 1);
        Rubro r2 = new Rubro("Bebidas Sin Alcohol", 2);                
        Rubro r3 = new Rubro("Bebidas Con Alcohol", 3);   
        
        //agregados
        Producto p10 = new Producto(10, "queso", 5, 100);
        Producto p11 = new Producto(11, "jamon", 5, 100);
        Producto p12 = new Producto(12, "huevo", 5, 100);
        Producto p13 = new Producto(13, "aji", 5, 100);
        
        Producto p14 = new Producto(14, "tomate", 0, 0);
        Producto p15 = new Producto(15, "lechuga", 0, 0);
        Producto p16 = new Producto(16, "mayonesa", 0, 0);
        Producto p17 = new Producto(17, "mostaza", 0, 0);
        
        //agregados milanesa
        Agregado m0 = new Agregado(false, 5.0, p10);
        Agregado m1 = new Agregado(false, 5.0, p11);
        Agregado m2 = new Agregado(false, 5.0, p12);
        Agregado m3 = new Agregado(false, 5.0, p13);
        //agregados milanesa especial
        Agregado a0 = new Agregado(true, 0, p10);
        Agregado a1 = new Agregado(true, 0, p11);
        Agregado a2 = new Agregado(true, 0, p12);
        Agregado a3 = new Agregado(true, 0, p13);
        
        Agregado a4 = new Agregado(true, 0, p14);
        Agregado a5 = new Agregado(true, 0, p15);
        Agregado a6 = new Agregado(true, 0, p16);
        Agregado a7 = new Agregado(true, 0, p17);
        
        //productos                
        Producto p1 = new Producto(1, "Milanesa", 60, 100);
        p1.setAgregado(a4);
        p1.setAgregado(a5);
        p1.setAgregado(a6);
        p1.setAgregado(a7);
        p1.setAgregado(m0);
        p1.setAgregado(m1);
        p1.setAgregado(m2);
        p1.setAgregado(m3);
        
        p1.setRubro(r1);
        
        Producto p2 = new Producto(2, "Milanesa Especial", 90, 100);        
        p2.setAgregado(a4);
        p2.setAgregado(a5);
        p2.setAgregado(a6);
        p2.setAgregado(a7);
        p2.setAgregado(a0);
        p2.setAgregado(a1);
        p2.setAgregado(a2);
        p2.setAgregado(a3);
        
        p2.setRubro(r1);

        Producto p3 = new Producto(3, "gaseosa cola 500ml", 40, 100);
        p3.setRubro(r2);
        Producto p4 = new Producto(4, "gaseosa cola 1000ml", 80, 100);
        p4.setRubro(r2);

        Producto p5 = new Producto(5, "cerveza 900ml", 90, 100);
        p5.setRubro(r3);

        //catalogo
        CatalogoProducto catalogo = new CatalogoProducto();
        catalogo.setProductos(p1);
        catalogo.setProductos(p2);
        catalogo.setProductos(p3);
        catalogo.setProductos(p4);
        catalogo.setProductos(p5);        

        return catalogo;
    }

    public static Producto getProducto(int idp) {
        Producto p = new Producto();
        CatalogoProducto catalogo = getCatalogo();
        for (Producto producto : catalogo.getProductos()) {
            if (producto.getId_Producto() == idp) {
                p = producto;
            }
        }
        return p;
    }
    
    public static ArrayList<Agregado> getAgregados (){
        ArrayList<Agregado> agregados = new ArrayList();
        //agregados
        Producto p10 = new Producto(10, "queso", 5, 100);
        Producto p11 = new Producto(11, "jamon", 5, 100);
        Producto p12 = new Producto(12, "huevo", 5, 100);
        Producto p13 = new Producto(13, "aji", 5, 100);
        
        Producto p14 = new Producto(14, "tomate", 0, 0);
        Producto p15 = new Producto(15, "lechuga", 0, 0);
        Producto p16 = new Producto(16, "mayonesa", 0, 0);
        Producto p17 = new Producto(17, "mostaza", 0, 0);
        
        //agregados milanesa
        Agregado m0 = new Agregado(false, 5.0, p10);
        Agregado m1 = new Agregado(false, 5.0, p11);
        Agregado m2 = new Agregado(false, 5.0, p12);
        Agregado m3 = new Agregado(false, 5.0, p13);
        //agregados milanesa especial
        Agregado a0 = new Agregado(true, 0, p10);
        Agregado a1 = new Agregado(true, 0, p11);
        Agregado a2 = new Agregado(true, 0, p12);
        Agregado a3 = new Agregado(true, 0, p13);
        
        Agregado a4 = new Agregado(true, 0, p14);
        Agregado a5 = new Agregado(true, 0, p15);
        Agregado a6 = new Agregado(true, 0, p16);
        Agregado a7 = new Agregado(true, 0, p17);
        
        agregados.add(m0);
        agregados.add(m1);
        agregados.add(m2);
        agregados.add(m3);
        agregados.add(a0);
        agregados.add(a1);
        agregados.add(a2);
        agregados.add(a3);
        agregados.add(a4);
        agregados.add(a5);
        agregados.add(a6);
        agregados.add(a7);
        
        return agregados;
    }
    
    public static Rubro [] getRubro(){
        //rubros
        Rubro r1 = new Rubro("Sandwich", 1);
        Rubro r2 = new Rubro("Bebidas Sin Alcohol", 2);                
        Rubro r3 = new Rubro("Bebidas Con Alcohol", 3);   
                        
        return (new Rubro [] { r1, r2, r3 });
    }
}
