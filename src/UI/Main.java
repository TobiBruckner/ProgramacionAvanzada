package UI;
import javax.swing.JOptionPane;

import BLL.Autor;
import BLL.Editor;
import BLL.Empleado;
import dll.Conexion;
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
		menu_empleado = JOptionPane.showOptionDialog(null,"menu empleado",""
				,0,0,null,
				opciones_empleado.values(),opciones_empleado.values()[0]);
		switch (menu_empleado) {
		case 0:
			JOptionPane.showMessageDialog(null, "ver informacion de libro");

			break;
			
        case 1:
			JOptionPane.showInputDialog("cambiar precio de libro");
			break;
			
        case 2:
	JOptionPane.showMessageDialog(null, "salir");
	break;

		
		}
	} while (menu_empleado!=2);
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
public static void menu_editor() {
	
	
	//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
			//,0,null,
			//opciones_empleado.values(),opciones_empleado.values()[0]);
	
	
	
	int menu_editor;
	
	do {
		menu_editor = JOptionPane.showOptionDialog(null,"",""
				,0,0,null,
				opciones_editor.values(),opciones_editor.values()[0]);
		
		switch (menu_editor) {
		case 0:
			JOptionPane.showMessageDialog(null, "ver_propuestas");
			break;

        case 1:
        	JOptionPane.showInputDialog("proyectar estimacion de ganancia");

			break;
        case 2:
        	JOptionPane.showMessageDialog(null, "saliendo");

	
	         break;
		}
	} while (menu_editor!=2);
	
	
}

public static void login(usuarios_tipos tipo) {

int login;	
do {

	login = JOptionPane.showOptionDialog(null, "que desea realizar", "", 0, 0, null, login_usuarios.values(), login_usuarios.values()[0]);	
	switch (login) {


	case 0:
		String usuario = JOptionPane.showInputDialog("ingrese su nombre de usuario");
		String pass = JOptionPane.showInputDialog("ingrese su contraseña");
		
		if (usuario.equals("empleado") && pass.equals("1234")) {
			menu_empleado();
			
		}else if (usuario.equals("autor") && pass.equals("1234")) {
			menu_autor();
		}else if (usuario.equals("editor") && pass.equals("1234")) {
			menu_editor();
		}

		break;
	case 1:
		boolean agregado = false;
		switch (tipo) {
			case empleado:
				agregado = Empleado.AgregarEmpleado();
				break;
			case editor:
				agregado = Editor.AgregarEditor();
				break;
			case autor:
				agregado = Autor.AgregarAutor();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario válido.");
				break;
		}
		JOptionPane.showMessageDialog(null, agregado ? "Agregado correctamente" : "No se pudo agregar");

		break;
	case 2:
		JOptionPane.showMessageDialog(null, "saliendo");
		

		break;

	}		
} while (login!=2);	

	
	
}

public static void usuarios() {
	
int menu_usuario;	
do {
menu_usuario = JOptionPane.showOptionDialog(null, "bienvenido a la libreria yenny, elija que tipo de usuario es:", null, 0, 0, null, usuarios_tipos.values(), usuarios_tipos.values()[0]);
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
