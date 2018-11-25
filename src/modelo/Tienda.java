/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Tienda {
    private ArrayList<Cajero> cajeros = new ArrayList();
    private int cuit;
    private String nombreFantasia;
    private String domicilio;
    private String razonSocial;
    private CondicionTributaria condicionTributaria;
    private PuntoVenta ptoVta;
    private Terminal terminal;

    public ArrayList<Cajero> getCajeros() {
        return cajeros;
    }

    public void setCajeros(Cajero cajero) {
        this.cajeros.add(cajero);
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domiciolio) {
        this.domicilio = domiciolio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public CondicionTributaria getCondicionTributaria() {
        return condicionTributaria;
    }

    public void setCondicionTributaria(CondicionTributaria condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }

    public PuntoVenta getPtoVta() {
        return ptoVta;
    }

    public void setPtoVta(PuntoVenta ptoVta) {
        this.ptoVta = ptoVta;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    
    }
