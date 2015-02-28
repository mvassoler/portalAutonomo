/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author mv
 */
@ManagedBean
@RequestScoped
public class TextoBean {

    /**
     * Creates a new instance of TextoBean
     */
    
    private String texto;
    
    public TextoBean() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
