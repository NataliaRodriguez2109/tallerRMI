/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.bodega;

import RMI.elements.Camion;
import RMI.elements.Paquete;
import RMI.elements.Coordenadas;
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
            System.out.println("[Client Bodega] Especificando el nombre de la politica de seguridad.");
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1525);
            this.bodega = (Bodega) registry.lookup("Bodega");
        } catch (RemoteException ex) {
            System.out.println("[Client Bodega] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Client Bodega] (NotBoundException): " + ex.getMessage());
        }
    }

    
    public boolean solicitarEnvioPaquetes(Coordenadas ubicacion, double peso){
        try {
            return this.bodega.solicitarEnvio(ubicacion, peso);
        } catch (RemoteException ex) {
            System.out.println("[Client Bodega] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
    
    public ArrayList<Paquete> obtenerPBodega(){
        try {
            return this.bodega.obtenerPBodega();
        } catch (RemoteException ex) {
            System.out.println("[Client Bodega] (RemoteException): " + ex.getMessage());
        }
        return null;
    }
    
     public boolean guardarPaquete(Paquete paquete) {
        try {
            return bodega.guardarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Client Bodega] (RemoteException): " + ex.getMessage());
        }
        return false;
    }
    
    
    
    public ArrayList<Camion> Camiones() {
        try {
            return this.bodega.Camiones();
        } catch (RemoteException ex) {
            System.out.println("[Client Bodega] (RemoteException): " + ex.getMessage());
        }
        return null;
    }
}
