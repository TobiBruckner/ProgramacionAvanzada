
public class EstadoPropuesta {
	//ATRIBUTOS
	private String estado;
	private double estimacion_ganancia;
	private int idPropuesta;
	//CONSTRUCTOR
	public EstadoPropuesta(String estado, double estimacion_ganancia, int idPropuesta) {
		super();
		this.estado = estado;
		this.estimacion_ganancia = estimacion_ganancia;
		this.idPropuesta = idPropuesta;
	}
	//GETTERS Y SETTERS
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getEstimacion_ganancia() {
		return estimacion_ganancia;
	}
	public void setEstimacion_ganancia(double estimacion_ganancia) {
		this.estimacion_ganancia = estimacion_ganancia;
	}
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	
}
