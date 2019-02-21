package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        try {
            JDBCOperations.selectAllFrom();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
