/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author mv
 */
public class ConversorMsgIdioma {
    
    public static String getMsg(String idMensagem){
        FacesContext ctx = FacesContext.getCurrentInstance();
        String msg = "";
        Locale local = ctx.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("messages", local);
        try {
            msg = bundle.getString(idMensagem);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }
    
}
