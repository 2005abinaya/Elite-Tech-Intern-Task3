package InternshipTask;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Scanner scanner;
    
    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.startClient();
    }
    
    public void startClient() {
        try {
            // Connect to the server on port 8080
            socket = new Socket("localhost", 8080);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(System.in);
            
            System.out.println("Connected to chat server!");
            
            // Thread for reading messages from server
            Thread readThread = new Thread(this::readMessages);
            readThread.start();
            
            // Thread for writing messages to server
            writeMessages();
            
        } catch (IOException e) {
            System.out.println("Cannot connect to server: " + e.getMessage());
        }
    }
    
    private void readMessages() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println("Disconnected from server");
        }
    }
    
    private void writeMessages() {
        try {
            String message;
            while (true) {
                message = scanner.nextLine();
                writer.println(message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } finally {
            try {
                socket.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
