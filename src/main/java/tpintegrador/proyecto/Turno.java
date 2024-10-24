/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package tpintegrador.proyecto;

/**
 *
 *
 * @author laure
 */
public class Turno extends Paciente {

    //Atributos
    private int fecha;
    private int hora;

    ///Constructor 
    public Turno(int fecha, int hora,String nombre, String apellido, int dni, int edad) {    
        super(nombre, apellido, dni, edad);
        this.fecha = fecha;
        this.hora = hora;
    }

    //Metodos gets y sets
    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

}
