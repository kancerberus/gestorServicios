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
public class ServicioTecnico {
    
 /*inf_tec_realizada = Funcion tecnica realizada
 */   
    private String inf_tec_realizada;
    private String observ;
    private String cod_incidencia;
    private String fecha_incidencia;
    private String hora_incidencia;
    private Usuarios nom_usuario;
    private TipoAtencion cod_atencion; 
    
    public ServicioTecnico(){
            cod_atencion = new TipoAtencion();
            nom_usuario = new Usuarios();
    }

    public String getInf_tec_realizada() {
        return inf_tec_realizada;
    }

    public void setInf_tec_realizada(String inf_tec_realizada) {
        this.inf_tec_realizada = inf_tec_realizada;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getCod_incidencia() {
        return cod_incidencia;
    }

    public void setCod_incidencia(String cod_incidencia) {
        this.cod_incidencia = cod_incidencia;
    }

    public String getFecha_incidencia() {
        return fecha_incidencia;
    }

    public void setFecha_incidencia(String fecha_incidencia) {
        this.fecha_incidencia = fecha_incidencia;
    }

    public String getHora_incidencia() {
        return hora_incidencia;
    }

    public void setHora_incidencia(String hora_incidencia) {
        this.hora_incidencia = hora_incidencia;
    }

    public Usuarios getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(Usuarios nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public TipoAtencion getCod_atencion() {
        return cod_atencion;
    }

    public void setCod_atencion(TipoAtencion cod_atencion) {
        this.cod_atencion = cod_atencion;
    }
}
