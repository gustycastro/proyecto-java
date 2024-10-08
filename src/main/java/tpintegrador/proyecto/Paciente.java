/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class Paciente extends Persona { //Herencia de persona
    //Atributos
    public String historialMedico;
    public boolean coberturaMedica;
    ///Constructor
    public Paciente(String nombre, String apellido, int dni, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
        this.edad=edad;
    }
    ///Metodos del paciente
    
    public void cacelarTurno(){
        
    }
    
}
