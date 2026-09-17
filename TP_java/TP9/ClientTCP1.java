import java.io.*;
import java.net.*;

public class ClientTCP1 {
    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        int port = 1234;

        System.out.println("Connexion au serveur sur " + addr.getHostName() + ":" + port);

        // Ouverture de la socket vers le serveur
        Socket socket = new Socket(addr, port);

        // Flux de sortie pour envoyer du texte
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = "Hello World TCP";
        out.println(message);
        System.out.println("Message envoye : " + message);

        // Fermeture du flux et de la socket
        out.close();
        socket.close();
    }
}
