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
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");

            if (conn != null){
		System.out.println("Conexión a base de datos ... Ok");
                
                crearTabla(conn, stmt);
            }else{
                System.out.println("Conexión a base de datos: problemas!");
            }
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
    public void crearTabla(Connection conn, Statement stmt){
        try{
        stmt = conn.createStatement();
                String sql = "CREATE TABLE TablaPacientes " +
                        "(ID paciente     INT     NOT NULL," +
                        " nombre          TEXT    NOT NULL, " + 
                        " edad            INT     NOT NULL, " + 
                        " fecha           DATE     NOT NULL, " + 
                        " DNI             INT     NOT NULL)"; 
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
        } catch ( Exception e ) {
         System.err.println("error en Tabla");
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
      System.out.println("Tabla creada correctamente");
    }
    //Posible base de datos
    public void agregarTurno(Paciente paciente){
        
    } 
    public void eliminarTurno(){
        
    }

}
