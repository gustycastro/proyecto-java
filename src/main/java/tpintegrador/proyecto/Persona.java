/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author HP
 */
public abstract class Persona {
    
    //Atributos 
    protected String nombre;
    protected String apellido;
    protected int dni;// Fer: cambie int de dni por long
    protected int edad;
    
    //Constructor
    
    public Persona(String nombre, String apellido, int dni, int edad) {// Fer: cambie int de dni por long
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    //Metodos

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

    public int getDni() {// Fer: cambie int de dni por long
        return dni;
    }

    public void setDni(int dni) {// Fer: cambie int de dni por long
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
