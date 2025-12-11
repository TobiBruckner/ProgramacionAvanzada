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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Empleado;
import dll.DTO_empleado;

public class empleadoregistroJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inpnombre;
    private JTextField inpapellido;
    private JTextField inpdni;
    private JTextField inpnombreusuario;
    private JPasswordField inppass;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                empleadoregistroJFrame frame = new empleadoregistroJFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public empleadoregistroJFrame() {
        setTitle("Registro de Empleado - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 600); 
        setLocationRelativeTo(null);  
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel lblTitulo = new JLabel("NUEVO EMPLEADO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setBounds(0, 20, 464, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblSub = new JLabel("Complete los datos para dar de alta un empleado");
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
        int gap = 60; 

       
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

        JLabel lblerror = new JLabel("");
        lblerror.setHorizontalAlignment(SwingConstants.CENTER);
        lblerror.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblerror.setForeground(new Color(231, 76, 60)); 
        lblerror.setBounds(50, 400, 360, 20);
        contentPane.add(lblerror);

        
       
        JButton btnRegistro = new JButton("Registrar Empleado");
        btnRegistro.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setBackground(new Color(39, 174, 96)); 
        btnRegistro.setFocusPainted(false);
        btnRegistro.setBorderPainted(false);
        btnRegistro.setBounds(50, 430, 360, 40);
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inpnombre.getText().trim();
                String apellido = inpapellido.getText().trim();
                String dni = inpdni.getText().trim();
                String nombre_usuario = inpnombreusuario.getText().trim();
                String pass = new String(inppass.getPassword()).trim();

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || nombre_usuario.isEmpty() || pass.isEmpty()) {
                    lblerror.setText("Por favor, complete todos los campos.");
                    return; 
                }
                lblerror.setText("");
                
                Empleado empleado = new Empleado(nombre, apellido, dni, nombre_usuario, pass);
                boolean ok = DTO_empleado.agregarEmpleado(empleado);
                
                if (ok) {
                    JOptionPane.showMessageDialog(contentPane, "Empleado registrado correctamente.");
                    empleadologinJFrame nuevo = new empleadologinJFrame();
                    nuevo.setVisible(true);
                    dispose();					
                } else {
                    lblerror.setText("Error: No se pudo registrar (Posible usuario duplicado).");
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
        btnCancelar.setBounds(130, 480, 200, 30);
        btnCancelar.addActionListener(e -> {
            empleadoinicioJFrame inicio = new empleadoinicioJFrame();
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