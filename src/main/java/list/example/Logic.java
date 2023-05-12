package list.example;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    public static List<User> userList = new ArrayList<>();

    public static void createUser(User user) {
        if (!searchUser(user.getName())) {
            System.out.println("Такой пользователь уже существует");
        } else {
            userList.add(user);
            System.out.println("Пользователь " + user.getName() + " добавлен");
        }
    }

    public static boolean searchUser(String name) {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }


    public static boolean autorisation(String login, String pass) {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(pass)) {
                return true;
            }
        }
        return false;
    }

    public static void getUser() {
        System.out.println(userList.toString());

    }
}
