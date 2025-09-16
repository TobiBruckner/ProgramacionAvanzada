
public class Autor extends Usuario{
	//ATRIBUTOS
	private int idAutor;
	private String red_social;
	//CONSTRUCTOR
	
	//GETTERS Y SETTERS
	public int getIdAutor() {
		return idAutor;
	}
	public Autor(String nombre, String apellido, int dNI, String mail, String contrasenia, int idAutor,
			String red_social) {
		super(nombre, apellido, dNI, mail, contrasenia);
		this.idAutor = idAutor;
		this.red_social = red_social;
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
	public String Login() {
		return "";
		
	}
	@Override
	public void Menu() {
		
	}
	public void CargarInfo() {
		
	}
	public void EnviarPropuesta() {
		
	}
	public void VerEstadoPropuesta() {
		
	}
	
	
}
