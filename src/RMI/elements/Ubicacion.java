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
public class Ubicacion implements Serializable {

    private double latitud;
    private double longitud;

    public Ubicacion(double latitud, double longitud) {
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

    //https://www.geeksforgeeks.org/program-distance-two-points-earth/
    public double calcularDistancia(double latitud1, double latitud2, double longitud1, double longitud2) {
        longitud1 = Math.toRadians(longitud1);
        longitud2 = Math.toRadians(longitud1);
        latitud1 = Math.toRadians(latitud1);
        latitud2 = Math.toRadians(latitud2);

        double dlon = longitud2 - longitud1;
        double dlat = latitud2 - latitud1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(latitud1) * Math.cos(latitud2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956  
        // for miles 
        double r = 6371;

        // calculate the result 
        return (c * r);
    }
}
