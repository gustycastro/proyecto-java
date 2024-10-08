/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class CentroDeSalud {
    
    //Atributos
    private String ubicación;
    private int contacto;
    
    //Constructor
    public CentroDeSalud(String ubicación, int contacto){
        this.ubicación = ubicación;
        this.contacto = contacto;
       
    }
    
    //Metodos gets y sets
    public String getUbicación() {
        return ubicación;
    }
    public void setUbicación(String ubicación) {
        this.ubicación = ubicación;
    }
    public int getContacto() {
        return contacto;
    }
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
    
    //Metodos
    public void recibirPersonas() {
        //Agregar este metodo a el UML
    }
}
