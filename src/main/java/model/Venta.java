package model;

import utils.GestorPDF;

import java.io.IOException;
import java.util.Date;

public class Venta {
    private Date fecha;


    public static void boletaVenta(Pasajero pasajero){
        GestorPDF gestorPDF = new GestorPDF();
        try {
            gestorPDF.generarBoleta(pasajero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
