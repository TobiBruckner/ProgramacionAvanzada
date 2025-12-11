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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BLL.Editor;
import BLL.EstadoPropuesta;
import dll.DTO_estado_propuesta;

public class PropuestasPendientesFrame extends JFrame {

    private JPanel contentPane;
    private Editor editorActual;
    private JTextField txtIdPropuesta;
    private JTextArea textArea;

    public PropuestasPendientesFrame(Editor editor) {
        this.editorActual = editor;
        setTitle("Evaluar Propuestas - Librería Yenny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 600);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("EVALUACIÓN DE PROPUESTAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setBounds(0, 20, 634, 30);
        contentPane.add(lblTitulo);
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        textArea.setBackground(new Color(245, 245, 245));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 60, 570, 250);
        contentPane.add(scrollPane);
        
        cargarPendientes(); 
        
        
        JPanel panelControles = new JPanel();
        panelControles.setBackground(new Color(236, 240, 241));
        panelControles.setBounds(30, 330, 570, 150);
        panelControles.setLayout(null);
        contentPane.add(panelControles);
        
        JLabel lblId = new JLabel("ID Propuesta a evaluar:");
        lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblId.setBounds(20, 20, 180, 30);
        panelControles.add(lblId);
        
        txtIdPropuesta = new JTextField();
        txtIdPropuesta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtIdPropuesta.setBounds(190, 20, 100, 30);
        panelControles.add(txtIdPropuesta);
        
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBackground(new Color(46, 204, 113));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAceptar.setFocusPainted(false);
        btnAceptar.setBounds(320, 20, 110, 30);
        btnAceptar.addActionListener(e -> evaluarPropuesta(true));
        panelControles.add(btnAceptar);
        
        JButton btnRechazar = new JButton("RECHAZAR");
        btnRechazar.setBackground(new Color(231, 76, 60));
        btnRechazar.setForeground(Color.WHITE);
        btnRechazar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRechazar.setFocusPainted(false);
        btnRechazar.setBounds(440, 20, 110, 30);
        btnRechazar.addActionListener(e -> evaluarPropuesta(false));
        panelControles.add(btnRechazar);
        
        JLabel lblInfo = new JLabel("<html><small>* Al aceptar se solicitará la estimación de ganancia.<br>* Al rechazar la ganancia será 0.</small></html>");
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setBounds(20, 70, 500, 40);
        panelControles.add(lblInfo);
        
        
        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnVolver.setBackground(new Color(127, 140, 141));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setBounds(225, 500, 180, 35);
        btnVolver.addActionListener(e -> {
            new EditorMenuFrame(editorActual).setVisible(true);
            dispose();
        });
        contentPane.add(btnVolver);
    }
    
    private void cargarPendientes() {
        List<String> pendientes = DTO_estado_propuesta.obtenerPropuestasPendientes();
        if (pendientes.isEmpty()) {
            textArea.setText("No hay propuestas pendientes de evaluación.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : pendientes) {
                sb.append(s).append("\n");
            }
            textArea.setText(sb.toString());
        }
    }
    
    private void evaluarPropuesta(boolean aceptar) {
        String idStr = txtIdPropuesta.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID de la propuesta.");
            return;
        }
        
        try {
            int idPropuesta = Integer.parseInt(idStr);
            
            if (DTO_estado_propuesta.propuestaTieneEstado(idPropuesta)) {
                JOptionPane.showMessageDialog(this, "Esta propuesta ya fue evaluada.");
                return;
            }
            
            String estado = aceptar ? "Aceptada" : "Rechazada";
            double ganancia = 0.0;
            
            if (aceptar) {
                String input = JOptionPane.showInputDialog(this, "Ingrese Estimación de Ganancia ($):");
                if (input == null) return;
                try {
                    ganancia = Double.parseDouble(input);
                    if (ganancia < 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Monto inválido.");
                    return;
                }
            }
            
            EstadoPropuesta nuevoEstado = new EstadoPropuesta(estado, ganancia, idPropuesta, editorActual.getId_editor());
            
            if (DTO_estado_propuesta.agregarEstadoPropuesta(nuevoEstado)) {
                JOptionPane.showMessageDialog(this, "Propuesta " + estado + " correctamente.");
                cargarPendientes(); 
                txtIdPropuesta.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar en base de datos.");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.");
        }
    }
}