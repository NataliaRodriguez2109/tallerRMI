/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.georeferenciador;

import RMI.elements.Ciudad;
import RMI.elements.Globales;
import RMI.elements.Paquete;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public class TempGeoreferenciador extends Thread {

    private ArrayList<Paquete> paquetes;
    private GeoreferenciadorImplementacion georeferenciadorImpl;
    private Paquete paquete1;
    private Ciudad ciudad1;

    public TempGeoreferenciador(GeoreferenciadorImplementacion georeferenciadorImpl) {
        this.georeferenciadorImpl = georeferenciadorImpl;
        this.paquetes = new ArrayList<>();
    }
    
    public void guardarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
        System.out.println(paquete.getCiudadEmisor());
    }

    private void georeferenciar() {
        while (true) {
            if (paquetes.size() >= 1) {
                try {                    
                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Globales.TIEMPOGEOREFERENCIADOR);
                    Paquete paquete = paquetes.get(0);
                    paquete = this.destinarCiudad(paquete);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetes.remove(paquete);

                    this.georeferenciadorImpl.agregarPaqueteACola(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Server Georeferenciador] (InterruptedException) " + ex.getMessage());
                }
            } else {
                System.getProperties();
            }
        }
    }
    
    private Paquete destinarCiudad(Paquete paquete) {
        Ciudad ciudad = this.georeferenciadorImpl.obtenerCiudad(paquete.getCiudadReceptor(), paquete.getDepartamentoReceptor());
        paquete.setCoordenadas(ciudad.getCoordenadas());
        return paquete;
    }

    @Override
    public void run() {
        georeferenciar();
    }
}
