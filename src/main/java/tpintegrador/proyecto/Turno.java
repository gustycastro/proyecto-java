/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package tpintegrador.proyecto;




import java.time.LocalDate;


public class Turno extends Paciente {

    // Atributos
    private LocalDate fecha;
    private int hora;
    private String medico;

    // Constructor
   
    public Turno(LocalDate fecha, int hora, String nombre, String apellido, int edad, int dni, String medico) {
        super(nombre, apellido, dni, edad);
        this.fecha = fecha;
        this.medico = medico;
        this.hora = hora;
    }

    // Métodos getters y setters

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    
    
    @Override
    public String toString() {
        return String.format("Paciente: %s %s, Fecha: %s, Medico: %s ",
                getNombre(), getApellido(), fecha.toString(), getMedico());
    }

}
