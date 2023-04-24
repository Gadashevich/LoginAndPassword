package org.example;

import java.sql.SQLException;
import java.util.Collection;

public class Logic {

    public void createUser(User user) throws SQLException {
        if (!searchUser(user.getName())) {
            System.out.println("Такой пользователь уже существует");
        } else {
            Service.setUser(user);
        }
    }

    public boolean searchUser(String name) {
        Collection<User> users = Service.getUsers();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
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
