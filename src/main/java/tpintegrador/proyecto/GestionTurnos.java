package tpintegrador.proyecto;

import java.sql.*;
import java.time.LocalDate;
import javafx.scene.control.ListView;

public class GestionTurnos {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:turnos.sqlite");
    }

    public void conexion() {
        try (Connection conn = getConnection()) {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Conexión a base de datos ... Ok");
            crearTabla(conn);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    private void crearTabla(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS TablaPacientes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT NOT NULL, "
                + "apellido TEXT NOT NULL, "
                + "edad INTEGER NOT NULL, "
                + "fecha TEXT NOT NULL, "
                + "dni INTEGER NOT NULL, "
                + "doctor TEXT, "
                + "hora TEXT, "
                + "cobertura INT"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla creada correctamente");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insertarPacientes(int ID, String nombre, String apellido, int edad, String fecha, int DNI, String doctor, String hora, int cobertura) {
        String sql = "INSERT INTO TablaPacientes (ID, nombre, apellido, edad, fecha, DNI, doctor, hora, cobertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Class.forName("org.sqlite.JDBC");
            conn.setAutoCommit(false);

            pstmt.setInt(1, ID);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, edad);
            pstmt.setString(5, fecha);
            pstmt.setInt(6, DNI);
            pstmt.setString(7, doctor);
            pstmt.setString(8, hora);
            pstmt.setInt(9, cobertura);

            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Registro creado con éxito");
        } catch (Exception e) {
            System.err.println("Error al insertar paciente: " + e.getMessage());
        }
    }

    public void mostrarRegistros() {
        String sql = "SELECT * FROM TablaPacientes;";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Nombre = %s, Apellido = %s, Edad = %d, Fecha = %s, DNI = %d, Doctor/ra = %s, Hora = %s, Cobertura = %d%n",
                        rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"),
                        rs.getString("fecha"), rs.getInt("dni"), rs.getString("doctor"),
                        rs.getString("hora"), rs.getInt("cobertura"));
            }
            System.out.println("Operación realizada con éxito");
        } catch (Exception e) {
            System.out.println("Error al mostrar los datos: " + e.getMessage());
        }
    }

    public boolean buscarTurnos(int DNI, ListView<Turno> listTurnos) {
        String sql = "SELECT * FROM TablaPacientes WHERE DNI = ?;";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            listTurnos.getItems().clear();
            stmt.setInt(1, DNI);
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                return false;
            }

            while (rs.next()) {
                Turno turno = new Turno(LocalDate.parse(rs.getString("fecha")), rs.getString("nombre"), rs.getString("apellido"),
                        DNI, rs.getInt("edad"), rs.getString("doctor"), rs.getString("hora"), rs.getInt("cobertura"));
                listTurnos.getItems().add(turno);
            }
            System.out.println("Operación realizada con éxito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al buscar turnos: " + e.getMessage());
            return false;
        }
    }

    public int obtenerUltimoId() {
        String sql = "SELECT MAX(ID) FROM TablaPacientes;";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.err.println("Error al obtener el último ID: " + e.getMessage());
            return 0;
        }
    }

    public void eliminarTurno(int dniPaciente, String fechaTurno, String horaTurno) {
        String sql = "DELETE FROM TablaPacientes WHERE DNI = ? AND fecha = ? AND hora = ?;";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dniPaciente);
            pstmt.setString(2, fechaTurno);
            pstmt.setString(3, horaTurno);
            pstmt.executeUpdate();
            System.out.printf("Turno eliminado para el paciente con DNI: %d, Fecha: %s, Hora: %s%n", dniPaciente, fechaTurno, horaTurno);
        } catch (Exception e) {
            System.out.println("Error al eliminar turno: " + e.getMessage());
        }
    }

    public boolean modificarTurnos(int dni, String fechaActual, String horaActual, String nuevaFecha, String nuevaHora) {
        String sql = "UPDATE TablaPacientes SET fecha = ?, hora = ? WHERE DNI = ? AND fecha = ? AND hora = ?;";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevaFecha);
            pstmt.setString(2, nuevaHora);
            pstmt.setInt(3, dni);
            pstmt.setString(4, fechaActual);
            pstmt.setString(5, horaActual);

            int filasActualizadas = pstmt.executeUpdate();
            System.out.println(filasActualizadas > 0 ? "Fecha y hora actualizadas correctamente." : "No se encontró el registro.");
            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar turnos: " + e.getMessage());
            return false;
        }
    }

    public boolean existeTurno(String nombreMedico, String fecha, String hora) {
        String sql = "SELECT COUNT(*) FROM TablaPacientes WHERE doctor = ? AND fecha = ? AND hora = ?;";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreMedico);
            pstmt.setString(2, fecha);
            pstmt.setString(3, hora);
            ResultSet rs = pstmt.executeQuery();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error al verificar turno existente: " + e.getMessage());
            return false;
        }
    }
}
