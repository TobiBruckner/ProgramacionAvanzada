package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Empleado;
import dll.DTO_autor;
import dll.DTO_empleado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class empleadoregistroJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpnombre;
	private JTextField inpapellido;
	private JTextField inpdni;
	private JTextField inpnombreusuario;
	private JPasswordField inppass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empleadoregistroJFrame frame = new empleadoregistroJFrame();
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
	public empleadoregistroJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroEmpleado = new JLabel("registro empleado");
		lblRegistroEmpleado.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblRegistroEmpleado.setBounds(154, 0, 132, 25);
		contentPane.add(lblRegistroEmpleado);
		
		JLabel lblNewLabel_1 = new JLabel("nombre");
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpnombre = new JTextField();
		inpnombre.setColumns(10);
		inpnombre.setBounds(10, 98, 86, 20);
		contentPane.add(inpnombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("apellido");
		lblNewLabel_1_1.setBounds(10, 139, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		inpapellido = new JTextField();
		inpapellido.setColumns(10);
		inpapellido.setBounds(10, 164, 86, 20);
		contentPane.add(inpapellido);
		
		JLabel lblNewLabel_1_2 = new JLabel("dni");
		lblNewLabel_1_2.setBounds(10, 214, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		inpdni = new JTextField();
		inpdni.setColumns(10);
		inpdni.setBounds(10, 239, 86, 20);
		contentPane.add(inpdni);
		
		JLabel lblNewLabel_1_3 = new JLabel("nombre_usuario");
		lblNewLabel_1_3.setBounds(10, 290, 86, 14);
		contentPane.add(lblNewLabel_1_3);
		
		inpnombreusuario = new JTextField();
		inpnombreusuario.setColumns(10);
		inpnombreusuario.setBounds(10, 315, 86, 20);
		contentPane.add(inpnombreusuario);
		
		JLabel lblNewLabel_1_4 = new JLabel("contaseña");
		lblNewLabel_1_4.setBounds(10, 368, 86, 14);
		contentPane.add(lblNewLabel_1_4);
		
		inppass = new JPasswordField();
		inppass.setBounds(10, 393, 86, 20);
		contentPane.add(inppass);
		
		JLabel lblerror = new JLabel("");
		lblerror.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(10, 456, 322, 14);
		contentPane.add(lblerror);

		
		JButton btnregistro = new JButton("registro");
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = inpnombre.getText().trim();
				String apellido = inpapellido.getText().trim();
				String dni = inpdni.getText().trim();
				String nombre_usuario = inpnombreusuario.getText().trim();
				String pass = new String(inppass.getPassword()).trim();
				

				if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || nombre_usuario.isEmpty() || pass.isEmpty()) {
					lblerror.setText("Debe completar todos los campos.");
					return; 
				}
				lblerror.setText("");
				
				
				Empleado empleado = new Empleado(nombre,apellido,dni,nombre_usuario,pass);
				boolean ok = DTO_empleado.agregarEmpleado(empleado);
				if (ok) {
					empleadologinJFrame nuevo = new empleadologinJFrame();
					nuevo.setVisible(true);
					dispose();					
				} else {
					
					lblerror.setText("error al ingresar");

				}
			}
		});
		btnregistro.setBounds(7, 480, 89, 23);
		contentPane.add(btnregistro);
		
		

	}

}
