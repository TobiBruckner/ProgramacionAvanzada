package UI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import BLL.Libro;
import dll.DTO_libro;

public class LibrosPrecioFrame extends JFrame {
    private final DefaultTableModel model;
    private final JTable table;
    public LibrosPrecioFrame() {
        setTitle("Modificar precio de libros");
        setSize(840, 460);
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
        JButton modificar = new JButton("Modificar precio");
        JButton cerrar = new JButton("Cerrar");
        actions.add(modificar);
        actions.add(cerrar);
        add(actions, BorderLayout.SOUTH);
        modificar.addActionListener(e -> onModificarPrecio());
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
    private void onModificarPrecio() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro");
            return;
        }
        int id = (Integer) model.getValueAt(row, 0);
        String precioStr = JOptionPane.showInputDialog(this, "Ingrese nuevo precio");
        if (precioStr == null || precioStr.trim().isEmpty()) return;
        double nuevoPrecio;
        try {
            nuevoPrecio = Double.parseDouble(precioStr.trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Precio inválido");
            return;
        }
        if (nuevoPrecio <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0");
            return;
        }
        boolean ok = DTO_libro.actualizarPrecioLibro(id, nuevoPrecio);
        JOptionPane.showMessageDialog(this, ok ? "Precio actualizado" : "No se pudo actualizar el precio");
        if (ok) loadData();
    }
}
