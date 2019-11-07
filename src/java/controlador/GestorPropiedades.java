/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author carlosf
 */
 /*Descripcion: Clase utilizada para encontrar la ruta del properties, es decir la ruta del archivo que tiene la informacion
  * de acceso a la base de datos.
  */
public class GestorPropiedades {

    public Properties cargarPropiedades(String ruta) throws Exception {
        Properties p = new Properties();
        try {
            ResourceBundle bdl = new PropertyResourceBundle(new FileInputStream(ruta));
            Enumeration keys = bdl.getKeys();
            while (keys.hasMoreElements()) {
                String prop = (String) keys.nextElement();
                String val = bdl.getString(prop);
                p.setProperty(prop, val);
            }
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
}
