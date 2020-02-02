package com;

import dao.Cliente;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named(value = "plantilla")
@RequestScoped
public class Plantilla extends Cliente {

    private String mensajeBoton;

    public Plantilla() {
    }

    public String getMensajeBoton() {
        return mensajeBoton;
    }

    public void setMensajeBoton(String mensajeBoton) {
        this.mensajeBoton = mensajeBoton;
    }

    public void verificarSesion() {
        /*Valida si hay una sesion activa trayendo los datos del cliente
          para el boton de la navegacion superior derecha
        */
        Cliente clte = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        //^^trae el cliente de la sesion^^
        if (clte == null) {
            this.mensajeBoton = "Iniciar sesión";
        } else {
            this.mensajeBoton = "Cerrar sesión";
            this.setNombre_clte("Hola " + clte.getNombre_clte() + "!");
        }
    }//fin de la verificacion de la sesion

    public String botomInicio() {
        /*Le da las direcciones al boton el boton de la navegacion superior derecha
        */
        Cliente clte = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        //^^trae el cliente de la sesion^^
        if (clte == null) {
            return "/login";//si no ha iniciado sesion redirige a login.xhtml
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();//cierra la sesion activa
            return "/index?faces-redirect=true";//redirige al index con la sesion cerrada
        }
    }//fin de las direcciones para el botonInicio

}//fin de la clase
