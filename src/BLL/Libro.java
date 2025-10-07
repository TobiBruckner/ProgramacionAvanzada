package BLL;

public class Libro {
	//ATRIBUTOS
	private int idLibro;
	private String nombre;
	private double precio;
	private int stock;
	private String genero;
	//CONSTRUCTOR
	public Libro(int idLibro, String nombre, double precio, int stock, String genero) {
		super();
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
	}
	//GETTERS Y SETTERS
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
