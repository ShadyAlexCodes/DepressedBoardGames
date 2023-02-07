package io.github.csc130.utils.GUI.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangeScene {
    public static Stage stage;
    public static Scene scene;
    private static Parent root;

    public void sceneChange(ActionEvent event, String strFXMLFileName) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(strFXMLFileName)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
