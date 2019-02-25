package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calendar");

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
