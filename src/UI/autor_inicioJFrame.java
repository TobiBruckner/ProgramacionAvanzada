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

public class autor_inicioJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autor_inicioJFrame frame = new autor_inicioJFrame();
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
	public autor_inicioJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("autor");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(203, 69, 75, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				autorloginJFrame inicio = new autorloginJFrame();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnlogin.setBounds(133, 197, 89, 23);
		contentPane.add(btnlogin);
		
		JButton btnregistro = new JButton("registro");
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autorregistroJFrame nuevo = new autorregistroJFrame();
				nuevo.setVisible(true);
				dispose();
			}
		});
		btnregistro.setBounds(287, 197, 89, 23);
		contentPane.add(btnregistro);
		
		JButton btnsalir = new JButton("salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnsalir.setBounds(216, 255, 89, 23);
		contentPane.add(btnsalir);

	}

}
