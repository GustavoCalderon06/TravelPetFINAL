package model;

public enum CiudadOrigen {
    PUCON("PUCON"),
    TEMUCO("Temuco"),
    VILLARRICA("Villarrica");

    private String ciudadOrigen;

    private CiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
}