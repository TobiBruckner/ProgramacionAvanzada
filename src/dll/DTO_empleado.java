package dll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Empleado;

public class DTO_empleado {
 
    public static boolean registrar_empleado(String nombre, String apellido, int dni, 
            String nombre_usuario, String contrasenia, String sucursal) {
        
        boolean registro = false;
        
        try {
      
            int id_usuario = DTO_usuario.registrar_usuario(nombre, apellido, dni, nombre_usuario, contrasenia, 3);
            
            if (id_usuario > 0) {
       
                Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO empleado (id_usuario, sucursal) VALUES (?, ?)");
                ps.setInt(1, id_usuario);
                ps.setString(2, sucursal);
                
                int res = ps.executeUpdate();
                if (res > 0) {
                    registro = true;
                }
                
                ps.close();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar empleado: " + e.getMessage());
        }
        
        return registro;
    }
    
    public static boolean verificar_empleado_existente(String nombre_usuario) {
        return DTO_usuario.verificar_usuario_existente(nombre_usuario);
    }
}