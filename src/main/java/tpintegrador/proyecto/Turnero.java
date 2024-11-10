/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.time.DayOfWeek;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import java.util.Iterator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author HP
 */
public class Turnero {

    //Atributos
    GestionTurnos bdTurnos = new GestionTurnos(); // Objeto para gestionar la base de datos de turnos
    private String pantallaActiva = "modificar"; // Variable para rastrear la pantalla actualmente activa (valor predeterminado es "modificar")

    @FXML
    private TextField nombreId; //Campo para el nombre del paciente
    @FXML
    private TextField apellidoId; //Campo para el apellido del paciente

    //como se repite el metodo buscarTurno para 3 botones, en pantallas distintas, en la interfaz grafica, necesitamos crear variables FXML para que JavaFX reconosca los botones
    @FXML
    private TextField dniId; //Campo para el DNI del paciente
    @FXML
    private TextField dniIdBuscarCancelar; //Campo para el DNI del paciente para pantalla Cancelar
    @FXML
    private TextField dniIdBuscarModificar; //Campo para el DNI del paciente para pantalla Modificar
    @FXML
    private TextField dniIdBuscarMostrar; //Campo para el DNI del paciente para pantalla Mostrar
    @FXML
    private TextField edadId; //Campo para la edad del paciente
    @FXML
    private DatePicker fechaId; //Campo para seleccionar la fecha del paciente en la pantalla "Modificar Turno"
    @FXML
    private DatePicker datePicker; //Para seleccionar la fecha del turno
    @FXML
    private ComboBox<Especialidades> comboEspecialidades; //ComboBox para seleccionar especialidad
    @FXML
    private ComboBox<ObraSocial> comboObrasSociales; //ComboBox para seleccionar especialidad
    @FXML
    private ComboBox<String> comboHora; //ComboBox para seleccionar la hora
    @FXML
    private ComboBox<String> comboHoraModificar; //ComboBox para seleccionar la hora en la pantalla "Modificar Turno"
    @FXML
    private Button btnMostrarMedicos; //Botón para mostrar médicos
    @FXML
    private Button btnAgendarTurno; //Botón para agendar el turno
    @FXML
    private Button btnCancelarTurno; //Botón para cancelar el turno
    @FXML
    private Button btnModificarTurno; //Botón para modificar el turno
    @FXML
    private Button btnTurnoModificado; //Botón para modificar el turno
    @FXML
    private Button btnBuscarPaciente; //Botón para buscar paciente  
    @FXML
    private Button btnBuscarTurnos; //Botón para buscar turno
    @FXML
    private AnchorPane paginaPrincipal; // Referencia FXML al AnchorPane de la pantalla principal
    @FXML
    private AnchorPane paginaAgregarTurno; // Referencia FXML al AnchorPane de la pantalla Agregar
    @FXML
    private AnchorPane paginaMostrarTurno; // Referencia FXML al AnchorPane de la pantalla Mostrar
    @FXML
    private AnchorPane paginaModificarTurno; // Referencia FXML al AnchorPane de la pantalla Modificar
    @FXML
    private AnchorPane paginaCancelarTurno; // Referencia FXML al AnchorPane de la pantalla Cancelar
    @FXML
    private ListView<Medico> listViewMedicos; // ListView para mostrar una lista de médicos en la pantalla "Agregar Turno"
    @FXML
    private ListView<Turno> listTurnosCancelar; // ListView para mostrar una lista de turnos en la pantalla "Cancelar Turno"
    @FXML
    private ListView<Turno> listTurnosMostrar; // ListView para mostrar una lista de turnos en la pantalla "Mostrar Turno"
    @FXML
    private ListView<Turno> listTurnosModificar; // ListView para mostrar una lista de turnos en la pantalla "Modificar Turno"

