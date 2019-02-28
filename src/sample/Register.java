package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Register {
    @FXML
    Button regButton;
    @FXML
    Button Back;
    @FXML
    TextField regUsername;
    @FXML
    PasswordField regPassword;
    @FXML
    PasswordField regPasswordConfirm;

    @FXML
    public void handleRegButton(){
        String username = regUsername.getText();
        String password = regPassword.getText();
        String passwordConfirm = regPasswordConfirm.getText();

        if(!password.equals(passwordConfirm))
            return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "Create database if not exists Notes";
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement connect_stmt = connect.createStatement();
            connect_stmt.executeUpdate(database);


            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String query = "CREATE USER '" + username + "'@'localhost' IDENTIFIED BY '" + password + "'";
            stmt.executeUpdate(query);
            query = "GRANT ALL PRIVILEGES ON * . * TO "+ username +"@'localhost'";
            stmt.executeUpdate(query);
            query = "create table if not exists note"+username+" (note_id INT AUTO_INCREMENT, date Date, note_text VARCHAR(255), UNIQUE KEY (note_id))";
            stmt.executeUpdate(query);
            Stage primaryStage = (Stage) Back.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.getScene().setRoot(newRoot);

        }catch(Exception ex) {
            Universal.showPopup();
        }

    }
    @FXML
    public void handleBackButton(){
        try {
            Stage primaryStage = (Stage) Back.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }catch(Exception ex){
            Universal.showPopup();
        }
    }
}