package BLL;

import javax.swing.JOptionPane;

import dll.DTO_autor;
import dll.DTO_propuesta;
import repository.Validaciones;
import java.util.List;
import dll.DTO_estado_propuesta;
import repository.opciones_autor;

public class Autor extends Usuario{
	//atributos
	private int id_autor;
	private int fk_estado_propuesta;	
	private String biografia;
	private String redes_sociales;

	//constructores


	public Autor(int id_autor,String nombre, String apellido, String dni, String pass, String biografia,
			String redes_sociales,int fk_estado_propuesta,String nombre_usuario) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.biografia = biografia;
		this.redes_sociales = redes_sociales;
		this.id_autor = id_autor;
		this.fk_estado_propuesta = fk_estado_propuesta;

	}

	public Autor(String nombre, String apellido, String dni, String nombre_usuario, String pass, String biografia,
			String redes_sociales) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		this.biografia = biografia;
		this.redes_sociales = redes_sociales;


	}
	
	public Autor(String nombre, String apellido, String dni, String nombre_usuario, String pass) {
		super(nombre, apellido, dni, nombre_usuario, pass);
		


	}	
	
	
	

	//getters y setters
    public int getId_autor() {
        return id_autor;
    }
    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    public String getBiografia() {
        return biografia;
    }

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getRedes_sociales() {
		return redes_sociales;
	}

	public void setRedes_sociales(String redes_sociales) {
		this.redes_sociales = redes_sociales;
	}
	
	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public int getFk_estado_propuesta() {
		return fk_estado_propuesta;
	}

	public void setFk_estado_propuesta(int fk_estado_propuesta) {
		this.fk_estado_propuesta = fk_estado_propuesta;
	}
	

	//MÉTODOS
	


		//login_autor
		public static Autor Login_autor() {
			String nombre_usuario;
			String pass;

			nombre_usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
			pass = JOptionPane.showInputDialog("Ingrese su contraseña: ");

			if (nombre_usuario.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error al ingresar datos");
				return null;
			}else {

				return DTO_autor.login_dto(nombre_usuario, pass);

			}
		}
		
		//agregar autor
		public static boolean AgregarAutor() {
			String nombre = Validaciones.ValidarString("Ingrese nombre:");
			String apellido = Validaciones.ValidarString("Ingrese apellido:");
			String dni = Validaciones.ValidarString("Ingrese DNI:");
			String pass = Validaciones.ValidarString("Ingrese contraseña:");
			
			
			Autor nuevo = new Autor(nombre,apellido,dni,nombre_usuario,pass);
			
			return DTO_autor.agregarAutor_dto(nuevo);
		}
		
		//agregar propuesta
		public  static boolean AgregarPropuesta() {
			String nombre = Validaciones.ValidarString("Ingrese nombre de propuesta");
			int cantidad_capitulos;
			do {
				 cantidad_capitulos = Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad de capitulos")); 
			} while (cantidad_capitulos<=0);
			
			int cantidad_paginas ;
			do {
				 cantidad_paginas = Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad de paginas")); 
			} while (cantidad_paginas<=0);
			 
			String capitulo_piloto = Validaciones.ValidarString("ingrese su capitulo piloto");
			
			//int fk_autor;
			//do {
			 //fk_autor = Integer.parseInt(JOptionPane.showInputDialog("ingrese id de usuario " + "el suyo es: " + this.getId_autor()));
			 //if (fk_autor!=this.getId_autor()) {
				// JOptionPane.showMessageDialog(null, "id incorrecto,por favor ingrese su id " + "el suyo es: " + this.getId_autor());
				
			//}
			//} while (fk_autor!=this.getId_autor());

			int fk_autor = Integer.parseInt(JOptionPane.showInputDialog("ingrese id de usuario "));
			
			
			Propuesta nuevo = new Propuesta(nombre,cantidad_capitulos,cantidad_paginas,capitulo_piloto,fk_autor);
			
			return DTO_autor.agregar_propuesta_dto(nuevo);
		}
		
	
    public static void menu_autor(Autor autor) {
			
			
			//opciones_empleado elegido = (opciones_empleado)JOptionPane.showInputDialog(null,"",""
					//,0,null,
					//opciones_empleado.values(),opciones_empleado.values()[0]);
			
			
			int menu_autor;
			
			do {
				menu_autor = JOptionPane.showOptionDialog(null,"Menú autor","¿Qué desea realizar?"
						,0,0,null,
						opciones_autor.values(),opciones_autor.values()[0]);
				
				switch (menu_autor) {
				case 0:
					Autor.AgregarPropuesta();
		        case 1:
					Autor.CargarInfo();

                    break;

		        case 2:
		        	
		        	JOptionPane.showMessageDialog(null, "salir");

			
			         
			
		              break;


				
				}
			} while (menu_autor!=2);
		}	
	
		//cargar info
	public static boolean CargarInfo() {
		String biografia = Validaciones.ValidarString("Ingrese biografia");
		String redes_sociales = Validaciones.ValidarString("Ingrese rdes sociales");
		
		return DTO_autor.cargar_info_dto(biografia, redes_sociales);
		
	}
	public void EnviarPropuesta() {
		
	}
	public void VerEstadoPropuesta() {
		
	}
	@Override
	public String toString() {
		return "Autor [biografia=" + biografia + ", redes_sociales=" + redes_sociales + "]";
	}
	
	
}
