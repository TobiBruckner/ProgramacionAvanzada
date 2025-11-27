package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Autor;
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

public class empleadologinJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpusuario;
	private JPasswordField inppass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empleadologinJFrame frame = new empleadologinJFrame();
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
	public empleadologinJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginEmpleado = new JLabel("login empleado");
		lblLoginEmpleado.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblLoginEmpleado.setBounds(31, 24, 109, 44);
		contentPane.add(lblLoginEmpleado);
		
		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 179, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		inpusuario = new JTextField();
		inpusuario.setColumns(10);
		inpusuario.setBounds(31, 204, 86, 20);
		contentPane.add(inpusuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("contaseña");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(31, 267, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		inppass = new JPasswordField();
		inppass.setBounds(31, 302, 86, 20);
		contentPane.add(inppass);
		
		JLabel lblerror = new JLabel("");
		lblerror.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(31, 344, 264, 14);
		contentPane.add(lblerror);
		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = inpusuario.getText();
				String pass = inppass.getText();
				Empleado empleado = DTO_empleado.login_dto(usuario, pass);
				
				if (empleado!=null) {
					
					menuempleadoJFrame inicio = new menuempleadoJFrame(empleado);
					inicio.setVisible(true);
					dispose();
					
				} else {
					lblerror.setText("error al ingresar");
				}
			}
		});
		btnlogin.setBounds(31, 369, 89, 23);
		contentPane.add(btnlogin);
		
		

	}

}
