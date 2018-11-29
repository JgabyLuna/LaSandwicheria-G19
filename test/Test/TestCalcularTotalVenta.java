/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.Creador;
import modelo.Producto;
import modelo.Venta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TestCalcularTotalVenta {
    
    public TestCalcularTotalVenta() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
        //Definicion
        Venta v = new Venta();
        Producto p1 = Creador.getProducto(1);// precio del producto = 60
        v.setLineasVenta(p1, 3);
        Producto p2 = Creador.getProducto(3);// precio del producto = 40;
        v.setLineasVenta(p2, 3);
        Producto p3 = Creador.getProducto(5);// precio del producto = 90;
        v.setLineasVenta(p3, 1);
     
        //Ejecucion
        double actual = v.calcularTotal();
        double esperado = 390;
     
        //Comprobacion
        assertEquals(esperado, actual, 0);
     }
}
