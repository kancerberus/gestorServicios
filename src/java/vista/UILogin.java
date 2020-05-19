/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestorUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelo.Menu;
import modelo.Sesion;
import modelo.Usuarios;
import util.Utilidades;

/**
 *
 * @author carlosv
 */
public class UILogin implements Serializable {

    private String usuario;
    private String clave;
    private Sesion sesion;
    private List<Menu> listaMenu;
    public Utilidades util = new Utilidades();
    private GestorUsuario gestorUsuario;

    
    public UILogin() {        
        sesion = new Sesion();
        sesion.setUsuario(new Usuarios());        
    }

    public void Ingresar() throws Exception {
        try {
            FacesContext contextoJSF = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) contextoJSF.getExternalContext().getSession(false);           
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        } catch (Exception e) {
            throw new RuntimeException("No se pudo registrar la sesión");
        }
        try {
            gestorUsuario = new GestorUsuario();
            Usuarios u = gestorUsuario.validarUsuario(usuario, clave);
            sesion.setUsuario(u);
            if(u!=null){
                setListaMenu(gestorUsuario.listarOpcionesMenu(usuario));
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/principal.xhtml");
            }
            else {
                util.mostrarMensaje("Usuario o clave incorrectos.");
            }
            
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo redireccionar la página");
        }
    }

         public void cerrarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
            s.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../");
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo redireccionar la página");
        }
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the sesion
     */
    public Sesion getSesion() {
        return sesion;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    /**
     * @return the listaMenu
     */
    public List<Menu> getListaMenu() {
        return listaMenu;
    }

    /**
     * @param listaMenu the listaMenu to set
     */
    public void setListaMenu(List<Menu> listaMenu) {
        this.listaMenu = listaMenu;
    }

}

