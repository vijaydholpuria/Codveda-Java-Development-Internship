import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static final int PORT = 1234;
    static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Chat Server Started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New Client Connected");

                ClientHandler client =
                        new ClientHandler(socket);

                clients.add(client);

                new Thread(client).start();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void broadcast(String message,ClientHandler sender) {

        for (ClientHandler client : clients) {

            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }
}