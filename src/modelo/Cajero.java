/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Cajero {
    private String nombre;
    private int legajo;

    public Cajero() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Cajero(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }
    
    public boolean cerrarSesion(){
       return true;
    }

    
    
}
