package BLL;

public class Usuario {
	//ATRIBUTOS
	private String nombre;
	private String apellido;
	private int DNI;
	private String nombre_usuario;
	private String contrasenia;
	//CONSTRUCTOR
	public Usuario(String nombre, String apellido, int dNI, String mail, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		this.nombre_usuario = mail;
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
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getMail() {
		return nombre_usuario;
	}
	public void setMail(String nombre_usuario) {
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
}
