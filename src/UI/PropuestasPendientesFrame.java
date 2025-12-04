package UI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dll.Conexion;
import BLL.Editor;
import BLL.EstadoPropuesta;
import dll.DTO_estado_propuesta;

public class PropuestasPendientesFrame extends JFrame {
    private final Editor editor;
    private final DefaultTableModel model;
    private final JTable table;
    public PropuestasPendientesFrame(Editor editor) {
        this.editor = editor;
        setTitle("Propuestas Pendientes");
        setSize(1000, 480);
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
        JButton aceptar = new JButton("Aceptar");
        JButton rechazar = new JButton("Rechazar");
        actions.add(aceptar);
        actions.add(rechazar);
        add(actions, BorderLayout.SOUTH);
        aceptar.addActionListener(e -> aceptarSeleccionada());
        rechazar.addActionListener(e -> rechazarSeleccionada());
        loadData();
    }
    private void loadData() {
        model.setRowCount(0);
        try {
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "SELECT p.id_propuesta, p.nombre_propuesta, p.cantidad_capitulos, p.cantidad_paginas, p.capitulo_piloto, "+
                "a.nombre, a.apellido, a.biografia, a.redes_sociales "+
                "FROM propuesta p INNER JOIN autor a ON p.fk_autor = a.id_autor "+
                "LEFT JOIN estado_propuesta ep ON p.id_propuesta = ep.fk_propuesta "+
                "WHERE ep.fk_propuesta IS NULL"
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
    private void aceptarSeleccionada() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Seleccione una propuesta"); return; }
        int id = (Integer) model.getValueAt(row, 0);
        String p = JOptionPane.showInputDialog(this, "Ingrese estimación de ganancia");
        if (p == null || p.trim().isEmpty()) return;
        double est;
        try { est = Double.parseDouble(p.trim()); } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Valor inválido"); return; }
        if (est < 0) { JOptionPane.showMessageDialog(this, "Debe ser mayor o igual a 0"); return; }
        EstadoPropuesta ep = new EstadoPropuesta("Aceptada", est, id, editor.getId_editor());
        boolean ok = DTO_estado_propuesta.agregarEstadoPropuesta(ep);
        JOptionPane.showMessageDialog(this, ok ? "Propuesta aceptada" : "Error al aceptar");
        if (ok) loadData();
    }
    private void rechazarSeleccionada() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Seleccione una propuesta"); return; }
        int id = (Integer) model.getValueAt(row, 0);
        EstadoPropuesta ep = new EstadoPropuesta("Rechazada", 0.0, id, editor.getId_editor());
        boolean ok = DTO_estado_propuesta.agregarEstadoPropuesta(ep);
        JOptionPane.showMessageDialog(this, ok ? "Propuesta rechazada" : "Error al rechazar");
        if (ok) loadData();
    }
}
