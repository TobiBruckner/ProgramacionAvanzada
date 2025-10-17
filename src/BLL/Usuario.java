package BLL;
import javax.swing.JOptionPane;

import repository.Validaciones;

public class Usuario {
	//ATRIBUTOS
	protected String nombre;
	protected String apellido;
	protected int dNI;
	protected String nombre_usuario;
	protected String contrasenia;
	//CONSTRUCTOR
	public Usuario(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dNI = dNI;
		this.nombre_usuario = nombre_usuario;
		this.contrasenia = contrasenia;
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDNI() {
		return dNI;
	}
	public void setDNI(int dNI) {
		this.dNI = dNI;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	//MÉTODOS
	public String Login() {
		return "";
	}
	public void Menu() {
		
	}
	public void Registrarse() {
		String nombre = Validaciones.ValidarString("Ingrese nombre: ");
		String apellido = Validaciones.ValidarString("Ingrese apellido: ");
		int dNI = Validaciones.ValidarInt("Ingrese DNI: ");
		String nombre_usuario = Validaciones.ValidarString("Ingrese su nombre de usuario: ");
		String contrasenia = Validaciones.ValidarString("Ingrese su contraseña");
		
		
	}
}
