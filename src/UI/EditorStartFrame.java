package UI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EditorStartFrame extends JFrame {
    public EditorStartFrame() {
        setTitle("Editor");
        setSize(360, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(1, 3, 12, 12));
        JButton login = new JButton("Login");
        JButton register = new JButton("Registrar");
        JButton exit = new JButton("Salir");
        panel.add(login);
        panel.add(register);
        panel.add(exit);
        add(panel, BorderLayout.CENTER);
        login.addActionListener(e -> {
            EditorLoginFrame f = new EditorLoginFrame();
            f.setVisible(true);
            dispose();
        });
        register.addActionListener(e -> {
            EditorRegisterFrame f = new EditorRegisterFrame();
            f.setVisible(true);
            dispose();
        });
        exit.addActionListener(e -> System.exit(0));
    }
    public static void start() {
        SwingUtilities.invokeLater(() -> new EditorStartFrame().setVisible(true));
    }
}
