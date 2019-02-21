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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date =  java.sql.Date.valueOf("2018-02-20");

            JDBCOperations.selectAllFrom();
            //JDBCOperations.insertInto(date, "This is temporary note");
            //JDBCOperations.insertInto(date, "This is temporary note");
            JDBCOperations.selectAllFrom();
            JDBCOperations.deleteFrom(2);
            JDBCOperations.deleteFrom(3);
            JDBCOperations.selectAllFrom();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
