package model;

import data.DataUpdater;
import data.FileReader;

import java.util.ArrayList;
import java.util.Date;

public class Pasajero {
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private String rut;
    private Date fecha=new Date();
    private int asiento;
    private boolean loginState = false;


    public Pasajero(String nombre,String correo, String numeroTelefono, String rut) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.rut = rut;

    }

    public Pasajero() {
    }

    public static void registrarUsuario(String nombre, String correo, String numeroTelefono, String rut) {
        int newId = FileReader.leerArchivo("src\\main\\resources\\clientes.txt").size() + 1;
        DataUpdater.guardarCliente(nombre, correo,numeroTelefono,rut,"src\\main\\resources\\clientes.txt", newId);
    }
    public boolean registroCheck(String filepath) {
        ArrayList<String> registros = FileReader.leerArchivo(filepath);
        this.loginState = false;
        for (String registro : registros) {
            String[] temp = registro.split(",");
            if (this.rut.equalsIgnoreCase(temp[0])) {
                this.loginState = true;
                break;
            }
        }
        return this.loginState;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLoginState() {
        return loginState;
    }


}
