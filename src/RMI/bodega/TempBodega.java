/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.bodega;

import RMI.elements.Globales;
import RMI.elements.Paquete;
import RMI.elements.Coordenadas;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nata_
 */
public class TempBodega extends Thread {

    private BodegaImplementacion bodegaImpl;
    private Coordenadas ubicacion;
    private boolean estado;
    private ArrayList<Paquete> paquetesAlmacen;
    private double pesoP;
    private ArrayList<Paquete> paquetesEnvio;

    public TempBodega(BodegaImplementacion bodegaImpl) {
        this.bodegaImpl = bodegaImpl;
        this.paquetesAlmacen = new ArrayList<>();
        this.estado = true;
    }

    public void añadirPaquete(Paquete paquete) {
        this.paquetesAlmacen.add(paquete);
    }

    public void agregarPaquetesEnviar(ArrayList<Paquete> paquetesEnviar, Coordenadas ubicacion, double peso) {
        this.paquetesEnvio = paquetesEnviar;
        this.ubicacion = ubicacion;
        this.pesoP = peso;
    }

    private void procesarEnvio() {
        ArrayList<Paquete> paquetesBodega = new ArrayList<>();
        for (Paquete paquete : paquetesEnvio) {
            paquete.setDistanciaDestino(ubicacion.calcularDistancia(paquete.getCoordenadas().getLatitud(),
                    ubicacion.getLatitud(), paquete.getCoordenadas().getLongitud(), ubicacion.getLongitud()));
        }
        
        Collections.sort(paquetesEnvio);
        double pesoTotal = 0;
        for (Paquete paquete : paquetesEnvio) {
            if (pesoTotal + paquete.getPeso() <= pesoP) {
                pesoTotal += paquete.getPeso();
                paquete.setEstado(Globales.ESTADO_ENVIADO);
                paquete.setFechaEnvio(java.time.LocalDate.now()+"");
            } else {
                paquetesBodega.add(paquete);
                paquetesEnvio.remove(paquete);
            }
        }
        this.bodegaImpl.enviarPaquetes(this.paquetesEnvio, paquetesBodega, pesoP);
        this.estado = true;
    }

    private void procesosBodega() {
        while (true) {
            if (paquetesAlmacen.size() >= 1) {
                try {
                    System.out.println("Almacenando en bodega");

                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Globales.TIEMPOALMACENAMIENTO);
                    Paquete paquete = paquetesAlmacen.get(0);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetesAlmacen.remove(paquete);

                    this.bodegaImpl.guardarEnBodega(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor] (InterruptedException) " + ex.getMessage());
                }
            }
            if (paquetesEnvio != null && this.estado) {
                try {
                    this.estado = false;
                    System.out.println("Preparando envio");
                    
                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Globales.TIEMPOPREPARACIONENVIO);

                    this.procesarEnvio();

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetesEnvio = null;
                } catch (InterruptedException ex) {
                    System.out.println("[Server Bodega] (InterruptedException) " + ex.getMessage());
                }
            } else {
                System.getProperties();
            }
        }
    }

    @Override
    public void run() {
        procesosBodega();
    }
}
