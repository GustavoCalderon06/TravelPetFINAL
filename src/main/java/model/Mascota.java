package model;

public class Mascota {
    private String nombre;
    private String tipo;
    private int peso;

    public Mascota(String nombre, String tipo, int peso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
