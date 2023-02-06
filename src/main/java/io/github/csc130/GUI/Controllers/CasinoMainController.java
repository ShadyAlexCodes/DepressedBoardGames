package io.github.csc130.GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CasinoMainController implements Initializable {
    @FXML
    private ComboBox gameMenu;
    @FXML
    private Button btnStart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       btnStart.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
                ChangeScene changeScene = new ChangeScene();
                try{
                    //I'm not sure how to make it pass on the selected fxml file when the button changes
                    /* what I've thought of until now is to make a string that will apply what the user selected
                    * from the combobox and then make that the value of the string to pass onto this method
                    * radio buttons are also an option*/

                    changeScene.sceneChange(actionEvent,"na");
                } catch (IOException e){
                    e.printStackTrace();
                }
           }
       });
    }
}