    public void interfazGrafica(Stage interfaz) throws Exception {
        // Crear objeto CentroDeSalud con su constructor inicializado y para despues cargar las listas de datos
        CentroDeSalud cs = new CentroDeSalud("Cuyo Salud", 44305677);
        cs.cargarListas();

        // Cargar el archivo FXML que define la interfaz gráfica
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/turnero.fxml"));
        Parent root = loader.load();

        // Obtener el controlador asociado al archivo FXML
        Turnero turneroController = loader.getController();

        // Crear la escena con el diseño cargado y establecer las dimensiones
        Scene scene = new Scene(root, 900, 700);
        // Agregar la hoja de estilos CSS a la escena
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

        // Configurar la escena y el título de la ventana principal
        interfaz.setScene(scene);
        interfaz.setTitle("Sistema de Turnero");
        interfaz.show();

        // Llenar el ComboBox de especialidades con los datos obtenidos del CentroDeSalud
        turneroController.comboEspecialidades.getItems().addAll(cs.getListaEspecialidades());

        // Llenar el ComboBox de obras sociales con los datos obtenidos del CentroDeSalud
        turneroController.comboObrasSociales.getItems().addAll(cs.getListaObraSocial());

        // Llenar el ComboBox de horas de turno (para agendar y modificar)
        turneroController.comboHora.getItems().addAll(cs.getListaHoras());
        turneroController.comboHoraModificar.getItems().addAll(cs.getListaHoras());

        // Configurar el evento del botón "Mostrar Médicos" para que muestre la lista de médicos según la especialidad seleccionada
        turneroController.btnMostrarMedicos.setOnAction(event -> turneroController.mostrarMedicos());

        // Configurar el evento del botón "Agendar Turno" para agendar un nuevo turno
        turneroController.btnAgendarTurno.setOnAction(event -> turneroController.agendarTurno());

        // Configurar el evento del botón "Modificar Turno" para aplicar cambios a un turno existente
        turneroController.btnTurnoModificado.setOnAction(event -> turneroController.modificarTurno());

        // Configurar el evento del botón "Buscar Turnos" para buscar turnos según criterios especificados
        turneroController.btnBuscarTurnos.setOnAction(event -> turneroController.buscarTurno());
    }

    //Ir a la página de Agregar Turno
    @FXML
    private void irAgregarTurno() {
        paginaPrincipal.setVisible(false);
        paginaAgregarTurno.setVisible(true);
    }

    //Ir a la página de Modificar Turno
    @FXML
    private void irModificarTurno() {
        paginaPrincipal.setVisible(false);
        paginaModificarTurno.setVisible(true);
        pantallaActiva = "modificar";
    }

    //Ir a la página de Mostrar Turno
    @FXML
    private void irMostrarTurno() {
        paginaPrincipal.setVisible(false);
        paginaMostrarTurno.setVisible(true);
        pantallaActiva = "mostrar";
    }

    //Ir a la página Cancelar Turno
    @FXML
    private void irCancelarTurno() {
        paginaPrincipal.setVisible(false);
        paginaCancelarTurno.setVisible(true);
        pantallaActiva = "cancelar";
    }

    //Volver a la página principal
    @FXML
    private void volverPaginaPrincipal() {
        paginaAgregarTurno.setVisible(false);
        paginaMostrarTurno.setVisible(false);
        paginaModificarTurno.setVisible(false);
        paginaCancelarTurno.setVisible(false);
        paginaPrincipal.setVisible(true);
    }

    // Método para mostrar los médicos de la especialidad seleccionada en el ComboBox
    @FXML
    private void mostrarMedicos() {
        // Crear una objeto CentroDeSalud para acceder a las listas de médicos y especialidades
        // Nota: "Cuyo Salud" y "44305677" son parámetros de prueba para el nombre y contacto del centro
        CentroDeSalud cs = new CentroDeSalud("Cuyo Salud", 44305677);
        cs.cargarListas(); // Cargar las listas necesarias 

        // Obtener la especialidad seleccionada en el ComboBox de especialidades
        Especialidades especialidadSeleccionada = comboEspecialidades.getValue();

        // Limpiar la lista de médicos antes de mostrar nuevos datos
        listViewMedicos.getItems().clear();

        // Verificar si el usuario ha seleccionado una especialidad válida
        if (especialidadSeleccionada != null) {
            // Iterar a través de la lista de médicos y filtrar por la especialidad seleccionada
            Iterator<Medico> it = cs.getListaMedicos().iterator();
            while (it.hasNext()) {
                Medico medico = it.next();
                // Comparar la especialidad del médico con la especialidad seleccionada por el usuario
                if (medico.getEspecialidad().equals(especialidadSeleccionada)) {
                    // Si la especialidad coincide, agregar el médico a la ListView
                    listViewMedicos.getItems().add(medico);
                }
            }
        } else {
            // Si no se ha seleccionado ninguna especialidad, mostrar un mensaje de advertencia
            showAlertE("Por favor, seleccione una especialidad.");
        }
    }

