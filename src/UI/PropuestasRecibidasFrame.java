package UI;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Editor;
import dll.DTO_propuesta;

public class PropuestasRecibidasFrame extends JFrame {

    private JPanel contentPane;
    private Editor editorActual;

    public PropuestasRecibidasFrame(Editor editor) {
        this.editorActual = editor;
        setTitle("Propuestas Recibidas - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
       
        JLabel lblTitulo = new JLabel("PROPUESTAS RECIBIDAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setBounds(0, 20, 584, 30);
        contentPane.add(lblTitulo);
        
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        textArea.setBackground(new Color(245, 245, 245));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 70, 520, 320);
        contentPane.add(scrollPane);
        
      
        cargarPropuestas(textArea);
        
       
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVolver.setBackground(new Color(127, 140, 141));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setBounds(200, 410, 180, 35);
        btnVolver.addActionListener(e -> {
            new EditorMenuFrame(editorActual).setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }
    
    private void cargarPropuestas(JTextArea area) {
        List<String> lista = DTO_propuesta.obtenerPropuestasConAutor();
        if (lista.isEmpty()) {
            area.setText("No hay propuestas registradas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String p : lista) {
                sb.append(p).append("\n");
            }
            area.setText(sb.toString());
        }
    }
}