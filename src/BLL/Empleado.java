package BLL;

import javax.swing.JOptionPane;

import repository.Validaciones;

public class Empleado extends Usuario{
	//ATRIBUTOS
	private String sucursal;
	//CONSTRUCTOR
	public Empleado(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, String sucursal) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.sucursal = sucursal;
	}
	//GETTERS Y SETTERS
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	//MÉTODOS
	
	public String Login() {
		return "";
	}
	@Override
	public void Menu() {
		
	}
	@Override
	public void Registrarse() {
		String nombre = Validaciones.ValidarString("Ingrese nombre:");
		String apellido = Validaciones.ValidarString("Ingrese apellido:");
		int dNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI:"));
		String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
		String contrasenia = Validaciones.ValidarString("Ingrese contraseña:");
		String sucursal = Validaciones.ValidarString("Ingrese su sucursal: ");

		
	}
	public void VerInformacionLibro() {
		
	}
	public void ModificarPrecio() {
		
	}
	
}
