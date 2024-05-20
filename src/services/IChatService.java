package org.localchat.serverrmi.services;

import org.localchat.serverrmi.dao.Message;
import org.localchat.serverrmi.dao.User;

import java.rmi.Remote;

public interface IChatService extends Remote {
    public User inscription(User user) throws Exception;

    public User seConnecter(User user) throws Exception;

    public void sendMessage(Message message) throws Exception;
}
