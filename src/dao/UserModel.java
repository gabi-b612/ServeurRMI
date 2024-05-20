package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public User insertUser(User user) throws Exception {
        if (isLoginExists(user.getLogin())) {
            throw new SQLException("User exist");
        } else {
            String sql = "INSERT INTO users (nameUser, login, password) VALUES (?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getNameUser());
                stmt.setString(2, user.getLogin());
                stmt.setString(3, user.getPassword());
                stmt.executeUpdate();
                return user;
            } catch (SQLException e) {
                throw new RuntimeException("Error to add user",e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isLoginExists(String login) throws Exception {
        String sql = "SELECT COUNT(*) FROM users WHERE login = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public User authenticateUser(String login, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password")
                    );
                }
            }
        }
        return null;
    }
}
