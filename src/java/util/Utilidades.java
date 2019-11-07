/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres
 */
public class Utilidades implements Serializable{
    
    public void mostrarMensaje(String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, "") );
    }
    
}
