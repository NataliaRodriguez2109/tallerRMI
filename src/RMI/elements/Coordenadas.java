/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.elements;

import java.io.Serializable;

/**
 *
 * @author nata_
 */
public class Coordenadas implements Serializable {

    private double latitud;
    private double longitud;

    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public double calcularDistancia(double latitud1, double latitud2, double longitud1, double longitud2) {
        double r = 6371;
        longitud1 = Math.toRadians(longitud1);
        longitud2 = Math.toRadians(longitud1);
        latitud1 = Math.toRadians(latitud1);
        latitud2 = Math.toRadians(latitud2);

        double distanciaLong = longitud2 - longitud1;
        double distanciaLat = latitud2 - latitud1;
        double s = Math.pow(Math.sin(distanciaLat / 2), 2)
                + Math.cos(latitud1) * Math.cos(latitud2)
                * Math.pow(Math.sin(distanciaLong / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(s));
        
        return (c * r);
    }
}
