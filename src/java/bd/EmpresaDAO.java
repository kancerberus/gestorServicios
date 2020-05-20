/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Empresa;

/**
 *
 * @author JuanVilla
 */
public class EmpresaDAO extends GestorBD {
    
    
    public EmpresaDAO() {
        super();
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
}
