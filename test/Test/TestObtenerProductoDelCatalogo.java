/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.Creador;
import modelo.CatalogoProducto;
import modelo.Producto;
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
public class TestObtenerProductoDelCatalogo {
    
    public TestObtenerProductoDelCatalogo() {
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
         CatalogoProducto catalogo = Creador.getCatalogo();
         
         //Ejecucion
         Object actual = catalogo.obtenerProducto(1);// El producto con id = 1 es Milanesa
         Object esperado = catalogo.getProductos().get(0);// El producto con index = 0 es Milanesa
         
         //Comprobacion
         assertEquals(esperado, actual);
     
     
     }
}
