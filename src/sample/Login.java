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
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    @FXML
    Button loginBtn;
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
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    @FXML
    public void handleRegisterBtn(){
        
    }


    public static String giveUsername(){
        return username;
    }
    public static String givePassword(){
        return password;
    }
    public boolean isConnectionOK(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note";

            ResultSet rset = stmt.executeQuery(strSelect);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

}
