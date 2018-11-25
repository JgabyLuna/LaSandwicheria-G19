/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author usuario
 */
public class Turno {
    private String nombre;
    private int horaInicio;
    private int horaFin;
    private ArrayList<Venta> ventas = new ArrayList();
    private Cajero cajero;

    public Turno() {
        horaInicio = obtenerHora();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Venta venta) {
        this.ventas.add(venta);
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }
    
    public int obtenerHora(){
        int hora;
        Calendar cal1 = Calendar.getInstance();
        hora = cal1.get(Calendar.HOUR);
        return hora;
    }
    
    public Rendicion obtenerRendicion(){
        double total = 0;
        for (Venta venta : ventas) {
            total = total + venta.getTotal();
        }
        Rendicion rendicion = new Rendicion();
        rendicion.setGanancia(total);
        return rendicion;
    }
    

    public void finalizarTurno(Venta venta) {
        this.setHoraFin(this.obtenerHora());
        this.setVentas(venta);
        cajero.cerrarSesion();
    }
}
