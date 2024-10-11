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
    
    //Metodos gets y sets
    public String getHistorialMedico() {
        return historialMedico;
    }
    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    public boolean isCoberturaMedica() {
        return coberturaMedica;
    }
    public void setCoberturaMedica(boolean coberturaMedica) {
        this.coberturaMedica = coberturaMedica;
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
    

    ///Metodos del paciente
    public void cacelarTurno() {
    }
    
}
