package BLL;

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


@Override
public String toString() {
	return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", nombre_usuario="
			+ nombre_usuario + ", pass=" + pass + "]";
}




}
