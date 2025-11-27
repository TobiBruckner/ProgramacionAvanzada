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

public class EditorLoginFrame extends JFrame {
    private final JTextField user;
    private final JPasswordField pass;
    public EditorLoginFrame() {
        setTitle("Login Editor");
        setSize(380, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.gridx = 0; c.gridy = 0; form.add(new JLabel("Usuario"), c);
        c.gridx = 1; c.gridy = 0; user = new JTextField(16); form.add(user, c);
        c.gridx = 0; c.gridy = 1; form.add(new JLabel("Contraseña"), c);
        c.gridx = 1; c.gridy = 1; pass = new JPasswordField(16); form.add(pass, c);
        JButton login = new JButton("Ingresar");
        JButton back = new JButton("Volver");
        JPanel actions = new JPanel();
        actions.add(login);
        actions.add(back);
        add(form, BorderLayout.CENTER);
        add(actions, BorderLayout.SOUTH);
        login.addActionListener(e -> {
            String u = user.getText().trim();
            String p = new String(pass.getPassword());
            Editor editor = DTO_editor.login_dto(u, p);
            if (editor != null) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión correcto");
                EditorMenuFrame f = new EditorMenuFrame(editor);
                f.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos");
            }
        });
        back.addActionListener(e -> {
            EditorStartFrame.start();
            dispose();
        });
    }
}
