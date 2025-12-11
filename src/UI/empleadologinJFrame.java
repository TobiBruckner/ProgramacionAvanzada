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
import BLL.Empleado;
import dll.DTO_empleado;

public class empleadologinJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userField;
    private JPasswordField passField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                empleadologinJFrame frame = new empleadologinJFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public empleadologinJFrame() {
        setTitle("Login Empleado - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500); 
        setLocationRelativeTo(null);   
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
      
        JLabel lblTitulo = new JLabel("INICIAR SESION");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setBounds(0, 40, 384, 40);
        contentPane.add(lblTitulo);
        
        JLabel lblSubtitulo = new JLabel("portal de empleados");
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblSubtitulo.setForeground(Color.GRAY);
        lblSubtitulo.setBounds(0, 80, 384, 20);
        contentPane.add(lblSubtitulo);
        
       
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsuario.setBounds(50, 140, 300, 20);
        contentPane.add(lblUsuario);
        
        userField = new JTextField();
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userField.setBounds(50, 165, 280, 35);
        contentPane.add(userField);
        
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPass.setBounds(50, 220, 300, 20);
        contentPane.add(lblPass);
        
        passField = new JPasswordField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBounds(50, 245, 280, 35);
        contentPane.add(passField);
        
        JLabel lblError = new JLabel("");
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblError.setForeground(new Color(231, 76, 60)); 
        lblError.setBounds(50, 300, 280, 20);
        contentPane.add(lblError);

        JButton btnLogin = new JButton("Ingresar");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(52, 152, 219));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(50, 330, 280, 45);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String u = userField.getText().trim();
                String p = new String(passField.getPassword());
                
                if (u.isEmpty() || p.isEmpty()) {
                    lblError.setText("Ingrese usuario y contraseña");
                    return;
                }
                
                
                Empleado empleado = DTO_empleado.login_dto(u, p);
                if (empleado != null) {
                    
                    menuempleadoJFrame menu = new menuempleadoJFrame(empleado);
                    menu.setVisible(true);
                    dispose();
                } else {
                    lblError.setText("Usuario o contraseña incorrectos");
                }
            }
        });
        contentPane.add(btnLogin);
        
       
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setFocusPainted(false);
        btnVolver.setBounds(140, 400, 100, 30);
        btnVolver.addActionListener(e -> {
            empleadoinicioJFrame inicio = new empleadoinicioJFrame();
            inicio.setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }
}