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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class empleadoinicioJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				empleadoinicioJFrame frame = new empleadoinicioJFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public empleadoinicioJFrame() {
		setTitle("Portal de Empleado - Librería Yenny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400); 
		setLocationRelativeTo(null);  
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("PORTAL DE EMPLEADO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(44, 62, 80)); 
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTitulo.setBounds(0, 40, 434, 40);
		contentPane.add(lblTitulo);
		
		
		JLabel lblSubtitulo = new JLabel("Administración y Ventas");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(Color.GRAY);
		lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSubtitulo.setBounds(0, 80, 434, 20);
		contentPane.add(lblSubtitulo);
		
		
		JButton btnLogin = new JButton("Iniciar Sesión");
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(52, 152, 219)); 
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBounds(115, 140, 200, 45);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadologinJFrame inicio = new empleadologinJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnLogin);
		
		
		JButton btnRegistro = new JButton("Registrar Empleado");
		btnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setBackground(new Color(46, 204, 113)); 
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setBounds(115, 200, 200, 45);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadoregistroJFrame inicio = new empleadoregistroJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistro);
		
		
		JButton btnVolver = new JButton("Volver al Menú");
		btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnVolver.setForeground(new Color(127, 140, 141)); 
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setFocusPainted(false);
		btnVolver.setBounds(115, 280, 200, 30);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new index().setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVolver);
	}
}