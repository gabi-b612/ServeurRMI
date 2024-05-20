package metier;


import dao.Message;
import dao.MessageModel;
import dao.User;
import dao.UserModel;

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
