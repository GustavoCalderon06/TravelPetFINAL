package GUIs;

import model.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaLogin extends Ventana {
    private JLabel labelLoguear;
    private JButton botonLogear,botonReset,botonVolver;
    private JTextField userInputPanel;
    private JPasswordField passInputPanel;

    public VentanaLogin() {
        super("VentanaLogin", 400, 450);
        generarElementosVentana();
    }

    public void generarElementosVentana() {
        generarLabel();
        generarBotonLogear();
        generarBotonReset();
        generarBotonVolver();
        generarInputPanels();
    }

    private void generarLabel() {
        String textoBienvenida = "Iniciar Sesion";
        super.generarJLabelEncabezado(this.labelLoguear, textoBienvenida, 50, 30, 600, 60);
    }

    public void generarBotonLogear() {
        String textoBoton = "Iniciar Sesion";
        this.botonLogear = super.generarBoton(textoBoton, 200, 270, 150, 50);
        this.add(this.botonLogear);
        this.botonLogear.addActionListener(this);
    }

    public void generarBotonReset() {
        String textoBoton = "Borrar";
        this.botonReset = super.generarBoton(textoBoton, 40, 270, 150, 50);
        this.add(this.botonReset);
        this.botonReset.addActionListener(this);
    }

    public void generarBotonVolver() {
        String textoBoton = "Volver";
        this.botonVolver = super.generarBoton(textoBoton, 90, 330, 200, 50);
        this.add(this.botonVolver);
        this.botonVolver.addActionListener(this);
    }

    public void generarInputPanels() {
        JLabel labelUser = new JLabel("Usuario: ");
        labelUser.setBounds(10, 150, 100, 40);
        labelUser.setForeground(Color.BLACK);
        this.userInputPanel = new JTextField();
        userInputPanel.setBounds(150, 150, 200, 40);
        super.add(userInputPanel);
        super.add(labelUser);

        JLabel labelPass = new JLabel("Contraseña: ");
        labelPass.setBounds(10, 200, 100, 40);
        labelPass.setForeground(Color.BLACK);
        passInputPanel = new JPasswordField();
        passInputPanel.setBounds(150, 200, 200, 40);
        super.add(passInputPanel);
        super.add(labelPass);
    }

    //Usa estos cambios
    public void actionPerformed(ActionEvent e) {
        boolean state;
        String vacio="";

        if(e.getSource() == this.botonLogear) {
            if (!userInputPanel.getText().equals(vacio) && !passInputPanel.getText().equals(vacio)) {
                Login login = new Login(userInputPanel.getText(), String.valueOf(passInputPanel.getPassword()));
                login.logearUsuario("src\\main\\resources\\registro\\IDPass.txt");
                state = login.isLoginState();
                if (!state) {
                    JOptionPane.showMessageDialog(this, "Login incorrecto, intente nuevamente.");
                    userInputPanel.setText("");
                    passInputPanel.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(this, "Logueado correctamente");
                    VentanaCliente cliente = new VentanaCliente();
                    this.dispose();

                }

            }else{
                JOptionPane.showMessageDialog(this, "Login no exitoso, intente nuevamente.");
            }
        }
        if(e.getSource() == this.botonReset){
            userInputPanel.setText("");
            passInputPanel.setText("");
        }
        if(e.getSource() == this.botonVolver){
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            this.dispose();
        }
    }

}