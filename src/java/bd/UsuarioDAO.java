/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Menu;
import modelo.Perfil;
import modelo.SubMenu;
import modelo.Usuario;

/**
 *
 * @author carlosv
 */
public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Usuario validarUsuario(String usuario, String clave) throws SQLException {
        Consulta consulta = null;
        ResultSet rs;
        String sql;
        Usuario u = null;
        Perfil p = null;
        try {
            consulta = new Consulta(getConexion());
            sql = "select u.usuario,u.nombre,u.id,u.cod_perfil,c.cod_conjunto,c.nom_conjunto,p.nombre perfil from "
                    + " usuarios u "
                    + " inner join perfiles p using (cod_perfil) "
                    + " inner join conjuntos c on (fk_cod_conjunto=cod_conjunto)"
                    + " where usuario='" + usuario.trim() + "' and clave=md5('" + clave.trim() + "');";
            rs = consulta.ejecutar(sql);
            if (rs.next()) {
                u = new Usuario();
                u.setUsuario(rs.getString("usuario"));
                u.setNom_usuario(rs.getString("nombre"));                
                
                p = new Perfil();
                p.setCod_perfil(rs.getString("cod_perfil"));
                p.setNom_perfil(rs.getString("perfil"));                
                u.setPerfil(p);
                
            }
            return u;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            consulta.desconectar();
        }
    }

    public List<Menu> listarOpcionesMenu(String usuario) throws SQLException {
        Consulta consulta = null;
        ResultSet rs;
        String sql, menuAnt = "";
        List<Menu> listaMenu = new ArrayList<>();
        try {
            Menu m;
            consulta = new Consulta(getConexion());
            sql = " select "
                    + " m.nombre nombre_menu,s.nombre nombre_submenu,imagen,s.opcion nombre_opcion"
                    + " from "
                    + " usuarios u "
                    + " inner join rel_perfil_submenu r using (cod_perfil) "
                    + " inner join menu m using (cod_menu) "
                    + " inner join submenu s using (cod_menu,cod_submenu) "
                    + " where "
                    + " usuario='" + usuario + "' "
                    + " order by m.orden,s.orden ";
            rs = consulta.ejecutar(sql);
            if (rs.next()) {

                SubMenu sm = new SubMenu();
                sm.setEtiqueta(rs.getString("nombre_submenu"));
                sm.setImagen(rs.getString("imagen"));
                sm.setOpcion(rs.getString("nombre_opcion"));
                //fredy
                //sm.setOpcion("nuevo_residente");

                m = new Menu();
                m.setEtiqueta(rs.getString("nombre_menu"));
                m.getListaSubMenu().add(sm);
                menuAnt = rs.getString("nombre_menu");

                while (rs.next()) {
                    sm = new SubMenu();
                    sm.setEtiqueta(rs.getString("nombre_submenu"));
                    sm.setImagen(rs.getString("imagen"));
                    sm.setOpcion(rs.getString("nombre_opcion"));
                    //fredy
                    //sm.setOpcion("nuevo_residente");
                    //si pertenece al mismo menu
                    if (rs.getString("nombre_menu").equalsIgnoreCase(menuAnt)) {
                        m.getListaSubMenu().add(sm);
                    } else {
                        listaMenu.add(m);
                        m = new Menu();
                        m.setEtiqueta(rs.getString("nombre_menu"));
                        m.getListaSubMenu().add(sm);
                        menuAnt = rs.getString("nombre_menu");
                    }
                }
                listaMenu.add(m);
            }

            return listaMenu;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            consulta.desconectar();
        }
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}