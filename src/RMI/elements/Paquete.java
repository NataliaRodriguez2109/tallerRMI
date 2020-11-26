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
public class Paquete implements Serializable{

    private String nombreEmisor;
    private String departamentoEmisor;
    private String ciudadEmisor;
    private String nombreReceptor;
    private String departamentoReceptor;
    private String ciudadReceptor;
    private Coordenadas coordenadas;
    private String fechaRecibido;
    private String fechaEnvio;
    private String estado;
    private double peso;
    private double distanciaDestino;
    
    public Paquete(String nombreEmisor, String departamentoEmisor, String ciudadEmisor, String nombreReceptor, String departamentoReceptor, String ciudadReceptor, double peso) {
        this.nombreEmisor = nombreEmisor;
        this.ciudadEmisor = ciudadEmisor;
        this.nombreReceptor = nombreReceptor;
        this.ciudadReceptor = ciudadReceptor;
        this.departamentoReceptor = departamentoReceptor;
        this.peso = peso;
        this.estado = "";
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getDepartamentoEmisor() {
        return departamentoEmisor;
    }

    public void setDepartamentoEmisor(String departamentoEmisor) {
        this.departamentoEmisor = departamentoEmisor;
    }

    public String getCiudadEmisor() {
        return ciudadEmisor;
    }

    public void setCiudadEmisor(String ciudadEmisor) {
        this.ciudadEmisor = ciudadEmisor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getDepartamentoReceptor() {
        return departamentoReceptor;
    }

    public void setDepartamentoReceptor(String departamentoReceptor) {
        this.departamentoReceptor = departamentoReceptor;
    }

    public String getCiudadReceptor() {
        return ciudadReceptor;
    }

    public void setCiudadReceptor(String ciudadReceptor) {
        this.ciudadReceptor = ciudadReceptor;
    }

    public String getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(String fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double getDistanciaDestino() {
        return distanciaDestino;
    }

    public void setDistanciaDestino(double distanciaDestino) {
        this.distanciaDestino = distanciaDestino;
    }

}
