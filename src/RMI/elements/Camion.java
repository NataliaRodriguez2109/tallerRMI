/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.elements;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public class Camion implements Serializable {

    private int id;
    private double capacidad;
    private ArrayList<Paquete> paquetes;

    public Camion(int id, double capacidad, ArrayList<Paquete> paquetes) {
        this.id = id;
        this.capacidad = capacidad;
        this.paquetes = paquetes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
