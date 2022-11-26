package com.example.integradora2discretas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
Group members:

A00381777 | Belalcazar Bonelo, Santiago Jose
A00381157 | Escobar Vacaflor, Daniel
A00381323 | Pinillos Sanchez, Luis Fernando

 */

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        showWindow("startScreen.fxml");
    }

    public static void showWindow(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    HelloApplication.class.getResource(fxml)
            );
            Parent node = fxmlLoader.load();
            Scene scene = new Scene(node);
            Stage window = new Stage();
            window.setScene(scene);
            window.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}