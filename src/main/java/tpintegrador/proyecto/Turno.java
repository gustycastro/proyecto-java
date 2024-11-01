/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package tpintegrador.proyecto;




import java.time.LocalDate;


public class Turno extends Persona {

    // Atributos
    private LocalDate fecha;
    private String medico;
    private String hora;
    // Constructor
    public Turno(LocalDate fecha,String nombre, String apellido, int edad, int dni, String medico, String hora) {
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
    public String getMedico() {
        return medico;
    }
    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    @Override
    public String toString() {
        return String.format("Paciente: %s %s, Fecha: %s, Hora: %s, Medico: %s ",
                getNombre(), getApellido(), fecha.toString(), getHora(), getMedico());
    }
}
