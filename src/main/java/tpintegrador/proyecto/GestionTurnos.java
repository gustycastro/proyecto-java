/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;
import java.sql.*;
/**
 *
 * @author laure
 */
public class GestionTurnos {
    
    public void conexion() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");

            if (conn != null)
		System.out.println("Conexión a base de datos ... Ok");
            else
                System.out.println("Conexión a base de datos: problemas!");

           conn.close();

        }
        catch (SQLException a) {
            System.out.println(a);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
}
    //Posible base de datos
    public void agregarTurno(Paciente paciente){
        
    } 
    public void eliminarTurno(){
        
    }

}
