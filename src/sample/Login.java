package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.getScene().setRoot(newRoot);
            username = usernameField.getText();
            password = passwordField.getText();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static String giveUsername(){
        return username;
    }
    public static String givePassword(){
        return password;
    }

}
