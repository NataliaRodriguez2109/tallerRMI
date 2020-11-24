/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.bodega;

import RMI.elements.Camion;
import RMI.elements.Globales;
import RMI.elements.Paquete;
import RMI.elements.Coordenadas;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public class BodegaImplementacion implements Bodega {

    private ArrayList<Paquete> paquetesBodega;
    
    private TempBodega tempBodega;
    
    private ArrayList<Camion> camiones;

    public BodegaImplementacion() {
        this.paquetesBodega = new ArrayList<>();
        this.camiones = new ArrayList<>();
        this.tempBodega = new TempBodega(this);
        this.tempBodega.start();
    }

    @Override
    public boolean guardarPaquete(Paquete paquete) throws RemoteException {
        this.tempBodega.añadirPaquete(paquete);
        return true;
    }

    public boolean guardarEnBodega(Paquete paquete) {
        paquete.setEstado(Globales.ESTADO_ALMACENADO);
        this.paquetesBodega.add(paquete);
        return true;
    }
    
    @Override
    public boolean solicitarEnvio(Coordenadas ubicacion, double peso) throws RemoteException {
        this.tempBodega.agregarPaquetesEnviar(this.paquetesBodega, ubicacion, peso);
        return true;
    }
    
    public boolean enviarPaquetes(ArrayList<Paquete> paquetesEnviar, ArrayList<Paquete> paquetesBodega, double capacidad){
        this.paquetesBodega = paquetesBodega;
        camiones.add(new Camion(camiones.size()+1, capacidad, paquetesEnviar));
        return true;
    }

    @Override
    public ArrayList<Paquete> obtenerPBodega() throws RemoteException {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        for(Paquete paquete : this.paquetesBodega){
            paquetes.add(paquete);
        }
        return paquetes;
    }

    

    @Override
    public ArrayList<Camion> Camiones() throws RemoteException {
        return this.camiones;
    }
}
