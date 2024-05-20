package org.localchat.serverrmi.services;

import org.localchat.serverrmi.dao.Message;

import java.rmi.Remote;

public interface IClient extends Remote {
    void receiveMessage(Message message) throws Exception;
}
