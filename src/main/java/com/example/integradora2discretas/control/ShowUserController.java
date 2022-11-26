package com.example.integradora2discretas.control;

import com.example.integradora2discretas.HelloApplication;
import com.example.integradora2discretas.model.ShowUser;
import com.example.integradora2discretas.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowUserController implements Initializable {

    @FXML
    private Button continueButton3;
    @FXML
    private Label userLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User currentUser = ShowUser.getInstance().getUser();
        userLabel.setText(currentUser.getNickname());
    }
    @FXML
    void open4(ActionEvent event) {

        HelloApplication.showWindow("StoryTime4.fxml");
        Stage currentStage = (Stage) continueButton3.getScene().getWindow();
        currentStage.hide();

    }

}
