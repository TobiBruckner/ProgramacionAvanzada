package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Editor;
import BLL.Empleado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuempleadoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuempleadoJFrame frame = new menuempleadoJFrame(null);
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
	public menuempleadoJFrame(Empleado empleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuEmpleado = new JLabel("menu empleado");
		lblMenuEmpleado.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblMenuEmpleado.setBounds(156, 11, 217, 57);
		contentPane.add(lblMenuEmpleado);
		
		JButton btnverlibro = new JButton("ver libro");
		btnverlibro.setBounds(31, 183, 156, 23);
		contentPane.add(btnverlibro);
		btnverlibro.addActionListener(e -> Empleado.VerInformacionLibro());
		
		JButton precio = new JButton("modificar precio");
		precio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		precio.setBounds(229, 183, 156, 23);
		contentPane.add(precio);
		precio.addActionListener(e -> Empleado.ModificarPrecio());
		
		JButton btnsalir = new JButton("salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsalir.setBounds(168, 237, 89, 23);
		contentPane.add(btnsalir);

	}

}
