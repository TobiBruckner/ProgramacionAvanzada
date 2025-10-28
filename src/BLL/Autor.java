package BLL;

import javax.swing.JOptionPane;

import dll.DTO_autor;
import repository.Validaciones;
import repository.opciones_autor;

public class Autor extends Usuario{
	//atributos
	private int id_autor;
	private int fk_estado_propuesta;	
	private String biografia;
	private String redes_sociales;

	//constructores


	public Autor(String nombre, String apellido, String dni, String nombre_usuario, String pass, String biografia,
			String redes_sociales,int id_autor,int fk_estado_propuesta) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.biografia = biografia;
		this.redes_sociales = redes_sociales;
		this.id_autor = id_autor;
		this.fk_estado_propuesta = fk_estado_propuesta;

	}

	public Autor(String nombre, String apellido, String dni, String nombre_usuario, String pass, String biografia,
			String redes_sociales) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.biografia = biografia;
		this.redes_sociales = redes_sociales;


	}

	public Autor(int id_autor, String apellido, String dni, String nombre_usuario, String pass, String nombre) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.id_autor = id_autor;
	}

	//getters y setters
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getRedes_sociales() {
		return redes_sociales;
	}

	public void setRedes_sociales(String redes_sociales) {
		this.redes_sociales = redes_sociales;
	}

	//MÉTODOS
		public static Autor Login_autor() {
			String nombre_usuario;
			String pass;

			nombre_usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
			pass = JOptionPane.showInputDialog("Ingrese su contraseña: ");

			if (nombre_usuario.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error al ingresar datos");
				return null;
			}else {

				return DTO_autor.login_dto(nombre_usuario, pass);

			}
		}
		
		public static boolean AgregarAutor() {
			String nombre = Validaciones.ValidarString("Ingrese nombre:");
			String apellido = Validaciones.ValidarString("Ingrese apellido:");
			String dni = Validaciones.ValidarString("Ingrese DNI:");
			String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
			String pass = Validaciones.ValidarString("Ingrese contraseña:");
			String biografia = Validaciones.ValidarString("Ingrese biografía:");
			String redes_sociales = Validaciones.ValidarString("Ingrese redes sociales:");
			
			Autor nuevo = new Autor(nombre,apellido,dni,nombre_usuario,pass,biografia,redes_sociales);
			
			return DTO_autor.agregarAutor(nuevo);
		}
		
	public void CargarInfo() {
		
	}
	public void EnviarPropuesta() {
		
	}
	public void VerEstadoPropuesta() {
		
	}
	@Override
	public String toString() {
		return "Autor [biografia=" + biografia + ", redes_sociales=" + redes_sociales + "]";
	}
	
	
}
