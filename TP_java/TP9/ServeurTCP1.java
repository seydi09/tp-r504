import java.io.*;
import java.net.*;

public class ServeurTCP1
 {
    public static void main(String[] args) throws Exception {
        int port = 1234;
        System.out.println("Attente de connexion sur le port " + port + "...");

        // Creation du socket serveur sur le port 1234
        ServerSocket serverSocket = new ServerSocket(port);

        // Attente bloquante jusqu'a ce qu'un client se connecte
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connecte : " + clientSocket.getInetAddress());

        // Lecture du message envoye par le client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();
        System.out.println("Message recu : " + message);

        // Fermeture des flux et sockets
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
