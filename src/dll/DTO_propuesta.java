package dll;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


import BLL.Propuesta;
import repository.Encriptador;

public class DTO_propuesta {
	
	
	private static Connection con = Conexion.getInstance().getConnection();	
	
	
//agregar_propuesta	
	public static boolean agregar_propuesta(Propuesta propuesta) {
		
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO propuesta (nombre_propuesta, cantidad_capitulos, cantidad_paginas, capitulo_piloto,fk_autor) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, propuesta.getNombre_propuesta());
            statement.setInt(2, propuesta.getCantidad_capitulos());
            statement.setInt(3, propuesta.getCantidad_paginas());
            statement.setString(4, propuesta.getCapitulo_piloto());
            
           

            

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
