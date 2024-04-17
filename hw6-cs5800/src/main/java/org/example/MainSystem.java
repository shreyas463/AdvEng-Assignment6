package org.example;

import java.util.Iterator;
import java.util.List;



public class MainSystem {
    private static final ChatServer chatServer = new ChatServer();

    public static void main(String[] args) {
        //creating 4 users and adding them to system
        User roomfrind1 = new User("Shreyas Chaudhary", chatServer);
        User roomfrind2 = new User("Stanley Hudson", chatServer);
        User roomfrind3 = new User("Bruno Fernandes", chatServer);
        User roomfrind4 = new User("Dwight Shrute", chatServer);
        System.out.println("\n===== User's Created =====");


        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        chatServer.sendMessage(new Message(roomfrind1, List.of(roomfrind2), "Hey, Stanley! What are we having for dinner tonight!"));
        chatServer.sendMessage(new Message(roomfrind4, List.of(roomfrind2), "Hi Stanley, How is your headache now?!"));
        chatServer.sendMessage(new Message(roomfrind2, List.of(roomfrind4), "Hey Dwight, Thanks for asking, but it's only gotten worse. "));
        chatServer.sendMessage(new Message(roomfrind4, List.of(roomfrind1), "Shreyas, Thanks for not asking me what I want to eat. "));
        chatServer.sendMessage(new Message(roomfrind1, List.of(roomfrind3), "Hi Bruno, Will you eat chicken today or are you still not having non-veg?!"));
        chatServer.sendMessage(new Message(roomfrind1, List.of(roomfrind4), "I'm so sorry Dwight, what do you want to eat? "));
        chatServer.sendMessage(new Message(roomfrind3, List.of(roomfrind1), "Hello, Shreyas, I will not be eating non-veg so I cannot eat chicken."));
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("\n===== Demonstrating block function =====");
        roomfrind2.blockerUsers(roomfrind1);
        System.out.println("----------------------------------");
        chatServer.sendMessage(new Message(roomfrind1, List.of(roomfrind2, roomfrind3), "Bruno, I want to go to cheesecake factory!"));
        System.out.println("----------------------------------");
        chatServer.sendMessage(new Message(roomfrind3, List.of(roomfrind1), "Why cheesecake factory, Shreyas?"));
        System.out.println("----------------------------------");
        System.out.println("\n===== Demonstrating unsent function =====");
        System.out.println("Bruno Fernandes unsent last message");
        chatServer.undoLastMessage(roomfrind3);
        System.out.printf("Now, Bruno Fernandes's last message is '%s'\n", roomfrind3.getChatHistory().getLastSentMessages());
        System.out.println("----------------------------------");
        System.out.println("\n===== Demonstrating unsent function =====");
        System.out.println("Stanley Hudson unsent last message:");
        chatServer.undoLastMessage(roomfrind2);
        System.out.println("----------------------------------");

        System.out.println("Iterating over all messages in Bruno Fernandes's chat history:");
        Iterator<Message> allMessagesIterator = roomfrind3.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.printf("------------------------------------\n");
        // Trying iterating over all messages in user1's chat history
        System.out.println("Iterating over all messages in Shreyas Chaudhary's chat history:");
        allMessagesIterator = roomfrind1.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.printf("------------------------------------\n");
        // Trying iterating over all messages in user4's chat history
        System.out.println("Iterating over all messages in Dwight Shrute chat history:");
        allMessagesIterator = roomfrind4.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.printf("------------------------------------\n");
        chatServer.unregisterUser(roomfrind1);
        chatServer.sendMessage(new Message(roomfrind3, List.of(roomfrind1), "Because I want to have the cheesecakes from there."));
    }
}
