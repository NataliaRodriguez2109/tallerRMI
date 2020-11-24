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
public class GeoreferenciadorImplementacion implements Georeferenciador {

    private TempGeoreferenciador tempGeoreferenciador;
    private Recepcion recepcion;    
    private DB udb;
    
    public GeoreferenciadorImplementacion() {
        super();
        udb = new DB();
        udb.connect();
        this.tempGeoreferenciador = new TempGeoreferenciador(this);
        this.tempGeoreferenciador.start();
    }
     @Override
    public boolean georeferenciarPaquete(Recepcion recepcion, Paquete paquete) throws RemoteException {
        this.recepcion = recepcion;
        this.tempGeoreferenciador.guardarPaquete(paquete);
        return true;
    }

    public Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) {
        try {
            return udb.obtenerCiudad(nombreCiudad, nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Server Georeferenciador] (SQLException)");
        }
        return null;
    }

    @Override
    public ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws RemoteException {
        try {            
            return udb.obtenerCiudades(nombreDepartamento);
        } catch (SQLException ex) {
            System.out.println("[Server Georeferenciador] (SQLException1)");
        }
        return null;
    }

    @Override
    public ArrayList<Departamento> obtenerDepartamentos() throws RemoteException {
        try {
            return udb.obtenerDepartamentos();
        } catch (SQLException ex) {
            System.out.println("[Server Georeferenciador] (SQLException2)");
        }
        return null;
    }

   

    public boolean agregarPaqueteACola(Paquete paquete){
        try {
            this.recepcion.registrarPaquete(paquete);
        } catch (RemoteException ex) {
            System.out.println("[Server Georeferenciador] (RemoteException)");
        }
        return true;
    }

    
}
