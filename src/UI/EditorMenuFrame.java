package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Editor;

public class EditorMenuFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Editor editorActual;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EditorMenuFrame frame = new EditorMenuFrame(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EditorMenuFrame(Editor editor) {
        this.editorActual = editor;
        setTitle("Panel de Editor - Librería Yenny");
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
        
        String nombreEditor = (editor != null) ? editor.getNombre() : "Editor";
        JLabel lblBienvenido = new JLabel("Bienvenido, " + nombreEditor);
        lblBienvenido.setForeground(Color.WHITE);
        lblBienvenido.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblBienvenido.setBounds(20, 15, 400, 30);
        panelHeader.add(lblBienvenido);
        
        JLabel lblMenu = new JLabel("GESTIÓN DE PROPUESTAS");
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblMenu.setForeground(new Color(44, 62, 80));
        lblMenu.setBounds(0, 90, 584, 30);
        contentPane.add(lblMenu);
        
      
        JButton btnVer = new JButton("<html><center>Propuestas<br>Recibidas</center></html>");
        btnVer.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnVer.setBackground(new Color(52, 152, 219));
        btnVer.setForeground(Color.WHITE);
        btnVer.setFocusPainted(false);
        btnVer.setBorderPainted(false);
        btnVer.setBounds(100, 150, 180, 90);
        btnVer.addActionListener(e -> {
           
            new PropuestasRecibidasFrame(editorActual).setVisible(true);
            dispose();
        });
        contentPane.add(btnVer);
        
       
        JButton btnProyectar = new JButton("<html><center>Evaluar y<br>Proyectar</center></html>");
        btnProyectar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnProyectar.setBackground(new Color(155, 89, 182));
        btnProyectar.setForeground(Color.WHITE);
        btnProyectar.setFocusPainted(false);
        btnProyectar.setBorderPainted(false);
        btnProyectar.setBounds(310, 150, 180, 90);
        btnProyectar.addActionListener(e -> {
            
            if (editorActual != null) {
                new PropuestasPendientesFrame(editorActual).setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnProyectar);
        
     
        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setBackground(new Color(231, 76, 60));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFocusPainted(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setBounds(220, 310, 150, 35);
        btnSalir.addActionListener(e -> {
            dispose();
            EditorStartFrame.start();
        });
        contentPane.add(btnSalir);
    }
}