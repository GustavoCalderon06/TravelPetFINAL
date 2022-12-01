package model;

public class Pasaje {
    private CiudadDestino destino;
    private CiudadOrigen origen;
    private int valor;
    private int dia;

    public Pasaje(CiudadDestino destino, CiudadOrigen origen, int valor, int dia) {
        this.destino = destino;
        this.origen = origen;
        this.valor = valor;
        this.dia = dia;
    }

    public CiudadDestino getDestino() {
        return destino;
    }

    public void setDestino(CiudadDestino destino) {
        this.destino = destino;
    }

    public CiudadOrigen getOrigen() {
        return origen;
    }

    public void setOrigen(CiudadOrigen origen) {
        this.origen = origen;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
