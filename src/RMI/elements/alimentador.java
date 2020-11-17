/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jesus David Otero
 */
public class alimentador {
    conexion c = new conexion();

    public alimentador() {
        c.getConn();
        String nombreFichero = ".\\src\\CO.txt";
        //Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            //Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            //Leer la primera línea, guardando en un String
            String texto = br.readLine();
            //Repetir mientras no se llegue al final del fichero
            while (texto != null) {
                //Hacer lo que sea con la línea leída
                
                String valores[] = texto.split("\t");
                System.out.println(valores[1]);
                //c.actualizar("INSERT INTO APP.CIUDADES (CIUDAD, DEPARTAMENTO, LATITUD, LONGITUD, CODIGO) VALUES ('" + valores[2] + "', '" + valores[3] + "', " + valores[9] + ", " + valores[10] + ", " + valores[1]+ ")");
                c.actualizar("INSERT INTO APP.departamentos (ID, NOMBRE) VALUES (" + valores[4] + ", '" + valores[3] + "')");
                //Leer la siguiente línea
                texto = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }
    public  ArrayList<Departamento> obtenerDepartamentos() throws SQLException {
        Statement statement;
        statement = c.getConn().createStatement();
        ArrayList<Departamento> departamentos = new ArrayList<>();
        String sql1 = "SELECT * FROM departamentos";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            departamentos.add(new Departamento(rs.getInt("id"), rs.getString("nombre")));
            System.out.println(rs.getInt("id") +"....."+rs.getString("nombre"));
        }
        return departamentos;
    }
        
    
    public static void main(String[] args) throws SQLException {
        alimentador ali = new alimentador();
        ali.obtenerDepartamentos();
    }
}
