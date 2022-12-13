package data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVtable {
    public void csvToTable(String path,JTable jTable1,DefaultTableModel model) {
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(";");
            model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            Object[] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(";");

                model.addRow(dataRow);
            }

        } catch (IOException e) {
            System.out.println("Problemas para leer el archivo");
        }
    }

}
