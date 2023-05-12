package IO.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logic {
    static int id = 0;

    public static void createUser(User user) {
        try (FileWriter writer = new FileWriter("src/main/java/IO/example/users.txt", true)) {
            getId();
            user.setId(++id);
            writer.write(user.toString());
            System.out.println("Пользователь " + user.getName() + " добавлен");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void getId() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/IO/example/users.txt"))) {
            int maxId = 0;
            while (reader.ready()) {
                String line = reader.readLine();
                String[] split = line.split(",");
                int indexId = split[0].indexOf("=") + 1;
                int tmp = Integer.parseInt(split[0].substring(indexId));

                if (tmp > maxId) {
                    maxId = tmp;
                }
                id = maxId;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean searchUser(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/IO/example/users.txt"))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] split = line.split(",");
                int i = split[1].indexOf("=") + 1;
                String substring = split[1].substring(i);
                if (name.equalsIgnoreCase(substring)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void getUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/IO/example/users.txt"))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean autorisation(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/IO/example/users.txt"))) {
                    while (reader.ready()){
                        String line = reader.readLine();
                        String[] split = line.split(",");

                        int indexName = split[1].indexOf("=") + 1;
                        String name = split[1].substring(indexName).trim();

                        int indexPass = split[3].indexOf("=") + 1;
                        String pass = split[3].substring(indexPass).trim();

                        if(name.equalsIgnoreCase(login) && pass.equalsIgnoreCase(password)){
                            return true;
                        }
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
