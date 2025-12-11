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

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				index frame = new index();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public index() {
		setTitle("Bienvenido a Librería Yenny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); 
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 250)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("LIBRERÍA YENNY");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(44, 62, 80)); 
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblTitulo.setBounds(0, 30, 484, 50);
		contentPane.add(lblTitulo);
		
		
		JLabel lblSubtitulo = new JLabel("Seleccione su tipo de usuario");
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setForeground(new Color(127, 140, 141)); 
		lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSubtitulo.setBounds(0, 90, 484, 30);
		contentPane.add(lblSubtitulo);
		
		
		JButton btnEmpleado = new JButton("Empleado");
		estilizarBoton(btnEmpleado);
		btnEmpleado.setBounds(60, 160, 110, 40);
		btnEmpleado.addActionListener(e -> {
			empleadoinicioJFrame inicio = new empleadoinicioJFrame();
			inicio.setVisible(true);
			dispose();
		});
		contentPane.add(btnEmpleado);
		
		
		JButton btnEditor = new JButton("Editor");
		estilizarBoton(btnEditor);
		btnEditor.setBounds(190, 160, 110, 40);
		btnEditor.addActionListener(e -> {
			EditorStartFrame inicio = new EditorStartFrame();
			inicio.setVisible(true);
			dispose();
		});
		contentPane.add(btnEditor);
		
		
		JButton btnAutor = new JButton("Autor");
		estilizarBoton(btnAutor);
		btnAutor.setBounds(320, 160, 110, 40);
		btnAutor.addActionListener(e -> {
			autor_inicioJFrame inicio = new autor_inicioJFrame();
			inicio.setVisible(true);
			dispose();
		});
		contentPane.add(btnAutor);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(231, 76, 60)); 
		btnSalir.setFocusPainted(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(190, 260, 110, 35);
		btnSalir.addActionListener(e -> dispose());
		contentPane.add(btnSalir);
	}
	
	
	private void estilizarBoton(JButton btn) {
		btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(52, 152, 219)); 
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
	}
}
