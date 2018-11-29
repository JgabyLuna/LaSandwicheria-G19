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
public class TestConsultarDisponibilidadDeProducto {
    
    public TestConsultarDisponibilidadDeProducto() {
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

    
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         //Definicion
         Venta v = new Venta();
         Producto p1 = Creador.getCatalogo().getProductos().get(0);
         v.setLineasVenta(p1, 2);
         
         //Ejecucion
         boolean actual = v.consultarDisponibilidad(p1, 3);
         boolean esperado = true;
                  
         //Comprobacion
         assertEquals(esperado, actual);
     }
}
