package dll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import BLL.Autor;
import BLL.Propuesta;
import BLL.Usuario;
import dll.Conexion;
import repository.Encriptador;

public class DTO_autor {

	private static Connection con = Conexion.getInstance().getConnection();	
	
	//login_dto
	public static Autor login_dto(String nombre_usuario, String pass) {	
    	Autor autor = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM autor WHERE nombre_usuario = ? AND pass = ?"
            );
            stmt.setString(1, nombre_usuario);
            stmt.setString(2, Encriptador.encriptar(pass));
            //executequery se utiliza cuando no hay cambios en la bdd
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_autor = rs.getInt("id_autor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String biografia = rs.getString("biografia");
                String redes_sociales = rs.getString("redes_sociales");

                 autor = new Autor(id_autor,nombre,apellido,dni,nombre_usuario,pass, redes_sociales, id_autor, redes_sociales);
                }
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autor;
    }
	
	//agregar_autor
	public static boolean agregarAutor_dto(Autor autor) {
	
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO autor( nombre, apellido, dni, pass, biografia, redes_sociales,nombre_usuario) VALUES (?, ?, ?, ?, ?,?, ?)"
            );
            statement.setString(1, autor.getNombre());
            statement.setString(2, autor.getApellido());
            statement.setString(3, autor.getDni());
            statement.setString(4, Encriptador.encriptar(autor.getPass()));
            statement.setString(5, autor.getBiografia());
            statement.setString(6, autor.getRedes_sociales());
            statement.setString(7, autor.getNombre_usuario());

            

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Autor agregado correctamente.");
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
	
	//agregar_propuesta	
			public static boolean agregar_propuesta_dto(Propuesta propuesta) {
				
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
			


}