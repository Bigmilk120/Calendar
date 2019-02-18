package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

import java.sql.Date;
import java.time.LocalDate;



public class Controller {
    @FXML
    GridPane grid;

    @FXML
    Button applyDate;
    @FXML
    DatePicker datePicker = new DatePicker(LocalDate.now());


    @FXML
    private void handleApplyButton(){
        Date date = java.sql.Date.valueOf(datePicker.getValue());
        System.out.println(date);

    }
}
