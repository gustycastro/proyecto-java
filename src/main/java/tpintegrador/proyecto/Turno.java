/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package tpintegrador.proyecto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 *
 * @author laure
 */
public class Turno extends Paciente {

    // Atributos
    private LocalDate fecha;
    public String medico;
    // Constructor
    public Turno(LocalDate fecha, String nombre, String apellido, int dni, int edad, String medico) {    
        super(nombre, apellido, dni, edad);
        this.fecha = fecha;
        this.medico = medico;
    }

    // Métodos getters y setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s %s, Fecha: %s, Edad: %d", 
                getNombre(), getApellido(), fecha.toString(), getEdad());
    }
}

