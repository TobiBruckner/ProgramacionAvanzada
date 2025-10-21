package BLL;

public class DetalleVenta {
	//ATRIBUTOS
	private int idVenta;
	private int cantidad;
	private int id_detalle_venta;
	private int cantidad_vendida;
	private int idLibro;
	private int fk_venta;
	private int fk_libro;
	


	//CONSTRUCTOR
	public DetalleVenta(int id_detalle_venta, int cantidad_vendida, int idLibro, int fk_venta, int fk_libro) {
		super();
		this.id_detalle_venta = id_detalle_venta;
		this.cantidad_vendida = cantidad_vendida;
		this.idLibro = idLibro;
		this.fk_venta = fk_venta;
		this.fk_libro = fk_libro;
	}
	public DetalleVenta(int cantidad_vendida, int idLibro) {
		super();
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.cantidad_vendida = cantidad_vendida;
		this.idLibro = idLibro;
		
	}
	//GETTERS Y SETTERS



	public int getId_detalle_venta() {
		return id_detalle_venta;
	}



	public int getId_detalle_venta() {
		return id_detalle_venta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}



	public void setId_detalle_venta(int id_detalle_venta) {
		this.id_detalle_venta = id_detalle_venta;
	}
	public int getCantidad() {
		return cantidad;
	}



	public int getCantidad_vendida() {
		return cantidad_vendida;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public void setCantidad_vendida(int cantidad_vendida) {
		this.cantidad_vendida = cantidad_vendida;
	}



	public int getIdLibro() {
		return idLibro;
	}



	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}



	public int getFk_venta() {
		return fk_venta;
	}



	public void setFk_venta(int fk_venta) {
		this.fk_venta = fk_venta;
	}



	public int getFk_libro() {
		return fk_libro;
	}



	public void setFk_libro(int fk_libro) {
		this.fk_libro = fk_libro;
	}

	

}
