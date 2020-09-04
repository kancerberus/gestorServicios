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
import modelo.Acceso;
import modelo.Empresa;
import modelo.SubEmpresa;
/**
 *
 * @author JuanVilla
 */
public class AccesoDAO extends GestorBD {
    
    private Connection conexion;
   
    public AccesoDAO() {
       super();
       
    }
    
    public AccesoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public String guardarAcceso(Acceso acceso) throws SQLException{
        FacesContext contextoJSF = FacesContext.getCurrentInstance();
        int actualizado=0;
        try {
            bd.conectar(getUsuario(), getClave(), getServidor(), getPuerto(), getBasedatos());
            
            sql = "insert into accesos" +
                  "(nom_acceso, ip_local, ip_publica, user_acceso, contraseña, cod_subempresa, cod_empresa)" +
                  "values ("
                  + "'" + acceso.getNom_acceso() +"',"
                  + "'" + acceso.getIp_local() +"',"
                  + "'" + acceso.getIp_externa() +"',"
                  + "'" + acceso.getUser_acceso() +"',"
                  + "'" + acceso.getContraseña() +"',"
                  + "'" + acceso.getEmpresa().getNit_empresa()+"',"
                  + "'" + acceso.getSub_empresa().getNit_subempresa()+"')";
                   
          actualizado = bd.actualizar(sql);
            
        } catch (SQLException E) {
            contextoJSF.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", E.getMessage()));
        } finally {
            bd.desconectar();
        }
        return Integer.toString(actualizado);
    }            
    
    
    public ArrayList<Acceso> listarAcceso() throws SQLException {
        Acceso acceso;
        ArrayList<Acceso> listarAcceso = new ArrayList<>();
        ResultSet rs;
        Consulta consulta = null;
        consulta = new Consulta(conexion);
        try {
            
            //Sq1 Carga la lista completa de accesos sin filtrar
            sql
             = " SELECT "
             + " e.nom_empresa, s.nom_subempresa,"
             + " a.cod_acceso, a.nom_acceso, a.ip_local, a.ip_publica, a.contraseña, a.user_acceso "
                    
             + " from accesos a inner join empresas e on (nit_empresa=cod_empresa) "
             + " inner join subempresa s on (nit_subempresa=cod_subempresa) ";
             
            rs = consulta.ejecutar(sql);


            while (rs.next()) {
                acceso = new Acceso ();
                acceso.setNom_acceso(rs.getString("nom_acceso"));
                acceso.setIp_local(rs.getString("ip_local"));
                acceso.setIp_externa(rs.getString("ip_publica"));
                acceso.setUser_acceso(rs.getString("user_acceso"));
                acceso.setContraseña(rs.getString("contraseña"));
                
                acceso.getEmpresa().setNom_empresa(rs.getString("nom_empresa"));
                acceso.getSub_empresa().setNom_empresa(rs.getString("nom_subempresa"));;
                
                
                listarAcceso.add(acceso);
            }
            return listarAcceso;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            consulta.desconectar();
        }
    }
}