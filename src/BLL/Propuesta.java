package BLL;

import javax.swing.JOptionPane;

import dll.DTO_autor;
import dll.DTO_propuesta;
import repository.Validaciones;

public class Propuesta {
	//ATRIBUTOS
	private int idPropuesta;
	private String nombre_propuesta;
	private int cantidad_capitulos;
	private int cantidad_paginas;
	private String capitulo_piloto;
	private int idAutor;
	//CONSTRUCTOR
	public Propuesta(int idPropuesta, String nombre_propuesta, int cantidad_capitulos, int cantidad_paginas,
			String capitulo_piloto, int idAutor) {
		super();
		this.idPropuesta = idPropuesta;
		this.nombre_propuesta = nombre_propuesta;
		this.cantidad_capitulos = cantidad_capitulos;
		this.cantidad_paginas = cantidad_paginas;
		this.capitulo_piloto = capitulo_piloto;
		this.idAutor = idAutor;
	}
	public Propuesta(String nombre_propuesta, int cantidad_capitulos, int cantidad_paginas,
			String capitulo_piloto, int idAutor) {
		super();
		this.nombre_propuesta = nombre_propuesta;
		this.cantidad_capitulos = cantidad_capitulos;
		this.cantidad_paginas = cantidad_paginas;
		this.capitulo_piloto = capitulo_piloto;
		this.idAutor = idAutor;
	}
	
	//GETTERS Y SETTERS
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public String getNombre_propuesta() {
		return nombre_propuesta;
	}
	public void setNombre_propuesta(String nombre_propuesta) {
		this.nombre_propuesta = nombre_propuesta;
	}
	public int getCantidad_capitulos() {
		return cantidad_capitulos;
	}
	public void setCantidad_capitulos(int cantidad_capitulos) {
		this.cantidad_capitulos = cantidad_capitulos;
	}
	public int getCantidad_paginas() {
		return cantidad_paginas;
	}
	public void setCantidad_paginas(int cantidad_paginas) {
		this.cantidad_paginas = cantidad_paginas;
	}
	public String getCapitulo_piloto() {
		return capitulo_piloto;
	}
	public void setCapitulo_piloto(String capitulo_piloto) {
		this.capitulo_piloto = capitulo_piloto;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	
}
