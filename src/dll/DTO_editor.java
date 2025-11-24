package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import BLL.Autor;
import BLL.Editor;
import repository.Encriptador;

public class DTO_editor {
private static Connection con = Conexion.getInstance().getConnection();	
	
    public static Editor login_dto(String nombre_usuario, String pass) {
    	Editor editor = null;
        try {
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Sin conexión a la base de datos");
                return null;
            }
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM editor WHERE nombre_usuario = ? AND pass = ?"
            );
            stmt.setString(1, nombre_usuario);
            stmt.setString(2, Encriptador.encriptar(pass));
            //executequery se utiliza cuando no hay cambios en la bdd
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_editor = rs.getInt("id_editor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                editor = new Editor(nombre,apellido,dni,nombre_usuario,pass,id_editor);
            }
       
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en login de editor: " + e.getMessage());
        }
        return editor;
    }
	
	public static boolean agregarEditor(Editor editor) {
	
        try {
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Sin conexión a la base de datos");
                return false;
            }
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO editor (nombre, apellido, dni, pass, nombre_usuario) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, editor.getNombre());
            statement.setString(2, editor.getApellido());
            statement.setString(3, editor.getDni());
            statement.setString(4, Encriptador.encriptar(editor.getPass()));
            statement.setString(5, editor.getNombre_usuario());

            


            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Editor agregado correctamente.");
                return true;
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
            	JOptionPane.showMessageDialog(null, "Editor con nombre de usuario ya creado");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar editor: " + e.getMessage());
            return false;

        }
        return false;
    }
	
	
	
}
