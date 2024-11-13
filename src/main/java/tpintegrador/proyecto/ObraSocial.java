/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class ObraSocial implements Cobertura {

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
        return nombre; //Esto permitirá que el ComboBox muestre el nombre de las obras sociales
    }

    @Override
    public int montoAbonar(String cobertura) {
        // Monto inicial del servicio, en este caso 25000
        double montoFinal = 25000;

        // Calcula el monto a abonar en función de la cobertura proporcionada
        switch (cobertura) {
            case "OSDE":
                // Si la cobertura es "OSDE", el monto a abonar es 0
                montoFinal = 0;
                break;
            case "OSEP":
                // Si la cobertura es "OSEP", se aplica un descuento del 40% sobre el monto original
                montoFinal = montoFinal - (montoFinal * 0.40);
                break;
            case "DAMSU":
                // Si la cobertura es "DAMSU", se aplica un descuento del 60% sobre el monto original
                montoFinal = montoFinal - (montoFinal * 0.60);
                break;
            case "Prevencion Salud":
                // Si la cobertura es "Prevencion Salud", se aplica un descuento del 70% sobre el monto original
                montoFinal = montoFinal - (montoFinal * 0.70);
                break;
        }
        // Devuelve el monto final redondeado a un valor entero
        return (int) montoFinal;
    }

}
