/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Menu {
    
    private String etiqueta;
    private List<SubMenu> listaSubMenu;

    public Menu() {
        this.listaSubMenu = new ArrayList<>();
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the listaSubMenu
     */
    public List<SubMenu> getListaSubMenu() {
        return listaSubMenu;
    }

    /**
     * @param listaSubMenu the listaSubMenu to set
     */
    public void setListaSubMenu(List<SubMenu> listaSubMenu) {
        this.listaSubMenu = listaSubMenu;
    }
    
}
