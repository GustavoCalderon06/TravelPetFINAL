package GUIs;

import data.CSVtable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaTabla2 extends JFrame implements ActionListener {

    private VentanaAsientos ventanaAsientos;
    private JTable tabla;
    public VentanaTabla2(VentanaAsientos ventanaAsientos) {
        super("Tarifas");
        generarTabla();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.ventanaAsientos = ventanaAsientos;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void generarTabla() {
        DefaultTableModel dtm = new DefaultTableModel();
        this.tabla = new JTable(dtm);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int column = 0;
                int row = tabla.getSelectedRow();
                String valor = tabla.getModel().getValueAt(row, column).toString();
                System.out.println(valor);
                switch(column) {
                    case 1 -> getVentanaAsientos().setDestino(valor);
                    case 2 -> getVentanaAsientos().setPrecio(Integer.parseInt(valor));
                    case 3 -> getVentanaAsientos().setFecha(valor);
                }
            }
        });

    }

    public VentanaAsientos getVentanaAsientos() {
        return ventanaAsientos;
    }
}

