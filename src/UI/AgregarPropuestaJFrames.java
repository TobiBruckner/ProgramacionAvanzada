package UI;

import BLL.Autor;
import BLL.Propuesta;
import dll.DTO_propuesta;
import repository.Validaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarPropuestaJFrames extends JFrame {

    private Autor autorActual;

   
    private JTextField propNombreField;
    private JTextField propCapitulosField;
    private JTextField propPaginasField;
    private JTextArea propCapituloPilotoArea;

   
    public AgregarPropuestaJFrames(Autor autor) {
        this.autorActual = autor;
        
        setTitle("Enviar Nueva Propuesta (Autor: " + autor.getNombre() + " " + autor.getApellido() + ")");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null); 
        
        initComponents();
        
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
       
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("FORMULARIO DE PROPUESTA DE LIBRO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        gbc.gridwidth = 1;
        
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Nombre de la Propuesta:"), gbc);
        propNombreField = new JTextField(25);
        gbc.gridx = 1;
        formPanel.add(propNombreField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Cantidad de Capítulos (> 0):"), gbc);
        propCapitulosField = new JTextField(25);
        gbc.gridx = 1;
        formPanel.add(propCapitulosField, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Cantidad de Páginas (> 0):"), gbc);
        propPaginasField = new JTextField(25);
        gbc.gridx = 1;
        formPanel.add(propPaginasField, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Capítulo Piloto:"), gbc);
        propCapituloPilotoArea = new JTextArea(8, 25);
        propCapituloPilotoArea.setLineWrap(true);
        propCapituloPilotoArea.setWrapStyleWord(true);
        JScrollPane scrollPilot = new JScrollPane(propCapituloPilotoArea);
        gbc.gridx = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(scrollPilot, gbc);
        gbc.gridheight = 1;
        
        mainPanel.add(formPanel, BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        JButton saveButton = new JButton("Guardar y Enviar Propuesta");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.addActionListener(this::handleAgregarPropuesta);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        this.add(mainPanel);
    }
    
    
    private void handleAgregarPropuesta(ActionEvent event) {
        String nombre = propNombreField.getText().trim();
        String capitulosStr = propCapitulosField.getText().trim();
        String paginasStr = propPaginasField.getText().trim();
        String capituloPiloto = propCapituloPilotoArea.getText().trim();
        
       
        if (nombre.isEmpty() || capitulosStr.isEmpty() || paginasStr.isEmpty() || capituloPiloto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidadCapitulos;
        int cantidadPaginas;
        
        
        try {
            cantidadCapitulos = Integer.parseInt(capitulosStr);
            if (cantidadCapitulos <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad de capítulos debe ser mayor a 0.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad de capítulos debe ser un número entero válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            cantidadPaginas = Integer.parseInt(paginasStr);
            if (cantidadPaginas <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad de páginas debe ser mayor a 0.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad de páginas debe ser un número entero válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        int idAutor = autorActual.getId_autor();
        
       
        Propuesta nuevo = new Propuesta(nombre, cantidadCapitulos, cantidadPaginas, capituloPiloto, idAutor);
        
       
        if (DTO_propuesta.agregar_propuesta(nuevo)) {
            JOptionPane.showMessageDialog(this, "Propuesta '" + nombre + "' enviada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar la propuesta.", "Error de BD", JOptionPane.ERROR_MESSAGE);
        }
    }
}