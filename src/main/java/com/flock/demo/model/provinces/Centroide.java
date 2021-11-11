package com.flock.demo.model.provinces;

public class Centroide {

    private Double lat;
    private Double lon;

    public Centroide(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Centroide() {
    }

    @Override
    public String toString() {
        return "Centroide{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
