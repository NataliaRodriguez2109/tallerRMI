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

    private void tareasBodega() {
        int i;
        while (true) {
            if (paquetesAlmacen.size() >= 1) {
                try {
                    System.out.println("Almacenando en bodega");
                    Thread.sleep(Globales.TIEMPOALMACENAMIENTO);
                    Paquete paquete = paquetesAlmacen.get(0);

                    int tiempo = Globales.TIEMPOALMACENAMIENTO;
                    System.out.println(tiempo);
                    for(i=0; i<tiempo; i++){
                        if(i == tiempo-1){
                            System.out.println("Almacenamiento finalizado en: " + tiempo + " segundos");
                        }
                    }

                    this.paquetesAlmacen.remove(paquete);

                    this.bodegaImpl.guardarEnBodega(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor Bodega] (InterruptedException) " + ex.getMessage());
                }
            }
            if (paquetesEnvio != null && this.estado) {
                try {
                    this.estado = false;
                    System.out.println("Preparando envio");
                    Thread.sleep(Globales.TIEMPOPREPARACIONENVIO);

                    this.procesarEnvio();

                    int tiempo = Globales.TIEMPOPREPARACIONENVIO;
                    System.out.println(tiempo);
                    for(i=0; i<tiempo; i++){
                        if(i == tiempo-1){
                            System.out.println("Preparación del envio finalizado en: " + tiempo + " segundos");
                        }
                    }

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
        tareasBodega();
    }
}
