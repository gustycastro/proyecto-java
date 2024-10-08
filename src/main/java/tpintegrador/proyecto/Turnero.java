/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Turnero {
    
    public void interfazGrafica(Stage primaryStage)throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("turnero.fxml"));
      primaryStage.setScene(new Scene(root, 300, 200));
      primaryStage.show();
    }
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private void agendarTurno() {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turno Agendado");
            alert.setHeaderText(null);
            alert.setContentText("Turno agendado para el: " + selectedDate);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fecha no seleccionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una fecha para agendar el turno.");
            alert.showAndWait();
        }
    }
}