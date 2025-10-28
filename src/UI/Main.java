package UI;
import javax.swing.JOptionPane;

import BLL.Autor;
import BLL.Editor;
import BLL.Empleado;
import BLL.Usuario;
import dll.Conexion;
import dll.DTO_empleado;
import repository.login_usuarios;
import repository.usuarios_tipos;
import repository.opciones_autor;
import repository.opciones_editor;
import repository.opciones_empleado;


public class Main {
public static void main(String[] args) {
	Conexion.getInstance();
	usuarios();
}

public static void menu_empleado() {
	
	
	//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
			//,0,null,
			//opciones_empleado.values(),opciones_empleado.values()[0]);
	
	
	int menu_empleado;
	
	do {
		menu_empleado = JOptionPane.showOptionDialog(null,"Menú empleado","¿Qué desea realizar?"
				,0,0,null,
				opciones_empleado.values(),opciones_empleado.values()[0]);
		switch (menu_empleado) {
		case 0:
			JOptionPane.showMessageDialog(null, "Ver información de libro");

			break;
			
        case 1:
			JOptionPane.showInputDialog("Cambiar precio de libro");
			break;
			
        case 2:
	JOptionPane.showMessageDialog(null, "Salir");
	break;

		
		}
	} while (menu_empleado!=2);
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
					menu_empleado();
				}else {
					JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
				}
				break;
			case editor:
				Editor editor = Editor.Login_editor();
				if(editor != null) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
					menu_editor(editor);
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

}
