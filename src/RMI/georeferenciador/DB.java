/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.georeferenciador;

import RMI.elements.Ciudad;
import RMI.elements.Departamento;
import RMI.elements.Coordenadas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 *
 * @author nata_
 */
public class DB {

    private static Connection connection;
    private static Statement statement;

    public static Connection connect() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
            System.exit(1);
        }

        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/distribuidos");

            statement = connection.createStatement();

            statement.setQueryTimeout(30);
            return connection;
        } catch (SQLException e) {
            System.err.println("[Server] (SQLException) " + e.getMessage());
            return connection;
        }
    }

    public static ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws SQLException {
        nombreDepartamento = nombreDepartamento.trim();
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ciudades WHERE departamento = '" + nombreDepartamento + "'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ciudad city = new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), new Coordenadas(rs.getDouble("latitud"), rs.getDouble("longitud")), rs.getInt("codigo"));
            boolean bandera = false;
            for (int i = 0; i < ciudades.size(); i++) {
                if (ciudades.get(i).getNombre().equals(city.getNombre())) {
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                ciudades.add(city);
            }
            System.out.println(rs.getString("ciudad"));
        }
        return ciudades;
    }

    public static ArrayList<Departamento> obtenerDepartamentos() throws SQLException {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM departamentos");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            departamentos.add(new Departamento(rs.getInt("id"), rs.getString("nombre")));

        }
        return departamentos;
    }

    public static Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) throws SQLException {
        nombreCiudad = nombreCiudad.trim();
        nombreDepartamento = nombreDepartamento.trim();
        String sql1 = "SELECT * FROM ciudades WHERE ciudad = '" + nombreCiudad + "' and departamento = '" + nombreDepartamento + "'";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            return new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), new Coordenadas(rs.getDouble("latitud"), rs.getDouble("longitud")), rs.getInt("codigo"));
        }
        return null;
    }

    public static ArrayList<String> obtenerLatiLong(String ciudad) throws SQLException {
        ciudad = ciudad.trim();
        ArrayList<String> latiLong = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ciudades WHERE ciudad = '" + ciudad + "'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            latiLong.add(rs.getDouble("latitud")+", "+rs.getDouble("longitud"));            
        }
        return latiLong;
    }

}
