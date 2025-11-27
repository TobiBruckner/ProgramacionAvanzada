package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BLL.Autor;
import dll.DTO_autor;
import java.awt.Color;

public class autorloginJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpusuario;
	private JPasswordField inpPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autorloginJFrame frame = new autorloginJFrame();
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
	public autorloginJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login autor");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 38, 109, 44);
		contentPane.add(lblNewLabel);
		
		inpusuario = new JTextField();
		inpusuario.setBounds(59, 218, 86, 20);
		contentPane.add(inpusuario);
		inpusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(59, 193, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("contaseña");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(59, 281, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		inpPassword = new JPasswordField();
		inpPassword.setBounds(59, 316, 86, 20);
		contentPane.add(inpPassword);
		
		JLabel lblerror = new JLabel("");
		lblerror.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(59, 358, 193, 14);
		contentPane.add(lblerror);

		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = inpusuario.getText();
				String pass = inpPassword.getText();
				Autor autor = DTO_autor.login_dto(usuario, pass);
				
				if (autor!=null) {
					
					menuautorJFrame inicio = new menuautorJFrame(autor);
					inicio.setVisible(true);
					dispose();
					
				} else {
					lblerror.setText("error al ingresar");
				}
			
			
			}
		});
		btnlogin.setBounds(59, 383, 89, 23);
		contentPane.add(btnlogin);
		
		

	}
}
