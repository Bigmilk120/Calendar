package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Login {
    @FXML
    Button loginBtn;
    @FXML
    Button registerBtn;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    private static String username = " ";
    private static String password =" ";

    @FXML
    public void handleLoginBtn(){
        try{
            username = usernameField.getText();
            password = passwordField.getText();
            if(isConnectionOK()) {
                Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
                Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
                primaryStage.getScene().setRoot(newRoot);
            }
        }catch(Exception ex){}
    }
    @FXML
    public void handleRegisterBtn(){
        try {
            Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("register.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }catch(Exception ex){}
    }


    public static String giveUsername(){
        return username;
    }
    public static String givePassword(){
        return password;
    }
    private boolean isConnectionOK(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=True", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note"+username.toLowerCase();

            stmt.executeQuery(strSelect);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

}
