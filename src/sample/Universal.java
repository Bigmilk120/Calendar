package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Universal {
    public static void showPopup(){
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Warning");
        Label label = new Label("Something went wrong...");
        Button button = new Button("Close");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        button.setOnAction(e->
                popup.close()
                );

        Scene scene = new Scene(layout,300,250);
        popup.setScene(scene);
        popup.showAndWait();
    }
}
