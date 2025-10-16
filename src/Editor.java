
public class Editor extends Usuario{
	//ATRIBUTOS
	private int idEditor;
	private String especialidad;
	//CONSTRUCTOR
	public Editor(String nombre, String apellido, int dNI, String nombre_usuario, String contrasenia, int idEditor,
			String especialidad) {
		super(nombre, apellido, dNI, nombre_usuario, contrasenia);
		this.idEditor = idEditor;
		this.especialidad = especialidad;
	}
	//GETTERS Y SETTERS
	public int getIdEditor() {
		return idEditor;
	}
	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	//MÉTODOS
	public String Login() {
		return "";
	}
	@Override
	public void Menu() {
		
	}
	@Override
	public void Registrarse() {
		
	}
	public void VerPropuesta() {
		
	}
	public void EstimacionGanancia() {
		
	}
	
}
