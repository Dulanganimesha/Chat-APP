package com.client.model;

import java.io.Serializable;
import java.util.ArrayList;

public class messageClient implements Serializable {
    private String name;
    private String message;
    private ArrayList<User> users;

    public messageClient() {
    }

    public messageClient(String name, String message, ArrayList<User> users) {
        this.name = name;
        this.message = message;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "messageClient{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", users=" + users +
                '}';
    }
}
