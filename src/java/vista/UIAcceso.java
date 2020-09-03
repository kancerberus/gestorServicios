package vista;

import controlador.GestorAcceso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Acceso;

/**
 *
 * @author JuanVilla
 */
public class UIAcceso implements Serializable {
    
    private FacesContext contextoJSF;
    private ELContext contextoEL;
    private ExpressionFactory ef;
    private Acceso acceso;
    private GestorAcceso gestorAcceso;
    private String nit_empresa;
    private String nit_subempresa;
    //Se declara lista para filtrar accesos de todas las empresas
    private List<Acceso> lista_acceso;
    //Se declara lista para filtrar con mas detalle
    private List<Acceso> filteredlista_acceso;
    
   
    
    
    public  UIAcceso() {  
        
        acceso = new Acceso();  
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        lista_acceso = new ArrayList<>();
        filteredlista_acceso = new ArrayList<>();
    }
         
    public void mostrarAccesos () throws Exception {
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        gestorAcceso = new GestorAcceso();
        lista_acceso.clear();
        
        try {
            
            lista_acceso = gestorAcceso.listaAcceso();
        }
        catch (Exception e) {
            Logger.getLogger(UIAcceso.class.getName()).log(Level.SEVERE, null, e);

        }                                             
    }
    
    
    public void guardarAcceso() {
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        
        String mensaje1 = "Guardado con exito!";
        String mensaje2 = "No guardado!";
                 
        //Se llena la información del acceso en la instancia de la clase        
        //gestorAcceso.guardarAcceso(acceso)
        try
        {
        //Se obtienen las variables de clase empresa y subempresa ingresando directamente a traves del Bean            
        nit_empresa = (String) ef.createValueExpression(contextoEL, "#{empresaBean.empresa.nit_empresa}", String.class).getValue(contextoEL);        
        nit_subempresa = (String) ef.createValueExpression(contextoEL, "#{empresaBean.subempresa.nit_subempresa}", String.class).getValue(contextoEL);  
        
        //se obtención de la información y se ingresa a la clase acceso
        acceso.getEmpresa().setNit_empresa(nit_empresa);
        acceso.getSub_empresa().setNit_subempresa(nit_subempresa);
        
        gestorAcceso = new GestorAcceso();
        
        String actualizado = gestorAcceso.guardarAcceso(acceso);
         
         if ("1".equals(actualizado)){
             getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensaje1));
          }
         
        }catch (Exception e) {                  
         getContextoJSF().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()+ mensaje2));
        }        
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().remove("accesoBean"); 
    }
     
     
    
   //Getters y Setters


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

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    
    public void setLista_acceso(List<Acceso> lista_acceso) {
        this.lista_acceso = lista_acceso;
    }
    
        public List<Acceso> getlista_acceso() throws Exception { 
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        gestorAcceso = new GestorAcceso();
        lista_acceso.clear();
        
        
        try {
            
            lista_acceso = gestorAcceso.listaAcceso();
        }
        catch (Exception e) {
            Logger.getLogger(UIAcceso.class.getName()).log(Level.SEVERE, null, e);

        }                                              
          return lista_acceso;    
    }

    public List<Acceso> getFilteredlista_acceso() {
        return filteredlista_acceso;
    }

    public void setFilteredlista_acceso(List<Acceso> filteredlista_acceso) {
        this.filteredlista_acceso = filteredlista_acceso;
    }
    
        
    
}
