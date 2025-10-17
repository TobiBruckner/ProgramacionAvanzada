package BLL;
import java.time.LocalDate;

public class Venta {
	//ATRIBUTOS
	private int idVenta;
	private LocalDate fecha;
	private double total;
	//CONSTRUCTOR
	public Venta(int idVenta, LocalDate fecha, double total) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.total = total;
	}
	//GETTERS Y SETTERS
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
