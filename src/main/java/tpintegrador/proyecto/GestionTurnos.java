/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.sql.*;
import java.time.LocalDate;
import javafx.scene.control.ListView;

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
            String sql = "CREATE TABLE IF NOT EXISTS TablaPacientes ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nombre TEXT NOT NULL, "
                    + "apellido TEXT NOT NULL, "
                    + "edad INTEGER NOT NULL, "
                    + "fecha TEXT NOT NULL, "
                    + "dni INTEGER NOT NULL, "
                    + "medico TEXT NOT NULL"
                    + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Tabla creada correctamente");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void insertarPacientes(int ID, String nombre, String apellido, int edad, String fecha, int DNI, String doctor) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            // Cargar el driver JDBC de SQLite (esto generalmente se hace solo una vez)
            Class.forName("org.sqlite.JDBC");

            // Conectar a la base de datos (considera reutilizar esta conexión en lugar de abrirla cada vez)
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            // Preparar la consulta de inserción con el campo "hora"
            String sql = "INSERT INTO TablaPacientes (ID, nombre, apellido, edad, fecha, DNI, doctor) VALUES (?, ?, ?, ?, ?, ?, ?);";
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, ID);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, edad);
            pstmt.setString(5, fecha);
            pstmt.setInt(6, DNI);
            pstmt.setString(7, doctor);

            // Ejecutar la actualización
            pstmt.executeUpdate();

            // Confirmar la transacción
            c.commit();
            System.out.println("Registro creado con éxito");
        } catch (Exception e) {
            System.err.println("Error al insertar paciente");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            // Cerrar los recursos
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión o el PreparedStatement");
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }

    public void mostrarRegistros() {
        Connection c = null;
        Statement stmt = null;
        try {
            // Conectar a la base de datos
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            // Crear la consulta SQL
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TablaPacientes;");

            // Recorrer los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                String fecha = rs.getString("fecha");
                int dni = rs.getInt("DNI");
                String doctor = rs.getString("doctor");

                System.out.println("Nombre = " + nombre);
                System.out.println("Apellido = " + apellido);
                System.out.println("Edad = " + edad);
                System.out.println("Fecha = " + fecha);
                System.out.println("DNI = " + dni);
                System.out.println("Doctor/ra = " + doctor);
                System.out.println();
            }
            // Cerrar ResultSet, Statement y Connection
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error al mostrar los datos ");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operación realizada con éxito");
    }

    public boolean buscarTurnos(int DNI, ListView<Turno> listTurnos) {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            // Establecer la conexión
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            // Verificar si el DNI existe en la base de datos
            String checkSql = "SELECT COUNT(*) FROM TablaPacientes WHERE DNI = ?";
            stmt = c.prepareStatement(checkSql);
            stmt.setInt(1, DNI);
            ResultSet checkRs = stmt.executeQuery();

            if (checkRs.next() && checkRs.getInt(1) == 0) {
                checkRs.close();
                stmt.close();
                c.close();
                return false;  // Retornar false si el DNI no existe
            }

            // Si el DNI existe, proceder con la búsqueda de turnos
            String sql = "SELECT * FROM TablaPacientes WHERE DNI = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, DNI);
            ResultSet rs = stmt.executeQuery();

            // Limpiar la lista antes de mostrar nuevos resultados
            listTurnos.getItems().clear();

            // Recorrer los resultados y añadirlos a la ListView
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String medico = rs.getString("doctor");
                LocalDate fecha = LocalDate.parse(rs.getString("fecha"));  // Asumiendo formato YYYY-MM-DD
                int edad = rs.getInt("edad");

                // Crear un objeto Turno y agregarlo a la lista
                Turno turno = new Turno(fecha, nombre, apellido, DNI, edad, medico);
                listTurnos.getItems().add(turno);
            }

            // Cerrar ResultSet y Statement
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Error al mostrar los datos");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Operación realizada con éxito");
        return true;  // Retornar true si el DNI existe y la operación se realiza correctamente
    }

    public int obtenerUltimoId() {
        Connection c = null;
        Statement stmt = null;
        int ultimoId = 0;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) FROM TablaPacientes;");

            if (rs.next()) {
                ultimoId = rs.getInt(1);  // Obtiene el valor más alto de la columna ID
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return ultimoId;
    }

    public void eliminarTurno(int dniPaciente, String fechaTurno) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
            c.setAutoCommit(false);
            System.out.println("Base de datos abierta exitosamente");

            // Consulta de eliminación usando DNI y FechaTurno
            String sql = "DELETE FROM TablaPacientes WHERE DNI = ? AND fecha = ?;";
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, dniPaciente);
            pstmt.setString(2, fechaTurno);
            pstmt.executeUpdate();
            c.commit();

            System.out.println("Turno eliminado con éxito para el paciente con DNI: " + dniPaciente + " y Fecha de Turno: " + fechaTurno);

            mostrarRegistros(); // Mostrar registros después de la eliminación
            pstmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el turno");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Método para modificar la fecha de un paciente por DNI
    public boolean modificarFechaTurno(Turno turno, String nuevaFecha) {
        String sql = "UPDATE TablaPacientes SET fecha = ? WHERE doctor = ?";
        boolean exito = false;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:turnos.sqlite"); // Conectar a la base de datos
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevaFecha);  // Setear nueva fecha
            pstmt.setString(2, turno.getMedico());            // Setear dni

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                exito = true;
                System.out.println("Fecha actualizada correctamente.");
            } else {
                System.out.println("No se encontró el registro con el DNI especificado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return exito;
    }

}
