/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestorEmpresa;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Empresa;


/**
 *
 * @author JuanVilla
 */
public class UIEmpresa {
   
    private FacesContext contextoJSF;
    private ELContext contextoEL;
    private ExpressionFactory ef;
    private GestorEmpresa gestorEmpresa;
    private Empresa empresa;
    
    public UIEmpresa() throws Exception{  
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        gestorEmpresa = new GestorEmpresa();
        empresa = new Empresa();
        
    }

    public void guardarEmpresa() {
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        
        String mensaje1 = "Guardado con exito!";
        String mensaje2 = "No guardado!";
                 
        //Se llena la información de empresa en la instancia de la clase        
        //Empresa empresa = (Empresa) ef.createValueExpression(contextoEL, "#{empresaBean}", Empresa.class).getValue(contextoEL); 
        
        try
        {
         
         String actualizado = gestorEmpresa.guardarEmpresa(empresa);
         
         if ("1".equals(actualizado)){
             getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensaje1));
          }
         
        }catch (Exception e) {                  
         getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()+ mensaje2));
        }        
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().remove("empresaBean");        
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
}
