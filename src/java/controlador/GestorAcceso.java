package controlador;

import bd.AccesoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Acceso;

/**
 *
 * @author JuanVilla
 */
public class GestorAcceso extends Gestor {
    
    AccesoDAO accesoDAO;
 
    
         public GestorAcceso() throws Exception{
            super();
            accesoDAO = new AccesoDAO(); 
         
         }
    
    public String guardarAcceso(Acceso acceso) throws SQLException {
        accesoDAO = new AccesoDAO();
        return accesoDAO.guardarAcceso(acceso);
    }
    
    public ArrayList<Acceso> listaAcceso() throws Exception {
        try {
            abrirConexion();
            AccesoDAO accesoDAO = new AccesoDAO(conexion);
            return accesoDAO.listarAcceso();
        } finally {
            cerrarConexion();
        }
    } 


        
}


