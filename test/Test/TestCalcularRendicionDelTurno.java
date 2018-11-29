/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.Creador;
import modelo.Producto;
import modelo.Turno;
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
public class TestCalcularRendicionDelTurno {
    
    public TestCalcularRendicionDelTurno() {
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
         Turno t = new Turno();
         Producto p1 = Creador.getProducto(1);
         Producto p2 = Creador.getProducto(4);
         Producto p3 = Creador.getProducto(5);
        
         Venta v1 = new Venta();
         v1.agregarProducto(p1, 2);
         v1.agregarProducto(p2, 1);
         t.setVentas(v1);
     
         Venta v2 = new Venta();
         v2.agregarProducto(p1, 2);
         v2.agregarProducto(p3, 1);
         t.setVentas(v2);
     
         //Ejecucion
         double actual = t.calcularRendicion();
         double esperado = 410;
         //Comprobacion
         assertEquals(esperado, actual, 0);
     }
}
