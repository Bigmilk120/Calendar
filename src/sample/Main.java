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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note";
            System.out.println("The SQL query is: " + strSelect); // Echo For debugging
            System.out.println();

            ResultSet rset = stmt.executeQuery(strSelect);

            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                int id = rset.getInt("note_id");
                Date date = rset.getDate("date");
                String note_text   = rset.getString("note_text");
                System.out.println(id + ", " + date + ", " + note_text);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        }catch (Exception ex){
            System.out.println(ex);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
