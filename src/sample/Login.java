package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Login {
    @FXML
    Button loginBtn;

    @FXML
    public void handleLoginBtn(){
        try{
            Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
            Parent newRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.getScene().setRoot(newRoot);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
