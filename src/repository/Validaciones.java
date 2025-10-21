package repository;

import javax.swing.JOptionPane;

public interface Validaciones {

			static String ValidarString(String mensaje) {
				
				String dato;
				do {
					dato = JOptionPane.showInputDialog(mensaje);
					if (dato.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error al ingresar.");
					}
				} while (dato.isEmpty());
				return dato;
				
				
			}
			
            static int ValidarInt(String mensaje) {
				
				int dato;
				do {
					dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
					if (dato <= 0) {
						JOptionPane.showMessageDialog(null, "Error al ingresar.");
					}
				} while (dato <= 0);
				return dato;
				
				
			}

}
