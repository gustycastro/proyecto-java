/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.time.LocalDate;

/**
 *
 * @author vale
 */
public class Paciente extends Persona{ //Herencia de persona
    
    //Atributos
    boolean coberturaMedica;
    public String fecha;
    public Medico doctor;
    ///Constructor

    
    public Paciente(String nombre, String apellido, int edad, int dni,String fecha, Medico doctor) {
       super(nombre,apellido,dni,edad);
       
       this.doctor=doctor;
    }
    
    //Metodos gets y sets

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Medico getDoctor() {
        return doctor;
    }

    public void setDoctor(Medico doctor) {
        this.doctor = doctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public boolean isCoberturaMedica() {
        return coberturaMedica;
    }

    public void setCoberturaMedica(boolean coberturaMedica) {
        this.coberturaMedica = coberturaMedica;
    }
     
}
