/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.georeferenciador;

import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Paquete;
import RMI.recepcion.Recepcion;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 * @author nata_
 */
public class GeoreferenciadorImpl implements Georeferenciador {

    private BufferGeoreferenciador bufferGeoreferenciador;
    private Recepcion recepcion;    
    private UbicacionBD udb;
    
    public GeoreferenciadorImpl() {
        super();
        udb = new UbicacionBD();
        udb.connect();
        this.bufferGeoreferenciador = new BufferGeoreferenciador(this);
        this.bufferGeoreferenciador.start();
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        try {
            return udb.obtenerCiudades(nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException1)");
        }
        return null;
    }

    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        try {
            return udb.obtenerDepartamentos();
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException2)");
        }
        return null;
    }

    @Override
    public boolean georeferenciarPaquete(Recepcion recepcion, Paquete paquete) throws RemoteException {
        this.recepcion = recepcion;
        this.bufferGeoreferenciador.agregarPaquete(paquete);
        return true;
    }

    public Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) {
        try {
            return udb.obtenerCiudad(nombreCiudad, nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Servidor] (SQLException)");
        }
        return null;
    }

    public boolean encolarPaquete(Paquete paquete){
        try {
            this.recepcion.registrarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Servidor] (RemoteException)");
        }
        return true;
    }

    
}
