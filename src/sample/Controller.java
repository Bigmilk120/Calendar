package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class Controller {
    @FXML
    Button applyDate;
    @FXML
    DatePicker datePicker;


    @FXML
    private void handleApplyButton(){
        String data = datePicker.getEditor().getText();
        System.out.println(data);

    }
}
