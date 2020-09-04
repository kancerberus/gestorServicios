/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestorEmpresa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.Empresa;
import modelo.SubEmpresa;
import modelo.Menu;

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
    private SubEmpresa subempresa;
    private List<Menu> listaMenu;
    private ArrayList<SelectItem> itemsEmpresas;
    private ArrayList<SelectItem> itemsSubempresas;
    
    
    public UIEmpresa() throws Exception{  
        
        contextoJSF = FacesContext.getCurrentInstance();
        contextoEL = contextoJSF.getELContext();
        ef = contextoJSF.getApplication().getExpressionFactory();
        gestorEmpresa = new GestorEmpresa();
        empresa = new Empresa();
        subempresa = new SubEmpresa();        
        itemsEmpresas = new ArrayList<>();   
        itemsSubempresas = new ArrayList<>();  
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
    
    
            public ArrayList<SelectItem> getItemsEmpresa() throws Exception{ 
           try {
                gestorEmpresa = new GestorEmpresa();
                ArrayList<Empresa> listaEmpresas;
                listaEmpresas = gestorEmpresa.listarEmpresas();
                itemsEmpresas.clear();
                for (int i = 0; i < listaEmpresas.size(); i++) {                    
                        itemsEmpresas.add(new SelectItem(
                                listaEmpresas.get(i).getNit_empresa(),
                                listaEmpresas.get(i).getNom_empresa()));
                    }                        
                }
            catch (Exception ex) {
                        Logger.getLogger(UIEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                return itemsEmpresas;    
    }
            
                      
            public ArrayList<SelectItem> getItemsSubempresas () throws Exception{ 
           try {
                gestorEmpresa = new GestorEmpresa();
                ArrayList<SubEmpresa> listarSubempresa;
                listarSubempresa = gestorEmpresa.listarSubempresas(empresa);
                itemsSubempresas.clear();
                for (int i = 0; i < listarSubempresa.size(); i++) {                    
                        itemsSubempresas.add(new SelectItem(listarSubempresa.get(i).getNit_subempresa(), listarSubempresa.get(i).getNom_empresa()));
                    }                        
                }
            catch (Exception ex) {
                        Logger.getLogger(UIEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                } 
                return itemsSubempresas;    
    }
            
    public FacesContext getContextoJSF() {
           return contextoJSF;
    }

    public void setContextoJSF(FacesContext contextoJSF) {
           this.contextoJSF = contextoJSF;
    }   

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void getItemsSubempresas(ArrayList<SelectItem> itemsSubempresas) {
        this.itemsSubempresas = itemsSubempresas;
    }

    public void setItemsSubempresas(ArrayList<SelectItem> itemsSubempresas) {
        this.itemsSubempresas = itemsSubempresas;
    }

    public SubEmpresa getSubempresa() {
        return subempresa;
    }

    public void setSubempresa(SubEmpresa subempresa) {
        this.subempresa = subempresa;
    }
        
       
}