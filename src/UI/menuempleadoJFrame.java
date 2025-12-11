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
import BLL.Empleado;

public class menuempleadoJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Empleado empleadoActual;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                menuempleadoJFrame frame = new menuempleadoJFrame(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public menuempleadoJFrame(Empleado empleado) {
        this.empleadoActual = empleado;
        setTitle("Panel de Empleado - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 420); 
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
        
        String nombre = (empleado != null) ? empleado.getNombre() : "Empleado";
        JLabel lblBienvenido = new JLabel("Bienvenido, " + nombre);
        lblBienvenido.setForeground(Color.WHITE);
        lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblBienvenido.setBounds(20, 15, 400, 30);
        panelHeader.add(lblBienvenido);
        
       
        JLabel lblMenu = new JLabel("GESTIÓN DE LIBRERÍA");
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblMenu.setForeground(new Color(44, 62, 80));
        lblMenu.setBounds(0, 90, 584, 30);
        contentPane.add(lblMenu);
        
      
        JButton btnVerLibro = new JButton("Ver Catálogo de Libros");
        btnVerLibro.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnVerLibro.setBackground(new Color(52, 152, 219)); 
        btnVerLibro.setForeground(Color.WHITE);
        btnVerLibro.setFocusPainted(false);
        btnVerLibro.setBorderPainted(false);
        btnVerLibro.setBounds(100, 150, 180, 90);
        btnVerLibro.addActionListener(e -> Empleado.VerInformacionLibro());
        contentPane.add(btnVerLibro);
        
        
        JButton btnPrecio = new JButton("Modificar Precios");
        btnPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnPrecio.setBackground(new Color(243, 156, 18)); 
        btnPrecio.setForeground(Color.WHITE);
        btnPrecio.setFocusPainted(false);
        btnPrecio.setBorderPainted(false);
        btnPrecio.setBounds(310, 150, 180, 90);
        btnPrecio.addActionListener(e -> Empleado.ModificarPrecio());
        contentPane.add(btnPrecio);
        
       
        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setBackground(new Color(231, 76, 60));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFocusPainted(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setBounds(220, 310, 150, 35);
        btnSalir.addActionListener(e -> {
            dispose();
            empleadoinicioJFrame inicio = new empleadoinicioJFrame(); 
            inicio.setVisible(true);
        });
        contentPane.add(btnSalir);
    }
}