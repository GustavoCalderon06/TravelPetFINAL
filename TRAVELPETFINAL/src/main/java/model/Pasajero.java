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
    private String asiento;
    private boolean loginState = false;


    public Pasajero(String nombre,String rut,String correo, String numeroTelefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.rut = rut;

    }



    public Pasajero(String nombre, String correo, String numeroTelefono, String rut, String asiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.rut = rut;
        this.asiento = asiento;
    }


    public static void registrarUsuario(String nombre,String rut,String correo, String numeroTelefono) {
        int newId = FileReader.leerArchivo("src\\main\\resources\\registro\\clientes.txt").size() + 1;
        DataUpdater.guardarCliente(nombre, correo,numeroTelefono,rut,"src\\main\\resources\\registro\\clientes.txt", newId);
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

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }


    @Override
    public String toString() {
        return "Pasajero{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", rut='" + rut + '\'' +
                '}';
    }
}
