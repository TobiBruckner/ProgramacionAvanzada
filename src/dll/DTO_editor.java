package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Editor;

public class DTO_editor {
    
    /**
     * Registra un nuevo editor en la base de datos
     * @param nombre Nombre del editor
     * @param apellido Apellido del editor
     * @param dni DNI del editor
     * @param nombre_usuario Nombre de usuario para el sistema
     * @param contrasenia Contraseña para el sistema
     * @param especialidad Especialidad del editor
     * @return true si el registro fue exitoso, false en caso contrario
     */
    public static boolean registrar_editor(String nombre, String apellido, int dni, 
            String nombre_usuario, String contrasenia, String especialidad) {
        
        boolean registro = false;
        
        try {
            // Primero registramos el usuario
            int id_usuario = DTO_usuario.registrar_usuario(nombre, apellido, dni, nombre_usuario, contrasenia, 2);
            
            if (id_usuario > 0) {
                // Si el usuario se registró correctamente, registramos el editor
                Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO editor (id_usuario, especialidad) VALUES (?, ?)");
                ps.setInt(1, id_usuario);
                ps.setString(2, especialidad);
                
                int res = ps.executeUpdate();
                if (res > 0) {
                    registro = true;
                }
                
                ps.close();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar editor: " + e.getMessage());
        }
        
        return registro;
    }
    
    /**
     * Verifica si ya existe un editor con el nombre de usuario especificado
     * @param nombre_usuario El nombre de usuario a verificar
     * @return true si existe, false en caso contrario
     */
    public static boolean verificar_editor_existente(String nombre_usuario) {
        return DTO_usuario.verificar_usuario_existente(nombre_usuario);
    }
}