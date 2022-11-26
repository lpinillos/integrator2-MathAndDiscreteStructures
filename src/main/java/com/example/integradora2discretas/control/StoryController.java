package com.example.integradora2discretas.control;

import com.example.integradora2discretas.HelloApplication;
import com.example.integradora2discretas.model.ShowUser;
import com.example.integradora2discretas.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StoryController {

    @FXML
    private Button openButton;

    @FXML
    private TextField userNickname;

    @FXML
    void open(ActionEvent event) {

        if(userNickname.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please write your nickname!");
            alert.showAndWait();
        }else{

            String user = userNickname.getText();
            ShowUser.getInstance().setUser(new User(user));
            HelloApplication.showWindow("StoryTime1.fxml");
            Stage currentStage = (Stage) openButton.getScene().getWindow();
            currentStage.hide();

        }

    }

    @FXML
    private Button continueButton;

    @FXML
    void open2(ActionEvent event) {

        HelloApplication.showWindow("StoryTime2.fxml");
        Stage currentStage = (Stage) continueButton.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton2;

    @FXML
    void open3(ActionEvent event) {

        HelloApplication.showWindow("StoryTime3.fxml");
        Stage currentStage = (Stage) continueButton2.getScene().getWindow();
        currentStage.hide();

    }


    @FXML
    private Button continueButton4;

    @FXML
    void open5(ActionEvent event) {

        HelloApplication.showWindow("StoryTime5.fxml");
        Stage currentStage = (Stage) continueButton4.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton5;

    @FXML
    void open6(ActionEvent event) {

        HelloApplication.showWindow("StoryTime6.fxml");
        Stage currentStage = (Stage) continueButton5.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton6;

    @FXML
    void open7(ActionEvent event) {

        HelloApplication.showWindow("StoryTime7.fxml");
        Stage currentStage = (Stage) continueButton6.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton7;

    @FXML
    void open8(ActionEvent event) {

        HelloApplication.showWindow("StoryTime8.fxml");
        Stage currentStage = (Stage) continueButton7.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton8;

    @FXML
    void open9(ActionEvent event) {

        HelloApplication.showWindow("StoryTime9.fxml");
        Stage currentStage = (Stage) continueButton8.getScene().getWindow();
        currentStage.hide();

    }

    @FXML
    private Button continueButton9;

    @FXML
    void open10(ActionEvent event) {

        HelloApplication.showWindow("instructions.fxml");
        Stage currentStage = (Stage) continueButton9.getScene().getWindow();
        currentStage.hide();

    }
    @FXML
    private Button startButton;

    @FXML
    void start(ActionEvent event) {

        HelloApplication.showWindow("answerScreen.fxml");
        Stage currentStage = (Stage) startButton.getScene().getWindow();
        currentStage.hide();

    }


}

