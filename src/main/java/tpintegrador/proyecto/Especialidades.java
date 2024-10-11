/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;
/**
 *
 * @author vale
 */
public class Especialidades {
    
    //Atributos
    private String nombre;
    
    //Constructor
    public Especialidades(String nombre) {
        this.nombre = nombre;
    }
    
    //Metodos gets y sets
    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre; // Esto permitirá que el ComboBox muestre el nombre de la especialidad
    }
    
    
}

