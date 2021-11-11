package com.flock.demo.model.provinces;

public class Province {

    private Centroide centroide;
    private String id;
    private String nombre;

    public Province(Centroide centroide, String id, String nombre) {
        this.centroide = centroide;
        this.id = id;
        this.nombre = nombre;
    }

    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "centroide=" + centroide +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Centroide getCentroide() {
        return centroide;
    }

    public void setCentroide(Centroide centroide) {
        this.centroide = centroide;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
