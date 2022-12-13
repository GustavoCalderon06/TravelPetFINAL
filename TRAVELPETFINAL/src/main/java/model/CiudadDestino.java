package model;

public enum CiudadDestino {
    CONCEPCION("Concepcion"),
    CHILLAN("Chillan"),
    CHIGUAYANTE("Chiguayante");


    private String ciudadDestino;

    private CiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadDestino;
    }
}
