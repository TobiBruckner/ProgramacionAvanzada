package BLL;

import java.util.LinkedList;

import dll.DTO_libro;
import repository.Validaciones;

public class Libro {
	//ATRIBUTOS
	private int id_libro;
	private String nombre_libro;
	private String autor_libro;
	private double precio_libro;
	private int stock;
	private String popularidad;
	//CONSTRUCTOR
	public Libro(int id_libro, String nombre_libro, String autor_libro, double precio_libro, int stock,
			String popularidad) {
		super();
		this.id_libro = id_libro;
		this.nombre_libro = nombre_libro;
		this.autor_libro = autor_libro;
		this.precio_libro = precio_libro;
		this.stock = stock;
		this.popularidad = popularidad;
	}
	public Libro(String nombre_libro, String autor_libro, double precio_libro, int stock, String popularidad) {
		super();
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
	public double getPrecio_libro() {
		return precio_libro;
	}
	public void setPrecio_libro(double precio_libro) {
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
	
	//MÉTODOS
	public static boolean AgregarLibro() {
		String nombre = Validaciones.ValidarString("Ingrese nombre del libro:");
		String autor = Validaciones.ValidarString("Ingrese nombre del autor:");
		double precio = Double.parseDouble(Validaciones.ValidarString("Ingrese precio del libro:"));
		int stock = Validaciones.ValidarInt("Ingrese stock del libro:");
		String popularidad = Validaciones.ValidarString("Ingrese la popularidad del libro:");

		Libro nuevo = new Libro(nombre, autor, precio, stock, popularidad);
		
		return DTO_libro.agregarLibro(nuevo);
	}
	
public static LinkedList<Libro> mostrarLibros() {
		
		return DTO_libro.mostrarLibros();
		
	}
	
	
}
