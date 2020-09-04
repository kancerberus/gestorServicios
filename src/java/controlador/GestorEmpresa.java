package controlador;

import bd.EmpresaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Empresa;
import modelo.SubEmpresa;

/**
 *
 * @author JuanVilla
 */
public class GestorEmpresa extends Gestor {
    
    
    EmpresaDAO empresaDAO;
    
    
    public GestorEmpresa()throws Exception{
        super();
    }
  
    
   public String guardarEmpresa(Empresa empresa) throws SQLException {
       
       empresaDAO = new EmpresaDAO(); 
       return empresaDAO.guardarEmpresa(empresa);
   }
   
    public ArrayList<Empresa> listarEmpresas() throws Exception {
        try {
            abrirConexion();
            EmpresaDAO empresaDAO = new EmpresaDAO(conexion);
            return empresaDAO.listarEmpresas();
        } finally {
            cerrarConexion();
        }
    }  
    
    public ArrayList<SubEmpresa> listarSubempresas (Empresa empresa) throws Exception {
        try {
            abrirConexion();
            EmpresaDAO empresaDAO = new EmpresaDAO(conexion);
            return empresaDAO.listarSubempresas(empresa);
        } finally {
            cerrarConexion();
        }
    } 
        
}
