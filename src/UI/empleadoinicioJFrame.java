package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class empleadoinicioJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empleadoinicioJFrame frame = new empleadoinicioJFrame();
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
	public empleadoinicioJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleado = new JLabel("empleado");
		lblEmpleado.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblEmpleado.setBounds(177, 35, 146, 34);
		contentPane.add(lblEmpleado);
		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadologinJFrame inicio = new empleadologinJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnlogin.setBounds(94, 149, 89, 23);
		contentPane.add(btnlogin);
		
		JButton btnregistro = new JButton("registro");
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadoregistroJFrame inicio = new empleadoregistroJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnregistro.setBounds(248, 149, 89, 23);
		contentPane.add(btnregistro);
		
		JButton btnsalir = new JButton("salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsalir.setBounds(177, 207, 89, 23);
		contentPane.add(btnsalir);

	}

}
