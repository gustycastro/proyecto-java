/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class Empleado extends Persona {
    
    //Atributos
    private String horarioAtencion;
    
    //Constructor
    public Empleado(String horarioAtencion, String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
        this.horarioAtencion = horarioAtencion;
    }
    
    //Metodos gets y sets
    public String getHorarioAtencion(){    
        return horarioAtencion;
    }
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {    
        this.nombre = nombre;
    }

    //Metodos
    public void asistirTrabajo() {
        System.out.println("Asiste al trabajo");
    }
}
