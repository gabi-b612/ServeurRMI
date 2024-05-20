package org.localchat.serverrmi.metier;

import org.localchat.serverrmi.dao.Message;
import org.localchat.serverrmi.dao.MessageModel;
import org.localchat.serverrmi.dao.User;
import org.localchat.serverrmi.dao.UserModel;

import java.sql.SQLException;

public class UserMetier {

    public User addUser (User user) throws Exception {
        return new UserModel().insertUser(user);
    }

    public User authenticate(String login, String password) throws Exception {
        return new UserModel().authenticateUser(login,password);
    }

    public void saveMessage(Message message) throws Exception {
        new MessageModel().insertMessage(message);
    }
}
