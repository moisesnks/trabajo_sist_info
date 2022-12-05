/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Frm;

import BO.ProductoBO;
import Clases.Producto;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ncmen
 */
public class Form_Agregar extends javax.swing.JDialog {

    /**
     * Creates new form jDialog_Agregar
     */
    public Form_Agregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        txt_valor_descuento.setEnabled(false);
        txt_id_producto.setEditable(false);
        txt_nombre_producto.setEditable(false);
        txt_valor_descuento.setEditable(false);
        txt_valor_producto.setEditable(false);
        rbtn_tiene_descuento.setSelected(false);
    }
    
    private ProductoBO pbo = new ProductoBO();
   
    public void a(JTextField t){
    
        t.setText("");
        t.setEditable(true);
    }
    
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_id_producto = new javax.swing.JTextField();
        txt_nombre_producto = new javax.swing.JTextField();
        txt_valor_producto = new javax.swing.JTextField();
        txt_valor_descuento = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        rbtn_tiene_descuento = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_producto.setText("ID Producto");
        txt_id_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_id_productoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_id_productoMouseEntered(evt);
            }
        });
        getContentPane().add(txt_id_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, -1));

        txt_nombre_producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre_producto.setText("Nombre Producto");
        txt_nombre_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nombre_productoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nombre_productoMouseEntered(evt);
            }
        });
        txt_nombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_productoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 210, -1));

        txt_valor_producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_valor_producto.setText("Valor Producto");
        txt_valor_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_valor_productoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_valor_productoMouseEntered(evt);
            }
        });
        getContentPane().add(txt_valor_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        txt_valor_descuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_valor_descuento.setText("Valor Descuento");
        txt_valor_descuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_valor_descuentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_valor_descuentoMouseEntered(evt);
            }
        });
        getContentPane().add(txt_valor_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 210, -1));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 226, -1, -1));

        rbtn_tiene_descuento.setText("Tiene Descuento");
        rbtn_tiene_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_tiene_descuentoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtn_tiene_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 153, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombre_productoActionPerformed
public void Agregar(JRadioButton rbtn){
        if(rbtn.isSelected()){
            //Todos los parametros
            String mensaje = "";
            Producto p = new Producto();
            p.setID_prod(txt_id_producto.getText());
            p.setNombre_prod(txt_nombre_producto.getText());
            p.setPrecio_prod(Integer.parseInt(txt_valor_producto.getText()));         
            p.setValor_descuento_prod(Integer.parseInt(txt_valor_descuento.getText()));
            p.setDescuento_prod(1);

            mensaje = pbo.agregarProducto(p);

            JOptionPane.showMessageDialog(null, mensaje);
        }
        else{
            //No tiene descuento
            System.out.println("no tiene descuento");
            String mensaje = "";
            Producto p = new Producto();
            p.setID_prod(txt_id_producto.getText());
            p.setNombre_prod(txt_nombre_producto.getText());
            p.setPrecio_prod(Integer.parseInt(txt_valor_producto.getText()));           
            p.setValor_descuento_prod(0);
            p.setDescuento_prod(0);

            mensaje = pbo.agregarProducto(p);

            JOptionPane.showMessageDialog(null, mensaje);
            
        }
               
 }

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        if(rbtn_tiene_descuento.isSelected()){
            //tiene todos los parametros y estan vacios
            if(txt_id_producto.getText().isEmpty() || txt_nombre_producto.getText().isEmpty() || txt_valor_producto.getText().isEmpty()
                    || txt_valor_descuento.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Para agregar un Producto", JOptionPane.WARNING_MESSAGE);
            }
            Agregar(rbtn_tiene_descuento);
        }
        else{
            //solo tiene id nombre y valor y estan vacios
            if(txt_id_producto.getText().isEmpty() || txt_nombre_producto.getText().isEmpty() || txt_valor_producto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Para agregar un Producto", JOptionPane.WARNING_MESSAGE);
                
            }
            Agregar(rbtn_tiene_descuento);
        }
        Form_Agregar.this.dispose();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_id_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_id_productoMouseClicked
        // TODO add your handling code here:
      a(txt_id_producto);
    }//GEN-LAST:event_txt_id_productoMouseClicked

    private void txt_nombre_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombre_productoMouseClicked
        // TODO add your handling code here:
      a(txt_nombre_producto);
    }//GEN-LAST:event_txt_nombre_productoMouseClicked

    private void txt_valor_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_valor_productoMouseClicked
        // TODO add your handling code here:
      a(txt_valor_producto);
    }//GEN-LAST:event_txt_valor_productoMouseClicked

    private void txt_valor_descuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_valor_descuentoMouseClicked
        // TODO add your handling code here:
        
        if(rbtn_tiene_descuento.isSelected()){
            
            a(txt_valor_descuento);
        }
 
     
    }//GEN-LAST:event_txt_valor_descuentoMouseClicked

    private void rbtn_tiene_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_tiene_descuentoActionPerformed
        // TODO add your handling code here:
        
        if(rbtn_tiene_descuento.isSelected()){
            
            txt_valor_descuento.setEnabled(true);
            txt_valor_descuento.setEditable(true);
            txt_valor_descuento.setText("Valor Descuento");
        }
        else{
            txt_valor_descuento.setEnabled(false);
            txt_valor_descuento.setEditable(false);
            txt_valor_descuento.setText("Valor Descuento");
            
        }
    }//GEN-LAST:event_rbtn_tiene_descuentoActionPerformed

    public void b(JTextField jt, String s){
        jt.setToolTipText(s);
    }
    
    private void txt_id_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_id_productoMouseEntered
        // TODO add your handling code here:
        
        b(txt_id_producto,"ID PRODUCTO");
    }//GEN-LAST:event_txt_id_productoMouseEntered

    private void txt_nombre_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombre_productoMouseEntered
        // TODO add your handling code here:
        b(txt_nombre_producto,"NOMBRE PRODUCTO");
    }//GEN-LAST:event_txt_nombre_productoMouseEntered

    private void txt_valor_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_valor_productoMouseEntered
        // TODO add your handling code here:
        b(txt_valor_producto,"VALOR PRODUCTO");
    }//GEN-LAST:event_txt_valor_productoMouseEntered

    private void txt_valor_descuentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_valor_descuentoMouseEntered
        // TODO add your handling code here:
        b(txt_valor_descuento, "VALOR DESCUENTO");
    }//GEN-LAST:event_txt_valor_descuentoMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_Agregar dialog = new Form_Agregar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JRadioButton rbtn_tiene_descuento;
    private javax.swing.JTextField txt_id_producto;
    private javax.swing.JTextField txt_nombre_producto;
    private javax.swing.JTextField txt_valor_descuento;
    private javax.swing.JTextField txt_valor_producto;
    // End of variables declaration//GEN-END:variables
}
