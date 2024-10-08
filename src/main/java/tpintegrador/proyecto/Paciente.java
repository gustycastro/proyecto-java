/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class Paciente extends Persona{ //Herencia de persona
    //Atributos
    private String historialMedico;
    private boolean coberturaMedica;
    
    ///Constructor

    public Paciente(String nombre, String apellido, int dni,int edad, String historialMedico, boolean coberturaMedica) {
        super(nombre,apellido,dni,edad);
        this.historialMedico = historialMedico;
        this.coberturaMedica = coberturaMedica;
    }
    
    
    ///Metodos del paciente
    public void cacelarTurno(){
        
    }
    
}
