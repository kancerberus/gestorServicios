package vista;

import controlador.GestorUsuario;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuarios;
import java.io.Serializable;

/**
 *
 * @author JuanVilla
 */


public class UIUsuario implements Serializable {
    
    private FacesContext contextoJSF;
    private ELContext contextoEL;
    private ExpressionFactory ef;
    private GestorUsuario gestorUsuario;
    private Usuarios usuario;
    
    
    
    public UIUsuario() throws Exception{  
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        gestorUsuario = new GestorUsuario();
        usuario = new Usuarios();
    }
    
    public void guardarUsuario() {
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        
        String mensaje1 = "Guardado con exito!";
        String mensaje2 = "No guardado!";
                 
        //Se llena la información del usuario en la instancia de la clase        
       
        try
        {
         
         String actualizado = gestorUsuario.guardarUsuario(usuario);
         
         if ("1".equals(actualizado)){
             getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensaje1));
          }
         
        }catch (Exception e) {                  
         getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()+ mensaje2));
        }        
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().remove("usuarioBean");        
    }

    public FacesContext getContextoJSF() {
        return contextoJSF;
    }

    public void setContextoJSF(FacesContext contextoJSF) {
        this.contextoJSF = contextoJSF;
    }

    public ELContext getContextoEL() {
        return contextoEL;
    }

    public void setContextoEL(ELContext contextoEL) {
        this.contextoEL = contextoEL;
    }

    public ExpressionFactory getEf() {
        return ef;
    }

    public void setEf(ExpressionFactory ef) {
        this.ef = ef;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
}
