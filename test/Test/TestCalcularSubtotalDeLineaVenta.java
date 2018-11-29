/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.Creador;
import modelo.LineaVenta;
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
public class TestCalcularSubtotalDeLineaVenta {
    
    public TestCalcularSubtotalDeLineaVenta() {
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
          LineaVenta linea = new LineaVenta(3, Creador.getProducto(3));
          
          //Ejecucion
          double actual = linea.calcularSubTotal();
          double esperado = 120;
          
          //Comprobacion
          assertEquals(esperado, actual, 0);
     }
}
