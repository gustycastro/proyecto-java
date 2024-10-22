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

            if (conn != null) {
                System.out.println("Conexión a base de datos ... Ok");
            
                // Llamar al método para crear la tabla
                crearTabla(conn);
            } else {
                System.out.println("Conexión a base de datos: problemas!");
            }
        } catch (SQLException a) {
            System.out.println(a);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
        try {
            if (conn != null) {
                conn.close(); // Cerrar la conexión al final
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    }

    public void crearTabla(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS TablaPacientes " +
                     "(ID_paciente INT PRIMARY KEY NOT NULL, " +
                     "nombre   TEXT NOT NULL, " +
                     "edad     INT NOT NULL, " +
                     "fecha    TEXT NOT NULL, " +
                     "DNI      INT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Tabla creada correctamente");
        } catch (SQLException e) {
        System.err.println("Error al crear la tabla");
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public void insertarPacientes(int ID, String nombre, int edad, String fecha, int DNI) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            String sql = "INSERT INTO TablaPacientes (ID, nombre, edad, fecha, DNI) VALUES (?, ?, ?, ?, ?);";
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, ID);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, edad);
            pstmt.setString(4, fecha);
            pstmt.setInt(5, DNI);

            pstmt.executeUpdate();
            pstmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Registro creado con éxito");
    }
    
    public void mostrarRegistros(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:tjdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM TablaPacientes;" );
      
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  nombre = rs.getString("nombre");
                int edad  = rs.getInt("edad");
                String  fecha = rs.getString("fecha");
                float DNI = rs.getFloat("DNI");
         
                System.out.println( "ID = " + id );
                System.out.println( "nombre = " + nombre );
                System.out.println( "edad = " + edad );
                System.out.println( "fecha = " + fecha );
                System.out.println( "DNI = " + DNI );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operacion realizada con exito");
    }
    //Posible base de datos
    public void agregarTurno(Paciente paciente){
        
    } 
    public void eliminarTurno(){
        
    }

}
