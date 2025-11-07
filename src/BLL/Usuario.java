package BLL;

import javax.swing.JOptionPane;

import repository.login_usuarios;
import repository.usuarios_tipos;

public class Usuario {
	//atributos	
	private String nombre;
	private String apellido;
	private String dni;
	private String nombre_usuario;
	private String pass;

	//constructor
	public Usuario(String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombre_usuario = nombre_usuario;
		this.pass = pass;
	}

	public Usuario(String nombre_usuario, String pass) {
		this.nombre_usuario = nombre_usuario;
		this.pass = pass;
	}

	//getters y setters
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	//MÉTODOS
	public String Login() {
		return "";
	}
	public void Menu() {
		
	}
	
	//funciones
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", nombre_usuario="
				+ nombre_usuario + ", pass=" + pass + "]";
	}
	
	public static void usuarios() {
		
		int menu_usuario;	
		do {
		menu_usuario = JOptionPane.showOptionDialog(null, "Bienvenido a la librería Yenny, elija que tipo de usuario es:", null, 0, 0, null, usuarios_tipos.values(), usuarios_tipos.values()[0]);
		switch (menu_usuario) {
		case 0:
			login(usuarios_tipos.empleado);
			break;

		case 1:
			login(usuarios_tipos.editor);
			break;
			
		case 2:
			login(usuarios_tipos.autor);
			break;
			
		case 3:
			JOptionPane.showMessageDialog(null, "Salir");
		}
		} while (menu_usuario!=3);	

			
			
			
		}
	
	public static void login(usuarios_tipos tipo) {

		int login;	
		do {

			login = JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "", 0, 0, null, login_usuarios.values(), login_usuarios.values()[0]);	
			switch (login) {


			case 0:
				switch (tipo) {
					case empleado:
						Empleado empleado = Empleado.Login_empleado();
						if(empleado != null) {
							JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
							Empleado.menu_empleado(empleado);
						}else {
							JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
						}
						break;
					case editor:
						Editor editor = Editor.Login_editor();
						if(editor != null) {
							JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
							Editor.menu_editor(editor);
						}else {
							JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
						}
						break;
		            case autor:
		                Autor autor = Autor.Login_autor();
		                if(autor != null) {
		                    JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
		                    Autor.menu_autor(autor);
		                }else {
		                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
		                }
		                break;
					default:
						JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario válido.");
						break;
				}

				break;
			case 1:
				boolean agregado = false;
				switch (tipo) {
					case empleado:
						agregado = Empleado.AgregarEmpleado();
						JOptionPane.showMessageDialog(null, agregado ? "Agregado correctamente" : "No se pudo agregar");
						
						break;
					case editor:
						agregado = Editor.AgregarEditor();
						JOptionPane.showMessageDialog(null, agregado ? "Agregado correctamente" : "No se pudo agregar");
						
						break;
					case autor:
						agregado = Autor.AgregarAutor();
						JOptionPane.showMessageDialog(null, agregado ? "Agregado correctamente" : "No se pudo agregar");
						
						break;
					default:
						JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario válido.");
						break;
				}
				

				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Saliendo");
				

				break;

			}		
		} while (login!=2);	

			
			
		}

}
