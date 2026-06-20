import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

private static final String HOST =
        "localhost";

private static final int PORT = 1234;

public static void main(String[] args) {

        try (

                Socket socket =
                        new Socket(HOST, PORT);

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));

                PrintWriter writer =
                        new PrintWriter(
                                socket.getOutputStream(),
                                true);

                Scanner sc =
                        new Scanner(System.in)

        ) {

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        Thread receiveThread = new Thread(() -> {

                        try {

                String message;

                            while ((message =
                                    reader.readLine())
                                    != null) {

                                System.out.println(
                                        message);
                            }

                        } catch (IOException e) {
                            System.out.println(
                                    "Disconnected");
                        }
                    });

            receiveThread.start();

            while (true) {

                String message =
                        sc.nextLine();

                writer.println(
                        name + ": "
                                + message);
            }

        } catch (IOException e) {
            System.out.println(
                    e.getMessage());
        }
    }
}