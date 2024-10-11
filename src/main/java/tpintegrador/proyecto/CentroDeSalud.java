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
public class CentroDeSalud {
    
    //Atributos
    private String ubicación;
    private int contacto;
    private static ArrayList<Especialidades> listaEspecialidades = new ArrayList<>();;
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();;
    
        //Constructor
    public CentroDeSalud(String ubicacion, int contacto){
        this.ubicación = ubicación;
        this.contacto = contacto; 
    }    
    public void cargarListas(){
        // Inicializar especialidades
        Especialidades cardiologia = new Especialidades("Cardiología");
        Especialidades pediatria = new Especialidades("Pediatría");
        Especialidades dermatologia = new Especialidades("Dermatología");
        
        listaEspecialidades.add(cardiologia);
        listaEspecialidades.add(pediatria);
        listaEspecialidades.add(dermatologia);
        // Inicializar Medicos
        Medico medico1 = new Medico(cardiologia, "12345", "9:00-17:00", "Dr. Juan Pérez", "Pérez", 12345678, 40);
        Medico medico2 = new Medico(dermatologia, "67890", "9:00-17:00", "Dra. Lautaro Sanchez", "Sanchez", 87654321, 35); 
        Medico medico3 = new Medico(pediatria, "67890", "9:00-17:00", "Dra. Monica Marquez", "Gómez", 87654321, 31);
        
        listaMedicos.add(medico1);
        listaMedicos.add(medico2);
        listaMedicos.add(medico3);
    }
    
    //Metodos
    public ArrayList<Medico> obtenerMedicos() {
        return listaMedicos;
    }

    public ArrayList<Especialidades> obtenerEspecialidades() {
        return  listaEspecialidades;
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
    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }
    public void setListaMedicos(ArrayList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
    public ArrayList<Especialidades> getListaEspecialidades() {
        return listaEspecialidades;
    }
    public void setListaEspecialidades(ArrayList<Especialidades> listaEspecialidades) {
        this.listaEspecialidades = listaEspecialidades;
    }
    //Metodos
    public void recibirPersonas() {
        //Agregar este metodo a el UML
    }
}
