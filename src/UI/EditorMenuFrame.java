package UI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import BLL.Editor;

public class EditorMenuFrame extends JFrame {
    public EditorMenuFrame(Editor editor) {
        setTitle("Menú Editor");
        setSize(440, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel header = new JLabel("Bienvenido");
        add(header, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(1, 3, 12, 12));
        JButton ver = new JButton("Propuestas recibidas");
        JButton proyectar = new JButton("Proyectar propuestas");
        JButton salir = new JButton("Salir");
        panel.add(ver);
        panel.add(proyectar);
        panel.add(salir);
        add(panel, BorderLayout.CENTER);
        ver.addActionListener(e -> Editor.VerPropuesta());
        proyectar.addActionListener(e -> Editor.EstimacionGanancia(editor.getId_editor()));
        salir.addActionListener(e -> EditorStartFrame.start());
    }
}
