/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.elements;

import java.io.Serializable;

/**
 *
 *
 * @author nata_
 */
public class Ciudad implements Serializable {

    private String nombre;
    private String departamento;
    private Coordenadas coordenadas;
    private int codigo;

    public Ciudad(String nombre, String departamento, Coordenadas coordenadas, int codigo) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.coordenadas = coordenadas;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

}
