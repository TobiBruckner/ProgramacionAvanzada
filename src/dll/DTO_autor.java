package dll;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Autor;

public class DTO_autor {
    
    
    public static boolean registrar_autor(String nombre, String apellido, int dni, 
            String nombre_usuario, String contrasenia, String red_social, String biografia) {
        
        boolean registro = false;
        
        try {
            
            int id_usuario = DTO_usuario.registrar_usuario(nombre, apellido, dni, nombre_usuario, contrasenia, 1);
            
            if (id_usuario > 0) {
                
                Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO autor (id_usuario, red_social, biografia) VALUES (?, ?, ?)");
                ps.setInt(1, id_usuario);
                ps.setString(2, red_social);
                ps.setString(3, biografia);
                
                int res = ps.executeUpdate();
                if (res > 0) {
                    registro = true;
                }
                
                ps.close();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar autor: " + e.getMessage());
        }
        
        return registro;
    }
    
    public static boolean verificar_autor_existente(String nombre_usuario) {
        return DTO_usuario.verificar_usuario_existente(nombre_usuario);
    }
}