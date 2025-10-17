package BLL;

import javax.swing.JOptionPane;

import repository.Validaciones;

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
	
	}
	
	public String Login() {
		return "";
		
	}
	@Override
	public void Menu() {
		
	}
	public void CargarInfo() {
		
	}
	public void EnviarPropuesta() {
		
	}
	public void VerEstadoPropuesta() {
		
	}
	
	
}
