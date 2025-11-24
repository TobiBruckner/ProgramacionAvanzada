package dll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import BLL.Autor;
import BLL.Libro;
import repository.Encriptador;

public class DTO_libro {
    private static Connection con = Conexion.getInstance().getConnection(); 

    public static boolean agregarLibro(Libro libro) {
		
        try {
            PreparedStatement statement = con.prepareStatement(
                "INSERT INTO libro (nombre_libro, autor_libro, precio_libro, stock, popularidad) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, libro.getNombre_libro());
            statement.setString(2, libro.getAutor_libro());
            statement.setDouble(3, libro.getPrecio_libro());
            statement.setInt(4, libro.getStock());
            statement.setString(5, libro.getPopularidad());
      

            

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Libro agregado correctamente.");
                return true;
            }
        } catch (MySQLIntegrityConstraintViolationException e) {
           	JOptionPane.showMessageDialog(null, "Libro con mismo nombre ya creado");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return false;
    }

    public static LinkedList<Libro> mostrarLibros() {
	    LinkedList<Libro> libros = new LinkedList<>();
	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM libro");
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id_libro = rs.getInt("id_libro");
	            String nombre_libro = rs.getString("nombre_libro");
	            String autor_libro = rs.getString("autor_libro");
	            double precio_libro = rs.getDouble("precio_libro");
	            int stock = rs.getInt("stock");
	            String popularidad = rs.getString("popularidad");

	            libros.add(new Libro(id_libro, nombre_libro, autor_libro, precio_libro, stock, popularidad));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        return libros;
    }

    public static boolean actualizarPrecioLibro(int idLibro, double nuevoPrecio) {
        try {
            PreparedStatement statement = con.prepareStatement(
                "UPDATE libro SET precio_libro = ? WHERE id_libro = ?"
            );
            statement.setDouble(1, nuevoPrecio);
            statement.setInt(2, idLibro);
            int filas = statement.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
