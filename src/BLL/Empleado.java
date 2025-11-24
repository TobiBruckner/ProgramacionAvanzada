package BLL;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import dll.DTO_autor;
import dll.DTO_editor;
import dll.DTO_empleado;
import dll.DTO_libro;
import repository.Encriptador;
import repository.Validaciones;
import repository.opciones_empleado;

public class Empleado extends Usuario{
	//ATRIBUTOS
	private int id_empleado;
	//CONSTRUCTOR
	public Empleado(String nombre, String apellido, String dni, String nombre_usuario, String pass,
			int id_empleado) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		
	}
	
	public Empleado(int id_empleado, String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.id_empleado = id_empleado;
	}

	public Empleado(String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
	}
	
	

	//GETTERS Y SETTERS
	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	//MÉTODOS
	public static Empleado Login_empleado() {
		String nombre_usuario;
		String pass;

		nombre_usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
		pass = JOptionPane.showInputDialog("Ingrese su contraseña: ");

		if (nombre_usuario.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error al ingresar datos");
			return null;
		}else {

			return DTO_empleado.login_dto(nombre_usuario, pass);

		}
	}
	
	public static boolean AgregarEmpleado() {
		String nombre = Validaciones.ValidarString("Ingrese nombre:");
		String apellido = Validaciones.ValidarString("Ingrese apellido:");
		String dni = Validaciones.ValidarString("Ingrese DNI:");
		String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
		String pass = Validaciones.ValidarString("Ingrese contraseña:");
		
		Empleado nuevo = new Empleado(nombre,apellido,dni,nombre_usuario,pass);
		
		return DTO_empleado.agregarEmpleado(nuevo);
	}

    public void VerInformacionLibro() {
        java.util.LinkedList<Libro> libros = DTO_libro.mostrarLibros();
        if (libros == null || libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Libro l : libros) {
            sb.append("ID: ").append(l.getId_libro())
              .append(" | Nombre: ").append(l.getNombre_libro())
              .append(" | Autor: ").append(l.getAutor_libro())
              .append(" | Precio: $").append(l.getPrecio_libro())
              .append(" | Stock: ").append(l.getStock())
              .append(" | Popularidad: ").append(l.getPopularidad())
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Información de Libros", JOptionPane.INFORMATION_MESSAGE);
    }
    public void ModificarPrecio() {
        java.util.LinkedList<Libro> libros = DTO_libro.mostrarLibros();
        if (libros == null || libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados");
            return;
        }
        String idStr = JOptionPane.showInputDialog("Ingrese ID de libro a modificar");
        if (idStr == null || idStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID inválido");
            return;
        }
        int id;
        try {
            id = Integer.parseInt(idStr.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID debe ser numérico");
            return;
        }
        String precioStr = JOptionPane.showInputDialog("Ingrese nuevo precio");
        if (precioStr == null || precioStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Precio inválido");
            return;
        }
        double nuevoPrecio;
        try {
            nuevoPrecio = Double.parseDouble(precioStr.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Precio debe ser numérico");
            return;
        }
        if (nuevoPrecio <= 0) {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0");
            return;
        }
        boolean ok = DTO_libro.actualizarPrecioLibro(id, nuevoPrecio);
        JOptionPane.showMessageDialog(null, ok ? "Precio actualizado" : "No se pudo actualizar el precio");
    }
	
	@Override
	public String toString() {
		return "Empleado [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
				+ ", getNombre_usuario()=" + getNombre_usuario() + ", getPass()=" + getPass() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	public static void menu_empleado(Empleado empleado) {
		
		
		//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
				//,0,null,
				//opciones_empleado.values(),opciones_empleado.values()[0]);
		
		
		int menu_empleado;
		
        do {
            menu_empleado = JOptionPane.showOptionDialog(null,"Menú empleado","¿Qué desea realizar?"
                    ,0,0,null,
                    opciones_empleado.values(),opciones_empleado.values()[0]);
            switch (menu_empleado) {
            case 0:
                empleado.VerInformacionLibro();
                break;
            case 1:
                boolean ok = Libro.AgregarLibro();
                JOptionPane.showMessageDialog(null, ok ? "Libro agregado correctamente" : "No se pudo agregar el libro");
                break;
            case 2:
                empleado.ModificarPrecio();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Salir");
                break;
            }
        } while (menu_empleado!=3);
	}
	
}
