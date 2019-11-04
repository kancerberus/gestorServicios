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
public class Acceso {
    private String nom_acceso;
    private String ip_local;
    private String ip_externa;
    private String usuario;
    private String contraseña;
    private String cod_acceso;
    private String cod_empresa;
    private String nom_usuario;
    private TipoServicio cod_servicio;
    private TipoDispositivo cod_dispositivo;
    
    public Acceso(){
        cod_servicio = new TipoServicio();
        cod_dispositivo = new TipoDispositivo();
                
}

    public String getNom_acceso() {
        return nom_acceso;
    }

    public void setNom_acceso(String nom_acceso) {
        this.nom_acceso = nom_acceso;
    }

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    public String getIp_externa() {
        return ip_externa;
    }

    public void setIp_externa(String ip_externa) {
        this.ip_externa = ip_externa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCod_acceso() {
        return cod_acceso;
    }

    public void setCod_acceso(String cod_acceso) {
        this.cod_acceso = cod_acceso;
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public TipoServicio getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(TipoServicio cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public TipoDispositivo getCod_dispositivo() {
        return cod_dispositivo;
    }

    public void setCod_dispositivo(TipoDispositivo cod_dispositivo) {
        this.cod_dispositivo = cod_dispositivo;
    }

    
}
