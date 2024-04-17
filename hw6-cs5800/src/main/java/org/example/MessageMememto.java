package org.example;

public class MessageMememto {
    private Message message;
    // A class that represents a snapshot of a message sent by a user. It should have
    //properties for the message content and timestamp.

    public Message getPreviousMessage(){
        return message;
    }

    public MessageMememto(Message message){
        this.message = message;
    }


}
