/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.EmpresaDAO;
import java.sql.SQLException;
import modelo.Empresa;

/**
 *
 * @author JuanVilla
 */
public class GestorEmpresa {
    
    
    EmpresaDAO empresaDAO;
    
    
    public GestorEmpresa(){
        empresaDAO = new EmpresaDAO();
        
        
    }
    
   public String guardarEmpresa(Empresa empresa) throws SQLException {
        return empresaDAO.guardarEmpresa(empresa);
    }
        
}