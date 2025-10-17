package BLL;

public class Libro {
	//ATRIBUTOS
	private int id_libro;
	private String nombre_libro;
	private String autor_libro;
	private String precio_libro;
	private int stock;
	private String popularidad;
	
	//CONSTRUCTOR
public Libro(int id_libro, String nombre_libro, String autor_libro, String precio_libro, int stock,
	        String popularidad) {
		super();
		this.id_libro = id_libro;
		this.nombre_libro = nombre_libro;
		this.autor_libro = autor_libro;
		this.precio_libro = precio_libro;
		this.stock = stock;
		this.popularidad = popularidad;
	}


//GETTERS Y SETTERS

public int getId_libro() {
	return id_libro;
}

public void setId_libro(int id_libro) {
	this.id_libro = id_libro;
}

public String getNombre_libro() {
	return nombre_libro;
}

public void setNombre_libro(String nombre_libro) {
	this.nombre_libro = nombre_libro;
}

public String getAutor_libro() {
	return autor_libro;
}

public void setAutor_libro(String autor_libro) {
	this.autor_libro = autor_libro;
}

public String getPrecio_libro() {
	return precio_libro;
}

public void setPrecio_libro(String precio_libro) {
	this.precio_libro = precio_libro;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public String getPopularidad() {
	return popularidad;
}

public void setPopularidad(String popularidad) {
	this.popularidad = popularidad;
}

	



}
