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

    private GeorefereciadorClient clienteGeorefereciador;
    private BodegaClient clienteBodega;
    private BufferRecepcion bufferRecepcion;
    
    public RecepcionImpl(String ip) {
        super();
        this.clienteGeorefereciador = new GeorefereciadorClient(ip);
        this.clienteBodega = new BodegaClient(ip);
        this.bufferRecepcion = new BufferRecepcion(this);
        this.bufferRecepcion.start();
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        return this.clienteGeorefereciador.obtenerCiudades(nombreDepartamento);
    }

    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        return this.clienteGeorefereciador.obtenerDepartamentos();
    }

    @Override
    public boolean registrarPaquete(Paquete paquete) throws RemoteException {
        this.bufferRecepcion.agregarPaquete(paquete);
        return true;
    }
    
    @Override
    public boolean georeferenciarPaquete(Paquete paquete){
        return this.clienteGeorefereciador.georeferenciarPaquete(this, paquete);
    }
    
    public boolean almacenarPaquete(Paquete paquete){
        //AQUI DEBO ENVIAR A LA BODEGA EL PAQUETE
        this.clienteBodega.almacenarPaquete(paquete);
        return true;
    }
    
}
