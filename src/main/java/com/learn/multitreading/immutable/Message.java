package com.learn.multitreading.immutable;

public class Message {

    private final String messageText;

    public Message(String message) {
        this.messageText = message;
    }

    public String getMessageText() {
        return messageText;
    }
}