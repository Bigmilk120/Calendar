package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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
    TextArea noteText = new TextArea();

    @FXML
    private void handleApplyButton(){
        try {
            Date date = java.sql.Date.valueOf(datePicker.getValue());
            noteText.setText(date.toString());
            System.out.println(date);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
