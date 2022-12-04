/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Clases.Cliente;
import java.sql.Connection;
import DAO.ClienteDAO;
import Clases.Conexion;
import javax.swing.JTable;
import java.sql.SQLException;
/**
 *
 * @author Moises
 */
public class ClienteBO {
    
    private String mensaje = "";
    private ClienteDAO cdao = new ClienteDAO();
    
    public String agregarCliente(Cliente c){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = cdao.agregarCliente(conn, c);
            
        } catch (Exception e)
        {
            mensaje = mensaje + " " + e.getMessage();
        } finally{
            try{
                if ( conn != null ){
                    conn.close();
                }
                
            } catch (SQLException e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
}
    
    public String modificarCliente(Cliente c){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = cdao.modificarCliente(conn, c);
            
        } catch (Exception e)
        {
            mensaje = mensaje + " " + e.getMessage();
        } finally{
            try{
                if ( conn != null ){
                    conn.close();
                }
                
            } catch (SQLException e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarCliente(int id){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = cdao.eliminarCliente(conn, id);
            
        } catch (Exception e)
        {
            mensaje = mensaje + " " + e.getMessage();
        } finally{
            try{
                if ( conn != null ){
                    conn.close();
                }
                
            } catch (SQLException e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarCliente(JTable tabla){
      Connection conn = Conexion.getConnection();
      cdao.listarCliente(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void BuscarCliente(int id, JTable tabla){
        Connection conn = Conexion.getConnection();
        
        cdao.BuscarCliente(conn, id, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}