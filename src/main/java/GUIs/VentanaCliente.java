package GUIs;

import Interface.VentanaMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class VentanaCliente extends Ventana implements VentanaMenu {
    private JLabel bienvenida;
    private JButton botonComprar, botonTarifas, botonSalida;

    public VentanaCliente() {
        super("VentanaCliente", 500, 300);
        generarElementosVentana();
    }

    public void generarElementosVentana() {
        generarPrimerBoton();
        generarSegundoBoton();
        generarTercerBoton();
        generarImagen();

    }


    public void generarImagen() {
        ImageIcon imagen=new ImageIcon("src\\main\\resources\\Cliente.jpg");
        JLabel labelUser = new JLabel();
        labelUser.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH)));
        labelUser.setBounds(50, 0, 400, 400);
        labelUser.setForeground(Color.BLACK);
        super.add(labelUser);
    }

    public void generarPrimerBoton() {
        String textoBoton = "Comprar Pasaje";
        this.botonComprar = super.generarBoton(textoBoton, 150, 40, 200, 50);
        this.add(this.botonComprar);
        this.botonComprar.addActionListener(this);
    }

    public void generarSegundoBoton() {
        String textoBoton = "Ver tarifas";
        this.botonTarifas = super.generarBoton(textoBoton, 150, 115, 200, 50);
        this.add(this.botonTarifas);
        this.botonTarifas.addActionListener(this);
    }

    public void generarTercerBoton() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 150, 190, 200, 50);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonComprar) {
            VentanaDatosPasajes ventana = new VentanaDatosPasajes();
            this.dispose();
        }
        if (e.getSource() == this.botonTarifas) {
            VentanaTabla tarifas= new VentanaTabla();

        }
        if (e.getSource() == this.botonSalida) {
            this.dispose();
            System.exit(0);
        }
    }
}
