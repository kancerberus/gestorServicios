/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;

/**
 *
 * @author Andres
 */
public class GestorPrincipal implements Serializable {

    private boolean registroAcceso = false;
    private boolean registroInventario = false;
    private boolean registroActas = false;
    private boolean registroClientes = false;
    private boolean registroUsuario = false;
    private boolean registroModelos = false;
    private boolean registroMarcas = false;
    private boolean consultarServicio = false;
    private boolean consultarDispositivo = false;
    
    
    public GestorPrincipal() {

    }

    public String selGeneral(String opcion) {
        switch (opcion) {
            case "registro_acceso":
                setRegistroAcceso(true);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "registro_inventario":
                setRegistroAcceso(false);
                setRegistroInventario(true);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "reg_acta":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(true);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "reg_cliente":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(true);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "reg_usuario":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(true);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "reg_modelo":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(true);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "reg_marca":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(true);
                setConsultarServicio(false);
                setConsultarDispositivo(false);
                break;
            case "cons_servicio":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(true);
                setConsultarDispositivo(false);
                break;
            case "cons_dispositvo":
                setRegistroAcceso(false);
                setRegistroInventario(false);
                setRegistroActas(false);
                setRegistroClientes(false);
                setRegistroUsuarios(false);
                setRegistroModelos(false);
                setRegistroMarcas(false);
                setConsultarServicio(false);
                setConsultarDispositivo(true);
                break;
        }
        return "";
    }

    public boolean isRegistroAcceso() {
        return registroAcceso;
    }

    public void setRegistroAcceso(boolean registroAcceso) {
        this.registroAcceso = registroAcceso;
    }

    public boolean isRegistroInventario() {
        return registroInventario;
    }

    public void setRegistroInventario(boolean registroInventario) {
        this.registroInventario = registroInventario;
    }

    public boolean isRegistroActas() {
        return registroActas;
    }

    public void setRegistroActas(boolean registroActas) {
        this.registroActas = registroActas;
    }

    public boolean isRegistroClientes() {
        return registroClientes;
    }

    public void setRegistroClientes(boolean registroClientes) {
        this.registroClientes = registroClientes;
    }

    public boolean isRegistroUsuarios() {
        return registroUsuario;
    }

    public void setRegistroUsuarios(boolean registroUsuarios) {
        this.registroUsuario = registroUsuarios;
    }

    public boolean isRegistroModelos() {
        return registroModelos;
    }

    public void setRegistroModelos(boolean registroModelos) {
        this.registroModelos = registroModelos;
    }

    public boolean isRegistroMarcas() {
        return registroMarcas;
    }

    public void setRegistroMarcas(boolean registroMarcas) {
        this.registroMarcas = registroMarcas;
    }

    public boolean isConsultarServicio() {
        return consultarServicio;
    }

    public void setConsultarServicio(boolean consultarServicio) {
        this.consultarServicio = consultarServicio;
    }

    public boolean isConsultarDispositivo() {
        return consultarDispositivo;
    }

    public void setConsultarDispositivo(boolean consultarDispositivo) {
        this.consultarDispositivo = consultarDispositivo;
    }

}