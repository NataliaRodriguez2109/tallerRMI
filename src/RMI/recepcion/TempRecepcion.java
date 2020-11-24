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
public class TempRecepcion extends Thread {

    private RecepcionImplementacion recepcionImpl;
    private ArrayList<Paquete> paquetes;
    

    public TempRecepcion(RecepcionImplementacion recepcionImpl) {
        this.recepcionImpl = recepcionImpl;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    private void registrarPaquete() {
        int i;
        while (true) {
            if (paquetes.size() >= 1) {
                try {
                    System.out.println("Registrando paquete");

                    Thread.sleep(Globales.TIEMPOREGISTRO);
                    Paquete paquete = paquetes.get(0);

                    int tiempo = Globales.TIEMPOREGISTRO;
                    for(i=0; i<tiempo; i++){
                        if(i == tiempo-1){
                            System.out.println("Registro finalizado en: " + tiempo + " segundos");
                        }
                    }

                    this.paquetes.remove(paquete);
                    
                    this.recepcionImpl.guardarPaqueteBodega(paquete);
                } catch (InterruptedException ex) {
                    System.out.println("[Server Recepcion] (InterruptedException)");
                }
            }else{
                System.getProperties();
            }
        }
    }

    @Override
    public void run() {
        registrarPaquete();
    }
}
