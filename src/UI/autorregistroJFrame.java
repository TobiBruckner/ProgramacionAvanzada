package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BLL.Autor;
import dll.DTO_autor;

import java.awt.Color;

public class autorregistroJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpnombre;
	private JTextField inpapellido;
	private JTextField inpdni;
	private JTextField inpnombreusuario;
	private JTextField inpbiografia;
	private JTextField inpredes;
	private JPasswordField inppass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autorregistroJFrame frame = new autorregistroJFrame();
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
	public autorregistroJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("registro autor");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(173, 28, 132, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("nombre");
		lblNewLabel_1.setBounds(29, 101, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpnombre = new JTextField();
		inpnombre.setBounds(29, 126, 86, 20);
		contentPane.add(inpnombre);
		inpnombre.setColumns(10);
		
		inpapellido = new JTextField();
		inpapellido.setColumns(10);
		inpapellido.setBounds(29, 192, 86, 20);
		contentPane.add(inpapellido);
		
		JLabel lblNewLabel_1_1 = new JLabel("apellido");
		lblNewLabel_1_1.setBounds(29, 167, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		inpdni = new JTextField();
		inpdni.setColumns(10);
		inpdni.setBounds(29, 267, 86, 20);
		contentPane.add(inpdni);
		
		JLabel lblNewLabel_1_2 = new JLabel("dni");
		lblNewLabel_1_2.setBounds(29, 242, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		inpnombreusuario = new JTextField();
		inpnombreusuario.setColumns(10);
		inpnombreusuario.setBounds(29, 343, 86, 20);
		contentPane.add(inpnombreusuario);
		
		JLabel lblNewLabel_1_3 = new JLabel("nombre_usuario");
		lblNewLabel_1_3.setBounds(29, 318, 86, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("contaseña");
		lblNewLabel_1_4.setBounds(29, 396, 86, 14);
		contentPane.add(lblNewLabel_1_4);
		
		inpbiografia = new JTextField();
		inpbiografia.setColumns(10);
		inpbiografia.setBounds(29, 477, 86, 20);
		contentPane.add(inpbiografia);
		
		JLabel lblNewLabel_1_5 = new JLabel("biografia");
		lblNewLabel_1_5.setBounds(29, 452, 46, 14);
		contentPane.add(lblNewLabel_1_5);
		
		inpredes = new JTextField();
		inpredes.setColumns(10);
		inpredes.setBounds(29, 548, 86, 20);
		contentPane.add(inpredes);
		
		JLabel lblNewLabel_1_6 = new JLabel("redes sociales");
		lblNewLabel_1_6.setBounds(29, 523, 102, 14);
		contentPane.add(lblNewLabel_1_6);
		
		inppass = new JPasswordField();
		inppass.setBounds(29, 421, 86, 20);
		contentPane.add(inppass);
		
		JLabel lblerror = new JLabel("");
		lblerror.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(29, 599, 383, 14);
		contentPane.add(lblerror);
		
		JButton btnregistro = new JButton("registro");
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = inpnombre.getText().trim();
				String apellido = inpapellido.getText().trim();
				String dni = inpdni.getText().trim();
				String nombre_usuario = inpnombreusuario.getText().trim();
				String pass = new String(inppass.getPassword()).trim();
				String biografia = inpbiografia.getText().trim();
				String redes_sociales = inpredes.getText().trim();
				
				if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || nombre_usuario.isEmpty() || pass.isEmpty() || biografia.isEmpty() || redes_sociales.isEmpty()) {
					lblerror.setText("Debe completar todos los campos.");
					return; 
				}
				lblerror.setText("");
				
				
				Autor autor = new Autor(nombre,apellido,dni,nombre_usuario,pass,biografia,redes_sociales);
				boolean ok = DTO_autor.agregarAutor_dto(autor);
				if (ok) {
					autorloginJFrame nuevo = new autorloginJFrame();
					nuevo.setVisible(true);
					dispose();					
				} else {
					
					lblerror.setText("error al ingresar");

				}
			}
		});
		btnregistro.setBounds(29, 624, 89, 23);
		contentPane.add(btnregistro);
		
		

	}

}
