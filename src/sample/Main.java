package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            JDBCOperations.selectAllFrom(stmt);
            JDBCOperations.insertInto(stmt, 2, new Date(2019-02-20), "This is temporary note");
            JDBCOperations.selectAllFrom(stmt);
            JDBCOperations.deleteFrom(stmt, 2);
            JDBCOperations.selectAllFrom(stmt);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
