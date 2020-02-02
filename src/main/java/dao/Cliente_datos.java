package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente_datos {

    final String SELECTINICIOSESION = "SELECT * FROM cliente WHERE correo_clte=? AND pass_clte=?";
    final static String SELECTVERIFICACORREO = "SELECT * FROM cliente WHERE correo_clte=?";
    final String INSERTCLTE = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?)";

    public boolean validaUsuario(String correo, String pass) {
        boolean resultado = false;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SELECTINICIOSESION);
            sentencia.setString(1, correo);
            sentencia.setString(2, pass);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }//fin de la validacion de los datos

    public Cliente datosCliente(String correo, String pass) {
        /*Trae los datos del cliente para ser almacenados en sesion*/
        Cliente clte = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SELECTINICIOSESION);
            sentencia.setString(1, correo);
            sentencia.setString(2, pass);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next() != false) {
                clte = new Cliente();
                clte.setId_clte(resultSet.getInt("id_clte"));
                clte.setNombre_clte(resultSet.getString("nombre_clte"));
                clte.setApellido1(resultSet.getString("apellido1"));
                clte.setApellido2(resultSet.getString("apellido2"));
                clte.setCorreo_clte(resultSet.getString("correo_clte"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clte;//devuelve el cliente 
    }//fin de la validacion de los datos

    public void guardaCliente(Cliente clte) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(INSERTCLTE);
            sentencia.setInt(1, incrementoId());
            sentencia.setString(2, clte.getNombre_clte());
            sentencia.setString(3, clte.getCorreo_clte());
            sentencia.setString(4, clte.getPass_clte());
            sentencia.setString(5, clte.getApellido1());
            sentencia.setString(6, clte.getApellido2());

            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//fin de guarda cliente 

    private int incrementoId() {
        /*Crea el aumento del id del cliente, no hay AUTOINCREMENT
        este es llamado desde guardaCliente(), trae la cantidad de 
        usuarios en la bd y los va sumando*/
        int contador = 1;
        try {
            String consulta = "SELECT ID_CLTE FROM CLIENTE";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                contador += 1;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return contador;
    }

    public static boolean validaCorreo(String correo) {
        boolean resultado = false;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SELECTVERIFICACORREO);
            sentencia.setString(1, correo);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }//fin de la validacion de los datos

}//fin de la clase cliente datos
