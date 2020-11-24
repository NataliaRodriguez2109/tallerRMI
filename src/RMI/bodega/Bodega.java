/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.bodega;

import RMI.elements.Camion;
import RMI.elements.Paquete;
import RMI.elements.Coordenadas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author nata_
 */
public interface Bodega extends Remote{
    boolean guardarPaquete(Paquete paquete) throws RemoteException;
    ArrayList<Paquete> obtenerPBodega() throws RemoteException;
    ArrayList<Camion> Camiones() throws RemoteException;
    boolean solicitarEnvio(Coordenadas ubicacion, double peso) throws RemoteException;
}
