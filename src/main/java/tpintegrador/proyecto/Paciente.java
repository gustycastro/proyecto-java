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
    private boolean coberturaMedica;
    
    ///Constructor

    public Paciente(String nombre, String apellido, long dni,int edad,boolean coberturaMedica) { // Fer: cambie int de dni por long
        super(nombre,apellido,dni,edad);
        this.coberturaMedica = coberturaMedica;
    }
    
    //Metodos gets y sets

    public boolean isCoberturaMedica() {
        return coberturaMedica;
    }

    public void setCoberturaMedica(boolean coberturaMedica) {
        this.coberturaMedica = coberturaMedica;
    }
     
}
