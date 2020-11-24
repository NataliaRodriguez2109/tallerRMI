/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.georeferenciador;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 *
 * @author nata_
 */
public class GeoreferenciadorServer {

    private String ip;

    public GeoreferenciadorServer(String ip) {
        this.ip = ip;
    }

    public void iniciarServicios() {
        System.out.println("[Server Georeferenciador] Establecer a través de cual interfaz de red del servidor ser recibirán peticiones.");
        System.setProperty("java.rmi.server.hostname", this.ip);
        
        System.out.println("[Server Georeferenciador] Especificando el nombre de la politica de seguridad.");
        System.setProperty("java.security.policy", "server.policy");
        
        System.out.println("[Server Georeferenciador] Estableciendo el manejador de seguridad.");
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        
        try{
            System.out.println("[Server Georeferenciador] Instanciado el objeto que va a ser accedido remotamente.");
            Georeferenciador georeferenciador = new GeoreferenciadorImpl();
            
            System.out.println("[Server Georeferenciador] Creando el 'stub' del objeto que va a ser accedido remotamente.");
            Georeferenciador stub = (Georeferenciador) UnicastRemoteObject.exportObject(georeferenciador,0);
            
            System.out.println("[Server Georeferenciador] Iniciando su propio servicio de RMI Registry.");
            Registry registry = LocateRegistry.createRegistry(1099);
            
            System.out.println("[Server Georeferenciador] Publicando el stub del objeto remoto en el RMI Registry.");
            registry.rebind("Georeferenciador", stub);
            
            System.out.println("[Server Georeferenciador] Servidor del georeferenciador listo!");
        }catch(RemoteException e) {
            System.out.println("[Server Georeferenciador] (RemoteException): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GeoreferenciadorServer georeferenciadorServidor = new GeoreferenciadorServer("127.0.0.1");
        georeferenciadorServidor.iniciarServicios();
    }
}
