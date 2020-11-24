/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.recepcion;

import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Paquete;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * 
 *
 * @author nata_
 */
public class RecepcionClient {

    private Recepcion recepcion;

    public RecepcionClient(String ip) {
        try {
            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            Registry registry = LocateRegistry.getRegistry(ip, 1710);
            System.out.println(ip);
            this.recepcion = (Recepcion) registry.lookup("Recepcion");
        } catch (RemoteException ex) {
            System.out.println("[Client Recepcion] (RemoteException): " + ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println("[Client Recepcion] (NotBoundException): " + ex.getMessage());
        }
    }
    
    public boolean registrarPaquete(Paquete paquete){
        try {
            return recepcion.georeferenciarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Client Recepcion] (RemoteException)1: " + ex.getMessage());
        }
        return false;
    }  

    public ArrayList<Departamento> obtenerDepartamentos() {
        try {                        
            return recepcion.obtenerDepartamentos();
        } catch (RemoteException ex) {
            System.out.println("[Client Recepcion] (RemoteException)2: " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) {
        try {
            return recepcion.obtenerCiudades(nombreDepartamento);
        } catch (RemoteException ex) {
            System.out.println("[Client Recepcion] (RemoteException)3: " + ex.getMessage());
        }
        return null;
    }    

}
