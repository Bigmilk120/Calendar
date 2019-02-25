package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    DatePicker insertDate = new DatePicker();
    @FXML
    TextField noteAdd = new TextField();
    @FXML
    Button insertButton;
    @FXML
    TextField deleteId = new TextField();
    @FXML
    Button deleteButton;
    @FXML
    Button showAll;


    @FXML
    private void handleApplyButton(){
        try {
            Date date = java.sql.Date.valueOf(datePicker.getValue());
            noteText.setText(JDBCOperations.selectFrom(date));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
    private void handleInsertButton(){
        try {
            Date date = java.sql.Date.valueOf(insertDate.getValue());
            String noteText=noteAdd.getText();
            JDBCOperations.insertInto(date,noteText);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
    private void handleDeleteButton(){
        try {
            int delId = Integer.parseInt(deleteId.getText());
            JDBCOperations.deleteFrom(delId);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
    private void handleShowAllButton(){
        try {
            noteText.setText(JDBCOperations.selectAllFrom());
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
    private void handleTemp(){
    }
}
