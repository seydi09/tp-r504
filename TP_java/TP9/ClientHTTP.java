import java.io.*;
import java.net.*;

public class ClientHTTP {
    public static void main(String[] args) throws Exception {
        // 1. Valeur par défaut
        String host = "www.google.com";

        // 2. Si un argument est donné dans le terminal, on l'utilise à la place !
        if (args.length > 0) {
            host = args[0];
        }

        int port = 80;

        System.out.println("Connexion au serveur HTTP " + host + " sur le port " + port + "...");

        // 3. Création du Socket TCP vers le serveur
        Socket socket = new Socket(host, port);

        // 4. Flux de sortie pour envoyer la requête HTTP au serveur
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        // 5. Rédaction et envoi de la requête HTTP
        String request = "GET / HTTP/1.1\r\n" +
                         "Host: " + host + "\r\n" +
                         "Connection: close\r\n\r\n";

        writer.print(request);
        writer.flush();

        System.out.println("--- Requête envoyée ---");
        System.out.println(request);

        // 6. Flux d'entrée pour lire la réponse du serveur
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        System.out.println("--- Réponse du serveur ---");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 7. Fermeture des flux et du socket
        reader.close();
        writer.close();
        socket.close();
    }
}
