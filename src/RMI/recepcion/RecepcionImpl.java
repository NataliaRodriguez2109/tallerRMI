/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.recepcion;

import RMI.bodega.BodegaClient;
import RMI.georeferenciador.GeorefereciadorClient;
import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Paquete;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 
 *
 * @author nata_
 */
public class RecepcionImpl implements Recepcion{

    private GeorefereciadorClient GeorefereciadorClient;
    private BodegaClient BodegaClient;
    private TempRecepcion tempReception;
    
    public RecepcionImpl(String ip) {
        super();
        this.GeorefereciadorClient = new GeorefereciadorClient(ip);
        this.BodegaClient = new BodegaClient(ip);
        this.tempReception = new TempRecepcion(this);
        this.tempReception.start();
    }
    
    @Override
    public boolean registrarPaquete(Paquete paquete) throws RemoteException {
        this.tempReception.agregarPaquete(paquete);
        return true;
    }
    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        return this.GeorefereciadorClient.obtenerCiudades(nombreDepartamento);
    }
    
    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        return this.GeorefereciadorClient.obtenerDepartamentos();
    }

    @Override
    public boolean georeferenciarPaquete(Paquete paquete){
        return this.GeorefereciadorClient.georeferenciarPaquete(this, paquete);
    }
    
    public boolean guardarPaqueteBodega(Paquete paquete){
        this.BodegaClient.guardarPaquete(paquete);
        return true;
    }
    
}
