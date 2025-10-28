package dll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BLL.EstadoPropuesta;
import BLL.Propuesta;
import java.util.Optional;

public class DTO_estado_propuesta {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	// Método para agregar un estado de propuesta
	public static boolean agregarEstadoPropuesta(EstadoPropuesta estadoPropuesta) {
		try {
			PreparedStatement statement = con.prepareStatement(
				"INSERT INTO estado_propuesta (estado_propuesta, estimacion_ganancia, fk_propuesta, fk_editor) VALUES (?, ?, ?, ?)"
			);
			statement.setString(1, estadoPropuesta.getEstado_propuesta());
			statement.setDouble(2, estadoPropuesta.getEstimacion_ganancia());
			statement.setInt(3, estadoPropuesta.getFk_propuesta());
			statement.setInt(4, estadoPropuesta.getFk_editor());
			
			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Estado de propuesta agregado correctamente.");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al agregar estado de propuesta: " + e.getMessage());
			return false;
		}
		return false;
	}
	
	// Método para obtener propuestas sin estado (pendientes de evaluación)
	public static List<String> obtenerPropuestasPendientes() {
		List<String> propuestasPendientes = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(
				"SELECT p.id_propuesta, p.nombre_propuesta, p.cantidad_capitulos, p.cantidad_paginas, p.capitulo_piloto, " +
				"a.nombre, a.apellido, a.biografia, a.redes_sociales " +
				"FROM propuesta p " +
				"INNER JOIN autor a ON p.fk_autor = a.id_autor " +
				"LEFT JOIN estado_propuesta ep ON p.id_propuesta = ep.fk_propuesta " +
				"WHERE ep.fk_propuesta IS NULL"
			);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String propuestaInfo = String.format(
					"ID: %d | %s\n" +
					"Capítulos: %d | Páginas: %d\n" +
					"Autor: %s %s\n" +
					"Capítulo Piloto: %s\n" +
					"Biografía: %s\n" +
					"Redes: %s\n" +
					"================================",
					rs.getInt("id_propuesta"),
					rs.getString("nombre_propuesta"),
					rs.getInt("cantidad_capitulos"),
					rs.getInt("cantidad_paginas"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getString("capitulo_piloto"),
					rs.getString("biografia"),
					rs.getString("redes_sociales")
				);
				propuestasPendientes.add(propuestaInfo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener propuestas pendientes: " + e.getMessage());
		}
		
		return propuestasPendientes;
	}
	
	// Método para verificar si una propuesta ya tiene estado
	public static boolean propuestaTieneEstado(int idPropuesta) {
		try {
			PreparedStatement stmt = con.prepareStatement(
				"SELECT COUNT(*) FROM estado_propuesta WHERE fk_propuesta = ?"
			);
			stmt.setInt(1, idPropuesta);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Método para obtener estados de propuestas por autor
	public static List<String> obtenerEstadosPorAutor(int idAutor) {
		List<String> estados = new ArrayList<>();
		try {
			PreparedStatement stmt = con.prepareStatement(
				"SELECT p.id_propuesta, p.nombre_propuesta, ep.estado_propuesta, ep.estimacion_ganancia " +
				"FROM propuesta p " +
				"LEFT JOIN estado_propuesta ep ON ep.fk_propuesta = p.id_propuesta " +
				"WHERE p.fk_autor = ?"
			);
			stmt.setInt(1, idAutor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int idProp = rs.getInt("id_propuesta");
				String nombre = rs.getString("nombre_propuesta");
				String estado = rs.getString("estado_propuesta");
				double estimacion = rs.getDouble("estimacion_ganancia");

				String estadoTexto;
				if (estado == null) {
					estadoTexto = String.format(
						"Propuesta #%d - %s\nEstado: Pendiente\n--------------------------------",
						idProp, nombre
					);
				} else if ("Aceptada".equalsIgnoreCase(estado)) {
					estadoTexto = String.format(
						"Propuesta #%d - %s\nEstado: Aceptada\nEstimación de ganancia: $%.2f\n--------------------------------",
						idProp, nombre, estimacion
					);
				} else { // Rechazada u otro
					estadoTexto = String.format(
						"Propuesta #%d - %s\nEstado: Rechazada\n--------------------------------",
						idProp, nombre
					);
				}

				estados.add(estadoTexto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al obtener estados de propuestas: " + e.getMessage());
		}
		return estados;
	}
}