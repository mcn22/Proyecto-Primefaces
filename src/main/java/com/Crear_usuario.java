package com;

import dao.Cliente;
import dao.Cliente_datos;
import dao.ValidacionesCrearUsuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "crear_usuario")
@RequestScoped
public class Crear_usuario extends Cliente {

    private Boolean bloquearBoton;
    private String mensajeNombre;
    private String mensajeApellido1;
    private String mensajeApellido2;
    private String mensajeCorreo;

    public String getMensajeNombre() {
        return mensajeNombre;
    }

    public void setMensajeNombre(String mensajeNombre) {
        this.mensajeNombre = mensajeNombre;
    }

    public String getMensajeApellido1() {
        return mensajeApellido1;
    }

    public void setMensajeApellido1(String mensajeApellido1) {
        this.mensajeApellido1 = mensajeApellido1;
    }

    public String getMensajeApellido2() {
        return mensajeApellido2;
    }

    public void setMensajeApellido2(String mensajeApellido2) {
        this.mensajeApellido2 = mensajeApellido2;
    }

    public Boolean getBloquearBoton() {
        return bloquearBoton;
    }

    public void setBloquearBoton(Boolean bloquearBoton) {
        this.bloquearBoton = bloquearBoton;
    }

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public Crear_usuario() {
    }
    
    //---------------------------------//

    public String registraClte() {
        Boolean formatoCorrecto = ValidacionesCrearUsuario.valida(this.getNombre_clte(),
                this.getApellido1(), this.getApellido2(), this.getCorreo_clte());//valida los formatos
        Boolean correoOcupado = Cliente_datos.validaCorreo(this.getCorreo_clte());//verifica que el correo no este en uso
        if (formatoCorrecto && !correoOcupado) {
            Cliente_datos clteDatos = new Cliente_datos();
            clteDatos.guardaCliente(this);
            return "login";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,//agregar mensaje de error a la pagina login
                            "Revisa los datos introducidos!",
                            "Error"));
            return "crear_usuario";
        }
        //las validaciones y registro del usuario
    }
    
    //------Validaciones ajax----------//

    public void validaNombre() {
        Boolean formatoOk = ValidacionesCrearUsuario.validaFormatoNombre(this.getNombre_clte());
        if (!formatoOk) {
            this.mensajeNombre = "Nombre no válido!";
        } else {
        }
    }

    public void validaApellido1() {
        Boolean formatoOk = ValidacionesCrearUsuario.validaFormatoNombre(this.getApellido1());
        if (!formatoOk) {
            this.mensajeApellido1 = "Apellido no válido!";
        } else {
        }
    }

    public void validaApellido2() {
        Boolean formatoOk = ValidacionesCrearUsuario.validaFormatoNombre(this.getApellido2());
        if (!formatoOk) {
            this.mensajeApellido2 = "Apellido no válido!";
        } else {
        }
    }

    public void validaCorreo() {
        Boolean formatoOk = ValidacionesCrearUsuario.validaFormatoCorreo(this.getCorreo_clte());
        Boolean correoOcupado = Cliente_datos.validaCorreo(this.getCorreo_clte());
        if (!formatoOk || correoOcupado) {
            this.mensajeCorreo = "Correo no válido!";
        } else {
        }
    }

}//fin de la clase de la creacion de los usuarios
