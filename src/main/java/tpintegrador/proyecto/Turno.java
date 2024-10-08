/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.util.ArrayList;

/**
 *
 * @author laure
 */
public class Turno {
    public int fecha;
    public int hora;
    public String nombre;
    public String apellido;
    public int DNI;
    public int edad;
    public ArrayList<Medico> tiposMedicos;
    ///Constructor 1
    public Turno(String nombre, String apellido, int dni, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.DNI=dni;
        this.edad=edad;
    }
    ///Constructor 2
    public Turno(int fecha, int hora, ArrayList<Medico> tiposMedicos){
        this.fecha=fecha;
        this.hora=hora;
        this.tiposMedicos=tiposMedicos;
    }
}
