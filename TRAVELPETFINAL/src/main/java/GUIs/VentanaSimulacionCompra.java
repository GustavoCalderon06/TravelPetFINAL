package GUIs;
import model.Mascota;
import model.Pasajero;
import utils.GestorPDF;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
public class VentanaSimulacionCompra extends Ventana {

    private VentanaAsientos Padre;

    private JButton botonGenerarPDF;
    private String asiento;
    private String asientoMascota;
    private String nombreMascota,tipo,peso;
    private String nombre,correo,numero,rut;
    private JLabel imagen,cordenada1,cordenada2,cordenada3;
    private JFormattedTextField c1,c2,c3;

    public VentanaSimulacionCompra(String asiento,String asientoMascota,String nombreMascota,String tipo,String peso,VentanaAsientos padre) {

        super("WebPoy", 500, 300);

        this.asiento=asiento;
        this.asientoMascota=asientoMascota;
        this.nombreMascota=nombreMascota;
        this.tipo=tipo;
        this.peso=peso;
        this.Padre=padre;
        padre.setVisible(false);

        generarElementosVentana();

    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    private void generarElementosVentana() {
        generarBotonPDF();
        generarImagen();
        generarTextFieldC1();
        generarTextFieldC2();
        generarTextFieldC3();

    }
    public void generarImagen() {
        this.imagen = new JLabel(new ImageIcon("src\\main\\resources\\imagenes\\Web.png"));
        this.imagen.setBounds(40, 0, 400, 300);
        this.imagen.setForeground(Color.BLACK);
        super.add(this.imagen);
    }
    private void generarTextFieldC1() {
        super.generarJLabel(this.cordenada1, "H1:", 20, 20, 30, 30);
        InternationalFormatter formato = super.generarFormato(0,99);
        this.c1 = super.generarJFormattedTextField(formato, 50, 20, 30, 30);
        this.add(this.c1);
    }
    private void generarTextFieldC2() {
        super.generarJLabel(this.cordenada2, "A4:", 100, 20, 30, 30);
        InternationalFormatter formato = super.generarFormato(0,99);
        this.c2 = super.generarJFormattedTextField(formato, 130, 20, 30, 30);
        this.add(this.c2);
    }
    private void generarTextFieldC3() {
        super.generarJLabel(this.cordenada3, "G2:", 180, 20, 30, 30);
        InternationalFormatter formato = super.generarFormato(0,99);
        this.c3 = super.generarJFormattedTextField(formato, 210, 20, 30, 30);
        this.add(this.c3);
    }

    public void generarBotonPDF() {
        String textoBoton = "Generar compra";
        this.botonGenerarPDF = super.generarBoton(textoBoton, 280, 20, 150, 50);
        this.botonGenerarPDF.setBackground(Color.RED);
        this.add(this.botonGenerarPDF);
        this.botonGenerarPDF.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGenerarPDF) {
            GestorPDF boleta = new GestorPDF();
            Pasajero pasajero=new Pasajero(nombre,correo,numero,rut,asiento);
            Mascota mascota=new Mascota(nombreMascota,tipo,peso,asientoMascota);
            try {
                boleta.generarBoleta(pasajero,mascota);
                JOptionPane.showMessageDialog(this, "Boleta de compra generada correctamente");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);


        }

    }


}
