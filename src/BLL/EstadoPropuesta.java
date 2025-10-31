package BLL;

public class EstadoPropuesta {
	//ATRIBUTOS
	private int id_estado_propuesta;
	private String estado_propuesta;
	private double estimacion_ganancia;
	private int fk_propuesta;
	private int fk_editor;
	
	//CONSTRUCTORES
	public EstadoPropuesta(String estado_propuesta, double estimacion_ganancia, int fk_propuesta, int fk_editor) {
		this.estado_propuesta = estado_propuesta;
		this.estimacion_ganancia = estimacion_ganancia;
		this.fk_propuesta = fk_propuesta;
		this.fk_editor = fk_editor;
	}
	
	public EstadoPropuesta(int id_estado_propuesta, String estado_propuesta, double estimacion_ganancia, int fk_propuesta, int fk_editor) {
		this.id_estado_propuesta = id_estado_propuesta;
		this.estado_propuesta = estado_propuesta;
		this.estimacion_ganancia = estimacion_ganancia;
		this.fk_propuesta = fk_propuesta;
		this.fk_editor = fk_editor;
	}
	//GETTERS Y SETTERS
	public int getId_estado_propuesta() {
		return id_estado_propuesta;
	}
	public void setId_estado_propuesta(int id_estado_propuesta) {
		this.id_estado_propuesta = id_estado_propuesta;
	}
	public String getEstado_propuesta() {
		return estado_propuesta;
	}
	public void setEstado_propuesta(String estado_propuesta) {
		this.estado_propuesta = estado_propuesta;
	}
	public double getEstimacion_ganancia() {
		return estimacion_ganancia;
	}
	public void setEstimacion_ganancia(double estimacion_ganancia) {
		this.estimacion_ganancia = estimacion_ganancia;
	}
	public int getFk_propuesta() {
		return fk_propuesta;
	}
	public void setFk_propuesta(int fk_propuesta) {
		this.fk_propuesta = fk_propuesta;
	}
	public int getFk_editor() {
		return fk_editor;
	}
	public void setFk_editor(int fk_editor) {
		this.fk_editor = fk_editor;
	}
	
}
