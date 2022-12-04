package Clases;

/**
 *
 * @author Moises
 */
public class Cliente {
    private int rut;
    private String nombres;
    private String apellido_pat;
    private String apellido_mat;
    private String correo;


    public Cliente() {
    }
    
    public Cliente(int rut, String nombres, String apellido_pat, String apellido_mat, String correo, int id_plan) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.correo = correo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombres=" + nombres + ", apellido_pat=" + apellido_pat + ", apellido_mat=" + apellido_mat + ", correo=" + correo + ", id_plan=" + '}';
    }


}
