package com;

import dao.Cliente;
import dao.Cliente_datos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "login")
@SessionScoped
public class Login extends Cliente implements Serializable {

    public Login() {
    }

    public String validarUsuario() {
        Cliente_datos clteRep = new Cliente_datos();
        String correo = this.getCorreo_clte();
        boolean result = clteRep.validaUsuario(correo, this.getPass_clte());//consulta la existencia del usuario
        if (result) {
            Cliente clte = clteRep.datosCliente(correo, this.getPass_clte());//traer los datos del usuario 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", clte);//guardar los datos del usuario en sesion
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,//agregar mensaje de error a la pagina login
                            "Datos incorrectos!",
                            "Intenta de nuevo!"));
            return "login";
        }
    }

}//fin de la clase del bean de inicio de sesion
