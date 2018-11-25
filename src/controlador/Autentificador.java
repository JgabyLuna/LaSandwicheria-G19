/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.*;
import vista.VistaVenta2;

/**
 *
 * @author usuario
 */
public class Autentificador {

    public Autentificador(IInicioSesion vista) {

    }

    public void solicitarAutentificacion(String nombre, int legajo, Tienda tienda) {
        
        if (autentificacion(legajo, nombre)) {
            tienda.getTerminal().IniciarSesion(nombre, legajo);            
        } else {
            JOptionPane.showMessageDialog(null, "Legajo Inexistente");
            
        }
        
        VistaVenta2 vista = new VistaVenta2(tienda);

    }

    public boolean autentificacion(int legajo, String nombre) {
        Tienda tienda = Creador.getTienda();
        for (Cajero cajero : tienda.getCajeros()) {
            if (cajero.getLegajo() == legajo && cajero.getNombre().equals(nombre)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
