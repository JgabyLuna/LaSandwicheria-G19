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
public class Cliente {
    private long docNro;
    private DocTipo docTipo;
    private CondicionTributaria condicionTibutaria;

    public Cliente(long docNro, DocTipo docTipo) {
        this.docNro = docNro;
        this.docTipo = docTipo;
    }

    public long getDocNro() {
        return docNro;
    }

    public void setDocNro(long docNro) {
        this.docNro = docNro;
    }

    public DocTipo getDocTipo() {
        return docTipo;
    }

    public void setDocTipo(DocTipo docTipo) {
        this.docTipo = docTipo;
    }

    public CondicionTributaria getCondicionTibutaria() {
        return condicionTibutaria;
    }

    public void setCondicionTibutaria(CondicionTributaria condicionTibutaria) {
        this.condicionTibutaria = condicionTibutaria;
    }
    
    
}
