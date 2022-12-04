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
import Clases.Cliente;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Moises
 */
public class ClienteDAO 
{
    private String mensaje = "";
    
    public String agregarCliente(Connection con, Cliente c){
        PreparedStatement pst = null;
        String sql = "INSERT INTO CLIENTE (RUT_CLIENTE, NOMBRE, APELLIDO_MAT, APELLIDO_PAT, CORREO)"
                    + "VALUES (?, ?, ?, ?, ?)";
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getRut());
            pst.setString(2, c.getNombres());
            pst.setString(3, c.getApellido_mat());
            pst.setString(4, c.getApellido_pat());
            pst.setString(5, c.getCorreo());
            //pst.setInt(6,c.getId_plan());
            
            mensaje = "Guardado con éxito";
            
            pst.execute();
            pst.close();
            
            
        } catch (SQLException e)
        {
            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public String modificarCliente(Connection con, Cliente c){
        PreparedStatement pst = null;
        String sql = "UPDATE CLIENTE SET NOMBRE = ?, APELLIDO_MAT = ?, APELLIDO_PAT = ?, CORREO = ?"
                   + "WHERE rut_cliente = ?";
        
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNombres());
            pst.setString(2, c.getApellido_mat());
            pst.setString(3, c.getApellido_pat());
            pst.setString(4, c.getCorreo());
            pst.setInt(5, c.getRut());
            //pst.setInt(6,c.getId_plan());
            
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
    
    public String eliminarCliente(Connection con, int id){
        PreparedStatement pst = null;
        String sql = "DELETE FROM CLIENTE WHERE rut_cliente = ?";
        Statement st = null;
        ResultSet rs = null;
        
        try 
        {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            mensaje = "Eliminado correctamente.";
            
            pst.execute();
            pst.close();
            
            
        } catch (SQLException e)
        {
            mensaje = "No se pudo eliminar correctamente \n " + e.getMessage();
        }
        
        return mensaje;
    }
    
    public void listarCliente(Connection con, JTable tabla)
    {
        DefaultTableModel model;
        String [] columnas = {"RUT", "NOMBRES", "APELLIDO_PAT", "APELLIDO_MAT", "CORREO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM CLIENTE ORDER BY APELLIDO_PAT";
        //String sql = "select rut_cliente as RUT, apellido_pat || ' ' || apellido_mat as APELLIDOS, nombre as NOMBRES, correo as CORREO from cliente order by apellido_pat";
        
        String [] filas = new String[5];
        //String [] filas = new String[4];
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                for (int i = 0; i < 5; i++) {
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO se puede listar la tabla");
        }
    }
    
    public void BuscarCliente(Connection con, int id, JTable tabla)
    {
        
        DefaultTableModel model;
        String [] columnas = {"RUT", "NOMBRES", "APELLIDO_PAT", "APELLIDO_MAT", "CORREO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM CLIENTE WHERE RUT_CLIENTE ="+id;
        //String sql = "select rut_cliente as RUT, apellido_pat || ' ' || apellido_mat as APELLIDOS, nombre as NOMBRES, correo as CORREO from cliente order by apellido_pat";
        
        String [] filas = new String[5];
        //String [] filas = new String[4];
        
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while (rs.next()){
                for (int i = 0; i < 5; i++) {
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
