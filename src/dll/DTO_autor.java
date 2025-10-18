package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Autor;

public class DTO_autor {
 
    public static boolean registrar_autor(String nombre, String apellido, int dni, 
            String nombre_usuario, String contrasenia, String red_social, String biografia) {
        
        boolean registro = false;
        
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO autor (nombre, apellido, dni, nombre_usuario, contrasenia, red_social, biografia) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, dni);
            ps.setString(4, nombre_usuario);
            ps.setString(5, contrasenia);
            ps.setString(6, red_social);
            ps.setString(7, biografia);
            
            int res = ps.executeUpdate();
            if (res > 0) {
                registro = true;
            }
            
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar autor: " + e.getMessage());
        }
        
        return registro;
    }
    
    public static boolean verificar_autor_existente(String nombre_usuario) {
        boolean existe = false;
        
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM autor WHERE nombre_usuario = ?");
            ps.setString(1, nombre_usuario);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                existe = true;
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar autor: " + e.getMessage());
        }
        
        return existe;
    }
}