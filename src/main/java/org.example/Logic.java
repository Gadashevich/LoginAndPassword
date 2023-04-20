package org.example;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    private List<User> users = new ArrayList<>();
    private int id = 0;

    public void createUser(User user) {
        if (!searchUser(user.getName())) {
            System.out.println("Такой пользователь уже существует");
        } else {
            user.setId(++id);
            users.add(user);
            System.out.println("Новый пользователь добавлен");
        }
    }

    private boolean searchUser(String name) {
        for (User users : users) {
            if (users.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }


    public boolean Autorisation(String login, String pass) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(pass)) {
                return true;
            }
        }
        return false;
    }

    public void getUsers(){
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
