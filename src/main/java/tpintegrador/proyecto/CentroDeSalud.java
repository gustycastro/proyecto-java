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
    private static ArrayList<Especialidades> listaEspecialidades = new ArrayList<>();
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static ArrayList<ObraSocial> listaObraSocial = new ArrayList<>();
    
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
        
        //Inicializar Obras Sociales
        ObraSocial osde = new ObraSocial("OSDE");
        ObraSocial osep = new ObraSocial("OSEP");
        ObraSocial damsu = new ObraSocial("DAMSU");
        ObraSocial psalud = new ObraSocial("Prevencion Salud");
        ObraSocial particular = new ObraSocial("Particular");
        
        listaObraSocial.add(osde);
        listaObraSocial.add(osep);
        listaObraSocial.add(damsu);
        listaObraSocial.add(psalud);
        listaObraSocial.add(particular);
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
    public static ArrayList<Especialidades> getListaEspecialidades() {
        return listaEspecialidades;
    }
    public static void setListaEspecialidades(ArrayList<Especialidades> listaEspecialidades) {
        CentroDeSalud.listaEspecialidades = listaEspecialidades;
    }
    public static ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }
    public static void setListaMedicos(ArrayList<Medico> listaMedicos) {
        CentroDeSalud.listaMedicos = listaMedicos;
    }
    public static ArrayList<ObraSocial> getListaObraSocial() {
        return listaObraSocial;
    }
    public static void setListaObraSocial(ArrayList<ObraSocial> listaObraSocial) {
        CentroDeSalud.listaObraSocial = listaObraSocial;
    }
    
    //Metodos
    public void recibirPersonas() {
        //Agregar este metodo a el UML
    }
}
