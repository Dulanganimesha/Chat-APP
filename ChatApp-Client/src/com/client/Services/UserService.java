package com.client.Services;

import com.client.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static final List<User> userDB = new ArrayList<>();

    public UserService(){}

    public void saveUser(User user) {
        userDB.add(user);
    }

    public List<User> findUsers(String query) {
        List<User> result = new ArrayList<>();

        for (User user : userDB) {

            if (user.getName().contains(query)) {
                result.add(user);
            }
        }
        return result;
    }
}
