package com.example.kp_db;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class UserRegistrationControllerTest {
    @Start
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Test
    void regButtonTestFXTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#userLoginTextField");
        robot.write("Jeka");



    }
}