package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("libreria yenny ");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(191, 29, 140, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnEmpleado = new JButton("empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadoinicioJFrame inicio = new empleadoinicioJFrame();
				inicio.setVisible(true);
				dispose();
				
			}
		});
		btnEmpleado.setBounds(43, 268, 89, 23);
		contentPane.add(btnEmpleado);
		
		JButton btnEditor = new JButton("editor");
		btnEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditorStartFrame inicio = new EditorStartFrame();
				inicio.setVisible(true);
				dispose();
				
			
			}
		});
		btnEditor.setBounds(163, 268, 89, 23);
		contentPane.add(btnEditor);
		
		JButton btnAutor = new JButton("autor");
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				autor_inicioJFrame inicio  = new autor_inicioJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnAutor.setBounds(278, 268, 89, 23);
		contentPane.add(btnAutor);
		
		JLabel lblNewLabel_1 = new JLabel("¿que tipo de usuario es?");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(145, 162, 214, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton btnsalir = new JButton("salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsalir.setBounds(385, 268, 89, 23);
		contentPane.add(btnsalir);

	}
}
