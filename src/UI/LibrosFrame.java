package UI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.LinkedList;
import BLL.Libro;
import dll.DTO_libro;

public class LibrosFrame extends JFrame {
    private final DefaultTableModel model;
    private final JTable table;
    public LibrosFrame() {
        setTitle("Libros");
        setSize(800, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Autor");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Popularidad");
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel actions = new JPanel();
        JButton cerrar = new JButton("Cerrar");
        actions.add(cerrar);
        add(actions, BorderLayout.SOUTH);
        cerrar.addActionListener(e -> dispose());
        loadData();
    }
    private void loadData() {
        model.setRowCount(0);
        LinkedList<Libro> libros = DTO_libro.mostrarLibros();
        if (libros == null) return;
        for (Libro l : libros) {
            model.addRow(new Object[]{
                l.getId_libro(),
                l.getNombre_libro(),
                l.getAutor_libro(),
                l.getPrecio_libro(),
                l.getStock(),
                l.getPopularidad()
            });
        }
    }
}
