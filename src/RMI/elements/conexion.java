/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jesus David Otero
 */
public class conexion {
    
    private Connection conn = null;
    
    
    public Connection getConn(){
        try{
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://25.109.204.202:1527/distribuidos");
            System.out.println("ON");
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return conn;
    }
    
    public ResultSet consulta(String consulta){
        ResultSet rs = null;
        try{
            PreparedStatement ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();                       
            System.out.println("buenaaaaa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public boolean actualizar(String query){        
        try{
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.executeUpdate(); 
            
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
