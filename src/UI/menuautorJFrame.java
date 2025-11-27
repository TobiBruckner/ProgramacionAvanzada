package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Autor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuautorJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Autor autorActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuautorJFrame frame = new menuautorJFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuautorJFrame(Autor autor) {
		
		this.autorActual = autor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("menu autor");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(219, 29, 109, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnagregarpropuesta = new JButton("agregar propuesta");
		btnagregarpropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (autorActual != null) {
					
					new AgregarPropuestaJFrames(autorActual);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Debe iniciar sesión como Autor para agregar una propuesta.", "Error de Sesión", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnagregarpropuesta.setBounds(65, 201, 156, 23);
		contentPane.add(btnagregarpropuesta);
		
		JButton btnVerestadopropuesta = new JButton("ver_estado_propuesta");
		btnVerestadopropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (autorActual != null) {
					
					new VerEstadoPropuestaJFrame(autorActual).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Debe iniciar sesión como Autor para ver el estado de las propuestas.", "Error de Sesión", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnVerestadopropuesta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVerestadopropuesta.setBounds(263, 201, 156, 23);
		contentPane.add(btnVerestadopropuesta);
		
		JButton btnsalir = new JButton("salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsalir.setBounds(202, 255, 89, 23);
		contentPane.add(btnsalir);

	}

}
