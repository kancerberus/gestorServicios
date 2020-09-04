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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Empresa;
import modelo.SubEmpresa;

/**
 *
 * @author JuanVilla
 */
public class EmpresaDAO extends GestorBD {
    private Connection conexion;
    
    public EmpresaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public EmpresaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String guardarEmpresa(Empresa empresa){
        FacesContext contextoJSF = FacesContext.getCurrentInstance();
        int actualizado=0;        
        try {
            bd.conectar(getUsuario(), getClave(), getServidor(), getPuerto(), getBasedatos());
                                    
            sql = "insert into empresas"  +
                  "(nom_empresa, nit_empresa, telefono_empresa, direccion_empresa, correo_empresa)" +
                  "values ('"+empresa.getNom_empresa()+"','"+empresa.getNit_empresa()+"','"+empresa.getTelefono_empresa()+"'," +
                  "'"+empresa.getDireccion_empresa()+"','"+empresa.getCorreo_empresa()+"')";
                   
            actualizado = bd.actualizar(sql);
            
        } catch (SQLException E) {
            contextoJSF.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", E.getMessage()));
        } finally {
            bd.desconectar();
        }
        return Integer.toString(actualizado);
    } 
    
    public ArrayList<Empresa> listarEmpresas() throws SQLException {
        Empresa empresa;
        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        ResultSet rs;
        Consulta consulta = null;
        try {
            consulta = new Consulta(getConexion());
            String sql
                    = " SELECT nit_empresa,nom_empresa "
                    + " FROM empresas ";

            rs = consulta.ejecutar(sql);

            while (rs.next()) {
                empresa = new Empresa ();
                empresa.setNit_empresa(rs.getString("nit_empresa"));
                empresa.setNom_empresa(rs.getString("nom_empresa"));
                listaEmpresas.add(empresa);
            }
            return listaEmpresas;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            consulta.desconectar();
        }
    }
      
    public ArrayList<SubEmpresa> listarSubempresas(Empresa empresa) throws SQLException {
        SubEmpresa subempresa;
        ArrayList<SubEmpresa> listaSubempresas = new ArrayList<>();
        ResultSet rs;
        Consulta consulta = null;
        try {
            consulta = new Consulta(getConexion());
            String sql
                    = " SELECT nit_subempresa, nom_subempresa " 
                    + " FROM subempresa" 
                    + " WHERE nit_empresa = '"+empresa.getNit_empresa()+"'" ;
                  
            rs = consulta.ejecutar(sql);

            while (rs.next()) {
                subempresa = new SubEmpresa();
                subempresa.setNit_subempresa(rs.getString("nit_subempresa"));
                subempresa.setNom_empresa(rs.getString("nom_subempresa"));
                listaSubempresas.add(subempresa);
            }
            return listaSubempresas;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            consulta.desconectar();
        }
    }
    
    //getters y setters

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

