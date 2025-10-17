package BLL;


public class DetalleVenta {
	//ATRIBUTOS
	private int idVenta;
	private int cantidad;
	private int idLibro;
	//CONSTRUCTOR
	public DetalleVenta(int idVenta, int cantidad, int idLibro) {
		super();
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.idLibro = idLibro;
	}
	//GETTERS Y SETTERS
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
}
