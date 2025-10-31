package dll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import BLL.Autor;
import BLL.Propuesta;
import repository.Encriptador;

public class DTO_propuesta {
	
	
	private static Connection con = Conexion.getInstance().getConnection();	
	
	

	public static boolean agregar_propuesta(Propuesta propuesta) {
		
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO propuesta (nombre_propuesta, cantidad_capitulos, cantidad_paginas, capitulo_piloto,fk_autor) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, propuesta.getNombre_propuesta());
            statement.setInt(2, propuesta.getCantidad_capitulos());
            statement.setInt(3, propuesta.getCantidad_paginas());
            statement.setString(4, propuesta.getCapitulo_piloto());
            statement.setInt(5, propuesta.getIdAutor());
            
           

            

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("propuesta agregada correctamente.");
                return true;
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
           	JOptionPane.showMessageDialog(null, "Autor con nombre de usuario ya creado");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return false;
    }
	

	public static List<String> obtenerPropuestasConAutor() {
		List<String> propuestas = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(
				"SELECT p.nombre_propuesta, p.cantidad_capitulos, p.cantidad_paginas, p.capitulo_piloto, " +
				"a.nombre, a.apellido, a.biografia, a.redes_sociales " +
				"FROM propuesta p " +
				"INNER JOIN autor a ON p.fk_autor = a.id_autor"
			);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String propuestaInfo = String.format(
					"=== PROPUESTA ===\n" +
					"Nombre: %s\n" +
					"Capítulos: %d\n" +
					"Páginas: %d\n" +
					"Capítulo Piloto: %s\n\n" +
					"=== AUTOR ===\n" +
					"Nombre: %s %s\n" +
					"Biografía: %s\n" +
					"Redes Sociales: %s\n" +
					"================================\n",
					rs.getString("nombre_propuesta"),
					rs.getInt("cantidad_capitulos"),
					rs.getInt("cantidad_paginas"),
					rs.getString("capitulo_piloto"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getString("biografia"),
					rs.getString("redes_sociales")
				);
				propuestas.add(propuestaInfo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener propuestas: " + e.getMessage());
		}
		
		return propuestas;
	}
	
}
