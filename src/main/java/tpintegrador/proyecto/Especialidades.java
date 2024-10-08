/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;
import java.util.ArrayList;
/**
 *
 * @author vale
 */
public class Especialidades {
    
    private String nombre;
    
    //Constructor
    public Especialidades(String nombre) {
        this.nombre = nombre;
    }
    
    //Metodos gets y sets
    @Override
    public String toString() {
        return nombre; // Esto permitirá que el ComboBox muestre el nombre de la especialidad
    }
    
    
}

