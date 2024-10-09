/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author laure
 */
public class Medico extends Empleado {
    
    //Atributos
    private Especialidades especialidad;
    private String matricula;
    
    //Constructor
    public Medico(Especialidades especialidad, String matricula, String horarioAtencion, String nombre, String apellido, int dni, int edad) {
        super(horarioAtencion, nombre, apellido, dni, edad);
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    
    public Especialidades getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    

    
    

    
    
}
