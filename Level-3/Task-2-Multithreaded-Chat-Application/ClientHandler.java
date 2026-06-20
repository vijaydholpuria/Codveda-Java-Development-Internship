import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket)
            throws IOException {

        this.socket = socket;

        reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));

        writer = new PrintWriter(
                socket.getOutputStream(),
                true);
    }

    @Override
    public void run() {

        try {

            String message;

            while ((message = reader.readLine())
                    != null) {

                System.out.println(message);

                ChatServer.broadcast(
                        message,
                        this);
            }

        } catch (IOException e) {
            System.out.println(
                    "Client Disconnected");
        }
    }

    public void sendMessage(
            String message) {

        writer.println(message);
    }
}