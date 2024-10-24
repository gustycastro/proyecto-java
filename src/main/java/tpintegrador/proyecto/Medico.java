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
    private int matricula;// Fer: cambie String de matricula por int
    
    //Constructor
    public Medico(Especialidades especialidad, int matricula, String horarioAtencion, String nombre, String apellido, int dni, int edad) { // Fer: cambie int de dni por long y String de matricula por int
        super(horarioAtencion, nombre, apellido, dni, edad);
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    //Metodos gets y sets
    public Especialidades getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }
    // Fer: cambie String de matricula por int
    public int getMatricula() {
        return matricula;
    }
    // Fer: cambie String de matricula por int
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return nombre; // Esto permitirá que el ComboBox muestre el nombre de los medicos
    }
    
    

    
    

    
    
}
