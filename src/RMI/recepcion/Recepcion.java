/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.recepcion;

import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Paquete;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 *
 * @author nata_
 */
public interface Recepcion extends Remote {
    ArrayList<Departamento> obtenerDepartamentos() throws RemoteException;
    ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException;
    boolean registrarPaquete(Paquete paquete) throws RemoteException;
    boolean georeferenciarPaquete(Paquete paquete) throws RemoteException;    
}
