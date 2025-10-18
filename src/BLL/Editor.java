package BLL;

import javax.swing.JOptionPane;

import repository.Validaciones;
import repository.opciones_editor;

public class Editor extends Usuario{
	//ATRIBUTOS
	private int idEditor;
	private String especialidad;
	//CONSTRUCTOR
	public Editor(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, int idEditor,
			String especialidad) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.idEditor = idEditor;
		this.especialidad = especialidad;
	}
	//GETTERS Y SETTERS
	public int getIdEditor() {
		return idEditor;
	}
	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	//MÉTODOS
	@Override
	public void Registrarse() {
		String nombre = Validaciones.ValidarString("Ingrese nombre:");
		String apellido = Validaciones.ValidarString("Ingrese apellido:");
		int dNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI:"));
		String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
		String contrasenia = Validaciones.ValidarString("Ingrese contraseña:");
		String especialidad = Validaciones.ValidarString("Ingrese especialidad:");
		
		if (dll.DTO_editor.verificar_editor_existente(nombre_usuario)) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Por favor, elija otro.");
			return;
		}
	
		boolean registrado = dll.DTO_editor.registrar_editor(nombre, apellido, dNI, nombre_usuario, contrasenia, especialidad);
		
		if (registrado) {
			JOptionPane.showMessageDialog(null, "Editor registrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al registrar el editor.");
		}
	}
	
	public String Login() {
		return "";
	}

	public void VerPropuesta() {
		
	}
	public void EstimacionGanancia() {
		
	}
	
}
