package UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import BLL.Editor;
import BLL.Usuario;
import dll.DTO_editor;

public class RegistroEditorGUI extends JFrame{
	private JTextField txtNombre, txtApellido, txtDni, txtPassword, txtNombreUsuario;
	private JButton btnRegistrar,btnSeleccionarFoto;
	private byte[] fotoPerfil;
	
	public RegistroEditorGUI() {
		setTitle("Registro de editor");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    

        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtDni = new JTextField();
        txtPassword = new JTextField();
        txtNombreUsuario = new JTextField();
        btnRegistrar = new JButton("Registrar");
        btnSeleccionarFoto = new JButton("Seleccionar Foto");

        txtNombre.setBounds(50, 20, 300, 25);
        txtApellido.setBounds(50, 60, 300, 25);
        txtDni.setBounds(50, 140, 300, 25);
        txtPassword.setBounds(50, 100, 300, 25);
        txtNombreUsuario.setBounds(50, 120, 300, 25);
        btnSeleccionarFoto.setBounds(50, 180, 140, 25);
        btnRegistrar.setBounds(210, 180, 140, 25);

        getContentPane().add(txtNombre);
        getContentPane().add(txtApellido);
        getContentPane().add(txtDni);
        getContentPane().add(txtPassword);
        getContentPane().add(txtNombreUsuario);
        getContentPane().add(btnSeleccionarFoto);
        getContentPane().add(btnRegistrar);
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(50, -8, 61, 16);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Apellido");
        lblNewLabel_1.setBounds(50, 43, 61, 16);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("DNI");
        lblNewLabel_2.setBounds(50, 85, 61, 16);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Contraseña");
        lblNewLabel_3.setBounds(50, 60, 61, 16);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Nombre de usuario");
        lblNewLabel_4.setBounds(50, 60, 61, 16);
        getContentPane().add(lblNewLabel_4);
        
        btnSeleccionarFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

            
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png");
                chooser.setFileFilter(filter);

                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();

                    
                    String nombreArchivo = selectedFile.getName().toLowerCase();
                    if (!(nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".png"))) {
                        JOptionPane.showMessageDialog(null, "Solo se permiten archivos JPG, JPEG o PNG.");
                        return;
                    }

                    try {
                        fotoPerfil = Files.readAllBytes(selectedFile.toPath());
                        JOptionPane.showMessageDialog(null, "Imagen cargada correctamente.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al leer la imagen.");
                    }
                }
            }
        });


        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDni.getText();
                String password = txtPassword.getText();
                String nombreUsuario = txtNombreUsuario.getText();

                Editor nuevo = new Editor(nombre, apellido, dni, password, nombreUsuario);
                DTO_editor.agregarEditor(nuevo);
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
            }
        });

        setVisible(true);
	}
	
	public static void main(String[] args) {
        new RegistroEditorGUI();
    }
}
