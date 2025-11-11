package BLL;

import javax.swing.JOptionPane;

import dll.DTO_autor;
import dll.DTO_editor;
import dll.DTO_propuesta;
import dll.DTO_estado_propuesta;
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

	

	public Editor(String nombre, String apellido, String dni, String nombre_usuario, String pass, byte[] fotoPerfil,int id_editor) {
		super(nombre, apellido, dni, nombre_usuario, pass, fotoPerfil);
		this.id_editor = id_editor;
	}

	public Editor(String nombre, String apellido, String dni, String nombre_usuario, String pass, int id_editor) {
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
	public static void EstimacionGanancia(int idEditor) {
		
		List<String> propuestasPendientes = DTO_estado_propuesta.obtenerPropuestasPendientes();
		
		if (propuestasPendientes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay propuestas pendientes de evaluación.");
			return;
		}
		
		
		StringBuilder mensaje = new StringBuilder("PROPUESTAS PENDIENTES DE EVALUACIÓN:\n\n");
		for (int i = 0; i < propuestasPendientes.size(); i++) {
			mensaje.append("PROPUESTA ").append(i + 1).append(":\n");
			mensaje.append(propuestasPendientes.get(i)).append("\n\n");
		}
		
		JOptionPane.showMessageDialog(null, mensaje.toString(), "Propuestas Pendientes", JOptionPane.INFORMATION_MESSAGE);
		
		
		String idPropuestaStr = JOptionPane.showInputDialog("Ingrese el ID de la propuesta que desea evaluar:");
		
		if (idPropuestaStr == null || idPropuestaStr.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Operación cancelada.");
			return;
		}
		
		try {
			int idPropuesta = Integer.parseInt(idPropuestaStr.trim());
			
			
			if (DTO_estado_propuesta.propuestaTieneEstado(idPropuesta)) {
				JOptionPane.showMessageDialog(null, "Esta propuesta ya ha sido evaluada.");
				return;
			}
			
			
			String[] opciones = {"Aceptar", "Rechazar", "Cancelar"};
			int decision = JOptionPane.showOptionDialog(
				null,
				"¿Qué decisión toma sobre esta propuesta?",
				"Evaluación de Propuesta",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opciones,
				opciones[0]
			);
			
			String estadoPropuesta;
			double estimacionGanancia = 0.0;
			
			if (decision == 0) {
				estadoPropuesta = "Aceptada";
				
			
				String estimacionStr = JOptionPane.showInputDialog("Ingrese la estimación de ganancia (valor numérico):");
				
				if (estimacionStr == null || estimacionStr.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar una estimación de ganancia para propuestas aceptadas.");
					return;
				}
				
				try {
					estimacionGanancia = Double.parseDouble(estimacionStr.trim());
					if (estimacionGanancia < 0) {
						JOptionPane.showMessageDialog(null, "La estimación de ganancia no puede ser negativa.");
						return;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido para la estimación.");
					return;
				}
				
			} else if (decision == 1) { 
				estadoPropuesta = "Rechazada";
				estimacionGanancia = 0.0; 
			} else {
				JOptionPane.showMessageDialog(null, "Operación cancelada.");
				return;
			}
			
			EstadoPropuesta estadoObj = new EstadoPropuesta(estadoPropuesta, estimacionGanancia, idPropuesta, idEditor);
			
			if (DTO_estado_propuesta.agregarEstadoPropuesta(estadoObj)) {
				String mensajeExito = String.format(
					"Propuesta %s correctamente.\nEstado: %s\nEstimación de ganancia: $%.2f",
					estadoPropuesta.toLowerCase(),
					estadoPropuesta,
					estimacionGanancia
				);
				JOptionPane.showMessageDialog(null, mensajeExito, "Evaluación Completada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error al guardar la evaluación de la propuesta.");
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un ID de propuesta válido (número entero).");
		}
	}

@Override
public String toString() {
	return "Editor [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
			+ ", getNombre_usuario()=" + getNombre_usuario() + ", getPass()=" + getPass() + ", toString()="
			+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}

public static void menu_editor(Editor editor) {
	
	
	//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
			//,0,null,
			//opciones_empleado.values(),opciones_empleado.values()[0]);
	
	
	
	int menu_editor;
	
	do {
		menu_editor = JOptionPane.showOptionDialog(null,"Menú editor","¿Qué desea realizar?"
				,0,0,null,
				opciones_editor.values(),opciones_editor.values()[0]);
		
		switch (menu_editor) {
		case 0:
			Editor.VerPropuesta();
			break;

        case 1:
        	Editor.EstimacionGanancia(editor.getId_editor());
			break;
        case 2:
        	JOptionPane.showMessageDialog(null, "Saliendo");

	
	         break;
		}
	} while (menu_editor!=2);
	
	
}
	
}
