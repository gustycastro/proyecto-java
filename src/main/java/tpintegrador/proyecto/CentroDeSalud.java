/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.util.ArrayList;
import java.util.Collections;

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
    public CentroDeSalud(String ubicacion, int contacto) {
        this.ubicación = ubicación;
        this.contacto = contacto;
    }

    public void cargarListas() {
        
        // Inicializar Especialidades usando un array y un bucle
        String[] nombresEspecialidades = {"Cardiología", "Pediatría", "Dermatología", "Traumatologia", "Oftalmología"};
        for (String nombre : nombresEspecialidades) {
            listaEspecialidades.add(new Especialidades(nombre));
        }
        
        // Inicializar Médicos
        Medico medico1 = new Medico(listaEspecialidades.get(0), 12345, "9:00-17:00", "Dr. Juan Pérez", "Pérez", 12345678, 40);
        Medico medico2 = new Medico(listaEspecialidades.get(1), 67890, "9:00-17:00", "Dra. Maria Sanchez", "Sanchez", 87654321, 35);
        Medico medico3 = new Medico(listaEspecialidades.get(2), 67890, "9:00-17:00", "Dra. Monica Marquez", "Gómez", 87654321, 31);
        Medico medico4 = new Medico(listaEspecialidades.get(3), 67890, "9:00-17:00", "Dr. Carlos Arias", "Gómez", 87654321, 31);
        Medico medico5 = new Medico(listaEspecialidades.get(0), 12345, "9:00-17:00", "Dr. Alfredo Pucci", "Pérez", 12345678, 40);
        Medico medico6 = new Medico(listaEspecialidades.get(1), 67890, "9:00-17:00", "Dr. Alberto Perez", "Sanchez", 87654321, 35);
        Medico medico7 = new Medico(listaEspecialidades.get(2), 67890, "9:00-17:00", "Dra. Federica Gomez", "Gómez", 87654321, 31);
        Medico medico8 = new Medico(listaEspecialidades.get(3), 67890, "9:00-17:00", "Dr. Matias Gonzalez", "Gómez", 87654321, 31);
        Medico medico9 = new Medico(listaEspecialidades.get(4), 67898, "9:00-17:00", "Dr. Matias Riquelme", "Riquelme", 879654123, 25);
        
        listaMedicos.clear();// Limpiar antes de agregar
        
        // Añadir todos los médicos de una vez
        Collections.addAll(listaMedicos, medico1, medico2, medico3, medico4, medico5, medico6, medico7, medico8, medico9);

        // Inicializar Obras Sociales usando un array y un bucle
        String[] nombresObrasSociales = {"OSDE", "OSEP", "DAMSU", "Prevencion Salud", "Particular"};
        for (String nombre : nombresObrasSociales) {
            listaObraSocial.add(new ObraSocial(nombre));
        }

    }
    
    
    //Metodos

    public ArrayList<Medico> obtenerMedicos() {
        return listaMedicos;
    }

    public ArrayList<Especialidades> obtenerEspecialidades() {
        return listaEspecialidades;
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
}
