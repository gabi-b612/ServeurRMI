package services;



import dao.Message;
import dao.User;

import java.rmi.Remote;

public interface IChatService extends Remote {
    public User inscription(User user) throws Exception;

    public User seConnecter(User user) throws Exception;

    public void sendMessage(Message message) throws Exception;
}
