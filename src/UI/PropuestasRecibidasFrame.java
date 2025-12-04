package UI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dll.Conexion;
import BLL.Editor;
 

public class PropuestasRecibidasFrame extends JFrame {
    private final Editor editor;
    private final DefaultTableModel model;
    private final JTable table;
    public PropuestasRecibidasFrame(Editor editor) {
        this.editor = editor;
        setTitle("Propuestas Recibidas");
        setSize(1000, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Propuesta");
        model.addColumn("Capítulos");
        model.addColumn("Páginas");
        model.addColumn("Piloto");
        model.addColumn("Autor Nombre");
        model.addColumn("Autor Apellido");
        model.addColumn("Biografía");
        model.addColumn("Redes");
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
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "SELECT p.id_propuesta, p.nombre_propuesta, p.cantidad_capitulos, p.cantidad_paginas, p.capitulo_piloto, "+
                "a.nombre, a.apellido, a.biografia, a.redes_sociales "+
                "FROM propuesta p INNER JOIN autor a ON p.fk_autor = a.id_autor"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("id_propuesta"),
                    rs.getString("nombre_propuesta"),
                    rs.getInt("cantidad_capitulos"),
                    rs.getInt("cantidad_paginas"),
                    rs.getString("capitulo_piloto"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("biografia"),
                    rs.getString("redes_sociales")
                });
            }
        } catch (Exception e) {
        }
    }
    
}
