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

public class autorregistroJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpnombre;
	private JTextField inpapellido;
	private JTextField inpdni;
	private JTextField inpnombreusuario;
	private JPasswordField inppass;
	private JTextField inpbiografia;
	private JTextField inpredes;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				autorregistroJFrame frame = new autorregistroJFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public autorregistroJFrame() {
		setTitle("Registro de Autor - Librería Yenny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 750); 
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("CREAR CUENTA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitulo.setForeground(new Color(44, 62, 80));
		lblTitulo.setBounds(0, 20, 464, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblSub = new JLabel("Complete sus datos para unirse como autor");
		lblSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSub.setForeground(Color.GRAY);
		lblSub.setBounds(0, 50, 464, 20);
		contentPane.add(lblSub);

		
		int xLabel = 50;
		int xField = 50;
		int widthField = 360;
		int heightField = 30;
		int yStart = 90;
		int gap = 55; 

		
		agregarEtiqueta("Nombre:", xLabel, yStart);
		inpnombre = agregarTextField(xField, yStart + 20, widthField, heightField);

		
		agregarEtiqueta("Apellido:", xLabel, yStart + gap);
		inpapellido = agregarTextField(xField, yStart + gap + 20, widthField, heightField);

		
		agregarEtiqueta("DNI:", xLabel, yStart + gap * 2);
		inpdni = agregarTextField(xField, yStart + gap * 2 + 20, widthField, heightField);

		
		agregarEtiqueta("Nombre de Usuario:", xLabel, yStart + gap * 3);
		inpnombreusuario = agregarTextField(xField, yStart + gap * 3 + 20, widthField, heightField);

		
		agregarEtiqueta("Contraseña:", xLabel, yStart + gap * 4);
		inppass = new JPasswordField();
		inppass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		inppass.setBounds(xField, yStart + gap * 4 + 20, widthField, heightField);
		contentPane.add(inppass);

		
		agregarEtiqueta("Biografía breve:", xLabel, yStart + gap * 5);
		inpbiografia = agregarTextField(xField, yStart + gap * 5 + 20, widthField, heightField);

		
		agregarEtiqueta("Redes Sociales (Contacto):", xLabel, yStart + gap * 6);
		inpredes = agregarTextField(xField, yStart + gap * 6 + 20, widthField, heightField);

	
		JLabel lblerror = new JLabel("");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblerror.setForeground(new Color(231, 76, 60));
		lblerror.setBounds(50, 580, 360, 20);
		contentPane.add(lblerror);
		
		
		
		
		JButton btnRegistro = new JButton("Registrar Autor");
		btnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setBackground(new Color(39, 174, 96)); 
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setBounds(50, 610, 360, 40);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = inpnombre.getText().trim();
				String apellido = inpapellido.getText().trim();
				String dni = inpdni.getText().trim();
				String nombre_usuario = inpnombreusuario.getText().trim();
				String pass = new String(inppass.getPassword()).trim();
				String biografia = inpbiografia.getText().trim();
				String redes_sociales = inpredes.getText().trim();
				
				if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || 
					nombre_usuario.isEmpty() || pass.isEmpty() || 
					biografia.isEmpty() || redes_sociales.isEmpty()) {
					lblerror.setText("Por favor, complete todos los campos.");
					return; 
				}
				
				lblerror.setText(""); 
				
				Autor autor = new Autor(nombre, apellido, dni, nombre_usuario, pass, biografia, redes_sociales);
				boolean ok = DTO_autor.agregarAutor_dto(autor);
				
				if (ok) {
					
					autorloginJFrame nuevo = new autorloginJFrame();
					nuevo.setVisible(true);
					dispose();					
				} else {
					lblerror.setText("Error: No se pudo registrar. Verifique el usuario.");
				}
			}
		});
		contentPane.add(btnRegistro);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnCancelar.setForeground(Color.GRAY);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBounds(130, 660, 200, 30);
		btnCancelar.addActionListener(e -> {
			
			autor_inicioJFrame inicio = new autor_inicioJFrame();
			inicio.setVisible(true);
			dispose();
		});
		contentPane.add(btnCancelar);
	}
	
	
	private void agregarEtiqueta(String texto, int x, int y) {
		JLabel lbl = new JLabel(texto);
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl.setForeground(new Color(100, 100, 100));
		lbl.setBounds(x, y, 300, 20);
		contentPane.add(lbl);
	}
	
	private JTextField agregarTextField(int x, int y, int w, int h) {
		JTextField txt = new JTextField();
		txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt.setBounds(x, y, w, h);
		contentPane.add(txt);
		return txt;
	}
}
