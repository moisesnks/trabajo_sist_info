/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ncmen
 */
public class Producto {
    private String ID_prod;
    private String nombre_prod;
    private int precio_prod;
    private int descuento_prod;
    private int valor_descuento_prod;


    public Producto() {
    }
    
    public Producto (String ID_prod, String nombre_prod, int precio_prod, int descuento_prod , int valor_descuento_prod) {
        this.ID_prod = ID_prod;
        this.nombre_prod = nombre_prod;
        this.precio_prod = precio_prod;
        this.descuento_prod = descuento_prod;
        this.valor_descuento_prod = valor_descuento_prod;
    }

    public String getID_prod() {
        return ID_prod;
    }

    public void setID_prod(String ID_prod) {
        this.ID_prod = ID_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public int getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(int precio_prod) {
        this.precio_prod = precio_prod;
    }

    public int getDescuento_prod() {
        return descuento_prod;
    }

    public void setDescuento_prod(int descuento_prod) {
        this.descuento_prod = descuento_prod;
    }

    public int getValor_descuento_prod() {
        return valor_descuento_prod;
    }

    public void setValor_descuento_prod(int valor_descuento_prod) {
        this.valor_descuento_prod = valor_descuento_prod;
    }


    @Override
    public String toString() {
        return "Producto{" + "ID_prod=" + ID_prod + ", Nombre_prod=" + nombre_prod + ", Precio_prod=" + precio_prod + ", Descuento_prod =" + descuento_prod + ", valor_descuento_prod=" + valor_descuento_prod + ", id_plan=" + '}';
    }


}

 