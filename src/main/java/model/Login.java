package model;

import data.FileReader;
import data.DataUpdater;

import java.util.ArrayList;

public class Login {
    private String user;
    private String pass;
    private boolean loginState = false;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static void registrarUsuario(String user, String pass) {
        int newId = FileReader.leerArchivo("src\\main\\resources\\registro\\IDPass.txt").size() + 1;
        DataUpdater.guardarUsuario(user, pass, "src\\main\\resources\\registro\\IDPass.txt", newId);
    }

    public String[] logearUsuario(String filepath) {
        ArrayList<String> registros = FileReader.leerArchivo(filepath);
        this.loginState = false;
        String[] usuarioLogeado = new String[6];
        for (int i = 0; i < registros.size(); i++) {
            String[] temp = registros.get(i).split(",");
            if (this.user.equalsIgnoreCase(temp[0]) && this.pass.equalsIgnoreCase(temp[1])) {
                this.loginState = true;
                usuarioLogeado = temp;
            }
        }
        return usuarioLogeado;
    }
    public boolean registroCheck(String filepath) {
        ArrayList<String> registros = FileReader.leerArchivo(filepath);
        this.loginState = false;
        for (String registro : registros) {
            String[] temp = registro.split(",");
            if (this.user.equalsIgnoreCase(temp[0])) {
                this.loginState = true;
                break;
            }
        }
        return this.loginState;
    }

    public boolean isLoginState() {
        return loginState;
    }
}
