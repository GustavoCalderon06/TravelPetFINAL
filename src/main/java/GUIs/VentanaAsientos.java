package GUIs;

import model.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VentanaAsientos extends Ventana {
    private VentanaDatosPasajes Padre;
    private JButton[][] botonesAsientos;
    private JButton botonContinuar;
    private JCheckBox mascota;
    final private int FILAS = 10;
    final private int COLUMNAS = 4;
    private String line, prueba, Destino, Fecha;
    private int Precio;
    private String prueba2,nombreMascota,tipo,peso;
    private JLabel labelNombreMascota,labelTipoMascota,labelPesoMascota;
    private JTextField textFieldNombreMascota,textFieldTipoMascota,textFieldPesoMascota;
    private JButton botonGuardar;
    public String getPrueba2() {
        return prueba2;
    }

    public void setPrueba2(String prueba2) {
        this.prueba2 = prueba2;
    }

    public String getPrueba() {
        return prueba;
    }


    public VentanaAsientos() {
        super("Asientos", 800, 800);
        generarElementos();
    }
    public VentanaAsientos(VentanaDatosPasajes padre) {
        super("Asientos", 800, 800);
        this.Padre = padre;
        generarElementos();
    }

    private void generarElementos() {
        generarMatrizBotones();
        generarCheckBox();
        generarBotonContinuar();
        generarBotonGuardar();
        generarInputPanels();
    }
    public void generarCheckBox(){
        this.mascota= new JCheckBox("Mascota", false);
        this.mascota.setBounds(500,50,100,50);
        this.add(this.mascota);
        this.mascota.setVisible(false);
        this.mascota.addActionListener(this);

    }
    private void generarBotonContinuar() {
        String textoBotonContinuar = "Continuar";
        this.botonContinuar = super.generarBoton(textoBotonContinuar, 300, 700, 150, 20);
        botonContinuar.setEnabled(false);
        this.add(this.botonContinuar);
        this.botonContinuar.addActionListener(this);
    }

    private void generarBotonGuardar() {
        String textoBotonContinuar = "Guardar";
        this.botonGuardar = super.generarBoton(textoBotonContinuar, 500, 400, 150, 20);
        botonGuardar.setVisible(false);
        this.add(this.botonGuardar);
        this.botonGuardar.addActionListener(this);
    }


    public void generarInputPanels() {
        labelNombreMascota = new JLabel("Nombre: ");
        labelNombreMascota.setBounds(440, 100, 100, 30);
        labelNombreMascota.setForeground(Color.BLACK);
        this.textFieldNombreMascota = new JTextField();
        textFieldNombreMascota.setBounds(500, 100, 200, 30);
        this.labelNombreMascota.setVisible(false);
        this.textFieldNombreMascota.setVisible(false);
        super.add(textFieldNombreMascota);
        super.add(labelNombreMascota);

        labelTipoMascota = new JLabel("Tipo: ");
        labelTipoMascota.setBounds(440, 200, 100, 30);
        labelTipoMascota.setForeground(Color.BLACK);
        this.textFieldTipoMascota = new JTextField();
        textFieldTipoMascota.setBounds(500, 200, 200, 30);
        this.labelTipoMascota.setVisible(false);
        this.textFieldTipoMascota.setVisible(false);
        super.add(textFieldTipoMascota);
        super.add(labelTipoMascota);

        labelPesoMascota = new JLabel("Peso: ");
        labelPesoMascota.setBounds(440, 300, 100, 30);
        labelPesoMascota.setForeground(Color.BLACK);
        this.textFieldPesoMascota = new JTextField();
        textFieldPesoMascota.setBounds(500, 300, 200, 30);
        this.labelPesoMascota.setVisible(false);
        this.textFieldPesoMascota.setVisible(false);
        super.add(textFieldPesoMascota);
        super.add(labelPesoMascota);


    }
    public void setVisibleDatosMascota(){
        this.labelNombreMascota.setVisible(true);
        this.textFieldNombreMascota.setVisible(true);
        this.labelTipoMascota.setVisible(true);
        this.textFieldTipoMascota.setVisible(true);
        this.labelPesoMascota.setVisible(true);
        this.textFieldPesoMascota.setVisible(true);
        this.botonGuardar.setVisible(true);


    }
    private void generarMatrizBotones() {
        botonesAsientos = new JButton[FILAS][COLUMNAS];
        int x = 50;
        int y = 50;
        int contador=0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                try {
                    line = Files.readAllLines(Paths.get("src\\main\\resources\\datos\\numeroAsiento.txt")).get(contador);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                botonesAsientos[i][j] = new JButton();
                botonesAsientos[i][j].setBackground(Color.BLUE);
                botonesAsientos[i][j].setBounds(x, y, 50, 50);
                botonesAsientos[i][j].setText(line);
                super.add(botonesAsientos[i][j]);
                botonesAsientos[i][j].addActionListener(this);
                if(j == 1){
                    contador++;
                    x += 200;
                    continue;
                }
                x += 50;
                contador++;
            }
            x = 50;
            y += 50;

        }
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
    public void registrarCliente() {
        nombreMascota = textFieldNombreMascota.getText();
        tipo = textFieldTipoMascota.getText();
        peso= textFieldPesoMascota.getText();
        if (!nombreMascota.isEmpty() && !tipo.isEmpty() && !peso.isEmpty() ) {
            Mascota mascota=new Mascota(nombreMascota,tipo,peso);
            mascota.registrarMascota(nombreMascota,tipo,Integer.parseInt(peso));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no exitoso, intente nuevamente.");
            resetText();
        }


    }
    public void resetText() {
        textFieldNombreMascota.setText("");
        textFieldTipoMascota.setText("");
        textFieldPesoMascota.setText("");


    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == botonContinuar){

            VentanaSimulacionCompra ventanaSimulacionCompra = new VentanaSimulacionCompra(prueba,prueba2,nombreMascota,tipo,peso,this);
            ventanaSimulacionCompra.setVisible(false);
            VentanaComprador ventanaComprador=new VentanaComprador(ventanaSimulacionCompra);

        }
        String vacio="";

        if (ae.getSource()==botonGuardar){
            if (!this.textFieldNombreMascota.getText().equals(vacio) && !this.textFieldTipoMascota.getText().equals(vacio) && !this.textFieldPesoMascota.getText().equals(vacio)){
                botonGuardar.setVisible(true);
                registrarCliente();
                JOptionPane.showMessageDialog(this, "Datos de mascota registrado exitosamente");
                JOptionPane.showMessageDialog(this, "Presione continuar para proseguir");
                this.textFieldNombreMascota.setEnabled(false);
                this.textFieldTipoMascota.setEnabled(false);
                this.textFieldPesoMascota.setEnabled(false);
                botonGuardar.setEnabled(false);
                botonContinuar.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Tiene que ingresar datos:");

            }

        }


        else{
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLUMNAS; j++) {

                    if (mascota.isSelected()){
                        if (botonesAsientos[i][j].isEnabled()) {

                            if (j % 2 == 0) {
                                botonesAsientos[i][j + 1].setEnabled(true);
                                botonesAsientos[i][j + 1].setBackground(Color.RED);
                                this.prueba2=botonesAsientos[i][j+1].getText();
                                System.out.println(this.prueba2);

                            } else {
                                botonesAsientos[i][j - 1].setEnabled(true);
                                botonesAsientos[i][j - 1].setBackground(Color.RED);
                                this.prueba2=botonesAsientos[i][j-1].getText();
                                System.out.println(this.prueba2);

                            }
                            break;
                        }
                        setVisibleDatosMascota();
                        mascota.setVisible(false);
                        botonContinuar.setEnabled(false);
                    }

                    botonesAsientos[i][j].setEnabled(false);

                    if (ae.getSource() == botonesAsientos[i][j]) {
                        System.out.println(getPrecio());
                        mascota.setVisible(true);
                        botonesAsientos[i][j].setBackground(Color.RED);
                        botonesAsientos[i][j].setEnabled(true);
                        this.prueba=botonesAsientos[i][j].getText();
                        System.out.println(this.prueba);
                        JOptionPane.showMessageDialog(this, "Asiento seleccionado exitosamente");
                        botonContinuar.setEnabled(true);
                    }

                }
            }
        }
    }
}