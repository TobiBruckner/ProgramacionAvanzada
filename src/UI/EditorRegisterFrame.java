package UI;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import dll.DTO_editor;
import BLL.Editor;

public class EditorRegisterFrame extends JFrame {
    private final JTextField nombre;
    private final JTextField apellido;
    private final JTextField dni;
    private final JTextField usuario;
    private final JPasswordField pass;
    
    public EditorRegisterFrame() {
        setTitle("Registrar Editor");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.gridx=0; c.gridy=0; form.add(new JLabel("Nombre"), c);
        c.gridx=1; c.gridy=0; nombre = new JTextField(18); form.add(nombre, c);
        c.gridx=0; c.gridy=1; form.add(new JLabel("Apellido"), c);
        c.gridx=1; c.gridy=1; apellido = new JTextField(18); form.add(apellido, c);
        c.gridx=0; c.gridy=2; form.add(new JLabel("DNI"), c);
        c.gridx=1; c.gridy=2; dni = new JTextField(18); form.add(dni, c);
        c.gridx=0; c.gridy=3; form.add(new JLabel("Usuario"), c);
        c.gridx=1; c.gridy=3; usuario = new JTextField(18); form.add(usuario, c);
        c.gridx=0; c.gridy=4; form.add(new JLabel("Contraseña"), c);
        c.gridx=1; c.gridy=4; pass = new JPasswordField(18); form.add(pass, c);
        JButton register = new JButton("Registrar");
        JButton back = new JButton("Volver");
        JPanel actions = new JPanel();
        actions.add(register);
        actions.add(back);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);
        
        register.addActionListener(e -> {
            String n = nombre.getText().trim();
            String a = apellido.getText().trim();
            String d = dni.getText().trim();
            String u = usuario.getText().trim();
            String p = new String(pass.getPassword());
            if (n.isEmpty()||a.isEmpty()||d.isEmpty()||u.isEmpty()||p.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }
            Editor editor = new Editor(n,a,d,u,p);
            boolean ok = DTO_editor.agregarEditor(editor);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Agregado correctamente");
                EditorLoginFrame lf = new EditorLoginFrame();
                lf.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar");
            }
        });
        back.addActionListener(e -> {
            EditorStartFrame.start();
            dispose();
        });
    }
    
}
