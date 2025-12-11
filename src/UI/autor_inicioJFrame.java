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

public class autor_inicioJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				autor_inicioJFrame frame = new autor_inicioJFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public autor_inicioJFrame() {
		setTitle("Portal de Autor - Librería Yenny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400); 
		setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("PORTAL DE AUTOR");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(44, 62, 80)); 
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTitulo.setBounds(0, 40, 434, 40);
		contentPane.add(lblTitulo);
		
		
		JLabel lblSubtitulo = new JLabel("Gestione sus propuestas y obras");
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
				autorloginJFrame inicio = new autorloginJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnLogin);
		
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setBackground(new Color(46, 204, 113)); 
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setBounds(115, 200, 200, 45);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autorregistroJFrame nuevo = new autorregistroJFrame();
				nuevo.setVisible(true);
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
				index main = new index(); 
				main.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVolver);
	}
}