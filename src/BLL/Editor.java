package BLL;

import javax.swing.JOptionPane;

import dll.DTO_autor;
import dll.DTO_editor;
import dll.DTO_propuesta;
import repository.Validaciones;
import repository.opciones_editor;
import java.util.List;

public class Editor extends Usuario{
	//ATRIBUTOS
	private int id_editor;
	//CONSTRUCTOR
	
	public Editor(String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
	}

	

	public Editor(int id_editor, String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.id_editor = id_editor;
	}

	//GETTERS Y SETTERS
	public int getId_editor() {
		return id_editor;
	}
	public void setId_editor(int id_editor) {
		this.id_editor = id_editor;
	}
	//MÉTODOS
	public static Editor Login_editor() {
		String nombre_usuario;
		String pass;

		nombre_usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
		pass = JOptionPane.showInputDialog("Ingrese su contraseña: ");

		if (nombre_usuario.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error al ingresar datos");
			return null;
		}else {

			return DTO_editor.login_dto(nombre_usuario, pass);

		}
	}
	
	public static boolean AgregarEditor() {
		String nombre = Validaciones.ValidarString("Ingrese nombre:");
		String apellido = Validaciones.ValidarString("Ingrese apellido:");
		String dni = Validaciones.ValidarString("Ingrese DNI:");
		String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
		String pass = Validaciones.ValidarString("Ingrese contraseña:");
		
		Editor nuevo = new Editor(nombre,apellido,dni,nombre_usuario,pass);
		
		return DTO_editor.agregarEditor(nuevo);
	}

	public static void VerPropuesta() {
		List<String> propuestas = DTO_propuesta.obtenerPropuestasConAutor();
		
		if (propuestas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay propuestas registradas.");
		} else {
			StringBuilder mensaje = new StringBuilder("PROPUESTAS REGISTRADAS:\n\n");
			for (String propuesta : propuestas) {
				mensaje.append(propuesta).append("\n");
			}
			
			JOptionPane.showMessageDialog(null, mensaje.toString(), "Propuestas", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void EstimacionGanancia() {
		
	}

@Override
public String toString() {
	return "Editor [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
			+ ", getNombre_usuario()=" + getNombre_usuario() + ", getPass()=" + getPass() + ", toString()="
			+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}
	
}
