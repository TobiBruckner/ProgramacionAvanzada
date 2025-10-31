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
		
	}
	public void ModificarPrecio() {
		
	}
	
	@Override
	public String toString() {
		return "Empleado [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
				+ ", getNombre_usuario()=" + getNombre_usuario() + ", getPass()=" + getPass() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
