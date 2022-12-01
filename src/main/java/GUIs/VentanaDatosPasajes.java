package GUIs;

import model.CiudadDestino;
import model.CiudadOrigen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaDatosPasajes extends Ventana{
    private JLabel labelLoguear;
    private JButton botonBuscar,botonCancelar;
    private JComboBox listaOrigen,listaDestino;

    public VentanaDatosPasajes() {
        super("Datos del Pasaje", 400, 450);
        generarElementosVentana();
    }

    public void generarElementosVentana() {
        generarLabel();
        generarBotonBuscarPasaje();
        generarBotonCancelar();
        generarListas();
    }

    private void generarLabel() {
        JLabel labelTitulo = new JLabel("Ingrese los siguientes datos: ");
        labelTitulo.setBounds(10, 10, 300, 40);
        labelTitulo.setForeground(Color.BLACK);
        Font fuenteTexto = new Font("Calibri",1,25);
        labelTitulo.setFont(fuenteTexto);
        this.add(labelTitulo);
    }

    public void generarBotonBuscarPasaje() {
        String textoBoton = "Buscar Pasaje";
        this.botonBuscar = super.generarBoton(textoBoton, 200, 270, 150, 50);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    public void generarBotonCancelar() {
        String textoBoton = "Salir";
        this.botonCancelar = super.generarBoton(textoBoton, 40, 270, 150, 50);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }



    public void generarListas() {
        JLabel labelOrigen = new JLabel("Origen: ");
        labelOrigen.setBounds(10, 100, 100, 40);
        labelOrigen.setForeground(Color.BLACK);
        this.listaOrigen=super.generarListaDesplegable(CiudadOrigen.values(),60,110, 100, 20);
        this.add(this.listaOrigen);
        this.add(labelOrigen);

        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setBounds(180, 100, 100, 40);
        labelDestino.setForeground(Color.BLACK);
        this.listaDestino=super.generarListaDesplegable(CiudadDestino.values(),240,110, 120, 20);
        this.add(this.listaDestino);
        this.add(labelDestino);


    }

    //Usa estos cambios
    public void actionPerformed(ActionEvent e) {
        boolean state;
        if(e.getSource() == this.botonBuscar) {
            VentanaAsientos asientos= new VentanaAsientos();
            this.dispose();

        }
        if(e.getSource() == this.botonCancelar){
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            this.dispose();
        }

    }


}
