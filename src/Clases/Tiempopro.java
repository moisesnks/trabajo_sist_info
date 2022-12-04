/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Moises
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tiempopro {

    Calendar fecha = new GregorianCalendar();

    String anho = Integer.toString(fecha.get(Calendar.YEAR));
     String mes = Integer.toString(fecha.get(Calendar.MONTH));
      String dia = Integer.toString(fecha.get(Calendar.DATE));

    public  String fechacomp = dia+"/"+mes+"/"+anho;

    String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
    String minutos = Integer.toString(fecha.get(Calendar.MINUTE));
    

    public String horacomp = hora+":"+minutos;
    
    
}
