package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import BLL.Editor;
import BLL.Empleado;
import repository.Encriptador;

public class DTO_empleado {
private static Connection con = Conexion.getInstance().getConnection();	
	
	public static Empleado login_dto(String nombre_usuario, String pass) {	
    	Empleado empleado = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM empleado WHERE nombre_usuario = ? AND pass = ?"
            );
            stmt.setString(1, nombre_usuario);
            stmt.setString(2, Encriptador.encriptar(pass));
            //executequery se utiliza cuando no hay cambios en la bdd
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_empleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                byte[] foto_perfil = rs.getBytes("foto_perfil");


                 empleado = new Empleado(id_empleado,nombre,apellido,dni,nombre_usuario,pass);
                }
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
	}
	
	public static boolean agregarEmpleado(Empleado empleado) {
	
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO empleado (nombre, apellido, dni, pass, nombre_usuario, foto_perfil) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido());
            statement.setString(3, empleado.getDni());
            statement.setString(4, Encriptador.encriptar(empleado.getPass()));
            statement.setString(5, empleado.getNombre_usuario());
            byte[] foto = empleado.getFotoPerfil();
            if (foto == null) {
                foto = new byte[0];
            }
            statement.setBytes(6, foto);
            
            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Empleado agregado correctamente.");
                return true;
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
           	JOptionPane.showMessageDialog(null, "Empleado con nombre de usuario ya creado");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return false;
    }
	
}
