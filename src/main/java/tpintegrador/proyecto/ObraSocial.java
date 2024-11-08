/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class ObraSocial implements Particular{
    
    //Atributos
    private String nombre;
    
    //Constructor
    public ObraSocial(String nombre) {
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
        return nombre; // Esto permitirá que el ComboBox muestre el nombre de las obras sociales
    }
    
    @Override
    public int montoAbonar(String cobertura) {
        double montoFinal = 25000;

        // Calcula el monto en función de la cobertura
        switch (cobertura) {
            case "OSDE":
                montoFinal = 0;
                break;
            case "OSEP":
                montoFinal = montoFinal - (montoFinal*0.40);
                break;
            case "DAMSU":
                montoFinal = montoFinal - (montoFinal*0.60);
                break;
            case "Prevencion Salud":
                montoFinal = montoFinal - (montoFinal*0.70);
                break;
        }
        return (int)montoFinal;
    }
}
