/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class ListasMedEsp {
    
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Especialidades> listaEspecialidades;
    
    //Constructor
    public ListasMedEsp() {
        listaMedicos = new ArrayList<>();
        listaEspecialidades = new ArrayList<>();
    }

    //Metodos
    public void agregarMedico(Medico medico) {
        listaMedicos.add(medico);
    }
    public void agregarEspecialidad(Especialidades especialidad) {
        listaEspecialidades.add(especialidad);
    }
    
    //Metodos gets y sets
    public ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }
    public ArrayList<Especialidades> getListaEspecialidades() {
        return listaEspecialidades;
    }
}
