/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JuanVilla
 */
public class SubEmpresa {
    private String nom_empresa;
    private String nit_subempresa;
    private String telefono_subempresa;
    private String direccion_subempresa;
    private String correo_subempresa;
    private Empresa nit_empresa;

    public SubEmpresa(){
        nit_empresa = new Empresa();
        
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public String getNit_subempresa() {
        return nit_subempresa;
    }

    public void setNit_subempresa(String nit_subempresa) {
        this.nit_subempresa = nit_subempresa;
    }

    public String getTelefono_subempresa() {
        return telefono_subempresa;
    }

    public void setTelefono_subempresa(String telefono_subempresa) {
        this.telefono_subempresa = telefono_subempresa;
    }

    public String getDireccion_subempresa() {
        return direccion_subempresa;
    }

    public void setDireccion_subempresa(String direccion_subempresa) {
        this.direccion_subempresa = direccion_subempresa;
    }

    public String getCorreo_subempresa() {
        return correo_subempresa;
    }

    public void setCorreo_subempresa(String correo_subempresa) {
        this.correo_subempresa = correo_subempresa;
    }

    public Empresa getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(Empresa nit_empresa) {
        this.nit_empresa = nit_empresa;
    }
    
    
    
}
