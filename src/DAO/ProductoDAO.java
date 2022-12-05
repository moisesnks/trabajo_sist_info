/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Moises
 */
import java.sql.Connection;
import Clases.Producto;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 *
 * @author Moises
 */
public class ProductoDAO 
{
    private String mensaje = "";
    
    public String agregarProducto(Connection con, Producto p){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PRODUCTOS (ID_PROD, NOMBRE_PROD, PRECIO_PROD, VALOR_DESCUENTO, TIENE_DESCUENTO)"
                    + "VALUES (?, ?, ?, ?, ?)";
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getID_prod());
            pst.setString(2, p.getNombre_prod());
            pst.setInt(3, p.getPrecio_prod());
            pst.setInt(4, p.getValor_descuento_prod());
            pst.setInt(5, p.getDescuento_prod());
            //pst.setInt(6,p.getId_plan());
            
            mensaje = "Guardado con éxito";
            
            pst.execute();
            pst.close();
            
            
        } catch (SQLException e)
        {
            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String modificarProducto(Connection con, Producto p){
        PreparedStatement pst = null;
        String sql = "UPDATE PRODUCTOS SET NOMBRE_PROD = ?, PRECIO_PROD = ?, TIENE_DESCUENTO = ?, VALOR_DESCUENTO = ?"
                   + "WHERE ID_PROD = ?";
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getNombre_prod());
            pst.setInt(2, p.getPrecio_prod());
            pst.setInt(3, p.getDescuento_prod());
            pst.setInt(4, p.getValor_descuento_prod());
            pst.setString(5, p.getID_prod());
            //pst.setInt(6,p.getId_plan());
            
            pst.execute();
            mensaje = "Actualizado correctamente.";
            pst.close();
            
            
        } catch (SQLException e)
        {
            mensaje = "No se pudo actualizar correctamente \n " + e.getMessage();
            System.out.println(mensaje);
        }
        
        return mensaje;
    }
    
    public String eliminarProducto(Connection con, String id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM PRODUCTOS WHERE ID_PROD = ?";
        Statement st = null;
        ResultSet rs = null;
        
        try 
        {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            
            mensaje = "Eliminado correctamente.";
            
            pst.execute();
            pst.close();
            
            
        } catch (SQLException e)
        {
            mensaje = "No se pudo eliminar correctamente \n " + e.getMessage();
        }
        
        return mensaje;
    }
    private int n;
    public void listarProductos(Connection con, JTable tabla)
    {
        DefaultTableModel model;
        String [] columnas = {"ID", "NOMBRE", "PRECIO", "VALOR DESCUENTO"};
        List <String> list = new ArrayList <String>(Arrays.asList(columnas));
        n = list.size();
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PRODUCTOS ORDER BY ID_PROD";
        //String sql = "select rut_cliente as RUT, apellido_pat || ' ' || apellido_mat as APELLIDOS, nombre as NOMBRES, correo as CORREO from cliente order by apellido_pat";
       
        String [] filas = new String[n];
      
        //String [] filas = new String[4];
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                for(int i = 0 ; i<n ; i++){
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO se puede listar la tabla");
        }
    }
    
    public void listarFiltrado(Connection con, JTable tabla, int d)
    {
        DefaultTableModel model;
    
        
        String [] columnas = {"ID", "NOMBRE", "PRECIO", "VALOR DESCUENTO"};
        List <String> list = new ArrayList <String>(Arrays.asList(columnas));
        if(d==1){
             n = list.size();
          
            
        }
        else{
            
            
            list.remove(3);
            columnas = list.toArray(new String[0]);
            
            n = list.size();
           
        
        }
        
         
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PRODUCTOS WHERE TIENE_DESCUENTO="+d+"ORDER BY ID_PROD";
        //String sql = "select rut_cliente as RUT, apellido_pat || ' ' || apellido_mat as APELLIDOS, nombre as NOMBRES, correo as CORREO from cliente order by apellido_pat";
        
        String [] filas = new String[n];
       
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                for(int i = 0 ; i<n ; i++){
                    filas[i] = rs.getString(i+1);
                }
                
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO se puede listar la tabla");
        }
    }
    
    public void BuscarProducto(Connection con, String id, JTable tabla)
    {
        
        DefaultTableModel model;
        String [] columnas = {"ID", "NOMBRE", "PRECIO", "VALOR DESCUENTO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PRODUCTOS WHERE ID_PROD ="+id;
        //String sql = "select rut_cliente as RUT, apellido_pat || ' ' || apellido_mat as APELLIDOS, nombre as NOMBRES, correo as CORREO from cliente order by apellido_pat";
        
        String [] filas = new String[4];
        //String [] filas = new String[4];
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO EXISTE REGISTRO DE ESE CLIENTE");
        }
        
    }
}

