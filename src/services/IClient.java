package services;



import dao.Message;

import java.rmi.Remote;

public interface IClient extends Remote {
    void receiveMessage(Message message) throws Exception;
}
