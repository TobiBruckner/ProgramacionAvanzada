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

	//MÉTODOS
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
		
		public static boolean AgregarAutor() {
			String nombre = Validaciones.ValidarString("Ingrese nombre:");
			String apellido = Validaciones.ValidarString("Ingrese apellido:");
			String dni = Validaciones.ValidarString("Ingrese DNI:");
			String nombre_usuario = Validaciones.ValidarString("Ingrese nombre de usuario:");
			String pass = Validaciones.ValidarString("Ingrese contraseña:");
			String biografia = Validaciones.ValidarString("Ingrese biografía:");
			String redes_sociales = Validaciones.ValidarString("Ingrese redes sociales:");
			
			Autor nuevo = new Autor(nombre,apellido,dni,nombre_usuario,pass,biografia,redes_sociales);
			
			return DTO_autor.agregarAutor(nuevo);
		}
		
		public static boolean AgregarPropuesta() {
			String nombre = Validaciones.ValidarString("Ingrese nombre de propuesta");
			int cantidad_capitulos;
			do {
				cantidad_capitulos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de capitulos"));
				if (cantidad_capitulos<=0) {
					JOptionPane.showMessageDialog(null, "la cantidad de capitulos debe ser mayor 0");
				}
			} while (cantidad_capitulos<=0);
			
			int cantidad_paginas;
			do {
				cantidad_paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de paginas"));
				if (cantidad_paginas<=0) {
					JOptionPane.showMessageDialog(null, "la cantidad de paginas debe ser mayor 0");
				}
			} while (cantidad_paginas<=0);

			String capitulo_piloto = Validaciones.ValidarString("Ingrese su capitulo piloto");
			int fk_autor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id"));
			
			
			Propuesta nuevo = new Propuesta(nombre,cantidad_capitulos,cantidad_paginas,capitulo_piloto,fk_autor);
			
			return DTO_propuesta.agregar_propuesta(nuevo);
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
                    Autor.VerEstadoPropuesta(autor.getId_autor());

                    break;

		        case 2:
		        	JOptionPane.showMessageDialog(null, "Saliendo");
			
		              break;


				
				}
			} while (menu_autor!=2);
		}	
		
    public static void VerEstadoPropuesta(int idAutor) {
        List<String> estados = DTO_estado_propuesta.obtenerEstadosPorAutor(idAutor);
        if (estados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay propuestas registradas para este autor.");
            return;
        }
        StringBuilder sb = new StringBuilder("ESTADO DE TUS PROPUESTAS:\n\n");
        for (String e : estados) {
            sb.append(e).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Estados de Propuestas", JOptionPane.INFORMATION_MESSAGE);
    }
	@Override
	public String toString() {
		return "Autor [biografia=" + biografia + ", redes_sociales=" + redes_sociales + "]";
	}
	
	
}
