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

//        Venta v = new Venta();
//        
//        DocTipo docTipo = new DocTipo(96, "DNI");
//        Cliente cliente = new Cliente(00000,docTipo );
//        System.out.println(Enlazador.autorizarComprobante(1, 11, "91CCD580-37DB-4B27-8F49-B5BC4F786330", v, "PES", 1, 1, cliente, 1));
        
        PuntoVenta ptoVta = new PuntoVenta();
        ptoVta.setNro(1);
        Tienda tienda = new Tienda();
        tienda.setNombreFantasia("La Sangucheria");
        tienda.setPtoVta(ptoVta);
        //agregar valores a los atributos de la tienda
        
        Terminal terminal = new Terminal();
        tienda.setTerminal(terminal);
        terminal.setTienda(tienda);
        InicioSesion vista1 = new InicioSesion(terminal);
        
    }
    
}
