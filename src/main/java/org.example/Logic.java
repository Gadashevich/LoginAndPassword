package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Logic {
    private List<User> users = new ArrayList<>();
    private int id = 0;

    public void createUser(User user) throws SQLException {
        if (!searchUser(user.getName())) {
            System.out.println("Такой пользователь уже существует");
        } else {
            Service.setUser(user);
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
        Collection<User> collection = Service.getUsers();
        for (User user : collection) {
            if (user.getName().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(pass)) {
                return true;
            }
        }
        return false;
    }


}
