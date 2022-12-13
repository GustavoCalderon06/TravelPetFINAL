package model;

import data.DataUpdater;
import data.FileReader;

public class Mascota {
    private String nombre;
    private String tipo;
    private String asiento;
    private String peso;

    public Mascota(String nombre, String tipo, String peso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
    }

    public Mascota(String nombre, String tipo,String peso, String asiento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.asiento = asiento;
        this.peso = peso;
    }

    public Mascota(String asiento) {
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAsiento() {
        return asiento;
    }
    public  void registrarMascota(String nombre,String tipo,int peso) {
        int newId = FileReader.leerArchivo("src\\main\\resources\\registro\\mascota.txt").size() + 1;
        DataUpdater.guardarMascota(nombre,tipo,peso,"src\\main\\resources\\registro\\mascota.txt", newId);
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
}
