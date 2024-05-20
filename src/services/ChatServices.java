package services;



import dao.Message;
import dao.User;
import metier.UserMetier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServices extends UnicastRemoteObject implements IChatService {


    public ChatServices() throws RemoteException {
    }

    public User inscription(User user) throws Exception {
        return new UserMetier().addUser(user);
    }

    public User seConnecter(User user) throws Exception {
        return new UserMetier().authenticate(user.getLogin(), user.getPassword());
    }

    public void sendMessage(Message message) throws Exception {
        new UserMetier().saveMessage(message);
    }
}
