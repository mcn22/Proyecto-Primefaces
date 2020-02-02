package dao;

import java.util.regex.*;

public class ValidacionesCrearUsuario {

    public static boolean valida(String nombre, String ape1, String ape2, String correo) {
        boolean correcto = false;
        boolean nomb = validaFormatoNombre(nombre);
        boolean apel1 = validaFormatoNombre(ape1);
        boolean apel2 = validaFormatoNombre(ape2);
        boolean corr = validaFormatoCorreo(correo);
        if (nomb && apel1 && apel2 && corr) {
            correcto = true;
        }//fin del if
        return correcto;
    }//fin de la validacion general

    public static boolean validaFormatoCorreo(String correo) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }//fin de la validacion de los correos

    public static boolean validaFormatoNombre(String dato) {
        Pattern pattern = Pattern.compile("^([a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]){2,30}$");
        Matcher matcher = pattern.matcher(dato);
        return matcher.matches();
    }//fin de la validacion de los nombres

}//fin de las validaciones del usuario al crear cuenta
