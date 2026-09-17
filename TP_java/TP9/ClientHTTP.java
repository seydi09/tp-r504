import java.io.*;
import java.net.*;

public class ClientHTTP {
    public static void main(String[] args) throws Exception {
        // Hôte et port par défaut pour HTTP
        String host = "www.google.com";
        int port = 80;

        System.out.println("Connexion au serveur HTTP " + host + " sur le port " + port + "...");

        // 1. Création du Socket TCP vers le serveur
        Socket socket = new Socket(host, port);

        // 2. Flux de sortie pour envoyer la requête HTTP au serveur
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        // 3. Rédaction et envoi de la requête HTTP
        // Note : HTTP impose de terminer chaque ligne par \r\n et d'ajouter une ligne vide à la fin
        String request = "GET / HTTP/1.1\r\n" +
                         "Host: " + host + "\r\n" +
                         "Connection: close\r\n\r\n";

        writer.print(request);
        writer.flush();

        System.out.println("--- Requête envoyée ---");
        System.out.println(request);

        // 4. Flux d'entrée pour lire la réponse du serveur
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        System.out.println("--- Réponse du serveur ---");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 5. Fermeture des flux et de la socket
        reader.close();
        writer.close();
        socket.close();
    }
}
