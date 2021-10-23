package com.client.Controller;

import com.client.Services.UserService;
import com.client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainFormController {


    public TextField txtClient;
    public Button btnAdd;

    private final UserService userService = new UserService();
    public AnchorPane root;

    public void initialize(){
    }

    public void btnAdd_OnAction(ActionEvent actionEvent) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        User user = new User(
                txtClient.getText()
        );

        if(btnAdd.getText().equals("ENTER")){
            userService.saveUser(user);
            txtClient.clear();
        }

        try ( Socket clientSocket = new Socket("6.tcp.ngrok.io", 19768)){
//            System.out.println("Enter your name");
//            String name = scanner.nextLine();

            String name = user.getName();

            try(OutputStream os = clientSocket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw)){
                while(true) {
                    System.out.println("Enter your message: ");
                    String message = scanner.nextLine();

                    bw.write(name + "> " + message);
                    bw.newLine();
                    bw.flush();

                    if (message.equalsIgnoreCase("exit")) {
                        System.exit(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/MessengerForm.fxml"))));
    }



}
