package controlador;

import modelo.Usuarios;
import bd.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Menu;
import modelo.Perfil;

/**
 *
 * @author carlosv
 */
public class GestorUsuario extends Gestor {
    
    UsuarioDAO usuarioDAO; 
     
    public GestorUsuario() throws Exception{
        super();
    }

     public String guardarUsuario(Usuarios usuario) throws Exception {
        
         usuarioDAO = new UsuarioDAO();
         return usuarioDAO.guardarUsuario(usuario);
        
    }
    
    public ArrayList<Perfil> listarPerfiles() throws Exception {
        try {
            abrirConexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            return usuarioDAO.listarPerfiles();
        } finally {
            cerrarConexion();
        }
    } 
     
    
    public Usuarios validarUsuario(String usuario, String clave) throws Exception {
        try {
            abrirConexion();
            UsuarioDAO usuarioDAO  = new UsuarioDAO(conexion);
            return usuarioDAO.validarUsuario(usuario, clave);
        } finally {
            cerrarConexion();
        }
    }

    public List<Menu> listarOpcionesMenu(String usuario) throws Exception {
        try {
            abrirConexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            return usuarioDAO.listarOpcionesMenu(usuario);
        } finally {
            cerrarConexion();
        }
    }
}
