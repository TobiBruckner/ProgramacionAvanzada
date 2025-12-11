package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Autor;
import dll.DTO_autor;

public class autorloginJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpusuario;
	private JPasswordField inpPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				autorloginJFrame frame = new autorloginJFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public autorloginJFrame() {
		setTitle("Login Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setForeground(new Color(44, 62, 80));
		lblTitulo.setBounds(0, 40, 384, 40);
		contentPane.add(lblTitulo);
		
		JLabel lblSubtitulo = new JLabel("Portal de Autores");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		lblSubtitulo.setForeground(Color.GRAY);
		lblSubtitulo.setBounds(0, 80, 384, 20);
		contentPane.add(lblSubtitulo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(50, 140, 300, 20);
		contentPane.add(lblUsuario);
		
		inpusuario = new JTextField();
		inpusuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		inpusuario.setBounds(50, 165, 280, 35); 
		contentPane.add(inpusuario);
		inpusuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPass.setBounds(50, 220, 300, 20);
		contentPane.add(lblPass);
		
		inpPassword = new JPasswordField();
		inpPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		inpPassword.setBounds(50, 245, 280, 35);
		contentPane.add(inpPassword);
		
		JLabel lblerror = new JLabel("");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblerror.setForeground(new Color(231, 76, 60)); 
		lblerror.setBounds(50, 300, 280, 20);
		contentPane.add(lblerror);

		JButton btnLogin = new JButton("Ingresar");
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(46, 204, 113)); 
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBounds(50, 330, 280, 45); 
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = inpusuario.getText();
				String pass = new String(inpPassword.getPassword());
				Autor autor = DTO_autor.login_dto(usuario, pass);
				
				if (autor != null) {
					menuautorJFrame inicio = new menuautorJFrame(autor);
					inicio.setVisible(true);
					dispose();
				} else {
					lblerror.setText("Usuario o contraseña incorrectos");
				}
			}
		});
		contentPane.add(btnLogin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnVolver.setForeground(Color.GRAY);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBounds(140, 400, 100, 30);
		btnVolver.addActionListener(e -> {
			new autor_inicioJFrame().setVisible(true); 
			dispose();
		});
		contentPane.add(btnVolver);
	}
}