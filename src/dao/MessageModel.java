package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MessageModel {
    public void insertMessage(Message message) throws Exception {
        int senderId = message.getSender().getIdUser();
        String content = message.getContent();

        String insertMessage = "INSERT INTO messages (sender_id, content) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertMessage)) {

            stmt.setString(1, String.valueOf(senderId));
            stmt.setString(2, content);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
