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
import BLL.Editor;
import dll.DTO_editor;

public class EditorRegisterFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField dniField;
    private JTextField usuarioField;
    private JPasswordField passField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EditorRegisterFrame frame = new EditorRegisterFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EditorRegisterFrame() {
        setTitle("Registro de Editor - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(100, 100, 480, 650); 
        setLocationRelativeTo(null);   
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JLabel lblTitulo = new JLabel("NUEVO EDITOR");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setBounds(0, 20, 464, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblSub = new JLabel("Complete los datos para registrar un editor");
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
        nombreField = agregarTextField(xField, yStart + 20, widthField, heightField);

      
        agregarEtiqueta("Apellido:", xLabel, yStart + gap);
        apellidoField = agregarTextField(xField, yStart + gap + 20, widthField, heightField);

       
        agregarEtiqueta("DNI:", xLabel, yStart + gap * 2);
        dniField = agregarTextField(xField, yStart + gap * 2 + 20, widthField, heightField);

        
        agregarEtiqueta("Nombre de Usuario:", xLabel, yStart + gap * 3);
        usuarioField = agregarTextField(xField, yStart + gap * 3 + 20, widthField, heightField);

       
        agregarEtiqueta("Contraseña:", xLabel, yStart + gap * 4);
        passField = new JPasswordField();
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBounds(xField, yStart + gap * 4 + 20, widthField, heightField);
        contentPane.add(passField);

       
        
       
        JButton btnRegister = new JButton("Registrar Editor");
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBackground(new Color(39, 174, 96)); 
        btnRegister.setFocusPainted(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setBounds(50, 480, 360, 40);
        btnRegister.addActionListener(e -> handleRegistro());
        contentPane.add(btnRegister);
        
       
        JButton btnBack = new JButton("Cancelar");
        btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnBack.setForeground(Color.GRAY);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setBounds(130, 530, 200, 30);
        btnBack.addActionListener(e -> {
            EditorStartFrame.start();
            dispose();
        });
        contentPane.add(btnBack);
    }
    
    
    private void handleRegistro() {
        String n = nombreField.getText().trim();
        String a = apellidoField.getText().trim();
        String d = dniField.getText().trim();
        String u = usuarioField.getText().trim();
        String p = new String(passField.getPassword());
        
        if (n.isEmpty() || a.isEmpty() || d.isEmpty() || u.isEmpty() || p.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Editor editor = new Editor(n, a, d, u, p);
        boolean ok = DTO_editor.agregarEditor(editor);
        
        if (ok) {
            JOptionPane.showMessageDialog(this, "Editor registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            EditorLoginFrame lf = new EditorLoginFrame();
            lf.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el editor. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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