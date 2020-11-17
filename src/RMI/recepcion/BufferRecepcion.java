/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.recepcion;

import RMI.elements.Globales;
import RMI.elements.Paquete;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public class BufferRecepcion extends Thread {

    private ArrayList<Paquete> paquetes;
    private RecepcionImpl recepcionImpl;

    public BufferRecepcion(RecepcionImpl recepcionImpl) {
        this.recepcionImpl = recepcionImpl;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    private void registrar() {
        while (true) {
            if (paquetes.size() >= 1) {
                try {
                    System.out.println("#############################");
                    System.out.println("Iniciando registro de paquete");

                    long inicio = System.currentTimeMillis();
                    Thread.sleep(Globales.TIEMPO_REGISTRO);
                    Paquete paquete = paquetes.get(0);

                    long fin = System.currentTimeMillis();
                    double tiempo = (double) ((fin - inicio) / 1000);
                    System.out.println("fin: " + tiempo + " segundos");

                    this.paquetes.remove(paquete);
                    
                    this.recepcionImpl.almacenarPaquete(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Servidor] (InterruptedException)");
                }
            }else{
                System.getProperties();
            }
        }
    }

    @Override
    public void run() {
        registrar();
    }
}
