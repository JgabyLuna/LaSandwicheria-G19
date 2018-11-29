/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import controlador.Enlazador;
import modelo.*;
import vista.InicioSesion;



/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 
        PuntoVenta ptoVta = new PuntoVenta();
        ptoVta.setNro(1);
        Tienda tienda = new Tienda();
        tienda.setNombreFantasia("La Sangucheria");
        tienda.setPtoVta(ptoVta);
        //agregar valores a los atributos de la tienda
        
        Terminal terminal = new Terminal();
        tienda.setTerminal(terminal);
        terminal.setTienda(tienda);
        InicioSesion vista1 = new InicioSesion(tienda);
        
    }
    
}
