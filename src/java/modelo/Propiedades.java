/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.GestorPropiedades;
import java.util.Properties;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author carlosv
 */
public class Propiedades {

    private static Propiedades instancia;
    private Properties propiedades;

     /*Descripcion:  Se cargan propiedades de la base de datos, este viene del archivo configuracion.properties*/
    private Propiedades() {
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        GestorPropiedades gestorPropiedades = new GestorPropiedades();
        try {
            propiedades = gestorPropiedades.cargarPropiedades(context.getRealPath("/WEB-INF/configuracion.properties"));
        } catch (Exception e) {
        }
    }

    /**
     * @return the instancia
     */
     /*Descripcion: Esta propiedad utiliza un Singleton para iniciar los parametros de configuracion */
    public static Propiedades getInstancia() {
        if (instancia == null) {
            synchronized (Propiedades.class) {
                instancia = new Propiedades();
            }
        }
        return instancia;
    }

    public Properties getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }
}
