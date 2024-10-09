/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

/**
 *
 * @author vale
 */
public class ObraSocial {
    
    //Atributos
    private int descuentoAfiliado;
    
    //Constructor
    public ObraSocial(int descuentoAfiliado){    
        this.descuentoAfiliado = descuentoAfiliado;
    }

    //Metodos gets y sets
    public int getDescuentoAfiliado() {
        return descuentoAfiliado;
    }
    public void setDescuentoAfiliado(int descuentoAfiliado) {    
        this.descuentoAfiliado = descuentoAfiliado;
    }

    //Metodos
    public void aplicarDescuento() {
        System.out.println("testeo");
    }
}
