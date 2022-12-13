package GUIs;

import model.Pasajero;
import utils.ValidadorRut;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaComprador extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoDireccion, textoNumeroTelefonico, textoCorreo;
    private JTextField textFieldNombre, textFieldCorreo, textFieldTelefono, textFieldRut;
    private String nombre,correo,numero,rut;
    private JButton botonContinuar, botonRegresar;

    private boolean regresar;

    private VentanaSimulacionCompra ventanaSimulacionCompra;



    public VentanaComprador(VentanaSimulacionCompra ventanaSimulacionCompra) {
        super("Datos del cliente", 500, 520);
        this.ventanaSimulacionCompra = ventanaSimulacionCompra;
        regresar = false;
        generarElementosVentana();
    }


    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonRegresar();
        generarBotonContinuar();
        generarTextFieldNombre();
        generarTextFieldCorreo();
        generarTextFieldTelefono();
        generarTextFieldRut();

    }


    private void generarEncabezado() {
        String textoCabecera = "Datos del cliente";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 60, 20, 500, 50);

    }

    private void generarBotonContinuar() {
        String textoBoton = "Ir a la compra";
        this.botonContinuar = super.generarBoton(textoBoton, 75, 450, 150, 20);
        this.add(this.botonContinuar);
        this.botonContinuar.addActionListener(this);
    }

    private void generarBotonRegresar() {
        String textoBotonCancelar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonCancelar, 275, 450, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }

    private void generarTextFieldNombre() {
        String textoNombre = "Nombre:";
        super.generarJLabel(this.textoNombre, textoNombre, 20, 100, 150, 20);
        this.textFieldNombre = super.generarJTextField(200, 100, 250, 20);
        this.add(this.textFieldNombre);
    }

    private void generarTextFieldCorreo() {
        String textoCorreo = "Correo electrónico:";
        super.generarJLabel(this.textoCorreo, textoCorreo, 20, 200, 150, 20);
        this.textFieldCorreo = super.generarJTextField(200, 200, 250, 20);
        this.add(this.textFieldCorreo);
    }

    private void generarTextFieldTelefono() {
        String textoNumero = "Número telefónico:";
        super.generarJLabel(this.textoNumeroTelefonico, textoNumero, 20, 250, 150, 20);
        this.textFieldTelefono = super.generarJTextField(200, 250, 250, 20);
        this.add(this.textFieldTelefono);
    }

    private void generarTextFieldRut() {
        String textoRut = "Rut:";
        super.generarJLabel(this.textoRut, textoRut, 20, 150, 150, 20);
        this.textFieldRut = super.generarJTextField(200, 150, 250, 20);
        this.add(this.textFieldRut);
    }


    public void resetText() {
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        textFieldTelefono.setText("");
        textFieldRut.setText("");


    }

    public void registrarCliente(String nombre,String correo,String numero,String rut) {
        if (!nombre.isEmpty() && !correo.isEmpty() && !numero.isEmpty()) {
            Pasajero pasajero = new Pasajero(nombre, rut, correo, numero);


            if (!pasajero.registroCheck("src\\main\\resources\\registro\\clientes.txt")) {
                pasajero.registrarUsuario(nombre, rut, correo, numero);
                JOptionPane.showMessageDialog(this, "Registro exitoso.");

            } else {
                JOptionPane.showMessageDialog(this, "Registro no exitoso, intente uno diferente.");
                resetText();
            }


        } else {
            JOptionPane.showMessageDialog(this, "Registro no exitoso, intente nuevamente.");
            resetText();
        }


    }
    public void deshabilitarElementos(){
        textFieldNombre.setEnabled(false);
        textFieldCorreo.setEnabled(false);
        textFieldRut.setEnabled(false);
        textFieldTelefono.setEnabled(false);
        botonContinuar.setEnabled(false);
        botonRegresar.setEnabled(false);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

    public String getRut() {
        return rut;
    }

    public void actionPerformed(ActionEvent e) {
        this.nombre = textFieldNombre.getText();
        this.correo = textFieldCorreo.getText();
        this.numero = textFieldTelefono.getText();
        this.rut = textFieldRut.getText();
        if (e.getSource() == this.botonContinuar) {
            if (ValidadorRut.validarDigito(rut)){
                deshabilitarElementos();

                registrarCliente(nombre,correo,numero,rut);

                this.ventanaSimulacionCompra.setVisible(true);
                this.ventanaSimulacionCompra.setNombre(nombre);
                this.ventanaSimulacionCompra.setCorreo(correo);
                this.ventanaSimulacionCompra.setNumero(numero);
                this.ventanaSimulacionCompra.setRut(rut);



            }else{
                JOptionPane.showMessageDialog(this, "Rut imcorrecto.");
                resetText();
            }

        }
        if (e.getSource() == this.botonRegresar) {
            regresar = true;

            this.dispose();
        }
    }

    public boolean isRegresar() {
        return regresar;
    }
}
