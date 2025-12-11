package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Autor;

public class menuautorJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Autor autorActual;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				menuautorJFrame frame = new menuautorJFrame(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public menuautorJFrame(Autor autor) {
		this.autorActual = autor;
		setTitle("Panel de Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236, 240, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(52, 73, 94));
		panelHeader.setBounds(0, 0, 600, 60);
		panelHeader.setLayout(null);
		contentPane.add(panelHeader);
		
		String nombreAutor = (autor != null) ? autor.getNombre() + " " + autor.getApellido() : "Invitado";
		JLabel lblBienvenido = new JLabel("Bienvenido, " + nombreAutor);
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblBienvenido.setBounds(20, 15, 400, 30);
		panelHeader.add(lblBienvenido);
		
		JLabel lblMenu = new JLabel("MENÚ PRINCIPAL");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblMenu.setForeground(new Color(44, 62, 80));
		lblMenu.setBounds(0, 90, 584, 30);
		contentPane.add(lblMenu);
		
		
		JButton btnPropuesta = new JButton("Nueva Propuesta");
		btnPropuesta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPropuesta.setBackground(new Color(52, 152, 219));
		btnPropuesta.setForeground(Color.WHITE);
		btnPropuesta.setFocusPainted(false);
		btnPropuesta.setBounds(100, 150, 180, 80);
		btnPropuesta.addActionListener(e -> {
			if (autorActual != null) {
				new AgregarPropuestaJFrames(autorActual); 
			} else {
				mostrarErrorSesion();
			}
		});
		contentPane.add(btnPropuesta);
		
		
		JButton btnEstado = new JButton("Ver Estados");
		btnEstado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEstado.setBackground(new Color(155, 89, 182)); 
		btnEstado.setForeground(Color.WHITE);
		btnEstado.setFocusPainted(false);
		btnEstado.setBounds(310, 150, 180, 80);
		btnEstado.addActionListener(e -> {
			if (autorActual != null) {
				new VerEstadoPropuestaJFrame(autorActual).setVisible(true);
			} else {
				mostrarErrorSesion();
			}
		});
		contentPane.add(btnEstado);
		
		
		JButton btnSalir = new JButton("Cerrar Sesión");
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSalir.setBackground(new Color(231, 76, 60));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(220, 300, 150, 35);
		btnSalir.addActionListener(e -> {
			dispose();
			new index().setVisible(true); 
		});
		contentPane.add(btnSalir);
	}
	
	private void mostrarErrorSesion() {
		JOptionPane.showMessageDialog(contentPane, "Debe iniciar sesión.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
