package com.server.Controller;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class ServerFormController {

    public AnchorPane root;
    public static ListView lstServer;



    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8585)) {
            out.println("Server has been started...");

            while (true) {
                out.println("Listening for incoming connections...");
                Socket localSocket = serverSocket.accept();

                new Thread(() -> {
                    try (InputStream is = localSocket.getInputStream();
                         InputStreamReader isr = new InputStreamReader(is);
                         BufferedReader br = new BufferedReader(isr)) {

//                        lstServer.setItems((ObservableList) br.lines());


                        br.lines().forEach(out::println);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
