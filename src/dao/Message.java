package org.localchat.serverrmi.dao;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private final User sender;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getNameUser() +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
