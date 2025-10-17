package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Usuario;

public class DTO_usuario {
    
    public static int registrar_usuario(String nombre, String apellido, int dni, 
            String nombre_usuario, String contrasenia, int tipo_usuario) {
        
        int id_usuario = 0;
        
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO usuario (nombre, apellido, dni, nombre_usuario, contrasenia, tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, dni);
            ps.setString(4, nombre_usuario);
            ps.setString(5, contrasenia);
            ps.setInt(6, tipo_usuario);
            
            int res = ps.executeUpdate();
            if (res > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    id_usuario = rs.getInt(1);
                }
                rs.close();
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        }
        
        return id_usuario;
    }
    
    public static boolean verificar_usuario_existente(String nombre_usuario) {
        boolean existe = false;
        
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM usuario WHERE nombre_usuario = ?");
            ps.setString(1, nombre_usuario);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                existe = true;
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + e.getMessage());
        }
        
        return existe;
    }
    
    public static int validar_credenciales(String nombre_usuario, String contrasenia) {
        int id_usuario = 0;
        
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id_usuario FROM usuario WHERE nombre_usuario = ? AND contrasenia = ?");
            ps.setString(1, nombre_usuario);
            ps.setString(2, contrasenia);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id_usuario = rs.getInt("id_usuario");
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar credenciales: " + e.getMessage());
        }
        
        return id_usuario;
    }
}