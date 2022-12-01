package GUIs;
import model.Pasajero;
import utils.GestorPDF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

//CLASE EXCENTA A CAMBIOS EN TEMA DE DISEÑO
public class VentanaSimulacionCompra extends Ventana {
    private JButton botonGenerarPDF;

    public VentanaSimulacionCompra() {
        super("VentanaPrincipal", 500, 300);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarBotonPDF();

    }

    public void generarBotonPDF() {
        String textoBoton = "Generar PDF";
        this.botonGenerarPDF = super.generarBoton(textoBoton, 100, 100, 150, 50);
        this.add(this.botonGenerarPDF);
        this.botonGenerarPDF.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGenerarPDF) {
            GestorPDF boleta = new GestorPDF();
            Pasajero pasajero=new Pasajero();
            try {
                boleta.generarBoleta(pasajero);
                JOptionPane.showMessageDialog(this, "Boleta de compra generada correctamente");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            dispose();

        }

    }


}
