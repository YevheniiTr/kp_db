package com.example.kp_db.Allert;

import javafx.scene.control.Alert;

public class Allert {
    //public static Alert alert;



    public static Alert getAllert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType,message);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
        return  alert;
    }
}
