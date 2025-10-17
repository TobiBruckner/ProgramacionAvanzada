package BLL;

public class Propuesta {
	//ATRIBUTOS
	private int idAutor;
	private int idEditor;
	private int idPropuesta;
	private String nombre;
	private int cantidad_paginas;
	private String capitulo_piloto;
	//CONSTRUCTOR
	public Propuesta(int idAutor, int idEditor, int idPropuesta, String nombre, int cantidad_paginas,
			String capitulo_piloto) {
		super();
		this.idAutor = idAutor;
		this.idEditor = idEditor;
		this.idPropuesta = idPropuesta;
		this.nombre = nombre;
		this.cantidad_paginas = cantidad_paginas;
		this.capitulo_piloto = capitulo_piloto;
	}
	//GETTERS Y SETTERS
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public int getIdEditor() {
		return idEditor;
	}
	public void setIdEditor(int idEditor) {
		this.idEditor = idEditor;
	}
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
