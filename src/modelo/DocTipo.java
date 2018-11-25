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
public class DocTipo{
    private int nro;
    private String desc;

    
    public DocTipo(int id, String desc) {
        this.nro = id;
        this.desc = desc;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int id) {
        this.nro = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
