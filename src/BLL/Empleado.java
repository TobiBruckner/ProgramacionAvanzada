package BLL;

public class Empleado extends Usuario{
	//ATRIBUTOS
	private String sucursal;
	//CONSTRUCTOR
	public Empleado(String nombre, String apellido, int dNI, String mail, String contrasenia, String sucursal) {
		super(nombre, apellido, dNI, mail, contrasenia);
		this.sucursal = sucursal;
	}
	//GETTERS Y SETTERS
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	//MÉTODOS
	public String Login() {
		return "";
	}
	@Override
	public void Menu() {
		
	}
	public void VerInformacionLibro() {
		
	}
	public void ModificarPrecio() {
		
	}
	
}
