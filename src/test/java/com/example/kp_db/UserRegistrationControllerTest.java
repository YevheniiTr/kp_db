package com.example.kp_db;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class UserRegistrationControllerTest extends ApplicationTest {
    //UserRegistrationController userRegistrationController = new UserRegistrationController();
    @Start
    public void Start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root1));
        stage.show();


    }

    @AfterEach
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    void firstTest(FxRobot robot) {
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#registrationButton");
        assertEquals("Введено неповні данні",getPane().getHeaderText());
    }
    @Test
    void secondTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#userLoginTextField").write("Yevhenii");
        robot.clickOn("#userPasswordTextField").write("TTT");
        robot.clickOn("#userNameTextField").write("Jeka");
        robot.clickOn("#userSurnameTextField").write("Tropanets");
        robot.clickOn("#userPatronymicTextField").write("Ivanovich");
        robot.clickOn("#userPhoneTextField").write("+321312312321");
        robot.clickOn("#userEmailTextField").write("damasska13@gmail.com");
        robot.clickOn("#userAddressTextField").write("Odessa");
        robot.clickOn("#registrationButton");
        assertEquals("Посада не була вибрана", getPane().getHeaderText());
    }
    @Test
    void thirdTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#userLoginTextField").write("Yevhenii");
        robot.clickOn("#userPasswordTextField").write("TTT");
        robot.clickOn("#userNameTextField").write("Jeka");
        robot.clickOn("#role2ManagerRadioButton");
        robot.clickOn("#registrationButton");
        assertEquals("Введено неповні данні",getPane().getHeaderText());

    }
    @Test
    void fourthTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#userLoginTextField").write("Yevhenii");
        robot.clickOn("#userPasswordTextField").write("TTT");
        robot.clickOn("#userNameTextField").write("Jeka");
        robot.clickOn("#userSurnameTextField").write("Tropanets");
        robot.clickOn("#userPatronymicTextField").write("Ivanovich");
        robot.clickOn("#userPhoneTextField").write("+321312312321");
        robot.clickOn("#userEmailTextField").write("damasska13@gmail.com");
        robot.clickOn("#userAddressTextField").write("Odessa");
        robot.clickOn("#role2ManagerRadioButton");
        robot.clickOn("#registrationButton");
        assertEquals("Користувач успішно зареєстрований", getPane().getHeaderText());


    }
    @Test
    void fifthTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#role2ManagerRadioButton");
        robot.clickOn("#registrationButton");
        assertEquals("Введено неповні данні",getPane().getHeaderText());
    }
    @Test
    void sixthTest(FxRobot robot){
        Button registrationButton = robot.lookup("#registrationButton").queryAs(Button.class);
        assertNotNull(registrationButton);
        robot.clickOn("#userSurnameTextField").write("Tropanets");
        robot.clickOn("#userPatronymicTextField").write("Ivanovich");
        robot.clickOn("#userPhoneTextField").write("+321312312321");
        robot.clickOn("#userEmailTextField").write("damasska13@gmail.com");
        robot.clickOn("#userAddressTextField").write("Odessa");
        robot.clickOn("#registrationButton");
        assertEquals("Введено неповні данні",getPane().getHeaderText());
    }
    private DialogPane getPane(){
        Node alert = lookup(".dialog-pane").query();
        DialogPane pane = (DialogPane) alert;
        Assertions.assertThat(pane).isVisible();
        return pane;
    }
}