package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class Service {

    public static void setUser(User user)  throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  users(name,age,password) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("Пользователь добавлен в БД ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Collection<User> getUsers() {
        Collection<User> collection = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name,age,password from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String password = resultSet.getString("password");
                collection.add(new User(id, name, age, password));
            }
        } catch (SQLException e) {
            System.out.println("Произошла ошибка вывода всех пользователей в БД");
        }
        return  collection;
    }


}
