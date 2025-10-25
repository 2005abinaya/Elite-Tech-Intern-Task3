package InternshipTask;


import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int[] PORTS = {5000, 8080, 8081, 8888, 9999};
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Multithreaded Chat Server Starting...");
        
        for (int port : PORTS) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server started on port: " + port);
                
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected: " + socket.getInetAddress());
                    
                    ClientHandler clientHandler = new ClientHandler(socket);
                    clients.add(clientHandler);
                    Thread clientThread = new Thread(clientHandler);
                    clientThread.start();
                }
                
            } catch (IOException e) {
                System.out.println("Port " + port + " is busy, trying next...");
            }
        }
    }
    
    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }
    
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println("Client disconnected. Total clients: " + clients.size());
    }
}
