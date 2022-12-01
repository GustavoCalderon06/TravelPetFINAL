package GUIs;
import model.Pasajero;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaComprador extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoDireccion, textoNumeroTelefonico, textoCorreo, textoNombreMascota, textoTipoMascota, textoPesoMascota;
    private JTextField textFieldNombre, textFieldCorreo, textFieldTelefono, textFieldRut, textFieldNombreMascota, textFieldTipoMascota, textFieldPesoMascota;
    private JButton botonContinuar, botonRegresar;


    public VentanaComprador() {
        super("Datos del cliente", 500, 520);
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
        generarTextFieldNombreMascota();
        generarTextFieldTipoMascota();
        generarTextFieldPesoMascota();
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

    private void generarTextFieldNombreMascota() {
        String textoNombreMascota = "Nombre de mascota:";
        super.generarJLabel(this.textoNombreMascota, textoNombreMascota, 20, 300, 150, 20);
        this.textFieldNombreMascota = super.generarJTextField(200, 300, 250, 20);
        this.add(this.textFieldNombreMascota);

    }

    private void generarTextFieldTipoMascota() {
        String textoTipoMascota = "Tipo de Mascota:";
        super.generarJLabel(this.textoPesoMascota, textoTipoMascota, 20, 350, 150, 20);
        this.textFieldTipoMascota = super.generarJTextField(200, 350, 250, 20);
        this.add(this.textFieldTipoMascota);

    }

    private void generarTextFieldPesoMascota() {
        String textoPesoMascota = "Peso de mascota";
        super.generarJLabel(this.textoPesoMascota, textoPesoMascota, 20, 400, 150, 20);
        this.textFieldPesoMascota = super.generarJTextField(200, 400, 250, 20);
        this.add(this.textFieldPesoMascota);

    }


    public void resetText() {
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        textFieldTelefono.setText("");
        textFieldRut.setText("");
        textFieldNombreMascota.setText("");
        textFieldTipoMascota.setText("");
        textFieldPesoMascota.setText("");

    }

    public void registrarCliente() {
        String nombre = textFieldNombre.getText();
        String correo = textFieldCorreo.getText();
        String numero = textFieldTelefono.getText();
        String rut = textFieldRut.getText();
        if (!nombre.isEmpty() && !correo.isEmpty() && !numero.isEmpty() && !rut.isEmpty()) {
            Pasajero pasajero = new Pasajero(nombre, correo, numero, rut);
            if (!pasajero.registroCheck("src\\main\\resources\\clientes.txt")) {
                pasajero.registrarUsuario(nombre, correo, numero, rut);
                JOptionPane.showMessageDialog(this, "Registro exitoso.");

            } else {
                JOptionPane.showMessageDialog(this, "Registro no exitoso, intente uno diferente.");
                resetText();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Registro no exitoso, intente nuevamente.");
            resetText();
        }
        String nombreMascota = textFieldNombreMascota.getText();
        String TipoMascota = textFieldTipoMascota.getText();
        String PesoMascota = textFieldPesoMascota.getText();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonContinuar) {
            registrarCliente();
            VentanaSimulacionCompra simulacionCompra=new VentanaSimulacionCompra();
            this.dispose();


        }
        if (e.getSource() == this.botonRegresar) {
            this.dispose();
        }

    }
}

