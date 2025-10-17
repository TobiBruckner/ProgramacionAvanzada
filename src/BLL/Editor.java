package BLL;

public class Editor extends Usuario{

//constructor	
public Editor(String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
}


@Override
public String toString() {
	return "Editor [getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + ", getDni()=" + getDni()
			+ ", getNombre_usuario()=" + getNombre_usuario() + ", getPass()=" + getPass() + ", toString()="
			+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}

	
}
