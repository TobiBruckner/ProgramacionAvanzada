package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

import BLL.Autor;
import dll.DTO_estado_propuesta;

public class VerEstadoPropuestaJFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Autor autorActual;

    
    public VerEstadoPropuestaJFrame(Autor autor) {
        this.autorActual = autor;

        setTitle("Estado de Propuestas (Autor: " + autor.getNombre_usuario() + ")");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setBounds(100, 100, 550, 450);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("ESTADO DE SUS PROPUESTAS ENVIADAS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Yu Gothic", Font.BOLD, 18));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

       
        cargarEstadoPropuestas(textArea);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel footerPanel = new JPanel();
        footerPanel.add(btnCerrar);
        contentPane.add(footerPanel, BorderLayout.SOUTH);
    }

    private void cargarEstadoPropuestas(JTextArea textArea) {
        if (autorActual == null) {
            textArea.setText("Error: No se encontró la información del Autor.");
            return;
        }

        
        int idAutor = autorActual.getId_autor(); 

        
        List<String> estados = DTO_estado_propuesta.obtenerEstadosPorAutor(idAutor); 

        if (estados.isEmpty()) {
            textArea.setText("No se encontraron propuestas enviadas o el estado de sus propuestas aún no ha sido evaluado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String estado : estados) {
            sb.append(estado).append("\n\n");
        }
        
        textArea.setText(sb.toString());
    }
}