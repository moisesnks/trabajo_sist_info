/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

/**
 *
 * @author ncmen
 */
import Clases.Producto;
import java.sql.Connection;
import Clases.Conexion;
import DAO.ProductoDAO;
import javax.swing.JTable;
import java.sql.SQLException;
/**
 *
 * @author Moises
 */
public class ProductoBO {
    
    private String mensaje = "";
    private ProductoDAO pdao = new ProductoDAO();
    
    public String agregarProducto(Producto p){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = pdao.agregarProducto(conn, p);
            
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
    
    public String modificarProducto(Producto p){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = pdao.modificarProducto(conn, p);
            
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
    
    public String eliminarProducto(String ID_prod){
        Connection conn = Conexion.getConnection();
        
        try 
        {
            mensaje = pdao.eliminarProducto(conn, ID_prod);
            
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
    
    public void listarProductos(JTable tabla){
      Connection conn = Conexion.getConnection();
      pdao.listarProductos(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarFiltrado(JTable tabla, int d){
      Connection conn = Conexion.getConnection();
      pdao.listarFiltrado(conn, tabla, d);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void BuscarProducto(String ID_prod, JTable tabla){
        Connection conn = Conexion.getConnection();
        
        pdao.BuscarProducto(conn, ID_prod, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }}