    //Método para agendar un turno
    @FXML
    private void agendarTurno() {
        // Obtener los valores de los campos
        String nombre = nombreId.getText();
        String apellido = apellidoId.getText();
        String dniStr = dniId.getText();
        String edadStr = edadId.getText();
        LocalDate selectedDate = datePicker.getValue();
        Medico medicoSeleccionado = listViewMedicos.getSelectionModel().getSelectedItem();
        String horaStr = comboHora.getValue();
        ObraSocial os = new ObraSocial(comboObrasSociales.getValue().toString());

        // Validación de los campos
        if (nombre.isEmpty() || apellido.isEmpty() || dniStr.isEmpty() || edadStr.isEmpty() || selectedDate == null || medicoSeleccionado == null || horaStr == null) {
            showAlertE("Por favor, complete todos los campos.");
            return;
        }
        // Validación de la fecha seleccionada (debe ser día hábil y posterior a hoy)
        LocalDate today = LocalDate.now();
        if (selectedDate.isBefore(today) || selectedDate.equals(today)) {
            showAlertE("La fecha debe ser posterior a hoy.");
            return;
        }
        if (selectedDate.getDayOfWeek() == DayOfWeek.SATURDAY || selectedDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            showAlertE("Seleccione un día hábil (lunes a viernes).");
            return;
        }
        try {
            // Validar que el DNI y la edad sean números
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);

            // Convertir la fecha a un formato adecuado
            String fecha = selectedDate.toString();
            int monto = os.montoAbonar(os.getNombre());

            // Validar que no haya un turno existente para el médico en esa fecha y hora
            String nombreMedico = medicoSeleccionado.getNombre(); // Obtener el nombre del médico como String
            if (bdTurnos.existeTurno(nombreMedico, fecha, horaStr)) {
                showAlertE("Ya existe un turno agendado para este médico a esa hora.");
                return;
            }

            // Agendar el turno si todo es válido
            bdTurnos.insertarPacientes(bdTurnos.obtenerUltimoId() + 1, nombre, apellido, edad, fecha, dni, nombreMedico, horaStr, monto);

            // Mostrar un mensaje de confirmación, indicando si se debe abonar o no un coseguro
            if (monto == 0) {
                showAlertC("¡Turno agendado Correctamente!\n"
                        + "No necesita abonar coseguro.");
            } else {
                showAlertC("¡Turno agendado Correctamente!\n"
                        + "Debe abonar un coseguro de $" + monto);
            }

            // limpiar los campos del formulario
            limpiarCampos();

        } catch (NumberFormatException e) {
            // Mostrar un mensaje de error si el DNI o la edad no son números válidos
            showAlertE("Por favor, ingrese un número válido para el DNI y la edad.");
        }
    }

    @FXML
    public void modificarTurno() {    // Método que maneja la lógica para buscar y modificar el turno de un paciente
        LocalDate nuevaFecha = fechaId.getValue();
        String nuevaHora = comboHoraModificar.getValue();
        LocalDate today = LocalDate.now();
        //Obtener el turno seleccionado
        Turno turno = listTurnosModificar.getSelectionModel().getSelectedItem();

        //Verificar que el turno esté seleccionado antes de continuar
        if (turno == null) {
            showAlertE("Seleccione un turno para modificar.");
            return;
        }
        if (nuevaFecha.isBefore(today) || nuevaFecha.equals(today)) {
            showAlertE("La fecha debe ser posterior a hoy.");
            return;
        }

        //Validación: la fecha debe ser un día hábil (lunes a viernes)
        if (nuevaFecha.getDayOfWeek() == DayOfWeek.SATURDAY || nuevaFecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
            showAlertE("Seleccione un día hábil (lunes a viernes).");
            return;
        }

        //Validación: la nueva fecha no debe ser anterior a la fecha actual del turno
        if (nuevaFecha.isBefore(turno.getFecha()) || nuevaFecha.equals(turno.getFecha())) {
            showAlertE("La nueva fecha debe ser posterior a la fecha actual del turno.");
            return;
        }

        // Validar que no haya un turno existente para el médico en esa fecha y hora
        if (bdTurnos.existeTurno(turno.getMedico(), nuevaFecha.toString(), nuevaHora)) {
            showAlertE("Turno existente, elija otra fecha u hora");

        } else {
            // Actualiza el turno si todo es valido
            boolean actualizado = bdTurnos.modificarTurnos(Integer.parseInt(dniIdBuscarModificar.getText()), turno.getFecha().toString(), turno.getHora(), nuevaFecha.toString(), nuevaHora);

            // Verifica si la actualización del turno fue exitosa
            if (actualizado) {
                // Si fue exitoso, actualiza el objeto `turno` con la nueva fecha y hora
                turno.setFecha(nuevaFecha);
                turno.setHora(nuevaHora);

                // Muestra un mensaje de confirmación indicando que el turno fue modificado
                showAlertC("Turno modificado correctamente");
            } else {
                // Si la actualización falló, muestra un mensaje de error para informar al usuario
                showAlertE("No se pudo modificar el turno. Verifique los datos e intente de nuevo.");
            }
        }

    }

    // Método para cancelar un turno
    @FXML
    private void cancelarTurno() {
        try {
            // Obtener el turno seleccionado desde el ListView de turnos a cancelar
            Turno turnoSeleccionado = listTurnosCancelar.getSelectionModel().getSelectedItem();

            // Si no se ha seleccionado ningún turno, mostrar un mensaje de error
            if (turnoSeleccionado == null) {
                showAlertE("No se ha seleccionado ningún turno para cancelar.");
                return; // Detener la ejecución si no hay un turno seleccionado
            }

            // Extraer la fecha y hora del turno seleccionado
            // Suponemos que el formato de la fecha es "YYYY-MM-DD" y la hora es en formato "HH:MM AM/PM"
            String fechaTurno = turnoSeleccionado.getFecha().toString(); // Obtiene solo la fecha del turno
            String horaTurno = turnoSeleccionado.getHora(); // Obtiene la hora del turno

            // Obtener el DNI ingresado por el usuario en el campo de búsqueda para cancelar el turno
            int dni = Integer.parseInt(dniIdBuscarCancelar.getText());

            // Llamar al método para eliminar el turno de la base de datos con los datos extraídos
            bdTurnos.eliminarTurno(dni, fechaTurno, horaTurno);

            // Mostrar un mensaje de confirmación indicando que el turno fue cancelado correctamente
            showAlertC("Turno cancelado correctamente.");

        } catch (NumberFormatException ex) {
            // Si el DNI ingresado no es un número válido, mostrar un mensaje de error
            showAlertE("El DNI ingresado no es válido.");
        }
    }

    @FXML
    public void buscarTurno() {
        int dni;                // Variable para almacenar el DNI del paciente
        String dniTexto = "";   // Variable para almacenar el texto ingresado en el campo de búsqueda
        boolean existe;         // Variable para verificar si el turno existe en la base de datos

        // Verifica cuál pantalla está activa para saber qué campo de texto utilizar
        if (pantallaActiva.equals("modificar")) {  // Si la pantalla activa es "modificar"

            dniTexto = dniIdBuscarModificar.getText().trim(); // Obtiene el texto ingresado en el campo de búsqueda

            try {
                dni = Integer.parseInt(dniTexto);  // Intenta convertir el texto a un número entero
            } catch (NumberFormatException e) {
                showAlertE("Por favor, introduce un número de DNI válido.");  // Si no es un número válido, muestra un mensaje de error
                return; // Detiene la ejecución del método si el DNI es inválido
            }

            // Busca los turnos en la base de datos usando el DNI y los muestra en la lista correspondiente
            existe = bdTurnos.buscarTurnos(dni, listTurnosModificar);

        } else if (pantallaActiva.equals("cancelar")) {  // Si la pantalla activa es "cancelar"

            dniTexto = dniIdBuscarCancelar.getText().trim(); // Obtiene el texto ingresado en el campo de búsqueda

            try {
                dni = Integer.parseInt(dniTexto);  // Intenta convertir el texto a un número entero
            } catch (NumberFormatException e) {
                showAlertE("Por favor, introduce un número de DNI válido.");  // Si no es un número válido, muestra un mensaje de error
                return; // Detiene la ejecución del método si el DNI es inválido
            }

            // Busca los turnos en la base de datos usando el DNI y los muestra en la lista correspondiente
            existe = bdTurnos.buscarTurnos(dni, listTurnosCancelar);

        } else if (pantallaActiva.equals("mostrar")) {  // Si la pantalla activa es "mostrar"

            dniTexto = dniIdBuscarMostrar.getText().trim(); // Obtiene el texto ingresado en el campo de búsqueda

            try {
                dni = Integer.parseInt(dniTexto);  // Intenta convertir el texto a un número entero
            } catch (NumberFormatException e) {
                showAlertE("Por favor, introduce un número de DNI válido.");  // Si no es un número válido, muestra un mensaje de error
                return; // Detiene la ejecución del método si el DNI es inválido
            }

            // Busca los turnos en la base de datos usando el DNI y los muestra en la lista correspondiente
            existe = bdTurnos.buscarTurnos(dni, listTurnosMostrar);

        } else {
            // Si la pantalla activa no está definida o es inválida, muestra un mensaje de error
            showAlertE("No se ha definido una pantalla activa.");
            return; // Detiene la ejecución si no hay una pantalla activa válida
        }

        // Si no se encuentran turnos asociados al DNI ingresado, muestra un mensaje de error
        if (!existe) {
            showAlertE("El DNI ingresado no existe en la base de datos.");
        }
    }

    //Método para mostrar alertas de error
    private void showAlertE(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Método para mostrar alertas de confirmación
    private void showAlertC(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Método para limpiar los campos
    private void limpiarCampos() {
        // Limpia todos los campos de entrada
        nombreId.clear();
        apellidoId.clear();
        dniId.clear();
        edadId.clear();
        comboHora.getSelectionModel().clearSelection();
        comboObrasSociales.getSelectionModel().clearSelection();
        comboEspecialidades.getSelectionModel().clearSelection();
        listViewMedicos.getItems().clear();
        datePicker.setValue(null);
    }
}
