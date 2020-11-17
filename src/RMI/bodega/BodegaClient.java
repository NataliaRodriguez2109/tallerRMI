/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.bodega;

import RMI.elements.Camion;
import RMI.elements.Paquete;
import RMI.elements.Ubicacion;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public class BodegaClient {

    private Bodega bodega;

    public BodegaClient(String ip) {
        try {
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1525);
            this.bodega = (Bodega) registry.lookup("Bodega");
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Cliente] (NotBoundException): " + ex.getMessage());
        }
    }

    public boolean almacenarPaquete(Paquete paquete) {
        try {
            return bodega.almacenarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
    
    public ArrayList<Paquete> obtenerPaquetesBodega(){
        try {
            return this.bodega.obtenerPaquetesBodega();
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return null;
    }
    
    public boolean solicitarEnvioPaquetes(Ubicacion ubicacion, double peso){
        try {
            return this.bodega.solicitarEnvio(ubicacion, peso);
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
    
    public ArrayList<Camion> Camiones() {
        try {
            return this.bodega.Camiones();
        } catch (RemoteException ex) {
            System.out.println("[Cliente] (RemoteException): " + ex.getMessage());
        }
        return null;
    }
}
