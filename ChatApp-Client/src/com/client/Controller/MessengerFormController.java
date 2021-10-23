package com.client.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class MessengerFormController {

    public TextField txtClient;

    public void btnAdd_OnAction(ActionEvent actionEvent) {
        String username = this.txtClient.getText();

    }
}
