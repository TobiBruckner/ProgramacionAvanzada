package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BLL.Autor;
import DLL.Conexion;

public class DTO_autor {

	private static Connection con = Conexion.getInstance().getConnection();	
	
	public static Autor login_dto(String nombre_usuario, String pass) {	
    	Autor autor = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM autor WHERE nombre_usuario = ? AND pass = ?"
            );
            stmt.setString(1, nombre_usuario);
            stmt.setString(2, pass);
            //executequery se utiliza cuando no hay cambios en la bdd
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_autor = rs.getInt("id_autor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                String biografia = rs.getString("biografia");
                String redes_sociales = rs.getString("redes_sociales");

                 autor = new Autor(id_autor,nombre,apellido,dni,nombre_usuario,pass);
                }
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autor;
    }
	
}