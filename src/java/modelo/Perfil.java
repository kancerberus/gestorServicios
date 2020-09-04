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
public class Perfil {
    private String cod_perfil;
    private String nom_perfil;
 
    public Perfil(){
        
    }

    public String getCod_perfil() {
        return cod_perfil;
    }

    public void setCod_perfil(String cod_perfil) {
        this.cod_perfil = cod_perfil;
    }

    public String getNom_perfil() {
        return nom_perfil;
    }

    public void setNom_perfil(String nom_perfil) {
        this.nom_perfil = nom_perfil;
    }        
}

