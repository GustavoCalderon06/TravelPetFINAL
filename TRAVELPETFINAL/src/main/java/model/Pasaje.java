package model;



public class Pasaje {
    private String destino;
    private CiudadOrigen origen;
    private int valor;
    private int dia;

    public Pasaje(CiudadOrigen origen,String destino,  int valor, int dia) {
        this.destino = destino;
        this.origen = origen;
        this.valor = valor;
        this.dia = dia;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
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

    @Override
    public String toString() {
        return "Pasaje{" +
                "destino='" + destino + '\'' +
                ", origen=" + origen +
                ", valor=" + valor +
                ", dia=" + dia +
                '}';
    }
}
