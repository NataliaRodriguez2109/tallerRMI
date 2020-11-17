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
    private Ubicacion ubicacion;
    private int codigo;

    public Ciudad(String nombre, String departamento, Ubicacion ubicacion, int codigo) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.ubicacion = ubicacion;
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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

}
