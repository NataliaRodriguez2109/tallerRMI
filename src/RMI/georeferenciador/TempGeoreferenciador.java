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
        int i;
        while (true) {
            if (paquetes.size() >= 1) {
                try {                    
                    System.out.println("Georeferenciando");
                    Thread.sleep(Globales.TIEMPOGEOREFERENCIADOR);
                    Paquete paquete = paquetes.get(0);
                    paquete = this.destinarCiudad(paquete);
                    
                    int tiempo = Globales.TIEMPOGEOREFERENCIADOR;
                    System.out.println(tiempo);
                    for(i=0; i<tiempo; i++){
                        if(i == tiempo-1){
                            System.out.println("Tiempo de finalización: " + tiempo + " segundos");
                        }
                    }

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
