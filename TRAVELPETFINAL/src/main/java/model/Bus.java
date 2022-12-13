package model;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private List<Pasajero> pasajeros;
    private List<Mascota> mascotas;
    private List<Pasaje> pasajes;


    public Bus() {
        this.pasajeros = new ArrayList<Pasajero>();
        this.mascotas = new ArrayList<Mascota>();
        this.pasajes = new ArrayList<Pasaje>();
    }

    public List<Pasaje> buscarPasajeOrigen(CiudadOrigen origen) {
        List<Pasaje> boletos = new ArrayList<Pasaje>();
        for (Pasaje boleto : this.pasajes) {
            if (boleto.getOrigen().equals(origen)) {
                boletos.add(boleto);
            }
        }
        return boletos;
    }
    public List<Pasaje> buscarPasajeDia(int dia) {
        List<Pasaje> boleto = new ArrayList<Pasaje>();
        for (Pasaje pasaje : this.pasajes) {
            if (pasaje.getDia()==dia) {
                boleto.add(pasaje);
            }
        }
        return boleto;
    }




    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }




    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }



    public List<Pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(List<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }




    public List<Pasajero> getClientes() {
        return pasajeros;
    }



}
