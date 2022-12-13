package GUIs;

import data.CSVtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class VentanaTabla extends JFrame {

    private VentanaAsientos VentanaAsientos;

    public VentanaTabla(VentanaAsientos ventanaAsientos) {
        super("Tarifas");
        generarTabla();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.VentanaAsientos = ventanaAsientos;
    }

    public VentanaTabla() {
        super("Tarifas");
        generarTabla();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);
    }


    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void generarTabla() {
        DefaultTableModel dtm = new DefaultTableModel();
        JTable tabla = new JTable(dtm);
        tabla.setDefaultEditor(Object.class, null);


        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        JScrollPane scrollPane = new JScrollPane(tabla);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        CSVtable CSV= new CSVtable();
        CSV.csvToTable("src\\main\\resources\\datos\\Tarifas.csv",tabla,dtm);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }


    private void cerrarVentana() {
        this.dispose();
    }
}
