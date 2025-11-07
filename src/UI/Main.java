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
	Usuario.usuarios();
}


}
