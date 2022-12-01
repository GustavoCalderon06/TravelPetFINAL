package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaAsientos extends Ventana {
    private JButton[][] botonesAsientos;
    private JButton botonContinuar;
    final private int FILAS = 10;
    final private int COLUMNAS = 4;
    private JButton selectedButton;
    private JButton selectedSecondButton;


    public VentanaAsientos() {
        super("Asientos", 500, 800);
        generarElementos();
    }

    private void generarElementos() {
        generarMatrizBotones();
        generarBotonContinuar();
    }
    private void generarBotonContinuar() {
        String textoBotonContinuar = "Continuar";
        this.botonContinuar = super.generarBoton(textoBotonContinuar, 300, 700, 150, 20);
        botonContinuar.setEnabled(false);
        this.add(this.botonContinuar);
        this.botonContinuar.addActionListener(this);
    }

    private void generarMatrizBotones() {
        botonesAsientos = new JButton[FILAS][COLUMNAS];
        int x = 50;
        int y = 50;
        int contador=1;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botonesAsientos[i][j] = new JButton();
                botonesAsientos[i][j].setBackground(Color.BLUE);
                botonesAsientos[i][j].setBounds(x, y, 50, 50);
                botonesAsientos[i][j].setText(Integer.toString(contador));


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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botonContinuar){
            this.dispose();
            VentanaComprador ventana = new VentanaComprador();

        }
        else{
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    if (ae.getSource() == botonesAsientos[i][j]) {
                        botonesAsientos[i][j].setBackground(Color.RED);

                        if(this.selectedButton == null){
                            this.selectedButton = botonesAsientos[i][j];
                            botonesAsientos[i][j].setEnabled(false);
                        }
                        if(this.selectedSecondButton != null){
                            this.selectedSecondButton = this.selectedButton;
                            this.selectedButton = botonesAsientos[i][j];
                        }
                        JOptionPane.showMessageDialog(this, "Asiento seleccionado exitosamente");

                        botonContinuar.setEnabled(true);



                    }else{
                        botonesAsientos[i][j].setEnabled(false);

                    }
                }
            }
        }
    }
}