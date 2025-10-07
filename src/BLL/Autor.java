package BLL;

import javax.swing.JOptionPane;

import DLL.DTO_autor;
import REPOSITORY.opciones_autor;


public class Autor extends Usuario{
	//ATRIBUTOS
	private int idAutor;
	private String red_social;
	private String biografia;
	//CONSTRUCTOR
	public Autor(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, int idAutor,
			String red_social,String biografia) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.idAutor = idAutor;
		this.red_social = red_social;
	}
	
	public Autor(int idAutor,String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia) {
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
	//MÉTODOS
	public static Autor Login_autor() {
		String nombre_usuario;
		String pass;
		
		nombre_usuario = JOptionPane.showInputDialog("ingrese su nombre_usuario");
		pass = JOptionPane.showInputDialog("ingrese su contraseña");
		
		if (nombre_usuario.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error al ingresar datos");
			return null;
		}else {
			
			return DTO_autor.login_dto(nombre_usuario, pass);
			
		}
		
		
		
		
	}
	
	public static void menu_autor() {
		
		
		//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
				//,0,null,
				//opciones_empleado.values(),opciones_empleado.values()[0]);
		
		
		int menu_autor;
		
		do {
			menu_autor = JOptionPane.showOptionDialog(null,"menu autor",""
					,0,0,null,
					opciones_autor.values(),opciones_autor.values()[0]);
			
			switch (menu_autor) {
			case 0:
				JOptionPane.showInputDialog("enviar propuesta");
				break;
	        case 1:
				JOptionPane.showInputDialog("cargar informacion");

				break;

	        case 2:
	        	
	            JOptionPane.showMessageDialog(null, "ver estado de propuesta");
		
		         break;
	        case 3:
	        	JOptionPane.showMessageDialog(null, "saliendo");
		
	              break;


			
			}
		} while (menu_autor!=3);
	}

	
	
	
	
}
