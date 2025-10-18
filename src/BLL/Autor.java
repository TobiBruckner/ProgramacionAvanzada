package BLL;

import javax.swing.JOptionPane;

import repository.Validaciones;
import repository.opciones_autor;

public class Autor extends Usuario{
	//ATRIBUTOS
	private int idAutor;
	private String red_social;
	private String biografia;
	//CONSTRUCTOR
	public Autor(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, int idAutor,
			String red_social, String biografia) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.idAutor = idAutor;
		this.red_social = red_social;
		this.biografia = biografia;
	}
	
	public Autor(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, int idAutor) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.idAutor = idAutor;
	}

	//GETTERS Y SETTERS
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getRed_social() {
		return red_social;
	}
	public void setRed_social(String red_social) {
		this.red_social = red_social;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	//MÉTODOS
	@Override
	public void Registrarse() {
		String nombre = Validaciones.ValidarString("Ingrese nombre:");
		String apellido = Validaciones.ValidarString("Ingrese apellido:");
		int dNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI:"));
		String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
		String contrasenia = Validaciones.ValidarString("Ingrese contraseña:");
		String red_social = Validaciones.ValidarString("Ingrese red social:");
		String biografia = Validaciones.ValidarString("Ingrese biografía:");
	
		if (dll.DTO_autor.verificar_autor_existente(nombre_usuario)) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Por favor, elija otro.");
			return;
		}
		
		boolean registrado = dll.DTO_autor.registrar_autor(nombre, apellido, dNI, nombre_usuario, contrasenia, red_social, biografia);
		
		if (registrado) {
			JOptionPane.showMessageDialog(null, "Autor registrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al registrar el autor.");
		}
	}
	
	public String Login() {
		return "";
		
	}
	public void CargarInfo() {
		
	}
	public void EnviarPropuesta() {
		
	}
	public void VerEstadoPropuesta() {
		
	}
	
	
}
