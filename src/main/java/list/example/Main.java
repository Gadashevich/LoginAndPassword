package list.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)   {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Введите команду для работы:  ");
            System.out.println("1. Регистрация");
            System.out.println("2. Авторизация");
            System.out.println("3. Отобразить весь список");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Вы ввели не число");
                scanner.nextLine();
                continue;
            } else {
                int i = scanner.nextInt();
                scanner.nextLine();

                switch (i) {
                    case 1:
                        System.out.println("Введите Имя пользователя");
                        String name = scanner.nextLine();
                        if (!Logic.searchUser(name)) {
                            System.out.println("Пользователь уже существует! Введите другое имя");
                            break;
                        }
                        System.out.println("Введите Возраст пользователя");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Ошибка! Вы ввели не число");
                            scanner.nextLine();
                            continue;
                        } else {
                            int age = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Введите Пароль пользователя");
                            String pass = scanner.nextLine();

                            User user = new User(name, age, pass);
                            Logic.createUser(user);
                        }
                        break;
                    case 2:
                        System.out.println("Введите логин:");
                        String login = scanner.nextLine();

                        System.out.println("Введите пароль:");
                        String password = scanner.nextLine();

                        if (Logic.autorisation(login, password)) System.out.println("Авторизация успешна");
                        else System.out.println("Неуспешная авторизация");
                        break;
                    case 3:
                        System.out.println("Список пользователей:");
                        Logic.getUser();
                        break;
                }
            }
        }
    }
}