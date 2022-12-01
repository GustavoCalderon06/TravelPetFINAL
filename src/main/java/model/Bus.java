package model;


import java.util.List;

public class Bus {
    private List<Pasajero> pasajeros;

    public Bus(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public List<Pasajero> getClientes() {
        return pasajeros;
    }



}
